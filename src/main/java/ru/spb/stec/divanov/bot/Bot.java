package ru.spb.stec.divanov.bot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.spb.stec.divanov.command.commands.CommandsContainer;
import ru.spb.stec.divanov.service.SendBotMessageImpl;


public class Bot extends TelegramLongPollingBot {

    private static final String BOT_TOKEN = "5215836988:AAHlnTVEQVYsJtLBsDINg2crQgt1ttdnrV0";
    private static final String BOT_NAME = "JimboJack88Bot";
    private static final String COMMAND_PREFIX = "/";
    private final CommandsContainer commandsContainer;

    public Bot() {
        this.commandsContainer = new CommandsContainer(new SendBotMessageImpl(this));
    }

    @Override
    public String getBotUsername() {
        return BOT_NAME;
    }

    @Override
    public String getBotToken() {
        return BOT_TOKEN;
    }

    @Override
    public void onUpdateReceived(Update update) {

        if (update.hasMessage() && update.getMessage().hasText()) {
            Message message = update.getMessage();
            String chatId = message.getChatId().toString();
            getCommandFromMessage(message.getText(), update);
        }
    }

    private void getCommandFromMessage(String message, Update update) {

        if (message.startsWith(COMMAND_PREFIX)) {
            String commandIdentifier = message.split(" ")[0].toLowerCase();
            commandsContainer.getCommandFromContainer(commandIdentifier).execute(update);
        } else {
            System.out.println("Unknown command"); // exception
        }
    }
}
