package Exceptions;

public class DiscountExpiredException extends DiscountException {
    public DiscountExpiredException() {
        super("This code has been expired!");
    }
}
