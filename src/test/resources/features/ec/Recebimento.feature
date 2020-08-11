#language: pt
#/**
# * @author Fernando Lisboa - Taking
# * Change: 08/01/2019 | Author: Jessé Dantas - Taking
# * Caminho: Portal Estabelecimento Comercial
# */
@ignore
Funcionalidade: Recebimentos
  Permite a consulta dos valores a serem disponibilizados ao usuario ao longo do mes

  
  Esquema do Cenario: <VSTS> - Recebimento mensal <cenario>
    Dado que estou na logado no portal EC "<user>", "<senha>", "<ambiente>"
    Quando eu clicar no menu recebimentos "<cnpj>"
    Entao devo validar que é exibido o valor recebido e o valor a receber do meu ec "<periodo>"

    Exemplos: 
      | VSTS   | cenario                                                | periodo      | cnpj       | user           | senha      |
      | 9999-1 | Realizar consulta de valores a receber e recebidos     | mês atual    | 2004240711 | 594.114.000-27 | Alelo2020@ |
      | 9999-2 | Realizar consulta de valores a receber no proximo mes  | mês seguinte | 2004240711 | 594.114.000-27 | Alelo2020@ |
      | 9999-3 | Realizar consulta de valores recebidos no mes anterior | mês anterior | 2004240711 | 594.114.000-27 | Alelo2020@ |

@ignore
  Esquema do Cenario: <VSTS> - Recebimento detalhado <cenario>
    Dado que estou na logado no portal EC "<user>", "<senha>", "<ambiente>"
    Quando eu clicar no menu recebimentos "<cnpj>"
    E Selecionar uma data com a opcao de produto "<produto>" para o CNPJ "<cnpj>" e clicar em comprovante"<comprovante>"
    Entao devo visualizar a lista de valores a receber de acordo com o produto selecionado "<produto>"

    Exemplos: 
      | VSTS   | cenario                                                  | produto           | cnpj       | user           | senha      |
      | 9999-4 | Consultar Recebimentos por tipo de produto - REFEIÇÃO    | ALELO REFEICAO    | 2004240711 | 594.114.000-27 | Alelo2020@ |
     #| 9999-5 | Consultar Recebimentos por tipo de produto - ALIMENTAÇÃO | ALELO ALIMENTACAO | 2004240711 | 594.114.000-27 | Alelo2020@ |
     #| 9999-6 | Consultar Recebimentos por tipo de produto - TODOS       | TODOS             | 2004240711 | 594.114.000-27 | Alelo2020@ |
@ignore
  Esquema do Cenario: <VSTS> - Recebimento detalhado <cenario>
    Dado que estou na logado no portal EC "<user>", "<senha>", "<ambiente>"
    Quando eu clicar no menu recebimentos "<cnpj>"
    E Selecionar uma data com a opcao de produto "<produto>" para o CNPJ "<cnpj>" e clicar em comprovante"<comprovante>"
    Entao devo visualizar a lista de valores a receber de acordo com o produto selecionado "<produto>"
    Entao devo validar que foi apresentado uma tabela com os detalhes das transacoes de acordo com o filtro "<produto>"

    Exemplos: 
      | VSTS   | cenario                                                                | produto           | cnpj       | user           | senha      |
      | 9999-7 | Consultar detalhe das transações de acordo com o produto - REFEIÇÃO    | ALELO REFEICAO    | 2004240711 | 594.114.000-27 | Alelo2020@ |
      | 9999-8 | Consultar detalhe das transações de acordo com o produto - ALIMENTAÇÃO | ALELO ALIMENTACAO | 2004240711 | 594.114.000-27 | Alelo2020@ |
      | 9999-9 | Consultar detalhe das transações de acordo com o produto- TODOS        | TODOS             | 2004240711 | 594.114.000-27 | Alelo2020@ |
@ignore
  Esquema do Cenario: <VSTS> - Comprovante detalhado <cenario>
    Dado que estou na logado no portal EC "<user>", "<senha>", "<ambiente>"
    Quando eu clicar no menu recebimentos "<cnpj>"
    E Selecionar uma data com a opcao de produto "<produto>" para o CNPJ "<cnpj>" e clicar em comprovante"<comprovante>"

    Exemplos: 
      | VSTS    | cenario                                                                                                     | cnpj       | produto           | comprovante | user           | senha      |
      | 9999-10 | Consultar detalhe das transações de acordo com o produto e realizar o download do comprovante - REFEIÇÃO    | 2004240711 | ALELO REFEICAO    | true        | 594.114.000-27 | Alelo2020@ |
      | 9999-11 | Consultar detalhe das transações de acordo com o produto e realizar o download do comprovante - ALIMENTAÇÃO | 2004240711 | ALELO ALIMENTACAO | true        | 594.114.000-27 | Alelo2020@ |
      | 9999-12 | Consultar detalhe das transações de acordo com o produto e realizar o download do comprovante - TODOS       | 2004240711 | TODOS             | true        | 594.114.000-27 | Alelo2020@ |
