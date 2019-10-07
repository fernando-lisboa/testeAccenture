# language: pt
@Regressivo @pedidoAntecipado @84884
Funcionalidade: Pedido Antecipado

  Contexto: Criar um novo pedido antecipado
    Dado que estou logado no Portal PME
    E acesso a tela de Novo Pedido
    E seleciono Novo Pedido

  Cenario: 85855 - Novo Pedido Colaborador associado a um posto de trabalho
    Quando seleciono mais de um contrato
    E incluo colaboradores manualmente atraves do botao Novo Colaborador
    E preencho o valor a ser depositado para cada colaborador em todos os beneficios
    E confirmo o local de entrega cadastrado
    Quando acessar a tela de resumo do pedido
    E clicar em Fazer Pedido
    Entao deve aparecer a mensagem 'Pedido realizado com sucesso!'

  @validacao
  Cenario: 85856 - Mensagem de Nova versão da Planilha de Importação de Colaboradores
    Quando seleciono apenas um contrato
    E clico no botao Importar Colaborador
    Entao e exibido um popup, com a mensagem de nova versao da planilha modelo

  Cenario: 85857 - Novo pedido Validacao de pedido e-commerce elegível
    Quando seleciono mais de um contrato
    E incluo colaboradores manualmente atraves do botao Novo Colaborador
    E preencho o valor a ser depositado para cada colaborador em todos os beneficios
    E confirmo o local de entrega cadastrado
    Quando acessar a tela de resumo do pedido
    E clicar em Fazer Pedido
    Entao deve aparecer a mensagem 'Pedido realizado com sucesso!'

  @wip
  Cenario: 85858 - Novo pedido Validacao de pedido e-commerce nao elegivel
    Quando seleciono apenas um contrato
    E incluo colaboradores manualmente atraves do botao Novo Colaborador
    E preencho o valor a ser depositado para cada colaborador
    E confirmo o local de entrega cadastrado
    Quando acessar a tela de resumo do pedido
    E clicar em Fazer Pedido
    Entao deve aparecer a mensagem 'Pedido realizado com sucesso!'

  Cenario: 85859 - Novo Pedido Validacao Pop-up pedido zerado
    Quando seleciono apenas um contrato
    E entro na tela de colaboradores fecho o Pop-up vermelho sobre os pedidos com valor zerado
    E seleciono prosseguir finalizando o pedido com todos os colaboradores
    Entao realizo novamente os passos anteriores ate a tela de colaboradores e verifico se o Pop-Up ainda e exibido
