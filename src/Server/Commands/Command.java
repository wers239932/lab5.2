package Server.Commands;

import Objects.City;
import Server.Storage;
import Server.Terminal.CommandOutput;
import Server.Terminal.Terminal;

import java.io.FileNotFoundException;

public abstract class Command {
    protected Boolean needObject;
    protected Boolean needlines;
    protected Boolean needStorage;
    protected Boolean needTerminal;

    public CommandOutput execute() throws FileNotFoundException { return null;    }

    public Boolean getNeedObject() {
        return needObject;
    }

    public Boolean getNeedlines() {
        return needlines;
    }
    public Boolean getNeedStorage(){return needStorage;}
    public Boolean getNeedTerminal(){return needTerminal;}
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
}
