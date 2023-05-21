package Model.Stuffs.Stationary;

import Model.Stuffs.Stuff;

public abstract class Stationary extends Stuff {
    private String producerCountry;

    public Stationary(String name, double price, int count, String producerCountry) {
        super(name, price,count, Category.STATIONARY);
        this.producerCountry = producerCountry;
    }

    public String getProducerCountry() {
        return producerCountry;
    }

    public void setProducerCountry(String producerCountry) {
        this.producerCountry = producerCountry;
    }

    @Override
    public String toString() {
        return super.toString() +
                "producerCountry: " + producerCountry ;
    }
}
