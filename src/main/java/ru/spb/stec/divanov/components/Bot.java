package ru.spb.stec.divanov.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.spb.stec.divanov.components.service.BotCommandWithCryptoCurrency;

@Component
public class Bot extends TelegramLongPollingBot {

    private final static String BOT_TOKEN = "5215836988:AAHlnTVEQVYsJtLBsDINg2crQgt1ttdnrV0";
    private final static String BOT_NAME = "JimboJack88Bot";
    private BotCommandWithCryptoCurrency cryptoService;

    @Autowired
    public void setCryptoService(BotCommandWithCryptoCurrency cryptoService) {
        this.cryptoService = cryptoService;
    }

    @Override
    public String getBotUsername() {
        return BOT_NAME;
    }

    @Override
    public String getBotToken() {
        return BOT_TOKEN;
    }

    @Override
    public void onUpdateReceived(Update update) {

        try {
            if (update.hasMessage() && update.getMessage().hasText()) {
                Message message = update.getMessage();
                String chatId = message.getChatId().toString();
                String response = parseMessage(message.getText());
                SendMessage sendMessage = new SendMessage();
                sendMessage.setChatId(chatId);
                sendMessage.setText(response);
                execute(sendMessage);
            }
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    private String parseMessage(String textMessage) {

        String response;

        if (textMessage.equals("/start")) {
            response = "Hi bro!\nThis is the test bot.\nPlease input /get command.";
        } else if (textMessage.equals("/get")) {
            response = cryptoService.getCryptoCurrencyRate();
        } else {
            response = "no valid command";
        }
        return response;

    }
}
