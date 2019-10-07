package br.com.alelo.integrations.vsts.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import br.com.alelo.integrations.vsts.entities.Vsts;

public class VstsController {

	Vsts vsts = new Vsts();
	JsonObject jsonObject = null;
	HttpURLConnection conection = null;
	
	
	public String sendGetRequest(String path){
		String json = null;
		URL url;
		try {
			url = new URL(path);
			try {
				conection = (HttpURLConnection) url.openConnection();
				
				conection.setRequestMethod("GET");
				
				conection.setRequestProperty("Content-Type", "application/json");
				conection.setRequestProperty("Authorization", vsts.getAuthorization());
				
				conection.setDoOutput(true);
				conection.setUseCaches(false);
				conection.setDoInput(true);

				BufferedReader in = new BufferedReader(new InputStreamReader(conection.getInputStream()));
				String inputLine;
				StringBuffer response = new StringBuffer();
				while ((inputLine = in.readLine()) != null) {
					response.append(inputLine);
				}
				in.close();
				conection.disconnect();
				return json = response.toString();
				
				//jsonObject = gson.fromJson(response.toString(), JsonObject.class);
			
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
			
		return json;
		
	}

	public JsonObject sendRequest(String method, String path, byte[] body) throws MalformedURLException {
		
		URL url = new URL(path + vsts.getApiVersion());
		try {
			conection = (HttpURLConnection) url.openConnection();
			if(method.equals("PATCH")){
				conection.setRequestProperty("X-HTTP-Method-Override", "PATCH");
				conection.setRequestMethod("POST");
			}else{
				conection.setRequestMethod(method);
			}
			//conection.se
			conection.setRequestProperty("Content-Type", "application/json");
			conection.setRequestProperty("Authorization", vsts.getAuthorization());
			
			conection.setDoOutput(true);
			conection.setUseCaches(false);
			conection.setDoInput(true);
			OutputStream os = conection.getOutputStream();
			os.write(body);
			os.flush();
			os.close();

			BufferedReader in = new BufferedReader(new InputStreamReader(conection.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			// print result
			Gson gson = new Gson();
			System.out.println(response.toString());
			jsonObject = gson.fromJson(response.toString(), JsonObject.class);
			conection.disconnect();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return jsonObject;

	}
	
	
	
	

}
