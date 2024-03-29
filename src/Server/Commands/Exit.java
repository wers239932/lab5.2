package Server.Commands;

import Server.Terminal.CommandOutput;
import Server.Terminal.Terminal;

public class Exit extends Command {
    public Exit(){
        needlines=false;
        needObject=false;
        needStorage=false;
        needTerminal=false;
        needCommandExecuter=false;
    }

    @Override
    public CommandOutput execute() {
        System.exit(0);
        return null;
    }
}
