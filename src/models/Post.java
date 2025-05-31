package models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class Post {
  private long id;
  private String msg;
  private User user;
  private List<Comment> comments;
  private Date createdAt;
  private long upvotes;
  private long downvotes;

  public Post(User user, String msg) {
    this.id = new Random().nextLong();
    this.msg = msg;
    this.user = user;
    this.comments = new ArrayList<>();
    this.createdAt = new Date();
    this.upvotes = 0;
    this.downvotes = 0;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getMsg() {
    return msg;
  }

  public void setMsg(String msg) {
    this.msg = msg;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public List<Comment> getComments() {
    return comments;
  }

  public void setComments(List<Comment> comments) {
    this.comments = comments;
  }

  public Date getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }

  public long getUpvotes() {
    return upvotes;
  }

  public void setUpvotes(long upvotes) {
    this.upvotes = upvotes;
  }

  public long getDownvotes() {
    return downvotes;
  }

  public void setDownvotes(long downvotes) {
    this.downvotes = downvotes;
  }

  @Override
  public String toString() {
    return "Post{" +
        "id=" + id +
        ", msg='" + msg + '\'' +
        ", user=" + user +
        ", comments=" + comments +
        ", createdAt=" + createdAt +
        ", upvotes=" + upvotes +
        ", downvotes=" + downvotes +
        '}';
  }
}
