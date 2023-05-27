package Model.User;

import Model.Discount;
import Model.Receipt;
import Model.User.Request.IncreaseCreditRequest;

import java.util.ArrayList;

public class Buyer extends User {
    private ArrayList<CartItem> cart;
    private ArrayList<Receipt> receipts;
    private IncreaseCreditRequest increaseCreditRequest;
    private ArrayList<Discount> discounts;
    private double credit;


    public Buyer(String username, String password, String email, String phoneNo) {
        super(username, password, email, phoneNo, Roll.BUYER);
        this.receipts = new ArrayList<>();
        this.cart = new ArrayList<>();
        this.credit = 0;
        this.discounts = new ArrayList<>();
    }

    public ArrayList<Discount> getDiscounts() {
        return discounts;
    }
    public ArrayList<CartItem> getCart() {
        return cart;
    }

    public ArrayList<Receipt> getReceipts() {
        return receipts;
    }

    public void setReceipts(Receipt newReceipt) {
        this.receipts.add(newReceipt);
    }

    public IncreaseCreditRequest getIncreaseCreditRequest() {
        return increaseCreditRequest;
    }

    public void setIncreaseCreditRequest(IncreaseCreditRequest increaseCreditRequest) {
        this.increaseCreditRequest = increaseCreditRequest;
    }

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }


}
