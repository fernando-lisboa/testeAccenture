#language: pt
#/**
# * Autor: Fernando Lisboa
# * Empresa: Taking
# * Data: 06/12/2019
# * Caminho: Portal Estabelecimento Comercial - loggof
# */

@Sair @front @Regressao 
Funcionalidade: Sair
    Permite ao usuario se deslogar da ferramenta

    Eu como usuario
    Quero me deslogar do Portal EC
    Para impedir que minha sessao possa ser reutilizada por terceiros não autorizados

    Contexto: 
        Dado que estou logado no Portal EC
		 
		@Release-15
	  @portalEC
	  @#felipe_lourenco
	  @realizar_loggof
    Cenario: Realizar loggof com sucesso
        Dado que estou em qualquer pagina da area logada do portal EC
        Quando aciono o botao de usuario
        E aciono a opcao Sair apresentada no menu
        Entao o Portal EC desloga a sessao e redireciona o usuario para a area nao logada

