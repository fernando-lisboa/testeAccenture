/**
 * Caminho: Portal Estabelecimento Comercial  --> Credenciamento
 *      Date: 12/12/2019 | Fernando Lisboa - Taking 
 * Last Date: 30/12/2019 | Jessé Dantas - Taking
 */

package br.com.alelo.qa.features.steps;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.alelo.qa.features.support.ParentSteps;
import br.com.alelo.qa.web.actions.CredenciamentoActions;
import br.com.alelo.qa.web.actions.HomeActions;
import br.com.alelo.qa.web.actions.OfertaAtivaActions;
import br.com.alelo.utils.SimpleCacheManager;
import cucumber.api.java.gl.E;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;

public class CredenciamentoStep extends ParentSteps {

	private static final Logger logger = LoggerFactory.getLogger(LoginSteps.class);
	CredenciamentoActions credenciamentoActions;
	OfertaAtivaActions oferta;
	HomeActions homeActions;
	protected SimpleCacheManager cache = SimpleCacheManager.getInstance();
	
	// ############################## Métodos Given ##############################

	@Dado("^que estou no portal meu estabelecimento$")
	public void que_estou_no_portal_meu_estabelecimento() throws Throwable {
		credenciamentoActions.paginaCredenciamento();
	}

	@E("^clico no botao cadastre seu estabelecimento$")
	public void clico_botao_estabelecimento() throws Throwable {
		credenciamentoActions.clicarbtnCadastreSeuEstabelecimento();
	}

	// Cenário: Sistema realiza o cadastro do estabelecimento com dois proprietários
	@Quando("^informo os dados do formulario$")
	public void preencho_o_formulario_de_login() throws Throwable {
		credenciamentoActions.preencherFormulario();
	}

	@E("^adiciono um segundo proprietario$")
	public void adiciono_segundo_proprietario() {
		credenciamentoActions.preencherDadosSegundoProprietario();
	}

	@E("^informo os demais dados$")
	public void informo_dados_conta() {
		credenciamentoActions.fluxoCompletoSemFormulario();
	}

	@Entao("^o sistema realiza o credenciamento do estabelecimento$")
	public void valida_cadastro() {
		credenciamentoActions.validarCredenciamento();
	}

	// Cenário: Sistema realiza o cadastro do estabelecimento com tes proprietarios
	@E("^adiciono um terceiro proprietario$")
	public void adiciono_terceiro_proprietario() {
		credenciamentoActions.preencherDadosSTerceiroProprietario();
	}

	// Cenário: Realizar o cadastro com outro endereço de correspondencia

	@E("^seleciono outro endereco de correspondencia$")
	public void seleciono_outro_endereco_correspondecia() {
		credenciamentoActions.preencherEnderecoCorrespondencia();
	}

	// Cenário: Sistema realiza o cadastro do estabelecimento no sistema sem
	// preenchimento do PAT

	@Quando("^informo os dados do formulario sem habilitar PAT$")
	public void preencho_o_formulario_de_login_sem_PAT() throws Throwable {
		credenciamentoActions.preencherFormSemHabilitarPAT();
	}
	
	// ############################## Métodos When ##############################

	@E("^seleciono um cartao concordando com os termos$")
	public void seleciono_cartao_nao_habilite_PAT() {
		credenciamentoActions.selecionarCartaoNaoHabilitePAT();
	}

	// Cenario: Validação do preenchimento automático do CEP
	@Quando("^informo o CEP$")
	public void informo_valor_CEP() throws Throwable {
		credenciamentoActions.preencherCampoCEP();
	}

	@Entao("^os campos com preenchimento automatico sao preenchidos$")
	public void valida_preenchimento_campos() {
		credenciamentoActions.validarPreenchimentoAutomaticoCEP();
	}

	@E("^os campos sem preenchimento automatico nao sao preenchidos$")
	public void valida_nao_preenchimento_campos() {
		credenciamentoActions.validarNaoPreenchimentoAutomaticoCEP();
	}

	// Cenario: Sistema exibe de forma dinamica o valor do campo cnae

	@Quando("^preencho o campo CNAE$")
	public void preencho_cnae() throws Throwable {
		credenciamentoActions.preencherCampoCNAE();
	}

