package br.com.alelo.qa.features.steps;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.List;
import java.util.Map;

import br.com.alelo.qa.data.entity.TransacoesAprovadas;
import br.com.alelo.qa.data.entity.VendasDetalhadas;
import br.com.alelo.qa.features.support.ParentSteps;
import br.com.alelo.qa.web.actions.ExtratoActions;
import br.com.alelo.qa.web.actions.PainelActions;
import br.com.alelo.qa.web.util.CSVUtil;
import br.com.alelo.qa.web.util.DriverUtil;
import br.com.alelo.qa.web.util.PDFUtil;
import br.com.alelo.utils.setupTestes.actions.CommonsActions;
import cucumber.api.DataTable;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;

public class ExtratoStep extends ParentSteps {

	CommonsActions comm = new CommonsActions();
	
	@Dado("^que um  Ec tenha as seguintes transacoes aprovadas$")
	public void que_um_Ec_tenha_as_seguintes_transacoes_aprovadas(List<TransacoesAprovadas> listTransacoes)
			throws Throwable {
		comm.insertMassaExtratoHML();
		System.out.println("massa inserida de extrato");
	}
	
	@Dado("^a taxa de tarifa de anuidade$")
	public void a_taxa_de_tarifa_de_anuidade(DataTable tarifa) throws Throwable {
	}

	@Quando("^eu buscar por este IdEc \"([^\"]*)\"$")
	public void eu_buscar_por_este_IdEc(String idEc) throws Throwable {

		PainelActions painel = new PainelActions(webdriver);
		painel.realizaBuscaEstabelecimento(idEc);

		DriverUtil driverUtil = new DriverUtil(webdriver);
		driverUtil.aguardaModalLoaderCarregar();

	}

	@Quando("^clicar no link extrato$")
	public void clicar_no_link_extrato() throws Throwable {
		PainelActions painel = new PainelActions(webdriver);

		painel.clicaMenuExtrato();
	}

	@Quando("^filtrar pela data entre$")
	public void filtrar_pela_data_entre(Map<String, String> map) throws Throwable {

		ExtratoActions extratoActions = new ExtratoActions(webdriver);
		DriverUtil driverUtil = new DriverUtil(webdriver);

		extratoActions.TratamentoData(map.get("dataInicio"),map.get("dataFim"));
//		extratoActions.selecionaDataCalendarioAnterior(map.get("diaInicial"), map.get("mesInicial"),
//				map.get("anoInicial"), map.get("diaFinal"), map.get("mesFinal"), map.get("anoFinal"));

		driverUtil.aguardaModalLoaderCarregar();
	}

	@Entao("^deve apresentar o extrato sumarizado com duas linhas$")
	public void deve_apresentar_o_extrato_sumarizado_com_duas_linhas(Map<String, String> map) throws Throwable {

		ExtratoActions extratoActions = new ExtratoActions(webdriver);

		List<String> camposDataRel = extratoActions.getColDataRelatorio();

		assertThat(camposDataRel.size(), equalTo(2));
		assertThat(camposDataRel.get(0), equalTo("20\nMAR / 2020"));
		assertThat(camposDataRel.get(1), equalTo("22\nMAR / 2020"));

		List<String> camposTransRel = extratoActions.getColTransRelatorio();

		assertThat(camposTransRel.size(), equalTo(2));
		assertThat(camposTransRel.get(0), equalTo("VENDAS\nR$ 108,99"));
		assertThat(camposTransRel.get(1), equalTo("VENDAS\nR$ 374,70"));
	}

	@Entao("^deve apresentar o extrato com duas linhas$")
	public void deve_apresentar_o_extrato_com_duas_linhas(Map<String, String> map) throws Throwable {

		ExtratoActions extratoActions = new ExtratoActions(webdriver);

		List<String> camposDataRel = extratoActions.getColDataRelatorio();

		assertThat(camposDataRel.size(), equalTo(2));
		assertThat(camposDataRel.get(0), equalTo("26\nFEV / 2020"));
		assertThat(camposDataRel.get(1), equalTo("20\nMAR / 2020"));

		List<String> camposTransRel = extratoActions.getColTransRelatorio();

		assertThat(camposTransRel.size(), equalTo(2));
		assertThat(camposTransRel.get(0), equalTo("VENDAS\nR$ 5,17"));
		assertThat(camposTransRel.get(1), equalTo("VENDAS\nR$ 108,99"));
	}

