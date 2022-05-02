package ru.spb.stec.divanov.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class BotCommandWithCryptoCurrency {

    private static final String HOST = "https://min-api.cryptocompare.com/data/pricemulti?fsyms=BTC,ETH&tsyms=USD,EUR,RUB";

    public String getCryptoCurrencyRate() {
        /*
         * Отдельный класс для установки соединения
         * */
        try {
            URL url = new URL(HOST);
            HttpURLConnection http = (HttpURLConnection) url.openConnection();
            http.setRequestMethod("GET");
            http.setRequestProperty("Content-type", "application/json");

            try (BufferedReader reader = new BufferedReader(new InputStreamReader(http.getInputStream()))) {
                StringBuilder response = new StringBuilder();
                String responseLine;
                while ((responseLine = reader.readLine()) != null) {
                    response.append(responseLine.trim());
                }
                http.disconnect();
                return response.toString();
            }
        } catch (Exception e) {
            return "ERROR";
        }
    }

}
