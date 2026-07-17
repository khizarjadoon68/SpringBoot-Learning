package in.strikes.crudSpringBoot.exception;

public class duplicateResourceException extends RuntimeException{

    public duplicateResourceException(String message){
        super(message);
    }

}
