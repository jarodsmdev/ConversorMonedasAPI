package model;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.internal.bind.util.ISO8601Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Properties;

public class ConsultaAPI {



    private static final String URL_API = "https://v6.exchangerate-api.com/v6/";
    private String API_KEY = "";


    public void consultar(double amountBase, String currencyBase, String currencyTarget) throws IOException, InterruptedException {

        // Cargar el archivo config.properties
        Properties props = new Properties();
        FileInputStream fis = new FileInputStream("src/config.properties");
        props.load(fis);
        fis.close();

        // Obtener el valor de la variable EXCHANGE_RATE_API_KEY
        String API_KEY = props.getProperty("EXCHANGE_RATE_API_KEY");

        if (API_KEY == null){
            System.err.println("API key not found. Set the EXCHANGE_RATE_API_KEY environment variable.");
            return;
        }

        String url = URL_API + API_KEY + "/pair/" + currencyBase + "/" + currencyTarget;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        String json = response.body();

        // Muestra la respuesta del JSON
        //System.out.println(json);

        // Convertir el JSON a un objeto ExchangeRateDTO
        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();

        ExchangeRateDTO exchangeDto = gson.fromJson(json, ExchangeRateDTO.class);

        // Crear un objeto ConversionRate a partir del ExchangeRateDTO
        ConversionRate conversionRate = new ConversionRate(
                exchangeDto.baseCode(),
                exchangeDto.targetCode(),
                exchangeDto.conversionRate()
        );

        conversionRate.convertTo(amountBase);
        //System.out.println(conversionRate.toString());
        System.out.print(conversionRate.getResponse());
    }
}
