package server;

import server.commands.Command;
import server.utilities.CommandArray;
import server.utilities.CommandExecuter;
import server.utilities.CommandMaker;
import server.utilities.CommandOutput;
import dataExchange.*;
import ui.ClientMessageReciever;

import java.io.FileNotFoundException;

public class ServerMessageDecoder {
    private CommandExecuter commandExecuter;
    private CommandMaker commandMaker;
    private Server server;
    private ClientMessageReciever clientMessageReciever;
    public void DecodeMessage(Message message)  {
        if(message instanceof ExecuteCommandRequest)
        {
            Command command = ((ExecuteCommandRequest) message).getCommand();
            this.commandMaker.addParams(command);
            CommandOutput commandOutput = null;
            try {
                commandOutput = this.commandExecuter.execute(command);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            SendCommandOutput response = new SendCommandOutput(commandOutput);
            server.sendMessage(response, clientMessageReciever);
        }
        if(message instanceof GetCommandArrayRequest)
        {
            CommandArray commandArray =  new CommandArray();
            String[] names = new String[1];
            names[0]="save";
            //commandArray.removeCommand(names);
            server.sendMessage(new SetCommandArrayResponse(commandArray),this.clientMessageReciever);
        }
    }
}
