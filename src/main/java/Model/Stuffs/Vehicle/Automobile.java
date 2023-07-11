package Model.Stuffs.Vehicle;

public class Automobile extends Vehicle {
    private int motorCapacity;
    private boolean isAutomate;

    public Automobile(String name, double price, int count, String companyName, int motorCapacity, boolean isAutomate) {
        super(name, price, count, companyName);
        this.motorCapacity = motorCapacity;
        this.isAutomate = isAutomate;
    }


    public int getMotorCapacity() {
        return motorCapacity;
    }

    public void setMotorCapacity(int motorCapacity) {
        this.motorCapacity = motorCapacity;
    }

    public boolean getIsAutomate() {
        return isAutomate;
    }

    public void setAutomate(boolean automate) {
        isAutomate = automate;
    }

    @Override
    public String toString() {
        return super.toString() +
                "motorCapacity=" + motorCapacity +
                ", isAutomate=" + isAutomate;
    }

}
