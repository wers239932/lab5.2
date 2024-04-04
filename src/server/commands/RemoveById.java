package server.commands;

import objectSpace.City;
import server.Storage;
import server.utilities.CommandOutput;

import java.util.ArrayList;

public class RemoveById extends Command implements CommandUsingLine, CommandUsingStorage{
    private Storage storage;
    private int id;
    public RemoveById()
    {
        this.description = "remove_by_id id : удалить элемент из коллекции по его id";
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
        response.add("Object removed");
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
