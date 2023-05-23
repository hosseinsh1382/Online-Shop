package Model;

public class DiscountFullCapacityException extends DiscountException {
    public DiscountFullCapacityException() {
        super("Capacity of this code is full!");
    }
}
