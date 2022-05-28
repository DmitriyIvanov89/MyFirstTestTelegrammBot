package ru.spb.stec.divanov;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import ru.spb.stec.divanov.bot.Bot;
import ru.spb.stec.divanov.service.controllers.GetRatesTopCoins;

import java.util.Map;

public class MyFirstTestTelegramBotApp {

    public static void main(String[] args) {

        try {
            TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
            telegramBotsApi.registerBot(new Bot());
        } catch (TelegramApiException ex) {
            ex.printStackTrace();
        }
    }
}
