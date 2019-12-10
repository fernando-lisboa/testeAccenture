#language: pt
#/**
# * Autor: Fernando Lisboa
# * Empresa: Taking
# * Data: 06/12/2019
# * Caminho: Portal Estabelecimento Web Admin
# */
@ArvCentral @front @Release-15 @Regressivo @Regressao
Funcionalidade: Contratacao ARV pela Central -  Perfil Operador
    Consultar e contratar ARV pela central - pontual, recorrente e automática
  
  Eu como operador da central
  Desejo Consultar e contratar ARV através


  ############################################# - VALIDACA DE PERFIL DE ACESSO - OPERADOR #############################################
  @Release-15 @Regressivo @ArvNaCentral @Automatica
  Cenario: Contratacao ARV Automática na central
Dado que eu logue no portal Arv na central com o perfil de operador
E que informe um CNPJ válido
E e clicar no botao buscar
E aparecer a tela com o campo dos dados cadastrais e as condicoes de antecipacao total e parcial para o operador
E Selecionar um EC para contratacao automatica e clicar em Alterar
E escolher a opcao de recorrencia diariaa
E o operador clicar no botao definir recebimento
E retornar para a tela de resultado da busca de CNPJ com a recorrencia escolhida
E o operador clicar para gerar proposta
E o sistema apresentar a soma dos valores a serem antecipados
Quando o operdaor prenencher o check de termo de aceite e clicar confirmar e contratar
Entao deve apresentar a tela de Antecipacao realizada com sucesso com a msg todos os codigos foram antecipados e o botao fechar 

@Release-15 @Regressivo @ArvNaCentral @Total
  Cenario: Contratacao ARV Pontual Total na central
Dado que eu logue no portal Arv na central com o perfil de operador
E que informe um CNPJ válid
E e clicar no botao buscar
E aparecer a tela com o campo dos dados cadastrais e as condicoes de antecipacao total e parcial para o operador
E Selecionar um EC para contratacao pontual total
E o operador clicar no botao definir recebimento
E apresentar os valores a serem antecipados
Quando o operdaor prenencher o check de termo de aceite e clicar confirmar e contratar
Entao deve apresentar a tela de Antecipacao realizada com sucesso com a msg todos os códigos foram antecipados e o botao fechar 

@Release-15 @Regressivo @ArvNaCentral @Parcial
  Cenario: Contratacao ARV Pontual parcial na central
Dado que eu logue no portal Arv na central com o perfil de operador
E que informe um CNPJ válid
E e clicar no botao buscar
E aparecer a tela com o campo dos dados cadastrais e as condicoes de antecipacao total e parcial para o operador
E o operador selecionar um Ec para alteracao de antecipacao
E o operador clicar em alterar
E inserir  o valor a ser antecipado "<parcial>"
E clicar no botao calcular valores disponiveis
E apresentar a tela com as duas opcoes de antecipacoes
E o operador selecionar uma das opcoes oferecidas
E o operador clicar no botao calcular valor liquido
E retornar para a tela de resultado da busca de CNPJ com a recorrencia escolhida
E o operador clicar para gerar proposta
E o operador conferir a soma dos valores a serem antecipados
Quando o operdaor prenencher o check de termo de aceite e clicar confirmar e contratar
Entao deve apresentar a tela de Antecipacao realizada com sucesso com a msg todos os códigos foram antecipados e o botao fechar
  
  