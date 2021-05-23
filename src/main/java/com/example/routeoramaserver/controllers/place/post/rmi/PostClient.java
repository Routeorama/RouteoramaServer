package com.example.routeoramaserver.controllers.place.post.rmi;

import com.example.routeoramaserver.callbacks.place.post.IPostServerCallback;
import com.example.routeoramaserver.callbacks.place.post.PostClientCallback;
import com.example.routeoramaserver.models.Comment;
import com.example.routeoramaserver.models.CommentContainer;
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
    public void LikeThePost(int postId, int userId) {
        try {
            server.LikeThePost(postId, userId);
        } catch (RemoteException e) {
            System.out.println("Could not contact server when liking a post.");
        }
    }

    @Override
    public void UnlikeThePost(int postId, int userId) {
        try {
            server.UnlikeThePost(postId, userId);
        } catch (RemoteException e) {
            System.out.println("Could not contact server when checking if post is liked.");
        }
    }

    @Override
    public boolean IsAlreadyLiked(int postId, int userId) {
        try {
            return server.IsAlreadyLiked(postId, userId);
        } catch (RemoteException e) {
            System.out.println("Could not contact server when checking if post is liked.");
        }
        return false;
    }

    @Override
    public PostContainer GetPostsForNewsFeed(int userId) {
        try{
            return server.GetPostsForNewsFeed(userId);
        } catch (RemoteException e){
            System.out.println("Could not get feed from server");
        }
        return null;
    }

    @Override
    public PostContainer LoadMorePostsForNewsFeed(int userId, int postId) {
        try{
            return server.LoadMorePostsForNewsFeed(userId, postId);
        } catch (RemoteException e){
            System.out.println("Could not load feed from server");
        }
        return null;
    }

    @Override
    public void Comment(Comment comment) {
        try{
            server.Comment(comment);
        } catch (RemoteException e){
            System.out.println("Could not comment");
        }
    }

    @Override
    public void DeleteComment(Comment comment) {
        try{
            server.DeleteComment(comment);
        } catch (RemoteException e){
            System.out.println("Could not delete comment");
        }
    }

    @Override
    public CommentContainer GetCommentForPost(int postId) {
        try{
            return server.GetCommentForPost(postId);
        } catch (RemoteException e){
            System.out.println("Could not fetch comment for post"  + e );
        }
        return null;
    }

    @Override
    public CommentContainer LoadMoreComments(Comment lastComment) {
        try{
            return server.LoadMoreComments(lastComment);
        } catch (RemoteException e){
            System.out.println("Could not fetch more comments for post");
        }
        return null;
    }
}
