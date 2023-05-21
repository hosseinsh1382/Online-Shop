package Model.User;

import java.util.ArrayList;

import Model.User.Request.IncreaseCreditRequest;
import Model.Receipt;

public class Buyer extends User {
    private ArrayList<CartItem> cart;
    private ArrayList<Receipt> receipts;
    private IncreaseCreditRequest increaseCreditRequest;
    private double credit;

    public Buyer(String username, String password, String email, String phoneNo) {
        super(username, password, email, phoneNo, Roll.BUYER);
        this.receipts = new ArrayList<>();
        this.cart = new ArrayList<>();
        this.credit = 0;
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
