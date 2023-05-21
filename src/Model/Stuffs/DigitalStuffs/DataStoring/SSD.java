package Model.Stuffs.DigitalStuffs.DataStoring;

public class SSD extends DataStoring {
    private double readSpeed, writeSpeed;

    public SSD(String name, double price, int count, double weight, double width, double height, double length, int capacity, double readSpeed, double writeSpeed) {
        super(name, price, count, weight, width, height, length, capacity);
        this.readSpeed = readSpeed;
        this.writeSpeed = writeSpeed;
    }

    public double getReadSpeed() {
        return readSpeed;
    }

    public void setReadSpeed(double readSpeed) {
        this.readSpeed = readSpeed;
    }

    public double getWriteSpeed() {
        return writeSpeed;
    }

    public void setWriteSpeed(double writeSpeed) {
        this.writeSpeed = writeSpeed;
    }

    @Override
    public String toString() {
        return super.toString() +
                "readSpeed: " + readSpeed +
                ", writeSpeed: " + writeSpeed;
    }
}
