package Model.Stuffs.Stationary;

public class Pen extends Stationary {
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
}
