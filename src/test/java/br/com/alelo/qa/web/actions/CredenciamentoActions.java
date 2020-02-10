/**
 * Caminho: Portal Estabelecimento Comercial  --> Credenciamento
 * Create: 12/12/2019 | Author: Fernando Lisboa - Taking 
 * Change: 03/01/2019 | Author: Jessé Dantas - Taking
 */

package br.com.alelo.qa.web.actions;

import static org.junit.Assert.assertEquals;

import java.util.Random;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import br.com.alelo.qa.utils.GeraCpfCnpj;
import br.com.alelo.qa.utils.RandomUtils;
import br.com.alelo.qa.web.page.CredenciamentoPage;

public class CredenciamentoActions extends CredenciamentoPage {

	public CredenciamentoActions(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	Actions action = new Actions(webdriver);

	GeraCpfCnpj geraCpfCnpj;
	RandomUtils random;
	String cnpj = geraCpfCnpj.cnpj(false);
	String cpf = geraCpfCnpj.cpf(false);
	String cel = random.getGenericCelular();
	String tel = random.getGenericTelefone();
	String numero = random.getGenericNumber();
	String alphanumeric = random.getGenericAlphanumeric();
	String cep = random.getRandomCep();
	String endereco = random.getRandomEndereco();
	String bairro = random.getRandomBairro();
	String cidade = random.getRandomCidade();
	String estado = random.getRandomEstado();
	String uf = random.getRandomUF();

	// Carregamento tela inicial
	public void paginaCredenciamento() throws InterruptedException {
		System.out.println(urlCredenciamento);
		getUrlCredenciamento();
		Thread.sleep(5000);
		btnPreencherFormulario.click();
	}

	// Clicar no botao cadastre seu estabelecimento
	public void clicarbtnCadastreSeuEstabelecimento() throws InterruptedException {
		btnCadastreSeuEstabelecimento.click();
	}

	// Metodo para preenchimento dos dados do estabelecimento
	public void preencherDadosEstabelecimentos() {
		campoRazaoSocial.sendKeys(cnpj + "Razao Social");
		campoCnpjCredenciamento.sendKeys(cnpj);
		campoNomeFantasia.sendKeys(cnpj + "Nome Fantasia");
		campo_cnae.sendKeys("4722902");
		campoDDD.sendKeys("11");
		campoTelefone.sendKeys("9" + cnpj.substring(0, 8));
		campoEmailCredenciamento.sendKeys(cnpj + "@mailinator.com");
	}

	// Preenchimento dos dados do segundo proprietario
	public void preencherDadosSegundoProprietario() {
		preencherDadosQuadroSocietario();
		btn_add_proprietario.click();
		campo_nome_completo_segundo_proprietario.sendKeys(cpf + "Segundo Proprietario");
		campo_cpf_segundo_proprietario.sendKeys(cpf);
		campo_data_nascimento_segundo_proprietario.sendKeys(random.getGenericDate());
		campo_ddd_segundo_proprietario.sendKeys("11");
		campo_telefone_segundo_proprietario.sendKeys(random.getGenericTelefone());
	}

	// Preenchimento dos dados do terceiro proprietario
	public void preencherDadosTerceiroProprietario() {
		preencherDadosSegundoProprietario();
		btn_add_proprietario.click();
		campo_nome_completo_terceiro_proprietario.sendKeys(cpf + "Terceiro Proprietario");
		campo_cpf_terceiro_proprietario.sendKeys(cpf);
		campo_data_nascimento_terceiro_proprietario.sendKeys(random.getGenericDate());
		campo_ddd_terceiro_proprietario.sendKeys("11");
		campo_telefone_terceiro_proprietario.sendKeys(random.getGenericTelefone());

	}

	// Metodo para preenchimento dos campos dados bancarios
	public void preencherDadosBancarios() {
//		selecionarCombo(escreverBanco, 2);
		campo_agencia_credenciamento.sendKeys(cnpj.substring(0, 4));
		campo_conta_corrente_credenciamento.sendKeys(cnpj.substring(0, 8));
	}

	// Metodo para preenchimento dos campos de endereco
	public void preencherDadosEndereco() {
		campoCep.sendKeys(random.getRandomCep());
		campo_numero.sendKeys(cpf.substring(0, 5));
		campoComplemento.sendKeys(random.getGenericAlphanumeric());
	}

	// Metodo para preenchimento dos campos do quadro societario
	public void preencherDadosQuadroSocietario() {
		campoNomeCompleto.sendKeys(cpf + random.getGenericAlphanumeric());
		campo_cpf_credenciamento.sendKeys(cpf);
		campo_data_nascimento.sendKeys(random.getGenericDate());
		campo_ddd_proprietario.sendKeys("11");
		campo_telefone_proprietario.sendKeys("9" + cpf.substring(0, 8));
	}

	// Preenchimento dos dados do formulario sem os dados bancarios
	public void preencherFormularioSemDadosBancarios() {
		preencherDadosEstabelecimentos();
		preencherDadosEndereco();
		preencherDadosQuadroSocietario();
	}

	// Preencher formulario
	public void preencherFormulario() {
		preencherDadosEstabelecimentos();
		preencherDadosBancarios();
		preencherDadosEndereco();
		preencherDadosQuadroSocietario();
	}

	// Preenchimento dos dados do formulario sem informar os dados de endereco
	public void preencherFormSemEndereco() {
		preencherDadosEstabelecimentos();
		preencherDadosBancarios();
		preencherDadosQuadroSocietario();
	}

	// Preenchimento dos dados do formulario sem informar os dados do
	// estabelecimento
	public void preencherFormsSemEstabelecimento() {
		preencherDadosBancarios();
		preencherDadosEndereco();
		preencherDadosQuadroSocietario();
	}

	// Preenchimento dos dados do formulario sem informar os dados do quadro
	// societario
	public void preencherFormSemQuadroSocietario() {
		preencherDadosEstabelecimentos();
		preencherDadosBancarios();
		preencherDadosEndereco();
	}

	// Metodo para preencher o formulario, passando cnae como parametro
	public void preencherFormulario(String cnae1, String cnae2) {
		campoRazaoSocial.sendKeys(cnpj + "Razao Social");
		campoCnpjCredenciamento.sendKeys(cnpj);
		campoNomeFantasia.sendKeys(cnpj + "Nome Fantasia");
		campo_cnae.sendKeys(cnae1, cnae2);
		campoDDD.sendKeys("11");
		campoTelefone.sendKeys(cnpj.substring(0, 8));
		campoEmailCredenciamento.sendKeys(cnpj + "@mailinator.com");
		preencherDadosBancarios();
		preencherDadosEndereco();
		preencherDadosQuadroSocietario();
	}

	// Preenchimento do endereço de correspondencia
	public void preencherEnderecoCorrespondencia() {
		btn_add_correspondencia.click();
		campo_cep_correspondencia.sendKeys(random.getRandomCep());
		campo_numero_correspondencia.sendKeys(random.getGenericNumber());
	}

	// Preenchimento dos dados do formulario sem habilitar PAT
	public void preencherFormSemHabilitarPAT() {
		campo_cnae_sem_pat.sendKeys(cnaeSemPat);
	}

	// Preenchimento dos dados do formulario habilitando somente o cartao refeicao
	public void preencherFormHabilitandoCartaoRefeicao() {
		campo_cnae_refeicao.sendKeys(cnaeRefeicao);
	}

	// Preenchimento dos dados do formulario habilitando somente o cartao
	// alimentacao
	public void preencherFormHabilitandoCartaoAlimentacao() {
		campo_cnae_alimentacao.sendKeys(cnaeAlimentacao);
	}

	// Preenchimento dos dados do formulario habilitando somente o cartao
	// multibeneficio
	public void preencherFormHabilitandoCartaoMulti() {
		campo_cnae_multi.sendKeys(cnaeMulti);
	}

	// Preenchimento dos dados do formulario habilitando somente o cartao auto
	public void preencherFormHabilitandoCartaoAuto() {
		campo_cnae_auto.sendKeys(cnaeAuto);
	}

	// Preenchimento dos dados do formulario habilitando os cartoes refeicao e
	// alimentacao
	public void preencherFormHabilitandoCartaoRefeicaoAlim() {
		campo_cnae_refeicao_alimentacao.sendKeys(cnaeRefeicaoAlim);
	}

	// Preenchimento dos dados do formulario habilitando os cartoes refeicao e
	// multibeneficios
	public void preencherFormHabilitandoCartaoRefeicaoMulti() {
		campo_cnae_refeicao_multi.sendKeys(cnaeRefeicaoMulti);
	}

	// Preenchimento dos dados do formulario habilitando os cartoes refeicao e auto
	// -----
	public void preencherFormHabilitandoCartaoRefeicaoAuto() {
		campo_cnae_refeicao_auto.sendKeys(cnaeRefeicaoAuto);
	}

	// Preenchimento dos dados do formulario habilitando os cartoes alimentacao e
	// multi
	public void preencherFormHabilitandoCartaoAlimentacaoMulti() {
		campo_cnae_alimentacao_multi.sendKeys(cnaeAlimentacaoMulti);
	}

	// Preenchimento dos dados do formulario habilitando somente os cartoes
	// alimentacao e auto
	public void preencherFormHabilitandoCartaoAlimentacaoAuto() {
		campo_cnae_alimentacao_auto.sendKeys(cnaeAlimentacaoAuto);
	}

	// Preenchimento dos dados do formulario habilitando os cartoes multi e auto
	public void preencherFormHabilitandoCartaoMultiAuto() {
		campo_cnae_multi_auto.sendKeys(cnaeMultiAuto);
	}

	// Preenchimento dos dados do formulario habilitando os cartoes refeicao,
	// alimentacao e multi
	public void preencherFormHabilitandoCartaoRefeicaoAlimMulti() {
		campo_cnae_refeicao_alimentacao_multi.sendKeys(cnaeRefeicaoAlimentacaoMulti);
	}

	// Preenchimento dos dados do formulario habilitando os cartoes
	// refeicao, alimentacao e auto
	public void preencherFormHabilitandoCartaoRefeicaoAlimAuto() {
		campo_cnae_refeicao_alimentacao_auto.sendKeys(cnaeRefeicaoAlimentacaoAuto);
	}

	// Preenchimento dos dados do formulario habilitando os cartoes
	// refeicao, multi e auto
	public void preencherFormHabilitandoCartaoRefeicaoMultiAuto() {
		campo_cnae_refeicao_multi_auto.sendKeys(cnaeRefeicaoMultiAuto);
	}

	// Preenchimento dos dados do formulario habilitando somente o cartao
	// alimentacao, multi e auto
	public void preencherFormHabilitandoCartaoAlimMultiAuto() {
		campo_cnae_alimentacao_multi_auto.sendKeys(cnaeAlimentacaoMultiAuto);
	}

	// Preenchimento do campo CEP
	public void preencherCampoCEP() {
		campoCep.sendKeys(cep);
		try {
			Thread.sleep(3000);
			campo_endereco.click();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// Clicar no botao buscar dos dados do CEP para ser direcionado ao site do
	// Correios
	public void clicarBotaoCEP() {
		try {
			Thread.sleep(3000);
			btn_buscar.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Preenchimento do campo CNAE
	public void preencherCampoCNAE() {
		campo_cnae.sendKeys(campoCnae);
	}

	// Preenchimento do campo CNAE com um valor errado
	public void preencherCampoCNAEErrado() {
		campo_cnae_incorreto.sendKeys();
	}

	// Metodo para clicar no botao excluir primeiro proprietario
	public void excluirPrimProprietario() {
		btn_prim_prorietario.click();
	}

	// Metodo para clicar no botao excluir segundo proprietario
	public void excluirSegProprietario() {
		btn_seg_prorietario.click();
	}

	// Metodo para clicar no botao excluir terceiro proprietario
	public void excluirTercProprietario() {
		btn_terc_prorietario.click();
	}

	// Metodo para selecionar a segunda credenciadora
	public void selecionarSegCredenciadora() {
		btn_prox_passo_form.click();
		credenciadora_dois.click();
	}

	// Metodo para clicar no botao proximo passo da pagina formulario
	public void clicarProximoPassoFormulario() {
		btn_prox_passo_form.click();
	}

	// Metodo para clicar no botao proximo passo da pagina Cartoes
	public void clicarProximoPassoCartoes() {
		btn_prox_passo_cartao.click();
	}

	// Metodo para clicar no botao proximo passo da pagina PAT
	public void clicarProximoPassoPAT() {
		btn_prox_passo_pat.click();
	}

	// Metodo para selecionar o cartao alimentacao da terceira credenciadora
	public void selecionarCartaoAlimTerceiraCred() {
		btn_prox_passo_form.click();
		credenciadora_tres.click();
		campo_codigo_tres.sendKeys(codigoVanX);
		cartao_um_cred_tres.click();
		btn_prox_passo_cartao.click();
	}

	// Metodo para selecionar cartao alimentacao e refeicao da primeira
	// credenciadora
	public void selecionarCartaoAlimERefPrimeiraCred() {
		clicarProximoPassoFormulario();
		credenciadora_um.click();
		campo_codigo_um.sendKeys(codigoVan1);
		cartao_um_cred_um.click();
		btn_prox_passo_cartao.click();
	}

	// Metodo para selecionar cartao alimentacao da primeira credenciadora
	public void selecionarCartaoAlimPrimeiraCred() {
		clicarProximoPassoFormulario();
		credenciadora_um.click();
		campo_codigo_um.sendKeys(codigoVan1);
		cartao_um_cred_um.click();
		cartao_dois_cred_um.click();
	}

	// Metodo para selecionar cartao alimentacao da segunda credenciadora
	public void selecionarCartaoAlimSegundaCred() {
		clicarProximoPassoFormulario();
		credenciadora_dois.click();
		cartao_um_cred_dois.click();
		cartao_dois_cred_dois.click();
	}

	// Metodo para selecionar cartao refeicao da primeira credenciadora
	public void selecionarCartaoRefPrimeiraCred() {
		clicarProximoPassoFormulario();
		credenciadora_um.click();
		campo_codigo_um.sendKeys(codigoVan1);
		cartao_um_cred_um.click();
		cartao_tres_cred_um.click();
	}

	// Metodo para selecionar cartao refeicao da segunda credenciadora
	public void selecionarCartaoRefSegundaCred() {
		clicarProximoPassoFormulario();
		credenciadora_dois.click();
		cartao_um_cred_dois.click();
		cartao_dois_cred_dois.click();
	}

	// Metodo para selecionar cartao refeicao da terceira credenciadora
	public void selecionarCartaoRefTerceiraCred() {
		clicarProximoPassoFormulario();
		credenciadora_tres.click();
		campo_codigo_tres.sendKeys(codigoVanX);
		cartao_dois_cred_tres.click();
	}

	// Metodo para selecionar cartao refeicao e alimentacao da primeira
	// credenciadora
	public void selecionarCartaoRefAlimPrimCred() {
		clicarProximoPassoFormulario();
		credenciadora_um.click();
		campo_codigo_um.sendKeys(codigoVan1);
		cartao_um_cred_um.click();
	}

	// Metodo para selecionar cartao refeicao e alimentacao da segunda credenciadora
	public void selecionarCartaoRefAlimSegCred() {
		clicarProximoPassoFormulario();
		credenciadora_dois.click();
	}

	// Metodo para selecionar os cartoes multibeneficios da primeira e segunda
	// credenciadora
	public void selecionarCartaoMultiPrimSegCred() {
		btn_prox_passo_form.click();
		credenciadora_um.click();
		campo_codigo_um.sendKeys(codigoVan1);
		cartao_dois_cred_um.click();
		credenciadora_dois.click();
		campo_codigo_dois.sendKeys(codigoVanX);
	}

	// Metodo para selecionar cartao auto e multibeneficios da primeira
	// credenciadora
	public void selecionarCartaoMultiEAutoPrimCred() {
		btn_prox_passo_form.click();
		credenciadora_um.click();
		campo_codigo_um.sendKeys(codigoVan1);
	}

	// Metodo para selecionar cartão auto primeira credenciadora e multibeneficios
	// segunda credenciadora ------
	public void selecionarCartaoAutoPrimCredMultiSegCred() {
		btn_prox_passo_form.click();
		credenciadora_um.click();
		campo_codigo_um.sendKeys(codigoVan1);
		cartao_um_cred_um.click();
		credenciadora_dois.click();
		campo_codigo_dois.sendKeys(codigoVanX);
	}

	// Metodo para selecionar somente a primeira credenciadora
	public void selecionarCredenciadora() {
		clicarProximoPassoFormulario();
		credenciadora_um.click();
		cartao_um_cred_um.click();
		cartao_dois_cred_um.click();
		cartao_tres_cred_um.click();
	}

	// Metodo para selecionar somente um cartao e somente uma credenciadora que nao
	// habilite o PAT
	public void selecionarCartaoNaoHabilitePAT() {
		clicarProximoPassoFormulario();
		credenciadora_um.click();
		campo_codigo_um.sendKeys(codigoVan1);
		clicarProximoPassoCartoes();
		cb_termo_concordo_condicoes.click();
		btn_finalizar_cadastro.click();
	}

	// Metodo para selecionar cartão refeição e informar os dados do PAT sem aceitar
	// os termos
	public void selecionarCartaoRefeicaoEInformarPAT() {
		clicarProximoPassoFormulario();
		credenciadora_um.click();
		campo_codigo_um.sendKeys(codigoVan1);
		cartao_um_cred_um.click();
		cartao_tres_cred_um.click();
		clicarProximoPassoCartoes();
		preencherDadosPATRefeicaoSemAceitarTermo();
	}

	// Metodo para preenchimento das informações do PAT Refeição
	public void preencherDadosPATRefeicao() {
		cb_refeicao_restaurante.click();
		campo_refeicoes_diarias.sendKeys(random.getGenericNumber());
		campo_tamanho_est_refeicao.sendKeys(random.getGenericNumber());
		campo_quantidade_mesas.sendKeys(random.getGenericNumber());
		campo_quantidade_assentos.sendKeys(random.getGenericNumber());
		cb_refeicao_2_a_6.click();
		cb_refeicao_comercial.click();
		cb_termo_exigencias_pat.click();
		cb_termo_consulta_pat.click();
	}

	// Metodo para preenchimento das informações PAT Alimentação
	public void preencherDadosPATAlimentacao() {
		cb_alim_supermercado.click();
		campo_tamanho_est_alimentacao.sendKeys(random.getGenericNumber().substring(0, 3));
		campo_quantidade_caixas.sendKeys(random.getGenericNumber().substring(0, 3));
		cb_alim_2_a_6.click();
		cb_alim_comercial.click();
		cb_termo_exigencias_pat.click();
		cb_termo_consulta_pat.click();
	}

	// Metodo para preenchimento das informações PAT Refeição sem aceitar os termos
	public void preencherDadosPATRefeicaoSemAceitarTermo() {
		cb_refeicao_restaurante.click();
		campo_refeicoes_diarias.sendKeys(random.getGenericNumber());
		campo_tamanho_est_refeicao.sendKeys(random.getGenericNumber());
		campo_quantidade_mesas.sendKeys(random.getGenericNumber());
		campo_quantidade_assentos.sendKeys(random.getGenericNumber());
		cb_refeicao_2_a_6.click();
		cb_refeicao_comercial.click();
	}

	// Fluxo completo iniciando no botao "proximo passo" do formulário
	public void fluxoCompletoSemFormulario() {
		try {
			selecionarCartaoRefPrimeiraCred();
			clicarProximoPassoCartoes();
			preencherDadosPATRefeicao();
			clicarProximoPassoPAT();
			cb_termo_concordo_condicoes.click();
			btn_finalizar_cadastro.click();
		} catch (Exception e) {

		}
	}

	// Fluxo completo iniciando no botao "proximo passo" do formulário e não
	// aceitando o termo de contrato da ultima pagina
	public void fluxoCompletoSemConcordarTermoContrato() {
		selecionarCartaoRefPrimeiraCred();
		clicarProximoPassoCartoes();
		preencherDadosPATRefeicao();
		clicarProximoPassoPAT();
	}

	// Metodo para preencher dados Pat alimentação e finalizar o cadastro
	public void preencherPatAlimentacaoEFinalizar() {
		clicarProximoPassoCartoes();
		preencherDadosPATAlimentacao();
		preencherDadosPATRefeicaoSemAceitarTermo();
		clicarProximoPassoPAT();
		cb_termo_concordo_condicoes.click();
		btn_finalizar_cadastro.click();

	}

	// Metodo para preencher dados Pat alimentacao e refeicao
	public void preencherPatAlimRefeicaoEFinalizar() {
		clicarProximoPassoCartoes();
		preencherDadosPATAlimentacao();
		preencherDadosPATRefeicao();
		clicarProximoPassoPAT();
		cb_termo_concordo_condicoes.click();
		btn_finalizar_cadastro.click();
	}

	/*
	 * ------ Metodos para validação ------
	 * 
	 */

	// Validar se o credenciamento foi concluido
	public void validarCredenciamento() {
//		validarSeElementoEstaVisivel(msgValidacaoCredenciamento);
		msg_validacao_credenciamento.isDisplayed();
	}

	// Validar se foi preenchido os campos automaticos ao buscar o CEP
	public void validarPreenchimentoAutomaticoCEP() throws Exception {
		preencherDadosBancarios();
		campo_estado.getText().equals(uf);
		campo_cidade.getText().equals(cidade);
		campo_endereco.getText().equals(endereco);
		campo_bairro.getText().equals(bairro);
	}

	// Validar se nao foi preenchido os campos automaticos ao buscar o CEP
	public void validarNaoPreenchimentoAutomaticoCEP() {
		campo_numero.getText().equals(numero);
		campo_complemento.getText().equals(alphanumeric);

	}

	// Validar se foi preenchido o campo CNPJ da segunda credenciadora
	public void validarAutoPreenchimentoCNPJdois() {
		String validacao = campo_codigo_dois.getText().replace(".", "").replace("/", "").replace("-", "").replace(" ",
				"");
//		String validacao = obterValorDoElementoAttribute(escreverCodigoDois, "value").replace(".", "").replace("/", "").replace("-", "").replace(" ", "");
		if (validacao.equals(cnpj)) {
		} else {
			System.out.println("Error");
			Assert.fail();
		}
	}

	// Validar se o sistema exibe a mensagem de aceitação das demais
	// credenciadoras
	public void validarMensagemDemaisCredenciadoras() {
//		validarMensagem(msgaceitacaocredenciadoramassa, msgaceitacaocredenciadoraum);
		msg_credenciadoras_um.getText().equals("Para habilitar a aceitação entre em contato conforme sua preferência");
	}

	// Validar se o botão proximo passo está desabilitado
	public void validarBotaoProxPassoDesabilitado() {
		assertEquals(false, btn_prox_passo_form.isEnabled());
	}

	// Validar mensagem de cnae incorreto
	public void validarMensagemCNAEIncorreto() {
		try {
			action.moveToElement(campo_cnae).build().perform();
			Thread.sleep(3000);
			campo_cnae.click();
			assertEquals(true, tooltip_bottom.isDisplayed());
			tooltip_bottom.getText().equals(
					"CNAE inválido. a atividade referente ao código não autoriza a habilitação dos produtos aleloCNAE inválido. "
							+ "a atividade referente ao código não autoriza a habilitação dos produtos alelo");
		} catch (Exception e) {

		}
	}

	// Validar se o sistema exibe somente o cartão Multi na primeira credenciadora
	public void validarExibicaoCartaoMulti() {
		credenciadora_um.click();
		if (nome_cartao_um_cred_um.getText().equals("ALELO MULTIBENEFÍCIOS")) {
			System.out.println("Cartão MultiBeneficios sendo exibido");
		} else {
			System.out.println("Cartão MultiBeneficios não sendo exibido");
			Assert.fail();
		}
		if (nome_cartao_dois_cred_um.isEnabled() != true) {
			System.out.println("Somente um cartão sendo apresentado");
		} else {
			Assert.fail();
		}
	}

	// Validar se o sistema exibe somente o cartão Auto na primeira credenciadora
	public void validarExibicaoCartaoAuto() {
		credenciadora_um.click();
		if (nome_cartao_um_cred_um.getText().equals("ALELO AUTO")) {
			System.out.println("Cartão Auto sendo exibido");
		} else {
			System.out.println("Cartão Auto não sendo exibido");
			Assert.fail();
		}
		if (nome_cartao_dois_cred_um.isEnabled() != true) {
			System.out.println("Cartão Refeicão não apresentado");
		} else {
			System.out.println("Cartão Refeicão apresentado");
			Assert.fail();
		}
	}

	// Validar exibicao dos cartoes refeicao e alimentacao da primeira credenciadora
	public void validarExibicaoRefeicaoAlim() {
		credenciadora_um.click();
		if (nome_cartao_um_cred_um.getText().equals("ALELO REFEIÇÃO")) {
			System.out.println("Cartão Alelo Refeição sendo exibido");
		} else {
			Assert.fail();
		}
		if (nome_cartao_dois_cred_um.getText().equals("ALELO ALIMENTAÇÃO")) {
			System.out.println("Cartão Alelo Alimentação sendo exibido");
		} else {
			Assert.fail();
		}
		if (nome_cartao_tres_cred_um.isEnabled() != true) {
			System.out.println("CNAE somente com dois tipos de cartões");
		} else {
			Assert.fail();
		}
	}

	// Validar exibicao dos cartoes refeicao e multi na primeira credenciadora
	public void validarExibicaoRefeicaoMulti() {
		credenciadora_um.click();
		if (nome_cartao_um_cred_um.getText().equals("ALELO MULTIBENEFÍCIOS")) {
			System.out.println("Cartão Alelo Multibenefícios sendo exibido");
		} else {
			Assert.fail();
		}
		if (nome_cartao_dois_cred_um.getText().equals("ALELO REFEIÇÃO")) {
			System.out.println("Cartão Alelo Refeição sendo exibido");
		} else {
			Assert.fail();
		}
		if (cartao_tres_cred_um.isDisplayed() != true) {
			System.out.println("CNAE somente com dois tipos de cartões");
		} else {
			Assert.fail();
		}
	}

	// Validar exibicao dos cartoes multibeneficions e auto na primeira
	// credenciadora
	public void validarExibicaoMultiAuto() {
		credenciadora_um.click();
		if (nome_cartao_um_cred_um.getText().equals("ALELO MULTIBENEFÍCIOS")) {
			System.out.println("Cartão Alelo Multibenefícios sendo exibido");
		} else {
			Assert.fail();
		}
		if (nome_cartao_dois_cred_um.getText().equals("ALELO AUTO")) {
			System.out.println("Cartão Alelo Auto sendo exibido");
		} else {
			Assert.fail();
		}
		if (cartao_tres_cred_um.isDisplayed() != true) {
			System.out.println("CNAE somente com dois tipos de cartões");
		} else {
			Assert.fail();
		}
	}

	// Validar exibicao dos cartoes refeicao, alimentacao e multi na primeira
	// credenciadora
	public void validarExibicaoRefeicaoAlimMulti() {
		credenciadora_um.click();
		if (nome_cartao_um_cred_um.getText().equals("ALELO MULTIBENEFÍCIOS")) {
			System.out.println("Cartão Alelo Multibenefícios sendo exibido");
		} else {
			Assert.fail();
		}
		if (nome_cartao_dois_cred_um.getText().equals("ALELO REFEIÇÃO")) {
			System.out.println("Cartão Alelo Refeição sendo exibido");
		} else {
			Assert.fail();
		}
		if (cartao_tres_cred_um.getText().equals("ALELO ALIMENTAÇÃO")) {
			System.out.println("Cartão Alelo Alimentação sendo exibido");
		} else {
			Assert.fail();
		}
		if (cartao_quatro_cred_um.isDisplayed() != true) {
			System.out.println("CNAE somente com tres tipos de cartões");
		} else {
			Assert.fail();
		}
	}

	// Validar nao exibicao do cartao auto na credenciadora dois
	public void validarNaoExibicaoAuto() {
		credenciadora_dois.click();
		if (nome_cartao_um_cred_dois.getText().equals("ALELO MULTIBENEFÍCIOS")) {
			System.out.println("Cartão MultiBeneficios sendo exibido");
		} else {
			System.out.println("Cartão MultiBeneficios não sendo exibido");
			Assert.fail();
		}
		if (cartao_dois_cred_dois.isDisplayed() != true) {
			System.out.println("Somente um cartão sendo apresentado");
		} else {
			Assert.fail();
		}
		if (cartao_tres_cred_dois.isDisplayed() != true) {
			System.out.println("CNAE somente com dois tipos de cartões");
		} else {
			Assert.fail();
		}
	}

	// Validar nao exibicao da pagina pat
	public void validarNaoExibicaoPat() {
		btn_prox_passo_cartao.click();
		if (campo_tamanho_est_alimentacao.isDisplayed() != true & campo_tamanho_est_refeicao.isDisplayed() != true) {
			System.out.println("Sistema nao esta na pagina do PAT");
		} else {
			Assert.fail();
		}

	}

	// Validar exclusao do segundo proprietario
	public void validarExclusaoSegProprietario() {
		boolean validacao;
		if (campo_nome_completo_segundo_proprietario.isDisplayed() != true) {
			System.out.println("Teste com sucesso");
			validacao = true;
		} else {
			System.out.println("Elemento " + campo_nome_completo_segundo_proprietario + " foi encontrado");
			if (!campo_nome_completo_segundo_proprietario.getText().equals(campo_nome_completo_segundo_proprietario)) {
				validacao = true;
				System.out.println(
						"Nome do segundo proprietario é diferente de " + campo_nome_completo_segundo_proprietario);
			} else {
				validacao = false;
				System.out
						.println("Nome do segundo proprietario é igual a " + campo_nome_completo_segundo_proprietario);
			}
		}
		assertEquals(true, validacao);
	}

	// Validar exclusao do primeiro proprietario
	public void validarExclusaoPrimProprietario() {
		if (!campoNomeCompleto.getText().equals(null)) {
			System.out.println("Teste ok");
		} else {
			Assert.fail();
		}
	}

	// Validar exclusao terceiroproprietario
	public void validarExclusaoTercProprietario() {
		boolean validacao = false;
		if (campo_nome_completo_terceiro_proprietario.isDisplayed() != true) {
			validacao = true;
		} else {
			Assert.fail();
		}
		assertEquals(true, validacao);
	}

	// Validar se a URL atual é a do correio
	public void validarSiteCorreios() {
		try {
			Thread.sleep(5000);
			String buscaCep = "http://www.buscacep.correios.com.br/sistemas/buscacep/";
			webdriver.switchTo().window(buscaCep);
			webdriver.getCurrentUrl();
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
	}

	// Metodo para validar se nao foi preenchido os campos da pagina PAT Alimentacao
	public void validarNaoPreenchimentoPATAlimentacao() {
//		validarMensagemValue("", escreverTamanhoEstAlimentacao);
		campo_tamanho_est_alimentacao.getText().equals("");
	}

	// Metodo para validar se nao foi preenchido os campos da pagina PAT Refeicao
	public void validarNaoPreenchimentoPATRefeicao() {
		btn_prox_passo_cartao.click();
//		validarMensagemValue("", escreverTamanhoEstRefeicao);
		campo_tamanho_est_refeicao.getText().equals("");
	}

	// Metodo para validar se nao foi preenchido os campos da pagina PAT Refeicao e
	// Alimentação
	public void validarNaoPreenchimentoPATRefeicaoAlimentacao() {
		campo_tamanho_est_refeicao.getText().equals("");
		campo_tamanho_est_alimentacao.getText().equals("");
	}

}
