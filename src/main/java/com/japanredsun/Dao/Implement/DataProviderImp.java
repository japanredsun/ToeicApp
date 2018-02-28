package com.japanredsun.Dao.Implement;

import com.japanredsun.AppConfig;
import com.japanredsun.Dao.DataProvider;

import java.sql.*;

public class DataProviderImp implements DataProvider {

    private Connection conn = null;
    private Statement stmt = null;

    public Connection getConn() {
        return conn;
    }

    public void initializeDB() throws ClassNotFoundException,SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection(AppConfig.getDbUrl(),AppConfig.getUSER(),AppConfig.getPASS());
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
        finalyCheck();
    }



}
