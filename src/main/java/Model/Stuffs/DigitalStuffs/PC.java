package Model.Stuffs.DigitalStuffs;

public class PC extends DigitalStuff {
    private String CPUModel, RAMCapacity;

    public PC(String name, double price, int count, double weight, double width, double height, double length, String CPUModel, String RAMCapacity) {
        super(name, price, count, weight, width, height, length);
        this.CPUModel = CPUModel;
        this.RAMCapacity = RAMCapacity;
    }

    public String getCPUModel() {
        return CPUModel;
    }

    public void setCPUModel(String CPUModel) {
        this.CPUModel = CPUModel;
    }

    public String getRAMCapacity() {
        return RAMCapacity;
    }

    public void setRAMCapacity(String RAMCapacity) {
        this.RAMCapacity = RAMCapacity;
    }

    @Override
    public String toString() {
        return "PC{" +
                "CPUModel='" + CPUModel + '\'' +
                ", RAMCapacity='" + RAMCapacity + '\'' +
                "} " + super.toString();
    }
}
