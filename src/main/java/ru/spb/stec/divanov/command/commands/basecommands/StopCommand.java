package ru.spb.stec.divanov.command.commands.basecommands;

import org.telegram.telegrambots.meta.api.objects.Update;
import ru.spb.stec.divanov.command.Command;
import ru.spb.stec.divanov.service.botsendmessage.SendBotMessageService;

public class StopCommand implements Command {

    private final SendBotMessageService sendBotMessageService;
    public static final String STOP_MESSAGE = "Bot completed. Bye";

    public StopCommand(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {
        sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(), STOP_MESSAGE);
    }
}
