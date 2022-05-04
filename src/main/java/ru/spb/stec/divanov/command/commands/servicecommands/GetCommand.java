package ru.spb.stec.divanov.command.commands.servicecommands;

import org.telegram.telegrambots.meta.api.objects.Update;
import ru.spb.stec.divanov.command.Command;
import ru.spb.stec.divanov.service.botsendmessage.SendBotMessageService;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class GetCommand implements Command {

    private static final String HOST = "https://min-api.cryptocompare.com/data/pricemulti?fsyms=BTC,ETH&tsyms=USD,EUR,RUB";
    private final SendBotMessageService sendBotMessageService;

    public GetCommand(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {
        sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(), getRates());
    }

    private String getRates() {
        try {
            URL url = new URL(HOST);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setRequestProperty("Content-type", "application/json");

            try (BufferedReader reader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()))) {
                StringBuilder response = new StringBuilder();
                String responseLine;
                while ((responseLine = reader.readLine()) != null) {
                    response.append(responseLine.trim());
                }
                httpURLConnection.disconnect();
                return response.toString();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "ERROR";
    }
}
