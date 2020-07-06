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

  @Regressivo  @arv
  Esquema do Cenario: <VSTS> - Realizar Antecipacao de vendas via Modal => <Cenario>
    Dado que estou na logado no portal EC "<user>", "<senha>"
    Quando seleciono um CNPJ de número "<CNPJ>" no combo Estabelecimento "<operador>"
    E estou usando "<Modal>", se cenario "<Cenario>", devo alterar o valor "<Valor>", antecipar "<Recorrencia>" e contratando "<Contratacao>" "<CNPJ>" "<operador>"
    Entao a validacao do cenario deve conter como resultado "<Resultado>"

    Exemplos: 
      | VSTS   | user           | senha      | CNPJ               | Cenario                 | operador | Modal | Valor | Recorrencia | Contratacao | Resultado                                 |
      | 9999-1 | 387.055.390-13 | Alelo2020@ | 2000496258 | Parcial                 | false    | true  | true  | false       | true        | ANTECIPAÇÃO REALIZADA COM SUCESSO         |
      | 9999-2 | 387.055.390-13 | Alelo2020@ | 2000496258 | Total                   | false    | true  | false | false       | true        | ANTECIPAÇÃO REALIZADA COM SUCESSO         |
      | 9999-3 | 387.055.390-13 | Alelo2020@ | 2000496258 | Recorrente Diário       | false    | true  | false | true        | false       | antecipacao recorrente deve estar ativa   |
      | 9999-4 | 387.055.390-13 | Alelo2020@ | 2000496258 | RecorrenteTotal Semanal | false    | true  | false | true        | false       | antecipacao recorrente deve estar ativa   |
      | 9999-5 | 387.055.390-13 | Alelo2020@ | 2000496258 | Recorrente Desativado   | false    | true  | false | true        | false       | antecipacao recorrente deve estar inativa |

  @Regressivo
  Esquema do Cenario: <VSTS> - Realizar Contratação de antecipacao de vendas via tela => <Cenario>
    Dado que estou na logado no portal EC "<user>", "<senha>"
    Quando seleciono um CNPJ de número "<CNPJ>" no combo Estabelecimento "<operador>"
    E estou usando "<Modal>", se cenario "<Cenario>", devo alterar o valor "<Valor>", antecipar "<Recorrencia>" e contratando "<Contratacao>" "<CNPJ>" "<operador>"
    Entao a validacao do cenario deve conter como resultado "<Resultado>"

    Exemplos: 
      | VSTS   | user           | senha      | CNPJ                              | Cenario                 | operador | Modal | Valor | Recorrencia | Contratacao | Resultado                                 |
      | 9999-1 | 387.055.390-13 | Alelo2020@ | 2000496258| Parcial                 | false    | false | true  | false       | true        | ANTECIPAÇÃO REALIZADA COM SUCESSO         |
      | 9999-2 | 387.055.390-13 | Alelo2020@ | 2000496258| Total                   | false    | false | false | false       | true        | ANTECIPAÇÃO REALIZADA COM SUCESSO         |
      | 9999-3 | 387.055.390-13 | Alelo2020@ | 2000496258 | Recorrente Diário       | false    | false | false | true        | false       | antecipacao recorrente deve estar ativa   |
      | 9999-4 | 387.055.390-13 | Alelo2020@ | 2000496258| RecorrenteTotal Semanal | false    | false | false | true        | false       | antecipacao recorrente deve estar ativa   |
      | 9999-5 | 387.055.390-13 | Alelo2020@ | 2000496258 | Recorrente Desativado   | false    | false | false | true        | false       | antecipacao recorrente deve estar inativa |
