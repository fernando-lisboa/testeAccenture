#language: pt
#/**
# * Autor: Fernando Lisboa
# * Empresa: Taking
# * Data: 07/07/2020
# * Caminho: Portal Estabelecimento Comercial
# */
@Regressivo @PlanoPorCanal
Funcionalidade: Contrtatação de planos por canal
  Permite contratar planos oferecido pelo web admim e identificar o canal contratado
  
  Eu como usuario
  Desejo identificar o canal do plano contratado

  Contexto: 
    Dado que estou na logado no portal webadmim EC "22222222222", "12345678!"

  @Regressivo
  Esquema do Cenario: <VSTS> - Inclusão de planos para um CNPJ e contratacao para o canal PORTAL_EC  => <Cenario>
    E que eu tenha planos disponíveis para cantratacao "hml"
    Quando efetuar o upload de planilha de planos para um "<CNPJ>" "<path>", "<fileName>"
    Dado que estou na logado no portal EC "<user>", "<senha>"
    E seleciono um CNPJ de número "<CNPJ>" no combo Estabelecimento "<operador>"
    Quando Contratar o plano ofertado "<tpPlano>" "<contratacao>"
    Entao devo validar que foi gravado no banco de dados o canal de contratacao "<canal>" "hml"
      | cnpj      | 28339982000160 |
      | numeroEc  |     2000496258 |
      | nomeCanal | PortalEC       |
      | idCanal   |              2 |

    Exemplos: 
      | VSTS  | Cenario                                                     | CNPJ       | user           | senha      | operador | contratacao | path                                  | fileName                              | tpPlano | canal       |
      | 99991 | Ofertar planos econtratar pelo canal Portal - 2 dias        | 2000496258 | 387.055.390-13 | Alelo2020@ | false    | true        | \\src\\test\\resources\\armazenador\\ | IncluirCNPJs_Ofertas.xlsx             |      02 | PortalEc    |
      | 99992 | Ofertar planos econtratar pelo canal Portal - 7 dias        | 2000496258 | 736.855.880-79 | Alelo2020@ | false    | true        | \\src\\test\\resources\\armazenador\\ | IncluirCNPJs_Ofertas.xlsx             |      07 | PortalEc    |
      | 99994 | Ofertar planos econtratar pelo canal Portal - 15 dias       | 2000496258 | 736.855.880-79 | Alelo2020@ | false    | true        | \\src\\test\\resources\\armazenador\\ | IncluirCNPJs_Ofertas.xlsx             |      15 | PortalEc    |
      | 99995 | Ofertar planos e verificar banco de dados - Front de Vendas | 2000496258 | 387.055.390-13 | Alelo2020@ | false    | false       | \\src\\test\\resources\\armazenador\\ | IncluirCNPJs_Ofertas_FrontVendas.xlsx |      02 | FrontVendas |
      | 99996 | Ofertar planos e verificar banco de dados - APP             | 2000496258 | 387.055.390-13 | Alelo2020@ | false    | false       | \\src\\test\\resources\\armazenador\\ | IncluirCNPJs_Ofertas_App.xlsx         |      02 | App         |

  @Regressivo 
  Esquema do Cenario: <VSTS> - Inclusão de planos para um CNPJ e contratacao para o canal PORTAL_EC  => <Cenario>
    E que eu tenha planos disponíveis para cantratacao "hml"
    Quando efetuar o upload de planilha de planos para um "<CNPJ>" acima da qtde de registros permitido "<path>", "<fileName>"

    Exemplos: 
      | VSTS  | Cenario                                        | CNPJ       | user           | senha      | operador | contratacao | path                                  | fileName                                 | tpPlano | canal    |
      #| 99997 | Ofertar planos com planilhas até 3Mil linhas   | 2000496258 | 387.055.390-13 | Alelo2020@ | false    | true        | \\src\\test\\resources\\armazenador\\ | uploadPlanilhaAte_3000_Linhas.xlsx |      02 | PortalEc |
      | 99997 | Ofertar planos com planilhas acima 3Mil linhas | 2000496258 | 387.055.390-13 | Alelo2020@ | false    | true        | \\src\\test\\resources\\armazenador\\ | uploadPlanilhaAcima_3002_Linhas.xlsx |      02 | PortalEc |
