package ru.spb.stec.divanov.command.commands;

import org.telegram.telegrambots.meta.api.objects.Update;
import ru.spb.stec.divanov.command.Command;
import ru.spb.stec.divanov.service.SendBotMessageService;

public class StopCommand implements Command {

    private SendBotMessageService sendBotMessageService;
    private static final String STOP_MESSAGE = "Bot completed";

    public StopCommand(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {
        sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(), STOP_MESSAGE);
    }
}
