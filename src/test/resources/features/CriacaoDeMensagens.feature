##language: pt
##/**
## * Autor: Fernando Lisboa
## * Empresa: Taiking
## * Data: 23/05/2019
## * Caminho: Portal Estabelecimento Web Admin
## */
#@Antecipacao1 @front @Regressao
#Funcionalidade: CriaçãoDeMensagem
#    Criar e enviar um comunicado para cliente estabelecimento comercial
#  
#  Eu como usuário
#  Desejo criar uma mensagem
#  Para enviar um comunicado para cliente estabelecimento comercial
#
#  Contexto: 
#    Dado que estou logado em qualquer tela no Web Admin
#
#  @Release-15 @criacaoDemensagens
#  Esquema do Cenario: [Busca web] "<Cenario>"-"<DescricaoDoCenario>"
#    Dado eu clique no botao de mensagem
#    E e clicar no botao adicionar
#    E quando eu preencher o formulario de mensagens e clicar em adicionar, "<tipoMensagem>","<tipoEnvio>"
#    Entao deve ser criada uma nova mensagem com os dados informados
#
#    Exemplos: 
#      | Cenario | DescricaoDoCenario                     | tipoMensagem | tipoEnvio |
#      | CT01.1  | Crirar mensagens ativas Simples padrão | Padrão       | Simples   |
#    #Exemplos: 
#     # | Cenario | DescricaoDoCenario         |
#     # | CT01.1  | excluir mensagens ativas   |
#    #S  | CT01.2  | excluir mensagens pendente |
