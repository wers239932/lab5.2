package server.commands;

import objectSpace.City;
import server.Storage;
import server.utilities.CommandOutput;

import java.util.ArrayList;

public class RemoveLower extends Command implements CommandUsingObject, CommandUsingStorage{
    private City city;
    private Storage storage;
    public RemoveLower()
    {

    }
    @Override
    public void addObject(City city)
    {
        this.city=city;
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
            City city1=(City) city2;
            if(city1.compareTo(city)<0)
            {
                storage.remove(city2);
            }
        }
        return new CommandOutput(response);
    }
}
