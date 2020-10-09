#language: pt
#/**
# * Autor: Michael Alba
# * Empresa: Taking
# * Data: 30/03/2020
# * Caminho: Portal Estabelecimento Comercial
# */
@Regressivo @Simulation
Funcionalidade: Simulação de Antecipacao => ARV
  Permite realizar antecipação dos valores a receber
  
  Eu como usuario
  Quero antecipar os valores do meu estabelecimento
  Para ter a flexibilidade de receber quando necessito

  Contexto: 
    Dado que o banco de arv esteja preparado para os testes
@SimularOperador
  Esquema do Cenario: <VSTS> - Realizar Simulação de antecipacao de vendas => <Cenario>
    Dado que estou na logado no portal EC Operador "<user>", "<senha>"
    E vou pedir ajuda no atendimento e acesso a outra aba do navegador "<operador>"
    Quando seleciono um CNPJ de número "<CNPJ>" no combo Estabelecimento "<operador>"
    E estou usando "<Modal>", se cenario "<Cenario>", devo alterar o valor "<Valor>", antecipar "<Recorrencia>" e contratando "<Contratacao>" "<CNPJ>" "<operador>"

    Exemplos: 
      | VSTS   | user           | senha      | CNPJ       | Cenario                          | operador | Modal | Valor | Recorrencia | Contratacao | Resultado                                      |
      | 9999-1 | 273.824.010-06 | Alelo2020@ | 2004240711 | Parcial operador                 | true     | true  | true  | false       | true        | SIMULAÇÃO DE ANTECIPAÇÃO REALIZADA COM SUCESSO |
      | 9999-2 | 273.824.010-06 | Alelo2020@ | 2004240711 | Total operador                   | true     | true  | false | false       | true        | SIMULAÇÃO DE ANTECIPAÇÃO REALIZADA COM SUCESSO |
      | 9999-4 | 273.824.010-06 | Alelo2020@ | 2004240711 | RecorrenteTotal Semanal operador | true     | true  | false | false       | true        | SIMULAÇÃO DE ANTECIPAÇÃO REALIZADA COM SUCESSO |
      | 9999-3 | 273.824.010-06 | Alelo2020@ | 2004240711 | Recorrente Diário operador       | true     | true  | false | false       | true        | SIMULAÇÃO DE ANTECIPAÇÃO REALIZADA COM SUCESSO |
      | 9999-5 | 273.824.010-06 | Alelo2020@ | 2004240711 | Recorrente Desativado operador   | true     | true  | false | false       | true        | SIMULAÇÃO DE ANTECIPAÇÃO REALIZADA COM SUCESSO |
  
 @ignore
  Esquema do Cenario: <VSTS> - Realizar Simulação de antecipacao de vendas - VIA PÁGINA=> <Cenario>
    Dado que estou na logado no portal EC Operador "<user>", "<senha>"
    E vou pedir ajuda no atendimento e acesso a outra aba do navegador "<operador>"
    Quando seleciono um CNPJ de número "<CNPJ>" no combo Estabelecimento "<operador>"
    E estou usando "<Modal>", se cenario "<Cenario>", devo alterar o valor "<Valor>", antecipar "<Recorrencia>" e contratando "<Contratacao>" "<CNPJ>" "<operador>"

    Exemplos: 
      | VSTS   | user           | senha      | CNPJ       | Cenario                          | operador | Modal | Valor | Recorrencia | Contratacao | Resultado                                      |
      #| 9999-1 | 273.824.010-06 | Alelo2020@ | 2004240711 | Parcial operador                 | true     | false | true  | false       | true        | SIMULAÇÃO DE ANTECIPAÇÃO REALIZADA COM SUCESSO |
      #| 9999-2 | 273.824.010-06 | Alelo2020@ | 2004240711 | Total operador                   | true     | false | false | false       | true        | SIMULAÇÃO DE ANTECIPAÇÃO REALIZADA COM SUCESSO |
      #| 9999-3 | 273.824.010-06 | Alelo2020@ | 2004240711 | Recorrente Diário operador       | true     | false | false | false        | false       | SIMULAÇÃO DE ANTECIPAÇÃO REALIZADA COM SUCESSO |
      #| 9999-4 | 273.824.010-06 | Alelo2020@ | 2004240711 | RecorrenteTotal Semanal operador | true     | false | false | false        | false       | SIMULAÇÃO DE ANTECIPAÇÃO REALIZADA COM SUCESSO |
      #| 9999-5 | 273.824.010-06 | Alelo2020@ | 2004240711 | Recorrente Desativado operador   | true     | false | false | false        | false       | SIMULAÇÃO DE ANTECIPAÇÃO REALIZADA COM SUCESSO |

  @SimulacaoComRecorrencia  @SimularOperador @OK
  Esquema do Cenario: <VSTS> - Realizar Simulação de antecipacao de vendas com recorrencia <Cenario>
    Dado que estou na logado no portal EC Operador "<user>", "<senha>"
    E vou pedir ajuda no atendimento e acesso a outra aba do navegador "<operador>"
    Quando seleciono um CNPJ de número "<CNPJ>" no combo Estabelecimento "<operador>"
    E estou usando "<Modal>", se cenario "<Cenario>", devo alterar o valor "<Valor>", antecipar "<Recorrencia>" e contratando "<Contratacao>" "<CNPJ>" "<operador>"
    Entao eu contrato a recorrencia da operacao e valido a mensagen de sucesso "<operador>", "<cenario>", "<modal>"

    Exemplos: 
      | VSTS   | user           | senha      | CNPJ       | Cenario          | operador | Modal | Valor | Recorrencia | Contratacao | cenario                 | modal    |
     | 9999-1 | 273.824.010-06 | Alelo2020@ | 2004240711 | Parcial operador | true     | true  | true  | false       | true        | Recorrente Diário       | inicio   |
      | 9999-2 | 273.824.010-06 | Alelo2020@ | 2004240711 | Total operador   | true     | true  | false | false       | true        | RecorrenteTotal Semanal | inicio   |
     
     #Esses testes era para a página de antecipe que não está funcional mais
     
      #| 9999-3 | 273.824.010-06 | Alelo2020@ | 2004240711 | Parcial operador | true     | false | true  | false       | true        | Recorrente Diário       | antecipe |
      #| 9999-4 | 273.824.010-06 | Alelo2020@ | 2004240711 | Total operador   | true     | false | false | false       | true        | RecorrenteTotal Semanal | antecipe |
      
      
  @SimulacaoSidekick @Ok
  Esquema do Cenario: <VSTS> - Validação da presença do sidekick => <Cenario>
    Dado que estou na logado no portal EC Operador "<user>", "<senha>"
    E vou pedir ajuda no atendimento e acesso a outra aba do navegador "<operador>"
    Entao valido que o sidkick de simulação está presente e todos os menus "<operador>"

    Exemplos: 
      | VSTS   | user           | senha      | ARV  | Cenario  | operador | Modal | Valor | Antecipacao |
      | 9999-1 | 273.824.010-06 | Alelo2020@ | true | sidekick | true     | true  | true  | false       |
  
