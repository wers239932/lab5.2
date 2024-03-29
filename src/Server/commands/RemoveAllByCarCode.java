package Server.commands;

import objectSpace.City;
import Server.Storage;
import Server.utilities.CommandOutput;

import java.util.ArrayList;

public class RemoveAllByCarCode extends Command implements CommandUsingLine, CommandUsingStorage{
    private Storage storage;
    private Long carCode;
    public RemoveAllByCarCode()
    {

    }
    @Override
    public void addStorage(Storage storage)
    {
        this.storage=storage;
    }
    @Override
    public void addParam(String line)
    {
        this.carCode=Long.parseLong(line);
    }
    @Override
    public CommandOutput execute() {
        ArrayList<String> response = new ArrayList<>();
        for(Object city2:storage)
        {
            City city1=(City) city2;
            if(city1.getCarCode()==carCode)
            {
                storage.remove(city2);
            }
        }
        return new CommandOutput(response);
    }
}
