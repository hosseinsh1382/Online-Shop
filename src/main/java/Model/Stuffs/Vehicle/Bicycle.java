package Model.Stuffs.Vehicle;

public class Bicycle extends Vehicle {
    public enum BicycleType {
        MOUNTAIN, ROAD, CITY, HYBRID
    }

    private BicycleType bicycleType;

    public Bicycle(String name, double price, int count, String companyName, BicycleType bicycleType) {
        super(name, price, count, companyName);
        this.bicycleType = bicycleType;
    }

    public BicycleType getBicycleType() {
        return bicycleType;
    }

    public void setBicycleType(BicycleType bicycleType) {
        this.bicycleType = bicycleType;
    }

    @Override
    public String toString() {
        return super.toString() +
                "bicycleType: " + bicycleType;
    }
}
