package ru.spb.stec.divanov;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import ru.spb.stec.divanov.bot.MyBotClass;


public class MyFirstTestTelegramBotApp {

    public static void main(String[] args) {

        try {
            TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
            telegramBotsApi.registerBot(new MyBotClass());
        } catch (TelegramApiException ex) {
            ex.printStackTrace();
        }
    }
}
