#language: pt
#/**
# * Autor: Fernando Lisboa
# * Empresa: Taking
# * Data: 06/12/2019
# * Caminho: IBM Security Access Manager
# */

@ISAM @front @Regressao
Funcionalidade: IBM Security Access Manager
    Permite ao usuario se acabe com a sessão aberta na ferramenta IBM
    
    Eu como usuario
    Quero remover a sessão aberta no ISAM utilizando o login do Portal EC
    Para impedir que o portal atinja o limite de acesso

		@ISAM
	  @portalEC
	  @#felipe_lourenco
	  @logar_ISAM
    Cenario: Remover sessao ativa no ISAM
        Dado que estou na tela de login IBM
        Quando preencho nome de usuario e senha
        E clico no botao login
        Entao o usuario e redirecionado para a pagina inicial do ISAM
        
    @ISAM
	  @portalEC
	  @#felipe_lourenco
	  @remover_sessao_ISAM
    Cenario: Remover sessao ativa no ISAM
        Dado que estou logado na plataforma
        Quando removo todas as sessos ativas
        Entao os usuarios ficam livres para acesso ao Portal EC
