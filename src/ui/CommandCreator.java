package ui;

import Server.commands.Command;
import Server.fileManagement.LineReader;
import Server.utilities.*;
import dataExchange.ExecuteCommandRequest;
import objectSpace.exceptions.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class CommandCreator {
    private Terminal terminal;
    private ParameterAdder parameterAdder;
    private CommandArray commandArray;
    private final LineReader lineReader;
    private Boolean isRunning;

    public CommandCreator(ParameterAdder parameterAdder, LineReader lineReader, Terminal terminal) {
        this.terminal = terminal;
        this.lineReader = lineReader;
        this.parameterAdder = new ParameterAdder(terminal, lineReader);
    }
    public void setCommandArray(CommandArray commandArray)
    {
        this.commandArray=commandArray;
    }

    private String getLine() throws IOException {
        return lineReader.readLine();
    }

    public Command makeCommand() {
        Command command = null;
        ArrayList<String> commandLine = null;
        while (command == null && isRunning) {
            String commandContents = null;
            try {
                commandContents = this.getLine();
            } catch (IOException e) {
                isRunning = false;
                throw new RuntimeException(e);
            }
            if (commandContents == null) isRunning = false;
            if (isRunning)
                commandLine = new ArrayList<>(Arrays.asList(commandContents.split(" +")));
            try {
                command = (Command) commandArray.get(commandLine.get(0)).getConstructor().newInstance();
            } catch (Exception e) {
                if (isRunning) {
                    command = null;
                    this.terminal.writeLine("command not understood");
                }
            }
        }
        if (isRunning)
            commandLine.remove(0);
        try {
            if (isRunning)
                this.parameterAdder.addParams(command, commandLine);
        } catch (CoordinatesException | AreaException | GovernmentException | GovernorException | HeightException |
                 CarCodeException | PopulationException | NameCityException | CapitalException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.out.println("ioe exception");
        }
        return command;
    }
    public void sendExecuteRequest(Command command)
    {
        ExecuteCommandRequest commandRequest = new ExecuteCommandRequest(command);
    }
}
