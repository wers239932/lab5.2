package server.commands;

import server.Storage;
import server.utilities.CommandOutput;

import java.util.ArrayList;

public class RemoveFirst extends Command implements CommandUsingStorage{
    private Storage storage;
    public RemoveFirst()
    {
        this.description = "remove_first : удалить первый элемент из коллекции";
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
