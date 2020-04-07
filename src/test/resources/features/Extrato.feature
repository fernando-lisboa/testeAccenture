#language: pt
#/**
# * Autor: Lucas Martins
# * Empresa: Taking
# * Data: 20/03/2020
# * Caminho: Portal Estabelecimento Comercial
# */

Funcionalidade: Validar Extrato
  Eu como cliente Alelo quero validar que ao acessar pagina de extrato
  apresente minhas transacoes no periodo filtrado.
  
  Contexto: 
    Dado que estou na logado no portal webadmim EC "22222222222", "12345678!"

  @Extrato 
  Esquema do Cenario: 00000 - Validar Extrato Sumarizado
    pesquisa dentro do mesmo meses.

    Dado possua um Ec "<IdEc>"
    E que este Ec tenha as seguintes transacoes aprovadas
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
      | diaInicial |       20 |
      | mesInicial |    MARCO |
      | anoInicial |     2020 |
      | diaFinal   |       22 |
      | mesFinal   |   MARCO  |
      | anoFinal   |     2020 |
    Entao deve apresentar o extrato sumarizado com duas linhas
      | data       |  valor  |
      | 20/03/2020 |  430,57 |
      | 22/03/2020 |  374,70 |
    E o valor total "R$ 805,27"

    Exemplos: 
      | VSTS  | IdEc       |
      | 00000 | 1015000590 |

  