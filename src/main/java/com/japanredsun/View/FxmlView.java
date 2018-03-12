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
            return AppConfig.FXMLPATH + "MainPage.fxml";
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
    },
    UPDATE{
        @Override
        public String getFxmlFile() {
            return AppConfig.FXMLPATH + "UpdateBox.fxml";
        }

        @Override
        public String getTitle() {
            return "Update Box";
        }
    },
    UPDATE_DETAIL{
        @Override
        public String getTitle() {
            return "Question Detail";
        }

        @Override
        public String getFxmlFile() {
            return AppConfig.FXMLPATH + "questionDetail.fxml";
        }
    };

    public abstract String getFxmlFile();
    public abstract String getTitle();
}
