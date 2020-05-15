package com.paydaybank.work.mocks;

import com.paydaybank.work.entity.Role;
import com.paydaybank.work.entity.RoleName;
import com.paydaybank.work.entity.User;
import com.paydaybank.work.repository.RoleRepository;
import com.paydaybank.work.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.sql.Timestamp;
import java.util.*;

@Configuration
public class CreateMockData {


    @Autowired
    PasswordEncoder encoder;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Bean
    public CommandLineRunner initializeRoles(RoleRepository roleRepository) {
        if (roleRepository.count() == 0) {
            return args -> {
                roleRepository.save(new Role(RoleName.ROLE_USER));
                roleRepository.save(new Role(RoleName.ROLE_ADMIN));
            };
        }
        return null;

    }

    @Bean
    public CommandLineRunner initializeUser(UserRepository userRepository) {
        if (userRepository.count() == 0) {
            return args -> {
                Set<Role> roles = new HashSet<>();
                Optional<Role> userRole = roleRepository.findByName(RoleName.ROLE_USER);
                roles.add(userRole.get());
                userRepository.save(new User("username","deneme@deneme.com",encoder.encode("123456"),"BOSSS",roles));
            };
        }
        return null;

    }

}
