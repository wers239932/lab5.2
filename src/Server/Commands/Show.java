package Server.Commands;

import Server.Storage;
import Server.Terminal.CommandOutput;

import java.util.ArrayList;

public class Show extends Command{
    private Storage storage;
    public Show()
    {
        needlines=false;
        needObject=false;
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
    public CommandOutput execute() {
        ArrayList<String> response = new ArrayList<>();
        for(Object city:storage)
        {
            response.add(city.toString());
        }
        return new CommandOutput(response);
    }
}
