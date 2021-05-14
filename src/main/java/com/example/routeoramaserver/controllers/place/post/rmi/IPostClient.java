package com.example.routeoramaserver.controllers.place.post.rmi;

import com.example.routeoramaserver.models.Post;
import com.example.routeoramaserver.models.PostContainer;

import java.util.List;

public interface IPostClient {
    void Start();
    Post NewPost(Post post, List<String> tags);
    boolean DeletePost(int postID);
    Post GetPost(int postID);
    PostContainer LoadPostsFromChannel(int placeID, int postID);
    boolean LikeThePost(int postId, int userId);
    boolean IsAlreadyLiked(int postId, int userId);
}
