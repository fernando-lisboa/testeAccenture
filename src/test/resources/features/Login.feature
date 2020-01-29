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

  @loginSucesso
  Esquema do Cenario: <VSTS> - Login com sucesso <cenario>
    Dado que esteja na tela inicial do portal
    Quando preencher o formulario de login "<user>", "<password>"
    Entao devo visualizar a tela do painel

    Exemplos: 
      | VSTS | cenario           | user           | password   |
      | 0000 | Login com sucesso | 546.219.170-72 | Alelo2018@ |

  @loginSemSucesso
  Esquema do Cenario: <VSTS> - Login com sucesso <cenario>
    Dado que esteja na tela inicial do portal
    Quando preencher o formulario de login "<user>", "<password>"
    Entao devo receber msg de erro no acesso

    Exemplos: 
      | VSTS | cenario                    | user           | password   |
      | 0000 | Login com user inexistente | 111.111.111-11 | Alelo2018@ |
      | 0000 | Login com senha incorreta  | 546.219.170-72 | Alelo2020! |
