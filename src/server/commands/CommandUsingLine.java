package server.commands;

/**
 * интерфейс для комманд которым требуется параметр - слово после названия команды
 */
public interface CommandUsingLine {
    public void addParam(String param);

}
