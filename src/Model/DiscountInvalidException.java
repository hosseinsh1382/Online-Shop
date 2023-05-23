package Model;

public class DiscountInvalidException extends DiscountException {
    public DiscountInvalidException() {
        super("Invalid discount code");
    }
}
