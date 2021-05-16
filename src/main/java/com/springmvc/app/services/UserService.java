package com.springmvc.app.services;

import com.springmvc.app.domain.User;
import com.springmvc.app.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public List<User> getAllUsersRecords() {
        List<User> userList = userRepository.findAll();
        return userList;
    }

    public void saveUserIntoDB(User user) {
        this.userRepository.save(user);
    }
}