	@Entao("^o valor total \"([^\"]*)\"$")
	public void o_valor_total(String valor) throws Throwable {

		ExtratoActions extratoActions = new ExtratoActions(webdriver);

		assertThat(extratoActions.getTextoValorTotalExtrato(), equalTo(valor));

	}

	@Entao("^as vendas detalhadas de cada dia$")
	public void as_vendas_detalhadas_de_cada_dia(List<VendasDetalhadas> listaVendasDetalhadas) throws Throwable {

		ExtratoActions extratoActions = new ExtratoActions(webdriver);

		extratoActions.clicaLinhaSumarizada(1);

		assertThat(extratoActions.getCabecalhoTabelaDetalhada(), equalTo(
				"DESCRIÇÃO Nº DA TRANSAÇÃO Nº DA AUTORIZAÇÃO CREDENCIADORA Nº DO CARTÃO PAGAMENTO R$ BRUTO R$ LÍQUIDO"));

		List<String> campos = extratoActions.getcamposTabelaDetalhada();

		assertThat(campos.get(0), equalTo(listaVendasDetalhadas.get(0).getDescricao()));
		assertThat(campos.get(1), equalTo(listaVendasDetalhadas.get(0).getNumTransacao()));
		assertThat(campos.get(2), equalTo(listaVendasDetalhadas.get(0).getNumAutorizacao()));
		assertThat(campos.get(3), equalTo(listaVendasDetalhadas.get(0).getCredenciadora()));
		assertThat(campos.get(4), containsString(listaVendasDetalhadas.get(0).getNumCartao()));
		assertThat(campos.get(4), containsString("REFEIÇÃO"));
		assertThat(campos.get(5), equalTo(listaVendasDetalhadas.get(0).getPagamento()));
		assertThat(campos.get(6), equalTo("R$ " + listaVendasDetalhadas.get(0).getValBruto()));
		assertThat(campos.get(7), equalTo("R$ " + listaVendasDetalhadas.get(0).getValLiquido()));

		assertThat(campos.get(8), equalTo(listaVendasDetalhadas.get(1).getDescricao()));
		assertThat(campos.get(9), equalTo(listaVendasDetalhadas.get(1).getNumTransacao()));
		assertThat(campos.get(10), equalTo(listaVendasDetalhadas.get(1).getNumAutorizacao()));
		assertThat(campos.get(11), equalTo(listaVendasDetalhadas.get(1).getCredenciadora()));
		assertThat(campos.get(12), containsString(listaVendasDetalhadas.get(1).getNumCartao()));
		assertThat(campos.get(12), containsString("REFEIÇÃO"));
		assertThat(campos.get(13), equalTo(listaVendasDetalhadas.get(1).getPagamento()));
		assertThat(campos.get(14), equalTo("R$ " + listaVendasDetalhadas.get(1).getValBruto()));
		assertThat(campos.get(15), equalTo("R$ " + listaVendasDetalhadas.get(1).getValLiquido()));

		assertThat(campos.get(16), equalTo(listaVendasDetalhadas.get(2).getDescricao()));
		assertThat(campos.get(17), equalTo(listaVendasDetalhadas.get(2).getNumTransacao()));
		assertThat(campos.get(18), equalTo(listaVendasDetalhadas.get(2).getNumAutorizacao()));
		assertThat(campos.get(19), equalTo(listaVendasDetalhadas.get(2).getCredenciadora()));
		assertThat(campos.get(20), containsString(listaVendasDetalhadas.get(2).getNumCartao()));
		assertThat(campos.get(20), containsString("REFEIÇÃO"));
		assertThat(campos.get(21), equalTo(listaVendasDetalhadas.get(2).getPagamento()));
		assertThat(campos.get(22), equalTo("R$ " + listaVendasDetalhadas.get(2).getValBruto()));
		assertThat(campos.get(23), equalTo("R$ " + listaVendasDetalhadas.get(2).getValLiquido()));

		assertThat(campos.get(24), equalTo(listaVendasDetalhadas.get(3).getDescricao()));
		assertThat(campos.get(25), equalTo(listaVendasDetalhadas.get(3).getNumTransacao()));
		assertThat(campos.get(26), equalTo(listaVendasDetalhadas.get(3).getNumAutorizacao()));
		assertThat(campos.get(27), equalTo(listaVendasDetalhadas.get(3).getCredenciadora()));
		assertThat(campos.get(28), containsString(listaVendasDetalhadas.get(3).getNumCartao()));
		assertThat(campos.get(28), containsString("REFEIÇÃO"));
		assertThat(campos.get(29), equalTo(listaVendasDetalhadas.get(3).getPagamento()));
		assertThat(campos.get(30), equalTo("R$ " + listaVendasDetalhadas.get(3).getValBruto()));
		assertThat(campos.get(31), equalTo("R$ " + listaVendasDetalhadas.get(3).getValLiquido()));

		assertThat(campos.get(32), equalTo(listaVendasDetalhadas.get(4).getDescricao()));
		assertThat(campos.get(33), equalTo(listaVendasDetalhadas.get(4).getNumTransacao()));
		assertThat(campos.get(34), equalTo(listaVendasDetalhadas.get(4).getNumAutorizacao()));
		assertThat(campos.get(35), equalTo(listaVendasDetalhadas.get(4).getCredenciadora()));
		assertThat(campos.get(36), containsString(listaVendasDetalhadas.get(4).getNumCartao()));
		assertThat(campos.get(36), containsString("REFEIÇÃO"));
		assertThat(campos.get(37), equalTo(listaVendasDetalhadas.get(4).getPagamento()));
		assertThat(campos.get(38), equalTo("R$ " + listaVendasDetalhadas.get(4).getValBruto()));
		assertThat(campos.get(39), equalTo("R$ " + listaVendasDetalhadas.get(4).getValLiquido()));

		extratoActions.clicaLinhaSumarizada(1);
		extratoActions.clicaLinhaSumarizada(2);

		campos = extratoActions.getcamposTabelaDetalhada();

		assertThat(extratoActions.getCabecalhoTabelaDetalhada(), equalTo(
				"DESCRIÇÃO Nº DA TRANSAÇÃO Nº DA AUTORIZAÇÃO CREDENCIADORA Nº DO CARTÃO PAGAMENTO R$ BRUTO R$ LÍQUIDO"));

		assertThat(campos.get(0), equalTo(listaVendasDetalhadas.get(5).getDescricao()));
		assertThat(campos.get(1), equalTo(listaVendasDetalhadas.get(5).getNumTransacao()));
		assertThat(campos.get(2), equalTo(listaVendasDetalhadas.get(5).getNumAutorizacao()));
		assertThat(campos.get(3), equalTo(listaVendasDetalhadas.get(5).getCredenciadora()));
		assertThat(campos.get(4), containsString(listaVendasDetalhadas.get(5).getNumCartao()));
		assertThat(campos.get(4), containsString("REFEIÇÃO"));
		assertThat(campos.get(5), equalTo(listaVendasDetalhadas.get(5).getPagamento()));
		assertThat(campos.get(6), equalTo("R$ " + listaVendasDetalhadas.get(5).getValBruto()));
		assertThat(campos.get(7), equalTo("R$ " + listaVendasDetalhadas.get(5).getValLiquido()));

		assertThat(campos.get(8), equalTo(listaVendasDetalhadas.get(6).getDescricao()));
		assertThat(campos.get(9), equalTo(listaVendasDetalhadas.get(6).getNumTransacao()));
		assertThat(campos.get(10), equalTo(listaVendasDetalhadas.get(6).getNumAutorizacao()));
		assertThat(campos.get(11), equalTo(listaVendasDetalhadas.get(6).getCredenciadora()));
		assertThat(campos.get(12), containsString(listaVendasDetalhadas.get(6).getNumCartao()));
		assertThat(campos.get(12), containsString("REFEIÇÃO"));
		assertThat(campos.get(13), equalTo(listaVendasDetalhadas.get(6).getPagamento()));
		assertThat(campos.get(14), equalTo("R$ " + listaVendasDetalhadas.get(6).getValBruto()));
		assertThat(campos.get(15), equalTo("R$ " + listaVendasDetalhadas.get(6).getValLiquido()));

		assertThat(campos.get(16), equalTo(listaVendasDetalhadas.get(7).getDescricao()));
		assertThat(campos.get(17), equalTo(listaVendasDetalhadas.get(7).getNumTransacao()));
		assertThat(campos.get(18), equalTo(listaVendasDetalhadas.get(7).getNumAutorizacao()));
		assertThat(campos.get(19), equalTo(listaVendasDetalhadas.get(7).getCredenciadora()));
		assertThat(campos.get(20), containsString(listaVendasDetalhadas.get(7).getNumCartao()));
		assertThat(campos.get(20), containsString("REFEIÇÃO"));
		assertThat(campos.get(21), equalTo(listaVendasDetalhadas.get(7).getPagamento()));
		assertThat(campos.get(22), equalTo("R$ " + listaVendasDetalhadas.get(7).getValBruto()));
		assertThat(campos.get(23), equalTo("R$ " + listaVendasDetalhadas.get(7).getValLiquido()));

		assertThat(campos.get(24), equalTo(listaVendasDetalhadas.get(8).getDescricao()));
		assertThat(campos.get(25), equalTo(listaVendasDetalhadas.get(8).getNumTransacao()));
		assertThat(campos.get(26), equalTo(listaVendasDetalhadas.get(8).getNumAutorizacao()));
		assertThat(campos.get(27), equalTo(listaVendasDetalhadas.get(8).getCredenciadora()));
		assertThat(campos.get(28), containsString(listaVendasDetalhadas.get(8).getNumCartao()));
		assertThat(campos.get(28), containsString("REFEIÇÃO"));
		assertThat(campos.get(29), equalTo(listaVendasDetalhadas.get(8).getPagamento()));
		assertThat(campos.get(30), equalTo("R$ " + listaVendasDetalhadas.get(8).getValBruto()));
		assertThat(campos.get(31), equalTo("R$ " + listaVendasDetalhadas.get(8).getValLiquido()));

		assertThat(campos.get(32), equalTo(listaVendasDetalhadas.get(9).getDescricao()));
		assertThat(campos.get(33), equalTo(listaVendasDetalhadas.get(9).getNumTransacao()));
		assertThat(campos.get(34), equalTo(listaVendasDetalhadas.get(9).getNumAutorizacao()));
		assertThat(campos.get(35), equalTo(listaVendasDetalhadas.get(9).getCredenciadora()));
		assertThat(campos.get(36), containsString(listaVendasDetalhadas.get(9).getNumCartao()));
		assertThat(campos.get(36), containsString("REFEIÇÃO"));
		assertThat(campos.get(37), equalTo(listaVendasDetalhadas.get(9).getPagamento()));
		assertThat(campos.get(38), equalTo("R$ " + listaVendasDetalhadas.get(9).getValBruto()));
		assertThat(campos.get(39), equalTo("R$ " + listaVendasDetalhadas.get(9).getValLiquido()));

		assertThat(campos.get(40), equalTo(listaVendasDetalhadas.get(10).getDescricao()));
		assertThat(campos.get(41), equalTo(listaVendasDetalhadas.get(10).getNumTransacao()));
		assertThat(campos.get(42), equalTo(listaVendasDetalhadas.get(10).getNumAutorizacao()));
		assertThat(campos.get(43), equalTo(listaVendasDetalhadas.get(10).getCredenciadora()));
		assertThat(campos.get(44), containsString(listaVendasDetalhadas.get(10).getNumCartao()));
		assertThat(campos.get(44), containsString("REFEIÇÃO"));
		assertThat(campos.get(45), equalTo(listaVendasDetalhadas.get(10).getPagamento()));
		assertThat(campos.get(46), equalTo("R$ " + listaVendasDetalhadas.get(10).getValBruto()));
		assertThat(campos.get(47), equalTo("R$ " + listaVendasDetalhadas.get(10).getValLiquido()));

		assertThat(campos.get(48), equalTo(listaVendasDetalhadas.get(11).getDescricao()));
		assertThat(campos.get(49), equalTo(listaVendasDetalhadas.get(11).getNumTransacao()));
		assertThat(campos.get(50), equalTo(listaVendasDetalhadas.get(11).getNumAutorizacao()));
		assertThat(campos.get(51), equalTo(listaVendasDetalhadas.get(11).getCredenciadora()));
		assertThat(campos.get(52), containsString(listaVendasDetalhadas.get(11).getNumCartao()));
		assertThat(campos.get(52), containsString("REFEIÇÃO"));
		assertThat(campos.get(53), equalTo(listaVendasDetalhadas.get(11).getPagamento()));
		assertThat(campos.get(54), equalTo("R$ " + listaVendasDetalhadas.get(11).getValBruto()));
		assertThat(campos.get(55), equalTo("R$ " + listaVendasDetalhadas.get(11).getValLiquido()));

		extratoActions.clicaLinhaSumarizada(1);
		extratoActions.clicaLinhaSumarizada(2);
	}

