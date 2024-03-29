package Server.Commands;

import Server.FileManagement.CSVSaver;
import Server.Storage;
import Server.Terminal.CommandOutput;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Save extends Command implements CommandUsingStorage{
    private Storage storage;
    public Save()
    {

    }
    @Override
    public void addStorage(Storage storage)
    {
        this.storage=storage;
    }
    @Override
    public CommandOutput execute() {
        String filepath = System.getenv("SAVEFILE");
        CSVSaver saver = new CSVSaver();
        try {
            saver.save(filepath,storage);
            return new CommandOutput(new ArrayList<String>());
        } catch (IOException e) {
            return new CommandOutput(new ArrayList<String>());
        }

    }
}
