/**
 *   Caminho: Portal Estabelecimento Comercial  --> ARV Na Central
 *      Date: 12/12/2019 | Fernando Lisboa - Taking 
 * Last Date: 30/12/2019 | Jessé Dantas - Taking
 */

package br.com.alelo.qa.web.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import br.com.alelo.qa.web.support.PageObject;

public class ContratacaoArvNaCentralPage extends PageObject {

	public ContratacaoArvNaCentralPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	protected String urlInicio = "http://meuestabelecimento-hml.siteteste.inf.br/inicio";
	protected String urlArvCentral = "https://meuestabelecimento-frontend-arv-central-hml.siteteste.inf.br/";

	public String getUrlCentral() {
		return urlArvCentral;
	}

	public String getUrlInicio() {
		return urlInicio;
	}

	@FindBy(id = "inputPassord")
	protected WebElement inputPassword;

	@FindBy(id = "btnLogin")
	protected WebElement btnLogin;

	@FindBy(id = "inputLogin")
	protected WebElement inputLogin;

	@FindBy(id = "comboCnpj")
	protected WebElement comboCnpj;

	@FindBy(id = "btnBuscarEc")
	protected WebElement btnBuscarEc;

	@FindBy(id = "msgCnpjNaoLocalizado")
	protected WebElement msgCnpjNaoLocalizado;

	@FindBy(id = "labelNomeFantasia")
	protected WebElement labelNomeFantasia;

	@FindBy(id = "baixar_arquivo_2012")
	protected WebElement baixar_arquivo_2012;

	@FindBy(id = "campoBuscarEc")
	protected WebElement campoBuscarEc;

	@FindBy(id = "nomeUsuarioLogado")
	protected WebElement nomeUsuarioLogado;

	@FindBy(id = "msgBomDia")
	protected WebElement msgBomDia;

	@FindBy(id = "btnAlterarValor")
	protected WebElement btnAlterarValor;

	@FindBy(id = "flagContratacaoIndividual_3")
	protected WebElement flagContratacaoIndividual_3;

	@FindBy(id = "flagContratacaoIndividual_2")
	protected WebElement flagContratacaoIndividual_2;

	@FindBy(id = "flagContratacaoIndividual")
	protected WebElement flagContratacaoIndividual;

	@FindBy(xpath = "//input[contains(@id,'formBasicCheckbox')]")
	protected WebElement flagContratacaoTodos;

	@FindBy(id = "labelCnpjQuadroPrincipal")
	protected WebElement cnpjContratacao;

	@FindBy(id = "btnAlterarRecorrencia")
	protected WebElement btnAlterarRecorrencia;

	@FindBy(id = "btnGerarProposta")
	protected WebElement btnGerarProposta;

	@FindBy(xpath = "//h3[@class='subHeader'][contains(.,'Área reservada para simulação e contratação de ARV ')]")
	protected WebElement confirmarSair;

	@FindBy(xpath = "//p[@class='aleloLogoutLink'][contains(.,'SAIR')]")
	protected WebElement btnSair;

	@FindBy(id = "cardRecurr-DAILY")
	protected WebElement flagRecebimentoDiario;

	@FindBy(xpath = "//div[@class='content w25 custom textDarkGreen'][contains(.,'DIÁRIAALTERAR')]")
	protected WebElement labelConfirmarRecorrencia;

	@FindBy(id = "cardRecurr-WEEKLY")
	protected WebElement flagRecebimentoSemanal_diaSemana;

	@FindBy(xpath = "//div[@class='content w25 custom textDarkGreen'][contains(.,'SEMANAL - SEGALTERAR')]")
	protected WebElement labelConfirmaRecebimentoSemanal;

	@FindBy(id = "btnAntecipationRecurrVisualize")
	protected WebElement definirRecebimento;

	@FindBy(id = "btnCancelar")
	protected WebElement btnCancelar;

	@FindBy(id = "imageLoader")
	protected WebElement loader;

	@FindBy(id = "labelAlterarRecorrencia")
	protected WebElement labelAlterarRecorrencia;

	@FindBy(id = "formControlsText")
	protected WebElement campoInsertValorParcial;

	@FindBy(id = "btnCalcularValoresDisponiveis")
	protected WebElement btnCalcularValoresDisponiveis;

	@FindBy(id = "btnCancelarCalculoValoresDisponiveis")
	protected WebElement btnCancelarCalculoValoresDisponiveis;

	@FindBy(id = "btnCalcularValoreLiquido")
	protected WebElement btnCalcularValoreLiquido;

	@FindBy(xpath = "//h2[@class='textDarkGreen fontBold alignCenter'][contains(.,'CONFIRMAR DADOS DE CONTRATAÇÃO')]")
	protected WebElement labelConfirmarDadosContratacao;

