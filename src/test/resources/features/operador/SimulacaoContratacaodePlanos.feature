#language: pt
#/**
# * Autor: Michael Alba
# * Empresa: Taking
# * Data: 30/03/2020
# * Caminho: Portal Estabelecimento Comercial
# */

@Regressivo
Funcionalidade: Antecipacao
  Permite contratar planos

  Eu como usuario
  Quero contratar planos para o meu estabelecimento



  @realizar_contratacao @Michael @Simulacao
  Esquema do Cenario: <VSTS> - Realizar Simulação de contratação de planos => <Cenario>
    Dado que estou na logado no portal EC Operador "<user>", "<senha>"
    Quando seleciono um CNPJ de número "<CNPJ>" no combo Estabelecimento
    E contratando plano de "<Cenario>" e contratando "<Contratacao>"
    #Entao a validacao do cenario deve conter como resultado "<Resultado>"

    Exemplos:
      | VSTS   | user           | senha      | CNPJ                              | Cenario          | Contratacao | Resultado                                                              |
      | 9999-1 | 012.345.678-90 | Alelo2020@ | • 04.013.223/0029-45 - 1012770645 | Plano de 02 dias | false       | valor bruto deve ser menor que o valor liquido apresentado na abertura |
      | 9999-2 | 012.345.678-90 | Alelo2020@ | • 04.013.223/0029-45 - 1012770645 | Plano de 07 dias | false       | valor bruto deve ser total                                             |
      | 9999-3 | 012.345.678-90 | Alelo2020@ | • 04.013.223/0029-45 - 1012770645 | Plano de 15 dias | false       | antecipacao recorrente deve estar ativa                                |

