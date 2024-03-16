package Server.Commands;

import Objects.City;
import Server.Storage;
import Server.Terminal.CommandOutput;

import java.util.ArrayList;

public class Remove_by_id extends Command{
    private Storage storage;
    private int id;
    public Remove_by_id()
    {
        needlines=true;
        needObject=false;
        needStorage=true;
        needTerminal=false;
    }
    @Override
    public void addStorage(Storage storage)
    {
        this.storage=storage;
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
            }
        }
        return new CommandOutput(response);
    }
}
