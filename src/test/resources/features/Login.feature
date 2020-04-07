#language: pt
#/**
# * Autor: Fernando Lisboa
# * Empresa: Taking
# * Data: 06/12/2019
@Regressivo @login
Funcionalidade: Login
  Permite a realizacao de Login no Portal EC

  Como usuario
  Quero logar no sistema
  Para acessar informacaos respectivas da conta

  @ligin @Regressivo @teste
  Esquema do Cenario: <VSTS> - Login com sucesso <cenario>
    Dado que esteja na tela inicial do portal
    Quando preencher o formulario de login "<user>", "<password>"
    Entao devo visualizar a tela do painel

    Exemplos:
      | VSTS  | cenario           | user           | password   |
      | 00001 | Login com sucesso | 387.055.390.13 | Alelo2020@ |

  @ligin @Regressivo
  Esquema do Cenario: <VSTS> - Login com sucesso <cenario>
    Dado que esteja na tela inicial do portal
    Quando preencher o formulario de login "<user>", "<password>"
    Entao devo receber msg de erro no acesso

    Exemplos:
      | VSTS  | cenario                    | user           | password   |
      | 00002 | Login com user inexistente | 111.111.111-11 | Alelo2018@ |
      | 00003 | Login com senha incorreta  | 546.219.170-72 | Alelo2020! |
