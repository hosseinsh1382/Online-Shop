package Model.Stuffs.Food;

import Model.Stuffs.Stuff;
public class Food extends Stuff {
    private int produceDate, expireDate;

    public Food(String name, double price, int count, int produceDate, int expireDate) {
        super(name, price,count, Category.FOOD);
        this.produceDate = produceDate;
        this.expireDate = expireDate;
    }

    public int getPro() {
        return produceDate;
    }

    public void setPro(int pro) {
        this.produceDate = pro;
    }

    public int getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(int expireDate) {
        this.expireDate = expireDate;
    }

    @Override
    public String toString() {
        return super.toString()+
                "pro: " + produceDate +
                ", exp: " + expireDate;
    }
}
