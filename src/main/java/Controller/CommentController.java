package Controller;

import Model.Comment;
import Model.Receipt;
import Model.Stuffs.Stuff;
import Model.User.Buyer;
import Model.User.CartItem;
import Model.User.Request.CommentRequest;

public class CommentController {
    public static String addComment(Stuff stuff, String commentText) {
        Comment newComment = new Comment(stuff.getID(), commentText, isBought(stuff), (Buyer) UserController.getLoggedInUser());
        CommentRequest newCommentRequest = new CommentRequest(newComment,stuff);
        return "request sent";
    }

    private static boolean isBought(Stuff stuff) {
        for (Receipt r : ((Buyer) UserController.getLoggedInUser()).getReceipts()) {
            for (CartItem c : r.getBoughtStuffs()) {
                if (c.getStuff().equals(stuff)) {
                    return true;
                }
            }
        }
        return false;
    }

    public String acceptCommentRequest(CommentRequest commentRequest) {
        commentRequest.getStuff().getComments().add(commentRequest.getNewComment());
        commentRequest.getStuff().getCommentRequests().remove(commentRequest);
        return "Request accepted";
    }

    public String rejectCommentRequest(CommentRequest commentRequest) {
        commentRequest.getStuff().getCommentRequests().remove(commentRequest);
        return "Request rejected";
    }

}
