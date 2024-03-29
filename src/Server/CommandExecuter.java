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
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class CommandExecuter {
    private LinkedList<String> sctiptNames;
    private Boolean isRunning;
    private Storage storage;
    private final CommandArray commandArray;
    private final CommandMaker commandMaker;
    private final LineReader lineReader;
    private final Terminal terminal;
    public CommandExecuter(Terminal terminal, LineReader lineReader,LinkedList<String> scriptNames)
    {
        this.terminal=terminal;
        this.lineReader=lineReader;
        this.commandMaker= new CommandMaker(terminal, lineReader,this);
        this.commandArray = new CommandArray();
        CommandSetter.setCommands(commandArray);
        this.sctiptNames=scriptNames;
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
                command = commandArray.get(commandLine.get(0)).getClass().getConstructor().newInstance();
            } catch (Exception e) {
                if(isRunning) {
                    command = null;
                    this.terminal.writeLine("command not understood");
                }
            }
        }
        if(isRunning)
            commandLine.remove(0);
        try {
            if(isRunning)
                this.commandMaker.addParams(command, commandLine);
        } catch (CoordinatesException | AreaException | GovernmentException | GovernorException | HeightException |
                 CarCodeException | PopulationException | NameCityException | CapitalException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.out.println("ioe exception");
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
            catch (NoSuchElementException e){
                try {
                    this.terminal.closeStream();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                this.terminal.writeLine("Программа завершена");
                System.exit(0);
            }
            catch (RuntimeException | FileNotFoundException e)
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


    public void addScriptName(String name)
    {
        this.sctiptNames.add(name);
    }
    public void removeScriptName()
    {
        this.sctiptNames.pop();
    }
    public LinkedList<String> getScriptNames()
    {
        return this.sctiptNames;
    }
}
