package ru.spb.stec.divanov.service.controllers;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import ru.spb.stec.divanov.service.httpconnection.ConnectionToCryptoAPI;

import java.util.ArrayList;
import java.util.List;

public class GetTopListCoinsController {
    private static final String topListCoins = "https://min-api.cryptocompare.com/data/top/totalvolfull?limit=10&tsym=USD";
    private static final String HEADER_MESSAGE = "Top 10 Coins by their total volume:\n";

    public List<JsonElement> getTopListCoins() {
        ConnectionToCryptoAPI connectionToCryptoAPI = new ConnectionToCryptoAPI();
        List<JsonElement> coins = new ArrayList<>();
        String response = connectionToCryptoAPI.getTopListCoins(topListCoins);
        JsonElement element = new Gson().fromJson(response, JsonElement.class);
        JsonArray jsonArray = element.getAsJsonObject().getAsJsonArray("Data");

        for (JsonElement e : jsonArray) {
            coins.add(e.getAsJsonObject().get("CoinInfo").getAsJsonObject().get("Name"));
        }

//        StringBuilder sb = new StringBuilder();
//        sb.append(HEADER_MESSAGE);
//
//        for (int i = 1; i < coins.size(); i++) {
//            sb.append(String.format("- %s\n", coins.get(i)));
//        }
//
//        return sb.toString();

        return coins;
    }


}
