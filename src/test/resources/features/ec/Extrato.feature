#language: pt
#/**
# * Autor: Lucas Martins
# * Empresa: Taking
# * Data: 20/03/2020
# * Caminho: Portal Estabelecimento Comercial
# */

@ignore
Funcionalidade: Validar Extrato 
  Eu como cliente Alelo quero validar que ao acessar pagina de extrato
  apresente minhas transacoes no periodo filtrado.

  Contexto: 
    Dado que estou na logado no portal EC "478.666.290-99", "Alelo2018@", "hm>"

@Extrato1
  Esquema do Cenario: 00000 - Validar Extrato Detalhado.
    Dado que um  Ec tenha as seguintes transacoes aprovadas
      | data       | valorBruto | taxaDesconto |
      | 20/03/2020 |       6,00 |         5,70 |
      | 20/03/2020 |      29,40 |        27,67 |
      | 20/03/2020 |      19,00 |        17,86 |
      | 20/03/2020 |      38,50 |        36,31 |
      | 20/03/2020 |       5,50 |         5,17 |
      | 20/03/2020 |      17,50 |        16,45 |
      | 20/03/2020 |      28,20 |        27,38 |
      | 20/03/2020 |      11,00 |        10,34 |
      | 20/03/2020 |      22,70 |        21,45 |
      | 20/03/2020 |       1,30 |         1,22 |
      | 20/03/2020 |      12,39 |        11,50 |
      | 20/03/2020 |       1,30 |         1,22 |
      | 20/03/2020 |       1,30 |         1,22 |
      | 20/03/2020 |       1,30 |         1,22 |
      | 20/03/2020 |      95,70 |        90,53 |
      | 20/03/2020 |       5,63 |         5,29 |
      | 20/03/2020 |      32,74 |        30,12 |
      | 20/03/2020 |      56,90 |        55,02 |
      | 20/03/2020 |      68,60 |        64,90 |
      | 22/03/2020 |      66,77 |        64,77 |
      | 22/03/2020 |       7,00 |         6,61 |
      | 22/03/2020 |      58,80 |        54,68 |
      | 22/03/2020 |      62,74 |        58,98 |
      | 22/03/2020 |     193,74 |       183,08 |
      | 22/03/2020 |       7,00 |         6,58 |
    Quando eu buscar por este IdEc "<IdEc>"
    E clicar no link extrato
    E filtrar pela data entre
      | dataInicio |"03/06/2019"|
      | dataFim | "06/06/2021" |     
    Entao deve apresentar o extrato sumarizado com duas linhas
      | data       | valor  |
      | 20/03/2020 | 430,57 |
      | 22/03/2020 | 374,70 |
    E o valor total "R$ 483,69"
    E as vendas detalhadas de cada dia
      | descricao | numTransacao | numAutorizacao | credenciadora | numCartao           | pagamento | valBruto | valLiquido |
      | VENDA     |   5292564652 |         561275 | CIELO         | 5067 **** **** 6015 | APROVADO  |    22,70 |      21,45 |
      | VENDA     |   5291686049 |         384360 | CIELO         | 5067 **** **** 0023 | APROVADO  |     6,00 |       5,70 |
      | VENDA     |   5291686048 |         213619 | CIELO         | 5067 **** **** 3021 | APROVADO  |    29,40 |      27,67 |
      | VENDA     |   5291686047 |         747600 | CIELO         | 5067 **** **** 6013 | APROVADO  |    19,00 |      17,86 |
      | VENDA     |   5291686046 |         444997 | PAG SEGURA    | 5067 **** **** 9011 | APROVADO  |    38,50 |      36,31 |
      | VENDA     |   5291686030 |         181120 | CIELO         | 5067 **** **** 0011 | APROVADO  |    20,79 |      19,58 |
      | VENDA     |   5291686029 |         047534 | GETNET        | 5067 **** **** 4012 | APROVADO  |    66,77 |      64,77 |
      | VENDA     |   5291686028 |         027123 | CIELO         | 5067 **** **** 0011 | APROVADO  |     7,00 |       6,61 |
      | VENDA     |   5291686027 |         424885 | CIELO         | 5067 **** **** 0032 | APROVADO  |    58,80 |      54,68 |
      | VENDA     |   5291686026 |         112926 | CIELO         | 5067 **** **** 3017 | APROVADO  |    62,74 |      58,98 |
      | VENDA     |   5291686025 |         881595 | REDE          | 5067 **** **** 9013 | APROVADO  |   193,74 |     183,08 |
      | VENDA     |   5291686024 |         364139 | REDE          | 5067 **** **** 9015 | APROVADO  |     7,00 |       6,58 |

    Exemplos: 
      | VSTS  | IdEc       |
      | 00000 | 2000496258 |

  @Extrato
  Esquema do Cenario: 00000 - Validar Extrato Detalhado Outras Trasacoes
    Dado que um  Ec tenha as seguintes transacoes aprovadas
      | data       | valorBruto | taxaDesconto |
      | 20/03/2020 |       6,00 |         5,70 |
      | 20/03/2020 |      29,40 |        27,67 |
      | 20/03/2020 |      19,00 |        17,86 |
      | 20/03/2020 |      38,50 |        36,31 |
      | 20/03/2020 |       5,50 |         5,17 |
      | 20/03/2020 |      17,50 |        16,45 |
      | 20/03/2020 |      28,20 |        27,38 |
      | 20/03/2020 |      11,00 |        10,34 |
      | 20/03/2020 |      22,70 |        21,45 |
      | 20/03/2020 |       1,30 |         1,22 |
      | 20/03/2020 |      12,39 |        11,50 |
      | 20/03/2020 |       1,30 |         1,22 |
      | 20/03/2020 |       1,30 |         1,22 |
      | 20/03/2020 |       1,30 |         1,22 |
      | 20/03/2020 |      95,70 |        90,53 |
      | 20/03/2020 |       5,63 |         5,29 |
      | 20/03/2020 |      32,74 |        30,12 |
      | 20/03/2020 |      56,90 |        55,02 |
      | 20/03/2020 |      68,60 |        64,90 |
      | 22/03/2020 |      66,77 |        64,77 |
      | 22/03/2020 |       7,00 |         6,61 |
      | 22/03/2020 |      58,80 |        54,68 |
      | 22/03/2020 |      62,74 |        58,98 |
      | 22/03/2020 |     193,74 |       183,08 |
      | 22/03/2020 |       7,00 |         6,58 |
      | 03/04/2020 |     170,50 |       160,45 |
    E a taxa de tarifa de anuidade
      | data       | valor  |
      | 03/04/2020 | 104,00 |
    Quando eu buscar por este IdEc "<IdEc>"
    E clicar no link extrato
    E filtrar pela data entre
      | diaInicial |     3 |
      | mesInicial | ABRIL |
      | anoInicial |  2020 |
      | diaFinal   |     4 |
      | mesFinal   | ABRIL |
      | anoFinal   |  2020 |
    Entao deve apresentar o extrato sumarizado
    E a linha para outras transacoes no valor "-104,00"
    E o valor total "R$ 56,45"
    E as vendas detalhadas
      | descricao | numTransacao | numAutorizacao | credenciadora | numCartao           | pagamento | valBruto | valLiquido |
      | VENDA     |   5291686044 |         115538 | CIELO         | 5067 **** **** 7015 | APROVADO  |   170,50 |     160,45 |

    Exemplos: 
      | VSTS  | IdEc       |
      | 00000 | 2000496258 |

  @Extrato
  Esquema do Cenario: 00000 - Validar Extrato Detalhado
     Selecao de meses.

    Dado que um  Ec tenha as seguintes transacoes aprovadas
      | data       | valorBruto | taxaDesconto |
      | 26/02/2020 |       5,50 |         5,17 |
      | 20/03/2020 |       6,00 |         5,70 |
      | 20/03/2020 |      29,40 |        27,67 |
      | 20/03/2020 |      19,00 |        17,86 |
      | 20/03/2020 |      38,50 |        36,31 |
      | 20/03/2020 |       5,50 |         5,17 |
      | 20/03/2020 |      17,50 |        16,45 |
      | 20/03/2020 |      28,20 |        27,38 |
      | 20/03/2020 |      11,00 |        10,34 |
      | 20/03/2020 |      22,70 |        21,45 |
      | 20/03/2020 |       1,30 |         1,22 |
      | 20/03/2020 |      12,39 |        11,50 |
      | 20/03/2020 |       1,30 |         1,22 |
      | 20/03/2020 |       1,30 |         1,22 |
      | 20/03/2020 |       1,30 |         1,22 |
      | 20/03/2020 |      95,70 |        90,53 |
      | 20/03/2020 |       5,63 |         5,29 |
      | 20/03/2020 |      32,74 |        30,12 |
      | 20/03/2020 |      56,90 |        55,02 |
      | 20/03/2020 |      68,60 |        64,90 |
      | 22/03/2020 |      66,77 |        64,77 |
      | 22/03/2020 |       7,00 |         6,61 |
      | 22/03/2020 |      58,80 |        54,68 |
      | 22/03/2020 |      62,74 |        58,98 |
      | 22/03/2020 |     193,74 |       183,08 |
      | 22/03/2020 |       7,00 |         6,58 |
    Quando eu buscar por este IdEc "<IdEc>"
    E clicar no link extrato
    E filtrar pela data entre
      | diaInicial |        19 |
      | mesInicial | FEVEREIRO |
      | anoInicial |      2020 |
      | diaFinal   |        31 |
      | mesFinal   | MARÇO     |
      | anoFinal   |      2020 |
    Entao deve apresentar o extrato com duas linhas
      | data       | valor  |
      | 26/02/2020 |   5,17 |
      | 20/03/2020 | 430,57 |
    E o valor total "R$ 114,16"

    Exemplos: 
      | VSTS  | IdEc       |
      | 00000 | 2000496258 |

  @Extrato 
  Esquema do Cenario: 00001 - Validar Extrato exportado formato PDF
     periodo entre meses.

    Dado que um  Ec tenha as seguintes transacoes aprovadas
      | data       | valorBruto | taxaDesconto |
      | 26/02/2020 |       5,50 |         5,17 |
      | 20/03/2020 |       6,00 |         5,70 |
      | 20/03/2020 |      29,40 |        27,67 |
      | 20/03/2020 |      19,00 |        17,86 |
      | 20/03/2020 |      38,50 |        36,31 |
      | 20/03/2020 |       5,50 |         5,17 |
      | 20/03/2020 |      17,50 |        16,45 |
      | 20/03/2020 |      28,20 |        27,38 |
      | 20/03/2020 |      11,00 |        10,34 |
      | 20/03/2020 |      22,70 |        21,45 |
      | 20/03/2020 |       1,30 |         1,22 |
      | 20/03/2020 |      12,39 |        11,50 |
      | 20/03/2020 |       1,30 |         1,22 |
      | 20/03/2020 |       1,30 |         1,22 |
      | 20/03/2020 |       1,30 |         1,22 |
      | 20/03/2020 |      95,70 |        90,53 |
      | 20/03/2020 |       5,63 |         5,29 |
      | 20/03/2020 |      32,74 |        30,12 |
      | 20/03/2020 |      56,90 |        55,02 |
      | 20/03/2020 |      68,60 |        64,90 |
      | 22/03/2020 |      66,77 |        64,77 |
      | 22/03/2020 |       7,00 |         6,61 |
      | 22/03/2020 |      58,80 |        54,68 |
      | 22/03/2020 |      62,74 |        58,98 |
      | 22/03/2020 |     193,74 |       183,08 |
      | 22/03/2020 |       7,00 |         6,58 |
    Quando eu buscar por este IdEc "<IdEc>"
    E clicar no link extrato
    E filtrar pela data entre
      | diaInicial |        19 |
      | mesInicial | FEVEREIRO |
      | anoInicial |      2020 |
      | diaFinal   |        31 |
      | mesFinal   | MARÇO     |
      | anoFinal   |      2020 |
    E clicar no botão PDF
    Entao apresentar no PDF as vendas detalhadas para cada dia

    Exemplos: 
      | VSTS  | IdEc       |
      | 00000 | 2000496258 |

  @Extrato 
  Esquema do Cenario: 00001 - Validar Extrato exportado formato CSV
     periodo entre meses.

    Dado que um  Ec tenha as seguintes transacoes aprovadas
      | data       | valorBruto | taxaDesconto |
      | 26/02/2020 |       5,50 |         5,17 |
      | 20/03/2020 |       6,00 |         5,70 |
      | 20/03/2020 |      29,40 |        27,67 |
      | 20/03/2020 |      19,00 |        17,86 |
      | 20/03/2020 |      38,50 |        36,31 |
      | 20/03/2020 |       5,50 |         5,17 |
      | 20/03/2020 |      17,50 |        16,45 |
      | 20/03/2020 |      28,20 |        27,38 |
      | 20/03/2020 |      11,00 |        10,34 |
      | 20/03/2020 |      22,70 |        21,45 |
      | 20/03/2020 |       1,30 |         1,22 |
      | 20/03/2020 |      12,39 |        11,50 |
      | 20/03/2020 |       1,30 |         1,22 |
      | 20/03/2020 |       1,30 |         1,22 |
      | 20/03/2020 |       1,30 |         1,22 |
      | 20/03/2020 |      95,70 |        90,53 |
      | 20/03/2020 |       5,63 |         5,29 |
      | 20/03/2020 |      32,74 |        30,12 |
      | 20/03/2020 |      56,90 |        55,02 |
      | 20/03/2020 |      68,60 |        64,90 |
      | 22/03/2020 |      66,77 |        64,77 |
      | 22/03/2020 |       7,00 |         6,61 |
      | 22/03/2020 |      58,80 |        54,68 |
      | 22/03/2020 |      62,74 |        58,98 |
      | 22/03/2020 |     193,74 |       183,08 |
      | 22/03/2020 |       7,00 |         6,58 |
    Quando eu buscar por este IdEc "<IdEc>"
    E clicar no link extrato
    E filtrar pela data entre
      | diaInicial |        19 |
      | mesInicial | FEVEREIRO |
      | anoInicial |      2020 |
      | diaFinal   |        31 |
      | mesFinal   | MARÇO     |
      | anoFinal   |      2020 |
    E clicar no botão CSV
    Entao apresentar no CSV as vendas detalhadas para cada dia

    Exemplos: 
      | VSTS  | IdEc       |
      | 00000 | 2000496258 |

  @Extrato 
  Esquema do Cenario: 00001 - Validar impressao Extrato.
    Dado que um  Ec tenha as seguintes transacoes aprovadas
      | data       | valorBruto | taxaDesconto |
      | 26/02/2020 |       5,50 |         5,17 |
      | 20/03/2020 |       6,00 |         5,70 |
      | 20/03/2020 |      29,40 |        27,67 |
      | 20/03/2020 |      19,00 |        17,86 |
      | 20/03/2020 |      38,50 |        36,31 |
      | 20/03/2020 |       5,50 |         5,17 |
      | 20/03/2020 |      17,50 |        16,45 |
      | 20/03/2020 |      28,20 |        27,38 |
      | 20/03/2020 |      11,00 |        10,34 |
      | 20/03/2020 |      22,70 |        21,45 |
      | 20/03/2020 |       1,30 |         1,22 |
      | 20/03/2020 |      12,39 |        11,50 |
      | 20/03/2020 |       1,30 |         1,22 |
      | 20/03/2020 |       1,30 |         1,22 |
      | 20/03/2020 |       1,30 |         1,22 |
      | 20/03/2020 |      95,70 |        90,53 |
      | 20/03/2020 |       5,63 |         5,29 |
      | 20/03/2020 |      32,74 |        30,12 |
      | 20/03/2020 |      56,90 |        55,02 |
      | 20/03/2020 |      68,60 |        64,90 |
      | 22/03/2020 |      66,77 |        64,77 |
      | 22/03/2020 |       7,00 |         6,61 |
      | 22/03/2020 |      58,80 |        54,68 |
      | 22/03/2020 |      62,74 |        58,98 |
      | 22/03/2020 |     193,74 |       183,08 |
      | 22/03/2020 |       7,00 |         6,58 |
    Quando eu buscar por este IdEc "<IdEc>"
    E clicar no link extrato
    E filtrar pela data entre
      | diaInicial |        26 |
      | mesInicial | FEVEREIRO |
      | anoInicial |      2020 |
      | diaFinal   |        27 |
      | mesFinal   | FEVEREIRO |
      | anoFinal   |      2020 |
    E clicar no botão imprimir
    Entao apresentar janela de impressao

    Exemplos: 
      | VSTS  | IdEc       |
      | 00000 | 2000496258 |
