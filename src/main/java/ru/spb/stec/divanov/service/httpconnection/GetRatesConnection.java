package ru.spb.stec.divanov.service.httpconnection;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class GetRatesConnection {

    private static final String HOST = "https://min-api.cryptocompare.com/data/pricemulti?fsyms=BTC,ETH&tsyms=USD,EUR,RUB";

    public String getRates() {
        try {
            URL url = new URL(HOST);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setRequestProperty("Content-type", "application/json");

            try (BufferedReader reader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()))) {
                StringBuilder response = new StringBuilder();
                String responseLine;
                while ((responseLine = reader.readLine()) != null) {
                    response.append(responseLine.trim());
                }
                httpURLConnection.disconnect();
                return response.toString();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Error request. Please try again later.";
    }
}
