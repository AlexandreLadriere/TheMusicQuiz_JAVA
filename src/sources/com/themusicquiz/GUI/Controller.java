/*
 * @Author: Alexandre Ladrière 
 * @Date: 2019-07-25 11:49:34 
 * @Last Modified by: Alexandre Ladrière
 * @Last Modified time: 2019-07-26 17:22:17
 */
package com.themusicquiz.GUI;

import java.io.FileNotFoundException; 
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;

public class Controller implements EventHandler<ActionEvent> {
    Gui gui;

    public Controller(Gui gui) {
        this.gui = gui;
    }

    @Override
    public void handle(ActionEvent event) {
        Object cmd = event.getSource();
        if(gui.getHomeScene().getStartButton().equals(cmd)) {
            gui.getWindow().setScene(gui.getGenreSelectionScene());
        }
        else if(gui.getGenreSelectionScene().getHiphopButton().equals(cmd)) {
            gui.getWindow().setScene(gui.getHiphopLanguageScene());
        }
        else if(gui.getHiphopLanguageScene().getFRhiphopButton().equals(cmd)) {
            gui.getWindow().setScene(gui.getModeSelectionScene());
        }
        else if(gui.getHiphopLanguageScene().getUShiphopButton().equals(cmd)) {
            gui.getWindow().setScene(gui.getModeSelectionScene());
        }
        else if(gui.getModeSelectionScene().getRandomButton().equals(cmd)) {
            gui.getWindow().setScene(gui.getQuestionScene());
        }
        else if(gui.getQuestionScene().getProposition1().equals(cmd)) {
            enableBottomButton();
            disablePropositions();
        }
        else if(gui.getQuestionScene().getProposition2().equals(cmd)) {
            enableBottomButton();
            disablePropositions();
        }
        else if(gui.getQuestionScene().getProposition3().equals(cmd)) {
            enableBottomButton();
            disablePropositions();
        }
        else if(gui.getQuestionScene().getProposition4().equals(cmd)) {
            enableBottomButton();
            disablePropositions();
        }
    }

    private void disableBottomButton() {
        gui.getQuestionScene().getOpenInBrowserButton().setDisable(true);
        gui.getQuestionScene().getInfoButton().setDisable(true);
        gui.getQuestionScene().getNextQuestionButton().setDisable(true);
    }

    private void enableBottomButton() {
        gui.getQuestionScene().getOpenInBrowserButton().setDisable(false);
        gui.getQuestionScene().getInfoButton().setDisable(false);
        gui.getQuestionScene().getNextQuestionButton().setDisable(false);
    }

    private void disablePropositions() {
        gui.getQuestionScene().getProposition1().setDisable(true);
        gui.getQuestionScene().getProposition2().setDisable(true);
        gui.getQuestionScene().getProposition3().setDisable(true);
        gui.getQuestionScene().getProposition4().setDisable(true);
    }
}