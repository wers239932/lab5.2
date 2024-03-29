package Server.Commands;

import Server.CommandExecuter;

/**
 * интерфейс для комманд которым требуется параметр - слово после названия команды
 */
public interface CommandUsingLine {
    public void addParam(String param);

}
