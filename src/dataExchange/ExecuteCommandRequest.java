package dataExchange;

import Server.commands.Command;
import Server.utilities.CommandArray;
import Server.utilities.CommandExecuter;

public class ExecuteCommandRequest extends Message{
    private Command command;
    public ExecuteCommandRequest(Command command)
    {
        this.command=command;
    }

    public Command getCommand() {
        return command;
    }
}
