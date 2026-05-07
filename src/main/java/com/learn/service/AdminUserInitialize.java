package com.learn.service;

import com.learn.entity.Users;
import com.learn.repository.UserDetailsRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class AdminUserInitialize {

    @Bean
    public CommandLineRunner createAdminUser(UserDetailsRepo userDetailsRepo, PasswordEncoder passwordEncoder) {
        return args -> {
            if (!userDetailsRepo.findByUsername("admin").isPresent()) {
                Users user = new Users();
                user.setUsername("zhaider");
                user.setPassword(passwordEncoder.encode("infa@123"));
                user.setRole("ROLE_ADMIN");
                userDetailsRepo.save(user);
                System.out.println("Default admin user created");
            }


        };
    }
}
