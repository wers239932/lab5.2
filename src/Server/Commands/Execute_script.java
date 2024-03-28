package Server.Commands;

import Server.CommandExecuter;
import Server.FileManagement.CommandFileReader;
import Server.FileManagement.FileReaderer;
import Server.Storage;
import Server.Terminal.CommandOutput;
import Server.Terminal.Terminal;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Execute_script extends Command{
    private FileReaderer fileReaderer;
    private String scriptName;
    private Terminal terminal;
    private Storage storage;
    public Execute_script()
    {
        needlines=true;
        needObject=false;
        needStorage=true;
        needTerminal=true;
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
    public CommandOutput execute() {
        this.fileReaderer = new CommandFileReader(scriptName);
        try {
            this.fileReaderer.openFile();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        CommandExecuter commandExecuter = new CommandExecuter(terminal,this.fileReaderer);
        commandExecuter.setStorage(storage);
        commandExecuter.startSession();
        try {
            this.fileReaderer.closeStream();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return new CommandOutput(new ArrayList<>());
    }
}
