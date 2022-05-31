package command.commands;

import org.junit.jupiter.api.DisplayName;
import ru.spb.stec.divanov.command.Command;
import ru.spb.stec.divanov.command.CommandName;
import ru.spb.stec.divanov.command.commands.basecommands.NoCommand;

@DisplayName("Unit-level testing for NoCommand")
public class NoCommandTest extends AbstractCommandTest {
    @Override
    String getCommandName() {
        return CommandName.NO.getName();
    }

    @Override
    String getCommandMessage() {
        return NoCommand.NO_COMMAND_MESSAGE;
    }

    @Override
    Command getCommand() {
        return new NoCommand(sendBotMessageService);
    }
}
