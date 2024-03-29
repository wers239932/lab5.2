package Objects.Exceptions;
/**
 * Класс расширяющий ArgumentCityException означающий ошибку с высотой над уровнем моря
 * @see
 * @author vladimir
 */
public class HeightException extends ArgumentCityException{
    public HeightException(String msg, int argumentNumber){
        super(msg, argumentNumber);
    }
    public HeightException(String msg, Throwable cause, int argumentNumber){
        super(msg, cause, argumentNumber);
    }

}
