package com.yppcat.community.serviceImpl;

import com.yppcat.community.constant.ResultCode;
import com.yppcat.community.entity.User;
import com.yppcat.community.repository.UserRepository;
import com.yppcat.community.result.Result;
import com.yppcat.community.result.ResultUtil;
import com.yppcat.community.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public Result addUser(String userName, String passWord, String emailAddress, String headerImage, String phoneNumber) {
        if (userRepository.findByUserName(userName).size() > 0) {
            return ResultUtil.error(ResultCode.CODE_ERROR_DATA, "用户名已存在");
        } else if (passWord.length() < 6) {
            return ResultUtil.error(ResultCode.CODE_ERROR_DATA, "密码长度不足6位");
        } else {
            User user = new User();
            user.setUserName(userName);
            user.setPassWord(passWord);
            user.setEmailAddress(emailAddress);
            user.setPhoneNumber(phoneNumber);
            user.setHeaderImage(headerImage);
            return ResultUtil.success(userRepository.save(user));
        }
    }

    @Override
    @Transactional
    public Result userLogin(String userName, String passWord) {
        if (passWord.length() < 6) {
            return ResultUtil.error(ResultCode.CODE_ERROR_DATA, "密码长度不足6位");
        } else {
            List<User> userList = userRepository.findByUserName(userName);
            if (userList.size() > 0) {
                User user = userList.get(0);
                if (!user.getPassWord().isEmpty() && user.getPassWord().equals(passWord)) {
                    return ResultUtil.success(user);
                } else {
                    return ResultUtil.error(ResultCode.CODE_ERROR_DATA, "密码错误");
                }
            } else {
                return ResultUtil.error(ResultCode.CODE_ERROR_DATA, "用户名不存在");
            }
        }
    }
}
