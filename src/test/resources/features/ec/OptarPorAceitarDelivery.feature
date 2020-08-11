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

@Regressivo @delivery
  Esquema do Cenario: <VSTS> - Realizar solicitação de app  => <Cenario>
    Dado que estou na logado no portal EC "<user>", "<senha>", "<ambiente>"
    E preencha os dados de PID "<ambiente>"
    Quando verificar a label do botao concluir
    E optar por aceitar a opcao app "<Delivery>" e clicar em avancar
    E devo validar a msg de confirmacao
    Entao deve gravar no banco de dados a opcao escolhida "<ambiente>", "<Delivery>"

    Exemplos: 
      | VSTS   | Cenario                                          | user           | senha      | Delivery | ambiente |
      | 9999-1 | Realizar credenciamento com solicitação de ifood | 972.018.730-16 | Alelo2020@ | Ifood    | hml      |
      | 9999-1 | Realizar credenciamento com solicitação de rappy | 972.018.730-16 | Alelo2020@ | Rappy    | hml      |
      | 9999-1 | Realizar credenciamento solicitando ambas opções | 972.018.730-16 | Alelo2020@ | TUDO     | hml      |

  @ignore
  Esquema do Cenario: <VSTS> - Realizar solicitação de app com Alimentação apenas  => <Cenario>
    Dado que estou na logado no portal EC "<user>", "<senha>"
    E preencha os dados de PID "<ambiente>"
    Quando verificar a label do botao concluir
    Entao devo verificar que não é oferecido a opção de app

    Exemplos: 
      | VSTS   | Cenario                                                                                 | user           | senha      | Cenario | ambiente |
      | 9999-1 | Realizar credenciamento com solicitação de ifood com ec que contenha apenas alimentação | 972.018.730-16 | Alelo2020@ | Ifood   | hml      |
