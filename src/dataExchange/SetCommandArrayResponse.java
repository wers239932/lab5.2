package dataExchange;

import server.utilities.CommandArray;

public class SetCommandArrayResponse extends Message {
    private CommandArray commandArray;
    public SetCommandArrayResponse(CommandArray commandArray)
    {
        this.commandArray=commandArray;
    }

    public CommandArray getCommandArray() {
        return commandArray;
    }
}
