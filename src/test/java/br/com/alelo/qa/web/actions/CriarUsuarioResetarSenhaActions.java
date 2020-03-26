package br.com.alelo.qa.web.actions;

import br.com.alelo.integrations.db.ConnBuc;
import br.com.alelo.qa.features.support.CriaArquivoJSON;
import br.com.alelo.qa.web.page.CriarUsuarioResetarSenhaPage;
import br.com.alelo.utils.GeraCpfCnpj;
import br.com.alelo.utils.setupTestes.actions.CommonsActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.lang.Thread.sleep;


public class CriarUsuarioResetarSenhaActions extends CriarUsuarioResetarSenhaPage {

    public CriarUsuarioResetarSenhaActions(WebDriver driver) {
        super(driver);
    }

    /**
     * <h3> Função Utilizada para Criar usuários e Mudar Senha através do esqueci senha da tela inicial do portal.</>>
     * <h3>Parâmetros Booleanos PID e TrocaSenha<h3>
     */

    public void UsuarioCria_MudaSenha_(boolean PID, boolean TrocaSenha, boolean LogarGmail, int associarCNPJS) throws InterruptedException {

        try {
//            CriaArquivoJSON json = new CriaArquivoJSON();
//
//            List<String>camposJSON = new ArrayList<String>();
//            List<String>valoresJSON = new ArrayList<String>();
//
//            camposJSON.add("CPF");camposJSON.add("Email");camposJSON.add("Senha");
//            valoresJSON.add("43457978883");valoresJSON.add("michael.pereira@taking.com.br");valoresJSON.add("teste123@");
//            camposJSON.add("CPF");camposJSON.add("Email");camposJSON.add("Senha");
//            valoresJSON.add("99999999999");valoresJSON.add("fernando@taking.com.br");valoresJSON.add("123teste@");
//            json.CriaArquivoJSON_(3,camposJSON,valoresJSON);

            //region [Burlar o captcha - Excluir o Captcha e Retirar Disabled do botao]
            // JavascriptExecutor js = (JavascriptExecutor) webdriver;

            waitForElementPageToBeClickable(webdriver.findElements(By.className("btnFormLight")).get(0));

            //Botão Primeiro Acesso
            JavaScriptAction(Funcao.click, null,null,webdriver.findElements(By.className("btnFormLight")).get(0));

            // TokenGmailPage GmailPage = new TokenGmailPage(webdriver);

            //Gera Numero Randomico - Usado para concatenar com o E-mail.
            Random rand = new Random();
            String n_mail = Integer.toString(rand.nextInt(999999999));
            String email = "roboalelousuario+" + n_mail + "@gmail.com";

            waitForElementPageToBeClickable(enderecoEmail);

            //E-mail
            enderecoEmail.sendKeys(email);

            //Remove o elemento Captcha da tela
            JavaScriptAction(Funcao.deletarElement, BuscatipoJava.getElementsByClassName,"clearfix",null);

            //Remove o Atributo Disabled do botão Cadastrar - Feito após deletar o captcha - Habilita o botão cadastrar
            JavaScriptAction(Funcao.habilitarElemento, BuscatipoJava.getElementById,"AccountRegisterBtnSubmitHandler",null);

            waitForElementPageToBeClickable(btnCadastrar);

            //Cadastrar
            btnCadastrar.click();

            waitForElementPageToBeClickable(btnFecharModal);
            Thread.sleep(2000);

            //Fechar modal - Siga as Instruções que enviamos no seu e-mail
            btnFecharModal.click();
            //endregion

            //region [Abrir Nova Guia e Navegar para o Gmail]
            //Abre Nova Guia
            JavaScriptAction(Funcao.abrirNovaGuia, null,null,null);

            //Lista todas as guias abertas
            ArrayList<String> tabs = new ArrayList<>(webdriver.getWindowHandles());

            //Move para a guia no Array[1] [0,1] devem estar abertas - Guia Sistema, Guia Gmail
            webdriver.switchTo().window(tabs.get(1));

            //Navega para a Url do Gmail
            webdriver.navigate().to(CriarUsuarioResetarSenhaPage.getUrlGmail());
            //endregion

            //region [Logar no Gmail]
            //Email
            sleep(4000);
            if(LogarGmail) {
                userGmail.sendKeys("roboalelousuario@gmail.com");

                //Prosseguir Usuário
                btnProsseguirUserGmail.click();

                //Senha
                senhaGmail.sendKeys("taking2020");

                //Email de recuperação - michael.alba@outlook.com.br
                //Prosseguir
                btnProsseguirSenhaGmail.click();
            }

            //Verifica confirmação de email e telefone
           /* try {
                if (webdriver.findElement(By.xpath("//*[@id='yDmH0d']/c-wiz[2]/c-wiz/div/div[1]/div/div/div/div[2]/div[3]/div/div[2]/div/span/span")).isDisplayed())
                    webdriver.findElement(By.xpath("//*[@id='yDmH0d']/c-wiz[2]/c-wiz/div/div[1]/div/div/div/div[2]/div[3]/div/div[2]/div/span/span")).click();
            }
            catch (Exception e){}
            */

            Thread.sleep(8000);

            //Clica no primeiro item da tabela de e-mails
            webdriver.findElements(By.name("portalec")).get(1).click();

            //Captura numero de token
            Thread.sleep(10000);
            String token_txt = webdriver.findElements(By.tagName("strong")).get(1).getText().substring(5,11);

            //Deleta Email
            webdriver.navigate().to("https://mail.google.com/mail/u/0/#inbox");
            sleep(3000);
            webdriver.findElement(By.xpath("/html/body/div[7]/div[3]/div/div[2]/div[1]/div[2]/div/div/div/div/div[1]/div/div[1]/div[1]/div/div/div[1]/div/div[1]/span")).click();

            webdriver.findElement(By.xpath("/html/body/div[7]/div[3]/div/div[2]/div[1]/div[2]/div/div/div/div/div[1]/div/div[1]/div[1]/div/div/div[2]/div[3]")).click();
            //endregion

            //region [Volta para Sistema Alelo para Validar o Token]
            //Move para aba(0) Primeira
            webdriver.switchTo().window(tabs.get(0));

            //Imputa o numero do token no campo
            inputTokenAlelo.sendKeys(token_txt);

            //Clica em Validar
            btnValidar.click();
            //endregion

            //region [Preenche o Formulário]
            GeraCpfCnpj cpf = new GeraCpfCnpj();
            String cpfNumber = cpf.cpf(true);
            //Nome
            formNome.sendKeys("nome_robo");

            //Sobrenome
            formSobrenome.sendKeys("sobrenome_robo");

            //CPF
            formCpf.sendKeys(cpfNumber);

            //Senha
            formSenha.sendKeys("Teste@123");

            //Confirme sua Senha
            formConfirmaSenha.sendKeys("Teste@123");

            //Aceitar Termo
            formAceitaTermo.click();

            //Cadastrar
            formCadastrar.click();

            waitForElementPageToBeClickable(btnFazerLoginModal);

            //Modal de Confirmação e Fazer Login
            btnFazerLoginModal.click();
            //endregion

            //region [Login]
            waitForElementPageToBeClickable(loginCpf);
            //CPF
            loginCpf.sendKeys(cpfNumber);

            //Senha
            loginSenha.sendKeys("Teste@123");

            //Entrar
            loginEntrar.click();
            //endregion

            //region [Formulario de Primeiro Acesso]
            //Telefone
            primeiroAcessoTelefone.sendKeys("11960745073");

            if(PID == true) {

                //region [Itens de Retorno do Banco de dados]
                String n_query_randomic = Integer.toString(rand.nextInt(5));
                String queryItens = "with Itens as(SELECT ROW_NUMBER() OVER(ORDER BY doc.nr_documento DESC) row_num, doc.nr_documento, pdc.cd_banco, pdc.nu_agencia, pdc.nu_conta FROM base_unica_cad.documento doc left join base_unica_cad.pessoa_unidade pu on (pu.niu_pessoa = doc.niu_pessoa) left join base_unica_cad.pessoa_domicilio_bancario pdc on (pdc.niu_pessoa = pu.niu_pessoa) WHERE doc.nr_documento in ('28339982000160','41707658000115','37491504000161','12259140000168'))select * from Itens where row_num = "+ n_query_randomic;
                CommonsActions conn_ation = new CommonsActions();
                ResultSet teste = conn_ation.consultaBanco(ConnBuc.getConexao(), queryItens);
                List <String> Itens = new ArrayList<>();
                while (teste.next())
                {
                    String nrDoc = teste.getString("NR_DOCUMENTO");
                    String cdBanco = teste.getString("CD_BANCO");
                    String nuAgencia = teste.getString("NU_AGENCIA");
                    String nuConta = teste.getString("NU_CONTA");
                    Itens.add(nrDoc);
                    Itens.add(cdBanco);
                    Itens.add(nuAgencia);
                    Itens.add(nuConta);
                    break;
                }
                //endregion

                waitForElementPageToBeClickable(primeiroAcessocnpj);

                //CNPJ
                primeiroAcessocnpj.clear();
                primeiroAcessocnpj.sendKeys(Itens.get(0));
                sleep(1000);
                primeiroAcessocnpj.clear();
                primeiroAcessocnpj.sendKeys(Itens.get(0));

                //Banco
                WebElement selectBanco = webdriver.findElement(By.id("formInlineBank"));
                String banco_completo = "";
                for ( WebElement banco : selectBanco.findElements(By.tagName("option")))
                    if (banco.getText().contains(Itens.get(1))) {
                        banco_completo = banco.getText();
                        break;
                    }

                Select selectBanco_ = new Select(primeiroAcessoBanco);
                selectBanco_.selectByVisibleText(banco_completo);
                //primeiroAcessoBanco.

                //Agencia
                primeiroAcessoAgencia.sendKeys(Itens.get(2));

                //Conta
                primeiroAcessoConta.sendKeys(Itens.get(3));

                waitForElementPageToBeClickable(btn_primeiroAcessoConfirmar);

                sleep(2000);

                //Confirmar
                btn_primeiroAcessoConfirmar.click();
                sleep(2000);

                //Confirmar
                btn_primeiroAcessoConfirmar.click();

                waitForElementPageToBeClickable(btn_primeiroAcessoComecar);
                //Começar
                btn_primeiroAcessoComecar.click();

                webdriver.switchTo().window(tabs.get(0));
                sleep(3000);
            }
            //endregion

            //Novo usuário cadastrado com sucesso...

            //region [Troca de Senha]
            if(TrocaSenha == true) {
                //Botao canto superior ( Navbar ) ( Icone Usuário )
                waitForElementPageToBeClickable(btn_iconProfileId);
                btn_iconProfileId.click();

                //Botao canto superior ( Navbar ) ( Icone Usuário ) ( Opção: Sair )
                waitForElementPageToBeClickable(btn_iconProfileIdSair);
                btn_iconProfileIdSair.click();

                //Botão Esqueci minha senha
                waitForElementPageToBeClickable(btn_esqueciMinhaSenha);
                btn_esqueciMinhaSenha.click();

                //CPF
                waitForElementPageToBeClickable(cpfEsqueciMinhaSenha);
                cpfEsqueciMinhaSenha.sendKeys(cpfNumber);

                //Remove o elemento Captcha da tela
                JavaScriptAction(Funcao.deletarElement, BuscatipoJava.getElementsByClassName,"clearfix",null);

                //Remove o Atributo Disabled do botão Cadastrar - Feito após deletar o captcha - Habilita o botão cadastrar
                JavaScriptAction(Funcao.habilitarElemento, BuscatipoJava.getElementById,"submitButton",null);


                waitForElementPageToBeClickable(webdriver.findElement(By.id("submitButton")));

                //Cadastrar
                webdriver.findElement(By.id("submitButton")).click();

                waitForElementPageToBeClickable(btnFecharModal);

                //Fechar modal - Siga as Instruções que enviamos no seu e-mail
                btnFecharModal.click();

                //Move para a guia no Array[1] [0,1] devem estar abertas - Guia Sistema, Guia Gmail
                webdriver.switchTo().window(tabs.get(1));

                //Clica no primeiro item da tabela de e-mails
                webdriver.navigate().to("https://mail.google.com/mail/u/0/#inbox");
                sleep(5000);
                webdriver.findElements(By.name("portalec")).get(1).click();

                //Captura numero de token
                Thread.sleep(10000);
                token_txt = webdriver.findElements(By.tagName("strong")).get(1).getText().substring(5,11);

                //Deleta Email
                webdriver.navigate().to("https://mail.google.com/mail/u/0/#inbox");
                sleep(3000);
                webdriver.findElement(By.xpath("/html/body/div[7]/div[3]/div/div[2]/div[1]/div[2]/div/div/div/div/div[1]/div/div[1]/div[1]/div/div/div[1]/div/div[1]/span")).click();

                webdriver.findElement(By.xpath("/html/body/div[7]/div[3]/div/div[2]/div[1]/div[2]/div/div/div/div/div[1]/div/div[1]/div[1]/div/div/div[2]/div[3]")).click();
                //endregion

                //region [Volta para Sistema Alelo para Validar o Token]
                //Move para aba(0) Primeira
                webdriver.switchTo().window(tabs.get(0));

                //Imputa o numero do token no campo
                inputTokenAlelo.sendKeys(token_txt);

                //Clica em Validar
                btnValidar.click();
                //endregion

                waitForElementPageToBeClickable(webdriver.findElement(By.id("password")));

                //Senha
                webdriver.findElement(By.id("password")).sendKeys("Resetsenha@123");

                //Confirmar Senha
                webdriver.findElement(By.id("passwordConfirm")).sendKeys("Resetsenha@123");

                //Cadastrar
                webdriver.findElement(By.id("submitButton")).click();
            }

            for (int i = 0 ; i < associarCNPJS ; i++)
            {
                Thread.sleep(6000);
                //Clica em Meus CNPJS
                meusCNPJSMenuPortal.click();
                Thread.sleep(4000);
                //Adicionar CNPJS
                btnAdicionarCNPJSPortal.click();
                //region [Itens de Retorno do Banco de dados]
                String n_query_randomic = Integer.toString(rand.nextInt(4));
                String queryItens = "with Itens as(SELECT ROW_NUMBER() OVER(ORDER BY doc.nr_documento DESC) row_num, doc.nr_documento, pdc.cd_banco, pdc.nu_agencia, pdc.nu_conta FROM base_unica_cad.documento doc left join base_unica_cad.pessoa_unidade pu on (pu.niu_pessoa = doc.niu_pessoa) left join base_unica_cad.pessoa_domicilio_bancario pdc on (pdc.niu_pessoa = pu.niu_pessoa) WHERE doc.nr_documento in ('28339982000160','41707658000115','37491504000161','12259140000168'))select * from Itens where row_num = "+ n_query_randomic;
                CommonsActions conn_ation = new CommonsActions();
                ResultSet teste = conn_ation.consultaBanco(ConnBuc.getConexao(), queryItens);
                List <String> Itens = new ArrayList<>();
                while (teste.next())
                {
                    String nrDoc = teste.getString("NR_DOCUMENTO");
                    String cdBanco = teste.getString("CD_BANCO");
                    String nuAgencia = teste.getString("NU_AGENCIA");
                    String nuConta = teste.getString("NU_CONTA");
                    Itens.add(nrDoc);
                    Itens.add(cdBanco);
                    Itens.add(nuAgencia);
                    Itens.add(nuConta);
                    break;
                }
                //endregion

                waitForElementPageToBeClickable(primeiroAcessocnpj);

                //CNPJ
                primeiroAcessocnpj.clear();
                primeiroAcessocnpj.sendKeys(Itens.get(0));
                sleep(1000);
                primeiroAcessocnpj.clear();
                primeiroAcessocnpj.sendKeys(Itens.get(0));

                //Banco
                WebElement selectBanco = webdriver.findElement(By.id("formInlineBank"));
                String banco_completo = "";
                for ( WebElement banco : selectBanco.findElements(By.tagName("option")))
                    if (banco.getText().contains(Itens.get(1))) {
                        banco_completo = banco.getText();
                        break;
                    }

                Select selectBanco_ = new Select(primeiroAcessoBanco);
                selectBanco_.selectByVisibleText(banco_completo);
                //primeiroAcessoBanco.

                //Agencia
                primeiroAcessoAgencia.sendKeys(Itens.get(2));

                //Conta
                primeiroAcessoConta.sendKeys(Itens.get(3));

                waitForElementPageToBeClickable(btnConfirmarCNPJSPortal);

                sleep(2000);

                //Confirmar
                btnConfirmarCNPJSPortal.click();

                webdriver.findElement(By.id("buttonBottomPrint")).click();

            }


            //endregion
            if(tabs.size() > 1) {
                webdriver.switchTo().window(tabs.get(1));
                JavaScriptAction(Funcao.fecharGuia, null, null, null);
                webdriver.switchTo().window(tabs.get(0));
            }

        } catch (Exception e) {
            System.out.println("Message: " + e.getMessage() + "Trace: " + e.getStackTrace());
            ArrayList<String> tabs = new ArrayList<>(webdriver.getWindowHandles());
            if(tabs.size() > 1) {
                webdriver.switchTo().window(tabs.get(1));
                JavaScriptAction(Funcao.fecharGuia, null, null, null);
                webdriver.switchTo().window(tabs.get(0));
            }
        }
    }

    public boolean ValidaResultado(String cenario, String mensagem) throws InterruptedException {
        try {
            switch (cenario) {
                case "Criação de novo usuário sem PID":
                    if(!primeiroAcessocnpj.isDisplayed())return false;
                    break;
                case "Criação de novo usuário com PID":
                    if(!btn_iconProfileId.isDisplayed())return false;
                    break;
                case "Alteração de senha de novo usuário":

                    break;
                default:
                    System.out.print("Cenário não encontrado na [ Feature ]");
                    break;
            }
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
}
