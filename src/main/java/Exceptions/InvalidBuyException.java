package Exceptions;

public class InvalidBuyException extends Exception {
    public InvalidBuyException(String message) {
        super("Buy failed - "+ message);
    }


}
