package Server.Commands;

import Server.Storage;
import Server.Terminal.CommandOutput;

import java.util.ArrayList;

public class Info extends Command{
    private Storage storage;
    public Info()
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
        response.add("Дата созданиия: "+storage.getCreationDate().toString());
        response.add("количество элементов в памяти: "+storage.size());
        return new CommandOutput(response);
    }
}
