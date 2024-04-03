package ui;

import dataExchange.Message;

public class ClientMessageReciever {
    private Message message;
    private Boolean messageReceived;
    private Boolean isOn;
    private ClientMessageDecoder clientMessageDecoder;
    public ClientMessageReciever(){}

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
                this.clientMessageDecoder.DecodeMessage(message);
            }
        }
    }
}
