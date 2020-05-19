package br.com.alelo.qa.web.actions;

import br.com.alelo.integrations.db.ConnUsadq;
import br.com.alelo.qa.features.support.JavaScriptUtils;
import br.com.alelo.qa.web.page.AntecipacaoPage;
import br.com.alelo.qa.web.page.PlanosPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.fail;

public class ContratacaodePlanosActions extends AntecipacaoPage {

    public ContratacaodePlanosActions(WebDriver driver) {
        super(driver);
        // TODO Auto-generated constructor stub
    }

    public void ContratarPlano(String Cenario, boolean Contratacao) {
        try {
            Thread.sleep(4000);
            JavaScriptUtils javaS = new JavaScriptUtils(webdriver);
            PlanosPage planosPage = new PlanosPage(webdriver);

            // Abre Modal
            javaS.JavaScriptAction(JavaScriptUtils.Funcao.click, null, null, planosPage.botao_side_kick);

            Cenario = Cenario.replace("Plano de ", "").replace(" dias","");

            switch (Cenario)
            {
                case "02":
                    javaS.JavaScriptAction(JavaScriptUtils.Funcao.click, null, null, webdriver.findElement(By.id("conditionCard-0")));
                    break;
                case "07":
                    javaS.JavaScriptAction(JavaScriptUtils.Funcao.click, null, null, webdriver.findElement(By.id("conditionCard-1")));
                    break;
                case "15":
                    javaS.JavaScriptAction(JavaScriptUtils.Funcao.click, null, null, webdriver.findElement(By.id("conditionCard-2")));
                    break;
            }

            if (!PreencheValorCampoSetSelectButton(null, webdriver.findElement(By.id("antecipation-terms-check")), null, 40))
                fail("Checkbox de confirmação nao recebeu a açao de clique");

            if (Contratacao)
                if (!PreencheValorCampoSetSelectButton(null, webdriver.findElement(By.id("antecipation-accept-button")), null, 40))
                    fail("Botão confirmar nao recebeu a açao de clique");


            Thread.sleep(200);
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }
    
    
}
