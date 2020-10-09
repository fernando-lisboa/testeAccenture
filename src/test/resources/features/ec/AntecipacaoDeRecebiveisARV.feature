#language: pt
#/**
# * Autor: Fernando Lisboa
# * Empresa: Taking
# * Data: 07/07/2020
# * Caminho: Portal Estabelecimento Comercial
# */
@Regressivo @ARV
Funcionalidade: Antecipacao de de vendas ARV - PÓS CONTRATAÇÃO E RECORRENTE
  Permite realizar antecipação dos valores a receber
  
  Eu como usuario
  Quero antecipar os valores do meu estabelecimento
  Para ter a flexibilidade de receber quando necessito

  Contexto: 
    Dado que o banco de arv esteja preparado para os testes

  @Regressivo @arvModal
  Esquema do Cenario: <VSTS> - Realizar Antecipacao de vendas via Modal => <Cenario>
    Dado que estou na logado no portal EC "<user>", "<senha>", "<ambiente>"
    Quando seleciono um CNPJ de número "<CNPJ>" no combo Estabelecimento "<operador>"
    E estou usando "<Modal>", se cenario "<Cenario>", devo alterar o valor "<Valor>", antecipar "<Recorrencia>" e contratando "<Contratacao>" "<CNPJ>" "<operador>"
   # Entao fecho a sessao

    Exemplos: 
      | VSTS   | user           | senha      | CNPJ       | Cenario                 | operador | Modal | Valor | Recorrencia | Contratacao | Resultado                                 | ambiente |
      | 9999-1 | 387.055.390-13 | Alelo2020@ | 2004240711 | Parcial                 | false    | true  | true  | false       | true        | ANTECIPAÇÃO REALIZADA COM SUCESSO         | hml      |
      | 9999-2 | 387.055.390-13 | Alelo2020@ | 2004240711 | Total                   | false    | true  | false | false       | true        | ANTECIPAÇÃO REALIZADA COM SUCESSO         | hml      |
      | 9999-3 | 387.055.390-13 | Alelo2020@ | 2004240711 | Recorrente Diário       | false    | true  | false | true        | false       | antecipacao recorrente deve estar ativa   | hml      |
      | 9999-4 | 387.055.390-13 | Alelo2020@ | 2004240711 | RecorrenteTotal Semanal | false    | true  | false | true        | false       | antecipacao recorrente deve estar ativa   | hml      |
      | 9999-5 | 387.055.390-13 | Alelo2020@ | 2004240711 | Recorrente Desativado   | false    | true  | false | true        | false       | antecipacao recorrente deve estar inativa | hml      |

  @Regressivo @ignore
  Esquema do Cenario: <VSTS> - Realizar Contratação de antecipacao de vendas via tela => <Cenario>
    Dado que estou na logado no portal EC "<user>", "<senha>", "<ambiente>"
    Quando seleciono um CNPJ de número "<CNPJ>" no combo Estabelecimento "<operador>"
    E estou usando "<Modal>", se cenario "<Cenario>", devo alterar o valor "<Valor>", antecipar "<Recorrencia>" e contratando "<Contratacao>" "<CNPJ>" "<operador>"
   # Entao fecho a sessao

    Exemplos: 
      | VSTS   | user           | senha      | CNPJ       | Cenario                 | operador | Modal | Valor | Recorrencia | Contratacao | Resultado                                 | ambiente |
      | 9999-1 | 387.055.390-13 | Alelo2020@ | 2004240711 | Parcial                 | false    | false | true  | false       | true        | ANTECIPAÇÃO REALIZADA COM SUCESSO         | hml      |
      | 9999-2 | 387.055.390-13 | Alelo2020@ | 2004240711 | Total                   | false    | false | false | false       | true        | ANTECIPAÇÃO REALIZADA COM SUCESSO         | hml      |
      | 9999-3 | 387.055.390-13 | Alelo2020@ | 2004240711 | Recorrente Diário       | false    | false | false | true        | false       | antecipacao recorrente deve estar ativa   | hml      |
      | 9999-4 | 387.055.390-13 | Alelo2020@ | 2004240711 | RecorrenteTotal Semanal | false    | false | false | true        | false       | antecipacao recorrente deve estar ativa   | hml      |
      | 9999-5 | 387.055.390-13 | Alelo2020@ | 2004240711 | Recorrente Desativado   | false    | false | false | true        | false       | antecipacao recorrente deve estar inativa | hml      |

  @Regressivo @arvRecorrentePos
  Esquema do Cenario: <VSTS> - Realizar Antecipacao de vendas via Modal com => <Cenario> pós contratação
    Dado que estou na logado no portal EC "<user>", "<senha>", "<ambiente>"
    Quando seleciono um CNPJ de número "<CNPJ>" no combo Estabelecimento "<operador>"
    E estou usando "<Modal>", se cenario "<Cenario>", devo alterar o valor "<Valor>", antecipar "<Recorrencia>" e contratando "<Contratacao>" "<CNPJ>" "<operador>"
    Entao eu contrato a recorrencia da operacao e valido a mensagen de sucesso "<operador>", "<Cenario>", "<modal>"
   # Entao fecho a sessao

    Exemplos: 
      | VSTS   | user           | senha      | CNPJ       | Cenario            | operador | Modal | Valor | Recorrencia | Contratacao | Resultado                         | ambiente |
      | 9999-1 | 387.055.390-13 | Alelo2020@ | 2004240711 | Recorrente Diário  | false    | true  | true  | false       | true        | ANTECIPAÇÃO REALIZADA COM SUCESSO | hml      |
      | 9999-1 | 387.055.390-13 | Alelo2020@ | 2004240711 | Recorrente Semanal | false    | true  | true  | false       | true        | ANTECIPAÇÃO REALIZADA COM SUCESSO | hml      |
