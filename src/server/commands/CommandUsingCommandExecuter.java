package server.commands;

import server.utilities.CommandExecuter;

/**
 * интерфейс для комманд которым требуется доступ к CommandExecuter в котором они выполняются
 * @see CommandExecuter
 */
public interface CommandUsingCommandExecuter {
    public void addCommandExecuter(CommandExecuter commandExecuter);

}
