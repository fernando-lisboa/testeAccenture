package br.com.alelo.qa.web.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import br.com.alelo.qa.web.support.PageObject;

public class CredenciamentoPage extends PageObject {

	@FindBy(xpath = "//button[text() = \"PREENCHER FORMULÁRIO\"]")
	protected WebElement btnPreencherFormulario;

	@FindBy(id = "password")
	protected WebElement senhaISAM;

	@FindBy(xpath = "//input[@value = \"Login\"]")
	protected WebElement botao_Login;

	@FindBy(xpath = "(//td/a[text() = \"Remover\"])[1]")
	protected WebElement removerSessao;

	@FindBy(id = "nameProprietary0")
	protected WebElement campoNomeCompleto;

	@FindBy(id = "complementCompany")
	protected WebElement campoComplemento;

	@FindBy(id = "postalCodeCompany")
	protected WebElement campoCep;

	@FindBy(id = "emailCompany")
	protected WebElement campoEmailCredenciamento;

	@FindBy(id = "telephoneCompany")
	protected WebElement campoTelefone;

	@FindBy(id = "dddCompany")
	protected WebElement campoDDD;

	@FindBy(id = "cnaeNumber")
	protected WebElement campoCnae;

	@FindBy(id = "tradingName")
	protected WebElement campoNomeFantasia;

	@FindBy(id = "cnpjCompany")
	protected WebElement campoCnpjCredenciamento;

	@FindBy(id = "companyName")
	protected WebElement campoRazaoSocial;

	@FindBy(id = "cpfProprietary1")
	protected WebElement campo_cpf_segundo_proprietario;

	@FindBy(id = "nameProprietary1")
	protected WebElement campo_nome_completo_segundo_proprietario;

	@FindBy(id = "telephoneProprietary0")
	protected WebElement campo_telefone_proprietario;

	@FindBy(id = "dddProprietary0")
	protected WebElement campo_ddd_proprietario;

	@FindBy(id = "birthDateProprietary0")
	protected WebElement campo_data_nascimento;

	@FindBy(id = "cpfProprietary0")
	protected WebElement campo_cpf_credenciamento;

	@FindBy(id = "numberCompany")
	protected WebElement campo_numero;

	@FindBy(id = "birthDateProprietary2")
	protected WebElement campo_data_nascimento_terceiro_proprietario;

	@FindBy(id = "cpfProprietary2")
	protected WebElement campo_cpf_terceiro_proprietario;

	@FindBy(id = "nameProprietary2")
	protected WebElement campo_nome_completo_terceiro_proprietario;

	@FindBy(id = "telephoneProprietary1")
	protected WebElement campo_telefone_segundo_proprietario;

	@FindBy(id = "dddProprietary1")
	protected WebElement campo_ddd_segundo_proprietario;

	@FindBy(id = "birthDateProprietary1")
	protected WebElement campo_data_nascimento_segundo_proprietario;

	@FindBy(id = "numberMail")
	protected WebElement campo_numero_correspondencia;

	@FindBy(id = "cnaeNumber")
	protected WebElement campo_cnae_sem_pat;

	@FindBy(id = "seatsCount")
	protected WebElement campo_quantidade_assentos;

	@FindBy(id = "tablesCount")
	protected WebElement campo_quantidade_mesas;

	@FindBy(id = "areaCount")
	protected WebElement campo_tamanho_est_refeicao;

	@FindBy(id = "mealsCount")
	protected WebElement campo_refeicoes_diarias;

	@FindBy(id = "postalCodeMail")
	protected WebElement campo_cep_correspondencia;

	@FindBy(id = "telephoneProprietary2")
	protected WebElement campo_telefone_terceiro_proprietario;

	@FindBy(id = "dddProprietary2")
	protected WebElement campo_ddd_terceiro_proprietario;

	@FindBy(id = "cnaeNumber")
	protected WebElement campo_cnae_refeicao_alimentacao;

	@FindBy(id = "neighborhoodCompany")
	protected WebElement campo_bairro;

	@FindBy(id = "streetCompany")
	protected WebElement campo_endereco;

	@FindBy(id = "cityCompany")
	protected WebElement campo_cidade;

	@FindBy(id = "districtCompany")
	protected WebElement campo_estado;

	@FindBy(id = "vanCheckLabel0")
	protected WebElement credenciadora_um;

	@FindBy(id = "mealDays0")
	protected WebElement cb_refeicao_2_a_6;

	@FindBy(id = "codeVan0")
	protected WebElement campo_codigo_um;

	@FindBy(id = "checkoutsCount")
	protected WebElement campo_quantidade_caixas;

	@FindBy(id = "foodArea")
	protected WebElement campo_tamanho_est_alimentacao;

	@FindBy(id = "cnaeNumber")
	protected WebElement campoTipoBeneficio;

	@FindBy(id = "cardSelectedLabel02")
	protected WebElement cartao_tres_cred_um;

	@FindBy(id = "cardSelectedLabel01")
	protected WebElement cartao_dois_cred_um;

	@FindBy(id = "cardSelectedLabel00")
	protected WebElement cartao_um_cred_um;

	@FindBy(id = "vanCheckLabel3")
	protected WebElement credenciadora_tres;

	@FindBy(id = "vanCheckLabel2")
	protected WebElement credenciadora_dois;

	@FindBy(id = "cardSelectedLabel31")
	protected WebElement cartao_dois_cred_tres;
	
	@FindBy(id = "imageLoader")
	protected WebElement loader;

	@FindBy(id = "cardSelectedLabel30")
	protected WebElement cartao_um_cred_tres;

	@FindBy(id = "cardSelectedLabel22")
	protected WebElement cartao_tres_cred_dois;

	@FindBy(id = "cardSelectedLabel21")
	protected WebElement cartao_dois_cred_dois;

