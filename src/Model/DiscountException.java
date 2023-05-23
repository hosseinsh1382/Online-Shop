package Model;

public class DiscountException extends Exception {
    public DiscountException(String message) {
        super(message);
    }

    @Override
    public String toString() {
        return "Unable to use: " + getMessage();
    }
}
