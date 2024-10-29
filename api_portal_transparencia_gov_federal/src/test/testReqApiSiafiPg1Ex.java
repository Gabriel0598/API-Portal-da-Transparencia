package test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Properties;

public class testReqApiSiafiPg1Ex {
    public static void main(String[] args) throws IOException {
        // Properties of connection
        String pathAppProperties = "app.properties";
        Properties appProps = new Properties();
        appProps.load(new FileInputStream(pathAppProperties));

        // API Access Key
        String keyAcess = appProps.getProperty("APIKey");

        // Connection
        String URLSiafiPG1 = "http://api.portaldatransparencia.gov.br/api-de-dados/orgaos-siafi?pagina=1";
        URL url = new URL(URLSiafiPG1);

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Accept", "application/json");
        connection.setRequestProperty("chave-api-dados", keyAcess);

        BufferedReader buffer = new BufferedReader(
                new InputStreamReader(connection.getInputStream()));
        String output;
        while((output = buffer.readLine())!= null){
            System.out.println(output);
        }
        connection.disconnect();
    }
}