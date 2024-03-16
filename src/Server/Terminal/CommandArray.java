package Server.Terminal;

import Server.Commands.Command;

import java.util.HashMap;

public class CommandArray extends HashMap<String, Command> {
    public CommandArray()
    {
        super();
    }
    public void addCommand(String[] names, Command command)
    {
        for (String name : names)
        {
            this.put(name, command);
        }
    }
}
