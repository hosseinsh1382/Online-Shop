package Model.Stuffs.Vehicle;

import Model.Stuffs.Stuff;

public abstract class Vehicle extends Stuff {
    private String companyName;

    public Vehicle(String name, double price, int count, String companyName) {
        super(name, price, count, Category.VEHICLE);
        this.companyName = companyName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public String toString() {
        return super.toString() +
                "companyName='" + companyName + '\'' +
                '}';
    }
}
