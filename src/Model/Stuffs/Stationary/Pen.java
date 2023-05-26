package Model.Stuffs.Stationary;

import Model.IDiscountable;

public class Pen extends Stationary implements IDiscountable {
    private String color;
    private double discountPercent=0;

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
    public double getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(double discountPercent) {
        this.discountPercent = discountPercent;
    }

    @Override
    public String toString() {
        return super.toString() +
                "color: " + color;
    }

    @Override
    public void addDiscount() {
        this.setPrice(this.getPrice() * (100 - discountPercent));
    }

    @Override
    public void removeDiscount() {
        this.setDiscountPercent(0);
        addDiscount();
    }
}
