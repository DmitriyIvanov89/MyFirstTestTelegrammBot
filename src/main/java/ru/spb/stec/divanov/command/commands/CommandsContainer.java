package ru.spb.stec.divanov.command.commands;

import ru.spb.stec.divanov.command.Command;
import ru.spb.stec.divanov.command.CommandName;
import ru.spb.stec.divanov.service.SendBotMessageService;

import java.util.HashMap;
import java.util.Map;

public class CommandsContainer {

    Map<String, Command> commands;

    public CommandsContainer(SendBotMessageService sendBotMessageService) {
        commands = new HashMap<>();
        commands.put(CommandName.START.getName(), new StartCommand(sendBotMessageService));
        commands.put(CommandName.STOP.getName(), new StopCommand(sendBotMessageService));
        commands.put(CommandName.HELP.getName(), new HelpCommand(sendBotMessageService));
    }

    public Command getCommandFromContainer(String commandIdentifier) {
        return commands.get(commandIdentifier);
    }
}
