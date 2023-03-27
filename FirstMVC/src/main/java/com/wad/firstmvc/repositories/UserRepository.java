package com.wad.firstmvc.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.wad.firstmvc.domain.User;

public interface UserRepository extends CrudRepository<User, Long> {
    List<User> findAll(); // overrides findAll to return a List

    List<User> findByName(String name);

    List<User> findByEmail(String email);

    List<User> findByAge(int age);

    List<User> findByCardsEmpty();
}