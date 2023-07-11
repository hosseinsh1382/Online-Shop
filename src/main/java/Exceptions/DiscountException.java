package Exceptions;

public class DiscountException extends Exception {
    public DiscountException(String message) {
        super("Unable to use: " + message);
    }
}
