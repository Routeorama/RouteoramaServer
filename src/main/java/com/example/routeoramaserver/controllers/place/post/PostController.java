package com.example.routeoramaserver.controllers.place.post;

import com.example.routeoramaserver.controllers.place.post.model.IPostModel;
import com.example.routeoramaserver.controllers.place.post.model.PostModel;
import com.example.routeoramaserver.controllers.place.post.rmi.IPostClient;
import com.example.routeoramaserver.controllers.place.post.rmi.PostClient;
import com.example.routeoramaserver.models.Comment;
import com.example.routeoramaserver.models.CommentContainer;
import com.example.routeoramaserver.models.Post;
import com.example.routeoramaserver.models.PostContainer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/post")
public class PostController {
    private IPostClient postClient;
    private IPostModel postModel;

    public PostController() {
        postClient = new PostClient();
        postModel = new PostModel();
        postClient.Start();
    }

    @PostMapping(value = "/add", consumes = "application/json", produces = "application/json")
    public Post NewPost(@RequestBody Post post) {
        //this might need to be separated into variables bcs they aren't async
        return postClient.NewPost(postModel.ValidatePost(post), postModel.GetTags(post));
    }

    @PostMapping(value = "/delete", consumes = "application/json", produces = "application/json")
    public boolean DeletePost(@RequestBody int postID) {
        return postClient.DeletePost(postID);
    }

    @PostMapping(value = "/getpost", consumes = "application/json", produces = "application/json")
    public Post GetPost(@RequestBody int postID) {
        return postClient.GetPost(postID);
    }

    @PostMapping(value = "/getposts", consumes = "application/json", produces = "application/json")
    public PostContainer LoadPostsFromChannel(@RequestBody int[] array) {
        return postClient.LoadPostsFromChannel(array[0], array[1]);
    }

    @PostMapping(value = "/likepost", consumes = "application/json")
    public void LikeThePost(@RequestBody int[] array) {
        postClient.LikeThePost(array[0], array[1]);
    }

    @PostMapping(value = "/islikedpost", consumes = "application/json", produces = "application/json")
    public boolean IsAlreadyLiked(@RequestBody int[] array) {
        return postClient.IsAlreadyLiked(array[0], array[1]);
    }

    @PostMapping(value = "/unlikethepost", consumes = "application/json")
    public void UnlikeThePost(@RequestBody int[] array) {
        postClient.UnlikeThePost(array[0], array[1]);
    }

    @PostMapping(value = "/getfeed", consumes = "application/json", produces = "application/json")
    public PostContainer GetPostsForNewsFeed(@RequestBody int userId) {
        return postClient.GetPostsForNewsFeed(userId);
    }

    @PostMapping(value = "/loadfeed", consumes = "application/json", produces = "application/json")
    public PostContainer LoadMorePostsForNewsFeed(@RequestBody int[] array) {
        return postClient.LoadMorePostsForNewsFeed(array[0], array[1]);
    }

    @PostMapping(value = "/comment", consumes = "application/json")
    public void Comment(@RequestBody Comment comment) {
        postClient.Comment(comment);
    }

    @PostMapping(value = "/deletecomment", consumes = "application/json")
    public void DeleteComment(@RequestBody Comment comment) {
        postClient.DeleteComment(comment);
    }

    @PostMapping(value = "/getcommentforpost", consumes = "application/json", produces = "application/json")
    public CommentContainer GetCommentForPost(@RequestBody int postId) {
        return postClient.GetCommentForPost(postId);
    }

    @PostMapping(value = "/loadmorecomments", consumes = "application/json", produces = "application/json")
    public CommentContainer LoadMoreComments(@RequestBody Comment lastComment) {
        return postClient.LoadMoreComments(lastComment);
    }
}
