package ru.spb.stec.divanov.command;

import ru.spb.stec.divanov.command.commands.basecommands.HelpCommand;
import ru.spb.stec.divanov.command.commands.basecommands.StartCommand;
import ru.spb.stec.divanov.command.commands.basecommands.StopCommand;
import ru.spb.stec.divanov.command.commands.basecommands.UnknownCommand;
import ru.spb.stec.divanov.command.commands.servicecommands.GetCommand;
import ru.spb.stec.divanov.service.botsendmessage.SendBotMessageService;

import java.util.HashMap;
import java.util.Map;

public class CommandsContainer {

    private final Map<String, Command> commands;

    public CommandsContainer(SendBotMessageService sendBotMessageService) {
        commands = new HashMap<>();
        commands.put(CommandName.START.getName(), new StartCommand(sendBotMessageService));
        commands.put(CommandName.STOP.getName(), new StopCommand(sendBotMessageService));
        commands.put(CommandName.HELP.getName(), new HelpCommand(sendBotMessageService));
        commands.put(CommandName.GET.getName(), new GetCommand(sendBotMessageService));
        commands.put(CommandName.UNKNOWN.getName(), new UnknownCommand(sendBotMessageService));
    }

    public Command getCommandFromContainer(String commandIdentifier) {
        return commands.get(commandIdentifier);
    }
}
