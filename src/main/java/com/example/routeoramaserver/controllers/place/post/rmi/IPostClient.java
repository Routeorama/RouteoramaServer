package com.example.routeoramaserver.controllers.place.post.rmi;

import com.example.routeoramaserver.models.Post;

import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.List;

public interface IPostClient {
    void Start();
    Post NewPost(Post post);
    boolean DeletePost(int postID);
    Post GetPost(int postID);
    HashMap<Boolean, List<Post>> LoadPostsFromChannel(int placeID, int postID);
}
