package Model.Stuffs.DigitalStuffs.DataStoring;

public class USB extends DataStoring {
    private String version;

    public USB(String name, double price, int count, double weight, double width, double height, double length, int capacity, String version) {
        super(name, price, count, weight, width, height, length, capacity);
        this.version = version;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return super.toString()+
                "version='" + version + '\'';
    }
}
