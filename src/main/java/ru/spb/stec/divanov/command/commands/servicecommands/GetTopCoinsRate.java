package ru.spb.stec.divanov.command.commands.servicecommands;

import org.telegram.telegrambots.meta.api.objects.Update;
import ru.spb.stec.divanov.command.Command;
import ru.spb.stec.divanov.service.botsendmessage.SendBotMessageService;
import ru.spb.stec.divanov.service.httpconnection.GetRatesConnection;
import ru.spb.stec.divanov.service.mapper.Mapper;
import ru.spb.stec.divanov.service.messagereader.RateReader;

public class GetTopCoinsRate implements Command {

    private final SendBotMessageService sendBotMessageService;

    public GetTopCoinsRate(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {
        sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(),
                new Mapper().mapping(new RateReader(new GetRatesConnection().getRates()).getRatesFromResponse()));
    }
}
