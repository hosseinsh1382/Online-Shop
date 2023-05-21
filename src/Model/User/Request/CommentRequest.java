package Model.User.Request;

import Model.Comment;
import Model.Stuffs.Stuff;
import Model.User.Buyer;

public class CommentRequest extends Request {
    private final Comment newComment;
    private final Stuff stuff;

    public CommentRequest(Buyer requester, Comment newComment, Stuff stuff) {
        super(requester);
        this.newComment = newComment;
        this.stuff = stuff;
    }

    public Stuff getStuff() {
        return stuff;
    }

    public Comment getNewComment() {
        return newComment;
    }

    @Override
    public String toString() {
        return super.toString()+
                "newComment: " + newComment +
                ", stuff: " + stuff;
    }
}
