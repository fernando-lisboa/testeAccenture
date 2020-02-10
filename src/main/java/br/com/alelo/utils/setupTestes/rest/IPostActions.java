package br.com.alelo.utils.setupTestes.rest;

import static io.restassured.RestAssured.given;

import java.util.Random;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.alelo.utils.setupTestes.actions.CommonsActions;
import br.com.alelo.utils.setupTestes.actions.Token;
import br.com.alelo.utils.setupTestes.builder.BuildContratacaoPainel;
import br.com.alelo.utils.setupTestes.param.ParametroPainel;
import io.restassured.response.Response;

public class IPostActions {

	public Response response;
	Random gerador = new Random();

	public void postComParametroNaUrl(String idPersonUnit, String status) throws JsonProcessingException {

		ParametroPainel param = new BuildContratacaoPainel().contratacaoCancelamento(idPersonUnit, status);
		ObjectMapper objJSON = new ObjectMapper();

		String jsonBody = objJSON.writeValueAsString(param);

		Token token = CommonsActions.getToken();
		Response response = given().log().all()
				.body(jsonBody)
				.header("X-IBM-Client-Id", token.getClientId())
				.header("X-IBM-Client-Secret", token.getClientSecret())
				.header("Authorization", token.getTokenType() + " " + token.getAccessToken())
				.header("content-type", "application/json").when()
				.post("/merchant-dashboard/contracts/" + idPersonUnit + "/status")
				.then().extract().response();
	}

	public Response post(String idPersonaUnit, String status) throws JsonProcessingException {

		ObjectMapper objJSON = new ObjectMapper();

		String jsonBody = objJSON.writeValueAsString("TODO inserir o objeto para post");
		Token token = CommonsActions.getToken();
		response = given().log().all()
				.body(jsonBody)
				.header("X-IBM-Client-Id", token.getClientId())
				.header("X-IBM-Client-Secret", token.getClientSecret())
				.header("Authorization", token.getTokenType() + " " + token.getAccessToken())
				.header("content-type", "application/json").when().post("/bank-loans/simulations");

		return response;
	}

}
