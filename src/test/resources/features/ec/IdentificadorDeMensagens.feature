#language: pt
#/**
#* Autor: Matheus Lisboa
#* Empresa: Taiking
#* Data: 12/03/2020
#* Caminho: Portal Estabelecimento Web Admin
#*/
@Antecipacao1 @front @Regressivo
Funcionalidade: CriaçãoDeMensagem
   Criar e enviar um comunicado para cliente estabelecimento comercial
  
  Eu como usuário
  Desejo criar uma mensagem
  Para enviar um comunicado para cliente estabelecimento comercial

  Contexto: 
    Dado que estou na logado no portal EC "538.984.648-65", "Alelo2018@"

  @Release-15 @indicadorNotificacao @Regressivo
  Esquema do Cenario: <VSTS> notification - <cenario>
    Dado que eu tenha um usuário com notificações
    Então devo validar que o icone de notificação está visivel com a quantidade de notificacoes disponiveis

    Exemplos: 
      | VSTS | cenario                             |
      | 9999 | identificar notificacao de mensagem |
