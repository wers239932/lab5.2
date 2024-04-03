package server;

import dataExchange.Message;
import objectSpace.exceptions.*;
import server.fileManagement.CSVLoader;
import server.utilities.CommandMaker;
import ui.Client;
import ui.ClientMessageReciever;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Server {
    private Boolean isOn;
    private ClientMessageReciever clientMessageReciever;
    private ServerMessageReceiver serverMessageReceiver;
    private ServerMessageDecoder serverMessageDecoder;
    private Storage storage;
    private CommandMaker commandMaker;
    public Server(ServerMessageReceiver serverMessageReceiver)
    {
        this.serverMessageReceiver = serverMessageReceiver;
        this.serverMessageDecoder = new ServerMessageDecoder();
        serverMessageReceiver.addServerMessageDecoder(this.serverMessageDecoder);
    }


    public void startSession(ClientMessageReciever clientMessageReciever) {
        this.clientMessageReciever = clientMessageReciever;
        CSVLoader csvLoader;
        try {
            csvLoader = new CSVLoader(new File(System.getenv("SAVEFILE")));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println("1.1");
        try {
            this.storage = csvLoader.loadStorage();
        } catch (IOException | CoordinatesException | AreaException | GovernmentException | GovernorException |
                 HeightException | CarCodeException | PopulationException | NameCityException | CapitalException e) {
            storage = new Storage();
            throw new RuntimeException(e);
        }

        System.out.println("1.2");
        this.serverMessageReceiver.startReceiver();
    }

    public void sendMessage(Message message, ClientMessageReciever clientMessageReciever) {
        clientMessageReciever.setMessage(message);
    }
}
