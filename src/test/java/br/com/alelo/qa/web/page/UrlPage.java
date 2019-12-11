package br.com.alelo.qa.web.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import br.com.alelo.qa.web.support.PageObject;

public class UrlPage extends PageObject{
	
	String url_entrada = "http://meuestabelecimento-hml.siteteste.inf.br/login";
	String url_inicio_webAdmin = "http://meuestabelecimento-webadmin-hml.siteteste.inf.br/portalec-webadmin/login";
	String url_inicio_webAdmin_validate = 	"http://meuestabelecimento-webadmin-hml.siteteste.inf.br/portalec-webadmin/offers/campanha";
	String url_inicio =	"http://meuestabelecimento-hml.siteteste.inf.br/inicio";
	String url_logout =	"http://meuestabelecimento-hml.siteteste.inf.br/login";
	String url_agenda =	"http://meuestabelecimento-hml.siteteste.inf.br/agenda";
	String url_agenda_resumo =	"http://meuestabelecimento-hml.siteteste.inf.br/agenda/resumo";
	String url_extrato =	"http://meuestabelecimento-hml.siteteste.inf.br/extrato";
	String url_configuracoes =	"http://meuestabelecimento-hml.siteteste.inf.br/configuracoes";
	String url_inicial_credenciamento =	"http://meuestabelecimento-frontend-accreditation-hml.siteteste.inf.br/productData";
	String url_inicial =	"http://meuestabelecimento-hml.siteteste.inf.br/login";

	
	
	
	public String getUrl_entrada() {
		return url_entrada;
	}

	public void setUrl_entrada(String url_entrada) {
		this.url_entrada = url_entrada;
	}

	public String getUrl_inicio_webAdmin() {
		return url_inicio_webAdmin;
	}

	public void setUrl_inicio_webAdmin(String url_inicio_webAdmin) {
		this.url_inicio_webAdmin = url_inicio_webAdmin;
	}

	public String getUrl_inicio_webAdmin_validate() {
		return url_inicio_webAdmin_validate;
	}

	public void setUrl_inicio_webAdmin_validate(String url_inicio_webAdmin_validate) {
		this.url_inicio_webAdmin_validate = url_inicio_webAdmin_validate;
	}

	public String getUrl_inicio() {
		return url_inicio;
	}

	public void setUrl_inicio(String url_inicio) {
		this.url_inicio = url_inicio;
	}

	public String getUrl_logout() {
		return url_logout;
	}

	public void setUrl_logout(String url_logout) {
		this.url_logout = url_logout;
	}

	public String getUrl_agenda() {
		return url_agenda;
	}

	public void setUrl_agenda(String url_agenda) {
		this.url_agenda = url_agenda;
	}

	public String getUrl_agenda_resumo() {
		return url_agenda_resumo;
	}

	public void setUrl_agenda_resumo(String url_agenda_resumo) {
		this.url_agenda_resumo = url_agenda_resumo;
	}

	public String getUrl_extrato() {
		return url_extrato;
	}

	public void setUrl_extrato(String url_extrato) {
		this.url_extrato = url_extrato;
	}

	public String getUrl_configuracoes() {
		return url_configuracoes;
	}

	public void setUrl_configuracoes(String url_configuracoes) {
		this.url_configuracoes = url_configuracoes;
	}

	public String getUrl_inicial_credenciamento() {
		return url_inicial_credenciamento;
	}

	public void setUrl_inicial_credenciamento(String url_inicial_credenciamento) {
		this.url_inicial_credenciamento = url_inicial_credenciamento;
	}

	public String getUrl_inicial() {
		return url_inicial;
	}

	public void setUrl_inicial(String url_inicial) {
		this.url_inicial = url_inicial;
	}



	public UrlPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

}
