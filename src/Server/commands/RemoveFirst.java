package Server.commands;

import Server.Storage;
import Server.utilities.CommandOutput;

import java.util.ArrayList;

public class RemoveFirst extends Command implements CommandUsingStorage{
    private Storage storage;
    public RemoveFirst()
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
