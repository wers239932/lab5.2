package Server.Commands;

import Objects.City;
import Server.Storage;
import Server.Terminal.CommandOutput;

import java.util.ArrayList;

public class Clear extends Command implements CommandUsingStorage{
    private Storage storage;
    public Clear()
    {

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
