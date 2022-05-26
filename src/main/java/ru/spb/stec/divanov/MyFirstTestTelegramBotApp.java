package ru.spb.stec.divanov;

import com.google.gson.*;
import ru.spb.stec.divanov.service.httpconnection.GetRatesConnection;

import java.util.ArrayList;
import java.util.List;

public class MyFirstTestTelegramBotApp {


    public static void main(String[] args) {

//        try {
//            TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
//            telegramBotsApi.registerBot(new Bot());
//        } catch (TelegramApiException ex) {
//            ex.printStackTrace();
//        }

        String response = new GetRatesConnection().getRates();
        JsonElement jsonElement = new Gson().fromJson(response, JsonElement.class);
//        System.out.println(jsonElement.getAsJsonObject().getAsJsonArray("Data").get(0).getAsJsonObject().get("CoinInfo").getAsJsonObject().get("Name"));

        JsonArray array = jsonElement.getAsJsonObject().getAsJsonArray("Data");
        List<JsonElement> coinsNames = new ArrayList<>();

        for (JsonElement element : array) {
            coinsNames.add(element.getAsJsonObject().get("CoinInfo").getAsJsonObject().get("Name"));
        }

        for (JsonElement element : array) {
            System.out.println(element.getAsString());
        }


    }
}
