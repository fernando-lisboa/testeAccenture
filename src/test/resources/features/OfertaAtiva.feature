# language: pt
#Author: fsilva.indra@alelo.com.br
#Keywords Summary : Consulta de proposta ativa para CNPJ elegivel
#Feature: List of scenarios.
#Scenario: Visualização de Propostas ativas para cnpj pré aprovado no BB
#Given: possuo um CNPJ com proposta pré aprovada
#When: acessar o portal
#Then: visualizar sidekick
@Regressivo @propostaAtiva
Funcionalidade: Login
  Consulta de proposta ativa para CNPJ elegivel
  
  Como usuario
  Quero acessar o portal ec
  Para verificar a disponibilidade de proposta ativa pré-aprovada pelo BB

  Contexto: 
    Dado que estou na logado no portal EC "<54621917072>", "Alelo2018@"

  @desenvolve
  Esquema do Cenario: <VSTS> - Clicar no saiba mais <cenario>
    E que estou  com CNPJ elegível "<cnpj>"
    Quando clico na opção saiba mais
    Então devo ser direcionado para a tela do resumo

    Exemplos: 
      | VSTS | cenario                         | user        | password   | cnpj           |
      | 0000 | Oferta ativa para cnpj elegível | 54621917072 | Alelo2018@ | 95699678000178 |

  @desenvolve
  Esquema do Cenario: <VSTS> - Alterar Valor <cenario>
    E que estou  com CNPJ elegível "<cnpj>"
    Quando clico na opção saiba mais
    E for direcionado para a tela do resumo
    E selecionar outro valor e outra quantidade de parcelas
    Entao o valor total deve ser alterado

    Exemplos: 
      | VSTS | cenario                                        | user        | password   | cnpj           |
      | 0000 | Simular valores e parcelas diferente da oferta | 54621917072 | Alelo2018@ | 95699678000178 |

  @desenvolve
  Esquema do Cenario: <VSTS> - Voltar sem alterar <cenario>
    E que estou  com CNPJ elegível "<cnpj>"
    E clico na opção saiba mais
    E for direcionado para a tela do resumo
    Quando clicar na opcao alterar valor e voltar sem alterar
    Entao os dados oferecidos nao devem ser alterados

    Exemplos: 
      | VSTS | cenario                                        | user        | password   | cnpj           |
      | 0000 | Clicar em alterar valores e voltar sem alterar | 54621917072 | Alelo2018@ | 95699678000178 |
