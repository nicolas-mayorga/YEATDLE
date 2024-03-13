package com.example.yeatdle;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.*;
import java.util.Objects;

public class loseScreenController {
    private Scene scene;
    private Stage stage;
    public ImageView loseSongPicture, winScreenPicture;
    public Text text1, textWin;

    public Button backButton;
    public void setLoseText (String input){
    text1.setText(input);
    }

    public void setWinText (String input){
        textWin.setText(input);
    }
    public void playAgain(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("gameScreen.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void setLoseSongPicture(String input) throws FileNotFoundException {

        InputStream stream1 = new FileInputStream("C:\\Users\\nmayo\\OneDrive\\Desktop\\yeatdlepics\\up2me.png");
        InputStream stream2 = new FileInputStream("C:\\Users\\nmayo\\OneDrive\\Desktop\\yeatdlepics\\geekpack.jpeg");
        InputStream stream3 = new FileInputStream("C:\\Users\\nmayo\\OneDrive\\Desktop\\yeatdlepics\\lyfe.jpeg");
        InputStream stream4 = new FileInputStream("C:\\Users\\nmayo\\OneDrive\\Desktop\\yeatdlepics\\afterlyfe.jpeg");

        Image upTwoMe = new Image(stream1);
        Image twoAlive = new Image(stream2);
        Image lyfe = new Image(stream3);
        Image afterlyfe = new Image(stream4);
        int albumId = getQueries.getAlbumNum(input);

        if (albumId == 1) {
            loseSongPicture.setImage(upTwoMe);
        } else if (albumId == 2) {
            loseSongPicture.setImage(twoAlive);
        } else if (albumId == 3) {
            loseSongPicture.setImage(lyfe);
        } else {
            loseSongPicture.setImage(afterlyfe);
        }
    }
    public void setWinScreenPicture(String input) throws FileNotFoundException {

        InputStream stream1 = new FileInputStream("C:\\Users\\nmayo\\OneDrive\\Desktop\\yeatdlepics\\up2me.png");
        InputStream stream2 = new FileInputStream("C:\\Users\\nmayo\\OneDrive\\Desktop\\yeatdlepics\\geekpack.jpeg");
        InputStream stream3 = new FileInputStream("C:\\Users\\nmayo\\OneDrive\\Desktop\\yeatdlepics\\lyfe.jpeg");
        InputStream stream4 = new FileInputStream("C:\\Users\\nmayo\\OneDrive\\Desktop\\yeatdlepics\\afterlyfe.jpeg");

        Image upTwoMe = new Image(stream1);
        Image twoAlive = new Image(stream2);
        Image lyfe = new Image(stream3);
        Image afterlyfe = new Image(stream4);
        int albumId = getQueries.getAlbumNum(input);

        if (albumId == 1) {
            winScreenPicture.setImage(upTwoMe);
        } else if (albumId == 2) {
            winScreenPicture.setImage(twoAlive);
        } else if (albumId == 3) {
            winScreenPicture.setImage(lyfe);
        } else {
            winScreenPicture.setImage(afterlyfe);
        }
    }
}
