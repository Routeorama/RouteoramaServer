package com.example.routeoramaserver.networking;

import java.rmi.Remote;

public interface IServer {
    void Start();
    String FetchData();
}
