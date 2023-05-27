package Model.Stuffs.Stationary;

import Model.IDiscountable;

public class Pencil extends Stationary implements IDiscountable {
    public enum PencilModel {
        HB, B, F, H, H2
    }

    private PencilModel pencilModel;

    public Pencil(String name, double price, int count, String producerCountry, PencilModel pencilModel) {
        super(name, price, count, producerCountry);
        this.pencilModel = pencilModel;
    }

    public PencilModel getPencilModel() {
        return pencilModel;
    }

    public void setPencilModel(PencilModel pencilModel) {
        this.pencilModel = pencilModel;
    }


    @Override
    public String toString() {
        return super.toString() +
                "pencilModel: " + pencilModel;
    }

    @Override
    public void addDiscount(double discountPercent) {
        this.setPrice(this.getPrice() * (100 - discountPercent));
    }


}