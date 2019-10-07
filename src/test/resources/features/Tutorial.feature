# language: pt
@Regressivo @tutorial @86264 
Funcionalidade: Tutorial - Primeiro Acesso 

	Contexto: Realizar o tutorial do primeiro acesso ao portal PME
    Dado que estou na tela de Login
	Quando preencho o formulario de login 
	E clico no botao Ok
 
   Esquema do Cenario: <VSTS> -  Seguir o passo a passo do Tutorial <cenario>
 Quando aparecer a mensagem de seja bem vindo clico em Comecar
 E confirmo os dados cadastrais do contratante
 E confirmo o endereco de entrega do contratante
 E seleciono Novo Pedido
 E seleciono o contrato <contrato>
 E deve aparecer a modal do termo de aceite 
 E seleciono o Li e concordo com os termos
 E deve aparecer uma nova modal com o termo de aceite do MTE
 E clico em aceitar o termo do MTE
 E incluo colaboradores manualmente atraves do botao Novo Colaborador
 E preencho o valor a ser depositado para cada colaborador
 E confirmo o local de entrega cadastrado
    Quando acessar a tela de resumo do pedido
    E clicar em Fazer Pedido
    Entao deve aparecer a mensagem 'Pedido realizado com sucesso!'
 
     Exemplos: 
	| VSTS  | cenario     | contrato   |
	| 86265 | Refeicao    | "12143419" |
	| 86266 | Alimentacao | "12143819" |

 