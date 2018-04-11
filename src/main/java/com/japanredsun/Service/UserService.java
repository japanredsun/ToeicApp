package com.japanredsun.Service;

import com.japanredsun.Model.Status;
import com.japanredsun.Model.User;
import com.japanredsun.Model.UserInfo;
import javafx.collections.ObservableList;

import java.sql.SQLException;
import java.util.List;

public interface UserService extends Service{
    List<User> getAllUsers() throws SQLException, ClassNotFoundException;

    User getUserByUsername(String username) throws SQLException, ClassNotFoundException;

    boolean authenticate(String username, String password) throws SQLException, ClassNotFoundException;

    UserInfo getUserInfo(String username) throws SQLException, ClassNotFoundException;

    void save(User user) throws SQLException, ClassNotFoundException;

    void detele(long id) throws SQLException, ClassNotFoundException;

    void updateUserInfo(UserInfo userInfo) throws SQLException, ClassNotFoundException;
}
