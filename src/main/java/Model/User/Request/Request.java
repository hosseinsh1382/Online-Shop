package Model.User.Request;


import Controller.BuyerController;
import Controller.UserController;
import Model.User.Buyer;

public abstract class Request {
    private Buyer requester;

    public Request() {
        this.requester = (Buyer) UserController.getLoggedInUser();
    }

    public Buyer getRequester() {
        return requester;
    }

    @Override
    public String toString() {
        return "requester: " + requester;
    }
}
