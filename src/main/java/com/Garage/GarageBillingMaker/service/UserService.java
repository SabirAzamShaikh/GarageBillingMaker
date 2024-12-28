package com.Garage.GarageBillingMaker.service;

import com.Garage.GarageBillingMaker.Entity.User;
import com.Garage.GarageBillingMaker.repository.UserRepo;
import org.springframework.stereotype.Service;

@Service
public class UserService
{
private UserRepo repo;

    public UserService(UserRepo repo) {
        this.repo = repo;
    }

public User saveuser(User user)
{
    return  repo.save(user);
}

}
