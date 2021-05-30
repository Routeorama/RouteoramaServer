package com.example.routeoramaserver.controllers.user;

import com.example.routeoramaserver.controllers.user.model.IUserModel;
import com.example.routeoramaserver.controllers.user.model.UserModel;
import com.example.routeoramaserver.controllers.user.rmi.IUserClient;
import com.example.routeoramaserver.controllers.user.rmi.UserClient;
import com.example.routeoramaserver.models.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class UserController {
    private IUserClient userClient;
    private IUserModel userModel;

    public UserController(){
        userClient = new UserClient();
        userModel = new UserModel();
        userClient.Start();
    }

    @PostMapping(value = "/login", consumes = "application/json", produces = "application/json")
    public User Login(@RequestBody User user){
        return userClient.Login(user.getUsername(), user.getPassword());
    }

    @PostMapping(value = "/register", consumes = "application/json", produces = "application/json")
    public boolean Register(@RequestBody User user){
        return userClient.Register(userModel.ValidateUser(user));
    }


    @PostMapping(value = "/updateuser", consumes = "application/json", produces = "application/json")
    public String UpdateUser(@RequestBody User user){
        return userClient.UpdateUser(userModel.ValidateUser(user));
    }
}
