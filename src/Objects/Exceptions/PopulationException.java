package Objects.Exceptions;
/**
 * Класс расширяющий ArgumentCityException означающий ошибку с населением
 * @see
 * @author vladimir
 */
public class PopulationException extends ArgumentCityException{

    public PopulationException(String msg, int argumentNumber){
        super(msg, argumentNumber);
    }

    public PopulationException(String msg, Throwable cause, int argumentNumber){
        super(msg, cause, argumentNumber);
    }

}
