package dataExchange;

import server.commands.Command;

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
