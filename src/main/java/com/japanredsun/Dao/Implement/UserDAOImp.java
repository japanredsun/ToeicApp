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
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserDAOImp implements UserDAO {

    private static final Logger LOG = Logger.getLogger(UserDAOImp.class.getName());

    private DataProvider dataProvider = new DataProviderImp();

    public List<User> getAllUsers() throws SQLException, ClassNotFoundException {
        List<User> users = new ArrayList<User>();
        String sql = "SELECT * From users";
        ResultSet rs = null;
            rs = dataProvider.executeReader(sql);
            while (rs.next()){
                long id = rs.getLong("id");
                String username = rs.getString("username");
                String password = rs.getString("password");
                Date createdDate = rs.getDate("created_date");
                String role = rs.getString("role");
                String status = rs.getString("active");
                User user = new User(id,username,password,role,createdDate,status);
                users.add(user);
                LOG.log(Level.INFO,"Select " + username);
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
                String status = rs.getString("active");
                user = new User(id,username,password,role,createdDate,status);
                LOG.log(Level.INFO,"Select " + username);
            }
            rs.close();
            ps.close();
            dataProvider.closeDB();
        return user;
    }

    public UserInfo getUserInfo(String username) throws SQLException, ClassNotFoundException {
        dataProvider.initializeDB();
        String sql = "SELECT total_point,grade FROM users WHERE username = ?";
        PreparedStatement ps = dataProvider.getConn().prepareStatement(sql);
        ps.setString(1,username);
        ResultSet rs = ps.executeQuery();
        UserInfo userInfo = null;
        if(rs.next()){
            Integer totalPoint = rs.getInt("total_point");
            String grade = rs.getString("grade");
            userInfo = new UserInfo(username,totalPoint,grade);
            LOG.log(Level.INFO,"Select UserInfo " + username);
        }
        rs.close();
        ps.close();
        return userInfo;
    }

    @Override
    public void insert(User user) throws SQLException, ClassNotFoundException {
        dataProvider.initializeDB();
        String sql = "INSERT INTO users(username,password,active,role) VALUES(?,?,?,?)";
        PreparedStatement ps = dataProvider.getConn().prepareStatement(sql);
        ps.setString(1,user.getUsername());
        ps.setString(2,user.getPassword());
        ps.setString(3,user.getIsActive());
        ps.setString(4,user.getRole());
        ps.executeUpdate();
        ps.close();
        dataProvider.closeDB();
        LOG.log(Level.INFO,"Insert " + user.getUsername());
    }

    @Override
    public void update(User user) throws SQLException, ClassNotFoundException {
        dataProvider.initializeDB();
        String sql = "UPDATE users SET username = ?, password=?, role=?, active=? WHERE id=?";
        PreparedStatement ps = dataProvider.getConn().prepareStatement(sql);
        ps.setString(1,user.getUsername());
        ps.setString(2,user.getPassword());
        ps.setString(3,user.getRole());
        ps.setString(4,user.getIsActive());
        ps.setLong(5,user.getId());
        ps.executeUpdate();
        ps.close();
        dataProvider.closeDB();
        LOG.log(Level.INFO,"Update " + user.getUsername());
    }

    @Override
    public void delete(long id) throws SQLException, ClassNotFoundException {
        dataProvider.initializeDB();
        String sql ="DELETE FROM users WHERE id=?";
        PreparedStatement ps = dataProvider.getConn().prepareStatement(sql);
        ps.setLong(1,id);
        ps.executeUpdate();
        ps.close();
        dataProvider.closeDB();
        LOG.log(Level.INFO,"Delete " + id);
    }
}
