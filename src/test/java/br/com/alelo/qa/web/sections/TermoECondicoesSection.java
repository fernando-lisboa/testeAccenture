package br.com.alelo.qa.web.sections;

import br.com.alelo.qa.web.support.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TermoECondicoesSection extends PageObject {
    @FindBy(xpath="//span[@id='spanCheckAceiteContrato_200']")
    protected WebElement slcLiEConcordo;

    @FindBy(xpath="//div[@class='modal modal-termo-aceite-contrato jqm-init ui-draggable modal-visible']//input[@id='id_botao_avancar_pedidos']")
    protected WebElement btnAvancar;

    public TermoECondicoesSection(WebDriver driver) {
        super(driver);
    }
}
