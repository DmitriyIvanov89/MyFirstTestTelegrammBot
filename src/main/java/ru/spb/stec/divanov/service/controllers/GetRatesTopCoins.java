package ru.spb.stec.divanov.service.controllers;

import com.google.gson.JsonElement;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class GetRatesTopCoins {
    private static final String address = "https://min-api.cryptocompare.com/data/pricemulti";
    private static final String API_KEY = "***";
    private GetTopListCoinsController getTopListCoinsController;

    public String getTopCoinsRates() {
        getTopListCoinsController = new GetTopListCoinsController();
        List<JsonElement> topListCoins = getTopListCoinsController.getTopListCoins();

        StringBuilder response = new StringBuilder();

        try {
            URL url = new URL(address);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("X-CMC_PRO_API_KEY", API_KEY);
            connection.setRequestProperty("Content-Type", "application/json; utf-8");
            connection.setRequestProperty("Accept", "application/json");
            
            int responseCode = connection.getResponseCode();

            if (responseCode != HttpURLConnection.HTTP_OK) {
                return String.format("Bad request. Status code: %d", responseCode);
            }

            try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                String responseLine;
                while ((responseLine = reader.readLine()) != null) {
                    response.append(responseLine.trim());
                }
                connection.disconnect();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Host doesn't exist";
        }

        return response.toString();

    }


}
