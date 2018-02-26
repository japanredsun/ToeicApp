package com.japanredsun.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface DataProvider {

    void initializeDB() throws ClassNotFoundException, SQLException;

    ResultSet executeReader(String sql) throws SQLException, ClassNotFoundException;

    void finalyCheck();

    void closeDB() throws SQLException;
}
