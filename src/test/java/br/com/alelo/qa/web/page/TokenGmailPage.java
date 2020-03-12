package br.com.alelo.qa.web.page;


import br.com.alelo.qa.features.support.JavaScriptUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class TokenGmailPage extends JavaScriptUtils {

    public TokenGmailPage(WebDriver driver) {
        super(driver);
        // TODO Auto-generated constructor stub
    }
    //region [Sistema Alelo]

    //region WebElement [Endereço de Email]
      @FindBy(id = "emailAddress")
      public static WebElement enderecoEmail;
    //endregion

    //region WebElement [Botão Cadastrar]
    @FindBy(id = "AccountRegisterBtnSubmitHandler")
    public static WebElement btnCadastrar;
    //endregion

    //region WebElement [Botão Fechar Modal]
    @FindBy(xpath = "//*[@id='customBtnCloseModal-success']/button")
    public static WebElement btnFecharModal;
    //endregion

    //region WebElement [Input Token]
    @FindBy(id = "otppswd")
    public static WebElement inputTokenAlelo;
    //endregion

    //region WebElement [Botão Validar]
    @FindBy(id = "btnSubmitHandlerCreate")
    public static WebElement btnValidar;
    //endregion

    //region WebElement [Formulário de Cadastro]
    //region WebElement [Nome]
    @FindBy(id = "firstName")
    public static WebElement formNome;
    //endregion

    //region WebElement [Sobrenome]
    @FindBy(id = "surname")
    public static WebElement formSobrenome;
    //endregion

    //region WebElement [CPF]
    @FindBy(id = "username")
    public static WebElement formCpf;
    //endregion

    //region WebElement [Senha]
    @FindBy(id = "passwordInput")
    public static WebElement formSenha;
    //endregion

    //region WebElement [Confirmar Senha]
    @FindBy(id = "passwordConfirm")
    public static WebElement formConfirmaSenha;
    //endregion

    //region WebElement [Aceita Termo]
    @FindBy(id = "acceptTerm")
    public static WebElement formAceitaTermo;
    //endregion

    //region WebElement [Cadastrar]
    @FindBy(id = "submitButton")
    public static WebElement formCadastrar;
    //endregion

    //region WebElement [Botão Fazer Login Modal]
    @FindBy(xpath = "//*[@id=\"customBtnCloseModal-success\"]/a")
    public static WebElement btnFazerLoginModal;
    //endregion

    //region WebElement [Login CPF]
    @FindBy(id = "cpf")
    public static WebElement loginCpf;
    //endregion

    //region WebElement [Login Senha]
    @FindBy(id = "password")
    public static WebElement loginSenha;
    //endregion

    //region WebElement [Login Entrar]
    @FindBy(id = "AccountLoginBtnSubmitHandler")
    public static WebElement loginEntrar;
    //endregion

    //region WebElement [Primeiro Acesso - Telefone]
    @FindBy(id = "formInlinePhone")
    public static WebElement primeiroAcessoTelefone;
    //endregion
    //endregion

    //region [Formulário de Primeiro Acesso]
    //region WebElement [Primeiro Acesso - CNPJ]
    @FindBy(name = "cnpj")
    public static WebElement primeiroAcessocnpj;
    //endregion

    //region WebElement [Primeiro Acesso - Banco]
    @FindBy(id = "formInlineBank")
    public static WebElement primeiroAcessoBanco;
    //endregion

    //region WebElement [Primeiro Acesso - Agência]
    @FindBy(id = "formInlineAgency")
    public static WebElement primeiroAcessoAgencia;
    //endregion

    //region WebElement [Primeiro Acesso - Conta]
    @FindBy(id = "formInlineCount")
    public static WebElement primeiroAcessoConta;
    //endregion

    //region WebElement [Primeiro Acesso - Btn Confirmar]
    @FindBy(id = "accountValidateBtnHandle")
    public static WebElement btn_primeiroAcessoConfirmar;
    //endregion

    //region WebElement [Primeiro Acesso - Btn Começar]
    @FindBy(id = "buttonBottomPrint")
    public static WebElement btn_primeiroAcessoComecar;
    //endregion

    //region WebElement [Resetar Senha - Btn Icone_Sair]
    @FindBy(id = "iconProfileId")
    public static WebElement btn_iconProfileId;
    //endregion

    //region WebElement [Resetar Senha - Btn Icone_Sair]
    @FindBy(id = "navbarDesktopSair")
    public static WebElement btn_iconProfileIdSair;
    //endregion

    //region WebElement [Resetar Senha - Btn esqueci a minha senha]
    @FindBy(className = "btnForgotPassword")
    public static WebElement btn_esqueciMinhaSenha;
    //endregion

    //region WebElement [Resetar Senha - Input CPF]
    @FindBy(id = "username")
    public static WebElement cpfEsqueciMinhaSenha;
    //endregion



    //endregion

    //endregion

    //region [Gmail]

    //region String [URL Gmail]
    public static String urlGmail = "https://www.gmail.com";
    public static String getUrlGmail() {
        return urlGmail;
    }
    //endregion

    //region WebElement [User Gmail]
    @FindBy(id = "identifierId")
    public static WebElement userGmail;
    //endregion

    //region WebElement [Botão Proximo Gmail -> usuario]
    @FindBy(xpath = "//*[@id='identifierNext']/span/span")
    public static WebElement btnProsseguirUserGmail;
    //endregion

    //region WebElement [Senha Gmail]
    @FindBy(xpath = "//*[@id='password']/div[1]/div/div[1]/input")
    public static WebElement senhaGmail;
    //endregion

    //region WebElement [Botão Proximo Gmail -> senha]
    @FindBy(xpath = "//*[@id='passwordNext']/span/span")
    public static WebElement btnProsseguirSenhaGmail;
    //endregion

    //endregion

/*



    @FindBy(id = "navbarDesktopSair")
    protected WebElement botaoSair;

    @FindBy(id = "nav-dropdown")
    protected WebElement botaoPerfil;*/

}
