package View;

import Controller.UserController;
import Exceptions.InvalidInputException;
import Model.User.Buyer;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Stg_Profile {
    public void show() {
        Stage stage = new Stage();
        VBox root = new VBox();

        Button btn_Back = new Button();
        btn_Back.setText("back");
        btn_Back.setFont(Font.font(12));
        //btn_Back.setPadding(new Insets(7));
        btn_Back.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, new CornerRadii(10), new Insets(0))));
        btn_Back.setPrefSize(50, 30);
        btn_Back.setAlignment(Pos.CENTER);
        btn_Back.setCursor(Cursor.HAND);

        VBox pane = new VBox(btn_Back);
        pane.setPadding(new Insets(0, 0, 0, 10));


        AnchorPane pane_Image = new AnchorPane();
        ImageView img_Login = new ImageView(new Image("https://cdn-icons-png.flaticon.com/512/6681/6681204.png", true));
        img_Login.setFitHeight(70);
        img_Login.setPreserveRatio(true);
        AnchorPane.setLeftAnchor(img_Login, 120.0);
        pane_Image.setPadding(new Insets(0, 0, 10, 0));
        pane_Image.getChildren().add(img_Login);


        Label lbl_Username = new Label();
        lbl_Username.setText("Username");
        lbl_Username.setAlignment(Pos.BOTTOM_CENTER);
        lbl_Username.setFont(Font.font(lbl_Username.getFont().getFamily(), FontWeight.BOLD, 13));
        lbl_Username.setBackground(new Background(new BackgroundFill(Color.BLACK, new CornerRadii(5,0,0,5,false), new Insets(0))));
        lbl_Username.setTextFill(Color.WHITE);
        lbl_Username.setPadding(new Insets(8));
        lbl_Username.setPrefWidth(80);


        TextField txt_Username = new TextField();
        txt_Username.setText(UserController.getLoggedInUser().getUsername());
        txt_Username.setPrefSize(200, lbl_Username.getHeight());
        txt_Username.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, new CornerRadii(0,5,5,0,false), new Insets(0))));
        txt_Username.setPadding(new Insets(8));
        txt_Username.setFont(Font.font(14));

        HBox hBox_Username = new HBox();
        hBox_Username.getChildren().addAll(lbl_Username, txt_Username);
        hBox_Username.setAlignment(Pos.CENTER);

        Label lbl_Password = new Label();
        lbl_Password.setText("Password");
        lbl_Password.setFont(Font.font(lbl_Password.getFont().getFamily(), FontWeight.BOLD, 13));
        lbl_Password.setAlignment(Pos.BOTTOM_CENTER);
        lbl_Password.setBackground(new Background(new BackgroundFill(Color.BLACK, new CornerRadii(5,0,0,5,false), new Insets(0))));
        lbl_Password.setPadding(new Insets(8));
        lbl_Password.setTextFill(Color.WHITE);
        lbl_Password.setPrefWidth(lbl_Username.getPrefWidth());
        lbl_Password.setPrefWidth(80);


        TextField txt_Password = new TextField();
        txt_Password.setText(UserController.getLoggedInUser().getPassword());
        txt_Password.setPrefSize(200, lbl_Password.getHeight());
        txt_Password.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, new CornerRadii(0,5,5,0,false), new Insets(0))));
        txt_Password.setPadding(new Insets(8));
        txt_Password.setFont(Font.font(14));

        HBox hBox_Password = new HBox();
        hBox_Password.getChildren().addAll(lbl_Password, txt_Password);
        hBox_Password.setAlignment(Pos.CENTER);


        Label lbl_PhoneNo = new Label();
        lbl_PhoneNo.setText("Phone");
        lbl_PhoneNo.setFont(Font.font(lbl_PhoneNo.getFont().getFamily(), FontWeight.BOLD, 13));
        lbl_PhoneNo.setAlignment(Pos.BOTTOM_CENTER);
        lbl_PhoneNo.setBackground(new Background(new BackgroundFill(Color.BLACK, new CornerRadii(5,0,0,5,false), new Insets(0))));
        lbl_PhoneNo.setPadding(new Insets(8));
        lbl_PhoneNo.setTextFill(Color.WHITE);
        lbl_PhoneNo.setPrefWidth(lbl_Username.getPrefWidth());
        lbl_PhoneNo.setPrefWidth(80);


        TextField txt_PhoneNo = new TextField();
        txt_PhoneNo.setText(UserController.getLoggedInUser().getPhoneNo());
        txt_PhoneNo.setPrefSize(200, lbl_Password.getHeight());
        txt_PhoneNo.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, new CornerRadii(0,5,5,0,false), new Insets(0))));
        txt_PhoneNo.setPadding(new Insets(8));
        txt_PhoneNo.setFont(Font.font(14));

        HBox hBox_PhoneNo = new HBox();
        hBox_PhoneNo.getChildren().addAll(lbl_PhoneNo, txt_PhoneNo);
        hBox_PhoneNo.setAlignment(Pos.CENTER);


        Label lbl_Email = new Label();
        lbl_Email.setText("Email");
        lbl_Email.setFont(Font.font(lbl_Email.getFont().getFamily(), FontWeight.BOLD, 13));
        lbl_Email.setAlignment(Pos.BOTTOM_CENTER);
        lbl_Email.setBackground(new Background(new BackgroundFill(Color.BLACK, new CornerRadii(5,0,0,5,false), new Insets(0))));
        lbl_Email.setPadding(new Insets(8));
        lbl_Email.setTextFill(Color.WHITE);
        lbl_Email.setPrefWidth(lbl_Username.getPrefWidth());
        lbl_Email.setPrefWidth(80);


        TextField txt_Email = new TextField();
        txt_Email.setText(UserController.getLoggedInUser().getEmail());
        txt_Email.setPrefSize(200, lbl_Password.getHeight());
        txt_Email.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, new CornerRadii(0,5,5,0,false), new Insets(0))));
        txt_Email.setPadding(new Insets(8));
        txt_Email.setFont(Font.font(14));


        HBox hBox_Email = new HBox();
        hBox_Email.getChildren().addAll(lbl_Email, txt_Email);
        hBox_Email.setAlignment(Pos.CENTER);


        DropShadow dropShadow = new DropShadow();
        dropShadow.setBlurType(BlurType.GAUSSIAN);
        dropShadow.setHeight(5);
        dropShadow.setWidth(10);
        dropShadow.setColor(Color.BLACK);
        dropShadow.setRadius(30);
        dropShadow.setSpread(0.2);

        VBox vBox_Information = new VBox();
        vBox_Information.getChildren().addAll(pane_Image, hBox_Username, hBox_Password, hBox_Email, hBox_PhoneNo);
        vBox_Information.setSpacing(10);
        vBox_Information.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(30), new Insets(0))));
        vBox_Information.setPadding(new Insets(10, 5, 40, 10));
        vBox_Information.setAlignment(Pos.CENTER);
        vBox_Information.setEffect(dropShadow);


        Button btn_Submit = new Button();
        btn_Submit.setText("Save");
        btn_Submit.setPrefSize(200, 40);
        btn_Submit.setBackground(new Background(new BackgroundFill(Color.DARKRED, new CornerRadii(10), new Insets(0))));
        btn_Submit.setEffect(dropShadow);
        btn_Submit.setFont(Font.font(btn_Submit.getFont().getFamily(), FontWeight.BOLD, 13));
        btn_Submit.setTextFill(Color.WHITE);
        btn_Submit.setCursor(Cursor.HAND);

        //Events{
        btn_Submit.setOnMouseEntered(events -> {
            btn_Submit.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, new CornerRadii(0), new Insets(0))));
            btn_Submit.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(10), new BorderWidths(1))));
            btn_Submit.setTextFill(Color.BLACK);
            btn_Submit.setFont(Font.font(btn_Submit.getFont().getFamily(), FontWeight.BOLD, 13));
        });
        btn_Submit.setOnMouseExited(event -> {
            btn_Submit.setBackground(new Background(new BackgroundFill(Color.DARKRED, new CornerRadii(10), new Insets(0))));
            btn_Submit.setTextFill(Color.WHITE);
            btn_Submit.setFont(Font.font(btn_Submit.getFont().getFamily(), FontWeight.BOLD, 13));
            btn_Submit.setBorder(Border.EMPTY);
        });
        btn_Submit.setOnMouseClicked(event -> {
            try {
                UserController.editUsername(txt_Username.getText());
                UserController.editPassword(txt_Password.getText());
                UserController.editEmail(txt_Email.getText());
                UserController.editPhoneNo(txt_PhoneNo.getText());
            }
            catch (InvalidInputException e){
                new Stg_Error().show(e.getMessage());
            }
            finally {
                txt_Username.setText(UserController.getLoggedInUser().getUsername());
                txt_Password.setText(UserController.getLoggedInUser().getPassword());
                txt_Email.setText(UserController.getLoggedInUser().getEmail());
                txt_PhoneNo.setText(UserController.getLoggedInUser().getPhoneNo());
            }
        });

        btn_Back.setOnMouseEntered(event -> {
            btn_Back.setBackground(new Background(new BackgroundFill(Color.BLACK, new CornerRadii(5), new Insets(0))));
            btn_Back.setTextFill(Color.WHITE);
        });
        btn_Back.setOnMouseExited(event -> {
            btn_Back.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, new CornerRadii(10), new Insets(0))));
            btn_Back.setTextFill(Color.BLACK);
        });
        btn_Back.setOnMouseClicked(event -> {
            showHomePage(stage);
        });
        //}

        root.setAlignment(Pos.CENTER);
        root.setSpacing(10);
        root.getChildren().addAll(pane, vBox_Information, btn_Submit);
        root.setPadding(new Insets(0, 40, 0, 40));

        Stop[] stops = new Stop[]{
                new Stop(0, Color.DARKGRAY),
                new Stop(1, Color.LIGHTGRAY)
        };
        LinearGradient linearGradient = new LinearGradient(0, 0, 1, 1, true, CycleMethod.NO_CYCLE, stops);
        root.setBackground(new Background(new BackgroundFill(linearGradient, new CornerRadii(0), new Insets(0))));

        Scene scene = new Scene(root, 400, 500);
        scene.setFill(linearGradient);

        stage.setResizable(false);
        stage.setScene(scene);
        stage.setTitle(UserController.getLoggedInUser().getUsername() + " Profile");
        stage.show();
    }

    private static void showHomePage(Stage stage) {
        Stg_Home homePage = new Stg_Home();
        homePage.show();
        stage.close();
    }

}
