package Model;

import Model.Stuffs.Stuff;

public interface IDiscountable {
    public void addDiscount(double discountPercent);

    default public void removeDiscount() {
        addDiscount(0);
    }
}
