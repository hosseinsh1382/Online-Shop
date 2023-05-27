package Exceptions;

public class InvalidBuyException extends Exception {
    public InvalidBuyException(String message) {
        super(message);
    }

    @Override
    public String toString() {
        return "Buy failed - " + super.toString();
    }
}
