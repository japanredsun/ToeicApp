package com.japanredsun.Dao.Implement;

import com.japanredsun.Dao.DataProvider;
import com.japanredsun.Dao.UserDAO;
import com.japanredsun.Model.User;
import com.japanredsun.Model.UserInfo;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImp implements UserDAO {

    private DataProvider dataProvider = new DataProviderImp();

    public List<User> getAllUsers() throws SQLException, ClassNotFoundException {
        List<User> users = new ArrayList<User>();
        String sql = "SELECT * From users WHERE active = 1";
        ResultSet rs = null;
            rs = dataProvider.executeReader(sql);
            while (rs.next()){
                long id = rs.getLong("id");
                String username = rs.getString("username");
                String password = rs.getString("password");
                Date createdDate = rs.getDate("created_date");
                String role = rs.getString("role");
                User user = new User(id,username,password,role,createdDate);
                users.add(user);
            }
            rs.close();
            dataProvider.closeDB();
        return users;
    }

    public User getUserByUsername(String username) throws SQLException, ClassNotFoundException {
        User user = null;
            dataProvider.initializeDB();
            String sql = "SELECT * FROM users WHERE active = 1 AND username = ?";
            PreparedStatement ps = dataProvider.getConn().prepareStatement(sql);
            ps.setString(1,username);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                long id = rs.getLong("id");
                String password = rs.getString("password");
                Date createdDate = rs.getDate("created_date");
                String role = rs.getString("role");
                user = new User(id,username,password,role,createdDate);
            }
            rs.close();
            ps.close();
            dataProvider.closeDB();
        return user;
    }

    public UserInfo getUserInfo(String username) throws SQLException, ClassNotFoundException {
        dataProvider.initializeDB();
        String sql = "SELECT totalpoint,grade FROM users WHERE username = ?";
        PreparedStatement ps = dataProvider.getConn().prepareStatement(sql);
        ps.setString(1,username);
        ResultSet rs = ps.executeQuery();
        UserInfo userInfo = null;
        if(rs.next()){
            Integer totalPoint = rs.getInt("total_point");
            String grade = rs.getString("grade");
            userInfo = new UserInfo(username,totalPoint,grade);
        }
        rs.close();
        ps.close();
        return userInfo;
    }
}
