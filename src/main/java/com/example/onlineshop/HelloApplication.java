package com.example.onlineshop;

import Controller.StuffController;
import Controller.UserController;
import Model.Comment;
import Model.Stuffs.DigitalStuffs.DataStoring.SSD;
import Model.Stuffs.DigitalStuffs.PC;
import Model.User.Buyer;
import View.Stg_Home;
import View.Stg_PaymentGateway;
import View.Stg_Profile;
import javafx.application.Application;
import javafx.stage.Stage;


public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) {
        Stg_Home homePage = new Stg_Home();
        homePage.show();

    }

    public static void main(String[] args) {
        PC pc = new PC("Asus", 25000, 5, 1.4, 30, 5, 20, "i7-11700", "20");
        PC pc2 = new PC("Lenovo", 27000, 8, 1.6, 25, 4, 18, "i5-1065", "2");
        SSD ssd = new SSD("Western Digital", 2400, 10, 0.2, 12, 3, 15, 256, 32, 43);

        Buyer buyer = new Buyer("hossein", "Aa123456.", "hossein@gmail.com", "09370248298");
        UserController.getUsers().add(buyer);

        Comment comment = new Comment(pc.getID(), "good quality", true, buyer);
        pc.getComments().add(comment);

        StuffController.getStuffs().add(ssd);
        StuffController.getStuffs().add(pc);
        StuffController.getStuffs().add(pc2);
        StuffController.getStuffs().add(ssd);
        StuffController.getStuffs().add(pc);
        StuffController.getStuffs().add(pc2);
        StuffController.getStuffs().add(ssd);
        StuffController.getStuffs().add(pc);
        StuffController.getStuffs().add(pc2);


        launch();
    }
}