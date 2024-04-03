package Server.commands;

import objectSpace.City;
import Server.utilities.CommandExecuter;
import Server.Storage;
import Server.utilities.CommandOutput;
import ui.Terminal;

import java.io.FileNotFoundException;

public abstract class Command {

    public CommandOutput execute() throws FileNotFoundException { return null;    }


    public void addParam(String param)
    {

    }
    public void addObject(City city)
    {

    }
    public void addStorage(Storage storage)
    {

    }
    public void addTerminal(Terminal terminal)
    {

    }
    public void addCommandExecuter(CommandExecuter commandExecuter)
    {

    }
}
