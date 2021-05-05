package com.example.routeoramaserver.controllers.place.post.rmi;

import com.example.routeoramaserver.callbacks.place.IPlaceServerCallback;
import com.example.routeoramaserver.callbacks.place.post.IPostServerCallback;
import com.example.routeoramaserver.callbacks.place.post.PostClientCallback;
import com.example.routeoramaserver.models.Post;
import com.example.routeoramaserver.networking.ServerConnection;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class PostClient implements IPostClient, PostClientCallback {

    private IPostServerCallback server;

    @Override
    public void Start() {
        try {
            UnicastRemoteObject.exportObject(this, 0);
            server = ServerConnection.getServerCallback().getPostServer();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Post NewPost(Post post) {
        try {
            return server.NewPost(post);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean DeletePost(int postID) {
        try {
            return server.DeletePost(postID);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Post GetPost(int postID) {
        try {
            return server.GetPost(postID);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }
}
