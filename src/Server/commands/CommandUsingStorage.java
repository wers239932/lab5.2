package Server.commands;

import Server.Storage;
/**
 * интерфейс для комманд которым требуется доступ к памяти
 * @see Storage
 */
public interface CommandUsingStorage {
    public void addStorage(Storage storage);

}
