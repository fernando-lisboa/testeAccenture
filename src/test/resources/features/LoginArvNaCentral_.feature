#language: pt
#/**
# * Autor: Fernando Lisboa
# * Empresa: Taiking
# * Data: 16/07/2019
# * Caminho: Portal Estabelecimento Web Admin
# */
Funcionalidade: ARVCentral
      
  Eu como operador da central
  Desejo Consultar e logar no portal ARV na Central

@testesMa
  Esquema do Cenario: <VSTS> notification - <cenario>
    Dado que eu acesse o portal Arv na central_
    E preencha o formulario de login e clique no botao entrar_ "<userARV>", "<passwordARV>"
    Entao eu devo validar que o acesso foi feito com sucesso_ "<mensagem>", "<status>"

    Exemplos: 
      | VSTS    | cenario                                         | user          | password    | mensagem                    | status   |
      | CT-1.01 | Validar login com usuario e senha valido        |   55356357079 | 12345678aA@ |                             | positivo |
      | CT-1.01 | Validar login com usuario invalido              |     123456789 | Alelo@2019  | usuário ou senha incorretos | negativo |
      | CT-1.01 | Validar login com senha invalida                | 123    456789 | Alelo@2019  | usuário ou senha incorretos | negativo |
      | CT-1.01 | Validar login Com campo Login em branco         |               | Alelo@2019  | botão entrar não habilitado | negativo |
      | CT-1.01 | Validar login Com campo senha em branco         |     123456789 |             | botão entrar não habilitado | negativo |
      | CT-1.01 | Validar login Com campo login e senha em branco |               |             | botão entrar não habilitado | negativo |