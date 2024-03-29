package Server.Commands;

import Server.FileManagement.CSVSaver;
import Server.Storage;
import Server.Terminal.CommandOutput;

import java.io.IOException;
import java.util.ArrayList;

public class Remove_first extends Command implements CommandUsingStorage{
    private Storage storage;
    public Remove_first()
    {

    }
    @Override
    public void addStorage(Storage storage)
    {
        this.storage=storage;
    }
    @Override
    public CommandOutput execute() {
        this.storage.remove(0);
        return new CommandOutput(new ArrayList<>());
    }
}
