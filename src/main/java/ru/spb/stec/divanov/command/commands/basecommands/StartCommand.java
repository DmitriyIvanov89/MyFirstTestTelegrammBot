package ru.spb.stec.divanov.command.commands.basecommands;

import org.telegram.telegrambots.meta.api.objects.Update;
import ru.spb.stec.divanov.command.Command;
import ru.spb.stec.divanov.command.CommandName;
import ru.spb.stec.divanov.service.botsendmessage.SendBotMessageService;

public class StartCommand implements Command {

    private final SendBotMessageService sendBotMessageService;
    // insert commands after create
    private static final String START_MESSAGE = String.format(
            "Hey! I'm a bot for receiving cryptocurrency rates.\n"
                    + "Please enter the available command to continue:\n"
                    + "%s - get a actual rate of top 3 coins;\n"
                    + "%s - get a number of top 10 coins by their total volume;\n"
                    + "%s - get a number of top 10 coins by their market cap;\n"
                    + "%s - stop work with bot;\n"
                    + "All data is taken from CryptoCompare (www.cryptocompare.com).",
            CommandName.GET.getName(),
            CommandName.GET.getName(),
            CommandName.GET.getName(),
            CommandName.STOP.getName()
    );

    public StartCommand(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {
        sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(), START_MESSAGE);
    }
}
