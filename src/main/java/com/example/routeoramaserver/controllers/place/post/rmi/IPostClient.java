package com.example.routeoramaserver.controllers.place.post.rmi;

import com.example.routeoramaserver.models.Comment;
import com.example.routeoramaserver.models.CommentContainer;
import com.example.routeoramaserver.models.Post;
import com.example.routeoramaserver.models.PostContainer;
import java.util.List;

public interface IPostClient{
    void Start();
    Post NewPost(Post post, List<String> tags);
    boolean DeletePost(int postID);
    Post GetPost(int postID);
    PostContainer LoadPostsFromChannel(int placeID, int postID);
    void LikeThePost(int postId, int userId);
    void UnlikeThePost(int postId, int userId);
    boolean IsAlreadyLiked(int postId, int userId);
    PostContainer GetPostsForNewsFeed(int userId);
    PostContainer LoadMorePostsForNewsFeed(int userId, int postId);
    void Comment(Comment comment);
    void DeleteComment(Comment comment);
    CommentContainer GetCommentForPost(int postId);
    CommentContainer LoadMoreComments(Comment lastComment);
    int GetCommentCount(int postId);
}
