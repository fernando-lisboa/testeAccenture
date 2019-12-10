#language: pt
#/**
# * Autor: Fernando Lisboa
# * Empresa: Taking
# * Data: 06/12/2019
# * Caminho: Portal Estabelecimento Comercial 
# */

@Configuracoes @front @Regressao
Funcionalidade: Configuracoes
    Permite inserção e manutenção dos estabelecimentos que o usuário possui acesso

    Eu como usuario
    Quero inserir, visualizar, editar e excluir os estabelecimentos que administro
    Para manter os dados da minha conta atualizados

    Contexto: 
        Dado que estou logado no Portal EC
        
    @Release-15
	  @portalEC
	  @#felipe_lourenco
	  @inserir_novo_estabeleciomento_superior
    Cenario: Inserir novo estabelecimento superior com sucesso
        Dado que estou na pagina Configuracoes
        Quando aciono o botao Adicionar CNPJ superior
        E insiro as informacoes no formulario dados bancarios
        E aciono o botao Confirmar
        Entao o Portal EC me redireciona para a pagina de configuracoes com o novo estabelecimento inserido
        
    @Release-15
	  @portalEC
	  @#felipe_lourenco
	  @inserir_novo_estabeleciomento_inferior
    Cenario: Inserir novo estabelecimento inferior com sucesso
        Dado que estou na pagina Configuracoes
        Quando aciono o botao Adicionar CNPJ inferior
        E insiro as informacoes no formulario dados bancarios
        E aciono o botao Confirmar
        Entao o Portal EC me redireciona para a pagina de configuracoes com o novo estabelecimento inserido
    
    @Release-15
	  @portalEC
	  @#felipe_lourenco
	  @inserir_novo_estabeleciomento_dados_invalidos
    Cenario: Inserir novo estabelecimento utilizando dados invalidos
        Dado que estou na pagina Configuracoes
        Quando aciono o botao Adicionar CNPJ 
        E insiro as informacoes no formulario dados bancarios invalidos
        E aciono o botao Confirmar
        Entao o Portal EC apresenta uma mensagem de erro
        
       