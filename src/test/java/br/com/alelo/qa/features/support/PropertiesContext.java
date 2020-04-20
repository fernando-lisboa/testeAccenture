package br.com.alelo.qa.features.support;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
public class PropertiesContext {
	
	@Value("${selenium.screenshotOnFailure}")
	private String screenshotOnFailure;
	
	@Bean("screenshotOnFailure")
	public boolean takeScreenshotOnFailure() {
		return Boolean.parseBoolean(screenshotOnFailure);
	}
	
	@Value("${selenium.screenshotDestinationFolder}")
	private String screenshotDestinationFolder;
	
	@Bean("screenshotDestinationFolder")
	public String getScreenshotDestinationFolder() {
		return screenshotDestinationFolder;
	}
	
	@Value("${selenium.webbrowser}")
	private String webbrowser;
	
	@Bean("webbrowser")
	public String getWebbrowser() {
		return webbrowser;
	}
	
	@Value("${selenium.maxTimeWaitLoadPage}")
	private Long maxTimeWaitLoadPage;
	
	@Bean("maxTimeWaitLoadPage")
	public Long getMaxTimeWaitLoadPage() {
		return maxTimeWaitLoadPage;
	}
	
	@Value("${baseurl}")
	private String baseUrl;

	@Value("${Ambiente}")
	public String Ambiente;

	@Bean("Ambiente")
	public String getAmbiente(){
		return Ambiente;
	}

	@Bean("baseurl")
	public String getBaseUrl(){
		return baseUrl;
	}
	
	@Value("${tags}")
	private String tags;
	
	@Bean("tags")
	public String getTags(){
		return tags;
	}

	@Value("projeto")
	private String projeto;
	
	@Bean("projeto")
	public String getVstsProjeto(){
		return projeto;
	}
	
	@Value("planid")
	private String planid;
	
	@Bean("planid")
	public String getVstsPlanId(){
		return planid;
	}
	
	@Value("atualizaVsts")
	private String atualizaVsts;
	
	@Bean("atualizaVsts")
	public String getVstsIntegrationActive(){
		return atualizaVsts;
	}
}
