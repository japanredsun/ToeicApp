package com.japanredsun.Dao;

import com.japanredsun.Model.User;
import java.util.List;

public interface UserDAO {

    List<User> getAllUsers();

    User getUserByUsername(String username);

}
