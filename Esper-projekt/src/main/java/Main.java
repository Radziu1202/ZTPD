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

        // 2 ZESTAW ZADAN

        //ZADANIE 5
     //   EPDeployment deployment = compileAndDeploy(epRuntime,
   //         "SELECT istream data, kursZamkniecia, spolka, max(kursZamkniecia)-kursZamkniecia AS roznica FROM KursAkcji.win:ext_timed_batch(data.getTime(), 1 day)");
        //
        //ZADANIE 6
      //  EPDeployment deployment = compileAndDeploy(epRuntime,
        //"SELECT istream data, kursZamkniecia, spolka, max(kursZamkniecia) - kursZamkniecia AS roznica " +
          //  "FROM KursAkcji(spolka IN ('IBM', 'Microsoft', 'Honda')).win:ext_timed_batch(data.getTime(), 1 days)");

        //ZADANIE 7 A

    //    EPDeployment deployment = compileAndDeploy(epRuntime,
      //  "SELECT istream data, kursOtwarcia, kursZamkniecia, spolka FROM KursAkcji.win:length(1)" +
        //    "WHERE kursZamkniecia > kursOtwarcia");


        //ZADANIE 7B
//        EPDeployment deployment = compileAndDeploy(epRuntime,
//        "SELECT istream data, kursOtwarcia, kursZamkniecia, spolka FROM KursAkcji(KursAkcji.roznicaKursow(kursOtwarcia, kursZamkniecia) > 0).win:length(1)");


        //ZADANIE 8
   //     EPDeployment deployment = compileAndDeploy(epRuntime,
   //         "SELECT istream data, spolka, kursZamkniecia, max(kursZamkniecia)-kursZamkniecia AS roznica FROM KursAkcji(spolka IN ( 'CocaCola','PepsiCo')).win:ext_timed(data.getTime(), 7 days)");

//ZADANIE 9
      //  EPDeployment deployment = compileAndDeploy(epRuntime,
        //"SELECT istream data, spolka, kursZamkniecia, max(kursZamkniecia) FROM KursAkcji(spolka IN ('CocaCola','PepsiCo')).win:ext_timed_batch(data.getTime(), 1 days)" +
          //  "HAVING max(kursZamkniecia) = kursZamkniecia");

 //ZADANIE 10
    //    EPDeployment deployment = compileAndDeploy(epRuntime,
     //   "SELECT istream max(kursZamkniecia) as maks  FROM KursAkcji.win:ext_timed_batch(data.getTime(), 7 days)");

//ZADANIE 11
   //     EPDeployment deployment = compileAndDeploy(epRuntime,
    //    "SELECT istream pepsi.kursZamkniecia as kursPepsi, cola.kursZamkniecia as kursCocaCola, pepsi.data " +
     //       "FROM KursAkcji(spolka = 'CocaCola').win:length(1) AS cola JOIN " +
    //        "KursAkcji(spolka = 'PepsiCo').win:length(1) as pepsi ON cola.data = pepsi.data WHERE pepsi.kursZamkniecia > cola.kursZamkniecia");

//ZADANIE 12
  //      EPDeployment deployment = compileAndDeploy(epRuntime,
    //    "SELECT istream cola.spolka, cola.data, cola.kursZamkniecia AS kursBiezacy, cola.kursZamkniecia - pepsi.kursZamkniecia AS roznica " +
      //      "FROM KursAkcji(spolka in ('PepsiCo', 'CocaCola')).win:length(1) as cola join KursAkcji(spolka in ( 'CocaCola','PepsiCo')).std:firstunique(spolka) AS pepsi " +
        //    "ON cola.spolka = pepsi.spolka");

//ZADANIE 13
 //       EPDeployment deployment = compileAndDeploy(epRuntime,
   //     "SELECT istream sp1.spolka, sp1.data, sp1.kursZamkniecia AS kursBiezacy, sp1.kursZamkniecia - sp2.kursZamkniecia AS roznica " +
     //       "FROM KursAkcji.win:length(1) as sp1 join  KursAkcji.std:firstunique(spolka) AS sp2 " +
       //     "on sp1.spolka = sp2.spolka where sp1.kursZamkniecia > sp2.kursZamkniecia");

//ZADANIE 14
//        EPDeployment deployment = compileAndDeploy(epRuntime,
  //      "SELECT istream sp1.data, sp2.data, sp1.spolka, sp1.kursOtwarcia, sp2.kursOtwarcia " +
    //        "FROM KursAkcji.win:ext_timed(data.getTime(), 7 days) AS sp1 join KursAkcji.win:ext_timed(data.getTime(), 7 days) AS sp2 " +
      //      "ON sp1.spolka = sp2.spolka WHERE sp1.kursOtwarcia - sp2.kursOtwarcia > 3");

//ZADANIE 15
  //      EPDeployment deployment = compileAndDeploy(epRuntime,
   //     "SELECT istream data, spolka, obrot " +
   //         "FROM  KursAkcji(market = 'NYSE').win:ext_timed_batch(data.getTime(), 7 days) ORDER BY obrot DESC LIMIT 3");

//ZADANIE 16
 //       EPDeployment deployment = compileAndDeploy(epRuntime,
 //             "SELECT istream data, spolka, obrot from KursAkcji(market = 'NYSE').win:ext_timed_batch(data.getTime(), 7 days) " +
    //          " ORDER BY obrot DESC LIMIT 1 OFFSET 2");
















        //1 ZESTAW ZADAN
//23
    //    EPDeployment deployment = compileAndDeploy(epRuntime,
      //          "SELECT irstream spolka as X, kursOtwarcia as Y " +
        //                "FROM KursAkcji.win:length(3) ");


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
