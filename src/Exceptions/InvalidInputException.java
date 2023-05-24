package Exceptions;

public class InvalidInputException extends Exception {
    public InvalidInputException(String message) {
        super(message);
    }

    public String toString() {
        return "Invalid input - " + super.toString();
    }
}
