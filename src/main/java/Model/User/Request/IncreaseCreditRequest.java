package Model.User.Request;

import Model.User.Buyer;

public class IncreaseCreditRequest extends Request {
    double extraCredit;

    public IncreaseCreditRequest(Buyer requester, double extraCredit) {
        super();
        this.extraCredit = extraCredit;
    }


    public double getExtraCredit() {
        return extraCredit;
    }
}
