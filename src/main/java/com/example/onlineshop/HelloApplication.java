package com.example.onlineshop;

import View.Stg_Home;
import View.Stg_Login;
import javafx.application.Application;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) {
        Stg_Home homePage = new Stg_Home();
        Stg_Login loginPage = new Stg_Login();
        loginPage.show();
        //homePage.show();


    }

    public static void main(String[] args) {
        launch();
    }
}