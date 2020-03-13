/**
 * Autor: Michael Alba
 * Empresa: Taking
 * Data: 12/03/2020
 * Caminho: Portal Criação e Alteração de Senha de Usuário
 */

package br.com.alelo.qa.features.steps;

import br.com.alelo.qa.features.support.ParentSteps;
import br.com.alelo.qa.web.actions.CriarUsuarioResetarSenhaActions;
import cucumber.api.java.it.Quando;
import cucumber.api.java.pt.Entao;
import org.junit.Assert;


public class CriarUsuarioResetarSenhaStep extends ParentSteps {

    @Quando("^criar um novo usuario PID \"([^\"]*)\" e trocar senha \"([^\"]*)\"$")
    public void criar_um_novo_usuario_PID_e_trocar_senha(boolean PID, boolean trocaSenha) throws Throwable {
        CriarUsuarioResetarSenhaActions criarUsuarioReset = new CriarUsuarioResetarSenhaActions(webdriver);
        criarUsuarioReset.UsuarioCria_MudaSenha_(PID, trocaSenha);
    }

    @Entao("^devo validar a mensagem esperada \"([^\"]*)\" no cenario \"([^\"]*)\"$")
    public void devo_validar_a_mensagem_esperada_no_cenario(String mensagemEsperada, String cenario) throws Throwable {
        CriarUsuarioResetarSenhaActions criarUsuarioReset = new CriarUsuarioResetarSenhaActions(webdriver);
        Assert.assertTrue(cenario + " falhou", !criarUsuarioReset.ValidaResultado(cenario, mensagemEsperada));
    }
}



