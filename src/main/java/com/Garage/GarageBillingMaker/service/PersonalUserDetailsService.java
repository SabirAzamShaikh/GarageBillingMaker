package com.Garage.GarageBillingMaker.service;

import com.Garage.GarageBillingMaker.Entity.PersonalUserDetails;
import com.Garage.GarageBillingMaker.Entity.User;
import com.Garage.GarageBillingMaker.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PersonalUserDetailsService implements UserDetailsService
{
    @Autowired
    private PasswordEncoder encoder;
private UserRepo repo;

    public PersonalUserDetailsService(UserRepo repo)
    {
        this.repo = repo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {

        User user=repo.findByUsername(username);
       if(user==null)
       {
           throw new UsernameNotFoundException("Username not found");
       }

return new PersonalUserDetails(user);

                    }
}
//        return org.springframework.security.core.userdetails.User
//                .withUsername(user.getUsername())
//                .password(user.getPassword())
//                .roles(user.getRole())
//                .build();