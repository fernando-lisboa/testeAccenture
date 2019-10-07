package br.com.alelo.qa.web.actions;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import br.com.alelo.qa.utils.GeraCpfCnpj;
import br.com.alelo.qa.web.page.CadastroNovoColaboradorPage;

public class CadastroNovoColaboradorActions extends CadastroNovoColaboradorPage {
	
	
	private void verificaFormularioCarregou(){

		waitForElementPageToLoad(cmpDataNascimentoNovoColaborador);
		waitForElementPageToLoad(cmpCpfNovoColaborador);
		waitForElementPageToLoad(cmpNomeNovoColaborador);
		waitForElementPageToBeClickable(cmpCpfNovoColaborador);
		waitForElementPageToBeClickable(cmpNomeNovoColaborador);
		waitForElementPageToBeClickable(cmpDataNascimentoNovoColaborador);
	}
	
	public void cadastrarNovoColaborador() {
		//Para gerar CPF Valido
		GeraCpfCnpj cpf = new GeraCpfCnpj();
		//Gerar data de Aniversario
		Calendar data = Calendar.getInstance();
        data.setTime(new Date());
        data.add(Calendar.YEAR, -20);
        String dataFormatada = new SimpleDateFormat("ddMMyyyy").format(data.getTime());
		this.btnNovoColaborador.click();
		verificaFormularioCarregou();
		this.cmpCpfNovoColaborador.clear();
		this.cmpCpfNovoColaborador.click();
		this.cmpCpfNovoColaborador.sendKeys(cpf.cpf(false));
		this.optTipoLocalEntregaPostoDeTrabalhoNovoColaborador.click();
		waitForElementPageToLoad(slcLocalDeEntrega);
		this.slcLocalDeEntrega.click();
		this.optLocalDeEntrega("PT101 :: Teste PT").click();
		this.cmpDataNascimentoNovoColaborador.clear();
		this.cmpDataNascimentoNovoColaborador.click();		
		this.cmpDataNascimentoNovoColaborador.sendKeys(dataFormatada);
		this.cmpNomeNovoColaborador.clear();
		this.cmpNomeNovoColaborador.click();
		this.cmpNomeNovoColaborador.sendKeys("Automação Colaborador"); 
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.btnSalvar.click();
	}

	public CadastroNovoColaboradorActions(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

}
