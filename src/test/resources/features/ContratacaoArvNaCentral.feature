#language: pt
#/**
# * Autor: Jessé Dantas | jesse.dantas@taking.com.br
# * Empresa: Taking
# * Data: 30/12/2019
# * Caminho: Portal Estabelecimento Web Admin
# */
@Release-15 @front @Regressao
Funcionalidade: Contratacao ARV pela Central
    Consultar e contratar ARV pela central - pontual, recorrente e automática
  
  Eu como operador da central
  Desejo Consultar e contratar ARV através

  #Contexto:
  # Dado que eu esteja logado no portal ARV na central
  # Dado que estou logado em qualquer tela arv na central com CPF "55356357079" e senha "12345678aA@"
  ############################################# - VALIDACAO DE MENSAGENS DE BOAS VINDAS - #############################################
  #feito
  @Release-15 @front @Regressivo @bomDia @robo
  Cenario: Validar Saudacao de bom dia
    Dado que eu acesse o portal ARV na central
    E insira o CPF "55356357079" com acesso
    E insira a senha "12345678aA@" válida
    Quando eu clicar no botão logar
    Entao devo visualizar no canto superior esquerdo da tela o Nome do usuário e a Saudacao

  #feito
  @Release-15 @front @Regressivo @boaTarde @robo
  Cenario: Validar Saudacao de boa tarde
    Dado que eu acesse o portal ARV na central
    E insira o CPF "55356357079" com acesso
    E insira a senha "12345678aA@" válida
    Quando eu clicar no botão logar
    Entao devo visualizar no canto superior esquerdo da tela o Nome do usuário e a Saudacao

  #feito
  @Release-15 @front @Regressivo @boaNoite @robo
  Cenario: Validar Saudacao de boa noite
    Dado que eu acesse o portal ARV na central
    E insira o CPF "55356357079" com acesso
    E insira a senha "12345678aA@" válida
    Quando eu clicar no botão logar
    Entao devo visualizar no canto superior esquerdo da tela o Nome do usuário e a Saudacao

  #feito
  @Release-15 @front @Regressivo @btnSair @robo
  Cenario: Validar Botão sair
    Dado que eu acesse o portal ARV na central
    E insira o CPF "55356357079" com acesso
    E insira a senha "12345678aA@" válida
    E eu clicar no botao logar
    Quando acessar o sistema de ARV na central
    E Clicar no botão SAIR no canto inferior esquedo da tela
    Entao deve ser feito o logout da aplicacao

  ############################################# - CONSULTA DE CNPJS COM ARV - #########################################################
  #feito
  #funcional =
  @Release-15 @front @Regressivo @ConsultaComESemArv @robo
  Cenario: Consulta de CNPJ "com" ou "sem" ARV disponível
    Dado que eu esteja logado no portal ARV na central com CPF "55356357079" e senha "12345678aA@"
    E inserir um CNPJ "<arv>" ARV disponível <cnpj>
    Quando clicar no botao Buscar
    Entao deve aparecer "<validacao>"
      | arv | cnpj           | validacao                                                             |
      | com | 28339982000160 | a tela com o campo dos dados cadastrais e as condicoes de antecipacao |
      | sem | 12259140000168 | exibir uma mensagem que não há saldo disponível para antecipacao      |

  #feito
  @Release-15 @front @Regressivo @ConsultaInexistente @robo
  Cenario: Consultar CNPJ Não existente
    Dado que eu esteja logado no portal ARV na central com CPF "55356357079" e senha "12345678aA@"
    E inserir um CNPJ inexistente na base "64072129000198"
    Quando clicar no botao Buscar
    Entao deve exibir a mensagem " - NENHUM CNPJ LOCALIZADO"

  #feito
  @Release-15 @front @Regressivo @ConsultaMaisDeUmEC @robo
  Esquema do Cenario: [Consultar CNPJ com mais de um EC cadastrado] "<Cenario>"-"<DescricaoDoCenario>"
    Dado que eu esteja logado no portal ARV na central com CPF "55356357079" e senha "12345678aA@"
    E inserir um CNPJ com mais de um EC cadastrado
    Quando clicar no botao Buscar
    Entao deve aparecer a tela com o campo dos dados cadastrais apresentando o Primeiro CNPJ e nome do EC da lista e os ECs relacionados com os dados para contratacao "<ec1>", "<ec2>"

    Exemplos: 
      | Cenario | DescricaoDoCenario                          | ec1        | ec2        |
      | CT01.1  | Consultar CNPJ com mais de um EC cadastrado | 1015000654 | 2000496258 |

  ############################################# - SIMULAÇÃO ARV  - #############################################
  #feito
  @Release-15 @front @Regressivo @SimularArvTotal @robo
  Esquema do Cenario: [Simular contratacao de ARV total para todos os Ecs] "<Cenario>"-"<DescricaoDoCenario>"
    Dado que inserir um CNPJ com mais de um EC com ARV disponível para contratacao "<cnpj>"
    E clicar no botao Buscar
    Quando aparecer a tela com o campo dos dados cadastrais e as condicoes de antecipacao total e parcial e selecionar a opcao todos para antecipacao
    Entao deve ser apresentado a tela de confirmaçao com o valor total da contratacao

    Exemplos: 
      | Cenario | DescricaoDoCenario                                 | cnpj           |
      | CT01.1  | Simular contratacao de ARV total para todos os Ecs | 28339982000160 |

  #flag individual não visivel para ser clicado
  @Release-15 @front @Regressivo @SimularArvUmEc @robo
  Esquema do Cenario: [Simular contratacao de ARV total para apenas 1 EC] "<Cenario>"-"<DescricaoDoCenario>"
    Dado que inserir um CNPJ com mais de um EC com ARV disponível para contratacao "<cnpj>"
    E clicar no botao Buscar
    Quando aparecer a tela com o campo dos dados cadastrais e as condicoes de antecipacao total e parcial e selecionar um ec
    Entao deve ser apresentado a tela de confirmaçao com o valor total da contratacao

    Exemplos: 
      | Cenario | DescricaoDoCenario                                | cnpj           |
      | CT01.1  | Simular contratacao de ARV total para apenas 1 EC | 28339982000160 |

  ############################################# - ALTERACAO DE VALOR DE CONTRATACAO DE ARV PARCIAL - #############################################
  @Release-15 @front @Regressivo @AlterarParcial
  Cenario: Alterar valor para simulação de ARV Parcial

  @Release-15 @front @Regressivo @SimularArvUmEc @robo
  Esquema do Cenario: [Simular contratacao de ARV total para apenas 1 EC] "<Cenario>"-"<DescricaoDoCenario>"
    Dado que inserir um CNPJ com mais de um EC com ARV disponível para contratacao "<cnpj>"
    E clicar no botao Buscar
    Quando selecionar um valor para antecipacao parcial e clicar em vizualizar valores disponiveis "<valor>"
    Entao deve apresentar a tela de antecipe suas vendas com o valor solicitado

    Exemplos: 
      | Cenario | DescricaoDoCenario                                | cnpj           | valor |
      | CT01.1  | Simular contratacao de ARV total para apenas 1 EC | 28339982000160 |  1000 |

  ############################################# - ALTERACAO DE VALOR DE CONTRATACAO DE ARV RECORRENTE - #############################################
  @Release-15 @front @Regressivo @RecorrenciaDiaria @robo
  Esquema do Cenario: [Contratar recorrencia Diaria] "<Cenario>"-"<DescricaoDoCenario>"
    Dado que inserir um CNPJ com mais de um EC com ARV disponível para contratacao "<cnpj>"
    E clicar no botao Buscar
    Quando selecionar uma recorrencia "<recorrencia>"
    Entao deve alterar a recorrencia de inativa para  "<confirmacao>"

    Exemplos: 
      | Cenario | DescricaoDoCenario            | cnpj           | confirmacao | recorrencia |
      | CT01.1  | Contratar recorrencia Diaria  | 28339982000160 | diaria      | diaria      |
      | CT01.2  | Contratar recorrencia Semanal | 28339982000160 | segunda     |             |
