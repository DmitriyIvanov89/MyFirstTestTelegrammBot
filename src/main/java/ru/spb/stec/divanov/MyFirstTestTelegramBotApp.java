package ru.spb.stec.divanov;

import com.google.gson.Gson;
import ru.spb.stec.divanov.service.httpconnection.ApacheTestConnection;
import ru.spb.stec.divanov.service.httpconnection.GetRatesConnection;

import java.io.*;

public class MyFirstTestTelegramBotApp {
    private static final String HOST = "https://min-api.cryptocompare.com/data/top/totalvolfull?limit=3&tsym=USD";

    public static void main(String[] args) {

//        try {
//            TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
//            telegramBotsApi.registerBot(new Bot());
//        } catch (TelegramApiException ex) {
//            ex.printStackTrace();
//        }

        System.out.println(new GetRatesConnection().getRates());
    }
}
