# language: pt
@Regressivo @termodeaceite @mte @86260
Funcionalidade: Termo de Aceite - MTE (D)

  Contexto: Realizar um pedido sem que o contratante tenha aceito o termo MTE anteriormente
    Dado que estou logado no Portal PME
    E acesso a tela de Novo Pedido
    E seleciono Novo Pedido

  @SPRINT
  Esquema do Cenario: <VSTS> - Pedido para contrato sem aceite MTE - <cenario>
    Quando seleciono o contrato <contrato>
    E realizo o aceite do termo MTE
    E preencho o valor a ser depositado para cada colaborador
    E confirmo o local de entrega cadastrado
    Quando acessar a tela de resumo do pedido
    E clicar em Fazer Pedido
    Entao deve aparecer a mensagem 'Pedido realizado com sucesso!'

    Exemplos: 
      | VSTS  | cenario     | contrato   |
      | 86253 | Alimentacao | "12143819" |
      | 86253 | Refeicao    | "12143919" |

  @validacao
  Cenario: 86257 - Realizar pedido sem aceite do termo MTE - Multiplos Contratos sem o aceite
    Quando seleciono o contrato "12143819" e o contrato "12143919"
    E realizo o aceite do termo MTE
    E preencho o valor a ser depositado para cada colaborador
    E confirmo o local de entrega cadastrado
    Quando acessar a tela de resumo do pedido
    E clicar em Fazer Pedido
    Entao deve aparecer a mensagem 'Pedido realizado com sucesso!'


