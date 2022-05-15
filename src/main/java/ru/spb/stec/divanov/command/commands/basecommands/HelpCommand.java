package ru.spb.stec.divanov.command.commands.basecommands;

import org.telegram.telegrambots.meta.api.objects.Update;
import ru.spb.stec.divanov.command.Command;
import ru.spb.stec.divanov.command.CommandName;
import ru.spb.stec.divanov.service.botsendmessage.SendBotMessageService;

public class HelpCommand implements Command {

    private final SendBotMessageService sendBotMessageService;
    // insert commands after create
    private static final String HELP_MESSAGE = String.format(
            "<b>Available commands</b>:\n\n"
                    + "%s - get a actual rate of top 3 coins;\n"
                    + "%s - get a number of top 10 coins by their total volume;\n"
                    + "%s - get a number of top 10 coins by their market cap;\n"
                    + "%s - stop work with bot;\n",
            CommandName.GET.getName(),
            CommandName.GET.getName(),
            CommandName.GET.getName(),
            CommandName.STOP.getName()
    );

    public HelpCommand(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {
        sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(), HELP_MESSAGE);
    }
}
