package Exceptions;

public class InvalidPhoneException extends InvalidInputException {
    public InvalidPhoneException() {
        super("Invalid phone number");
    }
}