	@Entao("^o sistema exibe as opcoes de acordo com o valor digitado$")
	public void valida_opcoes_cnae() {

	}

	// Cenario: Sistema exibe o CNPJ na credenciadora Stelo conforme o preenchido no
	// formulario
	@E("^seleciono a credenciadora Stelo$")
	public void seleciono_cred_Stelo() {
		credenciamentoActions.selecionarSegCredenciadora();
	}

	@Entao("^o sistema preenche o CNPJ conforme o dado informado no formulario$")
	public void valida_auto_preenchimento_CNPJ_dois() {
		credenciamentoActions.validarAutoPreenchimentoCNPJdois();
	}

	// Cenario: Sistema apresenta a mensagem de aceitacao das outras credenciadoras
	@E("^clico no botao proximo passo do formulario$")
	public void clico_proximo_passo_formulario() {
		credenciamentoActions.clicarProximoPassoFormulario();
	}

	@Entao("^o sistema exibe a mensagem de aceitacao das outras credenciadoras$")
	public void validar_mensagem_demais_credenciadoras() {
		credenciamentoActions.validarMensagemDemaisCredenciadoras();
	}

	// Cenario: Sistema nao direciona para a proxima pagina sem confirmar os termos
	// de aceite da pagina PAT
	@E("^informo os dados do PAT sem aceitar os termos de aceite$")
	public void preencher_PAT_sem_aceitar_termos() {
		credenciamentoActions.selecionarCartaoRefeicaoEInformarPAT();
	}

	@Entao("^o sistema nao habilita o botao para proxima pagina$")
	public void validar_mensagem_dados_obrigatorios() {
		credenciamentoActions.validarBotaoProxPassoDesabilitado();
	}
	
	// ############################## Métodos Then ##############################

	// Cenarios: Sistema nao permite o cadastro no sistema com os dados de
	// formularios sem preenchimento
	@Quando("^nao preencho os dados de formulario$")
	public void nao_preencho_formulario() throws Throwable {
		// clicarProximoPassoFormulario();
	}

	// Cenarios: Sistema nao permite o cadastro no sistema com os dados de
	// estabelecimento sem preenchimento
	@Quando("^nao preencho os dados de estabelecimento$")
	public void preencher_formulario_sem_estabelecimento() throws Throwable {
		credenciamentoActions.preencherFormsSemEstabelecimento();
	}

	// Cenarios: Sistema nao permite o cadastro no sistema com os dados de endereço
	// sem preenchimento
	@Quando("^nao preencho os dados de endereço$")
	public void preencher_formulario_sem_endereco() throws Throwable {
		credenciamentoActions.preencherFormSemEndereco();
	}

	// Cenarios: Sistema nao permite o cadastro no sistema com os dados de quadro
	// societario sem preenchimento
	@Quando("^nao preencho os dados do quadro societario$")
	public void preencher_formulario_sem_quadro_societario() throws Throwable {
		credenciamentoActions.preencherFormSemQuadroSocietario();
	}

	// Cenário: Sistema exibe mensagem de erro ao informar o cnae incorreto
	@Quando("^preencho o campo cnae com o dado invalido$")
	public void preencher_cnae_errado() throws Throwable {
		credenciamentoActions.preencherCampoCNAEErrado();
	}

	@Entao("^o sistema exibe mensagem de erro$")
	public void validar_mensagem_cnae_incorreto() {
		credenciamentoActions.validarMensagemCNAEIncorreto();
	}

	// Cenario: Sistema nao direciona para a proxima pagina sem preencher os dados
	// PAT refeicao
	@E("^seleciono a opcao de cartao vale refeicao$")
	public void selecionar_cartao_refeicao() {
		credenciamentoActions.selecionarCartaoRefPrimeiraCred();
	}

	@E("^nao preencho os dados PAT refeicao$")
	public void nao_preenchimento_PAT_refeicao() {
		credenciamentoActions.validarNaoPreenchimentoPATRefeicao();
	}

