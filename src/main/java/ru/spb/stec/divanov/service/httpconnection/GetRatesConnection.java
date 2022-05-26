package ru.spb.stec.divanov.service.httpconnection;

import java.io.BufferedReader;;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class GetRatesConnection {

//    private static final String HOST = "https://min-api.cryptocompare.com/data/pricemulti?fsyms=BTC,ETH&tsyms=USD,EUR,RUB";
//    private static final String HOST = "https://min-api.cryptocompare.com/data/top/totalvolfull?limit=3&tsym=USD";
    private static final String HOST = "https://pro-api.coinmarketcap.com/v2/cryptocurrency/quotes/latest?symbol=BTC&convert=USD";
    private static final String API_KEY = "9e2fe4d6-3b65-4b88-8915-3de23747c691";

    public String getRates() {
        StringBuilder response = new StringBuilder();

        try {
            URL url = new URL(HOST);
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
