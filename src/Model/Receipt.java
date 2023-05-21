package Model;

import Model.User.CartItem;

import java.sql.Date;
import java.util.ArrayList;

public class Receipt {
    private static int staticReceiptId = 0;
    private int receiptId;
    private Date buyDate;
    private double price;
    private ArrayList<CartItem> boughtStuffs;

    public Receipt(double price, ArrayList<CartItem> boughtStuffs) {

        buyDate = new Date(System.currentTimeMillis());
        this.price = price;
        this.boughtStuffs = boughtStuffs;
        this.receiptId = staticReceiptId++;
    }

    public static int getStaticReceiptId() {
        return staticReceiptId;
    }

    public int getReceiptId() {
        return receiptId;
    }

    public void setReceiptId(int receiptId) {
        this.receiptId = receiptId;
    }

    public Date getBuyDate() {
        return buyDate;
    }

    public void setBuyDate(Date buyDate) {
        this.buyDate = buyDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public ArrayList<CartItem> getBoughtStuffs() {
        return boughtStuffs;
    }

    public void setBoughtStuffs(ArrayList<CartItem> boughtStuffs) {
        this.boughtStuffs = boughtStuffs;
    }

    @Override
    public String toString() {
        return "receiptId: " + receiptId +
                ", buyDate: " + buyDate +
                ", price: " + price +
                ", boughtStuffs: " + boughtStuffs;
    }
}
