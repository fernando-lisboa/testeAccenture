#language: pt
#/**
#* Autor: Fernando Lisboa
#* Empresa: Taking
#* Data: 07/07/2020
#* Caminho: Portal Estabelecimento Comercial
#*/
@Regressivo
Funcionalidade: Antecipacao
  Permite realizar antecipação dos valores a receber
  
  Eu como usuario
  Quero antecipar os valores do meu estabelecimento
  Para ter a flexibilidade de receber quando necessito

  Contexto: 
    Dado que prepara o banco de pid para testes "hml"

  @Regressivo 
  Esquema do Cenario: <VSTS> - Realizar solicitação de app  => <Cenario>
    Dado que estou na logado no portal EC "<user>", "<senha>", "<ambiente>"
    E preencha os dados de PID "<ambiente>"
    Quando verificar a label do botao concluir
    E optar por aceitar a opcao app "<Delivery>" e clicar em avancar
    E devo validar a msg de confirmacao
    Entao deve gravar no banco de dados a opcao escolhida "<ambiente>", "<Delivery>", "<cnpj>", "<ec>"

    Exemplos: 
      | VSTS   | Cenario                                          | user           | senha      | Delivery | ambiente | cnpj           | ec         |
      | 9999-1 | Realizar credenciamento com solicitação de ifood | 972.018.730-16 | Alelo2020@ | Ifood    | hml      | 28339982000160 | 1015000654 |
      | 9999-1 | Realizar credenciamento com solicitação de rappy | 972.018.730-16 | Alelo2020@ | Rappy    | hml      | 28339982000160 | 1015000654 |
      | 9999-1 | Realizar credenciamento solicitando ambas opções | 972.018.730-16 | Alelo2020@ | TUDO     | hml      | 28339982000160 | 1015000654 |

  @Regressivo 
  Esquema do Cenario: <VSTS> - Realizar solicitação de app  => <Cenario>
    Dado que estou na logado no portal EC "<user>", "<senha>", "<ambiente>"
    E preencha os dados de PID "<ambiente>"
    Quando verificar a label do botao concluir
    E nao optar por aceitar delivery e verifico que acessou o painel EC


    Exemplos: 
      | VSTS   | Cenario                                             | user           | senha      | Delivery | ambiente | cnpj           | ec         |
      | 9999-1 | Realizar credenciamento Sem solicitação de Delivery | 972.018.730-16 | Alelo2020@ | Ifood    | hml      | 28339982000160 | 1015000654 |

  @ignore
  Esquema do Cenario: <VSTS> - Realizar solicitação de app com Alimentação apenas  => <Cenario>
    Dado que estou na logado no portal EC "<user>", "<senha>", "<ambiente>"
    E preencha os dados de PID "<ambiente>"
    Quando verificar a label do botao concluir
    Entao devo verificar que não é oferecido a opção de app

    Exemplos: 
      | VSTS   | Cenario                                                                                 | user           | senha      | Cenario | ambiente |
      | 9999-1 | Realizar credenciamento com solicitação de ifood com ec que contenha apenas alimentação | 972.018.730-16 | Alelo2020@ | Ifood   | hml      |

  @ignore
  Esquema do Cenario: <VSTS> - Extrair  Relatório de solicitação de App Via portal no webAdmin   => <Cenario>
    Dado que estou na logado no portal webadmim EC "22222222222", "12345678!"
    E pesquise o relatoriode solicitacao de delivery
   

    Exemplos: 
      | VSTS   | Cenario                                                | user           | senha      | Delivery | ambiente | relatorio | cnpj           |
      | 9999-1 | Extrair relatório de solicitação de delivery           | 222.143.700-48 | Alelo2020@ | Rappy    | hml      | true      | 54203102000133 |
      | 9999-1 | Fazer download de planilha de solicitação por delivery | 684.175.140-07 | Alelo2020@ | TUDO     | hml      | true      | 12259140000168 |
