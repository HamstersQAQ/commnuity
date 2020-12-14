package com.yppcat.community.controller;

import com.yppcat.community.result.Result;
import com.yppcat.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/user/add")
    public Result addUser(@RequestParam("userName") String userName,
                          @RequestParam("passWord") String passWord,
                          @RequestParam("emailAddress") String emailAddress,
                          @RequestParam("headerImage") String headerImage,
                          @RequestParam("phoneNumber") String phoneNumber) {

        return userService.addUser(userName, passWord, emailAddress, headerImage, phoneNumber);
    }

    @GetMapping(value = "user/login")
    public Result userLogin(@RequestParam("userName") String userName,
                            @RequestParam("passWord") String passWord) {
        return userService.userLogin(userName, passWord);
    }
}
