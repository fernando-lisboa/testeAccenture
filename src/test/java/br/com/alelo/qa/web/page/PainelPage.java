/**
 *
 */
package br.com.alelo.qa.web.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import br.com.alelo.qa.web.support.PageObject;

/**
 * @author Fernando Lisboa
 *
 */
public class PainelPage extends PageObject {

    public PainelPage(WebDriver driver) {
        super(driver);
        // TODO Auto-generated constructor stub
    }

    protected String urlInicio = "http://meuestabelecimento-hml.siteteste.inf.br/inicio";
    protected String urlExtrato = "http://meuestabelecimento-hml.siteteste.inf.br/extrato";

    public String getUrlInicio() {
        return urlInicio;
    }

    public String getUrlExtrato() {
        return urlExtrato;
    }

    @FindBy(id = "imageLoader")
    protected WebElement aguardar_gif;

    @FindBy(id = "cnpj")
    protected WebElement opcao_select;

    @FindBy(xpath = "//b[contains(.,'• 37.491.504/0001-61 - 1010745147')]")
    protected WebElement opcao_ec1;

    @FindBy(xpath = "//span[@class='space10-left'][contains(.,'@ 43.023.070/0010-69 - 2000189185')]")
    protected WebElement opcao_ec2;

    @FindBy(xpath = "//b[contains(.,'• 28.339.982/0001-60 - 2000496258')]")
    protected WebElement opcao_ec3;

    @FindBy(xpath = "//b[contains(.,'• 12.259.140/0001-68 - 1015000255')]")
    protected WebElement opcao_ec4;

    @FindBy(xpath = "//b[contains(.,'• 37.491.504/0001-61 - 1010745147')]")
    protected WebElement desbloq_1;

    @FindBy(xpath = "//b[contains(.,'• 41.707.658/0001-15 - 1010745139')]")
    protected WebElement desbloq_2;

    @FindBy(xpath = "//b[contains(.,'• 82.143.278/0001-82 - 1012770645')]")
    protected WebElement testeGratis;

    @FindBy(xpath = "//b[contains(.,'• 12.259.140/0001-68 - 1015000255')]")
    protected WebElement opcao_ec_plano;

    @FindBy(xpath = "//*[@id=\"cnpj\"]/../div/div/b[contains(text(), \"67.140.569/0001-23 - 2000494743\")]")
    protected WebElement opcao_ec_plano_saldo;

    @FindBy(xpath = "//b[contains(.,'• 28.339.982/0001-60 - 2000496258')]")
    protected WebElement opcao_ec_arv;

    @FindBy(xpath = "//b[contains(.,'• 12.259.140/0001-68 - 1015000255')]")
    protected WebElement ofertaPainel;

    @FindBy(xpath = "//*[@id=\"cnpj\"]/../div/div/b[contains(text(), \"00.304.562/0009-86 - 1015000654\")]")
    protected WebElement opcao_ec_sp_ss;

    @FindBy(xpath = "//*[@id=\"menuContentContainer\"]/div/div/div/div[2]/div/img")
    protected WebElement banner_superior;

    @FindBy(xpath = "//*[@id=\"footerAleloLogo\"]")
    protected WebElement banner_inferior;

    @FindBy(xpath = "//button[@type='button'][contains(.,'DIRF')]")
    protected WebElement btnDirf;

    @FindBy(className = "fontBold textDarkGreen3")
    protected WebElement linkDetalhes;

    @FindBy(id = "advertisingDashboardSideKick")
    protected WebElement sidekickPainel;
    public String textSidekickPainel = "30 dias grátis";

    @FindBy(id = "btnAtivarAgoraSidekick")
    protected WebElement btnSidekickPainel;

    @FindBy(id = "textNormalSidekick")
    protected WebElement sidekick_Plano;
    public String textSidekickPlano = "Quer ter o seu caixa sempre em dia?";

    @FindBy(id = "Null")
    protected WebElement estabelecimento_comparar;
    public String estabelecimentoComparar = "Quer ter o seu caixa sempre em dia?";

    @FindBy(id = "textNormalSidekick")
    protected WebElement sidekick_arv;
    public String textSidekickArv = "Antecipe suas vendas";

    @FindBy(className = "fontBold")
    protected WebElement vouReceber;
    public String aReceber = "VER DETALHES";

    @FindBy(className = "textGray12")
    protected WebElement jaRecebi;
    public String recebido = "Já recebi esse mês";

    @FindBy(id = "freePanel")
    protected WebElement graficoFaturamento;
    public String resumoUltmosTrintaDias = "RESUMO DOS ÚLTIMOS 30 DIAS";

    @FindBy(id = "monthlyPanel")
    protected WebElement graficoMensal;
    public String munuMensal = "MENSAL";

    @FindBy(id = "transactionPanel")
    protected WebElement graficoSemana;
    public String munuSemanal = "SEMANAL";

