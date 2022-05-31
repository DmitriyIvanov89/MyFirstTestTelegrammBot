package command.commands;

import org.junit.jupiter.api.DisplayName;
import ru.spb.stec.divanov.command.Command;
import ru.spb.stec.divanov.command.CommandName;
import ru.spb.stec.divanov.command.commands.basecommands.StopCommand;

@DisplayName("Util-level testing for StopCommand")
public class StopCommandTest extends AbstractCommandTest {
    @Override
    String getCommandName() {
        return CommandName.STOP.getName();
    }

    @Override
    String getCommandMessage() {
        return StopCommand.STOP_MESSAGE;
    }

    @Override
    Command getCommand() {
        return new StopCommand(sendBotMessageService);
    }
}
