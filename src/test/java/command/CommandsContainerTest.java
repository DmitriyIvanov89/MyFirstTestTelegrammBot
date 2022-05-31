package command;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.spb.stec.divanov.command.Command;
import ru.spb.stec.divanov.command.CommandName;
import ru.spb.stec.divanov.command.CommandsContainer;
import ru.spb.stec.divanov.command.commands.basecommands.UnknownCommand;
import ru.spb.stec.divanov.service.botsendmessage.SendBotMessageService;

import java.util.Arrays;

@DisplayName("Unit-level testing for CommandsContainer")
public class CommandsContainerTest {
    private CommandsContainer commandsContainer;

    @BeforeEach
    public void init() {
        SendBotMessageService sendBotMessageService = Mockito.mock(SendBotMessageService.class);
        commandsContainer = new CommandsContainer(sendBotMessageService);
    }

    @Test
    public void shouldGetAllTheExistingCommands() {
        Arrays.stream(CommandName.values())
                .forEach(commandName -> {
                    Command command = commandsContainer.getCommandFromContainer(commandName.getName());
                    Assertions.assertNotEquals(UnknownCommand.class, command.getClass());
                });
    }

    @Test
    public void shouldReturnUnknownCommand() {
        String unknownCommand = "/sfsfsfsfsf";
        Command command = commandsContainer.getCommandFromContainer(unknownCommand);
        Assertions.assertEquals(UnknownCommand.class, command.getClass());
    }

}
