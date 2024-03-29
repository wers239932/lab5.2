package Server.commands;

import objectSpace.City;
import Server.Storage;
import Server.utilities.CommandOutput;

import java.util.ArrayList;

public class CountGreaterThanCapital extends Command implements CommandUsingStorage, CommandUsingLine{
    private Storage storage;
    private Boolean capital;
    public CountGreaterThanCapital()
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
        this.capital=Boolean.parseBoolean(line);
    }
    @Override
    public CommandOutput execute() {
        int amount=0;
        ArrayList<String> response = new ArrayList<>();
        for(Object city2:storage)
        {
            City city1=(City) city2;
            if(city1.getCapital().compareTo(capital)>0)
            {
                amount++;
            }
        }
        response.add("количество объектов с полем carCode больше заданного равно " + amount);
        return new CommandOutput(response);
    }
}
