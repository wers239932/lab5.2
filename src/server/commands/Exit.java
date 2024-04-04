package server.commands;

import server.utilities.CommandOutput;

public class Exit extends Command {
    public Exit(){
        this.description = "exit : завершить программу (без сохранения в файл)";
    }

    @Override
    public CommandOutput execute() {
        System.exit(0);
        return null;
    }
}
