package com.japanredsun.Dao;

import com.japanredsun.AppConfig;

import java.sql.*;

public class DataProviderImp implements DataProvider {

    private Connection conn = null;
    private Statement stmt = null;

    public void initializeDB() throws ClassNotFoundException,SQLException{

        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("Driver loaded");

        conn = DriverManager.getConnection(AppConfig.DB_URL,AppConfig.USER,AppConfig.PASS);
        System.out.println("Database connected");

        this.stmt = conn.createStatement();
    }

    public ResultSet executeReader(String sql) throws SQLException, ClassNotFoundException {
        initializeDB();
        return stmt.executeQuery(sql);
    }

    public void finalyCheck(){
        if(stmt != null){
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(conn != null){
            try {
                conn.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }

    public void closeDB() throws SQLException {
        stmt.close();
        conn.close();
    }

}
