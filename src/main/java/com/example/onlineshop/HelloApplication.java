package com.example.onlineshop;

import View.Stg_HomePage;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) {
        Stg_HomePage homePage = new Stg_HomePage();
        homePage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}