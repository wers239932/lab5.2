import Objects.Exceptions.*;
import Server.CommandExecuter;
import Server.FileManagement.CSVLoader;
import Server.Storage;
import Server.Terminal.Terminal;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws CoordinatesException, AreaException, GovernmentException, GovernorException, HeightException, CarCodeException, PopulationException, IOException, NameCityException, CapitalException {
        Terminal terminal=new Terminal();
        CommandExecuter commandExecuter = new CommandExecuter(terminal,terminal);
        CSVLoader csvLoader;

        try {
            csvLoader = new CSVLoader(new File(System.getenv("SAVEFILE")));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        Storage storage = csvLoader.loadStorage();
        commandExecuter.setStorage(storage);
        commandExecuter.startSession();
    }
}