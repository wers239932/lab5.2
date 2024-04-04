package server.commands;

import server.utilities.CommandOutput;

import java.util.ArrayList;

public class OutputCommand extends Command implements CommandUsingLine{
    private String line;
    public OutputCommand()
    {
        this.description = "write : пишет первое слово ввода";
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
