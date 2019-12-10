#language: pt
#/**
# * Autor: Fernando Lisboa
# * Empresa: Taking
# * Data: 06/12/2019
# * Caminho: Portal Estabelecimento Comercial 
# */

@Credenciamento @front @Regressao
Funcionalidade: Credenciamento
	Validar o fluxo de credenciamento no portal Meu Estabelecimento
	
	Eu como proprietario de um estabelecimento
	Desejo realizar o cadastro no site 
	Para habilitar os produtos Alelo no meu estabelecimento
	
  Contexto:
	Dado que estou no portal meu estabelecimento
	

 @Release-01
 @portalEC
 @#lucas_nascimento
 @credenciamento_dois_proprietarios
  	Cenario: Sistema realiza o credenciamento do estabelecimento com dois proprietarios
  	Quando informo os dados do formulario 
  	E adiciono um segundo proprietario
  	E informo os demais dados
  	Entao o sistema realiza o credenciamento do estabelecimento


 @Release-01
 @portalEC
 @#lucas_nascimento
 @credenciamento_tres_proprietario
  	Cenario: Sistema realiza o credenciamento do estabelecimento com tres proprietarios
  	Quando informo os dados do formulario 
  	E adiciono um terceiro proprietario
  	E informo os demais dados
  	Entao o sistema realiza o credenciamento do estabelecimento


 @Release-01
 @portalEC
 @#lucas_nascimento
 @credenciamento_dois_enderecos
  	Cenario: Realizar o credenciamento com outro endereco de correspondencia
  	Quando informo os dados do formulario 
  	E seleciono outro endereco de correspondencia
  	E informo os demais dados
  	Entao o sistema realiza o credenciamento do estabelecimento


 @Release-01
 @portalEC
 @#lucas_nascimento
 @credenciamento_sem_pat
  	Cenario: Sistema realiza o credenciamento do estabelecimento no sistema sem preenchimento do PAT
  	Quando informo os dados do formulario sem habilitar PAT
  	E seleciono um cartao concordando com os termos 
  	Entao o sistema realiza o credenciamento do estabelecimento
  
  
 @Release-01
 @portalEC
 @#lucas_nascimento
 @credenciamento_com_pat
  	Cenario: Sistema realiza o credenciamento do estabelecimento no sistema com preenchimento do PAT
  	Quando informo os dados do formulario 
  	E informo os demais dados
  	Entao o sistema realiza o credenciamento do estabelecimento


 @Release-01
 @portalEC
 @#lucas_nascimento
 @preenchimento_automatico_cep
  	Cenario: Validacao do preenchimento automatico do CEP
  	Quando informo o CEP
  	Entao os campos com preenchimento automatico sao preenchidos
  	E os campos sem preenchimento automatico nao sao preenchidos


 @Release-01
 @portalEC
 @#lucas_nascimento 
 @exibe_um_cartao
  	Esquema do Cenario: Sistema exibe apenas um tipo de cartao na etapa de condicoes de recebimento
  	Quando informo os dados do formulario informando um cnae relacionado a <cartao>
  	E clico no botao proximo passo do formulario 
  	Entao o sistema exibe o tipo de cartao <tipo>

  Exemplos:
  | cartao | tipo |
  | multibeneficios |multibeneficios |
  | auto |auto |


 @Release-01
 @portalEC
 @#lucas_nascimento 
 @exibe_dois_cartoes
  	Esquema do Cenario: Sistema exibe dois tipos de cartoes de acordo com o CNAE 
  	Quando informo os dados do formulario com um cnae relacionado a <opcao1> <opcao2>
  	E clico no botao proximo passo do formulario 
  	Entao o sistema exibe os tipos de cartoes <tipo1> <tipo2> 

  Exemplos:
  |opcao1|opcao2|tipo1|tipo2|
  |refeicao|alimentacao|refeicao|alimentacao|
  |refeicao|multibeneficios|refeicao|multibeneficios|
  |multibeneficios|auto|multibeneficios|auto|
   
   
 @Release-01
 @portalEC
 @#lucas_nascimento 
 @exibe_tres_cartoes
  	Cenario: Sistema exibe tres tipos de cartoes de acordo com o CNAE 
  	Quando informo os dados do formulario com um cnae relacionado a tres tipos de cartoes
  	E clico no botao proximo passo do formulario 
  	Entao o sistema exibe os tres tipos de cartoes
   
   
 @Release-01
 @portalEC
 @#lucas_nascimento
 @nao_exibe_cartao_auto
  	Esquema do Cenario: Sistema nao exibe o tipo de cartao auto na credenciadora Stelo
  	Quando informo os dados do formulario com um cnae relacionado a <opcao1> <opcao2>
  	E clico no botao proximo passo do formulario
  	Entao o sistema nao exibe o cartao auto na credenciadora Stelo
  	
  Exemplos:
 |opcao1|opcao2|
 |multibeneficios|auto|
 
 
 @Release-01
 @portalEC
 @#lucas_nascimento 
 @preenchimento_automatico_cnpj
  	Cenario: Sistema exibe o CNPJ na credenciadora Stelo conforme o preenchido no formulario
  	Quando informo os dados do formulario
  	E seleciono a credenciadora Stelo
  	Entao o sistema preenche o CNPJ conforme o dado informado no formulario
  
  
 @Release-01
 @portalEC
 @#lucas_nascimento
 @mensagem_outras_credenciadas
  	Cenario: Sistema apresenta a mensagem de aceitacao das outras credenciadoras
  	Quando informo os dados do formulario
  	E clico no botao proximo passo do formulario
  	Entao o sistema exibe a mensagem de aceitacao das outras credenciadoras
  
  
 @Release-01
 @portalEC
 @#lucas_nascimento
 @credenciamento_com_pat_alimentacao_refeicao
  	Esquema do Cenario: Sistema realiza o credenciamento preenchendo o pat alimentacao e refeicao
  	Quando informo os dados do formulario
  	E seleciono as opcoes alimentacao e refeicao da credenciadora <credenciadora>
  	E finalizo o credenciamento preenchendo os pat
  	Entao o sistema realiza o credenciamento do estabelecimento 

  Exemplos:
  |credenciadora|
  |cielo|
  |stelo|


 @Release-01
 @portalEC
 @#lucas_nascimento
 @nao_exibe_pat
 	Esquema do Cenario: Sistema nao exibe a etapa Dados do PAT ao selecionar duas credenciadoras
 	Quando informo os dados do formulario com um cnae relacionado a <opcao1> <opcao2>
 	E seleciono os catoes <cartaoum> <cartaodois>
 	Então o sistema nao exibe a etapa dados do pat

 Exemplos:
  |opcao1|opcao2|cartaoum|cartaodois |
  |multibeneficios|auto|multibeneficiosCielo|mulmultibeneficiosStelo|
  |multibeneficios|auto|multibeneficiosCielo|autoCielo|
  |multibeneficios|auto|autoCielo|multibeneficiosStelo|
 
 
 @Release-01
 @portalEC
 @#lucas_nascimento
 @direciona_pagina_correios
 Cenario: Sistema direciona para a pagina dos correios ao clicar no botao "Nao sabe seu cep?"
 Quando clico no botao NAO SABE SEU CEP
 Entao o  sistema direciona para a pagina dos correios
 
 
 @Release-01
 @portalEC
 @#lucas_nascimento
 @negativo
 @excluir_proprietario
	Esquema do Cenario: Verificar se o sistema exclui os dados do proprietario ao clicar no botao excluir proprietario
	Quando preencho as informacoes do <variavelum> proprietario 
	E clico no botao excluir <variaveldois> proprietario
	Entao o sistema exclui o <variaveltres> proprietario
	
  Exemplos:
 |variavelum|variaveldois|variaveltres|
 |segundo|segundo|segundo|
 |segundo|primeiro|primeiro|
 |terceiro|primeiro|primeiro|
 |terceiro|segundo|segundo|
 |terceiro|terceiro|terceiro|


 @Release-01
 @portalEC
 @#lucas_nascimento
 @negativo
 @erro_termo_aceite_pat
 	Cenario: Sistema nao direciona para a proxima pagina sem confirmar os termos de aceite da pagina PAT 
 	Quando informo os dados do formulario
 	E informo os dados do PAT sem aceitar os termos de aceite
 	Entao o sistema nao habilita o botao para proxima pagina


 @Release-01
 @portalEC
 @#lucas_nascimento
 @negativo
 @formulario_sem_preenchimento
  	Cenario: Sistema nao permite o cadastro no sistema com os dados de formularios sem preenchimento
  	Quando nao preencho os dados de formulario
  	Entao o sistema nao habilita o botao para proxima pagina


 @Release-01
 @portalEC
 @#lucas_nascimento
 @negativo
 @erro_nao_preencher_estabelecimento
  	Cenario: Sistema nao permite o cadastro no sistema com os dados de estabelecimento sem preenchimento
 	Quando nao preencho os dados de estabelecimento
  	Entao o sistema nao habilita o botao para proxima pagina
 
 
 @Release-01
 @portalEC
 @#lucas_nascimento
 @negativo
 @erro_nao_preencher_endereco
  	Cenario: Sistema nao permite o cadastro no sistema com os dados de endereco sem preenchimento
  	Quando nao preencho os dados de endereço
  	Entao o sistema nao habilita o botao para proxima pagina

 @Release-01
 @portalEC
 @#lucas_nascimento
 @negativo
 @erro_nao_preencher_quadro_societario
  	Cenario: Sistema nao permite o cadastro no sistema com os dados de quadro societario sem preenchimento
  	Quando nao preencho os dados do quadro societario
  	Entao o sistema nao habilita o botao para proxima pagina
 
 	
 @Release-01
 @portalEC
 @#lucas_nascimento
 @negativo
 @erro_nao_preencher_dados_bancarios
  	Cenario: Sistema nao permite o cadastro no sistema com os dados bancarios sem preenchimento
  	Quando nao preencho os dados bancarios
  	Entao o sistema nao habilita o botao para proxima pagina

 
 @Release-01
 @portalEC
 @#lucas_nascimento
 @negativo
 @erro_nao_preencher_pat_refeicao
  	Cenario: Sistema nao direciona para a proxima pagina sem preencher os dados PAT refeicao
  	Quando informo os dados do formulario
  	E seleciono a opcao de cartao vale refeicao
  	E nao preencho os dados PAT refeicao
 	Entao o sistema nao habilita o botao para proxima pagina
 
 
 @Release-01
 @portalEC
 @#lucas_nascimento
 @negativo
 @erro_nao_preencher_pat_alimentacao
  	Cenario: Sistema nao direciona para a proxima pagina sem preencher os dados PAT alimentacao
  	Quando informo os dados do formulario
  	E seleciono a opcao de cartao vale alimentacao
  	E nao preencho os dados PAT alimentacao
 	Entao o sistema nao habilita o botao para proxima pagina
 
 
 @Release-01
 @portalEC
 @#lucas_nascimento
 @negativo
 @erro_nao_preencher_pat_alimentacao_refeicao
  	Cenario: Sistema nao direciona para a proxima pagina sem preencher os dados PAT alimentacao e refeicao
  	Quando informo os dados do formulario
  	E seleciono os tipos de cartoes
  	E nao preencho os dados PAT
 	Entao o sistema nao habilita o botao para proxima pagina
 	
 @Release-01
 @portalEC
 @#lucas_nascimento
 @negativo
 @nao_preencher_pat_alimentacao_preencher_refeicao
  	Cenario: Sistema nao direciona para a proxima pagina sem preencher os dados PAT alimentacao e preenchendo PAT refeicao
  	Quando informo os dados do formulario
  	E seleciono os tipos de cartoes
  	E preencho somente os dados do PAT refeicao
 	Entao o sistema nao habilita o botao para proxima pagina


 @Release-01
 @portalEC
 @#lucas_nascimento
 @negativo
 @nao_preencher_pat_refeicao_preencher_alimentacao
  	Cenario: Sistema nao direciona para a proxima pagina sem preencher os dados PAT refeicao e preenchendo alimentacao
  	Quando informo os dados do formulario
  	E seleciono os tipos de cartoes
  	E preencho somente os dados do PAT alimentacao
 	Entao o sistema nao habilita o botao para proxima pagina
 	
 
 @Release-01
 @portalEC
 @#lucas_nascimento
 @negativo
 @erro_nao_aceitar_termo_recebimento
  	Cenario: sistema nao conclui o credenciamento sem confirmar os termos de aceite do recebimento
  	Quando informo os dados do formulario
  	E nao seleciono a opcao de concordar com as condicoes de recebimento
  	Entao o sistema nao habilita o botao para proxima pagina
  	

 @Release-01
 @portalEC
 @#lucas_nascimento
 @negativo
 @erro_nao_seleciona_cartao
 	Cenario: Sistema nao direciona para a proxima pagina quando nao e selecionado o tipo de cartao 
  	Quando informo os dados do formulario
  	E seleciono somente a credenciadora
  	Entao o sistema nao habilita o botao para proxima pagina
  	
 
 @Release-01
 @portalEC
 @#lucas_nascimento
 @negativo
 @erro_nao_seleciona_credenciadora
 	Cenario: Sistema nao direciona para a proxima pagina quando nao e selecionado uma credenciadora 
  	Quando informo os dados do formulario
  	E clico no botao proximo passo do formulario
  	E nao seleciono a credenciadora
  	Entao o sistema nao habilita o botao para proxima pagina