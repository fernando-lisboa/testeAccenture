package br.com.desafio.qa;

import java.io.IOException;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.desafio.integrations.teams.SendTestResultTeams;
import br.com.desafio.integrations.vsts.controllers.RunController;
import br.com.desafio.utils.PropertiesFile;
import br.com.desafio.utils.ResultsFileStorage;
import br.com.desafio.utils.SimpleCacheManager;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(strict = false, 
features = {"src/test/resources/features/vechiles/"}, 
plugin = {"json:target/cluecumber-report/cucumber.json", "junit:target/junit.xml"},
		glue = { "classpath:br.com.desafio.qa.features.steps"}, 
		tags = {"@vechile"})

public class CucumberRunnerTest {

    private static RunController newRun = null;
    private static SimpleCacheManager cache = SimpleCacheManager.getInstance();
    private static Date dataHoraInicio = new Date();
    static WebDriver driverAnonimo;
    
    @Autowired
    protected static String titulo;

    @BeforeClass
    public static void setup() throws IOException {


//        //  Segundo Browser para execução de testes de simulação com operador de central "HELP"
//         new WebdriverAnonimous();
//         driverAnonimo = WebdriverAnonimous.getDriverAnonimo();
//         DriverAnonimo.setDriver(driverAnonimo);
//         DriverAnonimo.getDriver().get("https://meuestabelecimento-hml.siteteste.inf.br/");
         
        PropertiesFile props = new PropertiesFile();
        System.out.println("------------------------------");
        System.out.println("CARREGANDO DADOS DA EXECUÇÃO");
        props.configFile();
        System.out.println("------------------------------");
        String atualizaFerramentaCiCd = props.getValor("atualizaVsts");
//        ResultsFileStorage.createTestResultsFile();
//        ResultsFileStorage.saveResult("cenario;status;");
        if (atualizaFerramentaCiCd.equals("sim")) {
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


            System.out.println(
                    "Ciclo de testes encerrado as: " + new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(dataHoraFim));
            new SimpleDateFormat("HH:mm:ss").format(new Date(dataHoraFim.getTime() - dataHoraInicio.getTime()));

    }
}
