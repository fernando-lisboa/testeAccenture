#language: pt
#/**
# * @author Fernando Lisboa - Taking
# * Change: 08/01/2019 | Author: Jessé Dantas - Taking
# * Caminho: Portal Estabelecimento Comercial
# */
@ignore
Funcionalidade: Recebimentos
  Permite a consulta dos valores a serem disponibilizados ao usuario ao longo do mes

  Contexto: 
    Dado que estou na logado no portal EC "363.981.960-82", "Alelo2020@"

  @RecebimentoMes @ignore
  Esquema do Cenario: <VSTS> - Recebimento mensal <cenario>
    Quando eu clicar no menu recebimentos "<cnpj>"
    Entao devo validar que é exibido o valor recebido e o valor a receber do meu ec "<periodo>"

    Exemplos: 
      | VSTS | cenario                                                | periodo      | cnpj           |
      | 9999 | Realizar consulta de valores a receber e recebidos     | mês atual    | 28339982000160 |
      | 9999 | Realizar consulta de valores a receber no proximo mes  | mês seguinte | 28339982000160 |
      | 9999 | Realizar consulta de valores recebidos no mes anterior | mês anterior | 28339982000160 |
