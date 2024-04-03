package ui;

import dataExchange.Message;
import dataExchange.SendCommandOutput;
import dataExchange.SetCommandArrayResponse;

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
