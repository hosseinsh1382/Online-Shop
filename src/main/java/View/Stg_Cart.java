package View;

import Controller.*;
import Exceptions.DiscountException;
import Exceptions.OutOfCreditException;
import Model.Stuffs.Food.Food;
import Model.User.Buyer;
import Model.User.CartItem;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Stg_Cart {
    VBox vBox_Cart = new VBox();
    VBox vBox_SidePanel = new VBox();
    Stage stage = new Stage();

    public void show() {

        vBox_Cart.setPrefSize(580, 480);
        vBox_Cart.setAlignment(Pos.BASELINE_CENTER);
        vBox_Cart.setSpacing(5);
        vBox_Cart.setPadding(new Insets(20, 10, 20, 10));
        vBox_Cart.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, new CornerRadii(0), new Insets(0))));


        ScrollPane scrPane_Cart = new ScrollPane();
        scrPane_Cart.setContent(vBox_Cart);
        scrPane_Cart.setStyle("-fx-background-color: lightgray;");
        scrPane_Cart.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrPane_Cart.setFitToWidth(true);
        scrPane_Cart.setFitToHeight(true);


        // Show Cart items
        showCartItems();

        DropShadow dropShadow = new DropShadow();
        dropShadow.setBlurType(BlurType.GAUSSIAN);
        dropShadow.setWidth(2);
        dropShadow.setHeight(5);
        dropShadow.setSpread(0.05);
        dropShadow.setRadius(30);


        vBox_SidePanel.setPrefWidth(440);
        vBox_SidePanel.setPrefHeight(100);
        vBox_SidePanel.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(5), new Insets(20))));
        vBox_SidePanel.setPadding(new Insets(40));
        vBox_SidePanel.setEffect(dropShadow);
        vBox_SidePanel.setSpacing(5);

        showSidePanel();


        FlowPane root = new FlowPane();
        root.getChildren().addAll(scrPane_Cart, vBox_SidePanel);
        root.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, new CornerRadii(0), new Insets(0))));

        Scene scene = new Scene(root, 1030, 480);

        stage.setTitle("Cart");
        stage.setScene(scene);
        stage.show();
    }

    private void showCartItems() {
        Label lbl_NameHeader = new Label();
        lbl_NameHeader.setText("Name");
        lbl_NameHeader.setPrefWidth(150);
        lbl_NameHeader.setAlignment(Pos.CENTER);
        lbl_NameHeader.setFont(Font.font(lbl_NameHeader.getFont().getFamily(), FontWeight.BOLD, 14));
        lbl_NameHeader.setTextFill(Color.WHITE);

        Label lbl_CountHeader = new Label();
        lbl_CountHeader.setText("Count");
        lbl_CountHeader.setPrefWidth(50);
        lbl_CountHeader.setFont(Font.font(lbl_CountHeader.getFont().getFamily(), FontWeight.BOLD, 14));
        lbl_CountHeader.setAlignment(Pos.CENTER);
        lbl_CountHeader.setTextFill(Color.WHITE);

        Label lbl_PriceHeader = new Label();
        lbl_PriceHeader.setText("Price");
        lbl_PriceHeader.setPrefWidth(150);
        lbl_PriceHeader.setFont(Font.font(lbl_PriceHeader.getFont().getFamily(), FontWeight.BOLD, 14));
        lbl_PriceHeader.setAlignment(Pos.CENTER);
        lbl_PriceHeader.setTextFill(Color.WHITE);

        Label lbl_DiscountHeader = new Label();
        lbl_DiscountHeader.setText("Discount");
        lbl_DiscountHeader.setPrefWidth(130);
        lbl_DiscountHeader.setFont(Font.font(lbl_DiscountHeader.getFont().getFamily(), FontWeight.BOLD, 14));
        lbl_DiscountHeader.setAlignment(Pos.CENTER);
        lbl_DiscountHeader.setTextFill(Color.WHITE);

        Label lbl_remove = new Label();
        lbl_remove.setPrefWidth(75);


        HBox hBox_Header = new HBox();
        hBox_Header.setBackground(new Background(new BackgroundFill(Color.BLACK, new CornerRadii(5), new Insets(0))));
        hBox_Header.getChildren().addAll(lbl_NameHeader, lbl_CountHeader, lbl_PriceHeader, lbl_DiscountHeader, lbl_remove);
        hBox_Header.setPrefHeight(35);
        hBox_Header.setAlignment(Pos.CENTER);

        vBox_Cart.getChildren().add(hBox_Header);
        for (CartItem c : ((Buyer) UserController.getLoggedInUser()).getCart()) {

            Label lbl_Name = new Label();
            lbl_Name.setText(c.getStuff().getName());
            lbl_Name.setPrefWidth(150);
            lbl_Name.setAlignment(Pos.CENTER);
            lbl_Name.setFont(Font.font(14));


            Label lbl_Count = new Label();
            lbl_Count.setText(Integer.toString(c.getCount()));
            lbl_Count.setPrefWidth(50);
            lbl_Count.setAlignment(Pos.CENTER);
            lbl_Count.setFont(Font.font(14));


            Label lbl_Price = new Label();
            lbl_Price.setText(Double.toString(c.getTotalPrice()));
            lbl_Price.setPrefWidth(150);
            lbl_Price.setAlignment(Pos.CENTER);
            lbl_Price.setFont(Font.font(14));


            TextField txt_Discount = new TextField();
            txt_Discount.setPrefWidth(80);

            Button btn_AddDiscount = new Button();
            btn_AddDiscount.setText("Add");
            btn_AddDiscount.setPrefWidth(40);
            btn_AddDiscount.setTextFill(Color.WHITE);
            btn_AddDiscount.setBackground(new Background(new BackgroundFill(Color.BLACK, new CornerRadii(5), new Insets(0))));
            btn_AddDiscount.setCursor(Cursor.HAND);


            HBox hBox_Discount = new HBox();
            hBox_Discount.getChildren().addAll(txt_Discount, btn_AddDiscount);
            hBox_Discount.setSpacing(5);
            hBox_Discount.setPrefWidth(130);
            hBox_Discount.setAlignment(Pos.CENTER);
            hBox_Discount.setPadding(new Insets(0, 5, 0, 0));

            Button btn_Remove = new Button();
            btn_Remove.setText("Remove");
            btn_Remove.setBackground(new Background(new BackgroundFill(Color.DARKRED, new CornerRadii(5), new Insets(0))));
            btn_Remove.setPrefWidth(75);
            btn_Remove.setTextFill(Color.WHITE);
            btn_Remove.setFont(Font.font(btn_Remove.getFont().getFamily(), FontWeight.BOLD, 12));

            //Events
            btn_AddDiscount.setOnMouseClicked(event -> {
                try {
                    DiscountController.checkStuffDiscount(txt_Discount.getText(), c);
                } catch (DiscountException e) {
                    new Stg_Error().show(e.getMessage());
                }
            });
            btn_AddDiscount.setOnMouseEntered(event -> {
                btn_AddDiscount.setBackground(new Background(new BackgroundFill(Color.web("#222121"), new CornerRadii(5), new Insets(0))));
            });
            btn_AddDiscount.setOnMouseExited(event -> {
                btn_AddDiscount.setBackground(new Background(new BackgroundFill(Color.BLACK, new CornerRadii(5), new Insets(0))));
            });
            btn_Remove.setOnMouseEntered(event -> {
                btn_Remove.setBackground(new Background(new BackgroundFill(Color.RED, new CornerRadii(5), new Insets(0))));
            });
            btn_Remove.setOnMouseExited(event -> {
                btn_Remove.setBackground(new Background(new BackgroundFill(Color.DARKRED, new CornerRadii(5), new Insets(0))));

            });
            btn_Remove.setOnMouseClicked(event -> {
                CartController.removeStuff(c);
                vBox_Cart.getChildren().clear();
                vBox_SidePanel.getChildren().clear();
                showCartItems();
                showSidePanel();
            });

            HBox hBox_CartItem = new HBox();
            hBox_CartItem.getChildren().addAll(lbl_Name, lbl_Count, lbl_Price, hBox_Discount, btn_Remove);
            hBox_CartItem.setPrefHeight(35);
            hBox_CartItem.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(5), new Insets(0))));
            hBox_CartItem.setAlignment(Pos.CENTER);
            hBox_CartItem.setPadding(new Insets(0, 5, 0, 0));

            vBox_Cart.getChildren().addAll(hBox_CartItem);
        }
    }

    private void showSidePanel() {
        Label lbl_BuyerName = new Label();
        if (UserController.getLoggedInUser().getUsername().equals("null"))
            lbl_BuyerName.setText("Not signed in!");
        else lbl_BuyerName.setText(UserController.getLoggedInUser().getUsername());
        lbl_BuyerName.setFont(Font.font(lbl_BuyerName.getFont().getFamily(), FontWeight.BOLD, 19));
        lbl_BuyerName.setAlignment(Pos.CENTER);
        lbl_BuyerName.setPrefSize(440, 70);

        Label lbl_Credit = new Label();
        lbl_Credit.setText("Your credit: " + ((Buyer) UserController.getLoggedInUser()).getCredit());
        lbl_Credit.setAlignment(Pos.CENTER_LEFT);
        lbl_Credit.setPrefSize(440, 30);
        lbl_Credit.setPadding(new Insets(0, 0, 0, 20));
        lbl_Credit.setFont(Font.font(lbl_Credit.getFont().getFamily(), FontWeight.NORMAL, 16));

        TextField txt_Discount = new TextField();
        txt_Discount.setPrefSize(250, 30);
        txt_Discount.setPadding(new Insets(5, 20, 5, 20));
        txt_Discount.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(30), new Insets(0))));
        txt_Discount.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(30), new BorderWidths(1))));
        txt_Discount.setFont(Font.font(16));

        Button btn_AddDiscount = new Button();
        btn_AddDiscount.setText("Add");
        btn_AddDiscount.setFont(Font.font(btn_AddDiscount.getFont().getFamily(), FontWeight.BOLD, 16));
        btn_AddDiscount.setBackground(new Background(new BackgroundFill(Color.BLACK, new CornerRadii(30), new Insets(0))));
        btn_AddDiscount.setTextFill(Color.WHITE);
        btn_AddDiscount.setPrefSize(150, 30);
        btn_AddDiscount.setCursor(Cursor.HAND);

        HBox hBox_Discount = new HBox();
        hBox_Discount.setPrefSize(440, 50);
        hBox_Discount.setPadding(new Insets(5, 15, 5, 15));
        hBox_Discount.setSpacing(10);
        hBox_Discount.getChildren().addAll(txt_Discount, btn_AddDiscount);

        Label lbl_TotalPrice = new Label();
        lbl_TotalPrice.setText("Total price: " + CartController.getTotalCartPrice());
        lbl_TotalPrice.setPrefSize(440, 70);
        lbl_TotalPrice.setFont(Font.font(lbl_TotalPrice.getFont().getFamily(), FontWeight.BOLD, 19));
        lbl_TotalPrice.setAlignment(Pos.CENTER);

        Button btn_Buy = new Button();
        btn_Buy.setText("Buy");
        btn_Buy.setPrefSize(400, 50);
        btn_Buy.setBackground(new Background(new BackgroundFill(Color.BLACK, new CornerRadii(30), new Insets(0))));
        btn_Buy.setTextFill(Color.WHITE);
        btn_Buy.setFont(Font.font(btn_Buy.getFont().getFamily(), FontWeight.BOLD, 16));
        btn_Buy.setCursor(Cursor.HAND);


        Button btn_Cancel = new Button();
        btn_Cancel.setText("Cancel");
        btn_Cancel.setBackground(new Background(new BackgroundFill(Color.DARKRED, new CornerRadii(30), new Insets(0))));
        btn_Cancel.setPrefSize(400, 50);
        btn_Cancel.setTextFill(Color.WHITE);
        btn_Cancel.setFont(Font.font(btn_Cancel.getFont().getFamily(), FontWeight.BOLD, 16));
        btn_Cancel.setCursor(Cursor.HAND);


        Button btn_IncreaseCredit = new Button();
        btn_IncreaseCredit.setText("Increase Credit");
        btn_IncreaseCredit.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(30), new Insets(0))));
        btn_IncreaseCredit.setFont(Font.font(btn_IncreaseCredit.getFont().getFamily(), FontWeight.BOLD, 16));
        btn_IncreaseCredit.setTextFill(Color.BLACK);
        btn_IncreaseCredit.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(30), new BorderWidths(1))));
        btn_IncreaseCredit.setPrefSize(400, 50);
        btn_IncreaseCredit.setCursor(Cursor.HAND);

        // Events
        btn_Buy.setOnMouseEntered(event -> {
            btn_Buy.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(30), new Insets(0))));
            btn_Buy.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(30), new BorderWidths(1))));
            btn_Buy.setTextFill(Color.BLACK);
        });
        btn_Buy.setOnMouseExited(event -> {
            btn_Buy.setBackground(new Background(new BackgroundFill(Color.BLACK, new CornerRadii(30), new Insets(0))));
            btn_Buy.setBorder(Border.EMPTY);
            btn_Buy.setTextFill(Color.WHITE);

        });
        btn_Buy.setOnMouseClicked(event -> {
            if (!UserController.getLoggedInUser().getUsername().equals("null")) {
                try {
                    BuyerController.finalizeBuy();
                    vBox_Cart.getChildren().clear();
                    vBox_SidePanel.getChildren().clear();
                    showCartItems();
                    showSidePanel();
                } catch (OutOfCreditException e) {
                    new Stg_Error().show(e.getMessage());
                }
            }
            else new Stg_Error().show("Please Sign in first!");
        });
        btn_Cancel.setOnMouseEntered(event -> {
            btn_Cancel.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(30), new Insets(0))));
            btn_Cancel.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(30), new BorderWidths(1))));
            btn_Cancel.setTextFill(Color.BLACK);
        });
        btn_Cancel.setOnMouseExited(event -> {
            btn_Cancel.setBackground(new Background(new BackgroundFill(Color.DARKRED, new CornerRadii(30), new Insets(0))));
            btn_Cancel.setBorder(Border.EMPTY);
            btn_Cancel.setTextFill(Color.WHITE);
        });
        btn_Cancel.setOnMouseClicked(event -> {
            BuyerController.cancelBuy();
            vBox_Cart.getChildren().clear();
            vBox_SidePanel.getChildren().clear();
            showSidePanel();
            showCartItems();
        });
        btn_IncreaseCredit.setOnMouseEntered(event -> {
            btn_IncreaseCredit.setBackground(new Background(new BackgroundFill(Color.BLACK, new CornerRadii(30), new Insets(0))));
            btn_IncreaseCredit.setTextFill(Color.WHITE);
        });
        btn_IncreaseCredit.setOnMouseExited(event -> {
            btn_IncreaseCredit.setTextFill(Color.BLACK);
            btn_IncreaseCredit.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(30), new BorderWidths(1))));
            btn_IncreaseCredit.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(30), new Insets(0))));
        });
        btn_IncreaseCredit.setOnMouseClicked(event -> {
            new Stg_PaymentGateway().show();
            stage.close();
        });
        btn_AddDiscount.setOnMouseEntered(event -> {
            btn_AddDiscount.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(30), new Insets(0))));
            btn_AddDiscount.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(30), new BorderWidths(1))));
            btn_AddDiscount.setTextFill(Color.BLACK);
        });
        btn_AddDiscount.setOnMouseExited(event -> {
            btn_AddDiscount.setBackground(new Background(new BackgroundFill(Color.BLACK, new CornerRadii(30), new Insets(0))));
            btn_AddDiscount.setBorder(Border.EMPTY);
            btn_AddDiscount.setTextFill(Color.WHITE);

        });

        vBox_SidePanel.getChildren().addAll(lbl_BuyerName, lbl_Credit, hBox_Discount, lbl_TotalPrice, btn_Buy, btn_Cancel, btn_IncreaseCredit);
    }
}
