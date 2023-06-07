package Controller;

import Exceptions.OutOfCreditException;
import Model.Stuffs.Stuff;
import Model.User.Buyer;
import Model.User.CartItem;
import View.Stg_Error;

import java.util.ArrayList;

public class CartController {
    public static void removeStuff(CartItem cartItem) {
        ((Buyer) UserController.getLoggedInUser()).getCart().remove(cartItem);
    }

    public static double getTotalCartPrice() {
        double totalPrice = 0;
        for (CartItem c : ((Buyer) UserController.getLoggedInUser()).getCart()) {
            totalPrice += c.getTotalPrice();
        }
        return totalPrice;
    }
}
