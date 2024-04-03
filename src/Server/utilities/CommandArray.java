package Server.utilities;

import Server.commands.Command;

import java.util.HashMap;

/**
 * map названий команд и их экземпляров
 */
public class CommandArray extends HashMap<String, Class> {
    public CommandArray()
    {
        super();
    }
    public void addCommand(String[] names, Class commandClass)
    {
        for (String name : names)
        {
            this.put(name, commandClass);
        }
    }
    public void removeCommand(String[] names)
    {
        for (String name : names)
        {
            this.remove(name);
        }
    }
}
