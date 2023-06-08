package View;

import Controller.StuffController;
import Controller.UserController;
import Model.Stuffs.Stuff;
import Model.User.Buyer;
import javafx.animation.ScaleTransition;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Separator;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;

public class Stg_Home {

    Stage stage = new Stage();

    public void show() {

        //Header{
        AnchorPane header = new AnchorPane();
        header.setBackground(new Background(new BackgroundFill(Color.DARKGRAY, new CornerRadii(0), new Insets(0))));
        showHeader(header);
        //}

        Separator separator = new Separator(Orientation.HORIZONTAL);

        //Body{
        ScrollPane scrollPane = new ScrollPane();
        TilePane tilePane_Stuffs = new TilePane();
        tilePane_Stuffs.setHgap(20);
        tilePane_Stuffs.setVgap(20);
        tilePane_Stuffs.setPadding(new Insets(15));
        tilePane_Stuffs.setAlignment(Pos.BASELINE_CENTER);
        tilePane_Stuffs.setBackground(new Background(new BackgroundFill(Color.GRAY, new CornerRadii(0), new Insets(0))));


        scrollPane.setContent(tilePane_Stuffs);
        scrollPane.setFitToWidth(true);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        scrollPane.setFitToHeight(true);


        VBox root = new VBox();
        root.setBackground(new Background(new BackgroundFill(Color.GRAY, new CornerRadii(0), new Insets(0))));
        showStuffs(tilePane_Stuffs);
        root.getChildren().addAll(header, separator, scrollPane);

        Scene scene = new Scene(root, 1000, 600);


        stage.setMinWidth(700);
        stage.setMinHeight(600);
        stage.setScene(scene);
        stage.setTitle("Home");
        stage.show();
    }

