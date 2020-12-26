package br.com.desafio.utils.setupTestes.actions;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import br.com.desafio.utils.PropertiesFile;
import io.restassured.response.Response;

public class TokenActions {
	private Token token = null;

	public Token gerarTokenDeAcesso(String cenario) {

		TokenDao tokenDao = new TokenDao();
		Token token = tokenDao.getTokenByScenario(cenario);

		Response response = given().log().all().header("Accept", Token.getAccept())
				.header("Content-Type", Token.getContentType()).header("APIm-Debug", Token.getaPImDebug())
				.body(token.getBodyRequest()).when().post("mga/sps/oauth/oauth20/token").then().statusCode(200)
				.extract().response();
		response.prettyPrint();
		token.setTokenType("Bearer");
		// token.setTokenType(response.path("token_type"));
		token.setAccessToken(response.path("access_token"));
		// token.setExpiresIn(response.path("expires_in").);
		// token.setConsentedOn(response.path("consented_on"));
		return token;
	}

	public void setToken(String cenario) {
		TokenDao tokenDao = new TokenDao();
		token = tokenDao.getTokenByScenario(cenario);
		PropertiesFile props;
		try {
			props = new PropertiesFile();
			Response response = given().log().all().header("Accept", Token.getAccept())
					.header("Content-Type", Token.getContentType()).header("APIm-Debug", Token.getaPImDebug())
					.body(token.getBodyRequest()).when()
					.post(props.getValor("baseIsam") + "mga/sps/oauth/oauth20/token").then().statusCode(200).extract()
					.response();
			response.prettyPrint();
			token.setTokenType("Bearer");
			// token.setTokenType(response.path("token_type"));
			token.setAccessToken(response.path("access_token"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// token.setExpiresIn(response.path("expires_in").);
		// token.setConsentedOn(response.path("consented_on"));
	}

	public Token getToken() {
		return token;
	}
}
