package ru.spb.stec.divanov.service.botsendmessage;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.spb.stec.divanov.bot.MyBotClass;

public class SendBotMessageImpl implements SendBotMessageService {

    private final MyBotClass bot;

    public SendBotMessageImpl(MyBotClass bot) {
        this.bot = bot;
    }

    @Override
    public void sendMessage(String chatId, String message) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.enableHtml(true);
        sendMessage.setText(message);

        try {
            bot.execute(sendMessage);
        } catch (TelegramApiException ex) {
            ex.printStackTrace();
        }
    }
}
