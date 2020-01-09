#language: pt
#/**
# * Autor: Fernando Lisboa
# * Modificador: Jessé Dantas
# * Empresa: Taking
# * Data: 07/01/2020
# * Caminho: Portal Estabelecimento Comercial
# */
@Credenciamento @front @Regressao
Funcionalidade: Credenciamento
  Validar o fluxo de credenciamento no portal Meu Estabelecimento
  
  Eu como proprietario de um estabelecimento
  Desejo realizar o cadastro no site 
  Para habilitar os produtos Alelo no meu estabelecimento

  Contexto: 
    Dado que estou no portal meu estabelecimento
    E clico no botao cadastre seu estabelecimento

  @Release-01 @portalEC @credenciamento_dois_proprietarios
  Esquema do Cenario: <VSTS> - Sistema realiza o credenciamento do estabelecimento <cenario>
    Quando informo os dados do formulario
    E adiciono um <proprietario> proprietario
    E informo os demais dados
    Entao o sistema realiza o credenciamento do estabelecimento

    Exemplos: 
      | VSTS | cenario                | proprietario |
      |      | com dois proprietarios | segundo      |
      |      | com tres proprietarios | terceiro     |

  @Release-01 @portalEC @credenciamento_dois_enderecos
  Esquema do Cenario: <VSTS> - Realizar o credenciamento com outro endereco de correspondencia
    Quando informo os dados do formulario
    E seleciono outro endereco de correspondencia
    E informo os demais dados
    Entao o sistema realiza o credenciamento do estabelecimento

    Exemplos: 
      | VSTS |
      |      |

  @Release-01 @portalEC @credenciamento_sem_pat
  Esquema do Cenario: <VSTS> - Sistema realiza o credenciamento do estabelecimento no sistema sem preenchimento do PAT
    Quando informo os dados do formulario sem habilitar PAT
    E seleciono um cartao concordando com os termos
    Entao o sistema realiza o credenciamento do estabelecimento

    Exemplos: 
      | VSTS |
      |      |

  @Release-01 @portalEC @credenciamento_com_pat
  Esquema do Cenario: <VSTS> - Sistema realiza o credenciamento do estabelecimento no sistema com preenchimento do PAT
    Quando informo os dados do formulario
    E informo os demais dados
    Entao o sistema realiza o credenciamento do estabelecimento

    Exemplos: 
      | VSTS |
      |      |

  @Release-01 @portalEC @preenchimento_automatico_cep
  Esquema do Cenario: <VSTS> - Validacao do preenchimento automatico do CEP
    Quando informo o CEP
    Entao os campos com preenchimento automatico sao preenchidos
    E os campos sem preenchimento automatico nao sao preenchidos

    Exemplos: 
      | VSTS |
      |      |

  @Release-01 @portalEC @exibe_um_cartao
  Esquema do Cenario: <VSTS> - Sistema exibe apenas um tipo de cartao na etapa de condicoes de recebimento
    Quando informo os dados do formulario informando um cnae relacionado a <cartao>
    E clico no botao proximo passo do formulario
    Entao o sistema exibe o tipo de cartao <tipo>

    Exemplos: 
      | VSTS | cartao          | tipo            |
      |      | multibeneficios | multibeneficios |
      |      | auto            | auto            |

  @Release-01 @portalEC @exibe_dois_cartoes
  Esquema do Cenario: <VSTS> - Sistema exibe dois tipos de cartoes de acordo com o CNAE
    Quando informo os dados do formulario com um cnae relacionado a <opcao1> <opcao2>
    E clico no botao proximo passo do formulario
    Entao o sistema exibe os tipos de cartoes <tipo1> <tipo2>

    Exemplos: 
      | VSTS | opcao1          | opcao2          | tipo1           | tipo2           |
      |      | refeicao        | alimentacao     | refeicao        | alimentacao     |
      |      | refeicao        | multibeneficios | refeicao        | multibeneficios |
      |      | multibeneficios | auto            | multibeneficios | auto            |

  @Release-01 @portalEC @exibe_tres_cartoes
  Esquema do Cenario: <VSTS> - Sistema exibe tres tipos de cartoes de acordo com o CNAE
    Quando informo os dados do formulario com um cnae relacionado a tres tipos de cartoes
    E clico no botao proximo passo do formulario
    Entao o sistema exibe os tres tipos de cartoes

    Exemplos: 
      | VSTS |
      |      |

  @Release-01 @portalEC @nao_exibe_cartao_auto
  Esquema do Cenario: <VSTS> - Sistema nao exibe o tipo de cartao auto na credenciadora Stelo
    Quando informo os dados do formulario com um cnae relacionado a multibeneficios auto
    E clico no botao proximo passo do formulario
    Entao o sistema nao exibe o cartao auto na credenciadora Stelo

    Exemplos: 
      | VSTS |
      |      |

  @Release-01 @portalEC @preenchimento_automatico_cnpj
  Esquema do Cenario: <VSTS> - Sistema exibe o CNPJ na credenciadora Stelo conforme o preenchido no formulario
    Quando informo os dados do formulario
    E seleciono a credenciadora Stelo
    Entao o sistema preenche o CNPJ conforme o dado informado no formulario

    Exemplos: 
      | VSTS |
      |      |

  @Release-01 @portalEC @mensagem_outras_credenciadas
  Esquema do Cenario: <VSTS> - Sistema apresenta a mensagem de aceitacao das outras credenciadoras
    Quando informo os dados do formulario
    E clico no botao proximo passo do formulario
    Entao o sistema exibe a mensagem de aceitacao das outras credenciadoras

    Exemplos: 
      | VSTS |
      |      |

  @Release-01 @portalEC @credenciamento_com_pat_alimentacao_refeicao
  Esquema do Cenario: Sistema realiza o credenciamento preenchendo o pat alimentacao e refeicao
    Quando informo os dados do formulario
    E seleciono as opcoes alimentacao e refeicao da credenciadora <credenciadora>
    E finalizo o credenciamento preenchendo os pat
    Entao o sistema realiza o credenciamento do estabelecimento

    Exemplos: 
      | VSTS | credenciadora |
      |      | cielo         |
      |      | stelo         |

  @Release-01 @portalEC @nao_exibe_pat
  Esquema do Cenario: Sistema nao exibe a etapa Dados do PAT ao selecionar duas credenciadoras
    Quando informo os dados do formulario com um cnae relacionado a <opcao1> <opcao2>
    E seleciono os cartoes <cartaoum> <cartaodois>
    Então o sistema nao exibe a etapa dados do pat

    Exemplos: 
      | VSTS | opcao1          | opcao2 | cartaoum             | cartaodois              |
      |      | multibeneficios | auto   | multibeneficiosCielo | mulmultibeneficiosStelo |
      |      | multibeneficios | auto   | multibeneficiosCielo | autoCielo               |
      |      | multibeneficios | auto   | autoCielo            | multibeneficiosStelo    |

  @Release-01 @portalEC @direciona_pagina_correios
  Esquema do Cenario: Sistema direciona para a pagina dos correios ao clicar no botao "Nao sabe seu cep?"
    Quando clico no botao NAO SABE SEU CEP
    Entao o  sistema direciona para a pagina dos correios

    Exemplos: 
      | VSTS |
      |      |

  @Release-01 @portalEC @negativo @excluir_proprietario
  Esquema do Cenario: Verificar se o sistema exclui os dados do proprietario ao clicar no botao excluir proprietario
    Quando preencho as informacoes do <variavelum> proprietario
    E clico no botao excluir <variaveldois> proprietario
    Entao o sistema exclui o <variaveltres> proprietario

    Exemplos: 
      | VSTS | variavelum | variaveldois | variaveltres |
      |      | segundo    | segundo      | segundo      |
      |      | segundo    | primeiro     | primeiro     |
      |      | terceiro   | primeiro     | primeiro     |
      |      | terceiro   | segundo      | segundo      |
      |      | terceiro   | terceiro     | terceiro     |

  @Release-01 @portalEC @negativo @erro_termo_aceite_pat
  Esquema do Cenario: <VSTS> - Sistema nao direciona para a proxima pagina sem confirmar os termos de aceite da pagina PAT
    Quando informo os dados do formulario
    E informo os dados do PAT sem aceitar os termos de aceite
    Entao o sistema nao habilita o botao para proxima pagina

    Exemplos: 
      | VSTS |
      |      |

  @Release-01 @portalEC @negativo @formulario_sem_preenchimento
  Esquema do Cenario: <VSTS> - Sistema nao permite o cadastro no sistema com os dados <cenario>
    Quando nao preencho os dados <dados>
    Entao o sistema nao habilita o botao para proxima pagina

    Exemplos: 
      | VSTS | cenario                                | dados                |
      |      | de formularios sem preenchimento       | de formulario        |
      |      | de estabelecimento sem preenchimento   | de estabelecimento   |
      |      | de endereco sem preenchimento          | de endereço          |
      |      | do quadro societario sem preenchimento | do quadro societario |
      |      | bancarios sem preenchimento            | bancarios            |

  @Release-01 @portalEC @negativo @erro_nao_preencher_pat_refeicao
  Esquema do Cenario: <VSTS> - Sistema nao direciona para a proxima pagina sem preencher os dados PAT <cenario>
    Quando informo os dados do formulario
    E seleciono a opcao de cartao <cartao>
    E nao preencho os dados PAT <cenario>
    Entao o sistema nao habilita o botao para proxima pagina

    Exemplos: 
      | VSTS | cenario     | cartao           |
      |      | refeicao    | vale refeicao    |
      |      | alimentacao | vale alimentacao |

  @Release-01 @portalEC @negativo @erro_nao_preencher_pat_alimentacao_refeicao
  Esquema do Cenario: <VSTS> - Sistema nao direciona para a proxima pagina sem preencher os dados PAT alimentacao e refeicao
    Quando informo os dados do formulario
    E seleciono os tipos de cartoes
    E nao preencho os dados PAT
    Entao o sistema nao habilita o botao para proxima pagina

    Exemplos: 
      | VSTS |
      |      |

  @Release-01 @portalEC @negativo @nao_preencher_pat
  Esquema do Cenario: <VSTS> - Sistema nao direciona para a proxima pagina sem preencher os dados PAT <cenario>
    Quando informo os dados do formulario
    E seleciono os tipos de cartoes
    E preencho somente os dados do PAT <pat>
    Entao o sistema nao habilita o botao para proxima pagina

    Exemplos: 
      | VSTS | cenario                                | pat         |
      |      | alimentacao e preenchendo PAT refeicao | refeicao    |
      |      | refeicao e preenchendo alimentacao     | alimentacao |

  @Release-01 @portalEC @negativo @erro_nao_aceitar_termo_recebimento
  Esquema do Cenario: <VSTS> - Sistema nao conclui o credenciamento sem confirmar os termos de aceite do recebimento
    Quando informo os dados do formulario
    E nao seleciono a opcao de concordar com as condicoes de recebimento
    Entao o sistema nao habilita o botao para proxima pagina

    Exemplos: 
      | VSTS |
      |      |

  @Release-01 @portalEC @negativo @erro_nao_seleciona_cartao
  Esquema do Cenario: <VSTS> - Sistema nao direciona para a proxima pagina quando nao e selecionado o tipo de cartao
    Quando informo os dados do formulario
    E seleciono somente a credenciadora
    Entao o sistema nao habilita o botao para proxima pagina

    Exemplos: 
      | VSTS |
      |      |

  @Release-01 @portalEC @negativo @erro_nao_seleciona_credenciadora
  Esquema do Cenario: <VSTS> - Sistema nao direciona para a proxima pagina quando nao e selecionado uma credenciadora
    Quando informo os dados do formulario
    E clico no botao proximo passo do formulario
    E nao seleciono a credenciadora
    Entao o sistema nao habilita o botao para proxima pagina

    Exemplos: 
      | VSTS |
      |      |
