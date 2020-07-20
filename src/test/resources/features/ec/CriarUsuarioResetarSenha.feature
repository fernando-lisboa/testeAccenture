#language: pt
#/**
# * Autor: Michael Alba
# * Empresa: Taking
# * Data: 06/02/2020
# * Caminho: Portal Estabelecimento Comercial
# */

@CriarUsuarioResetarSenha @ignore
Funcionalidade: Criacao de Usuario e Reset de Senha
  Eu como usuário do portal
  Desejo efetuar a criacao de novos usuarios e dado a necessidade, resetar a senha do mesmo


  Esquema do Cenario: <VSTS> - Usuario <Cenario>
    Dado que esteja na tela inicial do portal
    Quando criar um novo usuario PID "<PID>" e trocar senha "<TrocaSenha>" logando no Gmail "<LogarGmail>" e associando CNPJS "<associarCNPJS>"
    Entao devo validar a mensagem esperada "<resultadoEsperado>" no cenario "<Cenario>"

    Exemplos:
      | VSTS   | Cenario                                | PID   | TrocaSenha | resultadoEsperado                   | LogarGmail | associarCNPJS |
      | 9999-1 | criação de novo usuário sem PID        | false | false      | Usuário Criado com sucesso          | true       | 0             |
      | 9999-2 | Criação de novo usuário com PID        | true  | false      | Usuário Criado com sucesso          | false      | 0             |
      | 9999-3 | Alteração de senha de novo usuário     | true  | true       | Troca de senha efetuada com sucesso | false      | 0             |
      | 9999-4 | Criacao de usuário com adicao de CNPJS | true  | false      | Adicao de CNPJS com sucesso         | false       | 1             |