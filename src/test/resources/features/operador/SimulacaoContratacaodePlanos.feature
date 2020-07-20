#language: pt
#/**
# * Autor: Michael Alba
# * Empresa: Taking
# * Data: 30/03/2020
# * Caminho: Portal Estabelecimento Comercial
# */
@Regressivo @SimulacaoPlanos 
Funcionalidade: Contratação de Planos
  Permite contratar planos
  
  Contexto:
  Dado que eu tenha planos disponíveis para cantratação
  

  @realizar_contratacao
  Esquema do Cenario: <VSTS> - Realizar Simulação de contratação de planos => <Cenario>
    Dado que estou na logado no portal EC Operador "<user>", "<senha>"
    E vou pedir ajuda no atendimento e acesso a outra aba do navegador "<operador>"
    Quando seleciono um CNPJ de número "<CNPJ>" no combo Estabelecimento "<operador>"
    E contratando plano de "<Cenario>" e contratando "<Contratacao>" "<operador>"

    #Entao a validacao do cenario deve conter como resultado "<Resultado>"
    Exemplos: 
      | VSTS   | user           | senha      | CNPJ                              | Cenario          | operador | Contratacao | Resultado                                      |
      | 9999-1 | 570.335.010-72 | Alelo2020@ | 2000496258 | Plano de 02 dias | true     | true        | SIMULAÇÃO DE ANTECIPAÇÃO REALIZADA COM SUCESSO |
      | 9999-1 | 570.335.010-72 | Alelo2020@ | 2000496258 | Plano de 07 dias | true     | true        | SIMULAÇÃO DE ANTECIPAÇÃO REALIZADA COM SUCESSO |
      | 9999-1 | 570.335.010-72 | Alelo2020@ | 2000496258 | Plano de 15 dias | true     | true        | SIMULAÇÃO DE ANTECIPAÇÃO REALIZADA COM SUCESSO |
