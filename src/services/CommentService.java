package services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import models.Comment;
import models.User;

public class CommentService {

  public static Map<Long, Comment> comments = new ConcurrentHashMap<>();
  public static Map<Long, List<Comment>> replyComments = new ConcurrentHashMap<>();

  public void replyComment(User user, Long id, String msg) {
    Comment comment = comments.get(id);
    Comment reply = new Comment(user, msg);
    comment.getReplies().add(reply);
    replyComments.put(id, comment.getReplies());
  }

  public void upvote(Long id) {
    Comment comment = comments.get(id);
    comment.setUpvotes(comment.getUpvotes() + 1);
  }

  public void downvote(Long id) {
    Comment comment = comments.get(id);
    comment.setDownvotes(comment.getDownvotes() + 1);
  }
}
