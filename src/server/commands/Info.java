package server.commands;

import server.Storage;
import server.utilities.CommandOutput;

import java.util.ArrayList;

public class Info extends Command implements CommandUsingStorage{
    private Storage storage;
    public Info()
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
        response.add("Дата созданиия: "+storage.getCreationDate().toString());
        response.add("количество элементов в памяти: "+storage.size());
        return new CommandOutput(response);
    }
}
