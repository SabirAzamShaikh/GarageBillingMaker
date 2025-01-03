package com.Garage.GarageBillingMaker.service;

import com.Garage.GarageBillingMaker.Entity.User;
import com.Garage.GarageBillingMaker.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService
{
private UserRepo repo;
@Autowired
private PasswordEncoder encoder;
    public UserService(UserRepo repo) {
        this.repo = repo;
    }


public User saveuser(User user)
{
    user.setPassword(encoder.encode(user.getPassword()));
    return  repo.save(user);
}

}
