#language: pt
#/**
# * Autor: Michael Alba
# * Empresa: Taking
# * Data: 30/03/2020
# * Caminho: Portal Estabelecimento Comercial
# */
@Regressivo @Simulacao @01
Funcionalidade: Antecipacao
  Permite realizar antecipação dos valores a receber
  
  Eu como usuario
  Quero antecipar os valores do meu estabelecimento
  Para ter a flexibilidade de receber quando necessito

  Contexto: 
    Dado que o banco de arv esteja preparado para os testes

  @SimularOperador @Simulacao
  Esquema do Cenario: <VSTS> - Realizar Simulação de antecipacao de vendas => <Cenario>
    Dado que estou na logado no portal EC Operador "<user>", "<senha>"
    E vou pedir ajuda no atendimento e acesso a outra aba do navegador "<operador>"
    Quando seleciono um CNPJ de número "<CNPJ>" no combo Estabelecimento "<operador>"
    E estou usando "<Modal>", se cenario "<Cenario>", devo alterar o valor "<Valor>", antecipar "<Recorrencia>" e contratando "<Contratacao>" "<CNPJ>" "<operador>"
    Entao a validacao do cenario deve conter como resultado "<Resultado>"

    Exemplos: 
      | VSTS   | user           | senha      | CNPJ                              | Cenario                          | operador | Modal | Valor | Recorrencia | Contratacao | Resultado                                      |
      | 9999-1 | 273.824.010-06 | Alelo2020@ | • 28.339.982/0001-60 - 2000496258 | Parcial operador                 | true     | true  | true  | false       | true        | SIMULAÇÃO DE ANTECIPAÇÃO REALIZADA COM SUCESSO |
      | 9999-2 | 273.824.010-06 | Alelo2020@ | • 28.339.982/0001-60 - 2000496258 | Total operador                   | true     | true  | false | false       | true        | SIMULAÇÃO DE ANTECIPAÇÃO REALIZADA COM SUCESSO |
      | 9999-4 | 273.824.010-06 | Alelo2020@ | • 28.339.982/0001-60 - 2000496258 | RecorrenteTotal Semanal operador | true     | true  | false | false       | true        | SIMULAÇÃO DE ANTECIPAÇÃO REALIZADA COM SUCESSO |
      | 9999-3 | 273.824.010-06 | Alelo2020@ | • 28.339.982/0001-60 - 2000496258 | Recorrente Diário operador       | true     | true  | false | false       | true        | SIMULAÇÃO DE ANTECIPAÇÃO REALIZADA COM SUCESSO |
      | 9999-5 | 273.824.010-06 | Alelo2020@ | • 28.339.982/0001-60 - 2000496258 | Recorrente Desativado operador   | true     | true  | false | false       | true        | SIMULAÇÃO DE ANTECIPAÇÃO REALIZADA COM SUCESSO |

  @SimularOperadorViaPagina @Simulacao @02
  Esquema do Cenario: <VSTS> - Realizar Simulação de antecipacao de vendas - VIA PÁGINA=> <Cenario>
    Dado que estou na logado no portal EC Operador "<user>", "<senha>"
    E vou pedir ajuda no atendimento e acesso a outra aba do navegador "<operador>"
    Quando seleciono um CNPJ de número "<CNPJ>" no combo Estabelecimento "<operador>"
    E estou usando "<Modal>", se cenario "<Cenario>", devo alterar o valor "<Valor>", antecipar "<Recorrencia>" e contratando "<Contratacao>" "<CNPJ>" "<operador>"

    Exemplos: 
      | VSTS   | user           | senha      | CNPJ                               | Cenario                          | operador | Modal | Valor | Recorrencia | Contratacao | Resultado                                      |
      | 9999-1 | 273.824.010-06 | Alelo2020@ | • 28.339.982/0001-60 - 2000496258 | Parcial operador                 | true     | false  | true  | false       | true        | SIMULAÇÃO DE ANTECIPAÇÃO REALIZADA COM SUCESSO |
      | 9999-2 | 273.824.010-06 | Alelo2020@ | • 28.339.982/0001-60 - 2000496258 | Total operador                   | true     | false  | false | false       | true        | SIMULAÇÃO DE ANTECIPAÇÃO REALIZADA COM SUCESSO |
      | 9999-3 | 273.824.010-06 | Alelo2020@ | • 28.339.982/0001-60 - 2000496258 | Recorrente Diário operador       | true     | false  | false | true        | false        | SIMULAÇÃO DE ANTECIPAÇÃO REALIZADA COM SUCESSO |
      | 9999-4 | 273.824.010-06 | Alelo2020@ | • 28.339.982/0001-60 - 2000496258 | RecorrenteTotal Semanal operador | true     | false  | false | true        | false        | SIMULAÇÃO DE ANTECIPAÇÃO REALIZADA COM SUCESSO |
      | 9999-5 | 273.824.010-06 | Alelo2020@ | • 28.339.982/0001-60 - 2000496258 | Recorrente Desativado operador   | true     | false  | false | true        | false        | SIMULAÇÃO DE ANTECIPAÇÃO REALIZADA COM SUCESSO |

  @SimularOperador @Simulacao 
  Esquema do Cenario: <VSTS> - Realizar Simulação de antecipacao de vendas => <Cenario>
    Dado que estou na logado no portal EC Operador "<user>", "<senha>"
    E vou pedir ajuda no atendimento e acesso a outra aba do navegador "<operador>"
    Quando seleciono um CNPJ de número "<CNPJ>" no combo Estabelecimento "<operador>"
    Entao valido que o sidkick de simulação está presente e todos os menus "<operador>"

    Exemplos: 
      | VSTS   | user           | senha      | ARV  | Cenario  | operador | Modal | Valor | Antecipacao | Resultado                                                              |
      | 9999-1 | 273.824.010-06 | Alelo2020@ | true | sidekick | true     | true  | true  | false       | valor bruto deve ser menor que o valor liquido apresentado na abertura |
