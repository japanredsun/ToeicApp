package com.japanredsun.Service.Implement;

import com.japanredsun.AppConfig;
import com.japanredsun.Dao.Implement.UserDAOImp;
import com.japanredsun.Dao.UserDAO;
import com.japanredsun.Model.User;
import com.japanredsun.Model.UserInfo;
import com.japanredsun.Service.UserService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserServiceImp extends ServiceImp implements UserService {

    private UserDAO userDAO = new UserDAOImp();

    public List<User> getAllUsers() throws SQLException, ClassNotFoundException {
        List<User> list = userDAO.getAllUsers();
        List<User> newList = new ArrayList<>();
            for (User user :
                    list) {
                if(user.getIsActive() != null) {
                    int status = Integer.parseInt(user.getIsActive());
                    switch (status) {
                        case 1: {
                            user.setIsActive("Active");
                            break;
                        }
                        case 0: {
                            user.setIsActive("Inactive");
                            break;
                        }
                        default:
                            user.setIsActive("Active");
                    }
                    newList.add(user);
                }
            }
        return newList;
    }

    public User getUserByUsername(String username) throws SQLException, ClassNotFoundException {
        return userDAO.getUserByUsername(username);
    }

    public boolean authenticate(String username, String password) throws SQLException, ClassNotFoundException {
        User user = this.getUserByUsername(username);
        if(user != null){
            if(password.equals(user.getPassword())){
                AppConfig.setLoginUser(user);
                System.out.println("Login success");
                return true;
            }else{
                System.out.println("Wrong password");
                return false;
            }
        }else {
            System.out.println("User not found");
            return false;
        }
    }

    public UserInfo getUserInfo(String username) throws SQLException, ClassNotFoundException {
        return userDAO.getUserInfo(username);
    }

    @Override
    public void save(User user) throws SQLException, ClassNotFoundException {
        if(user.getId() > 0){
            userDAO.update(user);
            System.out.println("Update success");
        }else {
            userDAO.insert(user);
            System.out.println("Insert success");
        }
    }

    @Override
    public void detele(long id) throws SQLException, ClassNotFoundException {
        userDAO.delete(id);
    }

    @Override
    public void updateUserInfo(UserInfo userInfo) throws SQLException, ClassNotFoundException {
        userDAO.updateUserInfo(userInfo);
    }

}
