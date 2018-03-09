package com.japanredsun.View;

import com.japanredsun.AppConfig;

public enum FxmlView {

    ADMIN{
        @Override
        public String getTitle() {
            return "Admin Panel";
        }

        @Override
        public String getFxmlFile() {
            return AppConfig.FXMLPATH + "AdminPage.fxml";
        }
    },
    HOME{
        @Override
        public String getTitle() {
            return "Toeic Application";
        }

        @Override
        public String getFxmlFile() {
            return AppConfig.FXMLPATH + "sample2.fxml";
        }
    },
    LOGIN{
        @Override
        public String getTitle() {
            return "Login";
        }

        @Override
        public String getFxmlFile() {
            return AppConfig.FXMLPATH + "Login.fxml";
        }
    };

    public abstract String getFxmlFile();
    public abstract String getTitle();
}
