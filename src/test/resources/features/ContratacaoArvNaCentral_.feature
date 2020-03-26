#language: pt
#/*
# * Autor: Matheus Lisboa
# * Empresa: Taking
# * Data: 18/03/2020
# * Caminho: Portal Estabelecimento Web Admin
# */
@Release-15 @front001 @Regressao @saudacao @robo
Funcionalidade: Contratacao ARV pela Central
    Consultar e contratar ARV pela central - pontual, recorrente e automática
  
  Eu como operador da central
  Desejo Consultar e contratar ARV através

  Contexto: 
    Dado que estou logado no Portal ARV na Central "55356357079", "12345678aA@"

  Esquema do Cenario: <VSTS> - Validar Saudacao de Boas Vindas <cenario>
    Entao devo visualizar no canto superior esquerdo da tela o Nome do usuário e a Saudacao

    Exemplos: 
      | VSTS  | cenario   |
      | 78508 | Bom Dia   |
      | 78508 | Boa Tarde |
      | 78508 | Boa Noite |

  @Release-15 @front001 @Regressivo @ConsultaComESemArv @robo
  Esquema do Cenario: <VSTS> - Consulta de CNPJ <cenario>
    Quando inserir um CNPJ no campo de pesquisa e clicar em Buscar "<cnpj>"
    Entao deve apresentar o cenario de validacao "<validacao>"

    Exemplos: 
      | VSTS  | cenario            | cnpj           | validacao                                                             |
      | 78512 | com Arv Disponível | 28339982000160 | a tela com o campo dos dados cadastrais e as condicoes de antecipacao |
      | 78513 | sem Arv Disponível | 12259140000168 | exibir uma mensagem que não há saldo disponível para antecipacao      |

#Feito
  @Release-15 @front001 @Regressivo @ConsultaMaisDeUmEC @robo
  Esquema do Cenario: <VSTS> - Consulta de CNPJ Com Mais de Um EC <cenario>
    Quando inserir um CNPJ com mais de um EC cadastrado e clicar no botao Buscar "<cnpj>"
    Entao deve aparecer a tela com o campo dos dados cadastrais apresentando os ECs relacionados com os dados para contratacao "<ec1>", "<ec2>"

    Exemplos: 
      | VSTS  | cenario                                     | cnpj           | ec1        | ec2        |
      | 78515 | consultar CNPJ com mais de um EC cadastrado | 28339982000160 | 1015000654 | 2000496258 |

  #Feito
  @Release-15 @front001 @Regressivo @SimularArvTotal @robo
  Esquema do Cenario: <VSTS> - SimularArvTotal <cenario>
    Quando inserir um CNPJ com mais de um EC com ARV disponível para contratacao "<cnpj>"
    E selecionar a opcao todos para antecipacao
    Entao deve ser apresentado a tela de confirmaçao com o valor total da contratacao

    Exemplos: 
      | VSTS  | cenario                                            | cnpj           |
      | 78517 | Simular contratacao de ARV total para todos os Ecs | 28339982000160 |

  @Release-15 @front001 @Regressivo @SimularArvUmEc @robo
  Esquema do Cenario: <VSTS> Simular Arv Um EC <cenario>
    Quando colocar um CNPJ com mais de um EC com ARV disponível para contratacao e clicar em gerar proposta "<cnpj>"
    Entao deve apresentar a tela de confirmaçao com o valor total da contratacao

    Exemplos: 
      | VSTS  | cenario                                           | cnpj           |
      | 78518 | simular contratacao de ARV total para apenas 1 EC | 28339982000160 |

  ############################################# - ALTERACAO DE VALOR DE CONTRATACAO DE ARV PARCIAL - #############################################
  #Feito
  @Release-15 @front001 @Regressivo @SimularAlteracaoARVParcial @robo
  Esquema do Cenario: <VSTS> Simular Alteracao Parcial de ARV <cenario>
    Quando Inserir um CNPJ com mais de um EC com ARV disponível para contratacao "<cnpj>"
    E selecionar um valor para antecipacao parcial e clicar em vizualizar valores disponiveis "<valor>"
    Entao deve apresentar a tela de antecipe suas vendas com o valor solicitado

    Exemplos: 
      | VSTS  | cenario                                           | cnpj           | valor |
      | 78524 | Simular contratacao de ARV total para apenas 1 EC | 28339982000160 |  1000 |

  ############################################# - ALTERACAO DE VALOR DE CONTRATACAO DE ARV RECORRENTE - #############################################
  @Release-15 @front001 @Regressivo @RecorrenciaDiaria @robo
  Esquema do Cenario: <VSTS> Simular Alteracao Contratacao de ARV Recorrente <cenario>
    Quando inserir um cnpj com mais de um EC com ARV disponível para contratacao "<cnpj>"
    E selecionar uma recorrencia "<recorrencia>"
    Entao deve alterar a recorrencia de inativa para  "<confirmacao>"

    Exemplos: 
      | VSTS  | Cenario                       | cnpj           | confirmacao | recorrencia |
      | 78526 | Contratar recorrencia Diaria  | 28339982000160 | Diária      | Diária      |
      | 78527 | Contratar recorrencia Semanal | 28339982000160 | SEG         | Semanal     |
