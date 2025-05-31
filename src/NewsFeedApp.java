import java.util.List;
import models.Post;
import models.User;
import services.CommentService;
import services.NewsFeedService;
import services.PostService;
import services.UserService;

public class NewsFeedApp {

  private final User user;
  private final UserService userService;
  private final PostService postService;
  private final CommentService commentService;
  private final NewsFeedService newsFeedService;

  public NewsFeedApp(User user) {
    this.user = user;
    this.userService = new UserService();
    this.postService = new PostService();
    this.commentService = new CommentService();
    this.newsFeedService = new NewsFeedService();
  }

//  public void signUp(String username) {
//    userService.signUp(username);
//  }
//
//  public User login(String username) {
//    return userService.login(username);
//  }

  private Post post(String msg) {
    return postService.post(this.user, msg);
  }

  private void showNewsFeed() {
    System.out.println(newsFeedService.showNewsFeed(this.user));
  }

  private void upvotePost(Long postId) {
    postService.upvote(postId);
  }

  private void downvotePost(Long postId) {
    postService.downvote(postId);
  }

  private void replyToPost(Long postId, String msg) {
    postService.comment(this.user, postId, msg);
  }

  private void replyToComment(Long commentId, String msg) {
    commentService.replyComment(this.user, commentId, msg);
  }

  private void follow(String userName) {
    userService.follow(this.user, userName);
  }

  public static void main(String[] args) {
    UserService userService = new UserService();
    userService.signUp("lucious");
    userService.signUp("albus");
    userService.signUp("tom");

    User user1 = userService.login("tom");

    NewsFeedApp newsFeedApp = new NewsFeedApp(user1);
    Post post1 = newsFeedApp.post("I am going to be the darkest dark wizard of all time");
    Post post2 = newsFeedApp.post("I am lord Voldemort btw 3:)");

    User user2 = userService.login("lucious");
    NewsFeedApp newsFeedApp2 = new NewsFeedApp(user2);
    newsFeedApp2.showNewsFeed();

    newsFeedApp2.upvotePost(post1.getId());
    newsFeedApp2.follow("tom");
    newsFeedApp2.replyToPost(post1.getId(), "I am with you dark lord!");

    User user3 = userService.login("albus");
    NewsFeedApp newsFeedApp3 = new NewsFeedApp(user3);
    newsFeedApp3.showNewsFeed();

    newsFeedApp3.post("Happiness can be found, even in the darkest of times, if one only remembers to turn on the light");
    newsFeedApp3.follow("tom");
    newsFeedApp3.downvotePost(post1.getId());
    newsFeedApp3.downvotePost(post2.getId());
    newsFeedApp3.replyToPost(post2.getId(), "LOL!");

    newsFeedApp3.showNewsFeed();
  }
}