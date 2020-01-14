/**
 * 
 */
package br.com.alelo.qa.web.actions;

import static org.junit.Assert.fail;

import org.openqa.selenium.WebDriver;

import br.com.alelo.qa.web.page.IsamPage;
import br.com.alelo.qa.features.steps.ISAMStep;

/**
 * @author Fernando Lisboa
 *
 */
public class IsamActions extends IsamPage {

	public IsamActions(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void telaLoginISAM() {
		System.out.println(getUrlISAM());
		getUrlISAM();
	}

	public void preencherUsuario() {
		usuario_ISAM.sendKeys("");
	}

	public void preencherSenha() {
		senha_ISAM.sendKeys("");
	}

	public void clicarLogin() {
		botao_login.click();
	}

	public void validarInicialISAM() {
		getUrlInternaISAM();
	}

	public void loginISAMGeral() throws Throwable {
		try {
			ISAMStep login = new ISAMStep();
			login.que_estou_na_tela_de_login_IBM();

			if (!webdriver.getCurrentUrl().contains("apisec.siteteste.inf.br")) {
				Thread.sleep(5000);
			} else {
				login.preencho_nome_de_usuario_e_senha();
				login.clico_no_botao_login();
				login.o_usuario_e_redirecionado_para_a_pagina_inicial_do_ISAM();
			}
		} catch (Exception e) {
			fail("Dados de login inválidos!");
		}
	}

	public void removerSessao() throws InterruptedException {
		try {
			Boolean on = remover_sessao.isEnabled();// elementExiste(removerSessao);

			while (on = true) {
				if (!on == false) {
					remover_sessao.click();
					on = remover_sessao.isEnabled();// elementExiste(removerSessao);
					Thread.sleep(1000);
				} else {
					break;
				}
			}
		} catch (Exception e) {
			System.out.println("Fim dos usuários!");
		}
	}

	public void validarSessao() {
		try {
			remover_sessao.isEnabled();
			System.out.println("Teste realizado com sucesso.");
		} catch (Exception e) {
			fail("Existem sessões ativas!");
		}
	}

}
