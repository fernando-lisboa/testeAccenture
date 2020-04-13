#language: pt
#/**
#* Autor: Matheus Lisboa
#* Empresa: Taiking
#* Data: 06/03/2020
#* Caminho: Portal Estabelecimento Web Admin
#*/
@criacaoDemensagens
Funcionalidade: CriaçãoDeMensagem
  Criar e enviar um comunicado para cliente estabelecimento comercial

  Eu como usuário
  Desejo criar uma mensagem
  Para enviar um comunicado para cliente estabelecimento comercial

  Contexto:
    Dado que estou na logado no portal webadmim EC "22222222222", "12345678!"

  @criacaoDemensagens
  Esquema do Cenario: <VSTS> notification - <cenario>
    Dado eu clique no botao de mensagem
    E e clicar no botao adicionar
    E quando eu preencher o formulario de mensagens e clicar em adicionar, "<tipoMensagem>","<tipoEnvio>"
    Entao deve ser criada uma nova mensagem com os dados informados

    Exemplos:
      | VSTS   | cenario                                    | tipoMensagem | tipoEnvio |
      | 9999-1 | Crirar mensagens ativas Padrão Simples     | Padrão       | Simples   |
      | 9999-2 | Crirar mensagens ativas Padrão Forçada     | Padrão       | Forçada   |
      | 9999-3 | Crirar mensagens ativas Segmentada Simples | Segmentada   | Simples   |
      | 9999-4 | Crirar mensagens ativas Segmentada Forçada | Segmentada   | Forçada   |

  @criacaoDemensagens
  Esquema do Cenario: <VSTS> notification - <cenario>
    Dado eu clique no menu mensagem
    E clicar no icone de editar
    Entao deve ser alterado a data final da postagem

    Exemplos:
      | VSTS   | cenario         |
      | 9999-5 | editar mensagem |

  @criacaoDemensagens
  Esquema do Cenario: <VSTS> notification - <cenario>
    Dado eu clique na aba de mensagem
    E selecionar o status e filtrar e clicar no icone de excluir, "<status>"
    Entao deve ser apresentado a mensagem de confirmacao de exclusao

    Exemplos:
      | VSTS   | cenario           | status  |
      | 9999-6 | excluir mensagens | Vigente |
      | 9999-7 | excluir mensagens | Inativa |
