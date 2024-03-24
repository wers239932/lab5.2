package Objects.Exceptions;

public class IncorrectDataExceptoin extends RuntimeException{
    public IncorrectDataExceptoin(String msg){
        super(msg);
    }
    public IncorrectDataExceptoin(String msg, Throwable cause){
        super(msg, cause);
    }
}
