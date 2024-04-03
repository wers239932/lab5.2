package ui;

import Server.Server;
import Server.ServerMessageReceiver;
import Server.commands.Command;
import Server.utilities.CommandArray;
import Server.utilities.CommandOutput;
import dataExchange.ExecuteCommandRequest;
import dataExchange.GetCommandArrayRequest;
import dataExchange.Message;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.NoSuchElementException;

public class Client {
    private CommandArray commandArray;
    private ServerMessageReceiver serverMessageReceiver;
    private ClientMessageReciever clientMessageReciever;
    private CommandCreator commandCreator;
    private ParameterAdder parameterAdder;
    private Terminal terminal;
    private ClientMessageDecoder clientMessageDecoder;
    private Boolean isRunning;
    public void setCommandArray()
    {
        this.sendMessage(new GetCommandArrayRequest(this));
    }
    public void sendMessage(Message message)
    {
        serverMessageReceiver.setMessage(message);
    }
    public void startClient(ServerMessageReceiver serverMessageReceiver)
    {
        this.terminal = new Terminal();
        this.parameterAdder = new ParameterAdder(terminal,terminal);
        this.commandCreator = new CommandCreator(parameterAdder,terminal,terminal);
        this.clientMessageDecoder = new ClientMessageDecoder(terminal,);
        this.serverMessageReceiver=serverMessageReceiver;
        this.setCommandArray();

    }
    public void startTerminal()
    {
        this.isRunning=true;
        Command command = null;
        while (isRunning)
        {
            try {
                command = commandCreator.makeCommand();
                if(isRunning)
                    this.sendMessage(new ExecuteCommandRequest(command));
            }
            catch (NoSuchElementException e){
                try {
                    this.terminal.closeStream();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                this.terminal.writeLine("Программа завершена");
                System.exit(0);
            }
            catch (RuntimeException e)
            {
                this.terminal.writeLine(e.getMessage());
                this.terminal.writeLine("command couldn't be executed");
            }
        }
        try {
            this.lineReader.closeStream();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
