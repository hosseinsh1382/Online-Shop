package Controller;

import Exceptions.*;
import Model.*;
import Model.Stuffs.Stuff;
import Model.User.Buyer;
import Model.User.CartItem;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class DiscountController {
    public static void addUserDiscount(Discount discount, Buyer buyer) {
        buyer.getDiscounts().add(discount);
    }

    public static void addStuffDiscount(Stuff stuff, Discount discount) {
        stuff.getDiscounts().add(discount);
    }

    public static void addCategoryDiscount(Discount.Category category, Discount discount) {
        discount.getCategories().add(category);
    }

    public static void checkUserDiscount(String discountCode, Buyer buyer, CartItem cartItem) throws DiscountException {
        for (Discount d : buyer.getDiscounts()) {
            if (d.getDiscountCode().equals(discountCode)) {
                if (checkDiscountValidation(d)) {
                    for (Discount.Category c : d.getCategories()) {
                        for (Stuff s : StuffController.getStuffs()) {
                            if (c.toString().equals(s.getCategory().toString())) {
                                cartItem.setTotalPrice(cartItem.getTotalPrice() - (100 - d.getDiscount()));
                                d.setCapacity(d.getCapacity() - 1);
                                return;
                            }
                        }
                    }
                }
            }
        }
        throw new DiscountInvalidException();
    }

    public static void checkStuffDiscount(String discountCode, CartItem cartItem) throws DiscountException {
        boolean validation;
        for (Discount d : cartItem.getStuff().getDiscounts()) {
            if (d.getDiscountCode().equals(discountCode)) {
                validation = checkDiscountValidation(d);
                if (validation) {
                    cartItem.setTotalPrice(cartItem.getTotalPrice() - (100 - d.getDiscount()));
                    d.setCapacity(d.getCapacity() - 1);
                    return;
                }
            }
        }
        throw new DiscountInvalidException();
    }

    public static boolean checkDiscountValidation(Discount discount) throws DiscountException {
        if (discount.getExpireDate().isAfter(LocalDate.now())) {
            if (discount.getCapacity() == 0) {
                return true;
            }
            throw new DiscountFullCapacityException();
        }
        throw new DiscountExpiredException();
    }

    public static void addDiscountToBuyer(Buyer buyer, double discountPercent, LocalDate expireDate, ArrayList<Discount.Category> categories) {
        Discount discount = new Discount(discountPercent, expireDate, 1, categories);
        buyer.getDiscounts().add(discount);
    }

    public static void addDiscountToBuyer(Buyer buyer, double discountPercent, LocalDate expireDate) {
        ArrayList<Discount.Category> categories = new ArrayList<>();
        categories.add(Discount.Category.VEHICLE);
        categories.add(Discount.Category.DIGITALSTUFF);
        categories.add(Discount.Category.STATIONARY);
        categories.add(Discount.Category.FOOD);
        addDiscountToBuyer(buyer, discountPercent, expireDate, categories);
    }

    public static void discountForLeastBoughtCategory(Buyer buyer, LocalDate expireDate) {
        int stationaryCount = 0, foodCount = 0, vehicleCount = 0, digitalStuff = 0;
        for (Receipt r : buyer.getReceipts()) {
            for (CartItem c : r.getBoughtStuffs()) {
                switch (c.getStuff().getCategory()) {
                    case STATIONARY:
                        stationaryCount++;
                        break;
                    case FOOD:
                        foodCount++;
                        break;
                    case VEHICLE:
                        vehicleCount++;
                        break;
                    case DIGITALSTUFF:
                        digitalStuff++;
                        break;
                }
            }
        }

        ArrayList<Discount.Category> categories = new ArrayList<>();
        double discountPercent = Math.random() * 100;

        if (stationaryCount < foodCount && stationaryCount < vehicleCount && stationaryCount < digitalStuff) {
            categories.add(Discount.Category.STATIONARY);
        }

        if (foodCount < stationaryCount && foodCount < vehicleCount && foodCount < digitalStuff) {
            categories.add(Discount.Category.FOOD);
        }

        if (vehicleCount < foodCount && vehicleCount < stationaryCount && vehicleCount < digitalStuff) {
            categories.add(Discount.Category.VEHICLE);
        }

        if (digitalStuff < foodCount && digitalStuff < vehicleCount && digitalStuff < stationaryCount) {
            categories.add(Discount.Category.DIGITALSTUFF);
        }
        addDiscountToBuyer(buyer, discountPercent, expireDate, categories);

    }

}
