#language: pt
#/**
# * Autor: Michael Alba
# * Empresa: Taking
# * Data: 30/03/2020
# * Caminho: Portal Estabelecimento Comercial
# */
@Regressivo @Simulation
Funcionalidade: MeusCNPJS
  Permite adicionar CNPJS
  
  Eu como usuario
  Quero adicionar CNPJS para o meu estabelecimento

  @adicionar_CNPJS @OK
  Esquema do Cenario: <VSTS> - Realizar Simulação de antecipacao de vendas => <Cenario>
    Dado que estou na logado no portal EC Operador "<user>", "<senha>"
    E vou pedir ajuda no atendimento e acesso a outra aba do navegador "<operador>"
    Entao eu simulo a associacao do cnpj "<CNPJS>" "<PesquisarCNPJ>" "<operador>"

    Exemplos: 
      | VSTS   | user           | senha      | Cenario          | operador | CNPJ       | CNPJS | PesquisarCNPJ | Resultado                   |
      | 9999-1 | 546.219.170-72 | Alelo2018@ | Adicionar 1 CNPJ | true     | 1012770645 |     1 | null          | CNPJS Simulados com sucesso |
