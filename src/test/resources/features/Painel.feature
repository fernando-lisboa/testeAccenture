#language: pt
#/**
# * Autor: Fernando Lisboa
# * Empresa: Taking
# * Data: 06/12/2019
# * Caminho: Portal Estabelecimento Comercial 
# */

@Painel @front @Regressao @Regressao
Funcionalidade: Painel
  Permite a realizacao de navegacao no Portal EC

	Eu como usuario
  Quero navegar no sistema
  Para validar informacoes respectivas da Home Page
    
  Contexto:
    Dado que estou na logado no portal EC
    Quando acesso o painel no menu 
    
  @Release-15
  @portalEC
	@#felipe_lourenco
	@alterar_cnpj_combo_selecao
  Cenario: Alterar o CNPJ no combo selecao com Sucesso
    E seleciono um CNPJ diferente no combo Estabelecimento
    Entao o painel carrega as informacoes respectivas ao CNPJ selecionado
    
  @Release-15
  @portalEC
	@#felipe_lourenco
	@validar_link_banner_superior
  Cenario: Validar link do banner superior
    E clico no banner superior
    Entao o sistema redireciona para a tela marketing cadastrada superior
  
  @Release-15
  @portalEC
	@#felipe_lourenco
	@validar_link_banner_inferior
  Cenario: Validar link dos banners inferiores
    E clico nos banners inferiores
    Entao o sistema redireciona para a tela marketing cadastrada inferior
    
  @Release-15
  @portalEC
	@#felipe_lourenco
	@validar_rodape_redes_sociais_twitter
  Cenario: Validar link das redes sociais Twitter
  	E clico na imagem correspondente ao Twitter
  	Entao o sistema redireciona para a url da Alelo no Twitter
  
  @Release-15
  @portalEC
	@#felipe_lourenco
	@validar_rodape_redes_sociais_facebook
  Cenario: Validar link das redes sociais facebook
  	E clico na imagem correspondente ao Facebook
  	Entao o sistema redireciona para a url da Alelo no Facebook
  
  @Release-15
  @portalEC
	@#felipe_lourenco
	@validar_rodape_redes_sociais_linkedin
  Cenario: Validar link das redes sociais linkedin
    E clico na imagem correspondente ao Linkedin
  	Entao o sistema redireciona para a url da Alelo no Linkedin
    
  @Release-15
  @portalEC
	@#samuel_milani
	@validar_sidekick_arv
  Cenario: Validar Side-Kick de ARV com EC com saldo e sem plano
  	E seleciono um CNPJ diferente que tenha ARV no combo Estabelecimento
  	Entao o sistema apresenta o sidekick de ARV
  	
  @Release-15
  @portalEC
	@#samuel_milani
	@validar_sidekick_plano_sem_saldo
  Cenario: Validar Side-Kick de Planos com EC sem saldo e com plano
  	E seleciono um CNPJ diferente que tenha plano e sem saldo no combo Estabelecimento
  	Entao o sistema apresenta o sidekick de Planos
  	
  @Release-15
  @portalEC
	@#samuel_milani
	@validar_sidekick_plano_com_saldo
  Cenario: Validar Side-Kick de Planos com EC sem saldo e com plano
  	E seleciono um CNPJ diferente que tenha plano e com saldo no combo Estabelecimento
  	Entao o sistema apresenta o sidekick de Planos
  	
  @Release-15
  @portalEC
	@#samuel_milani
	@validar_sem_sidekick
  Cenario: Validar Side-Kick de Planos com EC sem saldo e com plano
  	E seleciono um CNPJ diferente que nao tenha plano ou saldo no combo Estabelecimento
  	Entao o sistema nao apresenta o sidekick
    
  @Release-22
	@portalEC
	@api
	@#samuel_milani
	@logar_acessar_sistema
  Cenario: Validar informacoes da API inicial
   	Dado que informo os parametros de Login da api
   	E que realizo o post para obter o access token
    Quando executo o comando get com access token
		Entao valido o retorno da api
		E imprimo a resposta