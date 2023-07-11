package Exceptions;

public class InvalidInputException extends Exception {
    public InvalidInputException(String message) {
        super("Invalid input - " +message);
    }
}
