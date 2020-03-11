#language: pt
#/**
# * Autor: Fernando Lisboa
# * Empresa: Taking
# * Data: 06/02/2020
# * Caminho: Portal Estabelecimento Comercial
# */
@Painel @Regressivo
Funcionalidade: Painel
  Bloqueio e desbloqueio de planos via Web admim
  
  Eu como backoffice 
  Desejo fazer upload de planilha de bloqueio de painel
  Para clientes inadimplentes

  Contexto: 
    Dado que estou na logado no portal webadmim EC "22222222222", "12345678!"

  @PainelBloqueio22 @Regressivo
  Esquema do Cenario: <VSTS> - Bloqueio <cenario>
    E enviar uma planilha de bloqueio de painel "<path>", "<nomeArquivo>"
    Entao devo verificar que o ec foi bloqueado "<statusEsperado>", "<user>", "<password>", "<cnpj>"

    Exemplos: 
      Exemplos:

      | VSTS | cenario                                                                           | user           | password   | statusEsperado | path                                            | nomeArquivo                             | query                                                | cnpj |
      | 9999 | Bloquear CNPJ que esteja contratado no periodo de testes via upload de planilha   | 570.335.010-72 | Alelo2020@ | Bloqueado      | /src/test/resources/armazenador/bloqueioPainel/ | BloqueioDentroDoPeriodoDeTestes.xlsx    | select * from owadq.tacs_contr_indcd WHERE nu_cnpj = |    1 |
      | 9999 | Bloquear CNPJ que esteja contratado fora periodo de testes via upload de planilha | 570.335.010-72 | Alelo2020@ | Bloqueado      | /src/test/resources/armazenador/bloqueioPainel/ | Bloqueio fora do periodo de testes.xlsx | select * from owadq.tacs_contr_indcd WHERE nu_cnpj = |    2 |

  @Regressivo @PainelBloqueio222
  Esquema do Cenario: <VSTS> - Upload de planilha <cenario>
    E enviar uma planilha de bloqueio de painel "<path>", "<nomeArquivo>"
    Entao devo verificar que o ec foi Desbloqueado "<statusEsperado>", "<user>", "<password>", "<cnpj>"

    Exemplos: 
      | VSTS | cenario                                                                              | user           | password   | statusEsperado | path                                            | nomeArquivo                                 | cnpj |
      | 9999 | Desbloquear CNPJ que esteja contratado no periodo de testes via upload de planilha   | 570.335.010-72 | Alelo2020@ | TESTE GRÁTIS   | /src/test/resources/armazenador/bloqueioPainel/ | Desloqueio dentro do periodo de testes.xlsx |    2 |
      | 9999 | Desbloquear CNPJ que esteja contratado fora periodo de testes via upload de planilha | 570.335.010-72 | Alelo2020@ | Contratado     | /src/test/resources/armazenador/bloqueioPainel/ | Desloqueio fora do periodo de testes.xlsx   |    1 |
