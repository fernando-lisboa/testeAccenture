package br.com.alelo.qa.features.support;

import br.com.alelo.qa.web.support.PageObject;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptUtils extends PageObject {
    public JavaScriptUtils(WebDriver driver) {
            super(driver);
        }

    public enum Funcao{click, deletarElement, setValue,  habilitarElemento, abrirNovaGuia,fecharGuia,atualizarPagina}
    public enum BuscatipoJava{getElementsByClassName, getElementById, getElementsByName, getElementsByTagName, getElementsByTagNameNS}

    public boolean JavaScriptAction(Funcao funcao, BuscatipoJava buscaTipoJava, String descricaoElemento, WebElement webElement){
        JavascriptExecutor js = (JavascriptExecutor) webdriver;
        try{
            switch (funcao) {
                case click:
                    js.executeScript("arguments[0].click();", webElement);
                    break;
                case deletarElement:
                    js.executeScript("var element = document."+ buscaTipoJava +"('"+ descricaoElemento +"')[0].remove();");
                    break;
                case setValue:
                    js.executeScript("arguments[0].value='"+ descricaoElemento +"';", webElement);
                case habilitarElemento:
                    js.executeScript("return document."+ buscaTipoJava +"('"+ descricaoElemento +"').removeAttribute(\"disabled\");");
                    break;
                case abrirNovaGuia:
                    js.executeScript("window.open()");
                    break;
                case fecharGuia:
                    js.executeScript("window.close()");
                    break;
                case atualizarPagina:
                	js.executeScript("location.reload()");
                	break;
            }
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
