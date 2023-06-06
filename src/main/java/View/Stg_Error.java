package View;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Stg_Error {
    public Stage ownerStage;

    public void show(String errorMessage) {
        Image image = new Image("https://static-00.iconduck.com/assets.00/dialog-error-icon-2048x2048-xktj28v4.png",true);
        ImageView imgView_Error = new ImageView(image);
        imgView_Error.setFitHeight(40);
        imgView_Error.setFitWidth(40);
        imgView_Error.setImage(image);

        Label lbl_Error = new Label();
        lbl_Error.setText(errorMessage);
        lbl_Error.setPadding(new Insets(8,0,0,20));
        lbl_Error.setFont(Font.font(lbl_Error.getFont().getFamily(), 14));

        HBox root = new HBox();
        root.getChildren().addAll(imgView_Error,lbl_Error);
        root.setPadding(new Insets(25,10,30,40));

        Stage stage = new Stage();
        Scene scene = new Scene(root, 350, 100);
        stage.setTitle("Error");
        stage.initStyle(StageStyle.UTILITY);
        stage.initOwner(ownerStage);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);
        stage.show();
    }
}
