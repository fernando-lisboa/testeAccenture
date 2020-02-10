#language: pt

#/**
# * Autor: Fernando Lisboa
# * Empresa: Taking
# * Data: 06/12/2019
# * Caminho: Portal Estabelecimento Comercial
# */

@Antecipacao
Funcionalidade: Antecipacao
  Permite realizar antecipação dos valores a receber
  
  Eu como usuario 
  Quero antecipar os valores do meu estabelecimento 
  Para ter a flexibilidade de receber quando necessito

  Contexto: 
    Dado que estou na logado no portal EC "<546.219.170-72>", "Alelo2018@"

  @Release-33 
  Cenario: Realizar antecipacao de vendas
    Quando clico no SideKick no menu expansivel lateral de antecipacao de recebiveis
    E clico em concordo com os termos de antecipacao de recebiveis
    E clico em Antecipar Agora
    Entao Portal EC realiza a antecipacao

  @Release-33 
  Cenario: Cancelar antecipacao de planos
    Quando clico no SideKick no menu expansivel lateral de antecipacao de recebiveis
    E clico em concordo com os termos de antecipacao de recebiveis
    E clico em Cancelar antecipacao de recebiveis
    Entao o Portal EC cancela antecipacao

  @Release-33 
  Cenario: Fechar antecipacao de planos
    Quando clico no SideKick no menu expansivel lateral de antecipacao de recebiveis
    E clico em concordo com os termos de antecipacao de recebiveis
    E clico no botao Fechar antecipacao de recebiveis
    Entao o Portal EC fecha o modal antecipacao

  @Release-33 
  Cenario: Realizar alteracao de valor da antecipacao de vendas
    Quando clico no SideKick no menu expansivel lateral de antecipacao de recebiveis
    E clico em alterar valor
    E insiro um valor abaixo do valor que desejo antecipar
    E clico em vizualizar valores disponiveis
    E seleciono a opção desejada
    E clico calcular valor liquido
    E clico em concordo com os termos de antecipacao de recebiveis
    E clico em Antecipar Agora
    Entao Portal EC realiza a antecipacao

  @Release-33 
  Cenario: Cancelar alteracao de valor da antecipacao de vendas
    Quando clico no SideKick no menu expansivel lateral de antecipacao de recebiveis
    E clico em alterar valor
    E insiro um valor abaixo do valor que desejo antecipar
    E clico em vizualizar valores disponiveis
    E seleciono a opção desejada
    E clico no botao cancelar alteracao valores
    Entao o Portal EC retorna para o modal da antecipacao

  @Release-33 
  Cenario: Alterar recorrencia antecipacao de vendas
    Quando clico no SideKick no menu expansivel lateral de antecipacao de recebiveis
    E clico no botao alterar recorrencia antecipacao de recebiveis
    E seleciono a opcao semanal
    E seleciono o dia da semana
    E clico em definir recebimento
    E clico em concordo com os termos de antecipacao de recebiveis
    Entao o Portal EC retorna para o modal da antecipacao

  @Release-33
  Cenario: Desativar recorrencia antecipacao de vendas
    Quando clico no SideKick no menu expansivel lateral de antecipacao de recebiveis
    E clico no botao alterar recorrencia antecipacao de recebiveis
    E seleciono a opcao desativada
    E clico em definir recebimento
    E clico em concordo com os termos de antecipacao de recebiveis
    E clico em Antecipar Agora
    Entao o Portal EC retorna para o modal da antecipacao

  @Release-33 
  Cenario: Cancelar recorrencia
    Quando clico no SideKick no menu expansivel lateral de antecipacao de recebiveis
    E clico no botao alterar recorrencia antecipacao de recebiveis
    E seleciono a opcao desativada
    E clico no botao cancelar recorrencia
    Entao o Portal EC retorna para o modal da antecipacao

  @Release-33 
  Cenario: Validar informacoes da API do Sidekick de ARV
    Dado que informo os parametros de Login da api
    E que realizo o post para obter o access token
    Quando executo o comando get com access token na api do Sidekick de ARV
    Entao valido o retorno da api
    E imprimo a resposta

  ################################################TESTES DE NOVA TELA DE ARV##################################################################
  # * Autor: Fernando Lisboa
  # * Empresa: Taiking
  # * Data: 16/05/2019
  # * Caminho: Portal Estabelecimento Comercial / Antecipação ARV nova tela sem modal
  # */
  @Release-33
  Cenario: Realizar antecipacao de vendas via link no Banner
    Quando clicar no banner com campanha de antecipacao de recebiveis
    E clico em concordo com os termos de antecipacao de recebiveis
    E clico em Antecipar Agora
    Entao Portal EC realiza a antecipacao

  @Release-33 
  Cenario: Cancelar antecipacao de planos
    Quando clicar no banner com campanha de antecipacao de recebiveis
    E clico em concordo com os termos de antecipacao de recebiveis
    E clico em Cancelar antecipacao de recebiveis
    Entao o Portal EC cancela antecipacao

  @Release-33 
  Cenario: Fechar antecipacao de planos
    Quando clicar no banner com campanha de antecipacao de recebiveis
    E clico em concordo com os termos de antecipacao de recebiveis
    E clico no botao Fechar antecipacao de recebiveis
    Entao o Portal EC fecha o modal antecipacao

  @Release-33 
  Cenario: Realizar alteracao de valor da antecipacao de vendas
    Quando clicar no banner com campanha de antecipacao de recebiveis
    E clico em alterar valor
    E insiro um valor abaixo do valor que desejo antecipar
    E clico em vizualizar valores disponiveis
    E seleciono a opção desejada
    E clico calcular valor liquido
    E clico em concordo com os termos de antecipacao de recebiveis
    E clico em Antecipar Agora
    Entao Portal EC realiza a antecipacao

  @Release-33 
  Cenario: Cancelar alteracao de valor da antecipacao de vendas
    Quando clicar no banner com campanha de antecipacao de recebiveis
    E clico em alterar valor
    E insiro um valor abaixo do valor que desejo antecipar
    E clico em vizualizar valores disponiveis
    E seleciono a opção desejada
    E clico no botao cancelar alteracao valores
    Entao o Portal EC retorna para o modal da antecipacao

  @Release-33 
  Cenario: Alterar recorrencia antecipacao de vendas
    Quando clicar no banner com campanha de antecipacao de recebiveis
    E clico no botao alterar recorrencia antecipacao de recebiveis
    E seleciono a opcao semanal
    E seleciono o dia da semana
    E clico em definir recebimento
    E clico em concordo com os termos de antecipacao de recebiveis
    Entao o Portal EC retorna para o modal da antecipacao

  @Release-33 
  Cenario: Desativar recorrencia antecipacao de vendas
    Quando clicar no banner com campanha de antecipacao de recebiveis
    E clico no botao alterar recorrencia antecipacao de recebiveis
    E seleciono a opcao desativada
    E clico em definir recebimento
    E clico em concordo com os termos de antecipacao de recebiveis
    E clico em Antecipar Agora
    Entao o Portal EC retorna para o modal da antecipacao

  @Release-33 
  Cenario: Cancelar recorrencia
    Quando clicar no banner com campanha de antecipacao de recebiveis
    E clico no botao alterar recorrencia antecipacao de recebiveis
    E seleciono a opcao desativada
    E clico no botao cancelar recorrencia
    Entao o Portal EC retorna para o modal da antecipacao
