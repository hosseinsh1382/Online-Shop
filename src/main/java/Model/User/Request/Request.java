package Model.User.Request;


import Model.User.Buyer;

public abstract class Request {
    private Buyer requester;

    public Request(Buyer requester) {
        this.requester = requester;
    }

    public Buyer getRequester() {
        return requester;
    }

    @Override
    public String toString() {
        return "requester: " + requester;
    }
}
