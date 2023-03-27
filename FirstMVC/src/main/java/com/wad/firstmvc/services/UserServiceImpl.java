package com.wad.firstmvc.services;

import com.wad.firstmvc.domain.User;
import com.wad.firstmvc.repositories.UserRepository;

import java.util.List;

import org.springframework.stereotype.Service;

// old way of creating users
// @Service
// public class UserServiceImpl implements UserService {
//     List<User> users = new ArrayList(List.of(
//             new User(13L, "Mike", 35),
//             new User(15L, "John", 21),
//             new User(19L, "Hannah", 23)));

//     @Override
//     public List<User> findAll() {
//         return users;
//     }

//     @Override
//     public void save(User p) {
//         users.add(p);
//     }
// }

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> findAll() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public User findUserByName(String name) {
        return userRepository.findByName(name);
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User findUserByAge(int age) {
        return userRepository.findByAge(age);
    }
}