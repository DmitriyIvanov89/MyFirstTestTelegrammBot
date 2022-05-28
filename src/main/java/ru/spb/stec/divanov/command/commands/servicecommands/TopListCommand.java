package ru.spb.stec.divanov.command.commands.servicecommands;

import org.telegram.telegrambots.meta.api.objects.Update;
import ru.spb.stec.divanov.command.Command;
import ru.spb.stec.divanov.service.botsendmessage.SendBotMessageService;
import ru.spb.stec.divanov.service.controllers.GetRatesTopCoins;
import ru.spb.stec.divanov.service.printers.ResponsePrinter;

public class TopListCommand implements Command {

    private final SendBotMessageService sendBotMessageService;

    public TopListCommand(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {
        sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(),
                new ResponsePrinter().convertToView(new GetRatesTopCoins().getTopCoinsRates()));
    }
}
