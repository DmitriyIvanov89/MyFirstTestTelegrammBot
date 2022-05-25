package ru.spb.stec.divanov;

import com.google.gson.*;
import ru.spb.stec.divanov.service.httpconnection.GetRatesConnection;

public class MyFirstTestTelegramBotApp {
    private static final String HOST = "https://min-api.cryptocompare.com/data/top/totalvolfull?limit=3&tsym=USD";

    public static void main(String[] args) {

//        try {
//            TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
//            telegramBotsApi.registerBot(new Bot());
//        } catch (TelegramApiException ex) {
//            ex.printStackTrace();
//        }

        String response = new GetRatesConnection().getRates();
//        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonElement jsonElement = new Gson().fromJson(response, JsonElement.class);
//        System.out.println(jsonElement);
        jsonElement.getAsJsonObject();
        System.out.println(jsonElement.getAsJsonObject().get("Data"));

    }
}
