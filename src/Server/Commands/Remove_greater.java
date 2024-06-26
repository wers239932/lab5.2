package Server.Commands;

import Objects.City;
import Server.Storage;
import Server.Terminal.CommandOutput;

import java.util.ArrayList;

public class Remove_greater extends Command {
    private City city;
    private Storage storage;
    public Remove_greater()
    {
        needlines=false;
        needObject=true;
        needStorage=true;
        needTerminal=false;
        needCommandExecuter=false;
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
            if(city1.compareTo(city)>0)
            {
                storage.remove(city2);
            }
        }
        return new CommandOutput(response);
    }
}
