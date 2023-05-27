package Exceptions;

public class OutOfCreditException extends InvalidBuyException {
    public OutOfCreditException() {
        super("Not enough credit");
    }
}
