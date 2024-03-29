package Objects.Exceptions;
/**
 * Класс расширяющий ArgumentCityException означающий ошибку со столицей
 * @see
 * @author vladimir
 */
public class CapitalException extends ArgumentCityException{
    public CapitalException(String msg, int argumentNumber){
        super(msg, argumentNumber);
    }
    public CapitalException(String msg, Throwable cause, int argumentNumber){
        super(msg, cause, argumentNumber);
    }
}
