package services;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import models.User;

public class UserService {
  public static Map<String, User> activeUsers = new ConcurrentHashMap<>();

  public void signUp(String username) {
    createUser(username);
  }

  public User login(String username) {
    return Optional.ofNullable(
        activeUsers.get(username)
    ).orElseThrow(() -> new RuntimeException("User not found"));
  }

  // can also be used as follow back by followed user
  public void follow(User currentUser, String userName) {
    User followUser = activeUsers.get(userName);
    currentUser.getFollowing().add(followUser);
    followUser.getFollowing().add(currentUser);
  }

  private void createUser(String username) {
    User user = new User(username);
    activeUsers.put(username, user);
  }
}
