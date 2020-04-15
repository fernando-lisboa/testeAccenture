#language: pt
#/**
# * Autor: Michael Alba
# * Empresa: Taking
# * Data: 30/03/2020
# * Caminho: Portal Estabelecimento Comercial
# */
Funcionalidade: Antecipacao
  Permite contratar planos

  Eu como usuario
  Quero contratar planos para o meu estabelecimento


  @realizar_contratacao @Michael
  Esquema do Cenario: <VSTS> - Realizar Simulação de antecipacao de vendas => <Cenario>
    Dado que estou na logado no portal EC Operador "<user>", "<senha>"
    Quando seleciono um CNPJ de número "<CNPJ>" no combo Estabelecimento
    E estou usando "<Modal>", se cenario "<Cenario>", devo alterar o valor "<Valor>", antecipar "<Antecipacao>" e contratando "<Contratacao>"ando "<Modal>", se cenario "<Cenario>", devo alterar o valor "<Valor>" e antecipar "<Antecipacao>"
    Entao a validacao do cenario deve conter como resultado "<Resultado>"

    Exemplos:
      | VSTS   | user           | senha      | ARV                               | Cenario                 | Modal | Valor | Antecipacao | Contratacao | Resultado                                                              |
      | 9999-1 | 012.345.678-90 | Alelo2020@ | • 28.339.982/0001-60 - 2000496258 | Parcial                 | true  | true  | false       | true        | valor bruto deve ser menor que o valor liquido apresentado na abertura |
      | 9999-2 | 594.114.000-27 | Alelo2020@ | • 28.339.982/0001-60 - 2000496258 | Total                   | true  | false | false       | false       | valor bruto deve ser total                                             |
      | 9999-3 | 594.114.000-27 | Alelo2020@ | • 28.339.982/0001-60 - 2000496258 | Recorrente Diário       | true  | false | true        | false       | antecipacao recorrente deve estar ativa                                |
      | 9999-4 | 594.114.000-27 | Alelo2020@ | • 28.339.982/0001-60 - 2000496258 | RecorrenteTotal Semanal | true  | false | true        | false       | antecipacao recorrente deve estar ativa                                |
      | 9999-5 | 594.114.000-27 | Alelo2020@ | • 28.339.982/0001-60 - 2000496258 | Recorrente Desativado   | true  | false | true        | false       | antecipacao recorrente deve estar inativa                              |