    @FindBy(id = "painelDiario")
    protected WebElement graficodiario;
    public String munuDiario = "DIÁRIO";

    @FindBy(id = "iconProfileId")
    protected WebElement iconoPerfil;

    @FindBy(id = "navbarDesktopSair")
    protected WebElement btnSair;

    @FindBy(xpath = "//a[@class='nav-link'][contains(.,'Painel Meu Negócio')]")
    protected WebElement linkPainelMeuNegocio;

    @FindBy(id = "inputFile")
    protected WebElement inputFileBlock;

    @FindBy(id = "menuDocumentos")
    protected WebElement menuDocumentos;

    @FindBy(id = "btnUpload")
    protected WebElement btnFazerUpload;

    @FindBy(xpath = "//button[@type='button'][contains(.,'FECHAR')]")
    protected WebElement btnFechar;

    @FindBy(xpath = "//div[@class='fontNormal title'][contains(.,'Sucesso!')]")
    protected WebElement sucesso;
    public String sucessoText = "SUCESSO!";

    @FindBy(xpath = "//h5[@class='canceled'][contains(.,'Suspenso')]")
    protected WebElement statusContratoSuspenso;
    public String statusContratoText = "Suspenso";

    @FindBy(id = "btnContratarAgora")
    protected WebElement btnContratarAgora;

    @FindBy(id = "pannelBannerConfirmationButton")
    protected WebElement btnExperimentoGratisPainel;

    @FindBy(xpath = "//label[contains(@for,'flagTermoDeAceite')]")
    protected WebElement flagTermoDeAceite;

    @FindBy(id = "btnAtivarGratis")
    protected WebElement btnAtivarGratis;

    @FindBy(id = "labelMsgSucesso")
    protected WebElement labelMsgSucesso;
    public String textMsgSucesso = "Parabéns! A partir de agora, você conta com o Alelo Painel Meu Negócio para turbinar sua gestão";

    @FindBy(id = "panelTitleId")
    protected WebElement panelTitleId;
    public String textPanelTitleId = "Painel Meu Negócio";

    @FindBy(xpath = "//button[@type='button'][contains(.,'VOLTAR PARA O PAINEL')]")
    protected WebElement btnVoltarPainel;

    @FindBy(xpath = "//h5[@class='freeTestPill'][contains(.,'TESTE GRÁTIS')]")
    protected WebElement labelTesteGratis;

    @FindBy(xpath = "//h5[@class='hired'][contains(.,'Contratado')]")
    protected WebElement Contratado;

    @FindBy(xpath = "//span[@class='canceled'][contains(.,'dias restantes')]")
    protected WebElement contratadoGratis;

    @FindBy(xpath = "//h5[@class='canceled'][contains(.,'Cancelado')]")
    protected WebElement statusCancelado;

    @FindBy(id = "statusText")
    protected WebElement statusText;
    public String textConfirmacao = "30 dias restantes do Alelo Painel Meu Negócio";

    @FindBy(xpath = "//h5[contains(.,'Data da Contratação:')]")
    protected WebElement dtContratacao;
    public String textdtContratacao = "Data da Contratação:";

    @FindBy(xpath = "//h5[contains(.,'Primeira Mensalidade:')]")
    protected WebElement primeiraMensalidade;
    public String textprimeiraMensalidade = "Primeira Mensalidade:";

    @FindBy(xpath = "//h5[@class='cardLabel undefined'][contains(.,'Última Mensalidade:')]")
    protected WebElement ultimaMensalidade;
    public String textUltimaMensalidade = "Última Mensalidade:";

    @FindBy(xpath = "//button[@type='button'][contains(.,'experimente 30 dias grátis')]")
    protected WebElement btnExperimenteGratis;

    @FindBy(id = "btnCancelar")
    protected WebElement btnCancelar;

    @FindBy(xpath = "//h5[@class='singleText'][contains(.,'82.143.278/0001-82')]")
    protected WebElement cnpjContratado;

    @FindBy(className = "btnFormRed btn btn-lg btn-default")
    protected WebElement btnConfirmarCancelar;

    @FindBy(id = "valorContratado")
    protected WebElement valorContratado;
    public String textvalorContratado = "R$ 19,90";
    
    @FindBy(id = "menuExtrato")
    protected WebElement menuExtrato;
    
    @FindBy(xpath = "//div[@id='simulationAlert']/div[2]")
    protected WebElement msgSimulacao;
    public String msgSimulacaoEsperada = "IMPORTANTE: A simulação não efetivará a contratação do produto.";
    
    @FindBy(xpath = "//div[@id='simulationAlert']/div[2]")
    protected WebElement msgSimulacaoCancelamento;
    public String msgSimulacaoCancelamentoEsperada = "IMPORTANTE: A simulação não efetivará o cancelamento do produto.";

}
