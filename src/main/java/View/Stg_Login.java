package View;

import Controller.UserController;
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

public class Stg_Login {
    public void show() {
        Buyer buyer = new Buyer("hossein", "1234", "hosseinshirkavand82@gmail.com", "09370248298");
        UserController.getUsers().add(buyer);

        Stage stage = new Stage();
        VBox root = new VBox();

        Button btn_Back = new Button();
        btn_Back.setText("back");
        btn_Back.setFont(Font.font(12));
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
        pane_Image.setPadding(new Insets(0, 0, 20, 0));
        pane_Image.getChildren().add(img_Login);


        Label lbl_Username = new Label();
        lbl_Username.setText("Username:");
        lbl_Username.setAlignment(Pos.BOTTOM_CENTER);
        lbl_Username.setFont(Font.font(lbl_Username.getFont().getFamily(),FontWeight.BOLD,13));
        lbl_Username.setBackground(new Background(new BackgroundFill(Color.BLACK, new CornerRadii(5,0,0,5,false), new Insets(0))));
        lbl_Username.setTextFill(Color.WHITE);
        lbl_Username.setPadding(new Insets(8));


        TextField txt_Username = new TextField();
        txt_Username.setPrefSize(200, lbl_Username.getHeight());
        txt_Username.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, new CornerRadii(0,5,5,0,false), new Insets(0))));
        txt_Username.setPadding(new Insets(8));
        txt_Username.setFont(Font.font(14));


        HBox hBox_Username = new HBox();
        hBox_Username.getChildren().addAll(lbl_Username, txt_Username);
        hBox_Username.setAlignment(Pos.CENTER);

        Label lbl_Password = new Label();
        lbl_Password.setText("Password:");
        lbl_Password.setFont(Font.font(lbl_Password.getFont().getFamily(),FontWeight.BOLD,13));
        lbl_Password.setAlignment(Pos.BOTTOM_CENTER);
        lbl_Password.setBackground(new Background(new BackgroundFill(Color.BLACK, new CornerRadii(5,0,0,5,false), new Insets(0))));
        lbl_Password.setPadding(new Insets(8));
        lbl_Password.setTextFill(Color.WHITE);
        lbl_Password.setPrefWidth(lbl_Username.getPrefWidth());
        lbl_Password.setPrefWidth(81);


        TextField txt_Password = new TextField();
        txt_Password.setPrefSize(200, lbl_Password.getHeight());
        txt_Password.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, new CornerRadii(0,5,5,0,false), new Insets(0))));
        txt_Password.setPadding(new Insets(8));
        txt_Password.setFont(Font.font(14));


        HBox hBox_Password = new HBox();
        hBox_Password.getChildren().addAll(lbl_Password, txt_Password);
        hBox_Password.setAlignment(Pos.CENTER);

        DropShadow dropShadow = new DropShadow();
        dropShadow.setBlurType(BlurType.GAUSSIAN);
        dropShadow.setHeight(5);
        dropShadow.setWidth(10);
        dropShadow.setColor(Color.BLACK);
        dropShadow.setRadius(30);
        dropShadow.setSpread(0.2);

        VBox vBox_Information = new VBox();
        vBox_Information.getChildren().addAll(pane_Image, hBox_Username, hBox_Password);
        vBox_Information.setSpacing(10);
        vBox_Information.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(30), new Insets(0))));
        vBox_Information.setPadding(new Insets(10, 5, 80, 10));
        vBox_Information.setAlignment(Pos.CENTER);
        vBox_Information.setEffect(dropShadow);


        Button btn_Login = new Button();
        btn_Login.setText("Login");
        btn_Login.setPrefSize(200, 40);
        btn_Login.setBackground(new Background(new BackgroundFill(Color.DARKRED, new CornerRadii(10), new Insets(0))));
        btn_Login.setEffect(dropShadow);
        btn_Login.setFont(Font.font(btn_Login.getFont().getFamily(), FontWeight.BOLD, 13));
        btn_Login.setTextFill(Color.WHITE);
        btn_Login.setCursor(Cursor.HAND);

        //Events{
        btn_Login.setOnMouseEntered(events -> {
            btn_Login.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, new CornerRadii(0), new Insets(0))));
            btn_Login.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(10), new BorderWidths(1))));
            btn_Login.setTextFill(Color.BLACK);
            btn_Login.setFont(Font.font(btn_Login.getFont().getFamily(), FontWeight.BOLD, 13));
        });
        btn_Login.setOnMouseExited(event -> {
            btn_Login.setBackground(new Background(new BackgroundFill(Color.DARKRED, new CornerRadii(10), new Insets(0))));
            btn_Login.setTextFill(Color.WHITE);
            btn_Login.setFont(Font.font(btn_Login.getFont().getFamily(), FontWeight.BOLD, 13));
        });
        btn_Login.setOnMouseClicked(event -> {
            if (UserController.login(txt_Username.getText(), txt_Password.getText())) {
                if (UserController.getLoggedInUser() instanceof Buyer) {
                    Stg_Home homePage = new Stg_Home();
                    homePage.show();
                    stage.close();
                }
            } else {
                showHomePage(stage);
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
        btn_Back.setOnMouseClicked(event ->{
            showHomePage(stage);
        });
        //}

        root.setAlignment(Pos.CENTER);
        root.setSpacing(10);
        root.getChildren().addAll(pane, vBox_Information, btn_Login);
        root.setPadding(new Insets(0, 40, 0, 40));

        Stop[] stops = new Stop[]{
                new Stop(0, Color.DARKGRAY),
                new Stop(1, Color.LIGHTGRAY)
        };
        LinearGradient linearGradient = new LinearGradient(0, 0, 1, 1, true, CycleMethod.NO_CYCLE, stops);
        root.setBackground(new Background(new BackgroundFill(linearGradient, new CornerRadii(0), new Insets(0))));

        Scene scene = new Scene(root, 400, 450);
        scene.setFill(linearGradient);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.setTitle("Login");
        stage.show();
    }

    private static void showHomePage(Stage stage) {
        Stg_Home homePage = new Stg_Home();
        homePage.show();
        stage.close();
    }


}
