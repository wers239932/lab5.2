package Server.commands;

import ui.Terminal;

/**
 * интерфейс для комманд которым требуется доступ к терминалу
 */
public interface CommandUsingTerminal {
    public void addTerminal(Terminal terminal);

}
