package br.com.desafio.qa.features.steps;

import org.junit.Assert;

import br.com.desafio.qa.features.support.ParentSteps;
import br.com.desafio.qa.web.actions.InsurantDataActions;
import br.com.desafio.qa.web.actions.ProductDataActions;
import br.com.desafio.qa.web.actions.SelectPriceActions;
import br.com.desafio.qa.web.actions.SendQuoteActions;
import br.com.desafio.qa.web.actions.VechileDataActions;
import br.com.desafio.qa.web.page.InsurantDataPage;
import br.com.desafio.qa.web.page.SendQuotePage;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class VechileInsuranceApplicationStep extends ParentSteps {


	@Given("^I'm on the sampleApp website$")
	public void i_m_on_the_sampleApp_website() throws Throwable {

		webdriver.get(urlInicio);
		Assert.assertTrue("Não abriu a tela inicial conforme esperado",
				webdriver.getCurrentUrl().equals("http://sampleapp.tricentis.com/101/app.php"));
		System.out.println("inicio dos testes");

	}

	@When("^filling out the form of vechile data$")
	public void filling_out_the_form_of_vechile_data() throws Throwable {
		VechileDataActions actionVechile = new VechileDataActions(webdriver);
		actionVechile.fillFieldVechile();

	}

	@When("^filling out the form of insurant data$")
	public void filling_out_the_form_of_insurant_data() throws Throwable {

		InsurantDataActions actionInsurant = new InsurantDataActions(webdriver);
		actionInsurant.fillFieldInsurantData();
			
		}

	@When("^filling out the form of product data$")
	public void filling_out_the_form_of_product_data() throws Throwable {
		
		ProductDataActions actionsProductDada = new ProductDataActions(webdriver);
		actionsProductDada.fullFieldProductData();
	
	}

	@When("^filling out the form of select price options$")
	public void filling_out_the_form_of_select_price_options() throws Throwable {
		
		SelectPriceActions selectAction = new SelectPriceActions(webdriver);
		selectAction.fillFildSelectPriceOption();
		
		
	}

	@When("^filling out the form of send quotes \"([^\"]*)\", \"([^\"]*)\"$")
	public void filling_out_the_form_of_send_quotes(String user, String password) throws Throwable {

		SendQuoteActions sendQuoteActions = new SendQuoteActions(webdriver);
		sendQuoteActions.fillFiledSendQuote(user, password);
		
		
	}

	@Then("^I must validate the message of success$")
	public void i_must_validate_the_message_of_success() throws Throwable {

		SendQuoteActions sendQuoteActions = new SendQuoteActions(webdriver);
		sendQuoteActions.validationMessegeSuccess();
	}

}
