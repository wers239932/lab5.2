package ui;

import Server.commands.Command;
import Server.utilities.CommandExecuter;
import Server.utilities.CommandMaker;
import Server.utilities.CommandOutput;
import dataExchange.ExecuteCommandRequest;
import dataExchange.Message;
import dataExchange.SendCommandOutput;
import dataExchange.SetCommandArrayResponse;
import objectSpace.exceptions.*;

import java.io.FileNotFoundException;
import java.io.IOException;

public class ClientMessageDecoder {
    private Terminal terminal;
    private CommandCreator commandCreator;
    public ClientMessageDecoder(Terminal terminal, CommandCreator commandCreator)
    {
        this.terminal= terminal;
        this.commandCreator = commandCreator;
    }
    public void DecodeMessage(Message message){
        if(message instanceof SendCommandOutput)
        {
            this.terminal.writeCommandOutput(((SendCommandOutput) message).getCommandOutput());
        }
        if(message instanceof SetCommandArrayResponse)
        {
            this.commandCreator.setCommandArray(((SetCommandArrayResponse) message).getCommandArray());
        }
    }
}
