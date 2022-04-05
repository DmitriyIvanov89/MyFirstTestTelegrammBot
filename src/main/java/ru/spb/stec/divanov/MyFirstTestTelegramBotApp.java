package ru.spb.stec.divanov;

import javafx.scene.effect.SepiaTone;
import jdk.internal.dynalink.linker.LinkerServices;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import ru.spb.stec.divanov.components.Bot;
import ru.spb.stec.divanov.config.AppConfig;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;


public class MyFirstTestTelegramBotApp {
    public static void main(String[] args) {

//        try {
//            ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
//            TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
//            telegramBotsApi.registerBot(context.getBean(Bot.class));
//
//        } catch (TelegramApiException e) {
//            e.printStackTrace();
//        }
        System.out.println(myTestRequest());

    }

    public static String myTestRequest() {
        try {
            URL url = new URL("https://min-api.cryptocompare.com/data/pricemulti?fsyms=BTC,ETH&tsyms=USD,EUR,RUB");
            HttpURLConnection http = (HttpURLConnection) url.openConnection();
            http.setRequestMethod("GET");
            http.setRequestProperty("Content-type", "application/json");

            try (BufferedReader reader = new BufferedReader(new InputStreamReader(http.getInputStream()))) {
                StringBuilder response = new StringBuilder();
                String responseLine;
                while ((responseLine = reader.readLine()) != null) {
                    response.append(responseLine.trim());
                }
                http.disconnect();
                return response.toString();
            }
        } catch (Exception e) {
            return "ERROR";
        }
    }
}
