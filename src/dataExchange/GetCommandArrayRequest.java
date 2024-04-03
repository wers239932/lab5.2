package dataExchange;

import ui.Client;

public class GetCommandArrayRequest extends Message{
    private Client client;
    public GetCommandArrayRequest(Client client)
    {
        this.client=client;
    }
}
