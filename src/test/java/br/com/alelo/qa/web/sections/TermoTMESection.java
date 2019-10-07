package br.com.alelo.qa.web.sections;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import br.com.alelo.qa.web.support.PageObject;

public class TermoTMESection extends PageObject {

    @FindBy(xpath="//div[@class='modal modal-aceite-mte jqm-init ui-draggable modal-visible']//input[@class='botao botao--verde']")
    protected  WebElement btnAceitar;


    public TermoTMESection(WebDriver driver) {
        super(driver);
    }
}
