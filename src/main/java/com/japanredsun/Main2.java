package com.japanredsun;

import com.japanredsun.Model.User;
import com.japanredsun.Service.Implement.UserServiceImp;
import com.japanredsun.Service.UserService;

import java.util.ArrayList;
import java.util.List;

public class Main2 {
    public static void main(String[] args){
        UserService userService = new UserServiceImp();

        List<User> users;

        users = userService.getAllUsers();

        for (User user :
                users) {
            System.out.println(user.toString());
        }

        User user = userService.getUserByUsername("Japanredsun");
        System.out.println(user.toString());
    }
}
