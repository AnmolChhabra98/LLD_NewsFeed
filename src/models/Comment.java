package models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class Comment {
  private long id;
  private User user;
  private String msg;
  private Date createdAt;
  private long upvotes;
  private long downvotes;
  private List<Comment> replies;

  public Comment(User user, String msg) {
    this.id = new Random().nextLong();
    this.user = user;
    this.msg = msg;
    this.createdAt = new Date();
    this.upvotes = 0;
    this.downvotes = 0;
    this.replies = new ArrayList<>();
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public String getMsg() {
    return msg;
  }

  public void setMsg(String msg) {
    this.msg = msg;
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

  public List<Comment> getReplies() {
    return replies;
  }

  public void setReplies(List<Comment> replies) {
    this.replies = replies;
  }

  @Override
  public String toString() {
    return "Comment{" +
        "id=" + id +
        ", user=" + user +
        ", msg='" + msg + '\'' +
        ", createdAt=" + createdAt +
        ", upvotes=" + upvotes +
        ", downvotes=" + downvotes +
        ", replies=" + replies +
        '}';
  }
}
