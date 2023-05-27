package Model;

import Model.User.Buyer;

public class Comment {
    //User
    private String stuffID, commentText;
    private boolean isBought;
    private Buyer buyer;

    public Comment(String stuffID, String commentText, boolean isBought, Buyer buyer) {
        this.stuffID = stuffID;
        this.commentText = commentText;
        this.isBought = isBought;
        this.buyer = buyer;
    }

    public String getStuffID() {
        return stuffID;
    }

    public void setStuffID(String stuffID) {
        this.stuffID = stuffID;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public boolean getIsBought() {
        return isBought;
    }

    public void setIsBought(boolean bought) {
        isBought = bought;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }

    @Override
    public String toString() {
        return
                "commentText: '" + commentText + '\'' +
                        ", isBought: " + isBought +
                        ", buyer: " + buyer;
    }
}
