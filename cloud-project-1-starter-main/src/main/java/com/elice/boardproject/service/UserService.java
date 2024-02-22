package com.elice.boardproject.service;

import com.elice.boardproject.entity.User;

public interface UserService {
    User getUserById(int id);
    void saveUser(User user);
}
