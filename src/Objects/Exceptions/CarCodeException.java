package Objects.Exceptions;
/**
 * Класс расширяющий ArgumentCityException означающий ошибку с carCode
 * @see
 * @author vladimir
 */
public class CarCodeException extends ArgumentCityException{
    public CarCodeException(String msg, int argumentNumber){
        super(msg, argumentNumber);
    }
    public CarCodeException(String msg, Throwable cause, int argumentNumber){
        super(msg, cause, argumentNumber);
    }
}
