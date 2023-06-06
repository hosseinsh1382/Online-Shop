package View;

import Controller.BuyerController;
import Controller.CommentController;
import Controller.StuffController;
import Controller.UserController;
import Exceptions.OutOfStockCountException;
import Model.Comment;
import Model.Stuffs.DigitalStuffs.DataStoring.SSD;
import Model.Stuffs.DigitalStuffs.DataStoring.USB;
import Model.Stuffs.DigitalStuffs.DigitalStuff;
import Model.Stuffs.DigitalStuffs.PC;
import Model.Stuffs.Food.Food;
import Model.Stuffs.Stationary.NoteBook;
import Model.Stuffs.Stationary.Pen;
import Model.Stuffs.Stationary.Pencil;
import Model.Stuffs.Stationary.Stationary;
import Model.Stuffs.Stuff;
import Model.Stuffs.Vehicle.Automobile;
import Model.Stuffs.Vehicle.Bicycle;
import Model.Stuffs.Vehicle.Vehicle;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class Stg_Stuff {
    Stage ownerStage;


    public void Show(Stuff stuff) {
        Stage stage = new Stage();
        HBox root = new HBox();

        TilePane tilePane_Information = new TilePane();
        tilePane_Information.setVgap(5);
        tilePane_Information.setHgap(5);
        tilePane_Information.setPrefWidth(300);
        tilePane_Information.setPrefHeight(270);
        tilePane_Information.setAlignment(Pos.BASELINE_CENTER);
        tilePane_Information.setPadding(new Insets(20, 0, 0, 10));
        tilePane_Information.setBackground(new Background(new BackgroundFill(Color.web("#27374D"), new CornerRadii(0), new Insets(0))));

        ScrollPane scrpane_Information = new ScrollPane();
        scrpane_Information.setContent(tilePane_Information);
        scrpane_Information.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrpane_Information.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);

        Label lbl_Name = new Label();
        lbl_Name.setText("Name: " + stuff.getName());
        lbl_Name.setFont(Font.font(lbl_Name.getFont().getFamily(), FontWeight.BOLD, 15));
        lbl_Name.setTextFill(Color.web("#FFC26F"));
        lbl_Name.setPrefWidth(140);

        Label lbl_Price = new Label();
        lbl_Price.setText("Price: " + stuff.getPrice());
        lbl_Price.setFont(Font.font(lbl_Price.getFont().getFamily(), FontWeight.BOLD, 15));
        lbl_Price.setTextFill(Color.web("#FFC26F"));
        lbl_Price.setPrefWidth(130);
        lbl_Price.setAlignment(Pos.CENTER_LEFT);

        Label lbl_Category = new Label();
        lbl_Category.setText("Category: " + stuff.getCategory().toString().toLowerCase());
        lbl_Category.setFont(Font.font(14));
        lbl_Category.setTextFill(Color.web("#9DB2BF"));
        lbl_Category.setPrefWidth(140);

        Label lbl_Count = new Label();
        lbl_Count.setText("Count:" + stuff.getCount());
        lbl_Count.setFont(Font.font(14));
        lbl_Count.setTextFill(Color.web("#9DB2BF"));
        lbl_Count.setPrefWidth(130);

        Label lbl_AverageRate = new Label();
        lbl_AverageRate.setText("Rate: " + stuff.getAverageRate());
        lbl_AverageRate.setFont(Font.font(14));
        lbl_AverageRate.setTextFill(Color.web("#9DB2BF"));
        lbl_AverageRate.setAlignment(Pos.CENTER_LEFT);
        lbl_AverageRate.setPrefWidth(140);


        tilePane_Information.getChildren().addAll(lbl_Name, lbl_Price, new Separator(Orientation.HORIZONTAL), new Separator(Orientation.HORIZONTAL), lbl_Category, lbl_Count, lbl_AverageRate);


        if (stuff instanceof PC)
            pcShow((PC) stuff, tilePane_Information);
        if (stuff instanceof SSD)
            ssdShow((SSD) stuff, tilePane_Information);
        if (stuff instanceof USB)
            usbShow((USB) stuff, tilePane_Information);
        if (stuff instanceof Food)
            foodShow((Food) stuff, tilePane_Information);
        if (stuff instanceof Pen)
            penShow((Pen) stuff, tilePane_Information);
        if (stuff instanceof Pencil)
            pencilShow((Pencil) stuff, tilePane_Information);
        if (stuff instanceof NoteBook)
            notebookShow((NoteBook) stuff, tilePane_Information);
        if (stuff instanceof Automobile)
            automobileShow((Automobile) stuff, tilePane_Information);
        if (stuff instanceof Bicycle)
            bicycleShow((Bicycle) stuff, tilePane_Information);

        Separator separator = new Separator(Orientation.VERTICAL);

        // Comment Column{
        VBox vbox_Comments = new VBox();
        vbox_Comments.setPrefWidth(300);
        vbox_Comments.setPrefHeight(270);
        vbox_Comments.setBackground(new Background(new BackgroundFill(Color.web("#DDE6ED"), new CornerRadii(0), new Insets(0))));
        vbox_Comments.setPadding(new Insets(20, 20, 10, 10));


        ScrollPane scrpane_Comment = new ScrollPane();
        scrpane_Comment.setContent(vbox_Comments);
        scrpane_Comment.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        scrpane_Comment.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrpane_Comment.setBackground(new Background(new BackgroundFill(Color.web("#DDE6ED"), new CornerRadii(0), new Insets(0))));


        if (stuff.getComments().size() == 0) {
            Label lbl_NoComment = new Label();
            lbl_NoComment.setText("No Comment");
            lbl_NoComment.setTextFill(Color.RED);
            lbl_NoComment.setPadding(new Insets(20, 0, 0, 100));
            lbl_NoComment.setFont(Font.font(lbl_NoComment.getFont().getFamily(), FontWeight.BOLD, 14));

            vbox_Comments.getChildren().add(lbl_NoComment);
        }

        for (Comment c : stuff.getComments()) {
            HBox hBox_commentItem = new HBox();
            hBox_commentItem.setPadding(new Insets(0, 0, 5, 0));
            Label lbl_CommentText = new Label();
            lbl_CommentText.setText(c.getBuyer().getUsername() + ": " + c.getCommentText());
            lbl_CommentText.setFont(Font.font(14));
            lbl_CommentText.setTextFill(Color.web("#000000"));
            lbl_CommentText.setPrefHeight(17);
            lbl_CommentText.setPrefWidth(180);

            Label lbl_IsBought = new Label();
            if (c.getIsBought())
                lbl_IsBought.setText("Purchased");
            else lbl_IsBought.setText("Not purchased");
            lbl_IsBought.setFont(Font.font(14));
            lbl_IsBought.setTextFill(Color.web("#000000"));

            Separator separator2 = new Separator(Orientation.VERTICAL);
            hBox_commentItem.getChildren().addAll(lbl_CommentText, separator2, lbl_IsBought);
            Separator separator1 = new Separator(Orientation.HORIZONTAL);
            vbox_Comments.getChildren().addAll(hBox_commentItem, separator1);
        }
        TextField textField_NewComment = new TextField();
        textField_NewComment.setVisible(false);
        vbox_Comments.getChildren().add(textField_NewComment);


        //}


        //Buttons {
        DropShadow dropShadow = new DropShadow();
        dropShadow.setBlurType(BlurType.GAUSSIAN);
        dropShadow.setColor(Color.web("#585858"));
        dropShadow.setHeight(2);
        dropShadow.setWidth(4);
        dropShadow.setRadius(15);
        dropShadow.setSpread(0.3);

        VBox vBox_Buttons = new VBox();

        Button btn_AddToCart = new Button();
        btn_AddToCart.setText("Add to cart");
        btn_AddToCart.setPrefWidth(110);
        btn_AddToCart.setPrefHeight(30);
        btn_AddToCart.setBackground(new Background(new BackgroundFill(Color.web("#9DB2BF"), new CornerRadii(20), new Insets(0))));
        btn_AddToCart.setFont(Font.font(btn_AddToCart.getFont().getFamily(), FontWeight.BOLD, 12));
        btn_AddToCart.setTextFill(Color.web("#27374D"));
        btn_AddToCart.setEffect(dropShadow);


        Button btn_AddComment = new Button();
        btn_AddComment.setText("Add comment");
        btn_AddComment.setPrefWidth(110);
        btn_AddComment.setPrefHeight(30);
        btn_AddComment.setBackground(new Background(new BackgroundFill(Color.web("#9DB2BF"), new CornerRadii(20), new Insets(0))));
        btn_AddComment.setFont(Font.font(btn_AddComment.getFont().getFamily(), FontWeight.BOLD, 11));
        btn_AddComment.setTextFill(Color.web("#27374D"));
        btn_AddComment.setEffect(dropShadow);


        Button btn_AddRate = new Button();
        btn_AddRate.setText("Rate");
        btn_AddRate.setPrefWidth(110);
        btn_AddRate.setPrefHeight(30);
        btn_AddRate.setBackground(new Background(new BackgroundFill(Color.web("#9DB2BF"), new CornerRadii(20), new Insets(0))));
        btn_AddRate.setFont(Font.font(btn_AddRate.getFont().getFamily(), FontWeight.BOLD, 12));
        btn_AddRate.setTextFill(Color.web("#27374D"));
        btn_AddRate.setEffect(dropShadow);


        Label lbl_BuyCount = new Label();
        lbl_BuyCount.setText("Count:");
        lbl_BuyCount.setPrefWidth(50);
        lbl_BuyCount.setPrefHeight(20);

        TextField txt_BuyCount = new TextField();
        txt_BuyCount.setPrefWidth(50);
        txt_BuyCount.setPrefHeight(20);

        HBox hBox_Count = new HBox();
        hBox_Count.getChildren().addAll(lbl_BuyCount, txt_BuyCount);
        hBox_Count.setPadding(new Insets(60, 0, 0, 0));
        hBox_Count.setVisible(false);


        /*        for (Object n:vBox_Buttons.getChildren().toArray()){
            if (n instanceof Button){
                ((Button)n).setPrefWidth(110);
                ((Button)n).setPrefHeight(30);
                ((Button)n).setBackground(new Background(new BackgroundFill(Color.web("#9DB2BF"), new CornerRadii(5), new Insets(0))));
                ((Button)n).setFont(Font.font(btn_AddRate.getFont().getFamily(), FontWeight.BOLD, 12));
                ((Button)n).setTextFill(Color.web("#27374D"));
                ((Button)n).setEffect(dropShadow);

                ((Button)n).setOnMouseEntered(event ->{
                    ((Button)n).setBackground(new Background(new BackgroundFill(Color.web("#bbcad0"), new CornerRadii(5), new Insets(0))));
                });
                ((Button)n).setOnMouseExited(event ->{
                    ((Button)n).setBackground(new Background(new BackgroundFill(Color.web("#9DB2BF"), new CornerRadii(5), new Insets(0))));
                });
            }
        }*/

        vBox_Buttons.setPrefWidth(150);
        vBox_Buttons.setBackground(new Background(new BackgroundFill(Color.web("#526D82"), new CornerRadii(0), new Insets(0))));
        vBox_Buttons.getChildren().addAll(btn_AddToCart, btn_AddComment, btn_AddRate, hBox_Count);
        vBox_Buttons.setPadding(new Insets(20, 25, 0, 25));
        vBox_Buttons.setSpacing(10);


        //Events{
        btn_AddToCart.setOnMouseEntered(event -> {
            btn_AddToCart.setBackground(new Background(new BackgroundFill(Color.web("#bbcad0"), new CornerRadii(5), new Insets(0))));
        });
        btn_AddToCart.setOnMouseExited(event -> {
            btn_AddToCart.setBackground(new Background(new BackgroundFill(Color.web("#9DB2BF"), new CornerRadii(20), new Insets(0))));
        });
        btn_AddToCart.setOnMouseClicked(event -> {
            if (hBox_Count.isVisible()) {
                try {
                    BuyerController.buy(stuff, Integer.parseInt(txt_BuyCount.getText()));
                    hBox_Count.setVisible(false);
                    lbl_Count.setText("Count: " + stuff.getCount());
                } catch (NumberFormatException e) {
                    Stg_Error errorPage = new Stg_Error();
                    errorPage.ownerStage = stage;
                    errorPage.show("Invalid input");
                } catch (OutOfStockCountException e) {
                    Stg_Error errorPage = new Stg_Error();
                    errorPage.ownerStage = stage;
                    errorPage.show(e.getMessage());
                } finally {
                    hBox_Count.setVisible(false);
                }
            } else {
                hBox_Count.setVisible(true);
            }
        });

        btn_AddRate.setOnMouseEntered(event -> {
            btn_AddRate.setBackground(new Background(new BackgroundFill(Color.web("#bbcad0"), new CornerRadii(5), new Insets(0))));
        });
        btn_AddRate.setOnMouseExited(event -> {
            btn_AddRate.setBackground(new Background(new BackgroundFill(Color.web("#9DB2BF"), new CornerRadii(20), new Insets(0))));
        });
        btn_AddRate.setOnMouseClicked(event -> {
            if (hBox_Count.isVisible()) {
                StuffController.setRate(stuff, Double.parseDouble(txt_BuyCount.getText()));
                hBox_Count.setVisible(false);
                txt_BuyCount.setText("");
                lbl_AverageRate.setText("Rate: " + stuff.getAverageRate());
            } else hBox_Count.setVisible(true);
        });

        btn_AddComment.setOnMouseEntered(event -> {

            btn_AddComment.setBackground(new Background(new BackgroundFill(Color.web("#bbcad0"), new CornerRadii(5), new Insets(0))));
        });
        btn_AddComment.setOnMouseExited(event -> {
            btn_AddComment.setBackground(new Background(new BackgroundFill(Color.web("#9DB2BF"), new CornerRadii(20), new Insets(0))));
        });
        btn_AddComment.setOnMouseClicked(event -> {
            if (UserController.getLoggedInUser() != null) {

                if (textField_NewComment.isVisible()) {
                    CommentController.addComment(stuff, textField_NewComment.getText());
                    vbox_Comments.getChildren().remove(textField_NewComment);
                    textField_NewComment.setVisible(false);
                } else {
                    textField_NewComment.setVisible(true);
                }
            } else {
                Stg_Error errorPage = new Stg_Error();
                errorPage.ownerStage = stage;
                errorPage.show("Please Sign in First!");
            }
        });
        //}

        root.getChildren().addAll(scrpane_Information, scrpane_Comment, vBox_Buttons);

        Scene scene = new Scene(root, 750, 250);

        stage.setMaxWidth(800);
        stage.setMaxHeight(300);
        stage.setFullScreen(false);
        stage.initOwner(ownerStage);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Stuff Information");
        stage.setScene(scene);
        stage.show();
    }

    private void digitalStuffShow(DigitalStuff stuff, TilePane tilePane) {
        Label lbl_Weight = new Label();
        lbl_Weight.setText("Weight: " + stuff.getWeight());
        lbl_Weight.setFont(Font.font(14));
        lbl_Weight.setTextFill(Color.web("#9DB2BF"));
        lbl_Weight.setPrefWidth(130);

        Label lbl_Width = new Label();
        lbl_Width.setText("Width: " + stuff.getWidth());
        lbl_Width.setFont(Font.font(14));
        lbl_Width.setTextFill(Color.web("#9DB2BF"));
        lbl_Width.setPrefWidth(140);


        Label lbl_Height = new Label();
        lbl_Height.setText("Height: " + stuff.getHeight());
        lbl_Height.setFont(Font.font(14));
        lbl_Height.setTextFill(Color.web("#9DB2BF"));
        lbl_Height.setPrefWidth(130);

        Label lbl_Length = new Label();
        lbl_Length.setText("Length: " + stuff.getLength());
        lbl_Length.setFont(Font.font(14));
        lbl_Length.setTextFill(Color.web("#9DB2BF"));
        lbl_Length.setPrefWidth(140);

        tilePane.getChildren().addAll(lbl_Weight, lbl_Width, lbl_Height, lbl_Length);
    }

    private void pcShow(PC stuff, TilePane tilePane) {
        digitalStuffShow(stuff, tilePane);

        Label lbl_CPUModel = new Label();
        lbl_CPUModel.setText("CPU: " + stuff.getCPUModel());
        lbl_CPUModel.setFont(Font.font(14));
        lbl_CPUModel.setTextFill(Color.web("#9DB2BF"));
        lbl_CPUModel.setPrefWidth(130);

        Label lbl_RamCapacity = new Label();
        lbl_RamCapacity.setText("Ram: " + stuff.getRAMCapacity());
        lbl_RamCapacity.setFont(Font.font(14));
        lbl_RamCapacity.setTextFill(Color.web("#9DB2BF"));
        lbl_RamCapacity.setPrefWidth(140);

        Label lbl_Temp = new Label();

        tilePane.getChildren().addAll(lbl_CPUModel, lbl_RamCapacity, lbl_Temp);
    }

    private void ssdShow(SSD stuff, TilePane tilePane) {
        digitalStuffShow(stuff, tilePane);

        Label lbl_Capacity = new Label();
        lbl_Capacity.setText("Capacity: " + stuff.getCapacity());
        lbl_Capacity.setPrefWidth(130);
        lbl_Capacity.setFont(Font.font(14));
        lbl_Capacity.setTextFill(Color.web("#9DB2BF"));

        Label lbl_ReadSpeed = new Label();
        lbl_ReadSpeed.setText("Read speed: " + stuff.getReadSpeed());
        lbl_ReadSpeed.setPrefWidth(140);
        lbl_ReadSpeed.setFont(Font.font(14));
        lbl_ReadSpeed.setTextFill(Color.web("#9DB2BF"));

        Label lbl_WriteSpeed = new Label();
        lbl_WriteSpeed.setText("Write speed: " + stuff.getWriteSpeed());
        lbl_WriteSpeed.setFont(Font.font(14));
        lbl_WriteSpeed.setTextFill(Color.web("#9DB2BF"));
        lbl_WriteSpeed.prefWidth(140);


        tilePane.getChildren().addAll(lbl_Capacity, lbl_ReadSpeed, lbl_WriteSpeed);
    }

    private void usbShow(USB stuff, TilePane tilePane) {
        digitalStuffShow(stuff, tilePane);

        Label lbl_Capacity = new Label();
        lbl_Capacity.setText("Capacity: " + stuff.getCapacity());
        lbl_Capacity.setPrefWidth(130);
        lbl_Capacity.setFont(Font.font(14));
        lbl_Capacity.setTextFill(Color.web("#9DB2BF"));

        Label lbl_Version = new Label();
        lbl_Version.setText("Version: " + stuff.getVersion());
        lbl_Version.setTextFill(Color.web("#9DB2BF"));
        lbl_Version.setPrefWidth(140);
        lbl_Version.setFont(Font.font(14));
    }

    private void foodShow(Food food, TilePane tilePane) {
        Label lbl_productDate = new Label();
        lbl_productDate.setText("PRO: " + food.getPro());
        lbl_productDate.setPrefWidth(130);
        lbl_productDate.setFont(Font.font(14));
        lbl_productDate.setTextFill(Color.web("#9DB2BF"));

        Label lbl_ExpireDate = new Label();
        lbl_ExpireDate.setText("EXP: " + food.getExpireDate());
        lbl_ExpireDate.setPrefWidth(140);
        lbl_ExpireDate.setFont(Font.font(14));
        lbl_ExpireDate.setTextFill(Color.web("#9DB2BF"));

        Label lbl_Temp = new Label();

        tilePane.getChildren().addAll(lbl_productDate, lbl_ExpireDate, lbl_Temp);
    }

    private void stationaryShow(Stationary stuff, TilePane tilePane) {
        Label lbl_ProducerCountry = new Label();
        lbl_ProducerCountry.setText("Producer country: " + stuff.getProducerCountry());
        lbl_ProducerCountry.setPrefWidth(130);
        lbl_ProducerCountry.setFont(Font.font(14));
        lbl_ProducerCountry.setTextFill(Color.web("#9DB2BF"));

        tilePane.getChildren().add(lbl_ProducerCountry);
    }

    private void notebookShow(NoteBook stuff, TilePane tilePane) {
        stationaryShow(stuff, tilePane);

        Label lbl_ProducerCountry = new Label();
        lbl_ProducerCountry.setText("Producer country: " + stuff.getProducerCountry());
        lbl_ProducerCountry.setPrefWidth(140);
        lbl_ProducerCountry.setFont(Font.font(14));
        lbl_ProducerCountry.setTextFill(Color.web("#9DB2BF"));

        Label lbl_PaperMaterial = new Label();
        lbl_PaperMaterial.setText("Paper material: " + stuff.getPaperMaterial());
        lbl_PaperMaterial.setPrefWidth(130);
        lbl_PaperMaterial.setFont(Font.font(14));
        lbl_PaperMaterial.setTextFill(Color.web("#9DB2BF"));

        Label lbl_PaperCount = new Label();
        lbl_PaperCount.setText("Paper count: " + stuff.getPaperCount());
        lbl_PaperCount.setPrefWidth(140);
        lbl_PaperCount.setFont(Font.font(14));
        lbl_PaperCount.setTextFill(Color.web("#000000"));

        tilePane.getChildren().addAll(lbl_ProducerCountry, lbl_PaperMaterial, lbl_PaperCount);
    }

    private void penShow(Pen stuff, TilePane tilePane) {
        stationaryShow(stuff, tilePane);

        Label lbl_Color = new Label();
        lbl_Color.setText("Color: " + stuff.getColor());
        lbl_Color.setPrefWidth(140);
        lbl_Color.setFont(Font.font(14));
        lbl_Color.setTextFill(Color.web("#9DB2BF"));

        Label lbl_Temp = new Label();

        tilePane.getChildren().addAll(lbl_Color, lbl_Temp);
    }

    private void pencilShow(Pencil stuff, TilePane tilePane) {
        stationaryShow(stuff, tilePane);

        Label lbl_PencilMode = new Label();
        lbl_PencilMode.setText("Model: " + stuff.getPencilModel());
        lbl_PencilMode.setPrefWidth(140);
        lbl_PencilMode.setFont(Font.font(14));
        lbl_PencilMode.setTextFill(Color.web("#9DB2BF"));

        tilePane.getChildren().add(lbl_PencilMode);
    }

    private void vehicleShow(Vehicle stuff, TilePane tilePane) {
        Label lbl_CompanyName = new Label();
        lbl_CompanyName.setText("Company: " + stuff.getCompanyName());
        lbl_CompanyName.setPrefWidth(130);
        lbl_CompanyName.setFont(Font.font(14));
        lbl_CompanyName.setTextFill(Color.web("#9DB2BF"));

        tilePane.getChildren().add(lbl_CompanyName);
    }

    private void automobileShow(Automobile stuff, TilePane tilePane) {
        vehicleShow(stuff, tilePane);

        Label lbl_MotorCapacity = new Label();
        lbl_MotorCapacity.setText("Motor capacity: " + stuff.getMotorCapacity());
        lbl_MotorCapacity.setPrefWidth(140);
        lbl_MotorCapacity.setTextFill(Color.web("#9DB2BF"));
        lbl_MotorCapacity.setFont(Font.font(14));

        Label lbl_isAutomate = new Label();
        if (stuff.getIsAutomate())
            lbl_isAutomate.setText("Automate: Yes");
        else lbl_isAutomate.setText("Automate: No");
        lbl_isAutomate.setPrefWidth(130);
        lbl_isAutomate.setFont(Font.font(14));
        lbl_isAutomate.setTextFill(Color.web("#000000"));

        tilePane.getChildren().addAll(lbl_MotorCapacity, lbl_isAutomate);
    }

    private void bicycleShow(Bicycle stuff, TilePane tilePane) {
        vehicleShow(stuff, tilePane);

        Label lbl_BicycleType = new Label();
        lbl_BicycleType.setText("Type: " + stuff.getBicycleType().toString().toLowerCase());
        lbl_BicycleType.setFont(Font.font(14));
        lbl_BicycleType.setPrefWidth(140);
        lbl_BicycleType.setTextFill(Color.web("#9DB2BF"));

        Label lbl_Temp = new Label();

        tilePane.getChildren().addAll(lbl_BicycleType, lbl_Temp);
    }
}