	@FindBy(xpath = "//input[@type='checkbox'])[4]")
	protected WebElement flagAceite;

	@FindBy(id = "domicilioBancarioContratacaoAgencia")
	protected WebElement domicilioBancarioContratacaoAgencia;

	@FindBy(id = "domicilioBancarioContratacaoBanco")
	protected WebElement domicilioBancarioContratacaoBanco;

	@FindBy(id = "//h1[@class='fontBold'][contains(.,'- NENHUM CNPJ LOCALIZADO -')]")
	protected WebElement labelCnpjInexistente;

	@FindBy(id = "domicilioBancarioContratacao_2")
	protected WebElement domicilioBancarioContratacao_2;

	@FindBy(id = "domicilioBancarioContratacao_1")
	protected WebElement domicilioBancarioContratacao_1;

	@FindBy(id = "cnpjInformado")
	protected WebElement cnpjContratacao2;

	@FindBy(id = "btnCancelarConfirmacaoContratacao")
	protected WebElement domicilioBancarioContratacaoConta;

	@FindBy(id = "nomeRepresentanteLegal")
	protected WebElement nomeRepresentanteLegal;

	@FindBy(id = "enderecoRepresentanteLegal")
	protected WebElement enderecoRepresentanteLegal;

	@FindBy(id = "valorBrutoTable")
	protected WebElement idValorBrutoTable;

	@FindBy(xpath = "//div[@class='content w20'][contains(.,'R$')]")
	protected WebElement idValorBrutoIndividual;

	@FindBy(xpath = "//div[@class='total w15'][contains(.,'R$ ')]")
	protected WebElement idValorBrutoTotal;

	@FindBy(id = "valorLiqTable")
	protected WebElement idValorLiqTable;

	@FindBy(id = "text_conta1_confirmacao")
	protected WebElement domiciliobancarioConfirmacaoConta1;

	@FindBy(id = "text_agencia1_confirmacao")
	protected WebElement domiciliobancarioConfirmacaoAgencia1;

	@FindBy(id = "text_banco1_confirmacao")
	protected WebElement domiciliobancarioConfirmacaoBanco1;

	@FindBy(xpath = "//div[@class='noContent fontBolder textRed'][contains(.,'NÃO HÁ SALDO DISPONÍVEL PARA ANTECIPAÇÃO')]")
	protected WebElement arvNaoDisponivel;

	@FindBy(xpath = "//div[@class='total w15'][contains(.,'R$')]")
	protected WebElement idValorDescontoTotal;

	@FindBy(xpath = "//div[contains(@class,'content w20')])[3]")
	protected WebElement idValorDescontoIndividual;

	@FindBy(id = "valorDescontoTable")
	protected WebElement idValorDescontoTable;

	@FindBy(xpath = "//div[@class='total fontBolder textDarkGreen w15P']")
	protected WebElement idValorLiqTotal;

	@FindBy(xpath = "//div[@class='content w20 custom fontBolder textDarkGreen'][contains(.,'ALTERAR')]")
	protected WebElement idValorLiqIndividual;

	@FindBy(id = "text_conta2_confirmacao")
	protected WebElement domiciliobancarioConfirmacaoConta2;

	@FindBy(id = "text_agencia2_confirmacao")
	protected WebElement domiciliobancarioConfirmacaoAgencia2;

	@FindBy(id = "text_banco2_confirmacao")
	protected WebElement domiciliobancarioConfirmacaoBanco2;

	@FindBy(id = "text_confirmacao_contratacao")
	protected WebElement text_confirmacao_contratacao;

	@FindBy(id = "comboCnpj")
	protected WebElement comboCnpjInexistente;

	@FindBy(xpath = "//h2[@class='textDarkGreen fontBold alignCenter'][contains(.,'ANTECIPE SUAS VENDAS')]")
	protected WebElement labelAntecipeSuasVendas;

	@FindBy(id = "btnAntecipationRecurrVisualize")
	protected WebElement btnAntecipationRecurrVisualize;

	@FindBy(id = "flagContratacaoIndividual_1")
	protected WebElement flagContratacaoIndividual_1;

	@FindBy(id = "btnConsolidationCancel")
	protected WebElement btnConsolidationCancel;

	@FindBy(id = "btnViewValueAntecipation")
	protected WebElement btnViewValueAntecipation;

	@FindBy(id = "btnConfirmarEContratar")
	protected WebElement btnConfirmarEContratar;

	@FindBy(id = "cardRecurr-DISABLED")
	protected WebElement flagRecebimentoDesativado;

}
