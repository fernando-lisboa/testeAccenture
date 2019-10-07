# language: pt
@Regressivo
@resetarsenha

Funcionalidade: Reset de Senha
Envia uma nova senha de acesso ao sistema
  
Como usuario
Esqueci qual é a minha senha de acesso
E desejo receber uma nova senha de acesso

Contexto: Solicitando uma nova senha
Dado que estou na tela de Login

@PortalPME @endtoend @55358
Cenario: 55303 - Receber link para reset de senha com sucesso
E clico em esqueci minha senha
Quando eu entrar na tela de redefinicao de senha
E preencho com o cpf "58538431099"
E preencho com a dia de nascimento "01"
E preencho com a mes de nascimento "01"
E preencho com a ano de nascimento "1980"
E preencho com o cnpj "91082236000170"
E Clico no botao Enviar
Então a tela E-mail enviado com sucesso para endereço cadastrado deve ser exibida


@PortalPME @validacao @55358
Esquema do Cenario: <VSTS> - Visualizar erro ao tentar enviar link de reset de senha <cenario>
E clico em esqueci minha senha
Quando eu entrar na tela de redefinicao de senha
E preencho com o cpf <cpf>
E preencho com a dia de nascimento <dia>
E preencho com a mes de nascimento <mes>
E preencho com a ano de nascimento <ano>
E preencho com o cnpj <cnpj>
E Clico no botao Enviar
Então a mensagem <mensagem> deve ser exibida

Exemplos:
| VSTS  | cenario                                | cpf           | dia  | mes  | ano    | cnpj             | mensagem                                   |
| 55304 | preenchendo CPF invalido               | "04203499950" | "01" | "01" | "1980" | "91082236000170" | "Um ou mais dados incorretos ou inválidos" |
| 55305 | preenchendo Dia de Nascimento invalido | "58538431099" | "03" | "01" | "1980" | "91082236000170" | "Um ou mais dados incorretos ou inválidos" |
| 55306 | preenchendo Mes de Nascimento invalido | "58538431099" | "01" | "06" | "1980" | "91082236000170" | "Um ou mais dados incorretos ou inválidos" |
| 55307 | preenchendo Ano de Nascimento invalido | "58538431099" | "01" | "09" | "1980" | "91082236000170" | "Um ou mais dados incorretos ou inválidos" |
| 55308 | preenchendo CNPJ invalido              | "58538431099" | "01" | "01" | "1980" | "21312827728273" | "Um ou mais dados incorretos ou inválidos" |
