package com.example;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import io.github.cdimascio.dotenv.Dotenv;

public class StockDataFetcher {
    
    static final Dotenv dotenv = Dotenv.load();
    private static final String API_KEY = dotenv.get("API_KEY"); 

    public static String fetchStocks(String stock){
        
        String urlString = "https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol=" + stock + "&outputsize=compact&apikey=" + API_KEY;
        
        try{
            URI uri = new URI(urlString);
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .GET()
                .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            return response.body();
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
