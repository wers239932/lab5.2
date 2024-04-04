package server.commands;

import server.Storage;
import server.utilities.CommandOutput;

import java.util.ArrayList;

public class Show extends Command implements CommandUsingStorage{
    private Storage storage;
    public Show()
    {
        this.description = "show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении";
    }
    @Override
    public void addStorage(Storage storage)
    {
        this.storage=storage;
    }
    @Override
    public CommandOutput execute() {
        ArrayList<String> response = new ArrayList<>();
        for(Object city:storage)
        {
            response.add(city.toString());
        }
        return new CommandOutput(response);
    }
}
