package Server.Commands;

import Objects.City;
import Server.Storage;
import Server.Terminal.CommandOutput;

import java.util.ArrayList;

public class Remove_all_by_car_code extends Command{
    private Storage storage;
    private Long carCode;
    public Remove_all_by_car_code()
    {
        needlines=true;
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
