#language: pt
#/**
# * Autor: Fernando Lisboa
# * Empresa: Taking
# * Data: 06/02/2020
# * Caminho: Portal Estabelecimento Comercial
# */
@Regressivo
Funcionalidade: Painel Meu Negocio
  Contratação de painel meu negócio
  
  Eu como usuário do portal
  Desejo fazer contratação e cancelamento do PAINEL MEU NEGÓCIO
  Para clientes inadimplentes

  Contexto: 

  @SimulacaoContratacaoWeb @Regressivo
  Esquema do Cenario: <VSTS> - Painel <cenario>
    Dado que estou na logado no portal EC Operador "<user>", "<senha>"
    Quando seleciono um CNPJ diferente que tenha "<ARV>" no combo Estabelecimento
    Entao devo validar o status da contratacao e suas respectivas datas "<statusEsperado>"

    Exemplos: 
      | VSTS   | cenario                                         | statusEsperado | cnpj           | user           | senha      |
      | 9999-1 | Efetivar contratação dentro do periodo gratuito | TESTE GRÁTIS   | 82143278000182 | 012.345.678-90 | Alelo2020@ |
      | 9999-2 | Efetivar contratação fora do periodo gratuito   | Contratado     | 12259140000168 | 012.345.678-90 | Alelo2020@ |

  @SimulacaoContratacaoWeb @Regressivo
  Esquema do Cenario: <VSTS> - Painel <cenario>
    Dado que estou na logado no portal EC Operador "<user>", "<senha>"
    Quando efetuar o cancelamento do produto painel meu negocio "<cnpj>"
    Entao devo validar o status do cancelamento e suas respectivas datas "<statusEsperado>"

    Exemplos: 
      | VSTS   | cenario                                          | statusEsperado | cnpj           | user           | senha      |
      | 9999-3 | Efetivar Cancelamento dentro do periodo gratuito | TESTE GRÁTIS   | 28339982000160 | 012.345.678-90 | Alelo2020@ |
      | 9999-4 | Efetivar Cancelamento fora do periodo gratuito   | Cancelado      | 41707658000115 | 012.345.678-90 | Alelo2020@ |
