package br.com.desafio.utils.setupTestes.rest;

import static io.restassured.RestAssured.given;

import br.com.desafio.utils.setupTestes.actions.CommonsActions;
import br.com.desafio.utils.setupTestes.actions.Token;
import io.restassured.response.Response;

public class IGetActions {

	public Response response;

	public Response getComParametroNaUrl(String idPersonUnit, int codigoRetornoEsperado) {
		Token token = CommonsActions.getToken();
		response = given()
				.header("X-IBM-Client-Id", token.getClientId())
				.header("X-IBM-Client-Secret", token.getClientSecret())
				.header("Authorization", token.getTokenType() + " " + token.getAccessToken())
				.when()
				.get("/merchant-dashboard/contracts/" + idPersonUnit + "/status").then().extract().response();

		System.out.println("RETORNO: " + response.getStatusCode());
		return response;
	}

	public Response getIndicadores( String idPersonUnit, String function) {
		Token token = CommonsActions.getToken();
		response = given()
				.header("X-IBM-Client-Id", token.getClientId())
				.header("X-IBM-Client-Secret", token.getClientSecret())
				.header("Authorization", token.getTokenType() + " " + token.getAccessToken())
				.get("/merchant-dashboard/merchants/" + idPersonUnit + "/" + function).then().extract().response();
		System.out.println("RETORNO: " + response.getStatusCode());
		System.out.println("/merchant-dashboard/merchants/" + idPersonUnit + "/" + function);
		return response;
	}

	public Response getDetails( String idPersonUnit) {
		Token token = CommonsActions.getToken();
		response = given()
				.header("X-IBM-Client-Id", token.getClientId())
				.header("X-IBM-Client-Secret", token.getClientSecret())
				.header("Authorization", token.getTokenType() + " " + token.getAccessToken())
				.get("/merchant-dashboard/merchants/" + idPersonUnit + "/details").then().extract().response();
		System.out.println("RETORNO: " + response.getStatusCode());
		return response;
	}

	public Response get(String url, String param) {
		if (param != null) {
			url = url + "/" + param;
		}
		response = given().get(url).then().extract().response();
		System.out.println("RETORNO: " + response.getStatusCode());
		return response;
	}

	public Response getMsg(String url, String param) {
		if (param != null) {
			url = url + "/" + param;
		} else
			response = given().get(url).then().extract().response();
		System.out.println("RETORNO: " + response.getStatusCode());
		return response;
	}

}