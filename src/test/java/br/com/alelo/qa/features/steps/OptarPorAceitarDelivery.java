package br.com.alelo.qa.features.steps;

import br.com.alelo.qa.features.support.ParentSteps;
import br.com.alelo.qa.web.actions.OptarPorAceitarDeliveryActions;
import br.com.alelo.utils.setupTestes.actions.CommonsActions;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;

public class OptarPorAceitarDelivery extends ParentSteps {


	CommonsActions comm = new CommonsActions();

	@Dado("^que prepara o banco de pid para testes \"([^\"]*)\"$")
	public void que_prepara_o_banco_de_pid_para_testes(String ambiente) throws Throwable {

		comm.limparPid(ambiente);

	}

	@Dado("^preencha os dados de PID \"([^\"]*)\"$")
	public void preencha_os_dados_de_PID(String ambiente) throws Throwable {
		OptarPorAceitarDeliveryActions delivery = new OptarPorAceitarDeliveryActions(webdriver);


		delivery.preencherPID(ambiente);
	}

	@Quando("^verificar a label do botao concluir$")
	public void verificar_a_label_do_botao_concluir() throws Throwable {
		OptarPorAceitarDeliveryActions delivery = new OptarPorAceitarDeliveryActions(webdriver);
		delivery.verificarDelivery();
		
	}

	@Quando("^optar por aceitar a opcao app \"([^\"]*)\" e clicar em avancar$")
	public void optar_por_aceitar_a_opcao_app_e_clicar_em_avancar(String cenario) throws Throwable {
		OptarPorAceitarDeliveryActions delivery = new OptarPorAceitarDeliveryActions(webdriver);
		delivery.selecionarApp(cenario);
	}

	@Quando("^devo validar a msg de confirmacao$")
	public void devo_validar_a_msg_de_confirmacao() throws Throwable {
		OptarPorAceitarDeliveryActions delivery = new OptarPorAceitarDeliveryActions(webdriver);
		delivery.habilitarEconfirmarMsg();
	}

	@Entao("^deve gravar no banco de dados a opcao escolhida \"([^\"]*)\", \"([^\"]*)\"$")
	public void deve_gravar_no_banco_de_dados_a_opcao_escolhida(String ambiente, String plataforma) throws Throwable {
		
		OptarPorAceitarDeliveryActions delivery = new OptarPorAceitarDeliveryActions(webdriver);
		
		delivery.validarBancoDeDados_App(ambiente, plataforma);
	}

	@Entao("^devo verificar que não é oferecido a opção de app$")
	public void devo_verificar_que_não_é_oferecido_a_opção_de_app() throws Throwable {
		System.out.println("EM DESENVOLVIMENTO.....");
	}

}
