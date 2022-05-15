package ru.spb.stec.divanov.command;

import ru.spb.stec.divanov.command.commands.basecommands.*;
import ru.spb.stec.divanov.command.commands.servicecommands.GetTopCoinsRate;
import ru.spb.stec.divanov.service.botsendmessage.SendBotMessageService;

import java.util.HashMap;
import java.util.Map;

public class CommandsContainer {

    private final Map<String, Command> commands;
    private final Command unknownCommand;

    public CommandsContainer(SendBotMessageService sendBotMessageService) {
        commands = new HashMap<>();
        commands.put(CommandName.START.getName(), new StartCommand(sendBotMessageService));
        commands.put(CommandName.STOP.getName(), new StopCommand(sendBotMessageService));
        commands.put(CommandName.HELP.getName(), new HelpCommand(sendBotMessageService));
        commands.put(CommandName.NO.getName(), new NoCommand(sendBotMessageService));
        unknownCommand = new UnknownCommand(sendBotMessageService);

        commands.put(CommandName.GET.getName(), new GetTopCoinsRate(sendBotMessageService));
    }

    public Command getCommandFromContainer(String commandIdentifier) {
        return commands.getOrDefault(commandIdentifier, unknownCommand);
    }
}
