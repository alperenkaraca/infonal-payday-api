package com.paydaybank.work.service;

import com.paydaybank.work.entity.User;
import com.paydaybank.work.message.response.UserInfoResponse;
import com.paydaybank.work.repository.UserRepository;
import com.paydaybank.work.security.services.UserPrinciple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final  UserRepository userRepository;

    @Autowired
    public UserService(  UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserInfoResponse findUser() {
        Authentication authentication=  SecurityContextHolder.getContext().getAuthentication();
        UserPrinciple userPrinciple = (UserPrinciple) authentication.getPrincipal();
        Optional<User> user = userRepository.findById(userPrinciple.getId());
        User userInfo = user.orElse(null);
        if(userInfo!=null){
            return new UserInfoResponse(
                    userInfo.getUsername(),
                    userInfo.getEmail(),
                    userInfo.getTitle()
            );
        }
        return null;
    }
}
