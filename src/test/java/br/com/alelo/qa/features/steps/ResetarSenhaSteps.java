package br.com.alelo.qa.features.steps;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.alelo.qa.features.support.ParentSteps;
import br.com.alelo.qa.web.actions.EsqueciMinhaSenhaActions;
import br.com.alelo.qa.web.actions.EsqueciMinhaSenhaConfirmacaoEnvioActions;
import br.com.alelo.qa.web.actions.LoginActions;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;

public class ResetarSenhaSteps extends ParentSteps {
	
	private static final Logger logger = LoggerFactory.getLogger(ResetarSenhaSteps.class);
	LoginActions loginActions;
	EsqueciMinhaSenhaActions esqueciMinhaSenhaActions;
	EsqueciMinhaSenhaConfirmacaoEnvioActions esqueciMinhaSenhaConfirmacaoEnvioActions;

	@Dado("^clico em esqueci minha senha$")
	public void clico_em_esqueci_minha_senha() throws Throwable {
		loginActions = new LoginActions(webdriver);
		loginActions.esqueciMinhaSenha();
	}

	@Quando("^eu entrar na tela de redefinicao de senha$")
	public void eu_entrar_na_tela_de_redefinicao_de_senha() throws Throwable {
		esqueciMinhaSenhaActions = new EsqueciMinhaSenhaActions(webdriver);
		esqueciMinhaSenhaActions.aguardarFormularioEsqueciMinhaSenhaCarregar();
		logger.info("Pagina de esqueci minha senha do Portal PME");
	}

	@Quando("^preencho com o cpf \"([^\"]*)\"$")
	public void preencho_com_o_cpf(String cpf) throws Throwable {
		esqueciMinhaSenhaActions.preencherCpf(cpf);
	}

	@Quando("^preencho com a dia de nascimento \"([^\"]*)\"$")
	public void preencho_com_a_dia_de_nascimento(String dia) throws Throwable {
		esqueciMinhaSenhaActions.preencherDia(dia);
	}

	@Quando("^preencho com a mes de nascimento \"([^\"]*)\"$")
	public void preencho_com_a_mes_de_nascimento(String mes) throws Throwable {
		esqueciMinhaSenhaActions.preencherMes(mes);
	}

	@Quando("^preencho com a ano de nascimento \"([^\"]*)\"$")
	public void preencho_com_a_ano_de_nascimento(String ano) throws Throwable {
		esqueciMinhaSenhaActions.preencherAno(ano);
	}

	@Quando("^preencho com o cnpj \"([^\"]*)\"$")
	public void preencho_com_o_cnpj(String cnpj) throws Throwable {
		esqueciMinhaSenhaActions.preencherCnpj(cnpj);
		esqueciMinhaSenhaActions.preencherCaptcha();
	}

	@Quando("^Clico no botao Enviar$")
	public void clico_no_botao_Enviar() throws Throwable {
		esqueciMinhaSenhaActions.clicarEmContinuar();
	}

	@Então("^a mensagem \"([^\"]*)\" deve ser exibida$")
	public void a_mensagem_deve_ser_exibida(String msgErro) throws Throwable {
		esqueciMinhaSenhaActions.msgErroExibida(msgErro);
	}
	
	@Então("^a tela E-mail enviado com sucesso para endereço cadastrado deve ser exibida$")
	public void a_tela_E_mail_enviado_com_sucesso_para_endereço_cadastrado_deve_ser_exibida() throws Throwable {
	    esqueciMinhaSenhaConfirmacaoEnvioActions = new EsqueciMinhaSenhaConfirmacaoEnvioActions(webdriver);
	    esqueciMinhaSenhaConfirmacaoEnvioActions.validaMensagemEnvioComSucesso();
	}
	
}
