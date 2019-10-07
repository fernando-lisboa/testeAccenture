# language: pt
@Regressivo @pedido @76958
Funcionalidade: Pedido Antecipado

  Contexto: Criar um novo pedido antecipado
    Dado que estou logado no Portal PME
    E acesso a tela de Novo Pedido
    E seleciono Novo Pedido

  Cenario: 76964 - Novo Pedido Colaborador associado a um posto de trabalho
    Quando seleciono o contrato "12014419"
    E incluo colaboradores manualmente atraves do botao Novo Colaborador
    E preencho o valor a ser depositado para cada colaborador
    E confirmo o local de entrega cadastrado
    Quando acessar a tela de resumo do pedido
    E clicar em Fazer Pedido
    Entao deve aparecer a mensagem 'Pedido realizado com sucesso!'

  @validacao
  Cenario: 85972 - Tentar criar um pedido sem adicionar colaborador ao pedido - somente com um contrato
    Quando seleciono o contrato "12014519"
    E clico em Proxima etapa sem selecionar colaboradores
    Então deve aparecer a mensagem 'Adicione ao menos 1 colaborador ao pedido.'

  @validacao
  Cenario: 85976 - Tentar criar um pedido sem adicionar colaborador ao pedido - com mais de um contrato
    Quando seleciono o contrato "12014719" e o contrato "12014519"
    E clico em Proxima etapa sem selecionar colaboradores
    Então deve aparecer a mensagem 'Adicione ao menos 1 colaborador ao pedido.'
