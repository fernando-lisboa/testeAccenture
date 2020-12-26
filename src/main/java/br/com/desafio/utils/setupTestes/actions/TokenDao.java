package br.com.desafio.utils.setupTestes.actions;


public class TokenDao {
	public Token getTokenByScenario(String scenario) {

		Token token = new Token();
		/**
		 * app hml
		 */

		 token.setClientId("COLOCAR CLIENT ID PARA AUTENTICAÇÃO NA API CONECT");
		 token.setClientSecret("COLOCAR SECRETID ID PARA AUTENTICAÇÃO NA API CONECT");

		/**
		 * app hml
		 */
		
//		token.setClientId("5ed46877-cfb5-4479-ad45-45d31032b6ce");
//		token.setClientSecret("eA3hE8vR2xC3jS0jK2hD2gN8nI8lK7jQ8xV5hJ5lN5yJ3qU7jC");

		return token;

	}

}
