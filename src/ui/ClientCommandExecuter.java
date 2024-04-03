package ui;

import Server.commands.Command;
import Server.fileManagement.LineReader;
import Server.utilities.CommandExecuter;
import dataExchange.ExecuteCommandRequest;

import java.io.IOException;
import java.util.NoSuchElementException;

public class ClientCommandExecuter {
    private Boolean isRunning;
    private CommandCreator commandCreator;
    private Client client;
    private Terminal terminal;
    private LineReader lineReader;
    public ClientCommandExecuter(CommandCreator commandCreator, Client client, Terminal terminal, LineReader lineReader)
    {
        this.commandCreator = commandCreator;
        this.client = client;
        this.terminal = terminal;
        this.lineReader = lineReader;
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
                    this.client.sendMessage(new ExecuteCommandRequest(command));
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
