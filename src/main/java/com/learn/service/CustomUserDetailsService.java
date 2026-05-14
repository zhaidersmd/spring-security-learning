package com.learn.service;

import com.learn.entity.Users;
import com.learn.repository.UserDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserDetailsRepo userDetailsRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //return userDetailsRepo.findByUsername(username).orElseThrow(() ->  new UsernameNotFoundException(""));


        Users user = userDetailsRepo.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        

        return user;
    }
}
