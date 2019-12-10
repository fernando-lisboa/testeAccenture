#language: pt
#/**
# * Autor: Fernando Lisboa
# * Empresa: Taking
# * Data: 06/12/2019
# * Caminho: Portal Estabelecimento Comercial 
# */

@Planos @front @Regressao
Funcionalidade: Planos
  Permite realizar a contratação de planos
    
  Eu como usuario 
  Quero contratar planos para o meu estabelecimento 
  Para ter a flexibilidade de receber quando necessito

  Contexto: 
    Dado que estou logado em qualquer tela do Portal EC

  @Release-15
	@portalEC
	@#felipe_lourenco
	@realizar_contratacao_1
  Cenario: Realizar contratacao 1 com sucesso
    Quando clico no SideKick no menu expansivel lateral de contratacao
    E seleciono a opcao 1
    E clico em Aceitar Termos
    E clico em Contratar
    Entao o Portal EC realiza a contratacao
  
  @Release-15
	@portalEC
	@#felipe_lourenco
	@realizar_contratacao_2
  Cenario: Realizar contratacao 2 com sucesso
    Quando clico no SideKick no menu expansivel lateral de contratacao
    E seleciono a opcao 2
    E clico em Aceitar Termos
    E clico em Contratar
    Entao o Portal EC realiza a contratacao
  
  @Release-15
	@portalEC
	@#felipe_lourenco
	@realizar_contratacao_3
  Cenario: Realizar contratacao 3 com sucesso
    Quando clico no SideKick no menu expansivel lateral de contratacao
    E seleciono a opcao 3
    E clico em Aceitar Termos
    E clico em Contratar
    Entao o Portal EC realiza a contratacao

  @Release-15
	@portalEC
	@#felipe_lourenco
	@cancelar_contratacao
  Cenario: Cancelar contratacao de planos
   	Quando clico no SideKick no menu expansivel lateral de contratacao
    E seleciono uma opcao
    E clico em Aceitar Termos
    E clico em Cancelar contratacao
    Entao o Portal EC cancela a antecipacao
  
  @Release-15
	@portalEC
	@#felipe_lourenco
	@fechar_contratacao
  Cenario: Fechar contratacao de planos
   	Quando clico no SideKick no menu expansivel lateral de contratacao
    E seleciono uma opcao
    E clico em Aceitar Termos
    E clico no botao Fechar contratacao
    Entao o Portal EC fecha o modal da contratacao
 
	@Release-22
	@portalEC
	@api
	@#samuel_milani
	@logar_acessar_api_sidekick_planos
  Cenario: Validar informacoes da API do Sidekick de Planos
   	Dado que informo os parametros de Login da api
   	E que realizo o post para obter o access token
    Quando executo o comando get com access token na api do Sidekick de Planos
		Entao valido o retorno da api
		E imprimo a resposta