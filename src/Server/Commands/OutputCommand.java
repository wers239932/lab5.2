package Server.Commands;

import Server.Terminal.CommandOutput;
import Server.Terminal.Terminal;

import java.util.ArrayList;

public class OutputCommand extends Command{
    private String line;
    public OutputCommand()
    {
        needlines=true;
        needObject=false;
        needStorage=false;
        needTerminal=false;
    }
    @Override
    public void addParam(String line)
    {
        this.line=line;
    }
    @Override
    public CommandOutput execute() {
        ArrayList<String> response = new ArrayList<>();
        response.add(line);
        return new CommandOutput(response);
    }
}
