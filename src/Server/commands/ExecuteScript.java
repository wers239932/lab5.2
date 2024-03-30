package Server.commands;

import Server.utilities.CommandExecuter;
import Server.fileManagement.CommandFileReader;
import Server.fileManagement.FileReaderer;
import Server.Storage;
import Server.utilities.CommandOutput;
import Server.ui.Terminal;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class ExecuteScript extends Command implements CommandUsingLine, CommandUsingStorage, CommandUsingCommandExecuter, CommandUsingTerminal{
    private FileReaderer fileReaderer;
    private String scriptName;
    private Terminal terminal;
    private Storage storage;
    private CommandExecuter commandExecuter;
    public ExecuteScript()
    {

    }
    @Override
    public void addStorage(Storage storage)
    {
        this.storage=storage;
    }
    @Override
    public void addParam(String line)
    {
        this.scriptName=line;
    }
    @Override
    public void addTerminal(Terminal terminal)
    {
        this.terminal=terminal;
    }
    @Override
    public void addCommandExecuter(CommandExecuter commandExecuter)
    {
        this.commandExecuter=commandExecuter;
    }

    @Override
    public CommandOutput execute() {
        Boolean recursion=false;
        for(String scriptNamePrevious: commandExecuter.getScriptNames())
        {
            if(scriptNamePrevious.equals(scriptName))
            {
                recursion=true;
            }
        }
        if(!recursion) {
            this.commandExecuter.addScriptName(scriptName);
            this.fileReaderer = new CommandFileReader(scriptName);
            try {
                this.fileReaderer.openFile();
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            CommandExecuter commandExecuter = new CommandExecuter(terminal, this.fileReaderer, this.commandExecuter.getScriptNames()); //
            commandExecuter.setStorage(storage);
            commandExecuter.startSession();
            try {
                this.fileReaderer.closeStream();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            this.commandExecuter.removeScriptName();
            return new CommandOutput(new ArrayList<>());
        }
        else
        {
            ArrayList<String> response = new ArrayList<>();
            response.add("cannot execute recursively");
            return new CommandOutput (response);
        }
    }
}