	@Quando("^clicar no botão PDF$")
	public void clicar_no_botão_PDF() throws Throwable {

		ExtratoActions extratoActions = new ExtratoActions(webdriver);
		extratoActions.clicaBotaoExportarPDF();
	}

	@Quando("^clicar no botão CSV$")
	public void clicar_no_botão_CSV() throws Throwable {
		ExtratoActions extratoActions = new ExtratoActions(webdriver);
		extratoActions.clicaBotaoExportarCSV();
	}

	@Quando("^clicar no botão imprimir$")
	public void clicar_no_botão_imprimir() throws Throwable {
		ExtratoActions extratoActions = new ExtratoActions(webdriver);
		extratoActions.clicaBotaoImprimir();

	}

	@Entao("^apresentar no CSV as vendas detalhadas para cada dia$")
	public void apresentar_no_CSV_as_vendas_detalhadas_para_cada_dia() throws Throwable {

		ExtratoActions extratoActions = new ExtratoActions(webdriver);
		
		CSVUtil csvUtil = new CSVUtil();

		List<String> linhasCSV = csvUtil.leCSV();

		assertThat(linhasCSV.get(0), equalTo(
				"[N DA AUTORIZACAO, N CARTAO, TIPO CARTAO, CREDENCIADORA, DESCRICAO, VALOR BRUTO, VALOR LIQUIDO, DATA, STATUS, N DA TRANSACAO]"));
		assertThat(linhasCSV.get(1), equalTo(
				"[042443, 5067 **** **** 6013, RefeiÃ§Ã£o, CIELO, VENDA, 5.5, 5.17, 26/02/2020, APROVADO, 5291686045]"));
		assertThat(linhasCSV.get(2), equalTo(
				"[561275, 5067 **** **** 6015, RefeiÃ§Ã£o, CIELO, VENDA, 22.7, 21.45, 20/03/2020, APROVADO, 5292564652]"));
		assertThat(linhasCSV.get(3), equalTo(
				"[384360, 5067 **** **** 0023, RefeiÃ§Ã£o, CIELO, VENDA, 6, 5.7, 20/03/2020, APROVADO, 5291686049]"));
		assertThat(linhasCSV.get(4), equalTo(
				"[213619, 5067 **** **** 3021, RefeiÃ§Ã£o, CIELO, VENDA, 29.4, 27.67, 20/03/2020, APROVADO, 5291686048]"));
		assertThat(linhasCSV.get(5), equalTo(
				"[747600, 5067 **** **** 6013, RefeiÃ§Ã£o, CIELO, VENDA, 19, 17.86, 20/03/2020, APROVADO, 5291686047]"));
		assertThat(linhasCSV.get(6), equalTo(
				"[444997, 5067 **** **** 9011, RefeiÃ§Ã£o, PAG SEGURA, VENDA, 38.5, 36.31, 20/03/2020, APROVADO, 5291686046]"));
		
		csvUtil.limpaDiretorioDownload();
		
		extratoActions.clicaBotaoExportarInferiorCSV();
		
		linhasCSV = csvUtil.leCSV();

		assertThat(linhasCSV.get(0), equalTo(
				"[N DA AUTORIZACAO, N CARTAO, TIPO CARTAO, CREDENCIADORA, DESCRICAO, VALOR BRUTO, VALOR LIQUIDO, DATA, STATUS, N DA TRANSACAO]"));
		assertThat(linhasCSV.get(1), equalTo(
				"[042443, 5067 **** **** 6013, RefeiÃ§Ã£o, CIELO, VENDA, 5.5, 5.17, 26/02/2020, APROVADO, 5291686045]"));
		assertThat(linhasCSV.get(2), equalTo(
				"[561275, 5067 **** **** 6015, RefeiÃ§Ã£o, CIELO, VENDA, 22.7, 21.45, 20/03/2020, APROVADO, 5292564652]"));
		assertThat(linhasCSV.get(3), equalTo(
				"[384360, 5067 **** **** 0023, RefeiÃ§Ã£o, CIELO, VENDA, 6, 5.7, 20/03/2020, APROVADO, 5291686049]"));
		assertThat(linhasCSV.get(4), equalTo(
				"[213619, 5067 **** **** 3021, RefeiÃ§Ã£o, CIELO, VENDA, 29.4, 27.67, 20/03/2020, APROVADO, 5291686048]"));
		assertThat(linhasCSV.get(5), equalTo(
				"[747600, 5067 **** **** 6013, RefeiÃ§Ã£o, CIELO, VENDA, 19, 17.86, 20/03/2020, APROVADO, 5291686047]"));
		assertThat(linhasCSV.get(6), equalTo(
				"[444997, 5067 **** **** 9011, RefeiÃ§Ã£o, PAG SEGURA, VENDA, 38.5, 36.31, 20/03/2020, APROVADO, 5291686046]"));
		

	}

