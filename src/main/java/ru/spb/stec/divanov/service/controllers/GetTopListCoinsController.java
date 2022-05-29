package ru.spb.stec.divanov.service.controllers;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import ru.spb.stec.divanov.service.httpconnection.ConnectionToAPI;

import java.util.ArrayList;
import java.util.List;

public class GetTopListCoinsController {
    private static final String TOP_LIST_COINS_URL = "https://min-api.cryptocompare.com/data/top/totalvolfull?limit=10&tsym=USD";

    public List<JsonElement> getTopListCoins() {
        List<JsonElement> coins = new ArrayList<>();
        String response = new ConnectionToAPI().getTopListCoins(TOP_LIST_COINS_URL);
        JsonElement element = new Gson().fromJson(response, JsonElement.class);
        JsonArray jsonArray = element.getAsJsonObject().getAsJsonArray("Data");

        for (JsonElement e : jsonArray) {
            coins.add(e.getAsJsonObject().get("CoinInfo").getAsJsonObject().get("Name"));
        }

        return coins;
    }
}
