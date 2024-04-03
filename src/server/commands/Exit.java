package server.commands;

import server.utilities.CommandOutput;

public class Exit extends Command {
    public Exit(){

    }

    @Override
    public CommandOutput execute() {
        System.exit(0);
        return null;
    }
}
