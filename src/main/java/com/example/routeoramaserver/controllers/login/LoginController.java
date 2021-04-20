package com.example.routeoramaserver.controllers.login;

import com.example.routeoramaserver.controllers.login.rmi.ILoginClient;
import com.example.routeoramaserver.controllers.login.rmi.LoginClient;
import com.example.routeoramaserver.models.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class LoginController {
    private ILoginClient loginClient;

    public LoginController(){
        loginClient = new LoginClient();
        loginClient.Start();
    }

    @PostMapping(value = "/login", consumes = "application/json", produces = "application/json")
    public User Login(@RequestBody User user){
        return loginClient.Login(user.getUsername(), user.getPassword());
    }

    // ask about the use of a session ID
    // safer than sending the data directly
    // can be used for anything auth related after first log-in
    @PostMapping("/logout")
    public void Logout(){
        loginClient.Logout();
    }
}
