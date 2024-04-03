package Server;

import dataExchange.Message;

public class ServerMessageReceiver {
    private Message message;
    private Boolean messageReceived;
    private Boolean isOn;
    private ServerMessageDecoder serverMessageDecoder;
    public ServerMessageReceiver(){}

    public void setMessage(Message message) {
        this.message = message;
        this.messageReceived=false;
    }
    public void startReceiver()
    {
        this.isOn=true;
        while (isOn)
        {
            if(!this.messageReceived)
            {
                this.messageReceived=true;
                this.serverMessageDecoder.DecodeMessage(message);
            }
        }
    }
}
