package server.utilities.invokerLike;

import server.commands.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

/**
 * map названий команд и их экземпляров
 */
public class CommandArray {
    private HashMap<String, Class> map;
    public CommandArray()
    {
        map = new HashMap<String, Class>();
    }
    public void addCommand(String[] names, Class commandClass)
    {
        for (String name : names)
        {
            map.put(name, commandClass);
        }
    }
    public void addCommand(String[] names, Class<? extends Command> commandClass, ArrayList<Boolean> data)
    {
        this.addCommand(names,commandClass);
        CommandMetaData.addCommandData(commandClass,data);
    }
    public void setCommands()
    {
        this.addCommand(new String[]{"exit"}, Exit.class);
        this.addCommand(new String[]{"help"}, Help.class);
        this.addCommand(new String[]{"add"}, Add.class);
        this.addCommand(new String[]{"write"}, OutputCommand.class);
        this.addCommand(new String[]{"show"}, Show.class);
        this.addCommand(new String[]{"save"}, Save.class);
        this.addCommand(new String[]{"info"}, Info.class);
        this.addCommand(new String[]{"update"}, Update.class);
        this.addCommand(new String[]{"execute_script"}, ExecuteScript.class);
        this.addCommand(new String[]{"remove_by_id"}, RemoveById.class);
        this.addCommand(new String[]{"clear"}, Clear.class);
        this.addCommand(new String[]{"remove_first"}, RemoveFirst.class);
        this.addCommand(new String[]{"remove_greater"}, RemoveGreater.class);
        this.addCommand(new String[]{"remove_lower"}, RemoveLower.class);
        this.addCommand(new String[]{"remove_all_by_car_code"}, RemoveAllByCarCode.class);
        this.addCommand(new String[]{"sum_of_car_code"}, SumOfCarCode.class);
        this.addCommand(new String[]{"count_greater_than_capital"}, CountGreaterThanCapital.class);
    }
    public Class get(String commandName)
    {
        return this.map.get(commandName);
    }
    public Collection values()
    {
        return this.map.values();
    }
}