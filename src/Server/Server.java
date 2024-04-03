package Server;

import dataExchange.Message;
import ui.ClientMessageReciever;
import ui.CommandCreator;

public class Server {
    private Boolean isOn;

    public void startSession()
    {
        isOn=true;
        while (isOn)
        {

        }
    }
    public void sendMessage(Message message, ClientMessageReciever clientMessageReciever)
    {
        clientMessageReciever.setMessage(message);
    }
}
