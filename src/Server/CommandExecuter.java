package Server;

import Objects.Exceptions.*;
import Server.Commands.*;
import Server.FileManagement.FileReaderer;
import Server.FileManagement.LineReader;
import Server.Terminal.CommandArray;
import Server.Terminal.CommandMaker;
import Server.Terminal.CommandOutput;
import Server.Terminal.Terminal;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class CommandExecuter {
    private Boolean isRunning;
    private Storage storage;
    private CommandArray commandArray;
    private CommandMaker commandMaker;
    private LineReader lineReader;
    private Terminal terminal;
    public CommandExecuter(Terminal terminal, LineReader lineReader)
    {
        this.terminal=terminal;
        this.lineReader=lineReader;
        this.commandMaker= new CommandMaker(terminal, lineReader,this);
        this.commandArray = new CommandArray();
        CommandSetter.setCommands(commandArray);
    }

    public Storage getStorage() {
        return storage;
    }
    public void setStorage(Storage storage)
    {
        this.storage=storage;
    }

    public CommandOutput execute(Command command) throws FileNotFoundException {
        CommandOutput output = command.execute();
        return output;
    }
    private String getLine() throws IOException {
        return lineReader.readLine();
    }
    public Command makeCommand()
    {
        Command command = null;
        ArrayList<String> commandLine = null;
        while (command == null && isRunning) {
            String commandContents = null;
            try {
                commandContents = this.getLine();
            } catch (IOException e) {
                isRunning=false;
                throw new RuntimeException(e);
            }
            if(commandContents==null) isRunning=false;
            if(isRunning)
                commandLine = new ArrayList<>(Arrays.asList(commandContents.split(" +")));
            try {
                command = (Command) commandArray.get(commandLine.get(0)).getClass().getConstructor().newInstance();
            } catch (Exception e) {
                if(isRunning) {
                    command = null;
                    System.out.println("ti lox");
                }
            }
        }
        commandLine.remove(0);
        try {
            if(isRunning)
                this.commandMaker.addParams(command, commandLine);
        } catch (CoordinatesException e) {
            throw new RuntimeException(e);
        } catch (AreaException e) {
            throw new RuntimeException(e);
        } catch (GovernmentException e) {
            throw new RuntimeException(e);
        } catch (GovernorException e) {
            throw new RuntimeException(e);
        } catch (HeightException e) {
            throw new RuntimeException(e);
        } catch (CarCodeException e) {
            throw new RuntimeException(e);
        } catch (PopulationException e) {
            throw new RuntimeException(e);
        } catch (NameCityException e) {
            throw new RuntimeException(e);
        } catch (CapitalException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.out.println("sssssssnake");
        }
        return command;
    }
    public void startSession()
    {
        this.isRunning=true;
        Command command = null;
        while (isRunning)
        {
            try {
                command = makeCommand();
                CommandOutput commandOutput=new CommandOutput(new ArrayList<>());
                if(isRunning)
                    commandOutput = command.execute();
                for(String line : commandOutput.getResponse())
                    this.terminal.writeLine(line);
            }
            catch (RuntimeException | FileNotFoundException e)
            {
                this.terminal.writeLine(e.getMessage());
                this.terminal.writeLine("command not understood");
            }
        }
        try {
            this.lineReader.closeStream();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
