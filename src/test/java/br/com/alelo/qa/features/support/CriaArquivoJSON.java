package br.com.alelo.qa.features.support;

import org.json.JSONObject;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CriaArquivoJSON {

    @SuppressWarnings("unchecked")
    public void CriaArquivoJSON_(int quantidadeCampos, List<String> campos, List<String> valores) {


        int qtd_campos = campos.size();

        try {
            JSONArray array = new JSONArray();

            for(int i = 0; i < qtd_campos; i++) {

                    JSONObject jsonList = new JSONObject();

                    jsonList.put("CPF", valores.get(i));i++;
                    jsonList.put("Email", valores.get(i));i++;
                    jsonList.put("Senha", valores.get(i));
                    array.put(jsonList);
                }

            try{
                FileWriter writeFile = new FileWriter(System.getProperty("user.home") + "/Desktop/usuarios.json");
                //Escreve no arquivo conteudo do Objeto JSON
                writeFile.write(array.toString());
                writeFile.close();
                //Imprimne na Tela o Objeto JSON para vizualização
                System.out.println(array);
            }
            catch(IOException e){
                e.printStackTrace();
            }

            System.out.println("JSONArray: " + array);

        } catch (JSONException e) {
            e.printStackTrace();
        }







    }
}