	@Entao("^apresentar no PDF as vendas detalhadas para cada dia$")
	public void apresentar_no_PDF_as_vendas_detalhadas_para_cada_dia() throws Throwable {

		ExtratoActions extratoActions = new ExtratoActions(webdriver);
		
		PDFUtil pdfUtil = new PDFUtil();
		List<String> fileData = pdfUtil.lePDF();

		assertThat(fileData.get(0), equalTo(
				"N DA AUTORIZA... N CARTAO TIPO CAR... CREDENCIAD... DESCRI... VALOR BR... VALOR LIQU... DATA STATUS N DA TRANSA..."));
		assertThat(fileData.get(1),
				equalTo(" 042443 5067 **** **** 6013 Refeição CIELO VENDA 5.5 5.17 26/02/202 0 APROVAD O 5291686045"));
		assertThat(fileData.get(2), equalTo(
				" 561275 5067 **** **** 6015 Refeição CIELO VENDA 22.7 21.45 20/03/202 0 APROVAD O 5292564652"));
		assertThat(fileData.get(3),
				equalTo(" 384360 5067 **** **** 0023 Refeição CIELO VENDA 6 5.7 20/03/202 0 APROVAD O 5291686049"));
		assertThat(fileData.get(4), equalTo(
				" 213619 5067 **** **** 3021 Refeição CIELO VENDA 29.4 27.67 20/03/202 0 APROVAD O 5291686048"));
		assertThat(fileData.get(5),
				equalTo(" 747600 5067 **** **** 6013 Refeição CIELO VENDA 19 17.86 20/03/202 0 APROVAD O 5291686047"));
		assertThat(fileData.get(6), equalTo(
				" 444997 5067 **** **** 9011 Refeição PAG SEGURA VENDA 38.5 36.31 20/03/202 0 APROVAD O 5291686046"));

		pdfUtil.limpaDiretorioDownload();
		
		extratoActions.clicaBotaoExportarInferiorPDF();
		
		fileData = pdfUtil.lePDF();

		assertThat(fileData.get(0), equalTo(
				"N DA AUTORIZA... N CARTAO TIPO CAR... CREDENCIAD... DESCRI... VALOR BR... VALOR LIQU... DATA STATUS N DA TRANSA..."));
		assertThat(fileData.get(1),
				equalTo(" 042443 5067 **** **** 6013 Refeição CIELO VENDA 5.5 5.17 26/02/202 0 APROVAD O 5291686045"));
		assertThat(fileData.get(2), equalTo(
				" 561275 5067 **** **** 6015 Refeição CIELO VENDA 22.7 21.45 20/03/202 0 APROVAD O 5292564652"));
		assertThat(fileData.get(3),
				equalTo(" 384360 5067 **** **** 0023 Refeição CIELO VENDA 6 5.7 20/03/202 0 APROVAD O 5291686049"));
		assertThat(fileData.get(4), equalTo(
				" 213619 5067 **** **** 3021 Refeição CIELO VENDA 29.4 27.67 20/03/202 0 APROVAD O 5291686048"));
		assertThat(fileData.get(5),
				equalTo(" 747600 5067 **** **** 6013 Refeição CIELO VENDA 19 17.86 20/03/202 0 APROVAD O 5291686047"));
		assertThat(fileData.get(6), equalTo(
				" 444997 5067 **** **** 9011 Refeição PAG SEGURA VENDA 38.5 36.31 20/03/202 0 APROVAD O 5291686046"));
		
	}

