#language: pt
#/**
# * Autor: Michael Alba
# * Empresa: Taking
# * Data: 30/03/2020
# * Caminho: Portal Estabelecimento Comercial
# */
@Regressivo
Funcionalidade: Antecipacao
  Permite realizar antecipação dos valores a receber
  
  Eu como usuario
  Quero antecipar os valores do meu estabelecimento
  Para ter a flexibilidade de receber quando necessito
  
   Contexto:
  Dado que o banco de arv esteja preparado para os testes

  @realizar_antecipacao @frontModal
  Esquema do Cenario: <VSTS> - Realizar Simulação de antecipacao de vendas => <Cenario>
    Dado que estou na logado no portal EC "<user>", "<senha>"
    Quando seleciono um CNPJ diferente que tenha "<ARV>" no combo Estabelecimento
    E estou usando "<Modal>", se cenario "<Cenario>", devo alterar o valor "<Valor>" e antecipar "<Antecipacao>"
    Entao a validacao do cenario deve conter como resultado "<Resultado>"

    Exemplos:
      | VSTS   | user           | senha      | ARV  | Cenario                 | Modal | Valor | Antecipacao | Resultado                                                              |
      | 9999-1 | 594.114.000-27 | Alelo2020@ | true | Parcial                 | true | true  | false       | valor bruto deve ser menor que o valor liquido apresentado na abertura |
      | 9999-2 | 594.114.000-27 | Alelo2020@ | true | Total                   | true  | false | false       | valor bruto deve ser total                                             |
      | 9999-3 | 594.114.000-27 | Alelo2020@ | true | Recorrente Diário       | true | false | true        | antecipacao recorrente deve estar ativa                                |
      | 9999-4 | 594.114.000-27 | Alelo2020@ | true | RecorrenteTotal Semanal | true | false | true        | antecipacao recorrente deve estar ativa                                |
      | 9999-5 | 594.114.000-27 | Alelo2020@ | true | Recorrente Desativado   | true | false | true        | antecipacao recorrente deve estar inativa                              |

       @realizar_antecipacao @frontModal
  Esquema do Cenario: <VSTS> - Realizar Simulação de antecipacao de vendas => <Cenario>
    Dado que estou na logado no portal EC "<user>", "<senha>"
    Quando seleciono um CNPJ diferente que tenha "<ARV>" no combo Estabelecimento
    E estou usando "<Modal>", se cenario "<Cenario>", devo alterar o valor "<Valor>" e antecipar "<Antecipacao>"
    Entao a validacao do cenario deve conter como resultado "<Resultado>"

    Exemplos:
      | VSTS   | user           | senha      | ARV  | Cenario                 | Modal | Valor | Antecipacao | Resultado                                                              |
      | 9999-1 | 594.114.000-27 | Alelo2020@ | true | Parcial                 | false | true  | false       | valor bruto deve ser menor que o valor liquido apresentado na abertura |
      | 9999-2 | 594.114.000-27 | Alelo2020@ | true | Total                   | false  | false | false       | valor bruto deve ser total                                             |
      | 9999-3 | 594.114.000-27 | Alelo2020@ | true | Recorrente Diário       | false | false | true        | antecipacao recorrente deve estar ativa                                |
      | 9999-4 | 594.114.000-27 | Alelo2020@ | true | RecorrenteTotal Semanal | false | false | true        | antecipacao recorrente deve estar ativa                                |
      | 9999-5 | 594.114.000-27 | Alelo2020@ | true | Recorrente Desativado   | false | false | true        | antecipacao recorrente deve estar inativa                              |
      