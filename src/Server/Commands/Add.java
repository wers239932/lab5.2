package Server.Commands;

import Objects.City;
import Server.Storage;
import Server.Terminal.CommandOutput;
import Server.Terminal.Terminal;

import java.util.ArrayList;
import java.util.Arrays;

public class Add extends Command implements CommandUsingObject, CommandUsingStorage{
    private City city;
    private Storage storage;
    public Add()
    {    }
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
