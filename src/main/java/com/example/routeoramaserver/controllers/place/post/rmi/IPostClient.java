package com.example.routeoramaserver.controllers.place.post.rmi;

import com.example.routeoramaserver.models.Post;

import java.rmi.RemoteException;

public interface IPostClient {
    void Start();
    Post NewPost(Post post);
    boolean DeletePost(int postID);
    Post GetPost(int postID);
}
