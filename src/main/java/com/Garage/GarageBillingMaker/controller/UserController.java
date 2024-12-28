package com.Garage.GarageBillingMaker.controller;

import com.Garage.GarageBillingMaker.Entity.User;
import com.Garage.GarageBillingMaker.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController
{
    private UserService service;

    public UserController(UserService service)
    {
        this.service = service;
    }

    @PostMapping("/createuser")
public User madeuser(@RequestBody User user)
{
    return service.saveuser(user);
}

}
