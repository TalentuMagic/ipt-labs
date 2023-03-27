package com.wad.firstmvc.services;

import com.wad.firstmvc.domain.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    List<User> findUserByName(String name);

    List<User> findUserByEmail(String email);

    List<User> findUserByAge(int age);

    User save(User p);
}
