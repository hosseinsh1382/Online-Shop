package Model.Stuffs.Stationary;

import Model.IDiscountable;

public class Pencil extends Stationary implements IDiscountable {
    public enum PencilModel {
        HB, B, F, H, H2
    }

    private PencilModel pencilModel;
    private double discountPercent = 0;

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

    public double getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(double discountPercent) {
        this.discountPercent = discountPercent;
    }

    @Override
    public String toString() {
        return super.toString() +
                "pencilModel: " + pencilModel;
    }

    @Override
    public void addDiscount() {
        this.setPrice(this.getPrice() * (100 - discountPercent));
    }

    @Override
    public void removeDiscount() {
        this.setDiscountPercent(0);
        addDiscount();
    }


}