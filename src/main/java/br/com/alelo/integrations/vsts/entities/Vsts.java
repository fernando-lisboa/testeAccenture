package br.com.alelo.integrations.vsts.entities;

public class Vsts {
	
	private String url_base = "https://alelo.visualstudio.com/";
	private String projeto;
	private String pathbase = "/_apis/test/";
	private String apiVersion = "?api-version=5.1";
	private String authorization =  "Basic OnJzd3dxN3MzaWZjMmRuZ2lxdnAzb3c3Z2Q3b3c3dXRzZ2hvaG8zcW1oejR2b3FqM3FtbWE=";
	
	public String getUrl_base() {
		return url_base;
	}
	public void setUrl_base(String url_base) {
		this.url_base = url_base;
	}
	public String getProjeto() {
		return projeto;
	}
	public void setProjeto(String projeto) {
		this.projeto = projeto;
	}
	public String getPathbase() {
		return pathbase;
	}
	public void setPathbase(String pathbase) {
		this.pathbase = pathbase;
	}
	public String getApiVersion() {
		return apiVersion;
	}
	public void setApiVersion(String apiVersion) {
		this.apiVersion = apiVersion;
	}
	public String getAuthorization() {
		return authorization;
	}
	public void setAuthorization(String authorization) {
		this.authorization = authorization;
	}
	
	

}
