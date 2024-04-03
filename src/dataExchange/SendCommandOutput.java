package dataExchange;

import Server.utilities.CommandOutput;

public class SendCommandOutput extends Message{
    private CommandOutput commandOutput;

    public CommandOutput getCommandOutput() {
        return commandOutput;
    }
    public SendCommandOutput(CommandOutput commandOutput)
    {
        this.commandOutput=commandOutput;
    }
}
