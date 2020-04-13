#language: pt
#/**
# * Autor: Matheus Lisboa
# * Empresa: Taiking
# * Data:23/03/2020
# * Caminho: Portal Estabelecimento Web Admin
# */
Funcionalidade: ARVCentral
      
  Eu como operador da central
  Desejo Consultar e logar no portal ARV na Central

  @LoginArv
  Esquema do Cenario: <VSTS> notification - <cenario>
    Dado que eu acesse o portal Arv na central_
    E preencha o formulario de login e clique no botao entrar_ "<userARV>", "<passwordARV>"
    Entao eu devo validar que o acesso foi feito com sucesso_ "<mensagem>", "<status>"

    Exemplos: 
      | VSTS    | cenario                                  | userARV     | passwordARV   | mensagem   | status                     |          |
      | CT-1.01 | Validar login com usuario e senha valido | 55356357079 | 12345678aA@   |            | positivo                   |          |
      | CT-1.02 | Validar login com usuario invalido       |  5535635707 |     123456789 | Alelo@2019 | Usuário ou Senha inválido! | negativo |
      | CT-1.03 | Validar login com senha invalida         | 55356357079 | 123    456789 | Alelo@2019 | Usuário ou Senha inválido! | negativo |
