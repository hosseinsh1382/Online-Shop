package Model.Stuffs.DigitalStuffs;

import Model.Stuffs.Stuff;

public abstract class DigitalStuff extends Stuff {
    private double weight, width, height, length;

    public DigitalStuff(String name, double price, int count, double weight, double width, double height, double length) {
        super(name, price, count, Category.DIGITALSTUFF);
        this.weight = weight;
        this.width = width;
        this.height = height;
        this.length = length;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return super.toString() +
                "weight=" + weight +
                ", width=" + width +
                ", height=" + height +
                ", length=" + length;
    }
}
