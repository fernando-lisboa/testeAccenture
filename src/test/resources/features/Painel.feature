#language: pt
#/**
# * Autor: Fernando Lisboa
# * Empresa: Taking
# * Data: 06/12/2019
# * Caminho: Portal Estabelecimento Comercial
# */
@Painel
Funcionalidade: Painel
  Permite a realizacao de navegacao no Portal EC
  
  Eu como usuario
  Quero navegar no sistema
  Para validar informacoes respectivas da Home Page

  Contexto: 
    Dado que estou na logado no portal EC "546.219.170-72", "Alelo2018@"

  @Painel1
  Esquema do Cenario:  <VSTS> - Alterar SUCESSIVAMENTE CNPJ no combo selecao com Sucesso <cenario>
    E seleciono um CNPJ diferente no combo Estabelecimento
    Entao o painel carrega as informacoes respectivas ao CNPJ selecionado

    Exemplos: 
      | VSTS | cenario                         | user        | password   | cnpj           |
      | 46121 | Alterar SUCESSIVAMENTE CNPJ no combo selecao com Sucesso | 54621917072 | Alelo2018@ | 95699678000178 |

  @Painel
  Esquema do Cenario:  <VSTS> - Validar link do banner superior <cenario>
    E clico no banner superior
    Entao o sistema redireciona para a tela marketing cadastrada superior

    Exemplos: 
      | VSTS | cenario                         | user        | password   | cnpj           |
      | 0000 | Oferta ativa para cnpj elegível | 54621917072 | Alelo2018@ | 95699678000178 |

  @Painel
  Esquema do Cenario:  <VSTS> - Validar link dos banners inferiores <cenario>
    E clico nos banners inferiores
    Entao o sistema redireciona para a tela marketing cadastrada inferior

    Exemplos: 
      | VSTS | cenario                         | user        | password   | cnpj           |
      | 0000 | Oferta ativa para cnpj elegível | 54621917072 | Alelo2018@ | 95699678000178 |

  @Painel
  Esquema do Cenario:  <VSTS> - Validar link das redes sociais Twitter <cenario>
    E clico na imagem correspondente ao Twitter
    Entao o sistema redireciona para a url da Alelo no Twitter

    Exemplos: 
      | VSTS | cenario                         | user        | password   | cnpj           |
      | 0000 | Oferta ativa para cnpj elegível | 54621917072 | Alelo2018@ | 95699678000178 |

  @Painel
  Esquema do Cenario:  <VSTS> - Validar link das redes sociais facebook <cenario>
    E clico na imagem correspondente ao Facebook
    Entao o sistema redireciona para a url da Alelo no Facebook

    Exemplos: 
      | VSTS | cenario                         | user        | password   | cnpj           |
      | 0000 | Oferta ativa para cnpj elegível | 54621917072 | Alelo2018@ | 95699678000178 |

  @Painel
  Esquema do Cenario: <VSTS> -  Validar link das redes sociais linkedin <cenario>
    E clico na imagem correspondente ao Linkedin
    Entao o sistema redireciona para a url da Alelo no Linkedin

    Exemplos: 
      | VSTS | cenario                         | user        | password   | cnpj           |
      | 0000 | Oferta ativa para cnpj elegível | 54621917072 | Alelo2018@ | 95699678000178 |

  @Painel
  Esquema do Cenario:  <VSTS> - Validar Side-Kick de ARV com EC com saldo e sem plano <cenario>
    E seleciono um CNPJ diferente que tenha ARV no combo Estabelecimento
    Entao o sistema apresenta o sidekick de ARV

    Exemplos: 
      | VSTS | cenario                         | user        | password   | cnpj           |
      | 0000 | Oferta ativa para cnpj elegível | 54621917072 | Alelo2018@ | 95699678000178 |

  @Painel
  Esquema do Cenario:  <VSTS> - Validar Side-Kick de Planos com EC sem saldo e com plano <cenario>
    E seleciono um CNPJ diferente que tenha plano e sem saldo no combo Estabelecimento
    Entao o sistema apresenta o sidekick de Planos

    Exemplos: 
      | VSTS | cenario                         | user        | password   | cnpj           |
      | 0000 | Oferta ativa para cnpj elegível | 54621917072 | Alelo2018@ | 95699678000178 |

  @Painel
  Esquema do Cenario:  <VSTS> - Validar Side-Kick de Planos com EC sem saldo e com plano <cenario>
    E seleciono um CNPJ diferente que tenha plano e com saldo no combo Estabelecimento
    Entao o sistema apresenta o sidekick de Planos

    Exemplos: 
      | VSTS | cenario                         | user        | password   | cnpj           |
      | 0000 | Oferta ativa para cnpj elegível | 54621917072 | Alelo2018@ | 95699678000178 |

  @Painel
  Esquema do Cenario: <VSTS> -  Validar Side-Kick de Planos com EC sem saldo e com plano <cenario>
    E seleciono um CNPJ diferente que nao tenha plano ou saldo no combo Estabelecimento
    Entao o sistema nao apresenta o sidekick

    Exemplos: 
      | VSTS | cenario                         | user        | password   | cnpj           |
      | 0000 | Oferta ativa para cnpj elegível | 54621917072 | Alelo2018@ | 95699678000178 |

  @Painel
  Esquema do Cenario: <VSTS> -  Validar informacoes da API inicial <cenario>
    Dado que informo os parametros de Login da api
    E que realizo o post para obter o access token
    Quando executo o comando get com access token
    Entao valido o retorno da api
    E imprimo a resposta

    Exemplos: 
      | VSTS | cenario                         | user        | password   | cnpj           |
      | 0000 | Oferta ativa para cnpj elegível | 54621917072 | Alelo2018@ | 95699678000178 |
