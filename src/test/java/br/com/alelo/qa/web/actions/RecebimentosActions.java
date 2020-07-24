package br.com.alelo.qa.web.actions;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import br.com.alelo.qa.features.support.JavaScriptUtils;
import br.com.alelo.qa.web.page.RecebimentosPage;
import br.com.alelo.utils.SimpleCacheManager;
import br.com.alelo.utils.setupTestes.actions.CommonsActions;

public class RecebimentosActions extends RecebimentosPage {

    protected SimpleCacheManager cache = SimpleCacheManager.getInstance();
    CommonsActions comm = new CommonsActions();
    private String valorEsperado;
    int i;

    public RecebimentosActions(WebDriver driver) {
        super(driver);
        // TODO Auto-generated constructor stub
    }



    public void valitarTelaRecebiveis() {
        menuRecebimentos.click();
        waitForElementToBeInvisible(loader);
        validarTextoElemento(labelTelaRecebimentos, textLabelTelaRecebimentos);
    }

    public void valitarTelaConteudoRecebiveis() {
        Assert.assertTrue("valor recebido não está visivel", valorRecebido.isDisplayed());
        Assert.assertTrue("valor a receber não está visível", valorAReceber.isDisplayed());
        Assert.assertTrue("Mes de referencia não está visível", mesReferencia.isDisplayed());
        validarTextoElemento(labelTelaRecebimentos, textLabelTelaRecebimentos);
    }

    public void validarTextoElemento(WebElement elemento, String textoComparacao) {
        try {
            waitForElementToBeInvisible(loader);
            String textoDeComparacao = elemento.getText();
            System.out.println(textoDeComparacao);
            if (textoComparacao.equalsIgnoreCase(textoDeComparacao)) {
                System.out.println("Teste realizado com sucesso.");
            } else {
                System.out.println("Erro. \n" + "Mensagem esperada: " + textoComparacao + "\nMensagem obtida: "
                        + textoDeComparacao);
                Assert.fail();
            }
        } catch (Exception e) {
            Assert.fail();
            System.out.println(e);
        }
    }

    public void avacarMes() {
        waitForElementToBeInvisible(loader);
        String textoMesAtual = mesReferencia.getText();
        waitForElementPageToLoad(avancarMes);
        avancarMes.click();
        waitForElementToBeInvisible(loader);
        String textoMesFuturo = mesReferencia.getText();
        System.out.println(textoMesFuturo);

        if (!textoMesAtual.equals(textoMesFuturo)) {
            System.out.println("Teste realizado com sucesso.");
        } else {
            fail("Problemas ao avançar o mês");
        }
    }

    public void retrocederMes() {
        waitForElementToBeInvisible(loader);
        String textoMesAtual = mesReferencia.getText();
        waitForElementPageToBeClickable(retrocederMes);
        retrocederMes.click();
        waitForElementToBeInvisible(loader);
        System.out.println(textoMesAtual);
        String textoMesPassado = mesReferencia.getText();

        if (!textoMesAtual.equals(textoMesPassado)) {
            System.out.println("Teste realizado com sucesso.");
        } else {
            fail("Problemas ao retroceder o mês");
        }
    }

	public void validarPeriodos(String periodo) {
        if (periodo.equals("mês atual")) {
            valitarTelaConteudoRecebiveis();
        } else if (periodo.equals("mês seguinte")) {
            avacarMes();
        } else {
            retrocederMes();
            Assert.assertTrue("valor recebido não está visivel", valorRecebido.isDisplayed());
        }

    }

    public void validarCampoCabecalho(String produto) {
        //Assert.assertTrue(!valorEsperado.equals("0,00"));
        String attribute = mesExibido.getAttribute("value");
        String dataEsperada = comm.dataRecebiveis(i).toString();
        Assert.assertThat(attribute, is(dataEsperada));
        Assert.assertThat(comboProduto.getText(), is(produto));

    }

