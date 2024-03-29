package Server.commands;

import Server.ui.Terminal;

/**
 * интерфейс для комманд которым требуется доступ к терминалу
 */
public interface CommandUsingTerminal {
    public void addTerminal(Terminal terminal);

}
