#language: pt
#/**
# * Autor: Fernando Lisboa
# * Empresa: Taking
# * Data: 06/02/2020
# * Caminho: Portal Estabelecimento Comercial
# */
@Regressivo @ContratacaoWeb
Funcionalidade: Painel
  Contratação de painel meu negócio
  
  Eu como usuário do portal
  Desejo fazer contratação e cancelamento do PAINEL MEU NEGÓCIO
  Para clientes inadimplentes

  Contexto: 
    Dado que estou na logado no portal EC "546.219.170-72", "Alelo2018@"
    #SDado que estou na logado no portal EC "077.422.686-20", "F3@6t6x8"

  @PainelContratacaoWeb @Regressivo
  Esquema do Cenario: <VSTS> - Painel <cenario>
    Quando efetuar uma contratacao via sidekick "<cnpj>"
    Entao devo validar o status da contratacao e suas respectivas datas "<statusEsperado>"
 
      Exemplos:
      | VSTS | cenario                                         | statusEsperado | cnpj           |
     | 9999 | Efetivar contratação dentro do periodo gratuito | TESTE GRÁTIS   | 82143278000182 |
     | 9999 | Efetivar contratação fora do periodo gratuito   | Contratado     | 12259140000168 |

  @PainelCancelamento @Regressivo
  Esquema do Cenario: <VSTS> - Painel <cenario>
    Quando efetuar o cancelamento do produto painel meu negocio "<cnpj>"
    Entao devo validar o status do cancelamento e suas respectivas datas "<statusEsperado>"

      Exemplos:
      | VSTS | cenario                                          | statusEsperado | cnpj           |
      | 9999 | Efetivar Cancelamento dentro do periodo gratuito | TESTE GRÁTIS   | 28339982000160 |
      | 9999 | Efetivar Cancelamento fora do periodo gratuito   | Cancelado      | 41707658000115 |
