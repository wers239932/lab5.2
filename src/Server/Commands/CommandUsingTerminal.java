package Server.Commands;

import Server.Terminal.Terminal;

/**
 * интерфейс для комманд которым требуется доступ к терминалу
 */
public interface CommandUsingTerminal {
    public void addTerminal(Terminal terminal);

}
