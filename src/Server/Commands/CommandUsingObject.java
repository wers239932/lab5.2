package Server.Commands;

import Objects.City;

import java.util.zip.CheckedInputStream;
/**
 * интерфейс для комманд которым требуется объект коллекции
 * @see City
 */
public interface CommandUsingObject {
    public void addObject(City city);

}
