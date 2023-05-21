package Model.Stuffs;

import Model.User.Request.CommentRequest;
import Model.Comment;

import java.util.ArrayList;
import java.util.Objects;

public abstract class Stuff implements Comparable {
    public enum Category {
        DIGITALSTUFF, STATIONARY, VEHICLE, FOOD
    }

    private String ID, name;
    private double price, averageRate, totalRate = 0;
    static int staticInt = 1000;
    private int count, rateCount = 0;
    private Category category;
    private ArrayList<Comment> comments;
    private ArrayList<CommentRequest> commentRequests;

    public Stuff(String name, double price, int count, Category category) {
        this.name = name;
        this.price = price;
        this.count = count;
        this.category = category;
        setID();
        comments = new ArrayList<>();
        commentRequests = new ArrayList<>();
    }

    // Setters
    public void setID() {
        this.ID = this.category.toString().charAt(0) + " " + (Integer.toString(staticInt++));
    }

    public void increaseCount(int count) {
        this.count += count;
    }

    public void decreaseCount(int count) {
        this.count -= count;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setTotalRate(double totalRate) {
        this.totalRate = totalRate;
    }

    public void setAverageRate(double averageRate) {
        this.averageRate = averageRate;
    }

    public void setRateCount() {
        this.rateCount++;
    }

    public void setCount(int count) {
        this.count = count;
    }


    // Getters
    public int getRateCount() {
        return rateCount;
    }

    public Category getCategory() {
        return category;
    }

    public double getAverageRate() {
        return averageRate;
    }

    public double getPrice() {
        return price;
    }

    public int getCount() {
        return count;
    }

    public String getID() {
        return ID;
    }

    public String getName() {
        return this.name;
    }

    public ArrayList<Comment> getComments() {
        return comments;
    }

    public ArrayList<CommentRequest> getCommentRequests() {
        return commentRequests;
    }

    public double getTotalRate() {
        return totalRate;
    }

    @Override
    public String toString() {
        return "name: '" + name + '\'' +
                ", price: " + price +
                ", averageRate: " + averageRate +
                ", count: " + count +
                ", category: " + category;
    }
    
}
