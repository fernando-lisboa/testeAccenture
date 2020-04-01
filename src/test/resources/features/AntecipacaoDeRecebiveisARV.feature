#language: pt
#/**
# * Autor: Fernando Lisboa
# * Empresa: Taking
# * Data: 30/03/2020
# * Caminho: Portal Estabelecimento Comercial
# */
@Antecipacao @front @Regressao
Funcionalidade: Antecipacao
  Permite realizar antecipação dos valores a receber
  
  Eu como usuario 
  Quero antecipar os valores do meu estabelecimento 
  Para ter a flexibilidade de receber quando necessito

  Contexto: 
    Dado que estou na logado no portal EC "594.114.000-27", "Alelo2020@"

  @realizar_antecipacao
  Esquema do Cenario: <VSTS> - Realizar Simulação de antecipacao de vendas => <cenario>
    Quando clico no SideKick no menu expansivel lateral de antecipacao de recebiveis
    E seleciono a opcao de alterar valor e escolher o valor desejado e clicar no botao de vizualizacao de valores
    E clicar na opcao de vizualizar valores liquidos For encaminhado para a tela de contratacao
    Entao devo vizualizar os valores disponiveis para antecipacao do valor aproximado solicitado com o botao contratar agora desabilitado

    Exemplos: 
      | VSTS   | cenario           | cnpj           |
      | 9999-1 | Parcial           | 28339982000160 |
      | 9999-2 | Total             | 28339982000160 |
      | 9999-4 | Recorrente Diário | 28339982000160 |
      | 9999-5 | Total Semanal     | 28339982000160 |
