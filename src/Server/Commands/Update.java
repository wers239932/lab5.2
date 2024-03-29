package Server.Commands;

import Objects.City;
import Server.Storage;
import Server.Terminal.CommandOutput;

import java.util.ArrayList;

public class Update extends Command {
    private Storage storage;
    private int id;
    private City city;
    public Update()
    {
        needlines=true;
        needObject=true;
        needStorage=true;
        needTerminal=false;
        needCommandExecuter=false;
    }
    @Override
    public void addStorage(Storage storage)
    {
        this.storage=storage;
    }
    @Override
    public void addObject(City city)
    {
        this.city=city;
    }
    @Override
    public void addParam(String line)
    {
        this.id=Integer.parseInt(line);
    }
    @Override
    public CommandOutput execute() {
        ArrayList<String> response = new ArrayList<>();
        for(Object city2:storage)
        {
            City city1=(City) city2;
            if(city1.getId()==id)
            {
                storage.remove(city2);
                storage.add(city);
            }
        }
        return new CommandOutput(response);
    }
}
