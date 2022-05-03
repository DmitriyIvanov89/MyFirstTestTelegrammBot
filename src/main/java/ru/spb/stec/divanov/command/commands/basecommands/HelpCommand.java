package ru.spb.stec.divanov.command.commands.basecommands;

import org.telegram.telegrambots.meta.api.objects.Update;
import ru.spb.stec.divanov.command.Command;
import ru.spb.stec.divanov.command.CommandName;
import ru.spb.stec.divanov.service.SendBotMessageService;

public class HelpCommand implements Command {

    private final SendBotMessageService sendBotMessageService;
    private static final String HELP_MESSAGE = String.format(
            "<b>Available commands</b>\n\n"
                    + "%s - start work with bot\n"
                    + "%s - stop work with bot\n"
                    + "%s - get rates\n"
                    + "%s - get help\n",
            CommandName.START.getName(),
            CommandName.STOP.getName(),
            CommandName.GET.getName(),
            CommandName.HELP.getName());

    public HelpCommand(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {
        sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(), HELP_MESSAGE);
    }
}
