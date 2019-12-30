/**
 * Caminho: Portal Estabelecimento Comercial  --> Credenciamento
 *      Date: 12/12/2019 | Fernando Lisboa - Taking 
 * Last Date: 30/12/2019 | Jessé Dantas - Taking
 */

package br.com.alelo.qa.web.actions;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import br.com.alelo.qa.web.page.CredenciamentoPage;

public class CredenciamentoActions extends CredenciamentoPage{

	public CredenciamentoActions(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	// Carregamento tela inicial
	public void paginaCredenciamento() throws InterruptedException {
		abrirUrl(urlInicio);
		navegarUrl(urlInicio);
		Thread.sleep(5000);
		clicar("xpath", btnPreencherFormulario);
	}

	// Clicar no botao cadastre seu estabelecimento
	public void clicarbtnCadastreSeuEstabelecimento() throws InterruptedException {
		clicar(btnCadastreSeuEstabelecimento);
	}

	// Metodo para preenchimento dos dados do estabelecimento
	public void preencherDadosEstabelecimentos() {
		campoRazaoSocial.sendKeys(keysToSend);
		escrever(escreverRazaoSocial, razaoSocial);
		escrever(escreverCNPJ, cnpj);
		escrever(escreverNomeFantasia, nomeFantasia);
		escrever(escreverCNAE, cnae);
		escrever(escreverDDD, ddd);
		escrever(escreverTelefone, telefone);
		escrever(escreverEmail, email);
	}

	// Metodo para preenchimento dos campos dados bancarios
	public void preencherDadosBancarios() {
		selecionarCombo(escreverBanco, 2);
		escrever(escreverAgencia, agencia);
		escrever(escreverContaCorrente, contaCorrente);
	}

	// Metodo para preenchimento dos campos de endereco
	public void preencherDadosEndereco() {
		escrever(escreverCEP, cep);
		escrever(escreverNumero, numero);
		escrever(escreverComplemento, complemento);
	}

	// Metodo para preenchimento dos campos do quadro societario
	public void preencherDadosQuadroSocietario() {
		escrever(escreverNomeCompleto, nomeCompleto);
		escrever(escreverCPF, cpf);
		escrever(escreverDataNascimento, dataNascimento);
		escrever(escreverDDDProprietario, dddProprietario);
		escrever(escreverTelproprietario, telefoneProprietario);
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

	// Preenchimento dos dados do formulario sem informar os dados do estabelecimento
	public void preencherFormsSemEstabelecimento() {
		preencherDadosBancarios();
		preencherDadosEndereco();
		preencherDadosQuadroSocietario();
	}

	// Preenchimento dos dados do formulario sem informar os dados do quadro societario
	public void preencherFormSemQuadroSocietario() {
		preencherDadosEstabelecimentos();
		preencherDadosBancarios();
		preencherDadosEndereco();
	}

	// Metodo para preencher o formulario, passando cnae como parametro
	public void preencherFormulario(String cnae1, String cnae2) {
		escrever(escreverRazaoSocial, razaoSocial);
		escrever(escreverCNPJ, cnpj);
		escrever(escreverNomeFantasia, nomeFantasia);
		escrever(cnae1, cnae2);
		escrever(escreverDDD, ddd);
		escrever(escreverTelefone, telefone);
		escrever(escreverEmail, email);
		preencherDadosBancarios();
		preencherDadosEndereco();
		preencherDadosQuadroSocietario();
	}

	// Preenchimento dos dados do segundo proprietario
	public void preencherDadosSegundoProprietario() {
		preencherDadosQuadroSocietario();
		clicar(btnAdicionarProprietario);
		escrever(escreverNomeCompletoSegundoProprietario, nomeCompletoSegundoProprietario);
		escrever(escreverCPFSegundoProprietario, cpfSegundoProprietario);
		escrever(escreverDataNascimentoSegundoProprietario, dataNascimentoSegundoProprietario);
		escrever(escreverDDDProprietarioSegundoProprietario, dddProprietarioSegundoProprietario);
		escrever(escreverTelproprietarioSegundoProprietario, telProprietarioSegundoProprietario);
	}

	// Preenchimento dos dados do terceiro proprietario
	public void preencherDadosSTerceiroProprietario() {
		preencherDadosSegundoProprietario();
		clicar(btnAdicionarProprietario);
		escrever(escreverNomeCompletoTerceiroProprietario, nomeCompletoTerceiroProprietario);
		escrever(escreverCPFTerceiroProprietario, cpfTerceiroProprietario);
		escrever(escreverDataNascimentoTerceiroProprietario, dataNascimentoTerceiroProprietario);
		escrever(escreverDDDTerceiroProprietario, dddProprietarioTerceiroProprietario);
		escrever(escreverTelTerceiroProprietario, telProprietarioTerceiroProprietario);
	}

	// Preenchimento do endereço de correspondencia
	public void preencherEnderecoCorrespondencia() {
		clicar(btnAddCorrespondencia);
		escrever(escreverCEPCorrespondencia, cepCorrespondencia);
		escrever(escreverNumeroCorrespondencia, numeroCorrespondencia);
	}

	// Preenchimento dos dados do formulario sem habilitar PAT
	public void preencherFormSemHabilitarPAT() {
		preencherFormulario(escreverCNAESemPAT, CNAESemPAT);
	}

	// Preenchimento dos dados do formulario habilitando somente o cartao refeicao 
	public void preencherFormHabilitandoCartaoRefeicao() {
		preencherFormulario(escreverCNAERefeicao, cnaeRefeicao);
	}

	// Preenchimento dos dados do formulario habilitando somente o cartao alimentacao
	public void preencherFormHabilitandoCartaoAlimentacao() {
		preencherFormulario(escreverCNAEAlim, cnaeAlim);
	}

	// Preenchimento dos dados do formulario habilitando somente o cartao multibeneficio
	public void preencherFormHabilitandoCartaoMulti() {
		preencherFormulario(escreverCNAEMulti, cnaeMulti);
	}

	// Preenchimento dos dados do formulario habilitando somente o cartao auto
	public void preencherFormHabilitandoCartaoAuto() {
		preencherFormulario(escreverCNAEAuto, cnaeAuto);
	}

	// Preenchimento dos dados do formulario habilitando os cartoes refeicao e alimentacao 
	public void preencherFormHabilitandoCartaoRefeicaoAlim() {
		preencherFormulario(escreverCNAERefeicaoAlim, cnaeRefeicaoAlim);
	}

	// Preenchimento dos dados do formulario habilitando os cartoes refeicao e multibeneficios 
	public void preencherFormHabilitandoCartaoRefeicaoMulti() {
		preencherFormulario(escreverCNAERefeicaoMulti, cnaeRefeicaoMulti);
	}

	// Preenchimento dos dados do formulario habilitando os cartoes refeicao e auto -----
	public void preencherFormHabilitandoCartaoRefeicaoAuto() {
		preencherFormulario(escreverCNAERefeicaoAuto, cnaeRefeicaoAuto);
	}

	// Preenchimento dos dados do formulario habilitando os cartoes alimentacao e multi
	public void preencherFormHabilitandoCartaoAlimentacaoMulti() {
		preencherFormulario(escreverCNAEAlimMulti, cnaeAlimMulti);
	}

	// Preenchimento dos dados do formulario habilitando somente os cartoes alimentacao e auto
	public void preencherFormHabilitandoCartaoAlimentacaoAuto() {
		preencherFormulario(escreverCNAEAlimAuto, cnaeAlimAuto);
	}

	// Preenchimento dos dados do formulario habilitando os cartoes multi e auto
	public void preencherFormHabilitandoCartaoMultiAuto() {
		preencherFormulario(escreverCNAEMultiAuto, cnaeMultiAuto);
	}

	// Preenchimento dos dados do formulario habilitando os cartoes refeicao, 
	// alimentacao e multi
	public void preencherFormHabilitandoCartaoRefeicaoAlimMulti() {
		preencherFormulario(escreverCNAERefeicaoAlimMulti, cnaeRefeicaoAlimMulti);
	}

	// Preenchimento dos dados do formulario habilitando os cartoes
	// refeicao, alimentacao e auto
	public void preencherFormHabilitandoCartaoRefeicaoAlimAuto() {
		preencherFormulario(escreverCNAERefeicaoAlimAuto, cnaeRefeicaoAlimAuto);
	}

	// Preenchimento dos dados do formulario habilitando os cartoes
	// refeicao, multi e auto
	public void preencherFormHabilitandoCartaoRefeicaoMultiAuto() {
		preencherFormulario(escreverCNAERefeicaoMultiAuto, cnaeRefeicaoMultiAuto);
	}

	// Preenchimento dos dados do formulario habilitando somente o cartao
	// alimentacao, multi e auto
	public void preencherFormHabilitandoCartaoAlimMultiAuto() {
		preencherFormulario(escreverCNAEAlimMultiAuto, cnaeAlimMultiAuto);
	}

	// Preenchimento do campo CEP 
	public void preencherCampoCEP() {
		escrever(escreverCEP, cep);
		try {
			Thread.sleep(3000);
			clicar(escreverEndereco);
			} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	// Clicar no botao buscar dos dados do CEP para ser direcionado ao site do Correios
	public void clicarBotaoCEP() {
		try {
			Thread.sleep(3000);
			clicar(btnBuscar);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Preenchimento do campo CNAE
	public void preencherCampoCNAE() {
		escrever(escreverCNAE, cnae);
	}

	// Preenchimento do campo CNAE com um valor errado
	public void preencherCampoCNAEErrado() {
		escrever(escreverCNAE, cnaeIncorreto);
	}

	// Metodo para clicar no botao excluir primeiro proprietario
	public void excluirPrimProprietario() {
		clicar(btnExcluirPrimProprietario);
	}

	// Metodo para clicar no botao excluir segundo proprietario
	public void excluirSegProprietario() {
		clicar(btnExcluirSegProprietario);
	}

	// Metodo para clicar no botao excluir terceiro proprietario
	public void excluirTercProprietario() {
		clicar(btnExcluirTercProprietario);
	}

	// Metodo para selecionar a segunda credenciadora
	public void selecionarSegCredenciadora() {
		clicar(btnProximoPassoFormulario);
		clicar(credenciadoraDois);
	}
	
	// Metodo para clicar no botao proximo passo da pagina formulario
	public void clicarProximoPassoFormulario() {
		clicar(btnProximoPassoFormulario);
	}

	// Metodo para clicar no botao proximo passo da pagina Cartoes
	public void clicarProximoPassoCartoes() {
		clicar(btnProximoPassoCartao);
	}

	// Metodo para clicar no botao proximo passo da pagina PAT
	public void clicarProximoPassoPAT() {
		clicar(btnProximoPassoPAT);
	}

	// Metodo para selecionar o cartao alimentacao da terceira credenciadora
	public void selecionarCartaoAlimTerceiraCred() {
		clicar(btnProximoPassoFormulario);
		clicar(credenciadoraTres);
		escrever(escreverCodigoTres, codigoTres);
		clicar(cartaoUmCredTres);
		clicar(btnProximoPassoCartao);
	}

	// Metodo para selecionar cartao alimentacao e refeicao da primeira credenciadora
	public void selecionarCartaoAlimERefPrimeiraCred() {
		clicarProximoPassoFormulario();
		clicar(credenciadoraUm);
		escrever(escreverCodigoUm, codigoUm);
		clicar(cartaoUmCredUm);
		clicar(btnProximoPassoCartao);
	}

	// Metodo para selecionar cartao alimentacao da primeira credenciadora
	public void selecionarCartaoAlimPrimeiraCred() {
		clicarProximoPassoFormulario();
		clicar(credenciadoraUm);
		escrever(escreverCodigoUm, codigoUm);
		clicar(cartaoUmCredUm);
		clicar(cartaoDoisCredUm);

	}

	// Metodo para selecionar cartao alimentacao da segunda credenciadora
	public void selecionarCartaoAlimSegundaCred() {
		clicarProximoPassoFormulario();
		clicar(credenciadoraDois);
		clicar(cartaoUmCredDois);
		clicar(cartaoDoisCredDois);
	}

	// Metodo para selecionar cartao refeicao da primeira credenciadora
	public void selecionarCartaoRefPrimeiraCred() {
		clicarProximoPassoFormulario();
		clicar(credenciadoraUm);
		escrever(escreverCodigoUm, codigoUm);
		clicar(cartaoUmCredUm);
		clicar(cartaoTresCredUm);
	}

	// Metodo para selecionar cartao refeicao da segunda credenciadora
	public void selecionarCartaoRefSegundaCred() {
		clicarProximoPassoFormulario();
		clicar(credenciadoraDois);
		clicar(cartaoUmCredDois);
		clicar(cartaoDoisCredDois);

	}

	// Metodo para selecionar cartao refeicao da terceira credenciadora
	public void selecionarCartaoRefTerceiraCred() {
		clicarProximoPassoFormulario();
		clicar(credenciadoraTres);
		escrever(escreverCodigoDois, codigoTres);
		clicar(cartaoDoisCredTres);
	}

	// Metodo para selecionar cartao refeicao e alimentacao da primeira credenciadora
	public void selecionarCartaoRefAlimPrimCred() {
		clicarProximoPassoFormulario();
		clicar(credenciadoraUm);
		escrever(escreverCodigoUm, codigoUm);
		clicar(cartaoUmCredUm);
	}

	// Metodo para selecionar cartao refeicao e alimentacao da segunda credenciadora
	public void selecionarCartaoRefAlimSegCred() {
		clicarProximoPassoFormulario();
		clicar(credenciadoraDois);

	}

	// Metodo para selecionar os cartoes multibeneficios da primeira e segunda credenciadora
	public void selecionarCartaoMultiPrimSegCred() {
		clicar(btnProximoPassoFormulario);
		clicar(credenciadoraUm);
		escrever(escreverCodigoUm, codigoUm);
		clicar(cartaoDoisCredUm);
		clicar(credenciadoraDois);
		escrever(escreverCodigoDois, codigoDois);
	}

	// Metodo para selecionar cartao auto e multibeneficios da primeira credenciadora
	public void selecionarCartaoMultiEAutoPrimCred() {
		clicar(btnProximoPassoFormulario);
		clicar(credenciadoraUm);
		escrever(escreverCodigoUm, codigoUm);
	}

	// Metodo para selecionar cartão auto primeira credenciadora e multibeneficios segunda credenciadora ------
	public void selecionarCartaoAutoPrimCredMultiSegCred() {
		clicar(btnProximoPassoFormulario);
		clicar(credenciadoraUm);
		escrever(escreverCodigoUm, codigoUm);
		clicar(cartaoUmCredUm);
		clicar(credenciadoraDois);
		escrever(escreverCodigoDois, codigoDois);
	}

	// Metodo para selecionar somente a primeira credenciadora
	public void selecionarCredenciadora() {
		clicarProximoPassoFormulario();
		clicar(credenciadoraUm);
		clicar(cartaoUmCredUm);
		clicar(cartaoDoisCredUm);
		clicar(cartaoTresCredUm);
	}

	// Metodo para selecionar somente um cartao e somente uma credenciadora que nao habilite o PAT 
	public void selecionarCartaoNaoHabilitePAT() {
		clicarProximoPassoFormulario();
		clicar(credenciadoraUm);
		escrever(escreverCodigoUm, codigoUm);
		clicarProximoPassoCartoes();
		clicar(termoConcordoCondicoes);
		clicar(btnFinalizarCadastro);
	}

	// Metodo para selecionar cartão refeição e informar os dados do PAT sem aceitar os termos
	public void selecionarCartaoRefeicaoEInformarPAT() {
		clicarProximoPassoFormulario();
		clicar(credenciadoraUm);
		escrever(escreverCodigoUm, codigoUm);
		clicar(cartaoUmCredUm);
		clicar(cartaoTresCredUm);
		clicarProximoPassoCartoes();
		preencherDadosPATRefeicaoSemAceitarTermo();
	}

	//Metodo para preenchimento das informações do PAT Refeição 
	public void preencherDadosPATRefeicao() {
		clicar(cbRefeicaoRestaurante);
		escrever(escreverRefeicoesDiarias, refeicoesDiarias);
		escrever(escreverTamanhoEstRefeicao, tamanhoEstRefeicao);
		escrever(escreverQuantidadeMesas, quantidadeMesas);
		escrever(escreverQuantidadeAssentos, quantidadeAssentos);
		clicar(cbRefeicao2a6);
		clicar(cbRefeicaoComercial);
		clicar(termoExigenciasPAT);
		clicar(termoconsultaPat);
	}

	// Metodo para preenchimento das informações PAT Alimentação 
	public void preencherDadosPATAlimentacao() {
		clicar(cbAlimentacaoSupermercado);
		escrever(escreverTamanhoEstAlimentacao, tamanhoEstAlimentacao);
		escrever(escreverQuantCaixas, quantCaixas);
		clicar(cbAlimentacao2a6);
		clicar(cbAlimentacaoComercial);
		clicar(termoExigenciasPAT);
		clicar(termoconsultaPat);
	}

	//  Metodo para preenchimento das informações PAT Refeição sem aceitar os termos 
	public void preencherDadosPATRefeicaoSemAceitarTermo() {
		clicar(cbRefeicaoRestaurante);
		escrever(escreverRefeicoesDiarias, refeicoesDiarias);
		escrever(escreverTamanhoEstRefeicao, tamanhoEstRefeicao);
		escrever(escreverQuantidadeMesas, quantidadeMesas);
		escrever(escreverQuantidadeAssentos, quantidadeAssentos);
		clicar(cbRefeicao2a6);
		clicar(cbRefeicaoComercial);
	}

	// Fluxo completo iniciando no botao "proximo passo" do formulário
	public void fluxoCompletoSemFormulario() {
		try {
		selecionarCartaoRefPrimeiraCred();
		clicarProximoPassoCartoes();
		preencherDadosPATRefeicao();
		clicarProximoPassoPAT();
		clicar(termoConcordoCondicoes);
		clicar(btnFinalizarCadastro);
		}
		catch(Exception e){
			
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
		clicar(termoConcordoCondicoes);
		clicar(btnFinalizarCadastro);
		}

	// Metodo para preencher dados Pat alimentacao e refeicao
	public void preencherPatAlimRefeicaoEFinalizar() {
		clicarProximoPassoCartoes();
		preencherDadosPATAlimentacao();
		preencherDadosPATRefeicao();
		clicarProximoPassoPAT();
		clicar(termoConcordoCondicoes);
		clicar(btnFinalizarCadastro);
	}

	/*
	 * ------ Metodos para validação ------
	 * 
	 */

	// Validar se o credenciamento foi concluido
	public void validarCredenciamento() {
		validarSeElementoEstaVisivel(msgValidacaoCredenciamento);
	}

	// Validar se foi preenchido os campos automaticos ao buscar o CEP 
	public void validarPreenchimentoAutomaticoCEP() {
		preencherDadosBancarios();
		validarMensagemValue(estado, escreverEstado);
		validarMensagemValue(cidade, escreverCidade);
		validarMensagemValue(endereco, escreverEndereco);
		validarMensagemValue(bairro, escreverBairro);
	}

	// Validar se nao foi preenchido os campos automaticos ao buscar o CEP
	public void validarNaoPreenchimentoAutomaticoCEP() {
		validarMensagem("", escreverNumero);
		validarMensagem("", escreverComplemento);
	}

	// Validar se foi preenchido o campo CNPJ da segunda credenciadora
	public void validarAutoPreenchimentoCNPJdois() {
		String validacao = obterValorDoElementoAttribute(escreverCodigoDois, "value").replace(".","").replace("/", "").replace("-", "").replace(" ","");
		if (validacao.equals(cnpj)) {
		}else {
			System.out.println("Error");
			Assert.fail();
		}
	}

	// Validar se o sistema exibe a mensagem de aceitação das demais
	// credenciadoras
	public void validarMensagemDemaisCredenciadoras() {
		validarMensagem(msgaceitacaocredenciadoramassa, msgaceitacaocredenciadoraum);
	}

	// Validar se o botão proximo passo está desabilitado
	public void validarBotaoProxPassoDesabilitado() {
		validarSeElementoNaoEstaHabilitado(btnProximoPassoFormulario);
	}

	// Validar mensagem de cnae incorreto 
	public void validarMensagemCNAEIncorreto() {
		try {
		moverParaOelemento(escreverCNAE);
		Thread.sleep(3000);
		clicar(escreverCNAE);
		validarSeElementoEstaVisivel("tooltip-bottom");
		validarMensagem(
				"CNAE inválido. a atividade referente ao código não autoriza a habilitação dos produtos aleloCNAE inválido. "
						+ "a atividade referente ao código não autoriza a habilitação dos produtos alelo",
						obterTexto("tooltip-bottom"));
		}catch (Exception e) {
			
		}
	}

	// Validar se o sistema exibe somente o cartão Multi na primeira credenciadora
	public void validarExibicaoCartaoMulti() {
		clicar(credenciadoraUm);
		if (obterTexto(nomeCartaoUmCredUm).equals("ALELO MULTIBENEFÍCIOS")) {
			System.out.println("Cartão MultiBeneficios sendo exibido");
		}else{
			System.out.println("Cartão MultiBeneficios não sendo exibido");
			Assert.fail();
		}
		if (validarNaoExibicaoElemento(cartaoDoisCredUm) == true) {
			System.out.println("Somente um cartão sendo apresentado");
		}else {
			Assert.fail();
		}
	}

	// Validar se o sistema exibe somente o cartão Auto na primeira credenciadora
	public void validarExibicaoCartaoAuto() {
		clicar(credenciadoraUm);
		if (obterTexto(nomeCartaoUmCredUm).equals("ALELO AUTO")) {
			System.out.println("Cartão Auto sendo exibido");
		}else{
			System.out.println("Cartão Auto não sendo exibido");
			Assert.fail();
		}
		if (validarNaoExibicaoElemento(cartaoDoisCredUm)== true) {
			System.out.println("Cartão Refeicão não apresentado");
		}else {
			System.out.println("Cartão Refeicão apresentado");
			Assert.fail();
		}
	}

	// Validar exibicao dos cartoes refeicao e alimentacao da primeira credenciadora
	public void validarExibicaoRefeicaoAlim() {
		clicar(credenciadoraUm);
		if (obterTexto(nomeCartaoUmCredUm).equals("ALELO REFEIÇÃO")) {
			System.out.println("Cartão Alelo Refeição sendo exibido");
		} else {
			Assert.fail();
		}
		if (obterTexto(nomeCartaodoisCredUm).equals("ALELO ALIMENTAÇÃO")) {
			System.out.println("Cartão Alelo Alimentação sendo exibido");
		} else {
			Assert.fail();
		}
		if (validarNaoExibicaoElemento(cartaoTresCredUm) == true) {
			System.out.println("CNAE somente com dois tipos de cartões");
		} else {
			Assert.fail();
		}
	}

	// Validar exibicao dos cartoes refeicao e multi na primeira credenciadora
	public void validarExibicaoRefeicaoMulti() {
		clicar(credenciadoraUm);
		if (obterTexto(nomeCartaoUmCredUm).equals("ALELO MULTIBENEFÍCIOS")) {
			System.out.println("Cartão Alelo Multibenefícios sendo exibido");
		} else {
			Assert.fail();
		}
		if (obterTexto(nomeCartaodoisCredUm).equals("ALELO REFEIÇÃO")) {
			System.out.println("Cartão Alelo Refeição sendo exibido");
		} else {
			Assert.fail();
		}
		if (validarNaoExibicaoElemento(cartaoTresCredUm) == true) {
			System.out.println("CNAE somente com dois tipos de cartões");
		} else {
			Assert.fail();
		}
		}

	
	// Validar exibicao dos cartoes multibeneficions e auto na primeira credenciadora 
	public void validarExibicaoMultiAuto() {
		clicar(credenciadoraUm);
		if (obterTexto(nomeCartaoUmCredUm).equals("ALELO MULTIBENEFÍCIOS")) {
			System.out.println("Cartão Alelo Multibenefícios sendo exibido");
		} else {
			Assert.fail();
		}
		if (obterTexto(nomeCartaodoisCredUm).equals("ALELO AUTO")) {
			System.out.println("Cartão Alelo Auto sendo exibido");
		} else {
			Assert.fail();
		}
		if (validarNaoExibicaoElemento(cartaoTresCredUm) == true) {
			System.out.println("CNAE somente com dois tipos de cartões");
		} else {
			Assert.fail();
		}
		}
	
	// Validar exibicao dos cartoes refeicao, alimentacao e multi na primeira credenciadora 
	public void validarExibicaoRefeicaoAlimMulti() {
		clicar(credenciadoraUm);
		if (obterTexto(nomeCartaoUmCredUm).equals("ALELO MULTIBENEFÍCIOS")) {
			System.out.println("Cartão Alelo Multibenefícios sendo exibido");
		} else {
			Assert.fail();
		}
		if (obterTexto(nomeCartaodoisCredUm).equals("ALELO REFEIÇÃO")) {
			System.out.println("Cartão Alelo Refeição sendo exibido");
		} else {
			Assert.fail();
		}
		if (obterTexto(nomeCartaoTresCredUm).equals("ALELO ALIMENTAÇÃO")) {
			System.out.println("Cartão Alelo Alimentação sendo exibido");
		} else {
			Assert.fail();
		}
		if (validarNaoExibicaoElemento(cartaoQuatroCredUm) == true) {
			System.out.println("CNAE somente com tres tipos de cartões");
		} else {
			Assert.fail();
		}
		}

	// Validar nao exibicao do cartao auto na credenciadora dois 
	public void validarNaoExibicaoAuto() {
		clicar(credenciadoraDois);
		if (obterTexto(nomeCartaoUmCredDois).equals("ALELO MULTIBENEFÍCIOS")) {
			System.out.println("Cartão MultiBeneficios sendo exibido");
		}else{
			System.out.println("Cartão MultiBeneficios não sendo exibido");
			Assert.fail();
		}
		if (validarNaoExibicaoElemento(cartaoDoisCredDois) == true) {
			System.out.println("Somente um cartão sendo apresentado");
		}else {
			Assert.fail();
		}
		if (validarNaoExibicaoElemento(cartaoTresCredDois) == true) {
			System.out.println("CNAE somente com dois tipos de cartões");
		} else {
			Assert.fail();
		}
	}

	// Validar nao exibicao da pagina pat
	public void validarNaoExibicaoPat() {
		clicar(btnProximoPassoCartao);
		if (validarNaoExibicaoElemento(escreverTamanhoEstAlimentacao)
				& validarNaoExibicaoElemento(escreverTamanhoEstRefeicao) == true) {
			System.out.println("Sistema nao esta na pagina do PAT");
		} else {
			Assert.fail();
		}

	}

	// Validar exclusao do segundo proprietario 
	public void validarExclusaoSegProprietario() {
		boolean validacao;
		if (validarNaoExibicaoElemento(escreverNomeCompletoSegundoProprietario) == true) {
			System.out.println("Teste com sucesso");
			validacao = true;
		} else {
			System.out.println("Elemento " + escreverNomeCompletoSegundoProprietario + " foi encontrado");
			if (!obterTexto(escreverNomeCompletoSegundoProprietario).equals(nomeCompletoSegundoProprietario)) {
				validacao = true;
				System.out.println("Nome do segundo proprietario é diferente de " + nomeCompletoSegundoProprietario);
			} else {
				validacao = false;
				System.out.println("Nome do segundo proprietario é igual a " + nomeCompletoSegundoProprietario);
			}
		}
		assertEquals(true, validacao);
	}

	// Validar exclusao do primeiro proprietario 
	public void validarExclusaoPrimProprietario() {
		if (!obterTexto(escreverNomeCompleto).equals(nomeCompleto)) {
			System.out.println("Teste ok");
		} else {
			Assert.fail();
		}
	}

	// Validar exclusao terceiroproprietario 
	public void validarExclusaoTercProprietario() {
		boolean validacao = false;
		if (validarNaoExibicaoElemento(escreverNomeCompletoTerceiroProprietario) == true) {
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
			mudarAba(1);
			validarUrlAtual("http://www.buscacep.correios.com.br/sistemas/buscacep/");
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
	}
	
	// Metodo para validar se nao foi preenchido os campos da pagina PAT Alimentacao
	public void validarNaoPreenchimentoPATAlimentacao() {
		validarMensagemValue("", escreverTamanhoEstAlimentacao);
	}
	
	// Metodo para validar se nao foi preenchido os campos da pagina PAT Refeicao
	public void validarNaoPreenchimentoPATRefeicao() {
		clicar(btnProximoPassoCartao);
		validarMensagemValue("", escreverTamanhoEstRefeicao);
	}
	
	// Metodo para validar se nao foi preenchido os campos da pagina PAT Refeicao e Alimentação
		public void validarNaoPreenchimentoPATRefeicaoAlimentacao() {
			validarMensagemValue("", escreverTamanhoEstRefeicao);
			validarMensagemValue("", escreverTamanhoEstAlimentacao);
		}

}
