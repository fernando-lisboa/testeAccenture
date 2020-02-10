package br.com.alelo.utils.setupTestes.actions;


public class TokenDao {
	public Token getTokenByScenario(String scenario) {

		Token token = new Token();
		/**
		 * app hml
		 */

		 token.setClientId("af0f425d-d1b5-45a8-bcaf-2f7f700b186c");
		 token.setClientSecret("J3rO1kU4jT7hA2eS8xX4mC4qY7kV1oH6nG7yH8cA3jI1pJ3jY8");

		/**
		 * app hml
		 */
		
//		token.setClientId("5ed46877-cfb5-4479-ad45-45d31032b6ce");
//		token.setClientSecret("eA3hE8vR2xC3jS0jK2hD2gN8nI8lK7jQ8xV5hJ5lN5yJ3qU7jC");

		return token;

	}

}
