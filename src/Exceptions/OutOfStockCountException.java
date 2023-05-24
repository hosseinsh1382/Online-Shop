package Exceptions;

public class OutOfStockCountException extends InvalidBuyException{
    public OutOfStockCountException() {
        super("Count is out of Stock");
    }
}
