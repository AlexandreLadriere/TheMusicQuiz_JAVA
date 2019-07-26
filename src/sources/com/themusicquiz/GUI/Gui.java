/*
 * @Author: Alexandre Ladrière 
 * @Date: 2019-07-25 11:52:11 
 * @Last Modified by: Alexandre Ladrière
 * @Last Modified time: 2019-07-26 14:13:08
 */
package com.themusicquiz.GUI;

import java.io.FileInputStream; 
import java.io.FileNotFoundException; 

import javafx.animation.PauseTransition;
import javafx.util.Duration;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.text.TextAlignment;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import com.themusicquiz.enumerations.Constantes;
import com.themusicquiz.enumerations.Paths;

public class Gui extends Application {

    private Stage window;
    private Scene welcomeScene;
    private Scene homeScene;
    private Scene modeSelectionScene;

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;

        try {
            welcomeScene = new WelcomeScene();
            homeScene = new HomeScene();
            modeSelectionScene = new ModeSelectionScene();

            window.setScene(welcomeScene);
            window.setTitle("The Music Quiz");
            //pause between welcom scene and homeScene
            PauseTransition delay = new PauseTransition(new Duration((double) 2000));
            delay.setOnFinished( event -> window.setScene(homeScene) );

            delay.play();
            window.show();
        }
        catch(FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}