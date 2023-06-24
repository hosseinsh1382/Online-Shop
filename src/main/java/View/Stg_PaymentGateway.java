package View;

import Controller.BuyerController;
import Controller.UserController;
import Model.User.Buyer;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Stg_PaymentGateway {
    public void show() {
        Stage stage = new Stage();

        Label lbl_CardNo = new Label("Card number");
        lbl_CardNo.setFont(Font.font(14));

        TextField txtField_Card1 = new TextField();
        txtField_Card1.setPrefSize(80, 30);
        txtField_Card1.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(50), new Insets(0))));
        txtField_Card1.setBorder(new Border(new BorderStroke(Color.GRAY, BorderStrokeStyle.SOLID, new CornerRadii(50), new BorderWidths(1))));
        txtField_Card1.setFont(Font.font(13));
        txtField_Card1.setAlignment(Pos.CENTER);

        TextField txtField_Card2 = new TextField();
        txtField_Card2.setPrefSize(80, 30);
        txtField_Card2.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(50), new Insets(0))));
        txtField_Card2.setBorder(new Border(new BorderStroke(Color.GRAY, BorderStrokeStyle.SOLID, new CornerRadii(50), new BorderWidths(1))));
        txtField_Card2.setFont(Font.font(13));
        txtField_Card2.setAlignment(Pos.CENTER);

        TextField txtField_Card3 = new TextField();
        txtField_Card3.setPrefSize(80, 30);
        txtField_Card3.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(50), new Insets(0))));
        txtField_Card3.setBorder(new Border(new BorderStroke(Color.GRAY, BorderStrokeStyle.SOLID, new CornerRadii(50), new BorderWidths(1))));
        txtField_Card3.setFont(Font.font(13));
        txtField_Card3.setAlignment(Pos.CENTER);

        TextField txtField_Card4 = new TextField();
        txtField_Card4.setPrefSize(80, 30);
        txtField_Card4.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(50), new Insets(0))));
        txtField_Card4.setBorder(new Border(new BorderStroke(Color.GRAY, BorderStrokeStyle.SOLID, new CornerRadii(50), new BorderWidths(1))));
        txtField_Card4.setFont(Font.font(13));
        txtField_Card4.setAlignment(Pos.CENTER);

        HBox hBox_CardNo = new HBox();
        hBox_CardNo.setSpacing(10);
        hBox_CardNo.getChildren().addAll(txtField_Card1, txtField_Card2, txtField_Card3, txtField_Card4);


        Label lbl_ExpireDate = new Label();
        lbl_ExpireDate.setText("Expire Date:");
        lbl_ExpireDate.setPrefSize(80, 30);
        lbl_ExpireDate.setFont(Font.font(14));

        TextField txtField_ExpireYear = new TextField();
        txtField_ExpireYear.setPrefSize(50, 30);
        txtField_ExpireYear.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(50), new Insets(0))));
        txtField_ExpireYear.setBorder(new Border(new BorderStroke(Color.GRAY, BorderStrokeStyle.SOLID, new CornerRadii(50), new BorderWidths(1))));
        txtField_ExpireYear.setFont(Font.font(13));
        txtField_ExpireYear.setAlignment(Pos.CENTER);

        Label lbl_separator = new Label("/");
        lbl_separator.setPrefSize(5, 30);
        lbl_separator.setFont(Font.font(14));

        TextField txtField_ExpireMonth = new TextField();
        txtField_ExpireMonth.setPrefSize(50, 30);
        txtField_ExpireMonth.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(50), new Insets(0))));
        txtField_ExpireMonth.setBorder(new Border(new BorderStroke(Color.GRAY, BorderStrokeStyle.SOLID, new CornerRadii(50), new BorderWidths(1))));
        txtField_ExpireMonth.setFont(Font.font(13));
        txtField_ExpireMonth.setAlignment(Pos.CENTER);

        HBox hBox_ExpireDate = new HBox(lbl_ExpireDate, txtField_ExpireYear, lbl_separator, txtField_ExpireMonth);
        hBox_ExpireDate.setSpacing(10);

        Label lbl_CVV2 = new Label("CVV2:");
        lbl_CVV2.setPrefSize(50, 30);
        lbl_CVV2.setFont(Font.font(14));

        TextField txtField_CVV2 = new TextField();
        txtField_CVV2.setPrefSize(60, 30);
        txtField_CVV2.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(50), new Insets(0))));
        txtField_CVV2.setBorder(new Border(new BorderStroke(Color.GRAY, BorderStrokeStyle.SOLID, new CornerRadii(50), new BorderWidths(1))));
        txtField_CVV2.setFont(Font.font(13));
        txtField_CVV2.setAlignment(Pos.CENTER);

        HBox hBox_CVV2 = new HBox(lbl_CVV2, txtField_CVV2);
        hBox_CVV2.setSpacing(40);

        Label lbl_Password = new Label("Password:");
        lbl_Password.setPrefSize(80, 30);
        lbl_Password.setFont(Font.font(14));

        TextField txtField_Password = new TextField();
        txtField_Password.setPrefSize(120, 30);
        txtField_Password.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(50), new Insets(0))));
        txtField_Password.setBorder(new Border(new BorderStroke(Color.GRAY, BorderStrokeStyle.SOLID, new CornerRadii(50), new BorderWidths(1))));
        txtField_Password.setFont(Font.font(13));
        txtField_Password.setAlignment(Pos.CENTER);

        HBox hBox_Password = new HBox(lbl_Password, txtField_Password);
        hBox_Password.setSpacing(10);

        Button btn_Pay = new Button("Pay");
        btn_Pay.setPrefSize(200, 50);
        btn_Pay.setBackground(new Background(new BackgroundFill(Color.BLACK, new CornerRadii(50), new Insets(0))));
        btn_Pay.setTextFill(Color.WHITE);
        btn_Pay.setFont(Font.font(btn_Pay.getFont().getFamily(), FontWeight.BOLD, 14));
        btn_Pay.setCursor(Cursor.HAND);

        Button btn_Cancel = new Button("Cancel");
        btn_Cancel.setPrefSize(200, 50);
        btn_Cancel.setBackground(new Background(new BackgroundFill(Color.DARKRED, new CornerRadii(50), new Insets(0))));
        btn_Cancel.setTextFill(Color.WHITE);
        btn_Cancel.setFont(Font.font(btn_Cancel.getFont().getFamily(), FontWeight.BOLD, 14));
        btn_Cancel.setCursor(Cursor.HAND);


        HBox hBox_Buttons = new HBox(btn_Pay, btn_Cancel);
        hBox_Buttons.setSpacing(10);
        hBox_Buttons.setPadding(new Insets(40, 0, 0, 0));

        VBox vBox_LeftPanel = new VBox();
        vBox_LeftPanel.getChildren().addAll(lbl_CardNo, hBox_CardNo, hBox_ExpireDate, hBox_CVV2, hBox_Password, hBox_Buttons);
        vBox_LeftPanel.setPadding(new Insets(0, 50, 0, 50));
        vBox_LeftPanel.setSpacing(15);
        vBox_LeftPanel.setPrefSize(500, 400);
        vBox_LeftPanel.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(0), new Insets(0))));
        vBox_LeftPanel.setAlignment(Pos.CENTER);


        Label lbl_Username = new Label(UserController.getLoggedInUser().getUsername());
        lbl_Username.setFont(Font.font(lbl_Username.getFont().getFamily(), FontWeight.BOLD, 15));
        lbl_Username.setPrefWidth(400);
        lbl_Username.setAlignment(Pos.CENTER);

        Label lbl_Fee = new Label("Fee: ");
        lbl_Fee.setFont(Font.font(lbl_Fee.getFont().getFamily(), FontWeight.BOLD, 14));
        lbl_Fee.setPrefSize(30, 30);

        TextField txtField_Fee = new TextField("0");
        txtField_Fee.setPrefSize(250, 40);
        txtField_Fee.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(50), new BorderWidths(1))));
        txtField_Fee.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(50), new Insets(0))));
        txtField_Fee.setPadding(new Insets(0, 10, 0, 10));
        txtField_Fee.setAlignment(Pos.CENTER);
        txtField_Fee.setFont(Font.font(14));


        HBox hBox_Fee = new HBox(lbl_Fee, txtField_Fee);
        hBox_Fee.setSpacing(20);
        hBox_Fee.setAlignment(Pos.CENTER);

        Label lbl_CurrentCredit = new Label();
        lbl_CurrentCredit.setText("Current Credit:   " + ((Buyer) UserController.getLoggedInUser()).getCredit());
        lbl_CurrentCredit.setFont(Font.font(15));
        lbl_CurrentCredit.setPrefHeight(30);
        //lbl_CurrentCredit.setBackground(new Background(new BackgroundFill(Color.BLACK,new CornerRadii(0),new Insets(0))));


        Label lbl_TotalCredit = new Label();
        lbl_TotalCredit.setText("Total Credit: " + (((Buyer) UserController.getLoggedInUser()).getCredit() + Double.parseDouble(txtField_Fee.getText())));
        lbl_TotalCredit.setFont(Font.font(15));
        lbl_TotalCredit.setPrefHeight(30);

        //Events{
        txtField_Fee.addEventHandler(KeyEvent.KEY_RELEASED, e -> {
            lbl_TotalCredit.setText("Total Credit: " + (((Buyer) UserController.getLoggedInUser()).getCredit() + Double.parseDouble(txtField_Fee.getText())));
        });
        txtField_Card1.addEventHandler(KeyEvent.KEY_RELEASED, e -> {
            if (txtField_Card1.getLength() >= 4) {
                txtField_Card1.setText(txtField_Card1.getText(0, 4));
                txtField_Card2.requestFocus();
            }
        });
        txtField_Card2.addEventHandler(KeyEvent.KEY_RELEASED, e -> {
            if (txtField_Card2.getLength() >= 4) {
                txtField_Card2.setText(txtField_Card2.getText(0, 4));
                txtField_Card3.requestFocus();
            } else if (txtField_Card2.getLength() == 0)
                txtField_Card1.requestFocus();
        });
        txtField_Card3.addEventHandler(KeyEvent.KEY_RELEASED, e -> {
            if (txtField_Card3.getLength() >= 4) {
                txtField_Card3.setText(txtField_Card3.getText(0, 4));
                txtField_Card4.requestFocus();
            } else if (txtField_Card3.getLength() == 0) {
                txtField_Card2.requestFocus();
            }
        });
        txtField_Card4.addEventHandler(KeyEvent.KEY_RELEASED, e -> {
            if (txtField_Card4.getLength() >= 4) {
                txtField_Card4.setText(txtField_Card4.getText(0, 4));
                txtField_ExpireMonth.requestFocus();
            }
            if (txtField_Card4.getLength() == 0) {
                txtField_Card3.requestFocus();
            }
        });

        txtField_ExpireMonth.addEventHandler(KeyEvent.KEY_RELEASED, e -> {
            if (txtField_ExpireMonth.getLength() >= 2) {
                txtField_ExpireMonth.setText(txtField_ExpireMonth.getText(0, 2));
                txtField_ExpireYear.requestFocus();
            }
        });
        txtField_ExpireYear.addEventHandler(KeyEvent.KEY_RELEASED, e -> {
            if (txtField_ExpireYear.getLength() >= 2) {
                txtField_ExpireYear.setText(txtField_ExpireYear.getText(0, 2));
                txtField_CVV2.requestFocus();
            }
        });

        txtField_CVV2.addEventHandler(KeyEvent.KEY_RELEASED, e -> {
            if (txtField_CVV2.getLength() >= 4) {
                txtField_CVV2.setText(txtField_CVV2.getText(0, 4));
                txtField_Password.requestFocus();
            }
        });

        btn_Pay.setOnMouseEntered(event -> {
            btn_Pay.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(50), new Insets(0))));
            btn_Pay.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(50), new BorderWidths(1))));
            btn_Pay.setTextFill(Color.BLACK);
        });
        btn_Pay.setOnMouseExited(event -> {
            btn_Pay.setBackground(new Background(new BackgroundFill(Color.BLACK, new CornerRadii(50), new Insets(0))));
            btn_Pay.setBorder(Border.EMPTY);
            btn_Pay.setTextFill(Color.WHITE);
        });
        btn_Pay.setOnMouseClicked(event -> {
            try {
                BuyerController.cardNoValidation(txtField_Card1.getText() + txtField_Card2.getText() + txtField_Card3.getText() + txtField_Card4.getText());
                BuyerController.cardCVV2Validation(txtField_CVV2.getText());
                BuyerController.increaseCredit((Buyer) UserController.getLoggedInUser(), Integer.parseInt(txtField_Fee.getText()));
            }
            catch (Exception ex){
                Stg_Error errorPage = new Stg_Error();
                errorPage.show(ex.getMessage());
            }
        });

        btn_Cancel.setOnMouseEntered(event -> {
            btn_Cancel.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(50), new Insets(0))));
            btn_Cancel.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(50), new BorderWidths(1))));
            btn_Cancel.setTextFill(Color.BLACK);
        });
        btn_Cancel.setOnMouseExited(event -> {
            btn_Cancel.setBackground(new Background(new BackgroundFill(Color.DARKRED, new CornerRadii(50), new Insets(0))));
            btn_Cancel.setBorder(Border.EMPTY);
            btn_Cancel.setTextFill(Color.WHITE);
        });
        btn_Cancel.setOnMouseClicked(event->{
            stage.close();
        });
        //}

        VBox vbox_RightPanel = new VBox();
        vbox_RightPanel.getChildren().addAll(lbl_Username, hBox_Fee, lbl_CurrentCredit, lbl_TotalCredit);
        //vbox_RightPanel.setAlignment(Pos.CENTER);
        vbox_RightPanel.setSpacing(20);
        vbox_RightPanel.setPrefWidth(400);
        vbox_RightPanel.setPadding(new Insets(50, 20, 0, 20));


        HBox root = new HBox();
        root.getChildren().addAll(vBox_LeftPanel, vbox_RightPanel);

        Scene scene = new Scene(root, 900, 400);

        stage.setTitle("Payment gateway");
        stage.setScene(scene);
        stage.show();
    }
}
