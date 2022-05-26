package ru.spb.stec.divanov.service.httpconnection;

import java.io.BufferedReader;;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ConnectionToCryptoAPI {

    private static final String API_KEY = "***";

    public String testConnection(String host) {
        StringBuilder response = new StringBuilder();

        try {
            URL url = new URL(host);
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
