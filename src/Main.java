import objectSpace.exceptions.*;
import server.utilities.CommandExecuter;
import server.fileManagement.CSVLoader;
import server.Storage;
import server.utilities.invokerLike.CommandMetaData;
import ui.Terminal;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws CoordinatesException, AreaException, GovernmentException, GovernorException, HeightException, CarCodeException, PopulationException, IOException, NameCityException, CapitalException {
        CommandMetaData.setMetaData();
        Terminal terminal = new Terminal();
        CommandExecuter commandExecuter = new CommandExecuter(terminal,terminal, new LinkedList<>());
        CSVLoader csvLoader;
        try {
            System.out.println(System.getenv("SAVEFILE"));
            csvLoader = new CSVLoader(new File(System.getenv("SAVEFILE")));
            Storage storage = csvLoader.loadStorage();
            commandExecuter.setStorage(storage);
        } catch (Exception e) {
            Storage storage = new Storage();
            commandExecuter.setStorage(storage);
            throw new RuntimeException(e);
        }
        commandExecuter.startSession();
    }
}