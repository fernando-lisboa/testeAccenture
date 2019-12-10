#language: pt
#/**
# * Autor: Fernando Lisboa
# * Empresa: Taking
# * Data: 06/12/2019
# * Caminho: Portal Estabelecimento Comercial
# */

@Agenda @front @Regressao
Funcionalidade: Agenda
  Permite a consulta dos valores a serem disponibilizados ao usuario ao longo do mes

  Contexto: 
    Dado que estou logado no Portal EC

  @Release-15 
  @portalEC 
  @#felipe_lourenco 
  @realizar_consulta_dia_atual
  Cenario: Realizar consulta do dia atual com sucesso
    Quando que estou na tela Agenda
    E seleciono o campo correspondente ao dia atual
    Entao o Portal EC apresenta a tela de Extrato do respectivo dia

  @Release-15 
  @portalEC 
  @#felipe_lourenco
  @realizar_consulta_agenda_avançar
  Cenario: Realizar consulta em Agenda com botao Avancar
    Quando que estou na tela Agenda
    E seleciono o botao avancar no mes
    Entao o Portal EC apresenta a tela de Agenda do respectivo mes

  @Release-15 
  @portalEC 
  @#felipe_lourenco 
  @realizar_consulta_agenda_retroceder
  Cenario: Realizar consulta em Agenda com botao Retroceder
    Quando que estou na tela Agenda
    E seleciono o botao retroceder no mes
    Entao o Portal EC apresenta a tela de Agenda do respectivo mes

  @Release-15 
  @portalEC 
  @#felipe_lourenco
	@acessar_consulta_agenda_painel
  Cenario: Acessar a tela Agenda atraves do painel
    Quando estou na home page
    E clico no botao Veja mais detalhes
    Entao o Portal EC apresenta a tela de agenda

  @Release-15 
  @portalEC 
  @#felipe_lourenco 
  @validar_link_banner_esquerdo
  Cenario: Validar link do banner superior esquerdo com sucesso
    Quando que estou na tela Agenda
    E clico no banner esquerdo
    Entao o sistema redireciona para a tela marketing cadastrada esquerdo

  @Release-15 
  @portalEC 
  @#felipe_lourenco 
  @validar_link_banner_direito
  Cenario: Validar link do banner superior direito com sucesso
    Quando que estou na tela Agenda
    E clico no banner direito
    Entao o sistema redireciona para a tela marketing cadastrada direito

  @Release-15 
  @portalEC 
  @#felipe_lourenco 
  @realizar_extracao_PDF_superior
  Cenario: Extrair comprovante em PDF - superior
    Quando que estou na tela Agenda
    E seleciono o campo correspondente ao dia atual
    E clico no botao comprovantes
    E clico no botao Baixar em PDF superior
    Entao o sistema baixa o extrato em PDF

  @Release-15 
  @portalEC 
  @#felipe_lourenco 
  @realizar_extracao_PDF_inferior
  Cenario: Extrair comprovante em PDF - inferior
    Quando que estou na tela Agenda
    E seleciono o campo correspondente ao dia atual
    E clico no botao comprovantes
    E clico no botao Baixar em PDF inferior
    Entao o sistema baixa o extrato em PDF

  @Release-15 
  @portalEC 
  @#felipe_lourenco
  @realizar_extracao_CSV_superior
  Cenario: Extrair comprovante em CSV - superior
    Quando que estou na tela Agenda
    E seleciono o campo correspondente ao dia atual
    E clico no botao comprovantes
    E clico no botao Baixar em CSV superior
    Entao o sistema baixa o extrato em CSV

  @Release-15 
  @portalEC 
  @#felipe_lourenco 
  @realizar_extracao_CSV_inferior
  Cenario: Extrair comprovante em CSV - inferior
    Quando que estou na tela Agenda
    E seleciono o campo correspondente ao dia atual
    E clico no botao comprovantes
    E clico no botao Baixar em CSV inferior
    Entao o sistema baixa o extrato em CSV

  @Release-15 
  @portalEC 
  @#felipe_lourenco 
  @imprimir_comprovante_superior
  Cenario: Imprimir comprovante - superior
    Quando que estou na tela Agenda
    E seleciono o campo correspondente ao dia atual
    E clico no botao comprovantes
    E clico no botao Imprimir comprovante superior
    Entao o sistema imprime o comprovante

  @Release-15 
  @portalEC 
  @#felipe_lourenco 
  @imprimir_comprovante_inferior
  Cenario: Imprimir comprovante - inferior
    Quando que estou na tela Agenda
    E seleciono o campo correspondente ao dia atual
    E clico no botao comprovantes
    E clico no botao Imprimir comprovante inferior
    Entao o sistema imprime o comprovante

  @Release-22
	@portalEC
	@#samuel_milani
	@logar_acessar_api_Agenda
  Cenario: Validar informacoes da API de agenda
   	Dado que informo os parametros de Login da api
   	E que realizo o post para obter o access token
    Quando executo o comando get com access token na api de Agenda
		Entao valido o retorno da api
		E imprimo a resposta
		
	@Release-22
	@portalEC
	@api
	@#samuel_milani
	@logar_acessar_api_Transacoes_dia_Agenda
  Cenario: Validar informacoes da API de Transacoes do dia na agenda
   	Dado que informo os parametros de Login da api
   	E que realizo o post para obter o access token
   	E realizo o comando get na api de agenda para obter os parametros nescessarios
    Quando executo o comando get com access token na api de Transacoes do dia na Agenda
		Entao valido o retorno da api
		E imprimo a resposta
		
	@Release-22
	@portalEC
	@api
	@#samuel_milani
	@logar_acessar_api_Comprovante_diario_Agenda
  Cenario: Validar informacoes da API de Comprovante diario da agenda
   	Dado que informo os parametros de Login da api
   	E que realizo o post para obter o access token
   	E realizo o comando get na api de agenda para obter os parametros nescessarios
   	E realizo o comando get na api de transacoes para obter um comprovante
    Quando executo o comando get com access token na api do comprovante diario da Agenda
		Entao valido o retorno da api
		E imprimo a resposta