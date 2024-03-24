package Objects.Exceptions;
/**
 * Класс расширяющий ArgumentCityException означающий ошибку с координатами
 * @see
 * @author vladimir
 */
public class CoordinatesException extends ArgumentCityException{
    public CoordinatesException(String msg, int argumentNumber){
        super(msg, argumentNumber);
    }

    public CoordinatesException(String msg, Throwable cause, int argumentNumber){
        super(msg, cause, argumentNumber);
    }
}
