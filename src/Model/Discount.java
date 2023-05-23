package Model;

import java.util.ArrayList;
import java.util.Date;

public class Discount {
    private double discount;
    private Date expireDate;
    private int capacity;
    private String discountCode;
    private ArrayList<Category> categories;

    public enum Category {
        DIGITALSTUFF, STATIONARY, VEHICLE, FOOD
    }

    public Discount(double discount, Date expireDate, int capacity, ArrayList<Category> categories) {
        this.discount = discount;
        this.expireDate = expireDate;
        this.capacity = capacity;
        this.categories = categories;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public ArrayList<Category> getCategories() {
        return categories;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }


    public String getDiscountCode() {
        return discountCode;
    }

    public void setDiscountCode(String discountCode) {
        this.discountCode = discountCode;
    }

    public String generateCode() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789" + "abcdefghijklmnopqrstuvwxyz" + "-.?$&@_";
        StringBuilder code = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            int charIndex = (int) (Math.random() * (characters.length()));
            code.append(charIndex);
        }

        return code.toString();
    }
}