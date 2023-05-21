package Model.User;

import Model.Stuffs.Stuff;

public class CartItem {
    private Stuff stuff;
    private int count;
    private double totalPrice;

    public CartItem(Stuff stuff, int count) {
        this.stuff = stuff;
        this.count = count;
        this.totalPrice = this.stuff.getPrice() * this.count;
    }

    public double getTotalPrice() {
        return stuff.getPrice() * count;
    }

    public int getCount() {
        return count;
    }

    public Stuff getStuff() {
        return stuff;
    }

    @Override
    public String toString() {
        return "stuff: " + stuff +
                ", count: " + count +
                ", totalPrice: " + totalPrice;
    }
}
