package br.com.alelo.utils.setupTestes.actions;

public class Token {
	
	private String clientId;
	private String clientSecret;
	private static String accept = "application/json";
	private static String contentType = "application/x-www-form-urlencoded";
	private static String aPImDebug = "true";
	private static String grantType = "password";
	private static String scope = "/Customers.Merchants.Accredited";
	private static String username = "54621917072";
	private static String password = "Alelo2018@";
	//private static String username = "12479971899";
	//private static String password = "Dani2020@";
	private String tokenType = "Bearer";
	private String accessToken;
	
	
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public String getClientSecret() {
		return clientSecret;
	}
	public static String getAccept() {
		return accept;
	}
	public static String getContentType() {
		return contentType;
	}
	public static String getaPImDebug() {
		return aPImDebug;
	}
	public static String getGrantType() {
		return grantType;
	}
	public static String getScope() {
		return scope;
	}
	public static String getUsername() {
		return username;
	}
	public static String getPassword() {
		return password;
	}
	public void setClientSecret(String clientSecret) {
		this.clientSecret = clientSecret;
	}
	
	public String getTokenType() {
		return tokenType;
	}
	public void setTokenType(String tokenType) {
		this.tokenType = tokenType;
	}
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	
	public String getBodyRequest(){
		return "grant_type="+this.grantType
				+"&client_id="+this.clientId
				+"&client_secret="+this.clientSecret
				+"&scope="+this.scope
				+"&username="+this.username 
				+"&password=" + this.password;
	}
	

}
