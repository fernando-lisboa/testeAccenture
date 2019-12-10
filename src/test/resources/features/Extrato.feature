#language: pt
#/**
# * Autor: Fernando Lisboa
# * Empresa: Taking
# * Data: 06/12/2019
# * Caminho: Portal Estabelecimento Comercial 
# */

@Extrato @front @Regressao
Funcionalidade: Extrato
    Permite a conferencia sobre as transações realizadas nos estabelecimentos que o usuário possui acesso

    Eu como Estabelecimento Comercial
		Desejo acessar o extrato das transações dos cartões Alelo
		Para visualizar o detalhamento das minhas vendas e cobranças

    Contexto: 
        Dado que estou logado no Portal EC
        E clico na aba Extrato
        
  @Release-15
	@portalEC
	@#felipe_lourenco
	@selecionar_periodo
  Cenario: Selecionar um periodo
    Quando seleciono um periodo
    E clico no botao ok
    Entao o sistema renderiza as transacoes em tela
    
  @Release-15
	@portalEC
	@#felipe_lourenco
	@validar_detalhamento_vendas
  Cenario: Validar o detalhamento de vendas do extrato
    Quando seleciono um periodo
    E clico no botao ok
    E clico em uma linha de vendas
    Entao o sistema mostra o detalhamento das vendas do dia
    
  @Release-15
	@portalEC
	@#felipe_lourenco
	@validar_detalhamento_outras_transacoes
  Cenario: Validar o detalhamento de outras transacoes do extrato 
    Quando seleciono um periodo
    E clico no botao ok
    E clico em uma linha de outras transacoes
    Entao o sistema mostra o detalhamento de outras transacoes do dia
    
  @Release-15
	@portalEC
	@#felipe_lourenco
	@validar_busca_numero_cartao
  Cenario: Validar campo de busca por numero de cartao 
    Quando seleciono um periodo
    E clico no botao ok
    E busco transacoes pelo numero do cartao
    Entao o sistema tras somente resultados referentes ao numero pesquisado
    
  @Release-15
	@portalEC
	@#felipe_lourenco
	@baixar_extrato_PDF_superior
  Cenario: Baixar extrato comprovante em PDF - superior
  	Quando seleciono um periodo
  	E clico no botao ok
  	E clico no botao de download PDF - superior
    Entao o sistema baixa o PDF

  @Release-15
	@portalEC
	@#felipe_lourenco
	@baixar_extrato_PDF_inferior
  Cenario: Baixar extrato comprovante em PDF - inferior 
    Quando seleciono um periodo
    E clico no botao ok
  	E clico no botao de download PDF - inferior
    Entao o sistema baixa o PDF
    
  @Release-15
	@portalEC
	@#felipe_lourenco
	@baixar_extrato_CSV_superior
  Cenario: Baixar extrato comprovante em CSV - superior 
   	Quando seleciono um periodo
   	E clico no botao ok
  	E clico no botao de download CSV - superior
    Entao o sistema baixa o CSV
    
  @Release-15
	@portalEC
	@#felipe_lourenco
	@baixar_extrato_CSV_inferior
  Cenario: Baixar extrato comprovante em CSV - inferior 
    Quando seleciono um periodo
    E clico no botao ok
  	E clico no botao de download CSV - inferior
    Entao o sistema baixa o CSV
    
  @Release-15
	@portalEC
	@#felipe_lourenco
	@imprimir_extrato_superior
  Cenario: Imprimir extrato - superior
    Quando seleciono um periodo
    E clico no botao ok
  	E clico no botao de Imprimir extrato - superior
    Entao o sistema imprime o extrato
    
  @Release-15
	@portalEC
	@#felipe_lourenco
	@imprimir_extrato_inferior
  Cenario: Imprimir comprovante - inferior
   	Quando seleciono um periodo
   	E clico no botao ok
  	E clico no botao de Imprimir extrato - inferior
   	Entao o sistema imprime o extrato
   
  @Release-22
	@portalEC
	@#samuel_milani
	@logar_acessar_api_Extrato
  Cenario: Validar informacoes da API de extrato
   	Dado que informo os parametros de Login da api
   	E executo o comando get com access token com usuario de extrato
    Quando executo o comando get com access token na api de extrato
		Entao valido o retorno da api
		E imprimo a resposta
	
	@Release-22
	@portalEC
	@#samuel_milani
	@logar_acessar_api_Extrato_diario
  Cenario: Validar informacoes da API de extrato
   	Dado que informo os parametros de Login da api
   	E executo o comando get com access token com usuario de extrato
    Quando executo o comando get com access token na api de extrato diario
		Entao valido o retorno da api
		E imprimo a resposta