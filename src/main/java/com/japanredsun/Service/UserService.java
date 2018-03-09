package com.japanredsun.Service;

import com.japanredsun.Model.User;
import com.japanredsun.Model.UserInfo;

import java.sql.SQLException;
import java.util.List;

public interface UserService {
    List<User> getAllUsers() throws SQLException, ClassNotFoundException;

    User getUserByUsername(String username) throws SQLException, ClassNotFoundException;

    boolean authenticate(String username, String password) throws SQLException, ClassNotFoundException;

    UserInfo getUserInfo(String username) throws SQLException, ClassNotFoundException;


}