	@Entao("^apresentar janela de impressao$")
	public void apresentar_janela_de_impressao() throws Throwable {
		ExtratoActions extratoActions = new ExtratoActions(webdriver);
		List<String> conteudoModalImprimir = extratoActions.getConteudoModalImprimir();

		for (String linha : conteudoModalImprimir) {
			System.out.println(linha);
		}

		assertThat(conteudoModalImprimir.get(0), equalTo("DATA: 1582686000000"));
		assertThat(conteudoModalImprimir.get(1), equalTo("DESCRIÇÃO: VENDA"));
		assertThat(conteudoModalImprimir.get(2), equalTo("NÚMERO DA TRANSAÇÃO: 5291686045"));
		assertThat(conteudoModalImprimir.get(3), equalTo("NÚMERO DO CARTÃO: REFEIÇÃO"));
		assertThat(conteudoModalImprimir.get(4), equalTo("PAGAMENTO: APROVADO"));
		assertThat(conteudoModalImprimir.get(5), equalTo("R$ BRUTO: 5.5"));
		assertThat(conteudoModalImprimir.get(6), equalTo("R$ LÍQUIDO5.17"));

		assertThat(extratoActions.isBotaoModalImprimirFecharSuperiorDisplayed(), is(true));
		assertThat(extratoActions.isBotaoModalImprimirFecharInferiorDisplayed(), is(true));
		assertThat(extratoActions.isBotaoModalImprimirDisplayed(), is(true));

	}
	
	

