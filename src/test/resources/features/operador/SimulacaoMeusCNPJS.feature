#language: pt
#/**
# * Autor: Michael Alba
# * Empresa: Taking
# * Data: 30/03/2020
# * Caminho: Portal Estabelecimento Comercial
# */
@Regressivo
Funcionalidade: MeusCNPJS
  Permite adicionar CNPJS

  Eu como usuario
  Quero adicionar CNPJS para o meu estabelecimento


  @adicionar_CNPJS @Michael @Simulacao
  Esquema do Cenario: <VSTS> - Realizar Simulação de antecipacao de vendas => <Cenario>
    Dado que estou na logado no portal EC Operador "<user>", "<senha>"
    #E vou pedir ajuda no atendimento e acesso a outra aba do navegador
    Quando seleciono um CNPJ de número "<CNPJ>" no combo Estabelecimento
    E devo associar CNPJS "<CNPJS>" e pesquisar "<PesquisarCNPJ>"
    Entao a validacao do cenario deve conter como resultado: "<Resultado>"

    Exemplos:
      | VSTS   | user           | senha      | Cenario                       | CNPJ                              | CNPJS | PesquisarCNPJ        | Resultado                   |
      | 9999-1 | 594.114.000-27 | Alelo2020@ | Adicionar 1 CNPJ              | • 04.013.223/0029-45 - 1012770645 | 1     | null                 | CNPJS Simulados com sucesso |
      | 9999-1 | 012.345.678-90 | Alelo2020@ | pedir ajuda no atendimento    | • 04.013.223/0029-45 - 1012770645 | 1     | null                 | CNPJS Simulados com sucesso |
      | 9999-1 | 012.345.678-90 | Alelo2020@ | pesquisar por CNPJ específico | • 04.013.223/0029-45 - 1012770645 | 1     | "04.013.223/0196-78" | CNPJS Pesquisado com sucesso |

