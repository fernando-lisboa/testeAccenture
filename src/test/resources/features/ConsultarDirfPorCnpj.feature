#language: pt
#/**
# * Autor: Fernando Lisboa
# * Empresa: Taiking
# * Data: 30/05/2019
# * Caminho: Portal Estabelecimento Comercia - Consulta DIRF
# */
@consultaDirf @front @Regressao
Funcionalidade: Consulta DIRF
    Consultar e gerar pdf de informações do imposto de rendas disponíveis por EC
  
  Eu como usuário
  Desejo consultar meses e anos disponíveis de informações do imposto de renda DIRF por estabelecimento comercial
  Para uso de informativo de IR

   Contexto: 
    Dado que estou na logado no portal EC "<54621917072>", "Alelo2018@"

  @Release-33  @Regressivo @consultaDirf
  Esquema do Cenario: [Busca web] "<Cenario>"-"<DescricaoDoCenario>"
    Dado eu clique no link de informacoes
    E e visualizar a lista de anos disponiveis
    Quando clicar no botao baixar arquivo "<anoReferencia>"
    Entao o arquivo deve ser baixado no local informado

    Exemplos: 
      | Cenario | DescricaoDoCenario                       | anoReferencia |
      | CT-1.01 | efetuar download  de arquivo DIRF - 2018 |          2018 |
      | CT-1.02 | efetuar download  de arquivo DIRF - 2017 |          2017 |
      | CT-1.03 | efetuar download  de arquivo DIRF - 2016 |          2016 |
      | CT-1.04 | efetuar download  de arquivo DIRF - 2015 |          2015 |
      | CT-1.05 | efetuar download  de arquivo DIRF - 2014 |          2014 |
      | CT-1.05 | efetuar download  de arquivo DIRF - 2012 |          2012 |
