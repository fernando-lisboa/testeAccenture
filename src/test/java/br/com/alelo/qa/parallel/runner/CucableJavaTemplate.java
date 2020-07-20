package br.com.alelo.qa.parallel.runner;

import br.com.alelo.integrations.db.*;
import br.com.alelo.integrations.teams.SendTestResultTeams;
import br.com.alelo.integrations.vsts.controllers.RunController;
import br.com.alelo.utils.DriverAnonimo;
import br.com.alelo.utils.PropertiesFile;
import br.com.alelo.utils.ResultsFileStorage;
import br.com.alelo.utils.SimpleCacheManager;
import br.com.alelo.utils.WebdriverAnonimous;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = "classpath:br.com.alelo.qa.features.steps",
        strict = true,
        features = {"target/parallel/features/[CUCABLE:FEATURE].feature"},
        plugin = {"json:target/cluecumber-report/cucumber.json", "junit:target/junit.xml"},
       // plugin = {"json:target/cluecumber-report/[CUCABLE:RUNNER].json", "junit:target/[CUCABLE:RUNNER].xml"},
        tags = {"@Regressivo"}
)
public class CucableJavaTemplate {
    // [CUCABLE:CUSTOM:comment]

    private static RunController newRun = null;
    private static SimpleCacheManager cache = SimpleCacheManager.getInstance();
    private static Date dataHoraInicio = new Date();

    @Autowired
    protected static String titulo;

    @BeforeClass
    public static void setup() throws IOException {

        new DBConnection();
        Connection dbUsadq = DBConnection.getConnectionHml();
        ConnUsadq.setConexao(dbUsadq);

        new DBConnection();
        Connection dbPpoint = DBConnection.getConnectionPpoint();
        ConnPpoint.setConexao(dbPpoint);

        new DBConnection();
        Connection dbBuc = DBConnection.getConnectionBuc();
        ConnBuc.setConexao(dbBuc);

        new DBConnection();
        Connection dbEsmeralda = DBConnection.getConnectionHml_Esmeralda();
        ConnUsodsadq.setConexao(dbEsmeralda);

        // Segundo Browser para execução de testes de simulação com operador de central "HELP"
         new WebdriverAnonimous();
         WebDriver driverAnonimo = WebdriverAnonimous.getDriverAnonimo();
         DriverAnonimo.setDriver(driverAnonimo);
         DriverAnonimo.getDriver().get("https://meuestabelecimento-hml.siteteste.inf.br/");

        PropertiesFile props = new PropertiesFile();
        System.out.println("------------------------------");
        System.out.println("CARREGANDO DADOS DA EXECUÇÃO");
        props.configFile();
        System.out.println("------------------------------");
        String atualizaVsts = props.getValor("atualizaVsts");
        ResultsFileStorage.createTestResultsFile();
        ResultsFileStorage.saveResult("cenario;status;");
        if (atualizaVsts.equals("sim")) {
            PropertiesFile.createTempFile();
            newRun = new RunController("[AUT] " + cache.get("titulo") + " - "
                    + new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(dataHoraInicio));
            try {
                newRun.startRunTests();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        System.out.println(
                "Data e hora de inicio: " + new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(dataHoraInicio));
    }

    /**
     * @throws Exception
     */
    @AfterClass
    public static void teardown() throws Exception {
        Date dataHoraFim = new Date();
        PropertiesFile props = new PropertiesFile();
        System.out.println(
                "Ciclo de testes encerrado as: " + new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(dataHoraFim));
        String diff = new SimpleDateFormat("HH:mm:ss")
                .format(new Date(dataHoraFim.getTime() - dataHoraInicio.getTime()));

        if (props.getValor("teams").equalsIgnoreCase("sim")) {
            String msg = SendTestResultTeams.executionResult(diff, props.getValor("projeto"));
            SendTestResultTeams.sendMessage(msg);
        }

        try {
            String atualizaVsts = props.getValor("atualizaVsts");
            if (atualizaVsts.equals("sim")) {
                newRun.completedRunTests();
            }
            System.out.println(
                    "Ciclo de testes encerrado as: " + new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(dataHoraFim));
            new SimpleDateFormat("HH:mm:ss").format(new Date(dataHoraFim.getTime() - dataHoraInicio.getTime()));

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        ResultsFileStorage.deleteFile();
    }
}