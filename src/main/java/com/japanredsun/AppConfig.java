package com.japanredsun;

import com.japanredsun.Model.User;

public class AppConfig {

    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/javafx";

    //  Database credentials
    private static final String USER = "root";
    private static final String PASS = "24635701";

    //Principal
    private static User loginUser;

    //Fxml Resource path
    public static final String FXMLPATH = "/fxml/";

    //Resource path
    public static final String AUDIO_PATH = "/audio/";
    public static final String PICTURE_PATH = "/picture/";

    public static User getLoginUser() {
        return loginUser;
    }

    public static void setLoginUser(User loginUser) {
        AppConfig.loginUser = loginUser;
    }

    public static String getJdbcDriver() {
        return JDBC_DRIVER;
    }

    public static String getDbUrl() {
        return DB_URL;
    }

    public static String getUSER() {
        return USER;
    }

    public static String getPASS() {
        return PASS;
    }
}
