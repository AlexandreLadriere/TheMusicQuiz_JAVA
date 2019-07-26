/*
 * @Author: Alexandre Ladrière 
 * @Date: 2019-07-25 11:52:11 
 * @Last Modified by: Alexandre Ladrière
 * @Last Modified time: 2019-07-26 16:19:46
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

import javafx.scene.Node;
import java.util.ArrayList;

import com.themusicquiz.enumerations.Constantes;
import com.themusicquiz.enumerations.Paths;

public class Gui extends Application {

    private Stage window;
    private WelcomeScene welcomeScene;
    private HomeScene homeScene;
    private ModeSelectionScene modeSelectionScene;
    private GenreSelectionScene genreSelectionScene;
    private HiphopLanguageScene hiphopLanguageScene;

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;

        try {
            welcomeScene = new WelcomeScene();
            homeScene = new HomeScene();
            addButtonsToController(homeScene);
            modeSelectionScene = new ModeSelectionScene();
            addButtonsToController(modeSelectionScene);
            genreSelectionScene = new GenreSelectionScene();
            addButtonsToController(genreSelectionScene);
            hiphopLanguageScene = new HiphopLanguageScene();
            addButtonsToController(hiphopLanguageScene);
            
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

    public void addButtonsToController(HomeScene scene) {
        NodeGetter nodeGetter = new NodeGetter();
        ArrayList<Button> buttonArray = nodeGetter.getAllButtons(scene.getGrid());
        for(Button button : buttonArray) {
            button.setOnAction(new Controller(this));
        }
    }

    public void addButtonsToController(ModeSelectionScene scene) {
        NodeGetter nodeGetter = new NodeGetter();
        ArrayList<Button> buttonArray = nodeGetter.getAllButtons(scene.getGrid());
        for(Button button : buttonArray) {
            button.setOnAction(new Controller(this));
        }
    }

    public void addButtonsToController(GenreSelectionScene scene) {
        NodeGetter nodeGetter = new NodeGetter();
        ArrayList<Button> buttonArray = nodeGetter.getAllButtons(scene.getGrid());
        for(Button button : buttonArray) {
            button.setOnAction(new Controller(this));
        }
    }

    public void addButtonsToController(HiphopLanguageScene scene) {
        NodeGetter nodeGetter = new NodeGetter();
        ArrayList<Button> buttonArray = nodeGetter.getAllButtons(scene.getGrid());
        for(Button button : buttonArray) {
            button.setOnAction(new Controller(this));
        }
    }

    public Stage getWindow() {
        return window;
    }

    public void setWindow(Stage window) {
        this.window = window;
    }

    public WelcomeScene getWelcomeScene() {
        return welcomeScene;
    }

    public void setWelcomeScene(WelcomeScene welcomeScene) {
        this.welcomeScene = welcomeScene;
    }

    public HomeScene getHomeScene() {
        return homeScene;
    }

    public void setHomeScene(HomeScene homeScene) {
        this.homeScene = homeScene;
    }

    public ModeSelectionScene getModeSelectionScene() {
        return modeSelectionScene;
    }

    public void setModeSelectionScene(ModeSelectionScene modeSelectionScene) {
        this.modeSelectionScene = modeSelectionScene;
    }

    public GenreSelectionScene getGenreSelectionScene() {
        return genreSelectionScene;
    }

    public void setGenreSelectionScene(GenreSelectionScene genreSelectionScene) {
        this.genreSelectionScene = genreSelectionScene;
    }

    public HiphopLanguageScene getHiphopLanguageScene() {
        return hiphopLanguageScene;
    }

    public void setHiphopLanguageScene(HiphopLanguageScene hiphopLanguageScene) {
        this.hiphopLanguageScene = hiphopLanguageScene;
    }
}