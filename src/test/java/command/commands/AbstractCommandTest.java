package command.commands;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.spb.stec.divanov.bot.MyBotClass;
import ru.spb.stec.divanov.command.Command;
import ru.spb.stec.divanov.service.botsendmessage.SendBotMessageImpl;
import ru.spb.stec.divanov.service.botsendmessage.SendBotMessageService;

abstract class AbstractCommandTest {
    protected MyBotClass myBotClass = Mockito.mock(MyBotClass.class);
    protected SendBotMessageService sendBotMessageService = new SendBotMessageImpl(myBotClass);

    abstract String getCommandName();

    abstract String getCommandMessage();

    abstract Command getCommand();

    @Test
    public void shouldProperlyExecuteCommand() throws TelegramApiException {
        Long chatId = 1234567824356L;

        Update update = new Update();
        Message message = Mockito.mock(Message.class);
        Mockito.when(message.getChatId()).thenReturn(chatId);
        Mockito.when(message.getText()).thenReturn(getCommandName());
        update.setMessage(message);

        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId.toString());
        sendMessage.setText(getCommandMessage());
        sendMessage.enableHtml(true);

        getCommand().execute(update);

        Mockito.verify(myBotClass).execute(sendMessage);

    }


}