    public void showStuffs(TilePane tilePane) {

        ArrayList<Stuff> stuffs = StuffController.getStuffs();

        DropShadow shadow = new DropShadow();
        shadow.setHeight(0);
        shadow.setWidth(0);
        shadow.setColor(Color.web("#000000"));
        shadow.setSpread(0.1);
        shadow.setRadius(8);

        // Create component for show stuffs
        for (Stuff s : stuffs) {
            Label lbl_Name = new Label();
            lbl_Name.setFont(Font.font(lbl_Name.getFont().getFamily(), FontWeight.BOLD, 15));
            lbl_Name.setPadding(new Insets(0, 0, 30, 0));
            lbl_Name.setTextFill(Color.BLACK);

            Label lbl_Category = new Label();
            lbl_Category.setFont(Font.font(13));
            lbl_Category.setTextFill(Color.BLACK);
            lbl_Category.setPadding(new Insets(0, 0, 5, 0));

            Label lbl_Count = new Label();
            lbl_Count.setFont(Font.font(13));
            lbl_Count.setPadding(new Insets(0, 0, 5, 0));
            lbl_Count.setTextFill(Color.BLACK);

            Label lbl_AverageRate = new Label();
            lbl_AverageRate.setFont(Font.font(13));
            lbl_AverageRate.setTextFill(Color.BLACK);

            VBox vBox = new VBox(lbl_Category, lbl_Count, lbl_AverageRate);
            vBox.setAlignment(Pos.CENTER_LEFT);

            Label lbl_Price = new Label();
            lbl_Price.setFont(Font.font(15));
            lbl_Price.setFont(Font.font(lbl_Price.getFont().getFamily(), FontWeight.BOLD, 15));
            lbl_Price.setPadding(new Insets(30, 0, 0, 0));
            lbl_Price.setTextFill(Color.DARKRED);

            lbl_Name.setText("Name: " + s.getName());
            lbl_Category.setText("Category: " + s.getCategory().toString().toLowerCase());
            lbl_Count.setText("Count: " + s.getCount());
            lbl_AverageRate.setText("Rate: " + s.getAverageRate());
            lbl_Price.setText("Price: " + s.getPrice());

            VBox vBox_Stuff = new VBox();
            vBox_Stuff.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(10), new Insets(0))));
            vBox_Stuff.setCursor(Cursor.HAND);


            ScaleTransition scaleTransition = new ScaleTransition();
            scaleTransition.setNode(vBox_Stuff);
            scaleTransition.setDuration(Duration.seconds(0.2));
            //Hover Animation
            vBox_Stuff.setOnMouseEntered(event -> {
                // shadow on hover
                DropShadow hoverShadow = new DropShadow();
                hoverShadow.setColor(Color.BLACK);
                hoverShadow.setBlurType(BlurType.GAUSSIAN);
                hoverShadow.setRadius(20);
                hoverShadow.setWidth(20);
                hoverShadow.setHeight(20);
                hoverShadow.setSpread(0.3);

                scaleTransition.setToY(1.1);
                scaleTransition.setToX(1.1);
                scaleTransition.play();
                vBox_Stuff.setEffect(hoverShadow);
            });
            vBox_Stuff.setOnMouseExited(event -> {
                scaleTransition.setToX(1);
                scaleTransition.setToY(1);
                scaleTransition.play();
                vBox_Stuff.setEffect(shadow);
            });
            vBox_Stuff.setOnMouseClicked(event -> {
                Stg_Stuff stuffPage = new Stg_Stuff();
                stuffPage.ownerStage = stage;
                stuffPage.Show(s);
            });


            vBox_Stuff.getChildren().addAll(lbl_Name, vBox, lbl_Price);
            vBox_Stuff.setPrefWidth(170);
            vBox_Stuff.setPrefHeight(200);
            vBox_Stuff.setPadding(new Insets(10));
            vBox_Stuff.setAlignment(Pos.CENTER);
            vBox_Stuff.setEffect(shadow);


            tilePane.getChildren().add(vBox_Stuff);
        }
    }

    public void showHeader(AnchorPane header) {
        DropShadow dropShadow = new DropShadow();
        dropShadow.setBlurType(BlurType.GAUSSIAN);
        dropShadow.setColor(Color.web("#585858"));
        dropShadow.setHeight(2);
        dropShadow.setWidth(5);
        dropShadow.setRadius(15);
        dropShadow.setSpread(0.3);

        if (UserController.getLoggedInUser().getUsername() == "null") {
            Button btn_SignUp = new Button();
            btn_SignUp.setText("Sign Up");
            btn_SignUp.setPrefWidth(100);
            btn_SignUp.setPrefHeight(35);
            btn_SignUp.setMinWidth(60);
            btn_SignUp.setMinHeight(30);
            btn_SignUp.setBackground(new Background(new BackgroundFill(Color.BLACK, new CornerRadii(20), new Insets(0))));
            btn_SignUp.setFont(Font.font(btn_SignUp.getFont().getFamily(), FontWeight.BOLD, 13));
            btn_SignUp.setTextFill(Color.WHITE);
            btn_SignUp.setEffect(dropShadow);
            btn_SignUp.setCursor(Cursor.HAND);


            Button btn_Login = new Button();
            btn_Login.setText("Login");
            btn_Login.setPrefWidth(100);
            btn_Login.setPrefHeight(35);
            btn_Login.setMinWidth(60);
            btn_Login.setMinHeight(30);
            btn_Login.setFont(Font.font(btn_Login.getFont().getFamily(), FontWeight.BOLD, 13));
            btn_Login.setTextFill(Color.WHITE);
            btn_Login.setBackground(new Background(new BackgroundFill(Color.DARKRED, new CornerRadii(20), new Insets(0))));
            btn_Login.setEffect(dropShadow);
            btn_Login.setCursor(Cursor.HAND);

            AnchorPane.setTopAnchor(btn_SignUp, 20.0);
            AnchorPane.setLeftAnchor(btn_SignUp, 20.0);
            AnchorPane.setBottomAnchor(btn_SignUp, 20.0);

            AnchorPane.setLeftAnchor(btn_Login, 135.0);
            AnchorPane.setTopAnchor(btn_Login, 20.0);
            AnchorPane.setBottomAnchor(btn_Login, 20.0);

            //Events{
            btn_SignUp.setOnMouseEntered(event -> {
                btn_SignUp.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(20), new Insets(0))));
                btn_SignUp.setTextFill(Color.BLACK);
                btn_SignUp.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(20), new BorderWidths(1))));
            });
            btn_SignUp.setOnMouseExited(event -> {
                btn_SignUp.setBackground(new Background(new BackgroundFill(Color.BLACK, new CornerRadii(20), new Insets(0))));
                btn_SignUp.setTextFill(Color.WHITE);
            });
            btn_SignUp.setOnMouseClicked(event -> {
                stage.close();
                new Stg_SignUp().show();
            });

            btn_Login.setOnMouseEntered(event -> {
                btn_Login.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(20), new Insets(0))));
                btn_Login.setTextFill(Color.BLACK);
                btn_Login.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(20), new BorderWidths(1))));
            });
            btn_Login.setOnMouseExited(event -> {
                btn_Login.setBackground(new Background(new BackgroundFill(Color.DARKRED, new CornerRadii(20), new Insets(0))));
                btn_Login.setTextFill(Color.WHITE);
                btn_Login.setBorder(Border.EMPTY);
            });
            btn_Login.setOnMouseClicked(event -> {
                Stg_Login loginPage = new Stg_Login();
                stage.close();
                loginPage.show();
            });
            //}

            header.getChildren().addAll(btn_SignUp, btn_Login);
        }
        else {
            Button btn_Profile = new Button();
            btn_Profile.setText("Profile");
            btn_Profile.setPrefWidth(100);
            btn_Profile.setPrefHeight(35);
            btn_Profile.setMinWidth(60);
            btn_Profile.setMinHeight(30);
            btn_Profile.setBackground(new Background(new BackgroundFill(Color.DARKRED, new CornerRadii(20), new Insets(0))));
            btn_Profile.setFont(Font.font(btn_Profile.getFont().getFamily(), FontWeight.BOLD, 13));
            btn_Profile.setTextFill(Color.WHITE);
            btn_Profile.setEffect(dropShadow);
            btn_Profile.setCursor(Cursor.HAND);

            AnchorPane.setTopAnchor(btn_Profile, 20.0);
            AnchorPane.setLeftAnchor(btn_Profile, 20.0);
            AnchorPane.setBottomAnchor(btn_Profile, 20.0);

            //Events {
            btn_Profile.setOnMouseEntered(event -> {
                btn_Profile.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(20), new Insets(0))));
                btn_Profile.setTextFill(Color.BLACK);
                btn_Profile.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(20), new BorderWidths(1))));
            });
            btn_Profile.setOnMouseExited(event -> {
                btn_Profile.setBackground(new Background(new BackgroundFill(Color.DARKRED, new CornerRadii(20), new Insets(0))));
                btn_Profile.setTextFill(Color.WHITE);
                btn_Profile.setBorder(Border.EMPTY);
            });
            btn_Profile.setOnMouseClicked(event ->{
                stage.close();
                new Stg_Profile().show();
            });
            //}

            header.getChildren().add(btn_Profile);
        }

        Button btn_Cart = new Button();
        btn_Cart.setText("Cart");
        btn_Cart.setPrefWidth(100);
        btn_Cart.setPrefHeight(35);
        btn_Cart.setMinWidth(60);
        btn_Cart.setMinHeight(30);
        btn_Cart.setFont(Font.font(btn_Cart.getFont().getFamily(), FontWeight.BOLD, 13));
        btn_Cart.setTextFill(Color.WHITE);
        btn_Cart.setBackground(new Background(new BackgroundFill(Color.BLACK, new CornerRadii(20), new Insets(0))));
        btn_Cart.setEffect(dropShadow);
        btn_Cart.setCursor(Cursor.HAND);
        btn_Cart.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(20), new BorderWidths(1))));


        // Events{
        btn_Cart.setOnMouseEntered(event -> {
            btn_Cart.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(20), new Insets(0))));
            btn_Cart.setTextFill(Color.BLACK);
        });
        btn_Cart.setOnMouseExited(event -> {
            btn_Cart.setBackground(new Background(new BackgroundFill(Color.BLACK, new CornerRadii(20), new Insets(0))));
            btn_Cart.setTextFill(Color.WHITE);
        });
        btn_Cart.setOnMouseClicked(event -> {
            Stg_Cart cartPage = new Stg_Cart();
            cartPage.show();
        });
        //}


        header.getChildren().add(btn_Cart);


        AnchorPane.setTopAnchor(btn_Cart, 20.0);
        AnchorPane.setRightAnchor(btn_Cart, 20.0);
        AnchorPane.setBottomAnchor(btn_Cart, 20.0);
        //}
    }

}
