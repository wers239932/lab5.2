package Server.Commands;

import Objects.City;
import Server.Storage;
import Server.Terminal.CommandOutput;

import java.util.ArrayList;

public class Clear extends Command{
    private Storage storage;
    public Clear()
    {
        needlines=true;
        needObject=true;
        needStorage=true;
        needTerminal=false;
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
