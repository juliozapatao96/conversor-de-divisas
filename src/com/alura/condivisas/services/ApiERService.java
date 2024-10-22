package com.alura.condivisas.services;

import com.alura.condivisas.modelos.ApiResponseC;
import com.alura.condivisas.records.PairConversion;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ApiERService {
    private static final String KEY = "e303dda9ee4fa7a1918781b5";
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/";

    private final HttpClient client;
    private final Gson gson;

    // constructor
    public ApiERService(){
        this.client = HttpClient.newHttpClient();
        this.gson =new GsonBuilder()
                .setPrettyPrinting()
                .create();
    }


    // Metodo para convertir divisas - E.g.: https://v6.exchangerate-api.com/v6/YOUR-API-KEY/pair/EUR/GBP/AMOUNT
    public PairConversion convertCurrency(String baseCode, String targetCode, String amount){
        String url = BASE_URL + KEY + "/pair/" + baseCode + "/" + targetCode + "/" + amount;

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String json = response.body();

            PairConversion pairConversion = gson.fromJson(json, PairConversion.class);

            return pairConversion;
        } catch (Exception e) {
            throw new RuntimeException("Ocurrió un error en la conversión.");
        }

    }


    // Método para obtener la lista de códigos de divisas soportados
    public Map<String, String> getSupportedCurrencies() {
        String url = BASE_URL + KEY + "/codes";

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String json = response.body();

            // Extraer el array "supported_codes" del JSON
            ApiResponseC apiResponse = gson.fromJson(json, ApiResponseC.class);

            // Convertir la lista de listas en un Map<String, String> para tener el código y el nombre de la divisa
            Map<String, String> supportedCurrencies = new HashMap<>();
            for (List<String> currency : apiResponse.getSupportedCodes()) {
                supportedCurrencies.put(currency.get(0), currency.get(1)); // currency.get(0) es el código, currency.get(1) es el nombre
            }

            return supportedCurrencies;
        } catch (Exception e) {
            throw new RuntimeException("Error al obtener los códigos de divisas.", e);
        }
    }

}
