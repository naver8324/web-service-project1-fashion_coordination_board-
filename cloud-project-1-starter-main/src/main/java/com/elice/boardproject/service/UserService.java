package com.elice.boardproject.service;

import com.elice.boardproject.entity.User;
import com.elice.boardproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User getUserById(int id){
        return userRepository.findById(id).orElse(null);
    }
    
    public void saveUser(User user){
        userRepository.save(user);
    }
}