	@FindBy(id = "cardSelectedLabel20")
	protected WebElement cartao_um_cred_dois;

	@FindBy(id = "cardSelectedLabel04")
	protected WebElement cartao_quatro_cred_um;

	@FindBy(id = "cepUnknow")
	protected WebElement btn_buscar;

	@FindBy(id = "addProprietary")
	protected WebElement btn_add_proprietario;

	@FindBy(xpath = "//*[@id='sameAddressNo']/parent::label")
	protected WebElement btn_add_correspondencia;

	@FindBy(id = "nextStepButton")
	protected WebElement btn_prox_passo_pat;

	@FindBy(id = "nextStepButton")
	protected WebElement btn_prox_passo_cartao;

	@FindBy(id = "nextStepButton")
	protected WebElement btn_prox_passo_form;

	@FindBy(id = "mealDays2")
	protected WebElement cb_refeicao_domingo;

	@FindBy(id = "mealDays1")
	protected WebElement cb_refeicao_sabado;

	@FindBy(id = "checkPlate5")
	protected WebElement cb_refeicao_outros;

	@FindBy(id = "checkPlate4")
	protected WebElement cb_refeicao_seg_padaria;

	@FindBy(id = "checkPlate3")
	protected WebElement cb_refeicao_padaria;

	@FindBy(id = "checkPlate2")
	protected WebElement cb_refeicao_bar;

	@FindBy(id = "checkPlate1")
	protected WebElement cb_refeicao_fastfood;

	@FindBy(id = "checkPlate0")
	protected WebElement cb_refeicao_restaurante;

	@FindBy(id = "termsNutritional")
	protected WebElement cb_termo_consulta_pat;

	@FindBy(id = "termsPat")
	protected WebElement cb_termo_exigencias_pat;

	@FindBy(id = "mealTime2")
	protected WebElement cb_refeicao_24_horas;

	@FindBy(id = "mealTime1")
	protected WebElement cb_refeicao_noturno;

	@FindBy(id = "mealTime0")
	protected WebElement cb_refeicao_comercial;

	@FindBy(id = "cheekPlace1")
	protected WebElement cb_alim_hipermercado;

	@FindBy(id = "cheekPlace0")
	protected WebElement cb_alim_supermercado;

	@FindBy(id = "productBottomText")
	protected WebElement msg_credenciadoras_um;

	@FindBy(id = "codeVan2")
	protected WebElement campo_codigo_dois;

	@FindBy(id = "swal2-title")
	protected WebElement msg_validacao_credenciamento;

	@FindBy(id = "nextStepButton")
	protected WebElement btn_finalizar_cadastro;

	@FindBy(id = "termsAntecipation")
	protected WebElement cb_termo_concordo_condicoes;

	@FindBy(id = "cheekPlace9")
	protected WebElement cb_alim_outros;

	@FindBy(id = "cheekPlace8")
	protected WebElement cb_alim_padaria;

	@FindBy(id = "cheekPlace7")
	protected WebElement cb_alim_lat_frio;

	@FindBy(id = "cheekPlace6")
	protected WebElement cb_alim_hortimercado;

	@FindBy(id = "cheekPlace5")
	protected WebElement cb_alim_peixaria;

	@FindBy(id = "cheekPlace4")
	protected WebElement cb_alim_acogue;

	@FindBy(id = "cheekPlace3")
	protected WebElement cb_alim_armazem;

	@FindBy(id = "removeProprietary0")
	protected WebElement btn_prim_prorietario;

	@FindBy(id = "campo_conta_corrente_credenciamento")
	protected WebElement accountNumber;

	@FindBy(id = "agencyCode")
	protected WebElement campo_agencia_credenciamento;

	@FindBy(id = "bankCode")
	protected WebElement campo_banco_credenciamento;

	@FindBy(id = "foodTime2")
	protected WebElement cb_alim_24_horas;

	@FindBy(id = "foodTime1")
	protected WebElement cb_alim_noturno;

	@FindBy(id = "foodTime0")
	protected WebElement cb_alim_comercial;

	@FindBy(id = "foodDays2")
	protected WebElement cb_alim_domingo;

	@FindBy(id = "foodDays1")
	protected WebElement cb_alim_sabado;

	@FindBy(id = "foodDays0")
	protected WebElement cb_alim_2_a_6;

	@FindBy(id = "cheekPlace2")
	protected WebElement cb_alim_mercearia;

	@FindBy(id = "termsPrivacy")
	protected WebElement cb_termo_concordo_politica;

	@FindBy(id = "removeProprietary2")
	protected WebElement btn_terc_prorietario;

	@FindBy(id = "btn_seg_prorietario")
	protected WebElement btn_seg_prorietario;

	@FindBy(xpath = "//input[@id='cardSelected20']/..")
	protected WebElement cartao_multi_tres;

	@FindBy(id = "codeVan3")
	protected WebElement campo_codigo_tres;

	@FindBy(id = "cnaeNumber")
	protected WebElement campo_cnae_incorreto;

	@FindBy(xpath = "//*[@id='cardSelected20']/../../../h5")
	protected WebElement nome_cartao_um_cred_dois;

	@FindBy(xpath = "//*[@id='cardSelected00']/../../../h5")
	protected WebElement nome_cartao_um_cred_um;

	@FindBy(xpath = "//*[@id='cardSelected01']/../../../h5")
	protected WebElement nome_cartao_dois_cred_um;

	@FindBy(xpath = "//*[@id='cardSelected02']/../../../h5")
	protected WebElement nome_cartao_tres_cred_um;

	@FindBy(xpath = "//*[@id='cardSelected21']/../../../h5")
	protected WebElement nome_cartao_dois_cred_dois;

	public CredenciamentoPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

}
