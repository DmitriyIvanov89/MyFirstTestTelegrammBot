package ru.spb.stec.divanov;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import ru.spb.stec.divanov.components.Bot;
import ru.spb.stec.divanov.config.AppConfig;

public class MyFirstTestTelegramBotApp {
    public static void main(String[] args) {

        try {
            ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
            TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
            telegramBotsApi.registerBot(context.getBean(Bot.class));

        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

}
