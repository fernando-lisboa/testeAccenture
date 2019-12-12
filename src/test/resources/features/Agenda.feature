#language: pt
#/**
# * Autor: Fernando Lisboa
# * Empresa: Taking
# * Data: 06/12/2019
# * Caminho: Portal Estabelecimento Comercial
# */

@Regressivo
Funcionalidade: Agenda
  Permite a consulta dos valores a serem disponibilizados ao usuario ao longo do mes

   Contexto: 
    Dado que estou na logado no portal EC "<54621917072>", "Alelo2018@"

  @Release-15  @Regressivo
  Cenario: Realizar consulta do dia atual com sucesso
    Quando que estou na tela Agenda
    E seleciono o campo correspondente ao dia atual
    Entao o Portal EC apresenta a tela de Extrato do respectivo dia

  @Release-15  @Regressivo
  Cenario: Realizar consulta em Agenda com botao Avancar
    Quando que estou na tela Agenda
    E seleciono o botao avancar no mes
    Entao o Portal EC apresenta a tela de Agenda do respectivo mes

  @Release-15  @Regressivo
  Cenario: Realizar consulta em Agenda com botao Retroceder
    Quando que estou na tela Agenda
    E seleciono o botao retroceder no mes
    Entao o Portal EC apresenta a tela de Agenda do respectivo mes

  @Release-15  @Regressivo
  Cenario: Acessar a tela Agenda atraves do painel
    Quando estou na home page
    E clico no botao Veja mais detalhes
    Entao o Portal EC apresenta a tela de agenda

 @Release-15  @Regressivo
  Cenario: Validar link do banner superior esquerdo com sucesso
    Quando que estou na tela Agenda
    E clico no banner esquerdo
    Entao o sistema redireciona para a tela marketing cadastrada esquerdo

 @Release-15  @Regressivo
  Cenario: Validar link do banner superior direito com sucesso
    Quando que estou na tela Agenda
    E clico no banner direito
    Entao o sistema redireciona para a tela marketing cadastrada direito

  @Release-15  @Regressivo
  Cenario: Extrair comprovante em PDF - superior
    Quando que estou na tela Agenda
    E seleciono o campo correspondente ao dia atual
    E clico no botao comprovantes
    E clico no botao Baixar em PDF superior
    Entao o sistema baixa o extrato em PDF

 @Release-15  @Regressivo
  Cenario: Extrair comprovante em PDF - inferior
    Quando que estou na tela Agenda
    E seleciono o campo correspondente ao dia atual
    E clico no botao comprovantes
    E clico no botao Baixar em PDF inferior
    Entao o sistema baixa o extrato em PDF

  @Release-15  @Regressivo
  Cenario: Extrair comprovante em CSV - superior
    Quando que estou na tela Agenda
    E seleciono o campo correspondente ao dia atual
    E clico no botao comprovantes
    E clico no botao Baixar em CSV superior
    Entao o sistema baixa o extrato em CSV

 @Release-15  @Regressivo
  Cenario: Extrair comprovante em CSV - inferior
    Quando que estou na tela Agenda
    E seleciono o campo correspondente ao dia atual
    E clico no botao comprovantes
    E clico no botao Baixar em CSV inferior
    Entao o sistema baixa o extrato em CSV

  @Release-15  @Regressivo
  Cenario: Imprimir comprovante - superior
    Quando que estou na tela Agenda
    E seleciono o campo correspondente ao dia atual
    E clico no botao comprovantes
    E clico no botao Imprimir comprovante superior
    Entao o sistema imprime o comprovante

  @Release-15  @Regressivo
  Cenario: Imprimir comprovante - inferior
    Quando que estou na tela Agenda
    E seleciono o campo correspondente ao dia atual
    E clico no botao comprovantes
    E clico no botao Imprimir comprovante inferior
    Entao o sistema imprime o comprovante

