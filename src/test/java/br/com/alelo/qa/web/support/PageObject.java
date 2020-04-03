package br.com.alelo.qa.web.support;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.concurrent.TimeUnit;

import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;

public class PageObject {

    protected WebDriver webdriver;

    @Autowired
    private int maxTimeWaitLoadPage = 300;

    private WebDriverWait wait;

    protected WebElement encontraElementoPorParteDoTexto(String partialText) {
        return webdriver.findElement(By.xpath("//*[contains(text(),'" + partialText + "')]"));
    }

    protected WebElement encontraElementoPorParteDoId(String partialId) {
        return webdriver.findElement(By.xpath("//*[contains(@id,'" + partialId + "')]"));
    }

    public PageObject(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.webdriver = driver;
        this.webdriver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        this.webdriver.manage().window().maximize();

    }

    public void waitForElementToBeInvisible(WebElement element) {
        wait = new WebDriverWait(webdriver, maxTimeWaitLoadPage);
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public void validarUrlAtual(String url) {
        assertEquals(url, webdriver.getCurrentUrl());
    }

    public void validarModalErro(String textoEsperado, String textoCapturado) {
        assertEquals(textoEsperado, textoCapturado);
    }

    public void validarUrlPedaco(String urlPartial) {
        assertEquals(urlPartial, webdriver.getCurrentUrl().contains(urlPartial));
    }

    public void waitForElementPageToLoad(WebElement element) {
        wait = new WebDriverWait(webdriver, maxTimeWaitLoadPage);
        wait.until(ExpectedConditions.visibilityOfAllElements(element));
    }

    public void waitForElementPageToBeClickable(WebElement element) {
        wait = new WebDriverWait(webdriver, maxTimeWaitLoadPage);
        wait.until(ExpectedConditions.visibilityOfAllElements(element));

    }

    public void waitforFormToBeLoad(List<WebElement> elements) {
        wait = new WebDriverWait(webdriver, maxTimeWaitLoadPage);
        wait.until(ExpectedConditions.visibilityOfAllElements(elements));
    }

    public void arrastar(WebElement element, WebElement element2) {
        Actions action = new Actions(webdriver);
        try {
            action.dragAndDrop(element, element2);
            action.perform();
        } catch (Exception e) {
            String valorError = "Não é um elemento de arraste";
            System.out.println(valorError);
            throw new java.lang.Error(valorError);
        }
    }

    public Boolean VerificaObjetoExistente(By Type, WebElement elemento, Boolean Obrigatory, int tentativas) throws InterruptedException {
        for (int i = 0; i < tentativas; i++) {
            try {
                if (elemento != null)
                    if (elemento.isDisplayed() && elemento.isEnabled())
                        return true;

                if (webdriver.findElement(Type).isDisplayed() && webdriver.findElement(Type).isEnabled())
                    return true;

                if (Obrigatory == false)
                    return false;
            } catch (Exception e) {
                Thread.sleep(1000);
            }
        }
        return false;
    }

    public Boolean PreencheValorCampoSetSelectButton(By Type, WebElement element_view, String valor, int tentativas) throws InterruptedException {
        for (int i = 0; i < tentativas; i++)
            try {
                if (VerificaObjetoExistente(Type, element_view, true, 1)) {
                    String htmltag = null;
                    String type_element = null;
                    WebElement elementjava = null;

                    if (Type != null) {
                        htmltag = webdriver.findElement(Type).getTagName();
                        type_element = webdriver.findElement(Type).getAttribute("type");
                        elementjava = webdriver.findElement(Type);
                    } else if (element_view != null) {
                        htmltag = element_view.getTagName();
                        type_element = element_view.getAttribute("type");
                        elementjava = element_view;
                    }

                    JavascriptExecutor javaclick = (JavascriptExecutor) webdriver;

                    if (type_element != null && type_element.equals("submit"))
                        htmltag = "SUBMIT";

                    if (type_element == null && htmltag.equals("div"))
                        htmltag = "BUTTON";

                    if (htmltag.toUpperCase().trim().equals("INPUT") && type_element.toUpperCase().trim().equals("IMAGE"))
                        htmltag = "BUTTON";

                    if (htmltag.toUpperCase().trim().equals("INPUT") && type_element.toUpperCase().trim().equals("BUTTON"))
                        htmltag = "BUTTON";

                    if (htmltag.toUpperCase().trim().equals("INPUT") && type_element.toUpperCase().trim().equals("CHECKBOX"))
                        htmltag = "BUTTON";

                    if (htmltag.toUpperCase().trim().equals("INPUT") && type_element.toUpperCase().trim().equals("RADIO"))
                        htmltag = "BUTTON";

                    if (htmltag.toUpperCase().trim().equals("H3"))
                        htmltag = "BUTTON";

                    if (htmltag.toUpperCase().trim().equals("SPAN"))
                        htmltag = "BUTTON";
                    
                    if (htmltag.toUpperCase().trim().equals("B"))
                        htmltag = "BUTTON";

                    switch (htmltag.toUpperCase().trim()) {
                        case "INPUT":
                            if (Type != null) {
                                for (int x = 0; x <= 100; x++) {
                                    try {
                                        webdriver.findElement(Type).clear();
                                        if (!webdriver.findElement(Type).getAttribute("value").equals("")) {
                                            webdriver.findElement(Type).sendKeys(Keys.ARROW_RIGHT);
                                            webdriver.findElement(Type).sendKeys(Keys.SPACE);
                                        } else {
                                            break;
                                        }
                                    } catch (Exception e) {
                                        break;
                                    }
                                }
                                if (valor != null)
                                    webdriver.findElement(Type).sendKeys(valor);
                                else
                                    return true;
                            } else if (element_view != null) {
                                for (int x = 0; x <= 100; x++) {
                                    try {
                                        webdriver.findElement(Type).clear();
                                        if (!element_view.getAttribute("value").equals("")) {
                                            element_view.findElement(Type).sendKeys(Keys.ARROW_RIGHT);
                                            element_view.findElement(Type).sendKeys(Keys.SPACE);
                                        } else {
                                            break;
                                        }
                                    } catch (Exception e) {
                                        break;
                                    }
                                }

                                if (valor != null)
                                    element_view.sendKeys(valor);
                                else
                                    return true;
                            }
                            return true;

                        case "SUBMIT":
                            javaclick.executeScript("arguments[0].click();", elementjava);
                            return true;

                        case "TEXTAREA":

                            if (Type != null) {
                                for (int x = 0; x <= 100; x++) {
                                    if (!webdriver.findElement(Type).getAttribute("value").equals("")) {
                                        webdriver.findElement(Type).sendKeys(Keys.ARROW_RIGHT);
                                        webdriver.findElement(Type).sendKeys(Keys.SPACE);
                                    } else {
                                        break;
                                    }
                                }
                                if (valor != null)
                                    webdriver.findElement(Type).sendKeys(valor);
                                else
                                    return true;
                            } else if (element_view != null) {
                                for (int x = 0; x <= 100; x++) {
                                    if (!element_view.getAttribute("value").equals("")) {
                                        element_view.findElement(Type).sendKeys(Keys.ARROW_RIGHT);
                                        element_view.findElement(Type).sendKeys(Keys.SPACE);
                                    } else
                                        break;

                                }

                                if (valor != null)
                                    element_view.sendKeys(valor);
                                else
                                    return true;
                            }

                            if (valor != null)
                                webdriver.findElement(Type).sendKeys(valor);
                            return true;

                        case "SELECT":
                            if (Type != null) {
                                Select selectElement = new Select(webdriver.findElement(Type));
                                if (valor != null)
                                    selectElement.selectByVisibleText(valor);
                                else
                                    return true;
                            } else if (element_view != null) {
                                Select selectElement = new Select(element_view);
                                if (valor != null)
                                    selectElement.selectByVisibleText(valor);
                                else
                                    return true;
                            }
                            return true;

                        case "BUTTON":
                            javaclick.executeScript("arguments[0].click();", elementjava);
                            return true;

                        case "A":
                            javaclick.executeScript("arguments[0].click();", elementjava);
                            return true;

                        default:
                            return false;
                    }
                }
            } catch (Exception e) {
                Thread.sleep(500);
            }
        return false;
    }


    @FindBy(id = "loaderId")
    protected WebElement loader;

}