	// Cenario: sistema não conclui o credenciamento sem confirmar os termos de
	// aceite do recebimento
	@E("^nao seleciono a opcao de concordar com as condicoes de recebimento$")
	public void nao_concordar_condicoes_recebimento() {
		credenciamentoActions.fluxoCompletoSemConcordarTermoContrato();
	}

	// Cenario: Sistema não direciona para a proxima pagina quando nao e selecionado
	// o tipo de cartao
	@E("^seleciono somente a credenciadora$")
	public void seleciono_credenciadora() {
		credenciamentoActions.selecionarCredenciadora();
	}

	// Cenario: Sistema nao direciona para a proxima pagina sem preencher os dados
	// PAT alimentacao
	@E("^seleciono a opcao de cartao vale alimentacao$")
	public void seleciono_vale_alimentacao() {
		credenciamentoActions.selecionarCartaoAlimTerceiraCred();
	}

	@E("^nao preencho os dados PAT alimentacao$")
	public void nao_preencher_PAT() {
		credenciamentoActions.validarNaoPreenchimentoPATAlimentacao();
	}

	// Cenario: Sistema nao direciona para a proxima pagina sem preencher os dados
	// PAT alimentacao e refeicao
	@E("^seleciono os tipos de cartoes$")
	public void selecionar_cartao_alimentacao_refeicao() {
		credenciamentoActions.selecionarCartaoAlimERefPrimeiraCred();
	}

	@E("^nao preencho os dados PAT$")
	public void validar_nao_preenchimento_PAT() {
		credenciamentoActions.validarNaoPreenchimentoPATRefeicaoAlimentacao();
	}

	// Sistema nao direciona para a proxima pagina sem preencher os dados
	// PAT alimentacao e preenchendo PAT refeicao

	@E("^preencho somente os dados do PAT refeicao$")
	public void preencher_pat_refeicao() {
		credenciamentoActions.preencherDadosPATRefeicao();
	}

	// Cenario: Sistema nao direciona para a proxima pagina sem preencher os dados
	// PAT refeicao e preenchendo alimentacao
	@E("^preencho somente os dados do PAT alimentacao$")
	public void preencher_pat_alimentacao() {
		credenciamentoActions.preencherDadosPATAlimentacao();
	}

	// Cenario: Sistema exibe apenas um tipo de cartao na etapa de condicoes de
	// recebimento

	@Quando("^informo os dados do formulario informando um cnae relacionado a multibeneficios$")
	public void preencher_form_cnae_multibeneficios() throws Throwable {
		credenciamentoActions.preencherFormHabilitandoCartaoMulti();
	}

	@Quando("^informo os dados do formulario informando um cnae relacionado a auto$")
	public void preencher_form_cnae_auto() throws Throwable {
		credenciamentoActions.preencherFormHabilitandoCartaoAuto();
	}

	@Entao("^o sistema exibe o tipo de cartao multibeneficios$")
	public void validar_exibicao_multibeneficios() {
		credenciamentoActions.validarExibicaoCartaoMulti();
	}

	@Entao("^o sistema exibe o tipo de cartao auto$")
	public void validar_exibicao_auto() {
		credenciamentoActions.validarExibicaoCartaoAuto();
	}

	// Esquema do Cenario: Sistema exibe dois tipos de cartoes de acordo com o CNAE
	@Quando("^informo os dados do formulario com um cnae relacionado a refeicao alimentacao$")
	public void preencher_form_cnae_refeicao_alim() throws Throwable {
		credenciamentoActions.preencherFormHabilitandoCartaoRefeicaoAlim();
	}

	@Quando("^informo os dados do formulario com um cnae relacionado a refeicao multibeneficios$")
	public void preencher_form_cnae_refeicao_multibeneficios() throws Throwable {
		credenciamentoActions.preencherFormHabilitandoCartaoRefeicaoMulti();
	}

	@Quando("^informo os dados do formulario com um cnae relacionado a multibeneficios auto$")
	public void preencher_form_cnae_multibeneficios_auto() throws Throwable {
		credenciamentoActions.preencherFormHabilitandoCartaoMultiAuto();
	}

	@Entao("^o sistema exibe os tipos de cartoes refeicao alimentacao$")
	public void validar_exibicao_refeicao_alim() {
		credenciamentoActions.validarExibicaoRefeicaoAlim();
	}

