package com.paydaybank.work.controller;

import com.paydaybank.work.message.response.UserInfoResponse;
import com.paydaybank.work.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {


    private final UserService userService;

    @Autowired
    public UserController( UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public ResponseEntity<UserInfoResponse> getAllItems() {
        return ResponseEntity.ok(userService.findUser());
    }
}
