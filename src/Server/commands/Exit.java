package Server.commands;

import Server.utilities.CommandOutput;

public class Exit extends Command {
    public Exit(){

    }

    @Override
    public CommandOutput execute() {
        System.exit(0);
        return null;
    }
}
