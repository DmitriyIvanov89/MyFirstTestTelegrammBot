package ru.spb.stec.divanov.command.commands.basecommands;

import org.telegram.telegrambots.meta.api.objects.Update;
import ru.spb.stec.divanov.command.Command;
import ru.spb.stec.divanov.service.botsendmessage.SendBotMessageService;

public class NoCommand implements Command {

    private final SendBotMessageService sendBotMessageService;
    private final static String NO_COMMAND_MESSAGE = "You have entered an invalid command.\n"
            + "Please input /help to see the available commands";

    public NoCommand(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {
        sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(), NO_COMMAND_MESSAGE);
    }
}
