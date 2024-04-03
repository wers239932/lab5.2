package server.commands;

import server.Storage;
/**
 * интерфейс для комманд которым требуется доступ к памяти
 * @see Storage
 */
public interface CommandUsingStorage {
    public void addStorage(Storage storage);

}
