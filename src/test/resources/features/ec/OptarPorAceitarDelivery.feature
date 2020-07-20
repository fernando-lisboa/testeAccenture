#language: pt
#/**
# * Autor: Fernando Lisboa
# * Empresa: Taking
# * Data: 07/07/2020
# * Caminho: Portal Estabelecimento Comercial
# */
@Regressivo @ignore
Funcionalidade: Antecipacao
  Permite realizar antecipação dos valores a receber
  
  Eu como usuario
  Quero antecipar os valores do meu estabelecimento
  Para ter a flexibilidade de receber quando necessito

  Contexto: 
    Dado que prepara o banco de pid para testes "sit"

  @Regressivo @delivery @ignore
  Esquema do Cenario: <VSTS> - Realizar solicitação de app  => <Cenario>
    Dado que estou na logado no portal EC "<user>", "<senha>"
    E preencha os dados de PID "sit"
    Quando verificar a label do botao concluir
    E optar por aceitar a opcao app "<Cenario>" e clicar em avancar
    E devo validar a msg de confirmacao
    Entao deve gravar no banco de dados a opcao escolhida "<Cenario>"

    Exemplos: 
      | VSTS   | user           | senha      | Cenario       |
      | 9999-1 | 972.018.730-16 | Alelo2020@ | Ifood         |
      #| 9999-1 | 610.425.030-01 | Alelo2020@ | rappy         |
      #| 9999-1 | 610.425.030-01 | Alelo2020@ | Nao solicitar |
      #| 9999-1 | 610.425.030-01 | Alelo2020@ | multiplo      |

  @Regressivo @Combo @ignore
  Esquema do Cenario: <VSTS> - Realizar solicitação de app com Alimentação apenas  => <Cenario>
    Dado que estou na logado no portal EC "<user>", "<senha>"
    E preencha os dados de PID "sit"
    Quando verificar a label do botao concluir
    Entao devo verificar que não é oferecido a opção de app

    Exemplos: 
      | VSTS   | user           | senha      | Cenario |
      | 9999-1 | 387.055.390-13 | Alelo2020@ | Ifood   |
