package com.example.routeoramaserver.controllers.place.post.rmi;

import com.example.routeoramaserver.models.Post;
import com.example.routeoramaserver.models.PostContainer;

import java.rmi.RemoteException;
import java.util.List;

public interface IPostClient {
    void Start();
    Post NewPost(Post post, List<String> tags);
    boolean DeletePost(int postID);
    Post GetPost(int postID);
    PostContainer LoadPostsFromChannel(int placeID, int postID);
    void LikeThePost(int postId, int userId);
    void UnlikeThePost(int postId, int userId);
    boolean IsAlreadyLiked(int postId, int userId);
    PostContainer GetFeed(int userId);
    PostContainer LoadFeed(int i, int i1);
}
