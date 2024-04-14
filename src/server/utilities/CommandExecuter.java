package server.utilities;

import server.Storage;
import objectSpace.exceptions.*;
import server.commands.*;
import server.fileManagement.LineReader;
import server.utilities.invokerLike.CommandArray;
import server.utilities.invokerLike.CommandSetter;
import ui.Terminal;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * запускатель команд, начинает сессию
 */
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
        commandArray.setCommands();
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
    public Command makeCommand() throws Exception {
        Command command = null;
        ArrayList<String> commandLine = null;
        while (command == null) {
            String commandContents = null;
            try {
                commandContents = this.getLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            if(commandContents==null) throw new Exception();
            commandLine = new ArrayList<>(Arrays.asList(commandContents.split(" +")));
            try {
                command = (Command) commandArray.get(commandLine.get(0)).getConstructor().newInstance();
            } catch (Exception e) {
                command = null;
                this.terminal.writeLine("command not understood");
            }
        }
        commandLine.remove(0);
        try {
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
                CommandOutput commandOutput;
                commandOutput = command.execute();
                for(String line : commandOutput.getResponse())
                    this.terminal.writeLine(line);
            }
            catch (IncorrectDataExceptoin e)
            {
                this.terminal.writeLine("command not understood");
            }
            catch (CannotReadCityException e)
            {
                this.terminal.writeLine("конец файла");
            }
            catch (NoSuchElementException e){
                try {
                    this.terminal.closeStream();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                System.exit(0);
            }
            catch (RuntimeException | FileNotFoundException e)
            {
                this.terminal.writeLine(e.getMessage());
                this.terminal.writeLine("команда не выполнена");
            } catch (Exception e) {
                isRunning=false;
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
    public CommandArray getCommandArray ()
    {
        return this.commandArray;
    }
}
