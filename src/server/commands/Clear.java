package server.commands;

import server.Storage;
import server.utilities.CommandOutput;

import java.util.ArrayList;

public class Clear extends Command implements CommandUsingStorage{
    private Storage storage;
    public Clear()
    {
        this.description = "clear : очистить коллекцию";
    }
    @Override
    public void addStorage(Storage storage)
    {
        this.storage=storage;
    }
    @Override
    public CommandOutput execute() {
        ArrayList<String> response = new ArrayList<>();

        for(Object city2:storage)
        {
            storage.remove(city2);
        }
        return new CommandOutput(response);
    }
}
