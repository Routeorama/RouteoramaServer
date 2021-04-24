package com.example.routeoramaserver.controllers.user;

import com.example.routeoramaserver.controllers.user.rmi.IUserClient;
import com.example.routeoramaserver.controllers.user.rmi.UserClient;
import com.example.routeoramaserver.models.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class UserController {
    private IUserClient userClient;

    public UserController(){
        userClient = new UserClient();
        userClient.Start();
    }

    @PostMapping(value = "/login", consumes = "application/json", produces = "application/json")
    public User Login(@RequestBody User user){
        User returnedUser = userClient.Login(user.getUsername(), user.getPassword());
        return returnedUser;
    }

    // ask about the use of a session ID
    // safer than sending the data directly
    // can be used for anything auth related after first log-in
    @PostMapping("/logout")
    public void Logout(){
        userClient.Logout();
    }

    @PostMapping(value = "/register", consumes = "application/json", produces = "application/json")
    public boolean Register(@RequestBody User user){
        return userClient.Register(user);
    }
}
