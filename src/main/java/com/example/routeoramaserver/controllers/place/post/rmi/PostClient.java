package com.example.routeoramaserver.controllers.place.post.rmi;

import com.example.routeoramaserver.callbacks.place.post.IPostServerCallback;
import com.example.routeoramaserver.callbacks.place.post.PostClientCallback;
import com.example.routeoramaserver.models.Post;
import com.example.routeoramaserver.models.PostContainer;
import com.example.routeoramaserver.networking.ServerConnection;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;


public class PostClient implements IPostClient, PostClientCallback {

    private IPostServerCallback server;

    @Override
    public void Start() {
        try {
            UnicastRemoteObject.exportObject(this, 0);
            server = ServerConnection.getServerCallback().getPostServer();
        } catch (RemoteException e) {
            System.out.println("Could not contact server.");
        }
    }

    @Override
    public Post NewPost(Post post, List<String> tags) {
        try {
            return server.NewPost(post, tags);
        } catch (RemoteException e) {
            System.out.println("Could not contact server when creating new post.");
        }
        return null;
    }

    @Override
    public boolean DeletePost(int postID) {
        try {
            return server.DeletePost(postID);
        } catch (RemoteException e) {
            System.out.println("Could not contact server when deleting the post.");
        }
        return false;
    }

    @Override
    public Post GetPost(int postID) {
        try {
            return server.GetPost(postID);
        } catch (RemoteException e) {
            System.out.println("Could not contact server when getting post.");
        }
        return null;
    }

    @Override
    public PostContainer LoadPostsFromChannel(int placeID, int postID) {
        try {
            return server.LoadPostsFromChannel(placeID, postID);
        } catch (RemoteException e) {
            System.out.println("Could not contact server when loading more posts.");
        }
        return null;
    }

    @Override
    public boolean LikeThePost(int userId, int postId) {
        try {
            return server.LikeThePost(userId, postId);
        } catch (RemoteException e) {
            System.out.println("Could not contact server when liking a post.");
        }
        return false;
    }

    @Override
    public boolean IsAlreadyLiked(int userId, int postId) {
        try {
            return server.IsAlreadyLiked(userId, postId);
        } catch (RemoteException e) {
            System.out.println("Could not contact server when checking if post is liked.");
        }
        return false;
    }
}
