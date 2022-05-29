package ru.spb.stec.divanov.service.controllers;

import com.google.gson.JsonElement;
import ru.spb.stec.divanov.service.httpconnection.ConnectionToAPI;

import java.util.List;

public class GetTopCoinsRatesController {
    private static final String RATES_URL = "https://min-api.cryptocompare.com/data/pricemulti?fsyms=";
    private static final String CURRENCY_FOR_RATE_REQUEST_PARAM = "&tsyms=USD,EUR,RUB";

    public String getRates() {
        List<JsonElement> topCoinsNames = new GetTopListCoinsController().getTopListCoins();
        StringBuilder requestParamsCoinsNames = new StringBuilder();
        for (JsonElement element : topCoinsNames) {
            requestParamsCoinsNames.append(element.getAsString() + ",");
        }

        return new ConnectionToAPI().getTopListCoins(RATES_URL + requestParamsCoinsNames.toString() + CURRENCY_FOR_RATE_REQUEST_PARAM);
    }


}
