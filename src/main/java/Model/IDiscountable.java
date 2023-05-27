package Model;

public interface IDiscountable {
    void addDiscount(double discountPercent);

    default void removeDiscount() {
        addDiscount(0);
    }
}