	@Entao("^o sistema exibe os tipos de cartoes refeicao multibeneficios$")
	public void validar_exibicao_refeicao_multibeneficios() {
		credenciamentoActions.validarExibicaoRefeicaoMulti();
	}

	@Entao("^o sistema exibe os tipos de cartoes multibeneficios auto$")
	public void validar_exibicao_multibeneficios_auto() {
		credenciamentoActions.validarExibicaoMultiAuto();
	}

	// Esquema do Cenario: Sistema exibe tres tipos de cartoes de acordo com o CNAE
	@Quando("^informo os dados do formulario com um cnae relacionado a tres tipos de cartoes$")
	public void preencher_form_cnae_refeicao_alim_multi() throws Throwable {
		credenciamentoActions.preencherFormHabilitandoCartaoRefeicaoAlimMulti();
	}

	@Entao("^o sistema exibe os tres tipos de cartoes$")
	public void validar_exibicao_alim_multi_auto() {
		credenciamentoActions.validarExibicaoRefeicaoAlimMulti();
	}

	// Esquema do Cenario: Sistema nao exibe o tipo de cartao auto na credenciadora
	// Stelo
	@Entao("^o sistema nao exibe o cartao auto na credenciadora Stelo$")
	public void validar_nao_exibicao_auto() {
		credenciamentoActions.validarNaoExibicaoAuto();
	}

	// Esquema do Cenario: Sistema nao exibe os tipos de cartoes
	// auto e multibeneficios na credenciadora stone
	@Entao("^o sistema nao exibe os cartoes auto e multibeneficios na credenciadora dois$")
	public void validar_nao_exibicao_auto_multi() {
		// validarNaoExibicaoAutoMulti();
	}

	// Esquema do Cenario: Sistema realiza o credenciamento do
	// estabelecimento preenchendo o pat alimentacao ou refeicao
	@E("^seleciono o tipo do cartao alimentacaoCielo$")
	public void seleciono_cartao_alimentacaoCielo() {
		credenciamentoActions.selecionarCartaoAlimPrimeiraCred();
	}

	@E("^seleciono o tipo do cartao alimentacaodois$")
	public void seleciono_cartao_alimentacao_seg_cred() {
		credenciamentoActions.selecionarCartaoAlimSegundaCred();
	}

	@E("^seleciono o tipo do cartao alimentacaoStone$")
	public void seleciono_cartao_alimentacaoStone() {
		credenciamentoActions.selecionarCartaoAlimTerceiraCred();
	}

	@E("^seleciono o tipo do cartao refeicaoCielo$")
	public void seleciono_cartao_refeicaoCielo() {
		credenciamentoActions.selecionarCartaoRefPrimeiraCred();
	}

	@E("^seleciono o tipo do cartao refeicaodois$")
	public void seleciono_cartao_refeicaodois() {
		credenciamentoActions.selecionarCartaoRefSegundaCred();
	}

	@E("^seleciono o tipo do cartao refeicaoStone$")
	public void seleciono_cartao_refeicaoStone() {
		credenciamentoActions.selecionarCartaoRefTerceiraCred();
	}

	@E("^finalizo o credenciamento preenchendo o pat refeicao$")
	public void finalizo_cadastro_pat_refeicao() {
		// preencherPatRefeicaoEFinalizar();
	}

	@E("^finalizo o credenciamento preenchendo o pat alimentacao$")
	public void finalizo_cadastro_pat_alimentacao() {
		credenciamentoActions.preencherPatAlimentacaoEFinalizar();
	}

	// Esquema do Cenario: Sistema realiza o credenciamento preenchendo o pat
	// alimentacao e refeicao
	@E("^seleciono as opcoes alimentacao e refeicao da credenciadora cielo$")
	public void seleciono_cartoes_cielo() {
		credenciamentoActions.selecionarCartaoRefAlimPrimCred();
	}

	@E("^seleciono as opcoes alimentacao e refeicao da credenciadora stelo$")
	public void seleciono_cartoes_dois() {
		credenciamentoActions.selecionarCartaoRefAlimSegCred();
	}

