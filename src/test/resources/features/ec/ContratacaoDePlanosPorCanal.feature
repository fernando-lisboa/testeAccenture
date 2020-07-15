#language: pt
#/**
# * Autor: Fernando Lisboa
# * Empresa: Taking
# * Data: 07/07/2020
# * Caminho: Portal Estabelecimento Comercial
# */
@Regressivo
Funcionalidade: Contrtatação de planos por canal
  Permite contratar planos oferecido pelo web admim e identificar o canal contratado
  
  Eu como usuario
  Desejo identificar o canal do plano contratado

  Contexto: 
    Dado que estou na logado no portal webadmim EC "22222222222", "12345678!"

  @Regressivo @PlanoPorCanal
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
      | VSTS  | cenario                                               | CNPJ       | user           | senha      | operador | contratacao | path                                  | fileName                              | tpPlano | canal       |
      | 46121 | Ofertar planos econtratar pelo canal Portal - 2 dias  | 2000496258 | 387.055.390-13 | Alelo2020@ | false    | true        | \\src\\test\\resources\\armazenador\\ | IncluirCNPJs_Ofertas.xlsx             |      02 | PortalEc    |
      | 46121 | Ofertar planos econtratar pelo canal Portal - 7 dias  | 2000496258 | 736.855.880-79 | Alelo2020@ | false    | true        | \\src\\test\\resources\\armazenador\\ | IncluirCNPJs_Ofertas.xlsx             |      07 | PortalEc    |
      | 46121 | Ofertar planos econtratar pelo canal Portal - 15 dias | 2000496258 | 736.855.880-79 | Alelo2020@ | false    | true        | \\src\\test\\resources\\armazenador\\ | IncluirCNPJs_Ofertas.xlsx             |      15 | PortalEc    |
      | 46121 | Ofertar planos econtratar pelo canal Portal - 2 dias  | 2000496258 | 387.055.390-13 | Alelo2020@ | false    | true        | \\src\\test\\resources\\armazenador\\ | IncluirCNPJs_Ofertas_FrontVendas.xlsx |      02 | FrontVendas |
      | 46121 | Ofertar planos econtratar pelo canal Portal - 2 dias  | 2000496258 | 387.055.390-13 | Alelo2020@ | false    | true        | \\src\\test\\resources\\armazenador\\ | IncluirCNPJs_Ofertas_App.xlsx         |      02 | App         |

  @Regressivo @ignore
  Esquema do Cenario: <VSTS> - Inclusão de planos para um CNPJ e contratacao para o canal PORTAL_EC  => <Cenario>
    E que eu tenha planos disponíveis para cantratacao "hml"
    Quando efetuar o upload de planilha de planos para um "<CNPJ>" "<caminho>", "<fileName>"

    Exemplos: 
      | VSTS  | cenario                             | CNPJ                              | user           | senha      | operador | caminho                               | fileName                      | tpPlano | canal    |
      | 46121 | Efetuar upload de planilha com erro | • 37.491.504/0001-61 - 1010745147 | 736.855.880-79 | Alelo2020@ | false    | \\src\\test\\resources\\armazenador\\ | IncluirCNPJs_OfertasErro.xlsx |      02 | PortalEc |
