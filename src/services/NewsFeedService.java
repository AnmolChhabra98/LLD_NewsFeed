package services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import models.Comment;
import models.Post;
import models.User;

public class NewsFeedService {

  public List<Post> showNewsFeed(User user) {
    List<Post> posts = new ArrayList<>(PostService.allPosts);

    Set<Long> followingUserIds = user.getFollowing().stream()
        .map(User::getId)
        .collect(Collectors.toSet());

    Comparator<Post> comparator = Comparator
        // 1. Followed users first (true = 1, false = 0 → reverse order to bring followed to top)
        .comparing((Post p) -> !followingUserIds.contains(p.getUser().getId()))
        // 2. Higher score first
        .thenComparing((Post p) -> p.getDownvotes() - p.getUpvotes())
        // 3. More comments (including nested replies)
        .thenComparing((Post p) -> -countComments(p.getComments()))
        // 4. Most recent first
        .thenComparing(Post::getCreatedAt, Comparator.reverseOrder());

    posts.sort(comparator);
    return posts;
  }

  private int countComments(List<Comment> comments) {
    if(Objects.isNull(comments))
      return 0;
    int count = comments.size();
    for(Comment comment : comments) {
      count += countComments(comment.getReplies());
    }

    return count;
  }
}
