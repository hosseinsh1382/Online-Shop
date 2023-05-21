package Controller;

import Model.Stuffs.Stuff;
import Model.User.CartItem;

import java.util.ArrayList;

public class CartController {
    public static void removeStuff(ArrayList<CartItem> carts, Stuff stuff){
        carts.remove(stuff);
    }
}
