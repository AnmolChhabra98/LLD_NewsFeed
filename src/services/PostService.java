package services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import models.Comment;
import models.Post;
import models.User;

public class PostService {
  public static Map<Long, List<Post>> userToPosts = new ConcurrentHashMap<>();
  public static Map<Long, Post> idToPosts = new ConcurrentHashMap<>();
  public static List<Post> allPosts = new ArrayList<>();

  public Post post(User user, String msg) {
    Post post = new Post(user, msg);
    // why this not put if absent
    userToPosts.computeIfAbsent(user.getId(), k -> new ArrayList<>()).add(post);
    allPosts.add(post);
    idToPosts.put(post.getId(), post);

    return post;
  }

  public void upvote(Long id) {
    Post post = idToPosts.get(id);
    post.setUpvotes(post.getUpvotes() + 1);
  }

  public void downvote(Long id) {
    Post post = idToPosts.get(id);
    post.setDownvotes(post.getDownvotes() + 1);
  }

  public void comment(User user, Long id, String msg) {
    Post post = idToPosts.get(id);
    Comment comment = new Comment(user, msg);
    post.getComments().add(comment);
    CommentService.comments.putIfAbsent(comment.getId(), comment);
  }
}
