package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class User {
  private long id;
  private String username;
  private List<User> followers;
  private List<User> following;

  public User(String username) {
    this.id = new Random().nextLong();
    this.username = username;
    this.followers = new ArrayList<>();
    this.following = new ArrayList<>();
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public List<User> getFollowers() {
    return followers;
  }

  public void setFollowers(List<User> followers) {
    this.followers = followers;
  }

  public List<User> getFollowing() {
    return following;
  }

  public void setFollowing(List<User> following) {
    this.following = following;
  }

  @Override
  public String toString() {
    List<String> followingUsernames = following != null
        ? following.stream()
        .map(User::getUsername)
        .toList()
        : Collections.emptyList();

    return "User{" +
        "id=" + id +
        ", username='" + username + '\'' +
        ", followingUsernames=" + followingUsernames +
        '}';
  }
}