	@Entao("^deve apresentar o extrato sumarizado$")
	public void deve_apresentar_o_extrato_sumarizado() throws Throwable {
		
		ExtratoActions extratoActions = new ExtratoActions(webdriver);

		List<String> camposDataRel = extratoActions.getColDataRelatorio();

		assertThat(camposDataRel.size(), equalTo(1));
		assertThat(camposDataRel.get(0), equalTo("03\nABR / 2020"));

		List<String> camposTransRel = extratoActions.getColTransRelatorio();

		assertThat(camposTransRel.size(), equalTo(1));
		assertThat(camposTransRel.get(0), containsString("VENDAS\nR$ 160,45"));

	}

	@Entao("^a linha para outras transacoes no valor \"([^\"]*)\"$")
	public void a_linha_para_outras_transacoes_no_valor(String arg1) throws Throwable {
	    
		ExtratoActions extratoActions = new ExtratoActions(webdriver);
		List<String> camposTransRel = extratoActions.getColTransRelatorio();
		assertThat(camposTransRel.get(0), containsString("OUTRAS TRANSAÇÕES\n- R$ 104,00"));
		
	}
	
	@Entao("^as vendas detalhadas$")
	public void as_vendas_detalhadas(List<VendasDetalhadas> listaVendasDetalhadas) throws Throwable {
		
		ExtratoActions extratoActions = new ExtratoActions(webdriver);

		extratoActions.clicaLinhaSumarizada(1);

		assertThat(extratoActions.getCabecalhoTabelaDetalhada(), equalTo(
				"DESCRIÇÃO Nº DA TRANSAÇÃO Nº DA AUTORIZAÇÃO CREDENCIADORA Nº DO CARTÃO PAGAMENTO R$ BRUTO R$ LÍQUIDO"));

		List<String> campos = extratoActions.getcamposTabelaDetalhada();

		assertThat(campos.get(0), equalTo(listaVendasDetalhadas.get(0).getDescricao()));
		assertThat(campos.get(1), equalTo(listaVendasDetalhadas.get(0).getNumTransacao()));
		assertThat(campos.get(2), equalTo(listaVendasDetalhadas.get(0).getNumAutorizacao()));
		assertThat(campos.get(3), equalTo(listaVendasDetalhadas.get(0).getCredenciadora()));
		assertThat(campos.get(4), containsString(listaVendasDetalhadas.get(0).getNumCartao()));
		assertThat(campos.get(4), containsString("REFEIÇÃO"));
		assertThat(campos.get(5), equalTo(listaVendasDetalhadas.get(0).getPagamento()));
		assertThat(campos.get(6), equalTo("R$ " + listaVendasDetalhadas.get(0).getValBruto()));
		assertThat(campos.get(7), equalTo("R$ " + listaVendasDetalhadas.get(0).getValLiquido()));
		
		extratoActions.clicaLinhaOutrasTransacoes(1);
		
		campos = extratoActions.getcamposTabelaOutrasTransacoes();
		
		assertThat(campos.get(0), equalTo("TARIFA DE ANUIDADE\n- R$ 104,00"));
		
	}
}