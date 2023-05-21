package Model.Stuffs.DigitalStuffs.DataStoring;

import Model.Stuffs.DigitalStuffs.DigitalStuff;

public abstract class DataStoring extends DigitalStuff {

    private int capacity;

    public DataStoring(String name, double price, int count, double weight, double width, double height, double length, int capacity) {
        super(name, price, count, weight, width, height, length);
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return super.toString() +
                "capacity: " + capacity ;
    }
}
