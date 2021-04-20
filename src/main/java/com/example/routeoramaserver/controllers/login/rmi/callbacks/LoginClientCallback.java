package com.example.routeoramaserver.controllers.login.rmi.callbacks;

import java.rmi.Remote;

/*
* if the DB server needs to send data back, use interfaces like these
* instead of sync waiting for a return to finish, use another method that gets called remotely by the DB server
* send any data necessary as an argument
* */
public interface LoginClientCallback extends Remote {
}
