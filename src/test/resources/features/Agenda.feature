#language: pt
#/**
# * @author Fernando Lisboa - Taking
# * Change: 08/01/2019 | Author: Jessé Dantas - Taking
# * Caminho: Portal Estabelecimento Comercial
# */
@Regressivo
Funcionalidade: Agenda
  Permite a consulta dos valores a serem disponibilizados ao usuario ao longo do mes

  Contexto: 
    Dado que estou na logado no portal EC "54621917072", "Alelo2018@"

  @Release-33 @Regressivo
  Esquema do Cenario: <VSTS> - Realizar consulta do dia atual com sucesso
    Quando que estou na tela Agenda
    E seleciono o campo correspondente ao dia atual
    Entao o Portal EC apresenta a tela de Extrato do respectivo dia

    Exemplos: 
      | VSTS |
      |      |

  @Release-33 @Regressivo
  Esquema do Cenario: <VSTS> - Realizar consulta em Agenda com botao <botao>
    Quando que estou na tela Agenda
    E seleciono o botao <botao> no mes
    Entao o Portal EC apresenta a tela de Agenda do respectivo mes

    Exemplos: 
      | VSTS | botao      |
      |      | avancar    |
      |      | retroceder |

  @Release-33 @Regressivo
  Esquema do Cenario: <VSTS> - Acessar a tela Agenda atraves do painel
    Quando estou na home page
    E clico no botao Veja mais detalhes
    Entao o Portal EC apresenta a tela de agenda

    Exemplos: 
      | VSTS |
      |      |

  @Release-33 @Regressivo
  Esquema do Cenario: <VSTS> - Validar link do banner superior <banner>
    Quando que estou na tela Agenda
    E clico no banner <banner>
    Entao o sistema redireciona para a tela marketing cadastrada <banner>

    Exemplos: 
      | VSTS | banner   |
      |      | esquerdo |
      |      | direito  |

  @Release-33 @Regressivo
  Esquema do Cenario: <VSTS> - Extrair comprovante em <tipo_arquivo> <angulo>
    Quando que estou na tela Agenda
    E seleciono o campo correspondente ao dia atual
    E clico no botao comprovantes
    E clico no botao Baixar em <tipo_arquivo> <angulo>
    Entao o sistema baixa o extrato em <tipo_arquivo>

    Exemplos: 
      | VSTS | tipo_arquivo | angulo   |
      |      | PDF          | superior |
      |      | PDF          | inferior |
      |      | CSV          | superior |
      |      | CSV          | inferior |

  @Release-33 @Regressivo
  Esquema do Cenario: <VSTS> - <angulo>
    Quando que estou na tela Agenda
    E seleciono o campo correspondente ao dia atual
    E clico no botao comprovantes
    E clico no botao Imprimir comprovante <angulo>
    Entao o sistema imprime o comprovante

    Exemplos: 
      | VSTS | angulo   |
      |      | superior |
      |      | inferior |
