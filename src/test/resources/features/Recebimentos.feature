#language: pt
#/**
# * @author Fernando Lisboa - Taking
# * Change: 08/01/2019 | Author: Jessé Dantas - Taking
# * Caminho: Portal Estabelecimento Comercial
# */
#@Regressivo
#Funcionalidade: Recebimentos
  #Permite a consulta dos valores a serem disponibilizados ao usuario ao longo do mes

 # Contexto: 
   # Dado que estou na logado no portal EC "546.219.170-72", "Alelo2018@"

#  @RecebimentoMes @Regressivo
 # Esquema do Cenario: <VSTS> - Recebimento mensal <cenario>
 #   Quando eu clicar no menu recebimentos "<cnpj>"
  # Entao devo validar que é exibido o valor recebido e o valor a receber do meu ec "<periodo>"

  #  Exemplos: 
    #  | VSTS | cenario                                            | periodo      | cnpj           |
    #  | 9999 | Realizar consulta de valores a receber e recebidos | mês atual    | 28339982000160 |
    # | 9999 | Realizar consulta de valores a receber             | mês seguinte | 28339982000160 |
     # | 9999 | Realizar consulta de valores recebidos             | mês anterior | 28339982000160 |
