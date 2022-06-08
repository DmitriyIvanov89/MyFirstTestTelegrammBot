package ru.spb.stec.divanov.bot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.spb.stec.divanov.command.CommandName;
import ru.spb.stec.divanov.command.CommandsContainer;
import ru.spb.stec.divanov.service.botsendmessage.SendBotMessageImpl;


public class MyBotClass extends TelegramLongPollingBot {

    private static final String COMMAND_PREFIX = "/";
    private final CommandsContainer commandsContainer;

    public MyBotClass() {
        this.commandsContainer = new CommandsContainer(new SendBotMessageImpl(this));
    }

    @Override
    public String getBotUsername() {
        return System.getenv("BOT_NAME");
    }

    @Override
    public String getBotToken() {
        return System.getenv("BOT_TOKEN");
    }

    @Override
    public void onUpdateReceived(Update update) {

        if (update.hasMessage() && update.getMessage().hasText()) {
            Message message = update.getMessage();
            if (message.getText().startsWith(COMMAND_PREFIX)) {
                String commandIdentifier = message.getText().split(" ")[0].toLowerCase();
                commandsContainer.getCommandFromContainer(commandIdentifier).execute(update);
            } else {
                commandsContainer.getCommandFromContainer(CommandName.NO.getName()).execute(update);
            }
        }
    }
}
