/**
 * Autor: Michael Alba
 * Empresa: Taking
 * Data: 12/03/2020
 * Caminho: Portal Criação e Alteração de Senha de Usuário
 */

package br.com.alelo.qa.features.steps;

import br.com.alelo.qa.features.support.ParentSteps;
import br.com.alelo.qa.web.actions.AntecipacaoActions;
import br.com.alelo.qa.web.actions.MeusCNPJsActions;
import cucumber.api.java.it.E;
import cucumber.api.java.it.Quando;
import cucumber.api.java.pt.Entao;
import org.junit.Assert;


public class MeusCNPJsStep extends ParentSteps {

    @E("vou pedir ajuda no atendimento e acesso a outra aba do navegador")
    public void vou_pedir_ajuda_no_atendimento_e_acesso_a_outra_aba_do_navegador()throws Throwable {
        MeusCNPJsActions adicionaCNPJ = new MeusCNPJsActions(webdriver);
        adicionaCNPJ.PedirAjudaMenu();
    }

    @Quando("devo associar CNPJS \"([^\"]*)\"$")
    public void devo_associar_um_CNPJ(int CNPJS) throws Throwable {
        MeusCNPJsActions adicionaCNPJ = new MeusCNPJsActions(webdriver);
        adicionaCNPJ.AdicionaCNPJS(CNPJS);
    }

    @Entao("a validacao do cenario deve conter como resultado: \"([^\"]*)\"$")
    public void a_validacao_do_cenario_deve_conter_como_resultado_(String Resultado) throws Throwable {
        MeusCNPJsActions AA = new MeusCNPJsActions(webdriver);
        AA.ResultadoEvidencia(Resultado);
    }
}



