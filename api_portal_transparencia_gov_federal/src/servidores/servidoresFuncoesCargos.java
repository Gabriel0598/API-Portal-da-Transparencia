package servidores;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Properties;

public class servidoresFuncoesCargos {
    public static void main(String[] args) throws IOException {
        // Properties of connection
        String pathAppProperties = "app.properties";
        Properties appProps = new Properties();
        appProps.load(new FileInputStream(pathAppProperties));

        // API Access Key
        String keyAPI = appProps.getProperty("APIKey");

        // Connection
        String URLServidoresCargosFuncoes = "https://api.portaldatransparencia.gov.br/api-de-dados/servidores/funcoes-e-cargos?pagina=1";
        URL url = new URL(URLServidoresCargosFuncoes);

        // Invoke get method
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Accept", "application/json");
        connection.setRequestProperty("chave-api-dados", keyAPI);

        // Output buffered
        BufferedReader buffer = new BufferedReader(
                new InputStreamReader(connection.getInputStream())
        );
        String output;
        while ((output = buffer.readLine()) != null){
            System.out.println(output);
        }
        connection.disconnect();
    }
}
