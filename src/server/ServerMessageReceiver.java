package server;

import dataExchange.Message;

public class ServerMessageReceiver {
    private Message message;
    private Boolean messageReceived;
    private Boolean isOn;
    private ServerMessageDecoder serverMessageDecoder;
    public ServerMessageReceiver(ServerMessageDecoder serverMessageDecoder)
    {
        this.serverMessageDecoder = serverMessageDecoder;
    }
    public ServerMessageReceiver()
    {    }
    public void addServerMessageDecoder(ServerMessageDecoder serverMessageDecoder)
    {this.serverMessageDecoder = serverMessageDecoder;}

    public void setMessage(Message message) {
        this.message = message;
        this.messageReceived=false;
    }
    public void startReceiver()
    {
        this.isOn=true;
        this.messageReceived = false;
        while (isOn)
        {
            System.out.println("1.3");
            if(!this.messageReceived)
            {
                this.messageReceived=true;
                this.serverMessageDecoder.DecodeMessage(message);
            }
        }
    }
    public void stopReceiver()
    {this.isOn=false;}
}
