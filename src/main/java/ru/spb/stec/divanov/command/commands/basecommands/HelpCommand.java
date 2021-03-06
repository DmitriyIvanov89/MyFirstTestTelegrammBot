package ru.spb.stec.divanov.command.commands.basecommands;

import org.telegram.telegrambots.meta.api.objects.Update;
import ru.spb.stec.divanov.command.Command;
import ru.spb.stec.divanov.command.CommandName;
import ru.spb.stec.divanov.service.botsendmessage.SendBotMessageService;

public class HelpCommand implements Command {

    private final SendBotMessageService sendBotMessageService;
    // insert commands after create
    public static final String HELP_MESSAGE = String.format(
            "<b>Available commands</b>:\n\n"
                    + "%s - get a actual rate of top 3 coins;\n"
                    + "%s - stop work with bot;\n",
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
