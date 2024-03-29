package Server.Commands;

import Server.Storage;
import Server.Terminal.CommandOutput;

import java.util.ArrayList;

public class Show extends Command implements CommandUsingStorage{
    private Storage storage;
    public Show()
    {

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
