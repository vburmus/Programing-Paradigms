package lista8_1;

public class EmptyException extends RuntimeException{
    public EmptyException() {
        super();
    }


    public EmptyException(String message){
        super(message);
    }
}
