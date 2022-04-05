package ru.spb.stec.divanov.components;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class CryptoService implements BaseCryptoService {

    private static final String HOST = "https://min-api.cryptocompare.com/data/price?fsym=BTC&tsyms=USD,JPY,EUR";
    private static final String TOKEN_API = "adca4a1a1d77164572531e5eb0b1386fded3ee934ec030171dba622192e081c3";

    @Override
    public String requestCryptoCourses() {
//        try {
//            URL url = new URL(HOST);
//            HttpURLConnection http = (HttpURLConnection) url.openConnection();
//            http.setRequestMethod("POST");
//            http.setDoOutput(true);
//            http.setRequestProperty("Content-type", TOKEN_API);
//
//            String data = "adca4a1a1d77164572531e5eb0b1386fded3ee934ec030171dba622192e081c3";
//            byte[] out = data.getBytes(StandardCharsets.UTF_8);
//            OutputStream stream = http.getOutputStream();
//            stream.write(out);
//
//            try (BufferedReader reader = new BufferedReader(new InputStreamReader(http.getInputStream()))) {
//                StringBuilder response = new StringBuilder();
//                String responseLine;
//                while ((responseLine = reader.readLine()) != null) {
//                    response.append(responseLine.trim());
//                }
//                http.disconnect();
//                return response.toString();
//            }
//        } catch (Exception e) {
//            return "ERROR";
//        }
        return null;
    }

}
