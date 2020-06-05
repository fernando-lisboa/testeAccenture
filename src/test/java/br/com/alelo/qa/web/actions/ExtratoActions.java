 /**
 * 
 */
package br.com.alelo.qa.web.actions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import br.com.alelo.qa.features.support.JavaScriptUtils;
import br.com.alelo.qa.features.support.JavaScriptUtils.Funcao;
import br.com.alelo.qa.web.page.ExtratoPage;

/**
 * @author Lucas Martins
 *
 */
public class ExtratoActions extends ExtratoPage {

	private String winHandleBefore;

	public ExtratoActions(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public boolean pageSourceContainsText(String text) {
		boolean isPresent = webdriver.getPageSource().contains(text);
		return isPresent;
	}

	public void TratamentoData(String dataInicioMass, String dataFimMass) throws InterruptedException
	{
		try{			
		JavaScriptUtils js = new JavaScriptUtils(webdriver);
		
		Thread.sleep(3000);
		
		String[] dataInicioMassSplit = dataInicioMass.split("/"); // Separa mes do ano
		String[] dataFimMassSplit = dataFimMass.split("/"); // Separa mes do ano
		
		int Ano = 0;
		int Mes = 0;
		int Dia = 0;
		
		String[] diaMesAno_ = null;
		
		for(int x = 0; x < 2; x++) // x = 0 [dataInicio] || x = 1 [dataFim] 
		{
			js.JavaScriptAction(Funcao.click, null, null, webdriver.findElements(By.id("datetimmecustom")).get(x));
			
			VerificaObjetoExistente(By.id("datetimmecustomDiv"), null, null, 40);
			if(x == 0)
				diaMesAno_ = dataInicioMassSplit;
			else 
				diaMesAno_ = dataFimMassSplit;
			
			
			//Mes e Ano do calendário
			WebElement mesAnoCalendario_ = webdriver.findElements(By.id("datetimmecustomDiv")).get(x).findElement(By.xpath("//div/div/div/table/thead/tr[1]/th[2]"));
			String mesAnoCalendario = mesAnoCalendario_.getText();
			//Separa mes do ano
			String[] mesAno = mesAnoCalendario.split(" ");
			
			//Ano do calendario
			String Ano_ = mesAno[1]; 
			Ano = Integer.parseInt(Ano_);
			
			//Mes do calendário
			String Mes_ = mesAno[0];
			
			switch(Mes_.toUpperCase().trim())
			{
			case "JANEIRO":
				Mes = 1;
				break;
			case "FEVEREIRO":
				Mes = 2;
				break;
			case "MARÇO":
				Mes = 3;
				break;
			case "ABRIL":
				Mes = 4;
				break;
			case "MAIO":
				Mes = 5;
				break;
			case "JUNHO":
				Mes = 6;
				break;
			case "JULHO":
				Mes = 7;
				break;
			case "AGOSTO":
				Mes = 8;
				break;
			case "SETEMBRO":
				Mes = 9;
				break;
			case "OUTUBRO":
				Mes = 10;
				break;
			case "NOVEMBRO":
				Mes = 11;
				break;
			case "DEZEMBRO":
				Mes = 12;
				break;
			}
							
			//Ano do Calendario Massa
			
			String stringanocalendario = diaMesAno_[2];
			int CalendarioMassaAno = Integer.parseInt(stringanocalendario.trim().replace("\"", ""));
			
			//Mes do Calendario Massa
			String stringmescalendario = diaMesAno_[1];
			int CalendarioMassaMes = Integer.parseInt(stringmescalendario.trim().replace("\"", ""));
			
			//Dia do Calendario Massa
			String CalendarioMassaDia = diaMesAno_[0].trim().replace("\"", "");
			
			WebElement rightArrow = webdriver.findElements(By.id("datetimmecustomDiv")).get(x).findElement(By.xpath("//div/div/div/table/thead/tr[1]/th[1]/span"));
			WebElement leftArrow = webdriver.findElements(By.id("datetimmecustomDiv")).get(x).findElement(By.xpath("//div/div/div/table/thead/tr[1]/th[3]/span"));
									
		//Tratamento para seleção do Ano
		while(Ano != CalendarioMassaAno)
		{			
			if(Ano < CalendarioMassaAno)
			{
				js.JavaScriptAction(Funcao.click, null, null, leftArrow);
				Thread.sleep(300);
			}
			else
			{
				js.JavaScriptAction(Funcao.click, null, null, rightArrow);
				Thread.sleep(300);
			}
			//Mes e Ano do calendário
			mesAnoCalendario_ = webdriver.findElements(By.id("datetimmecustomDiv")).get(x).findElement(By.xpath("//div/div/div/table/thead/tr[1]/th[2]"));
			mesAnoCalendario = mesAnoCalendario_.getText();
			//Separa mes do ano
			mesAno = mesAnoCalendario.split(" ");
			
			//Ano do calendario
			Ano_ = mesAno[1]; 
			Ano = Integer.parseInt(Ano_);
		}
		
		//Tratamento para seleção do Mês
		while(Mes != CalendarioMassaMes)
		{	
			if(Mes < CalendarioMassaMes)
			{				
				js.JavaScriptAction(Funcao.click, null, null, rightArrow);
				Thread.sleep(300);
			}
			else
			{
				
				js.JavaScriptAction(Funcao.click, null, null, leftArrow);
				Thread.sleep(300);
			}
			//Mes e Ano do calendário
			mesAnoCalendario_ = webdriver.findElements(By.id("datetimmecustomDiv")).get(x).findElement(By.xpath("//div/div/div/table/thead/tr[1]/th[2]"));
			mesAnoCalendario = mesAnoCalendario_.getText();
			//Separa mes do ano
			mesAno = mesAnoCalendario.split(" ");
			
			//Mes do calendário
			Mes_ = mesAno[0];
			
			switch(Mes_.toUpperCase().trim())
			{
			case "JANEIRO":
				Mes = 1;
				break;
			case "FEVEREIRO":
				Mes = 2;
				break;
			case "MARÇO":
				Mes = 3;
				break;
			case "ABRIL":
				Mes = 4;
				break;
			case "MAIO":
				Mes = 5;
				break;
			case "JUNHO":
				Mes = 6;
				break;
			case "JULHO":
				Mes = 7;
				break;
			case "AGOSTO":
				Mes = 8;
				break;
			case "SETEMBRO":
				Mes = 9;
				break;
			case "OUTUBRO":
				Mes = 10;
				break;
			case "NOVEMBRO":
				Mes = 11;
				break;
			case "DEZEMBRO":
				Mes = 12;
				break;
			}
		}
		
		//dia do calendário
		List<WebElement> ListaDia_ = webdriver.findElements(By.id("datetimmecustomDiv")).get(x).findElements(By.tagName("td")); //todos os dias displayed
		List<WebElement> ListDiasMes_ = new ArrayList<WebElement>(); // dias reais do mes
		//rdtDay rdtNew || rdtDay rdtOld
		for(WebElement dia : ListaDia_)		
			if(!dia.getAttribute("class").contains("rdtOld") || !dia.getAttribute("class").contains("rdtNew"))
				ListDiasMes_.add(dia);
		
		
		for(WebElement dia_Selecao : ListDiasMes_)
		if(dia_Selecao.getText().equals(CalendarioMassaDia))
			js.JavaScriptAction(Funcao.click, null, null, dia_Selecao);
		
		}
		}catch(Exception e){
			Thread.sleep(1000);
		}
		
		
				
	}
	public String getTextoVendasDia() {
		return this.vendasDia.getText();
	}

	public String getTextoAlerta() {
		return webdriver.switchTo().alert().getText();
	}

	public void clicabotaoOKAlerta() {
		webdriver.switchTo().alert().accept();
	}

	public String getTextoValorTotalExtrato() {
		return this.valorTotalExtrato.getText();
	}

	public void clicaLinkVendasDia() throws InterruptedException {
		linkVendasDia.click();
	}

	public void clicaBotaoGerarExtrato() throws InterruptedException {
		bntGerarExtrato.click();
		Thread.sleep(5000);
	}

	public void clicaBotaoExportar() {
		bntExportar.click();
	}

	public void clicaBotaoExportarPDF() throws InterruptedException {
		bntPDF.click();
		Thread.sleep(3000);
	}

	public void clicaBotaoExportarCSV() throws InterruptedException {
		bntCSV.click();
		Thread.sleep(3000);
	}

	public void clicaBotaoImprimir() throws InterruptedException {
		bntImprimir.click();
		Thread.sleep(3000);
	}

	public boolean isBotaoModalImprimirDisplayed() {
		return bntModalImprimir.get(1).isDisplayed();
	}

	public boolean isBotaoModalImprimirFecharSuperiorDisplayed() {
		return bntModalFecharSuperior.isDisplayed();
	}

	public boolean isBotaoModalImprimirFecharInferiorDisplayed() {
		return bntModalFecharInferior.isDisplayed();
	}

	public void clicaBotaoExportarInferiorPDF() throws InterruptedException {
		bntInferiorPDF.click();
		Thread.sleep(3000);
	}

	public void clicaBotaoExportarInferiorCSV() throws InterruptedException {
		bntInferiorCSV.click();
		Thread.sleep(3000);
	}

	public void clicaBotaoImprimirInferior() {
		bntInferiorImprimir.click();
	}

	public List<String> getConteudoModalImprimir() {

		List<String> listaConteudo = new ArrayList<>();

		for (WebElement linha : cabecalhoConteudoModalImprimir) {
			listaConteudo.add(linha.getText());
		}

		for (WebElement linha : conteudoModalImprimir) {
			listaConteudo.add(linha.getText());
		}

		return listaConteudo;

	}

	public String getCabecalhoRelatorio() {
		return this.cabecalhoRel.getText();
	}

	public String getCorpoRelatorio(int linha) {
		return this.corpoRel.get(linha).getText();
	}

	public String getCabecalhoTabelaDetalhada() {
		return cabecalhoTabelaDetalhada.getText();
	}

	public List<String> getcamposTabelaDetalhada() {

		List<String> camposTabelaDetalhada = new ArrayList<>();

		for (WebElement campo : this.camposTabelaDetalhada) {
			camposTabelaDetalhada.add(campo.getText());
		}

		return camposTabelaDetalhada;
	}

	public List<String> getColDataRelatorio() {

		List<String> colDataRelatorio = new ArrayList<>();

		for (WebElement campo : listColDataRelatorio) {

			colDataRelatorio.add(campo.getText());

		}
		return colDataRelatorio;

	}

	public void selecionaDataCalendarioAnterior(String startDay, String startMonth, String startYear, String endDay,
			String endMonth, String endYear) throws InterruptedException {

		Thread.sleep(2000);

		clicaBtnStartDataCalendario();

		boolean notFoundYearMonth = true;

		List<WebElement> bntCalendario = webdriver.findElements(By.xpath(
				"//*[contains(@class, 'DayPickerNavigation_svg__horizontal DayPickerNavigation_svg__horizontal_1')]"));
		WebElement bntEsquerda = bntCalendario.get(0);
		WebElement bntDireita = bntCalendario.get(1);

		bntDireita.click();

		while (notFoundYearMonth) {

			Thread.sleep(1000);

			List<WebElement> calendarios = webdriver
					.findElements(By.xpath("//*[contains(@class, 'CalendarMonth_caption CalendarMonth_caption_1')]"));

			WebElement calendarioEsquerda = calendarios.get(1);

			String dataEsquerda = calendarioEsquerda.getText();

			String anoEsquerda = dataEsquerda.split(" ")[1];
			String mesEsquerda = dataEsquerda.split(" ")[0];

			if (anoEsquerda.contains(startYear)) {
				if (mesEsquerda.contains(startMonth)) {

					List<WebElement> days = calendarioEsquerda.findElements(By.xpath(
							"//*[contains(@class, 'CalendarDay CalendarDay_1 CalendarDay__default CalendarDay__default_2')]"));

					days.stream().filter(d -> d.getText().equals(startDay)).findFirst().get().click();

					notFoundYearMonth = false;

				} else {
					Thread.sleep(1000);
					bntEsquerda.click();
					Thread.sleep(1000);

				}
			} else {
				Thread.sleep(1000);
				bntEsquerda.click();
				Thread.sleep(1000);
			}
		}

		notFoundYearMonth = true;
		Thread.sleep(1000);

		while (notFoundYearMonth) {

			List<WebElement> calendarios = webdriver
					.findElements(By.xpath("//*[contains(@class, 'CalendarMonth_caption CalendarMonth_caption_1')]"));

			WebElement calendarioEsquerda = calendarios.get(1);

			String dataEsquerda = calendarioEsquerda.getText();

			String anoEsquerda = dataEsquerda.split(" ")[1];
			String mesEsquerda = dataEsquerda.split(" ")[0];

			if (anoEsquerda.contains(endYear)) {
				if (mesEsquerda.contains(endMonth)) {

					List<WebElement> days = calendarioEsquerda.findElements(By.xpath(
							"//*[contains(@class, 'CalendarDay CalendarDay_1 CalendarDay__default CalendarDay__default_2')]"));

					days.stream().filter(d -> d.getText().equals(endDay)).findFirst().get().click();

					notFoundYearMonth = false;

				} else {
					Thread.sleep(1000);
					bntDireita.click();
					Thread.sleep(1000);

				}
			} else {
				Thread.sleep(1000);
				bntDireita.click();
				Thread.sleep(1000);
			}
		}

		buttonOk.click();

	}

	public void selecionaDataCalendarioExportar(String startDay, String startMonth, String startYear, String endDay,
			String endMonth, String endYear) throws InterruptedException {

		Thread.sleep(2000);

		boolean notFoundYearMonth = true;

		List<WebElement> bntCalendario = webdriver.findElements(By.xpath(
				"//*[contains(@class, 'DayPickerNavigation_svg__horizontal DayPickerNavigation_svg__horizontal_1')]"));
		WebElement bntEsquerda = bntCalendario.get(0);
		WebElement bntDireita = bntCalendario.get(1);

		bntDireita.click();

		while (notFoundYearMonth) {

			Thread.sleep(1000);

			List<WebElement> calendarios = webdriver
					.findElements(By.xpath("//*[contains(@class, 'CalendarMonth_caption CalendarMonth_caption_1')]"));

			WebElement calendarioEsquerda = calendarios.get(1);

			String dataEsquerda = calendarioEsquerda.getText();

			String anoEsquerda = dataEsquerda.split(" ")[1];
			String mesEsquerda = dataEsquerda.split(" ")[0];

			if (anoEsquerda.contains(startYear)) {
				if (mesEsquerda.contains(startMonth)) {

					List<WebElement> days = calendarioEsquerda.findElements(By.xpath(
							"//*[contains(@class, 'CalendarDay CalendarDay_1 CalendarDay__default CalendarDay__default_2')]"));

					days.stream().filter(d -> d.getText().equals(startDay)).findFirst().get().click();

					notFoundYearMonth = false;

				} else {
					Thread.sleep(1000);
					bntEsquerda.click();
					Thread.sleep(1000);

				}
			} else {
				Thread.sleep(1000);
				bntEsquerda.click();
				Thread.sleep(1000);
			}
		}

		notFoundYearMonth = true;
		Thread.sleep(1000);

		while (notFoundYearMonth) {

			List<WebElement> calendarios = webdriver
					.findElements(By.xpath("//*[contains(@class, 'CalendarMonth_caption CalendarMonth_caption_1')]"));

			WebElement calendarioEsquerda = calendarios.get(1);

			String dataEsquerda = calendarioEsquerda.getText();

			String anoEsquerda = dataEsquerda.split(" ")[1];
			String mesEsquerda = dataEsquerda.split(" ")[0];

			if (anoEsquerda.contains(endYear)) {
				if (mesEsquerda.contains(endMonth)) {

					List<WebElement> days = calendarioEsquerda.findElements(By.xpath(
							"//*[contains(@class, 'CalendarDay CalendarDay_1 CalendarDay__default CalendarDay__default_2')]"));

					days.stream().filter(d -> d.getText().equals(endDay)).findFirst().get().click();

					notFoundYearMonth = false;

				} else {
					Thread.sleep(1000);
					bntDireita.click();
					Thread.sleep(1000);

				}
			} else {
				Thread.sleep(1000);
				bntDireita.click();
				Thread.sleep(1000);
			}
		}

	}

	public List<String> getColTransRelatorio() {

		List<String> colTransRelatorio = new ArrayList<>();

		for (WebElement campo : listColTransRelatorio) {

			colTransRelatorio.add(campo.getText());

		}

		return colTransRelatorio;
	}

	public void clicaLinhaSumarizada(int numLinha) {

		numLinha = numLinha - 1;

		listLinhaSumarizada.get(numLinha).click();

	}

	public void clicaLinhaOutrasTransacoes(int numLinha) {

		numLinha = numLinha - 1;

		listLinhaOutrasTransacoes.get(numLinha).click();

	}

	public List<String> getcamposTabelaOutrasTransacoes() {

		List<String> linhaOutrasTransacoes = new ArrayList<>();

		for (WebElement campo : camposTabelaOutrasTransacoes) {

			linhaOutrasTransacoes.add(campo.getText());

		}

		return linhaOutrasTransacoes;

	}

	public String getTextoCabecalhoTabelaDetalheTransacao() {

		return cabecalhoTabelaDetalheTransacao.getText();
	}

	public List<String> getLinhaTransDetalhada() {

		List<String> linhaTransDetalhada = new ArrayList<>();

		for (WebElement campo : listLinhaDetalheTransacao) {

			linhaTransDetalhada.add(campo.getText());

		}

		return linhaTransDetalhada;
	}

	private void clicaBtnStartDataCalendario() {
		bntStartDataCalendario.click();
	}

	public void clicaBntInteresse() {

		if (bntInteresse != null) {

			bntInteresse.click();

			bntFechaModalInteresse.click();

		}
	}

}
