# language: pt
@Regressivo
@login
@55356
Funcionalidade: Login
Permite a realizacao de Login no Portal PME
  
Como usuario
Quero logar no sistema
Para acessar informacaos respectivas da conta

Contexto: possibilidade de acessar o sistema
Dado que estou na tela de Login

@PortalPME @endtoend 
Cenario: 55289 - Realizar login com sucesso
Quando preencho o formulario de login 
E clico no botao Ok
Entao acesso a pagina inicial



@PortalPME @validacao 
Esquema do Cenario: <VSTS> - Realizar login com erro no campo <cenario>
Quando preencho o formulario de login 
E clico no botao Ok
Entao visualizo mensagem de erro: <msg_erro>

Exemplos:
| VSTS  	| cenario             | msg_erro                                   |
| 55290 	| CPF                 | "Um ou mais dados incorretos ou inválidos" |
| 55291 	| dia do nascimento   | "Um ou mais dados incorretos ou inválidos" |
| 55292 	| mes do nascimento   | "Um ou mais dados incorretos ou inválidos" |
| 55293 	| ano do nascimento   | "Um ou mais dados incorretos ou inválidos" |
| 55451 	| senha               | "Um ou mais dados incorretos ou inválidos" |