#language: pt
#/**
# * Autor: Fernando Lisboa
# * Empresa: Taiking
# * Data: 16/07/2019
# * Caminho: Portal Estabelecimento Web Admin
# */
@ArvCentral @front @Release-15 @front @Regressivo @front @Regressao
Funcionalidade: Efetuar Login ARV pela Central
      
  Eu como operador da central
  Desejo Consultar e logar no portal ARV na Central

  ############################################# - VALIDACA DE PERFIL DE ACESSO - Sucesso #############################################
  @Release-15 @front @Regressivo @ArvNaCentral @sucesso
  Cenario: Validar login com sucesso
    Dado que eu acesse o portal Arv na central
    E insira no campo login com o id userName eu informe o nome do operador
    E no campo senha com o id password eu informe uma senha
    Quando eu clicar no botao Entrar com o id send
    Então eu devo validar que o acesso foi feito com o nome e o perfil de usuario informado

  ############################################# - VALIDACA DE PERFIL DE ACESSO - Negativo #############################################
  @Release-15 @front @Regressivo @ArvNaCentral @UserInvalido
  Esquema do Cenario: [Busca web] "<Cenario>"-"<DescricaoDoCenario>"
    Dado que eu acesse o portal Arv na central
    E insira no campo login com o id userName eu informe o nome do operador "<user>"
    E no campo senha com o id password eu informe uma senha "<password>"
    Quando eu clicar no botao Entrar com o id send
    Então devo receber a mensagem de "<mensagem>"

    Exemplos: 
      | Cenario | DescricaoDoCenario                              | user      | password   | mensagem                    |
      | CT-1.01 | Validar login com Usuario invalido              | 123456789 | Alelo@2019 | usuário ou senha incorretos |
      | CT-1.01 | Validar login com Senha invalida                | 123456789 | Alelo@2019 | usuário ou senha incorretos |
      | CT-1.01 | Validar login Com campo Login em branco         |           | Alelo@2019 | botão entrar não habilitado |
      | CT-1.01 | Validar login Com campo Senha em branco         | 123456789 |            | botão entrar não habilitado |
      | CT-1.01 | Validar login Com campo Login e Senha em branco |           |            | botão entrar não habilitado |
