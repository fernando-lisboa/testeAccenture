#language: pt
#/**
# * Autor: Fernando Lisboa
# * Empresa: Taiking
# * Data: 23/05/2019
# * Caminho: Portal Estabelecimento Web Admin
# */
@Antecipacao1 @front @Regressao
Funcionalidade: CriaçãoDeMensagem
    Criar e enviar um comunicado para cliente estabelecimento comercial
  
  Eu como usuário
  Desejo criar uma mensagem
  Para enviar um comunicado para cliente estabelecimento comercial

  Contexto: 
    Dado que estou logado em qualquer tela no Web Admin

  @Release-15 @criacaoDemensagens
  Esquema do Cenario: [Busca web] "<Cenario>"-"<DescricaoDoCenario>"
    Dado eu clique no botao de mensagem
    E e clicar no botao adicionar
    E quando eu preencher o formulario de mensagens e clicar em adicionar, "<tipoMensagem>","<tipoEnvio>"
    Entao deve ser criada uma nova mensagem com os dados informados

    Exemplos: 
      | Cenario | DescricaoDoCenario                           | tipoMensagem | tipoEnvio  |
      | CT01.1  | Crirar mensagens ativas Simples padrão       | Padrão      | Simples     |
      #| CT01.2  | Crirar mensagens ativas Simples segmentada   | Simples      | segmentada |
     # | CT01.3  | Crirar mensagens ativas Forçada padrão       | Forçada      | padrao     |
      #| CT01.4  | Crirar mensagens ativas Forçada segmentada   | Forçada      | segmentada |
     # | CT01.5  | Crirar mensagens pendente Simples padrão     | Simples      | padrao     |
      #| CT01.6  | Crirar mensagens pendente Simples segmentada | Simples      | segmentada |
      #| CT01.7  | Crirar mensagens pendente Forçada padrão     | Forçada      | padrao     |
      #| CT01.8  | Crirar mensagens pendente Forçada segmentada | Forçada      | segmentada |

 # @Release-15 @criacaoDemensagens
 #Esquema do Cenario: [Busca web] "<Cenario>"-"<DescricaoDoCenario>"
    #Dado eu clique no botao de mensagem
   # E e clicar no botao editar mensagem
   # E preencher as datas para editar a mensagem
  #  Entao então a vigencia da mensagem deve ficar de acordo com a alteracao feita

    #Exemplos: 
      #| Cenario | DescricaoDoCenario                |
      #| CT01.1  | editar mensagens ativas Simples   |
      #| CT01.2  | editar mensagens ativas Forçada   |
     # | CT01.3  | editar mensagens pendente Simples |
     # | CT01.4  | editar mensagens pendente Forçada |

 # @Release-15 @criacaoDemensagens
 # Esquema do Cenario: [Busca web] "<Cenario>"-"<DescricaoDoCenario>"
    #Dado eu clique no botao de mensagem
    #E e clicar no botao editar mensagem
   #E preencher as datas para editar a mensagem
    #Entao então a vigencia da mensagem deve ficar de acordo com a alteracao feita

    #Exemplos: 
     # | Cenario | DescricaoDoCenario         |
     # | CT01.1  | excluir mensagens ativas   |
    #S  | CT01.2  | excluir mensagens pendente |
