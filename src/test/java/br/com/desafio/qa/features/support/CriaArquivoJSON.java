package br.com.desafio.qa.features.support;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CriaArquivoJSON {

    public void CriaArquivoJSON_(int quantidadeCampos, List<String> campos, List<String> valores) {


        int qtd_campos = campos.size();

        try {
            JSONArray array = new JSONArray();
            JSONObject jsonList = new JSONObject();


            JSONObject json;
            try {
                FileReader fileReader = new FileReader(System.getProperty("user.home") + "/Desktop/usuarios.json");
                json = new JSONObject(fileReader);
                System.out.println(json.toString());
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
                System.err.println("Não foi possível ler o arquivo json");
            }

            /*try {
                JSONArray jsonArquivoLeitura = new JSONArray(new FileReader();
                //loop through each object
                for (int i = 0; i < jsonArquivoLeitura.length(); i++) {
                    JSONObject jsonProductObject = jsonArquivoLeitura.getJSONObject(i);
                    jsonList.put("CPF", jsonProductObject.getString("CPF"));
                    jsonList.put("Email", jsonProductObject.getString("Email"));
                    jsonList.put("Senha", jsonProductObject.getString("Senha"));
                }
            } catch (Exception e) {
            }*/

            for (int i = 0; i < qtd_campos; i++) {

                jsonList.put("CPF", valores.get(i));
                i++;
                jsonList.put("Email", valores.get(i));
                i++;
                jsonList.put("Senha", valores.get(i));
                array.put(jsonList);
            }

            try {

                FileWriter writeFile = new FileWriter(System.getProperty("user.home") + "/Desktop/usuarios.json");
                //Escreve no arquivo conteudo do Objeto JSON
                writeFile.write(array.toString());
                writeFile.close();
                //Imprimne na Tela o Objeto JSON para vizualização
                System.out.println(array);
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println("JSONArray: " + array);

        } catch (JSONException e) {
            e.printStackTrace();
        }


    }
}
