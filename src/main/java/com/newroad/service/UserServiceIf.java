package com.newroad.service;

import com.newroad.entity.User;

import java.util.List;
public interface UserServiceIf {
    List<User> getUsers();
    boolean addAccount(User account);
}
