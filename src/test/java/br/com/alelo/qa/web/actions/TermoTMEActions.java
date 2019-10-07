package br.com.alelo.qa.web.actions;

import br.com.alelo.qa.web.sections.TermoTMESection;
import org.openqa.selenium.WebDriver;

public class TermoTMEActions extends TermoTMESection {

    public TermoTMEActions(WebDriver driver) {
        super(driver);
    }

    public void aceitarTermo(){
        this.btnAceitar.click();
    }
}
