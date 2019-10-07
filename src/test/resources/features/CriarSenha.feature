#language: pt
#/**
# * Autor: Esther Angelica Hinrichsen
# * Empresa: Taking
# * Data: 20/08/2019
# *
# */
@Regressivo @CriarSenha
Funcionalidade: Primeiro Acesso - Criar Senha
  Permite a criação de senha para primeiro acesso ao Portal PME

  Contexto: possibilidade de cadastrar uma senha para acesso ao Portal PME
    Dado que tenho uma empresa cadastrada
    E um contrato ativo
    E que estou na tela de Login
    
@validacao @55357
  Esquema do Cenario: <VSTS> -  Visualizar erro ao tentar enviar link de criacao de senha preenchendo <cenario>
    E clico no botao criar senha
    Quando abrir a pagina com o formulario de cadastro de senha
    E digito o cpf <cpf>
    E data de nascimento <data_nascimento>
    E CNPJ <cnpj>
    E clico no botão enviar
    Entao será exibido <resultado_esperado>

    Exemplos: 
      | VSTS  | cenario                    | cpf           | data_nascimento | cnpj                 | resultado_esperado                         |
      | 55297 | CPF invalido               | "04203499950" | "01/03/1989"    | "30.047.853/0001-40" | "Um ou mais dados incorretos ou inválidos" |
      | 55298 | dia de nascimento invalido | "04203499950" | "01/03/1989"    | "30.047.853/0001-40" | "Um ou mais dados incorretos ou inválidos" |
      | 55299 | mes de nascimento invalido | "04203499950" | "01/03/1989"    | "30.047.853/0001-40" | "Um ou mais dados incorretos ou inválidos" |
      | 55300 | ano de nascimento invalido | "04203499950" | "01/03/1989"    | "30.047.853/0001-40" | "Um ou mais dados incorretos ou inválidos" |
      | 55301 | CNPJ invalido              | "04203499950" | "01/03/1989"    | "30.047.853/0001-40" | "Um ou mais dados incorretos ou inválidos" |
