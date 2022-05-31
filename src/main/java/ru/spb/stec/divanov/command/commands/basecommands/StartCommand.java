package ru.spb.stec.divanov.command.commands.basecommands;

import org.telegram.telegrambots.meta.api.objects.Update;
import ru.spb.stec.divanov.command.Command;
import ru.spb.stec.divanov.command.CommandName;
import ru.spb.stec.divanov.service.botsendmessage.SendBotMessageService;

public class StartCommand implements Command {

    private final SendBotMessageService sendBotMessageService;
    // insert commands after create
    public static final String START_MESSAGE = String.format(
            "Hey! I'm a bot for receiving cryptocurrency rates.\n"
                    + "Please enter the available command to continue:\n\n"
                    + "%s - get a actual rate of top 10 coins;\n"
                    + "%s - help;\n"
                    + "\n\nAll data is from CryptoCompare (www.cryptocompare.com).",
            CommandName.GET.getName(),
            CommandName.HELP.getName()
    );

    public StartCommand(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {
        sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(), START_MESSAGE);
    }
}
