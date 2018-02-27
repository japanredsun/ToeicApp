package com.japanredsun.Service;

import com.japanredsun.Model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    User getUserByUsername(String username);

    boolean authenticate(String username, String password);
}
