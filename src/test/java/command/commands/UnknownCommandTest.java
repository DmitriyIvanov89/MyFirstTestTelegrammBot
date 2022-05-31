package command.commands;

import org.junit.jupiter.api.DisplayName;
import ru.spb.stec.divanov.command.Command;
import ru.spb.stec.divanov.command.commands.basecommands.UnknownCommand;

@DisplayName("Util-level testing for UnknownCommand")
public class UnknownCommandTest extends AbstractCommandTest {
    @Override
    String getCommandName() {
        return "/sfgdgsgsdg";
    }

    @Override
    String getCommandMessage() {
        return UnknownCommand.UNKNOWN_MESSAGE;
    }

    @Override
    Command getCommand() {
        return new UnknownCommand(sendBotMessageService);
    }
}
