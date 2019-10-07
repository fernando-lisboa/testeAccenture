# language: pt
@Regressivo @copiapedido @55364
Funcionalidade: Copiar um Pedido Recente

  Contexto: Criar um novo pedido antecipado
    Dado que estou logado no Portal PME
    E acesso a tela de Novo Pedido
	
	@wip
  Esquema do Cenario: <VSTS> - Validar Copia de Pedido <cenario>
    E Clico em Copiar um pedido recente
    E seleciono o pedido de <pedido>
    E vou para proxima etapa
    Quando aparecer os dados do pedido eu altero a data de credito para <data_credito>
    E vou para tela de resumo do pedido
    Entao clico em fazer pedido
    E deve aparecer a mensagem 'Pedido realizado com sucesso!'

    Exemplos: 
      | VSTS  | cenario     | pedido     | data_credito |
      | 55182 | refeicao    | "72069351" | "Janeiro/2020" |
      | 55183 | alimentacao | "72069353" | "Janeiro/2020" |
      | 55184 | natal       | "72069018" | "Janeiro/2020" |
      | 55185 | cultura     | "72048697" | "Janeiro/2020" |
      | 86198 | flex car    | "72069465" | "Janeiro/2020" |
