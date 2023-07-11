package Exceptions;

public class InvalidEmailException extends InvalidInputException{
    public InvalidEmailException(){
        super("Invalid email address");
    }
}
