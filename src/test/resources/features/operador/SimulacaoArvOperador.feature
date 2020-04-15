#language: pt
#/**
# * Autor: Michael Alba
# * Empresa: Taking
# * Data: 30/03/2020
# * Caminho: Portal Estabelecimento Comercial
# */
Funcionalidade: Antecipacao
  Permite realizar antecipação dos valores a receber
  
  Eu como usuario
  Quero antecipar os valores do meu estabelecimento
  Para ter a flexibilidade de receber quando necessito

  Contexto: 
    Dado que o banco de arv esteja preparado para os testes

  @realizar_antecipacao1 @SimularOperador
  Esquema do Cenario: <VSTS> - Realizar Simulação de antecipacao de vendas => <Cenario>
    Dado que estou na logado no portal EC Operador "<user>", "<senha>"
    Quando seleciono um CNPJ de número "<CNPJ>" no combo Estabelecimento
    E estou usando "<Modal>", se cenario "<Cenario>", devo alterar o valor "<Valor>", antecipar "<Antecipacao>" e contratando "<Contratacao>"
    Entao a validacao do cenario deve conter como resultado "<Resultado>"

    Exemplos: 
      | VSTS   | user           | senha      | CNPJ                              | Cenario                 | Modal | Valor | Antecipacao | Contratacao | Resultado                                                              |
      | 9999-1 | 012.345.678-90 | Alelo2020@ | @ 12.819.758/0002-16 - 0000660817 | Parcial operador                | true  | true  | false       | true        | valor bruto deve ser menor que o valor liquido apresentado na abertura |
      | 9999-2 | 594.114.000-27 | Alelo2020@ | @ 12.819.758/0002-16 - 0000660817 | Total  operador                 | true  | false | false       | false       | valor bruto deve ser total                                             |
      | 9999-3 | 594.114.000-27 | Alelo2020@ | @ 12.819.758/0002-16 - 0000660817 | Recorrente Diário operador      | true  | false | true        | false       | antecipacao recorrente deve estar ativa                                |
      | 9999-4 | 594.114.000-27 | Alelo2020@ | @ 12.819.758/0002-16 - 0000660817 | RecorrenteTotal Semanal operador| true  | false | true        | false       | antecipacao recorrente deve estar ativa                                |
      | 9999-5 | 594.114.000-27 | Alelo2020@ | @ 12.819.758/0002-16 - 0000660817 | Recorrente Desativado operador  | true  | false | true        | false       | antecipacao recorrente deve estar inativa                              |

  @realizar_antecipacao @frontModal
  Esquema do Cenario: <VSTS> - Realizar Simulação de antecipacao de vendas - VIA PÁGINA=> <Cenario>
    Dado que estou na logado no portal EC "<user>", "<senha>"
    Quando seleciono um CNPJ de número "<CNPJ>" no combo Estabelecimento
    E estou usando "<Modal>", se cenario "<Cenario>", devo alterar o valor "<Valor>", antecipar "<Antecipacao>" e contratando "<Contratacao>"
    Entao a validacao do cenario deve conter como resultado "<Resultado>"

    Exemplos: 
      | VSTS   | user           | senha      | ARV                               | Cenario                 | Modal | Valor | Antecipacao | Contratacao | Resultado                                                              |
      | 9999-1 | 012.345.678-90 | Alelo2020@ | @ 12.819.758/0002-16 - 0000660817 | Parcial                 | true  | true  | false       | true        | valor bruto deve ser menor que o valor liquido apresentado na abertura |
      | 9999-2 | 594.114.000-27 | Alelo2020@ | @ 12.819.758/0002-16 - 0000660817 | Total                   | true  | false | false       | false       | valor bruto deve ser total                                             |
      | 9999-3 | 594.114.000-27 | Alelo2020@ | @ 12.819.758/0002-16 - 0000660817 | Recorrente Diário       | true  | false | true        | false       | antecipacao recorrente deve estar ativa                                |
      | 9999-4 | 594.114.000-27 | Alelo2020@ | @ 12.819.758/0002-16 - 0000660817 | RecorrenteTotal Semanal | true  | false | true        | false       | antecipacao recorrente deve estar ativa                                |
      | 9999-5 | 594.114.000-27 | Alelo2020@ | @ 12.819.758/0002-16 - 0000660817 | Recorrente Desativado   | true  | false | true        | false       | antecipacao recorrente deve estar inativa                              |

  @sidekickSimulação
  Esquema do Cenario: <VSTS> - Realizar Simulação de antecipacao de vendas => <Cenario>
    Dado que estou na logado no portal EC Operador "<user>", "<senha>"
    Entao valido que o sidkick de simulação está presente e todos os menus

    Exemplos: 
      | VSTS   | user           | senha      | ARV  | Cenario | Modal | Valor | Antecipacao | Resultado                                                              |
      | 9999-1 | 012.345.678-90 | Alelo2020@ | true | Parcial | true  | true  | false       | valor bruto deve ser menor que o valor liquido apresentado na abertura |
