package Model.Stuffs.Stationary;

import Model.IDiscountable;

public class Pen extends Stationary implements IDiscountable {
    private String color;
    public Pen(String name, double price, int count, String producerCountry, String color) {
        super(name, price, count, producerCountry);
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return super.toString() +
                "color: " + color;
    }

    @Override
    public void addDiscount(double discountPercent) {
        this.setPrice(this.getPrice()*(100-this.getPrice()));
    }

}
