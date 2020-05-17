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
                    userInfo.getTitle(),
                    userInfo.getId()
            );
        }
        return null;
    }

    public UserInfoResponse updateUserInfo(UserInfoResponse userInfo) {
        Optional<User> user = userRepository.findById(userInfo.getId());
        User updatedInfo = user.orElse(null);
        updatedInfo.setEmail(userInfo.getEmail());
        updatedInfo.setTitle(userInfo.getTitle());
        updatedInfo.setUsername(userInfo.getUsername());
        userRepository.save(updatedInfo);
        if(updatedInfo!=null){
            return new UserInfoResponse(
                    updatedInfo.getUsername(),
                    updatedInfo.getEmail(),
                    updatedInfo.getTitle(),
                    updatedInfo.getId()
            );
        }
        return null;
    }
}
