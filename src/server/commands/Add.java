package server.commands;

import objectSpace.City;
import server.Storage;
import server.utilities.CommandOutput;

import java.util.ArrayList;

public class Add extends Command implements CommandUsingObject, CommandUsingStorage{
    private City city;
    private Storage storage;
    public Add()
    {
        this.description = "add {element} : добавить новый элемент в коллекцию";
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
        this.storage.add(city);
        ArrayList<String> response = new ArrayList<>();
        response.add("added city");
        return new CommandOutput(new ArrayList<>());
    }
}
