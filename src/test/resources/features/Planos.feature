#language: pt
#/**
# * @author Fernando Lisboa - Taking
# * Change: 08/01/2019 | Author: Jessé Dantas - Taking
# * Caminho: Portal Estabelecimento Comercial
# */
@Planos @front @Regressao
Funcionalidade: Planos
  Permite realizar a contratação de planos
    
  Eu como usuario 
  Quero contratar planos para o meu estabelecimento 
  Para ter a flexibilidade de receber quando necessito

  Contexto: 
    Dado que estou na logado no portal EC "<54621917072>", "Alelo2018@"

  @Release-15 @portalEC @realizar_contratacao_opcao
  Esquema do Cenario: <VSTS> - Realizar contratacao <cenario> com sucesso
    Quando clico no SideKick no menu expansivel lateral de contratacao
    E seleciono a opcao <cenario>
    E clico em Aceitar Termos
    E clico em Contratar
    Entao o Portal EC realiza a contratacao

    Exemplos: 
      | VSTS | cenario |
      |      |       1 |
      |      |       2 |
      |      |       3 |

  @Release-15 @portalEC @#felipe_lourenco @cancelar_contratacao @fechar_contratacao
  Esquema do Cenario: <VSTS> - <cenario> contratacao de planos
    Quando clico no SideKick no menu expansivel lateral de contratacao
    E seleciono uma opcao
    E clico em Aceitar Termos
    E clico em <cenario> contratacao
    Entao o Portal EC <validacao> antecipacao

    Exemplos: 
      | VSTS | cenario  | validacao     |
      |      | Cancelar | cancela       |
      |      | Fechar   | fecha o modal |
