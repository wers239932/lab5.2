package Server.Commands;

import Objects.City;
import Server.Storage;
import Server.Terminal.CommandOutput;

import java.util.ArrayList;

public class Sum_of_car_code extends Command implements CommandUsingStorage{
    private Storage storage;
    public Sum_of_car_code()
    {

    }
    @Override
    public void addStorage(Storage storage)
    {
        this.storage=storage;
    }
    @Override
    public CommandOutput execute() {
        Long sum= 0L;
        ArrayList<String> response = new ArrayList<>();
        for(Object city2:storage)
        {
            City city1=(City) city2;
            sum+=city1.getCarCode();
        }
        response.add("сумма carcode по всем объектам равна " + sum);
        return new CommandOutput(response);
    }
}
