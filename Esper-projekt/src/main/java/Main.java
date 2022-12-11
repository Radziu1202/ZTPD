import java.io.IOException;
import com.espertech.esper.common.client.configuration.Configuration;
import com.espertech.esper.runtime.client.EPRuntime;
import com.espertech.esper.runtime.client.EPRuntimeProvider;
import com.espertech.esper.common.client.EPCompiled;
import com.espertech.esper.common.client.configuration.Configuration;
import com.espertech.esper.compiler.client.CompilerArguments;
import com.espertech.esper.compiler.client.EPCompileException;
import com.espertech.esper.compiler.client.EPCompilerProvider;
import com.espertech.esper.runtime.client.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Configuration configuration = new Configuration();
        configuration.getCommon().addEventType(KursAkcji.class);
        EPRuntime epRuntime = EPRuntimeProvider.getDefaultRuntime(configuration);
//23
        EPDeployment deployment = compileAndDeploy(epRuntime,
                "SELECT irstream spolka as X, kursOtwarcia as Y " +
                        "FROM KursAkcji.win:length(3) ");


//24
//        EPDeployment deployment = compileAndDeploy(epRuntime,
//                "SELECT irstream spolka as X, kursOtwarcia as Y " +
//                    "FROM KursAkcji.win:length(3) " +
//                    "WHERE spolka = 'Oracle'");

//25
//        EPDeployment deployment = compileAndDeploy(epRuntime,
//            "SELECT IRSTREAM data, kursOtwarcia, spolka " +
//                "FROM KursAkcji.win:length(3) " +
//                "WHERE spolka = 'Oracle'");


//26
//        EPDeployment deployment = compileAndDeploy(epRuntime,
//            "SELECT IRSTREAM data, kursOtwarcia, spolka " +
//                "FROM KursAkcji(spolka='Oracle').win:length(3) ");


//27
// Wyłaczenie generowania wynikowego strumienia zdarzeń usuwanych  - nie będzie RSTREAM
//        EPDeployment deployment = compileAndDeploy(epRuntime,
//        "SELECT ISTREAM data, kursOtwarcia, spolka " +
//            "FROM KursAkcji(spolka='Oracle').win:length(3) ");

//28
//        EPDeployment deployment = compileAndDeploy(epRuntime,
//        "SELECT ISTREAM MAX(kursOtwarcia) " +
//            "FROM KursAkcji(spolka='Oracle').win:length(5) ");

//29
//        EPDeployment deployment = compileAndDeploy(epRuntime,
//        "SELECT ISTREAM kursOtwarcia - MAX(kursOtwarcia) AS roznica " +
//            "FROM KursAkcji(spolka='Oracle').win:length(5) ");
// Funkcja max nie bierze największej wartości ze wszystkich danych tylko największą wartość z okna .

//30
//      EPDeployment deployment = compileAndDeploy(epRuntime,
//            "SELECT ISTREAM data, spolka, kursOtwarcia - MIN(kursOtwarcia) AS roznica " +
//                  "FROM KursAkcji(spolka='Oracle').win:length(2) " +
//                "HAVING kursOtwarcia > MIN(kursOtwarcia)");

// Odp: Uzyskany wynik jest poprawny, uzyskane zostały tylko wzrost.

        ProstyListener prostyListener = new ProstyListener();
        for (EPStatement statement : deployment.getStatements()) {
            statement.addListener(prostyListener);
        }
        InputStream inputStream = new InputStream();
        inputStream.generuj(epRuntime.getEventService());
    }

    public static EPDeployment compileAndDeploy(EPRuntime epRuntime, String epl) {
        EPDeploymentService deploymentService = epRuntime.getDeploymentService();
        CompilerArguments args = new CompilerArguments(epRuntime.getConfigurationDeepCopy());
        EPDeployment deployment;
        try {
            EPCompiled epCompiled = EPCompilerProvider.getCompiler().compile(epl, args);
            deployment = deploymentService.deploy(epCompiled);
        } catch (EPCompileException e) {
            throw new RuntimeException(e);
        } catch (EPDeployException e) {
            throw new RuntimeException(e);
        }
        return deployment;
    }
}