	@E("^finalizo o credenciamento preenchendo os pat$")
	public void finalizo_cadastro_pat() {
		credenciamentoActions.preencherPatAlimentacaoEFinalizar();
	}

	// Esquema do Cenario: Sistema nao exibe a etapa Dados do PAT ao selecionar duas
	// credenciadoras

	@E("^seleciono os catoes multibeneficiosCielo mulmultibeneficiosStelo$")
	public void seleciono_multium_multidois() {
		credenciamentoActions.selecionarCartaoMultiPrimSegCred();
	}

	@E("^seleciono os catoes multibeneficiosCielo autoCielo$")
	public void seleciono_multicielo_autoCielo() {
		credenciamentoActions.selecionarCartaoMultiEAutoPrimCred();
	}

	@E("^seleciono os catoes autoCielo multibeneficiosStelo$")
	public void seleciono_autocielo_multidois() {
		credenciamentoActions.selecionarCartaoAutoPrimCredMultiSegCred();
	}

	@Entao("^o sistema nao exibe a etapa dados do pat$")
	public void validar_nao_exibicao_dados_pat() {
		credenciamentoActions.validarNaoExibicaoPat();

	}

	// Cenario: Sistema direciona para a pagina dos correios ao clicar no botao "Nao
	// sabe seu cep?"

	@Quando("^clico no botao NAO SABE SEU CEP$")
	public void clico_nao_sabe_cep() throws Throwable {
		credenciamentoActions.clicarBotaoCEP();
	}

	@Entao("^o  sistema direciona para a pagina dos correios$")
	public void valida_site_correios() {
		credenciamentoActions.validarSiteCorreios();

	}

	/*
	 * // Esquema do Cenario: Sistema nao permite o cadastro no sistema com os dados
	 * de formularios sem preenchimento
	 * 
	 * @Quando("^clico no botao proximo passo sem preencher os dados de formulario$"
	 * ) public void proxpasso_sem_preenchimento_formulario() throws Throwable {
	 * clicarProximoPassoFormulario(); }
	 */
	// Cenario: Sistema nao permite o cadastro no sistema com os dados bancarios sem
	// preenchimento
	@Quando("^nao preencho os dados bancarios$")
	public void nao_preencho_dados_bancarios() throws Throwable {
		credenciamentoActions.preencherFormularioSemDadosBancarios();
	}

	// Cenario: Verificar se o sistema exclui os dados do proprietario ao clicar no
	// botao excluir proprietario
	@Quando("^preencho as informacoes do segundo proprietario$")
	public void preencho_segundo_proprietario() throws Throwable {
		credenciamentoActions.preencherDadosSegundoProprietario();
	}

	@Quando("^preencho as informacoes do terceiro proprietario$")
	public void preencho_terceiro_proprietario() throws Throwable {
		credenciamentoActions.preencherDadosSTerceiroProprietario();
	}

	@E("^clico no botao excluir primeiro proprietario$")
	public void clico_excluir_primeiro_proprietario() {
		credenciamentoActions.excluirPrimProprietario();
	}

	@E("^clico no botao excluir segundo proprietario$")
	public void clico_excluir_segundo_proprietario() {
		credenciamentoActions.excluirSegProprietario();
	}

	@E("^clico no botao excluir terceiro proprietario$")
	public void clico_excluir_terceiro_proprietario() {
		credenciamentoActions.excluirTercProprietario();
	}

	@Entao("^o sistema exclui o primeiro proprietario$")
	public void valida_exclusao_primeiro_proprietario() {
		credenciamentoActions.validarExclusaoPrimProprietario();
	}

	@Entao("^o sistema exclui o segundo proprietario$")
	public void valida_exclusao_segundo_proprietario() {
		credenciamentoActions.validarExclusaoSegProprietario();
	}

	@Entao("^o sistema exclui o terceiro proprietario$")
	public void valida_exclusao_terceiro_proprietario() {
		credenciamentoActions.validarExclusaoTercProprietario();
	}

	// Sistema nao direciona para a proxima pagina quando nao e selecionado uma
	// credenciadora
	@E("^nao seleciono a credenciadora$")
	public void valido_credenciadora_selecionada() {
		// validarSeCredenciadoraMarcada();
	}

}