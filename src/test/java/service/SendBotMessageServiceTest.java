package service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.spb.stec.divanov.bot.MyBotClass;
import ru.spb.stec.divanov.service.botsendmessage.SendBotMessageImpl;
import ru.spb.stec.divanov.service.botsendmessage.SendBotMessageService;

@DisplayName("Unit-level testing fot SendBotMessageService")
public class SendBotMessageServiceTest {
    private SendBotMessageService sendBotMessageService;
    private MyBotClass bot;

    @BeforeEach
    public void init() {
        bot = Mockito.mock(MyBotClass.class);
        sendBotMessageService = new SendBotMessageImpl(bot);
    }

    @Test
    public void shouldProperlySendMessage() throws TelegramApiException {
        String chatId = "test_chatId";
        String message = "test_message";

        SendMessage sendMessage = new SendMessage();
        sendMessage.setText(message);
        sendMessage.setChatId(chatId);
        sendMessage.enableHtml(true);

        sendBotMessageService.sendMessage(chatId, message);

        Mockito.verify(bot).execute(sendMessage);
    }

}
