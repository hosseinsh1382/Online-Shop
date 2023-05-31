package View;

import Controller.StuffController;
import Model.Stuffs.DigitalStuffs.PC;
import Model.Stuffs.Stuff;
import javafx.animation.Animation;
import javafx.animation.ScaleTransition;
import javafx.animation.Transition;
import javafx.animation.TranslateTransition;
import javafx.fxml.Initializable;
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
import javafx.scene.effect.Shadow;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Stg_HomePage {


    public void show() {

        PC pc = new PC("a", 222, 2, 4, 4, 4, 2, "d", "2");
        PC pc2 = new PC("b", 222, 2, 4, 4, 4, 2, "d", "2");

        StuffController.getStuffs().add(pc);
        StuffController.getStuffs().add(pc2);
        StuffController.getStuffs().add(pc2);
        StuffController.getStuffs().add(pc2);
        StuffController.getStuffs().add(pc2);
        StuffController.getStuffs().add(pc2);
        StuffController.getStuffs().add(pc2);
        StuffController.getStuffs().add(pc2);
        StuffController.getStuffs().add(pc2);
        StuffController.getStuffs().add(pc);
        StuffController.getStuffs().add(pc);
        StuffController.getStuffs().add(pc);
        StuffController.getStuffs().add(pc);
        StuffController.getStuffs().add(pc);


        DropShadow dropShadow = new DropShadow();
        dropShadow.setBlurType(BlurType.GAUSSIAN);
        dropShadow.setColor(Color.web("#585858"));
        dropShadow.setHeight(2);
        dropShadow.setWidth(5);
        dropShadow.setRadius(15);
        dropShadow.setSpread(0.3);

        //Header{
        Button btn_SignUp = new Button();
        btn_SignUp.setText("Sign Up");
        btn_SignUp.setPrefWidth(80);
        btn_SignUp.setPrefHeight(30);
        btn_SignUp.setMinWidth(60);
        btn_SignUp.setMinHeight(30);
        btn_SignUp.setBackground(new Background(new BackgroundFill(Color.web("#9DB2BF"), new CornerRadii(5), new Insets(0))));
        btn_SignUp.setFont(Font.font(btn_SignUp.getFont().getFamily(), FontWeight.BOLD, 13));
        btn_SignUp.setTextFill(Color.web("#27374D"));
        btn_SignUp.setEffect(dropShadow);

        Button btn_Login = new Button();
        btn_Login.setText("Login");
        btn_Login.setPrefWidth(80);
        btn_Login.setPrefHeight(30);
        btn_Login.setMinWidth(60);
        btn_Login.setMinHeight(30);
        btn_Login.setFont(Font.font(btn_Login.getFont().getFamily(), FontWeight.BOLD, 13));
        btn_Login.setTextFill(Color.web("#27374D"));
        btn_Login.setBackground(new Background(new BackgroundFill(Color.web("#9DB2BF"), new CornerRadii(5), new Insets(0))));
        btn_Login.setEffect(dropShadow);


        Button btn_Cart = new Button();
        btn_Cart.setText("Cart");
        btn_Cart.setPrefWidth(80);
        btn_Cart.setPrefHeight(30);
        btn_Cart.setMinWidth(60);
        btn_Cart.setMinHeight(30);
        btn_Cart.setFont(Font.font(btn_Cart.getFont().getFamily(), FontWeight.BOLD, 13));
        btn_Cart.setTextFill(Color.web("#27374D"));
        btn_Cart.setBackground(new Background(new BackgroundFill(Color.web("#9DB2BF"), new CornerRadii(5), new Insets(0))));
        btn_Cart.setEffect(dropShadow);


        AnchorPane header = new AnchorPane();
        header.setBackground(new Background(new BackgroundFill(Color.web("#526D82"), new CornerRadii(0), new Insets(0))));
        header.getChildren().addAll(btn_Login, btn_SignUp, btn_Cart);
        AnchorPane.setTopAnchor(btn_SignUp, 20.0);
        AnchorPane.setLeftAnchor(btn_SignUp, 20.0);
        AnchorPane.setBottomAnchor(btn_SignUp, 20.0);

        AnchorPane.setLeftAnchor(btn_Login, 120.0);
        AnchorPane.setTopAnchor(btn_Login, 20.0);
        AnchorPane.setBottomAnchor(btn_Login, 20.0);

        AnchorPane.setTopAnchor(btn_Cart, 20.0);
        AnchorPane.setRightAnchor(btn_Cart, 20.0);
        AnchorPane.setBottomAnchor(btn_Cart, 20.0);
        //}

        Separator separator = new Separator(Orientation.HORIZONTAL);

        //Body{
        ScrollPane scrollPane = new ScrollPane();
        TilePane tilePane_Stuffs = new TilePane();
        tilePane_Stuffs.setHgap(20);
        tilePane_Stuffs.setVgap(20);
        tilePane_Stuffs.setPadding(new Insets(15));
        tilePane_Stuffs.setAlignment(Pos.BASELINE_CENTER);

        scrollPane.setContent(tilePane_Stuffs);
        scrollPane.setFitToWidth(true);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        scrollPane.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, new CornerRadii(0), new Insets(0))));
        scrollPane.setStyle("-fx-background:#DDE6ED;");


        VBox root = new VBox();
        root.setBackground(new Background(new BackgroundFill(Color.web("#DDE6ED"), new CornerRadii(0), new Insets(0))));
        showStuffs(tilePane_Stuffs);
        root.getChildren().addAll(header, separator, scrollPane);

        Scene scene = new Scene(root, 1000, 600);

        Stage homePage = new Stage();
        homePage.setMinWidth(700);
        homePage.setMinHeight(600);
        homePage.setScene(scene);
        homePage.show();
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
            lbl_Name.setPadding(new Insets(0, 0, 30, 45));
            lbl_Name.setTextFill(Color.web("#9DB2BF"));
            lbl_Name.setEffect(shadow);

            Label lbl_Category = new Label();
            lbl_Category.setFont(Font.font(13));
            lbl_Category.setTextFill(Color.web("#9DB2BF"));
            lbl_Category.setPadding(new Insets(0, 0, 5, 0));

            Label lbl_Count = new Label();
            lbl_Count.setFont(Font.font(13));
            lbl_Count.setPadding(new Insets(0, 0, 5, 0));
            lbl_Count.setTextFill(Color.web("#9DB2BF"));

            Label lbl_AverageRate = new Label();
            lbl_AverageRate.setFont(Font.font(13));
            lbl_AverageRate.setTextFill(Color.web("#9DB2BF"));

            Label lbl_Price = new Label();
            lbl_Price.setFont(Font.font(15));
            lbl_Price.setFont(Font.font(lbl_Price.getFont().getFamily(), FontWeight.BOLD, 15));
            lbl_Price.setPadding(new Insets(30, 0, 0, 35));
            lbl_Price.setTextFill(Color.web("#C88EA7"));
            lbl_Price.setEffect(shadow);

            VBox vBox_Stuff = new VBox();
            vBox_Stuff.setBackground(new Background(new BackgroundFill(Color.web("#27374D"), new CornerRadii(10), new Insets(0))));
            vBox_Stuff.setCursor(Cursor.HAND);

            TranslateTransition transition = new TranslateTransition();
            transition.setDuration(Duration.seconds(1));

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

            lbl_Name.setText("Name: " + s.getName());
            lbl_Category.setText("Category: " + s.getCategory().toString().toLowerCase());
            lbl_Count.setText("Count: " + s.getCount());
            lbl_AverageRate.setText("Rate: " + s.getAverageRate());
            lbl_Price.setText("Price: " + s.getPrice());

            vBox_Stuff.getChildren().addAll(lbl_Name, lbl_Category, lbl_Count, lbl_AverageRate, lbl_Price);
            vBox_Stuff.setPrefWidth(170);
            vBox_Stuff.setPrefHeight(200);
            vBox_Stuff.setPadding(new Insets(10));
            vBox_Stuff.setEffect(shadow);


            tilePane.getChildren().add(vBox_Stuff);
        }
    }

}
