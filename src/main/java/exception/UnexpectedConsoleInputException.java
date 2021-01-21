package exception;

public class UnexpectedConsoleInputException extends RuntimeException{
    public UnexpectedConsoleInputException(String message){
        super(message);
    }
}
