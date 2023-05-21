package Controller;

import Model.User.Request.IncreaseCreditRequest;

public class AdminController {
    public String acceptIncreaseRequest(IncreaseCreditRequest increaseCreditRequest) {
        increaseCreditRequest.getRequester().setCredit(increaseCreditRequest.getExtraCredit() +
                increaseCreditRequest.getRequester().getCredit());
        increaseCreditRequest.getRequester().setIncreaseCreditRequest(null);
        return "Request accepted";
    }

    public String rejectIncreaseRequest(IncreaseCreditRequest increaseCreditRequest) {
        increaseCreditRequest.getRequester().setIncreaseCreditRequest(null);
        return "Request rejected!";
    }

}
