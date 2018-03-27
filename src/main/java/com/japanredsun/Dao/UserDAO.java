package com.japanredsun.Dao;

import com.japanredsun.Model.User;
import com.japanredsun.Model.UserInfo;

import java.sql.SQLException;
import java.util.List;

public interface UserDAO {

    List<User> getAllUsers() throws SQLException, ClassNotFoundException;

    User getUserByUsername(String username) throws SQLException, ClassNotFoundException;

    UserInfo getUserInfo(String username) throws SQLException, ClassNotFoundException;

    void insert(User user) throws SQLException, ClassNotFoundException;

    void update(User user) throws SQLException, ClassNotFoundException;

    void delete(long id) throws SQLException, ClassNotFoundException;

}
