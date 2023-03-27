package com.wad.firstmvc.services;

import java.util.List;

import com.wad.firstmvc.domain.User;

public interface UserService {
    List<User> findAll();

    User findUserByName(String name);

    User findUserByEmail(String email);

    User findUserByAge(int age);

    User saveUser(User p);
}
