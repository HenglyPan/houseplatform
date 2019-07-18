package com.newroad.controller;


import com.newroad.entity.User;
import com.newroad.service.UserServiceIf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@EnableTransactionManagement
public class UserController {
    @Autowired
    private UserServiceIf userService;

    @RequestMapping("user")


    
    public List<User> getUsers(){
        return userService.getUsers();
    }
}
