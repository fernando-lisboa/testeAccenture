# language: pt

  @Regressivo @login 
  Funcionalidade: Login
  Permite a realizacao de Login no Portal EC
  
  Como usuario
  Quero logar no sistema
  Para acessar informacaos respectivas da conta
  
  #Contexto: 
  #Dado que estou na logado no portal EC "<54621917072>", "<Alelo2018@>"
 
  @desenvolve
  Esquema do Cenario: <VSTS> - Login com sucesso <cenario>
    Dado que esteja na tela inicial do portal
    Quando preencher o formulario de login "<user>", "<password>"
    Entao devo visualizar a tela do painel

    Exemplos: 
      | VSTS | cenario           | user        | password   |
      | 0000 | Login com sucesso | 54621917072 | Alelo2018@ |
