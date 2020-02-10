#language: pt
#/**
# * Autor: Fernando Lisboa
# * Empresa: Taking
# * Data: 06/12/2019
# * Caminho: Portal Estabelecimento Comercial
# */
@Painel @Regressivo
Funcionalidade: Painel
  Permite a realizacao de navegacao no Portal EC
  
  Eu como usuario
  Quero navegar no sistema
  Para validar informacoes respectivas da Home Page

  Contexto: 
    Dado que estou na logado no portal EC "546.219.170-72", "Alelo2018@"

  @Paine @Regressivo
  Esquema do Cenario: <VSTS> - Alterar SUCESSIVAMENTE CNPJ no combo selecao com Sucesso <cenario>
    E seleciono um CNPJ diferente no combo Estabelecimento
    Entao o painel carrega as informacoes respectivas ao CNPJ selecionado

    Exemplos: 
      | VSTS  | cenario                                                  |
      | 46121 | Alterar SUCESSIVAMENTE CNPJ no combo selecao com Sucesso |

  @Painel @Regressivo
  Esquema do Cenario: <VSTS> - Validar Side-Kick de ARV com EC com saldo e sem planos <cenario>
    E seleciono um CNPJ diferente que tenha ARV no combo Estabelecimento
    Entao o sistema apresenta o sidekick de ARV

    Exemplos: 
      | VSTS  | cenario                                                |
      | 64124 | Validar Side-Kick de ARV com EC com saldo e sem planos |

  @Painel @Regressivo
  Esquema do Cenario: <VSTS> - Painel meu negocio - Elegivel <cenario>
    E seleciono um CNPJ diferente que seja elegivel para contratação do painel meu negocio
    Entao o sistema apresenta o sidekick de painel

    Exemplos: 
      | VSTS  | cenario           |
      | 64121 | Validar Side-Kick |

  @Painel @Regressivo
  Esquema do Cenario: <VSTS> - Painel - <cenario>
    E seleciono um CNPJ diferente que tenha ARV no combo Estabelecimento
    Entao devo validar a apresentação de infomaçoes de valores a receber

    Exemplos: 
      | VSTS | cenario                                                      |
      | 9999 | Validar informação de agenda na tela de Painel "Vou receber" |

  @Painel @Regressivo
  Esquema do Cenario: <VSTS> - Painel - <cenario>
    E seleciono um CNPJ diferente que tenha ARV no combo Estabelecimento
    Entao devo validar a apresentação de infomaçoes de valores já recebidos

    Exemplos: 
      | VSTS | cenario                                                      |
      | 9999 | Validar informação de agenda na tela de Painel "Vou receber" |

  @Painel @Regressivo
  Esquema do Cenario: <VSTS> - Painel - <cenario>
    E seleciono um CNPJ diferente que tenha ARV no combo Estabelecimento
    Entao devo validar a apresentação de infomaçoes painel com resumo de faturamento e graficos do painel meu negocio "<graficoEsperado>"

    Exemplos: 
      | VSTS | cenario                                            | graficoEsperado |
      | 9999 | Validar informação de painel resumo de faturamento | faturamento     |
      | 9999 | Validar informação de painel free mensal           | mensal          |
      | 9999 | Validar informação de painel free semanal          | semanal         |

  # | 9999 | Validar informação de painel free diário           | diario      |
 
