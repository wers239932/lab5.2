package Server.commands;

import objectSpace.City;

/**
 * интерфейс для комманд которым требуется объект коллекции
 * @see City
 */
public interface CommandUsingObject {
    public void addObject(City city);

}
