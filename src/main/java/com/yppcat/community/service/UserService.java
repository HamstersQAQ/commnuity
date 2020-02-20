package com.yppcat.community.service;

import com.yppcat.community.result.Result;
import org.springframework.stereotype.Component;

@Component
public interface UserService {

     Result addUser(String userName, String passWord, String emailAddress, String headerImage, String phoneNumber);

     Result userLogin(String userName, String passWord);
}
