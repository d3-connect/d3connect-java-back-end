package io.d3connect.d3connect.service;

import io.d3connect.d3connect.domain.User;
import io.d3connect.d3connect.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    //Create or Update User
    public User createOrUpdateUser(User user) {
        return userRepository.save(user);
    }

    // Find All Users
    public Iterable<User> findAllUsers() {
      return userRepository.findAll();
    }


    // Find one user
    public User findUserById(Long id) {
        User user = userRepository.findUserById(id);
        return user;
    }

    // Delete User
    public void  deleteUserById(Long id) {
        User user  = userRepository.findUserById(id);
        userRepository.delete(user);
    }

}
