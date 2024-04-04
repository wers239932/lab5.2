package server.utilities;

import java.util.ArrayList;

/**
 * текстовый результат выполнения команды
 */
public class CommandOutput {

    private final ArrayList<String> response;

    public CommandOutput(ArrayList<String> response) {
        this.response = response;
    }

    public ArrayList<String> getResponse(){
        return this.response;
    }
}
