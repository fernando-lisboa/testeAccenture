#language: pt
#/**
# * Autor: Fernando Lisboa
# * Empresa: Taking
# * Data: 06/02/2020
# * Caminho: Portal Estabelecimento Comercial
# */
@Regressivo @Simulation
Funcionalidade: Painel Meu Negocio
  Contratação de painel meu negócio
  
  Eu como usuário do portal
  Desejo fazer contratação e cancelamento do PAINEL MEU NEGÓCIO
  Para clientes inadimplentes

  Contexto: 


  Esquema do Cenario: <VSTS> - Painel <cenario>
    Dado que estou na logado no portal EC Operador "<user>", "<senha>"
    E vou pedir ajuda no atendimento e acesso a outra aba do navegador "<operador>"
    Quando seleciono um CNPJ de número "<CNPJ>" no combo Estabelecimento "<operador>"
    Entao eu devo efetuar uma simulacao de contratacao via sidekick operador

    Exemplos: 
      | VSTS   | user           | senha      | CNPJ       | Cenario                                         | statusEsperado | Modal | Valor | Antecipacao | Contratacao | Resultado                                      |
      | 9999-5 | 012.345.678-90 | Alelo2020@ | 1015000387 | Efetivar contratação dentro do periodo gratuito | TESTE GRÁTIS   | true  | false | true        | true        | SIMULAÇÃO DE ANTECIPAÇÃO REALIZADA COM SUCESSO |


  Esquema do Cenario: <VSTS> - Painel <cenario>
    Dado que estou na logado no portal EC Operador "<user>", "<senha>"
    E vou pedir ajuda no atendimento e acesso a outra aba do navegador "<operador>"
    Entao eu devo efetuar uma simulacao cancelamento de Painel meu negocio

    Exemplos: 
      | VSTS   | user           | senha      | CNPJ       | Cenario                                         | statusEsperado | Modal | Valor | Antecipacao | Contratacao | Resultado                                      |
      | 9999-5 | 012.345.678-90 | Alelo2020@ | 2004078183 | Efetivar contratação dentro do periodo gratuito | TESTE GRÁTIS   | true  | false | true        | true        | SIMULAÇÃO DE ANTECIPAÇÃO REALIZADA COM SUCESSO |
