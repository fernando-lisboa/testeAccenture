# language: pt
@Regressivo @termodeaceite @mte @86268
Funcionalidade: Termo de Aceite - MTE (D)

  Contexto: Realizar um pedido sem que o contratante tenha aceito o termo MTE anteriormente
    Dado que estou logado no Portal PME
    E acesso a tela de Novo Pedido
    E seleciono Novo Pedido

  Esquema do Cenario: <VSTS> - Aceite do termo via 'Pedidos Recentes' <cenario>
    E Clico em Copiar um pedido recente
    E seleciono o pedido de <pedido>
    E vou para proxima etapa
    E realizo o aceite do termo MTE
    Quando aparecer os dados do pedido eu altero a data de credito para <data_credito>
    E vou para tela de resumo do pedido
    Entao clico em fazer pedido
    E deve aparecer a mensagem 'Pedido realizado com sucesso!'

    Exemplos: 
      | VSTS  | cenario     | pedido     | data_credito   |
      | 86269 | refeicao    | "72069351" | "Janeiro/2020" |
      | 86270 | alimentacao | "72069353" | "Janeiro/2020" |
