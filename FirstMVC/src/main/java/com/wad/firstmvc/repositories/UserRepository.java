package com.wad.firstmvc.repositories;

import java.util.List;

// import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.wad.firstmvc.domain.User;

// course implementation
// public interface UserRepository extends CrudRepository<User, Long> {
//     List<User> findAll(); // overrides findAll to return a List

//     List<User> findByName(String name);

//     List<User> findByEmail(String email);

//     List<User> findByAge(int age);

//     List<User> findByCardsEmpty();
// }

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findAll();

    User findByUsername(String username);

    User findByName(String name);

    User findByEmail(String email);

    User findByAge(int age);
}
