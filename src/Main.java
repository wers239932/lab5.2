import objectSpace.exceptions.*;
import server.Server;
import server.ServerMessageReceiver;
import server.utilities.CommandExecuter;
import server.fileManagement.CSVLoader;
import server.Storage;
import ui.Client;
import ui.ClientMessageReciever;
import ui.Terminal;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws CoordinatesException, AreaException, GovernmentException, GovernorException, HeightException, CarCodeException, PopulationException, IOException, NameCityException, CapitalException {
        ClientMessageReciever clientMessageReciever = new ClientMessageReciever();
        ServerMessageReceiver serverMessageReceiver = new ServerMessageReceiver();
        Client client = new Client(clientMessageReciever);
        Server server = new Server(serverMessageReceiver);
        server.startSession(clientMessageReciever);
        client.startClient(serverMessageReceiver);
    }
}