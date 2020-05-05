#language: pt
#/**
# * @author Fernando Lisboa - Taking
# * Change: 08/01/2019 | Author: Jessé Dantas - Taking
# * Caminho: Portal Estabelecimento Comercial
# */
Funcionalidade: Recebimentos
  Permite a consulta dos valores a serem disponibilizados ao usuario ao longo do mes

  Contexto: 
    Dado que estou na logado no portal EC "594.114.000-27", "Alelo2020@"

  #Feito
  @Recebimentos @Regressivo
  Esquema do Cenario: <VSTS> - Recebimento mensal <cenario>
    Quando eu clicar no menu recebimentos "<cnpj>"
    Entao devo validar que é exibido o valor recebido e o valor a receber do meu ec "<periodo>"

    Exemplos: 
      | VSTS   | cenario                                                | periodo      | cnpj           |
      | 9999-1 | Realizar consulta de valores a receber e recebidos     | mês atual    | 28339982000160 |
      | 9999-2 | Realizar consulta de valores a receber no proximo mes  | mês seguinte | 28339982000160 |
      | 9999-3 | Realizar consulta de valores recebidos no mes anterior | mês anterior | 28339982000160 |

  #Feito
   @Recebimentos @Regressivo
  Esquema do Cenario: <VSTS> - Recebimento detalhado <cenario>
    Quando eu clicar no menu recebimentos "<cnpj>"
    E selecionar a data atual e a opcao de "<produto>"
    Entao devo visualizar a lista de valores a receber de acordo com o produto selecionado "<produto>"

    Exemplos: 
      | VSTS   | cenario                                                  | produto           | cnpj           |
      | 9999-4 | Consultar Recebimentos por tipo de produto - REFEIÇÃO    | ALELO REFEICAO    | 28339982000160 |
      | 9999-5 | Consultar Recebimentos por tipo de produto - ALIMENTAÇÃO | ALELO ALIMENTACAO | 28339982000160 |
      | 9999-6 | Consultar Recebimentos por tipo de produto - TODOS       | TODOS             | 28339982000160 |

  #Feito
  @Recebimentos @Regressivo
  Esquema do Cenario: <VSTS> - Recebimento detalhado <cenario>
    Quando eu clicar no menu recebimentos "<cnpj>"
    E selecionar a data atual e a opcao de "<produto>"
    E devo visualizar a lista de valores a receber de acordo com o produto selecionado "<produto>"
    Entao devo validar que foi apresentado uma tabela com os detalhes das transacoes de acordo com o filtro "<produto>"

    Exemplos: 
      | VSTS   | cenario                                                                | produto           | cnpj           |
      | 9999-7 | Consultar detalhe das transações de acordo com o produto - REFEIÇÃO    | ALELO REFEICAO    | 28339982000160 |
      | 9999-8 | Consultar detalhe das transações de acordo com o produto - ALIMENTAÇÃO | ALELO ALIMENTACAO | 28339982000160 |
      | 9999-9 | Consultar detalhe das transações de acordo com o produto- TODOS        | TODOS             | 28339982000160 |

   @Recebimentos @Regressivo
  Esquema do Cenario: <VSTS> - Comprovante detalhado <cenario>
    Quando clicar no menu recebimentos "<cnpj>"
    E Selecionar a data atual e a opcao de produtos e clicar em comprovante"<produto>"
    E devo visualizar a lista de valores a receber de acordo com o produto selecionado e fazer o download do comprovante"<produto>"
    Entao devo validar que foi realizado o download ou impressao do comprovante "<produto>"

    Exemplos: 
      | VSTS    | cenario                                                                                                     | produto           | cnpj           |
      | 9999-10 | Consultar detalhe das transações de acordo com o produto e realizar o download do comprovante - REFEIÇÃO    | ALELO REFEICAO    | 28339982000160 |
      | 9999-11 | Consultar detalhe das transações de acordo com o produto e realizar o download do comprovante - ALIMENTAÇÃO | ALELO ALIMENTACAO | 28339982000160 |
     | 9999-12 | Consultar detalhe das transações de acordo com o produto e realizar o download do comprovante - TODOS       | TODOS             | 28339982000160 |
