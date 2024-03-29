package Server.Commands;

import Objects.City;
import Server.CommandExecuter;
import Server.Storage;
import Server.Terminal.CommandMaker;
import Server.Terminal.CommandOutput;
import Server.Terminal.Terminal;

import java.io.FileNotFoundException;

public abstract class Command { //TODO HUINA razdelit na CommandUsingElement, CommandUsingId and e.t.c.
    protected Boolean needObject;
    protected Boolean needlines;
    protected Boolean needStorage;
    protected Boolean needTerminal;
    protected Boolean needCommandExecuter;

    public CommandOutput execute() throws FileNotFoundException { return null;    }

    public Boolean getNeedObject() {
        return needObject;
    }

    public Boolean getNeedlines() {
        return needlines;
    }
    public Boolean getNeedStorage(){return needStorage;}
    public Boolean getNeedTerminal(){return needTerminal;}
    public Boolean getNeedCommandExecuter()
    {
        return needCommandExecuter;
    }
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
