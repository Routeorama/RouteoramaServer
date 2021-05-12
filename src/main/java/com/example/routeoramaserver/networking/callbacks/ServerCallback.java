package com.example.routeoramaserver.networking.callbacks;

import com.example.routeoramaserver.callbacks.place.IPlaceServerCallback;
import com.example.routeoramaserver.callbacks.place.post.IPostServerCallback;
import com.example.routeoramaserver.callbacks.user.IUserServerCallback;


import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServerCallback extends Remote {
    IUserServerCallback getUserServer() throws RemoteException;
    IPlaceServerCallback getPlaceServer() throws RemoteException;
    IPostServerCallback getPostServer() throws RemoteException;
}