    public void localizaDiaComRecebiveisDisponiveis(String produto, String CNPJ, boolean Comprovante) throws InterruptedException, IOException {
        waitForElementToBeInvisible(loader);

        Boolean sair = false;

        int itens = webdriver.findElements(By.className("gtm-link-event")).size() - 7; //7 itens que nao compartilham da tabela agenda
        try {
            for (i = 1; i < itens; i++) {
                try {
                    WebElement item_lista = webdriver.findElement(By.xpath("//html/body/div[1]/main/body/div/div/div/div[2]/div/a[" + i + "]"));
                    String tipo_item = "";
                    List<WebElement> spans = item_lista.findElements(By.tagName("span"));
                    if (!spans.get(3).getText().equals(""))
                        tipo_item = spans.get(2).getText().toUpperCase().trim();
                    System.out.println(tipo_item);
                    if (!tipo_item.equals(""))
                        if (tipo_item.equals("VOU RECEBER") || tipo_item.equals("JÁ RECEBI") || tipo_item.equals("VOU RECEBER HOJE"))
                            if (!spans.get(3).getText().trim().replace("R$ ", "").equals("0,00") && !spans.get(3).getText().trim().replace("R$ ", "").contains("-")) {
                                item_lista.click();
                                selecionarProduto(produto, CNPJ, Comprovante);
                                Thread.sleep(1000);
                               // jsWD.JavaScriptAction(JavaScriptUtils.Funcao.click, null, null, pageCnpj.acceptHelp);
                                menuAgenda.click(); // Agenda
                                waitForElementToBeInvisible(loader);
                            }
                }
                catch (Exception e){
                    String txt = e.getMessage() + "vez:" + i;
                    System.out.println(txt);
                    Thread.sleep(100);
                }
            }
        }catch (Exception e){
            Thread.sleep(200);}
    }

    public void selecionarProduto(String produto, String CNPJ, boolean Comprovante) throws InterruptedException, IOException {
        try {
            waitForElementToBeInvisible(loader);
            switch (produto) {
                case "ALELO REFEICAO":
                    comboProduto.click();
                    produtoRefeicao.click();

                    //Clica em comprovante
                    if (Comprovante) {
                        webdriver.findElement(By.id("buttonComprovantes0")).click();
                        waitForElementToBeInvisible(loader);
                    }
                    break;
                case "ALELO ALIMENTACAO":
                    comboProduto.click();
                    produtoAlimentacao.click();

                    //Clica em comprovante
                    if (Comprovante) {
                        webdriver.findElement(By.id("buttonComprovantes0")).click();
                        waitForElementToBeInvisible(loader);
                    }
                    break;
                case "TODOS":
                    comboProduto.click();
                    produtoTodos.click();

                    //Clica em comprovante
                    if (Comprovante) {
                        webdriver.findElement(By.id("buttonComprovantes0")).click();
                        waitForElementToBeInvisible(loader);
                    }
                    break;
                default:
                    break;
            }
        }
        catch (Exception e)
        {}
    }

    public void validarDetalheTransacoes(String produtoEsperado) throws Throwable {
        Thread.sleep(2000);
        List<String> percorrerDetalhes = percorrerDetalhes(tableDetalhe);
        for (String produto : percorrerDetalhes)
            if (!produtoEsperado.equals("TODOS"))
                Assert.assertThat(produto, is(produtoEsperado));
            else
                Assert.assertTrue("Não trouxe todos os produtos", produto.contains("ALELO"));
    }

    public List<String> percorrerDetalhes(WebElement elemento) throws Throwable {
        Thread.sleep(2000);
        List<String> list_produto = new ArrayList<String>();
        int tabela = tableDetalhe.findElements(By.tagName("tr")).size();
        for (int i = 1; i <= tabela; i++) {
            WebElement elemento_montado = null;
            if (tabela == 1)
                elemento_montado = webdriver
                        .findElement(By.xpath("//*[@id='tableSummaryOperationListDesktop']/tbody/tr/td[3]/span"));
            else
                elemento_montado = webdriver.findElement(
                        By.xpath("//*[@id='tableSummaryOperationListDesktop']/tbody/tr[" + i + "]/td[3]/span"));
            list_produto.add(elemento_montado.getText());
        }
        return list_produto;

    }

    public void btnComprovante() throws Throwable {
        waitForElementPageToBeClickable(btnComprovantes);
        btnComprovantes.click();

    }

    public void downloadBtn() throws Throwable {
        waitForElementPageToBeClickable((WebElement) btnDownloadPdfDown);

        JavascriptExecutor js = (JavascriptExecutor) webdriver;
        js.executeScript("arguments[0].click();", webdriver.findElement(By.id("summary-export-pdf-button-2")));
        Thread.sleep(2000);

    }
}
