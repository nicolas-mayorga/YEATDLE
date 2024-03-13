package com.example.yeatdle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.controlsfx.control.textfield.TextFields;

import java.io.IOException;
import java.net.URL;

import java.util.*;


import static com.example.yeatdle.getQueries.*;
public class HelloController implements Initializable {
    @FXML
    AnchorPane root2;
    @FXML
    TextField guessInput;
    @FXML
    Text tracktext1, tracktext2, tracktext3, tracktext4, tracktext5, featuretext1, featuretext2, featuretext3, featuretext4, featuretext5, albumtext1, albumtext2, albumtext3, albumtext4, albumtext5;
    @FXML
    Text lengthtext1, lengthtext2, lengthtext3, lengthtext4, lengthtext5, numbertexts1, numbertexts2, numbertexts3, numbertexts4, numbertexts5;
    @FXML
    Text numberarrow1, numberarrow2, numberarrow3, numberarrow4, numberarrow5, lengtharrow1, lengtharrow2, lengtharrow3, lengtharrow4, lengtharrow5;
    @FXML
    Text albumcheck1, albumcheck2, albumcheck3, albumcheck4, albumcheck5, fcheck1, fcheck2, fcheck3, fcheck4, fcheck5;
    @FXML
    Rectangle abox1, abox2, abox3, abox4, abox5, nbox1, nbox2, nbox3, nbox4, nbox5, lbox1, lbox2,lbox3,lbox4,lbox5, fbox1, fbox2, fbox3, fbox4, fbox5;

    private Stage stage;
    private Scene scene;

    public void switchToLoseScreen(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("loseScreen.fxml")));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void playButton(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(HelloApplication.class.getResource("gameScreen.fxml")));
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public String mysterySong = getSongs().get(((int) (Math.random() * (71 - 1 + 1)) + 1) - 1);

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            TextFields.bindAutoCompletion(guessInput, getSongs());
        } catch
        (NullPointerException ignored) {
        }
    }
     int count = 0;

    public void guessButton(ActionEvent e) throws IOException {
        List<Text> trackTexts = Arrays.asList(tracktext1, tracktext2, tracktext3, tracktext4, tracktext5);

        List<Text> albumTexts = Arrays.asList(albumtext1, albumtext2, albumtext3, albumtext4, albumtext5);
        List<Rectangle> albumBoxes = Arrays.asList(abox1, abox2, abox3, abox4, abox5);

        List<Text> numberTexts = Arrays.asList(numbertexts1, numbertexts2, numbertexts3, numbertexts4, numbertexts5);
        List<Rectangle> numberBoxes = Arrays.asList(nbox1, nbox2, nbox3, nbox4, nbox5);
        List<Text> numberArrowTexts = Arrays.asList(numberarrow1, numberarrow2, numberarrow3, numberarrow4, numberarrow5);

        List<Text> lengthTexts = Arrays.asList(lengthtext1, lengthtext2, lengthtext3, lengthtext4, lengthtext5);
        List<Rectangle> lengthBoxes = Arrays.asList(lbox1, lbox2, lbox3, lbox4, lbox5);
        List<Text> lengthArrowTexts = Arrays.asList(lengtharrow1, lengtharrow2, lengtharrow3, lengtharrow4, lengtharrow5);

        List<Text> featureTexts = Arrays.asList(featuretext1, featuretext2, featuretext3, featuretext4, featuretext5);
        List<Rectangle> featureBoxes = Arrays.asList(fbox1, fbox2, fbox3, fbox4, fbox5);

        String songInput = guessInput.getText();
        if (!songInput.contains("  ")) {
            if (count < 5) {
                if (Objects.equals(songInput, mysterySong)) {
                    Parent root;
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("winScreen.fxml"));
                    root = loader.load();

                    loseScreenController loseScreen = loader.getController();
                    loseScreen.setWinScreenPicture(mysterySong);
                    loseScreen.setWinText(mysterySong);

                    stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
                    scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                    count = 0;
                } else {
                    count++;
                    if (Objects.equals(getAlbum(mysterySong), getAlbum(songInput))) {
                        albumBoxes.get(count - 1).setFill(Paint.valueOf("#18a123"));
                    }
                    if (Objects.equals(getTrackLengthArrow(mysterySong, songInput), "↑") || Objects.equals(getTrackLengthArrow(mysterySong, songInput), "↓")) {
                        lengthBoxes.get(count - 1).setFill(Paint.valueOf("#ae9e3d"));
                    } else if (Objects.equals(getTrackLengthArrow(mysterySong, songInput), "=")) {
                        lengthBoxes.get(count - 1).setFill(Paint.valueOf("#18a123"));
                        lengthArrowTexts.get(count - 1).setFill(Paint.valueOf("18a123"));
                    }
                    if (Objects.equals(getTrackNumberArrow(mysterySong, songInput), "↑") || Objects.equals(getTrackNumberArrow(mysterySong, songInput), "↓")) {
                        numberBoxes.get(count - 1).setFill(Paint.valueOf("#ae9e3d"));
                    } else if (Objects.equals(getTrackNumberArrow(mysterySong, songInput), "=")) {
                        numberBoxes.get(count - 1).setFill(Paint.valueOf("#18a123"));
                        numberArrowTexts.get(count - 1).setFill(Paint.valueOf("18a123"));
                    }
                    if (Objects.equals(getFeature(mysterySong), getFeature(songInput))) {
                        featureBoxes.get(count - 1).setFill(Paint.valueOf("#18a123"));
                    }
                    trackTexts.get(count - 1).setText(songInput);
                    albumTexts.get(count - 1).setText(getAlbum(songInput));
                    lengthTexts.get(count - 1).setText(getTrackLengthText(songInput));
                    numberTexts.get(count - 1).setText(getTrackNumberText(songInput));
                    featureTexts.get(count - 1).setText(getFeature(songInput));
                    numberArrowTexts.get(count - 1).setText(getTrackNumberArrow(mysterySong, songInput));
                    lengthArrowTexts.get(count - 1).setText(getTrackLengthArrow(mysterySong, songInput));
                }
            } else {
                Parent root;
                FXMLLoader loader = new FXMLLoader(getClass().getResource("loseScreen.fxml"));
                root = loader.load();

                loseScreenController loseScreen = loader.getController();
                loseScreen.setLoseText(mysterySong);
                loseScreen.setLoseSongPicture(mysterySong);
                stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
                count = 0;

            }
        } else {
            guessInput.setPromptText("Invalid song. Please try again");
        }
    }
}