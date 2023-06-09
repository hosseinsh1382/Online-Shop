package Controller;

import Exceptions.InvalidInputException;
import Exceptions.OutOfCreditException;
import Exceptions.OutOfStockCountException;
import Model.Discount;
import Model.Receipt;
import Model.Stuffs.Stuff;
import Model.User.Buyer;
import Model.User.CartItem;
import Model.User.Request.IncreaseCreditRequest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BuyerController {
    public static String increaseCredit(Buyer buyer, double extraCredit) {
        IncreaseCreditRequest increaseCreditRequest = new IncreaseCreditRequest((Buyer) UserController.getLoggedInUser(), extraCredit);
        ((Buyer) UserController.getLoggedInUser()).setIncreaseCreditRequest(increaseCreditRequest);
        return "Request sent";
    }

    public static ArrayList<Stuff> filter(String category) {
        ArrayList<Stuff> filteredStuffs = new ArrayList<>();
        for (Stuff s : StuffController.getStuffs())
            if (s.getCategory().toString().equalsIgnoreCase(category)) {
                filteredStuffs.add(s);
            }
        return filteredStuffs;
    }

    public static ArrayList<Stuff> filter(double low, double high) {
        ArrayList<Stuff> filteredStuffs = new ArrayList<>();
        for (Stuff s : StuffController.getStuffs())
            if (s.getPrice() > low && s.getPrice() < high)
                filteredStuffs.add(s);
        return filteredStuffs;

    }

    public static ArrayList<Stuff> filter(double rate) {
        ArrayList<Stuff> filteredStuffs = new ArrayList<>();
        for (Stuff s : StuffController.getStuffs())
            if (s.getAverageRate() >= rate)
                filteredStuffs.add(s);
        return filteredStuffs;
    }

    public static ArrayList<Stuff> filter() {
        ArrayList<Stuff> filteredStuffs = new ArrayList<>();
        for (Stuff s : StuffController.getStuffs()) {
            if (s.getCount() > 0)
                filteredStuffs.add(s);
        }
        return filteredStuffs;
    }

    public static void buy(Stuff boughtStuff, int count) throws OutOfStockCountException {
        if (boughtStuff.getCount() < count)
            throw new OutOfStockCountException();

        CartItem newStuff = new CartItem(boughtStuff, count);
        // update count of bought stuff
        boughtStuff.setCount(boughtStuff.getCount() - count);

        ((Buyer) UserController.getLoggedInUser()).getCart().add(newStuff);

    }

    public static void finalizeBuy() throws OutOfCreditException{
        double price = 0;
        for (CartItem c : ((Buyer) UserController.getLoggedInUser()).getCart()) {
            price += c.getTotalPrice();
        }
        if (((Buyer) UserController.getLoggedInUser()).getCredit() > price) {
            Receipt newReceipt = new Receipt(price, ((Buyer) UserController.getLoggedInUser()).getCart());
            ((Buyer) UserController.getLoggedInUser()).setReceipts(newReceipt);
            ((Buyer) UserController.getLoggedInUser()).getCart().removeAll(((Buyer) UserController.getLoggedInUser()).getCart());
            ((Buyer) UserController.getLoggedInUser()).setCredit(((Buyer) UserController.getLoggedInUser()).getCredit() - price);
        }
        else throw new OutOfCreditException();
    }

    public static String cancelBuy() {
        for (CartItem c : ((Buyer) UserController.getLoggedInUser()).getCart()) {
            c.getStuff().increaseCount(c.getCount());
        }
        ((Buyer) UserController.getLoggedInUser()).getCart().removeAll(((Buyer) UserController.getLoggedInUser()).getCart());
        return "Cancelled";
    }

    public static void signUp(String username, String password, String email, String phoneNo) {
        Buyer newBuyer = new Buyer(username, password, email, phoneNo);
        UserController.getUsers().add(newBuyer);
    }

    public static void cardNoValidation(String cardNo) throws InvalidInputException{
        Pattern pattern = Pattern.compile("^\\d{16}");
        Matcher matcher = pattern.matcher(cardNo);

        if (!matcher.find()){
            throw new InvalidInputException("Invalid card number!");
        }
    }

    public static void cardCVV2Validation(String cvv2) throws InvalidInputException {
        Pattern pattern = Pattern.compile("^\\d{3,4}");
        Matcher matcher = pattern.matcher(cvv2);
        if (!matcher.find()){
            throw new InvalidInputException("Invalid CVV2");
        }
    }

    public static Discount chanceCircle(Buyer buyer) throws OutOfCreditException {
        int fee = 50;
        if (buyer.getCredit() > fee) {
            Random random = new Random();
            int category = random.nextInt(0, 5);
            double discountPercent = random.nextDouble(0, 100);
            int extraDays = random.nextInt(1, 11);
            LocalDate expireDate = LocalDate.now().plusDays(extraDays);
            ArrayList<Discount.Category> categoryArrayList = new ArrayList<>();
            switch (category) {
                case 0:
                    return null;
                case 1:
                    categoryArrayList.add(Discount.Category.DIGITALSTUFF);
                    break;
                case 2:
                    categoryArrayList.add(Discount.Category.FOOD);
                    break;
                case 3:
                    categoryArrayList.add(Discount.Category.STATIONARY);
                    break;
                case 4:
                    categoryArrayList.add(Discount.Category.VEHICLE);
                    break;
            }
            Discount discount = new Discount(discountPercent, expireDate, 1, categoryArrayList);
            buyer.getDiscounts().add(discount);
            return discount;
        }
        throw new OutOfCreditException();
    }

}
