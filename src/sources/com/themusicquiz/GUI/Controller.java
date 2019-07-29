/*
 * @Author: Alexandre Ladrière 
 * @Date: 2019-07-25 11:49:34 
 * @Last Modified by: Alexandre Ladrière
 * @Last Modified time: 2019-07-26 17:22:17
 */
package com.themusicquiz.GUI;

import java.io.FileNotFoundException;
import java.io.IOException;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;

import com.themusicquiz.enumerations.MusicGenres;
import com.themusicquiz.enumerations.QuestionType;
import com.themusicquiz.composants.URLBrowser;

public class Controller implements EventHandler<ActionEvent> {
    Gui gui;

    public Controller(Gui gui) {
        this.gui = gui;
    }

    @Override
    public void handle(ActionEvent event) {
        Object cmd = event.getSource();
        try {
            if (gui.getHomeScene().getStartButton().equals(cmd)) {
                gui.getWindow().setScene(gui.getGenreSelectionScene());
            } else if (gui.getGenreSelectionScene().getHiphopButton().equals(cmd)) {
                gui.getWindow().setScene(gui.getHiphopLanguageScene());
            } else if (gui.getHiphopLanguageScene().getFRhiphopButton().equals(cmd)) {
                gui.getQuiz().setDBPath(MusicGenres.FR_hiphop);
                gui.getWindow().setScene(gui.getModeSelectionScene());
            }
            else if(gui.getHiphopLanguageScene().getUShiphopButton().equals(cmd)) {
                gui.getQuiz().setDBPath(MusicGenres.US_hiphop);
                gui.getWindow().setScene(gui.getModeSelectionScene());
            }
            else if(gui.getModeSelectionScene().getWhoButton().equals(cmd)) {
                gui.getQuiz().setQuestionType(QuestionType.WHO);
                gui.getQuiz().iniQuestionList();
                gui.updateQuestionScene();
                gui.getWindow().setScene(gui.getQuestionScene());
            }
            else if(gui.getModeSelectionScene().getWhenButton().equals(cmd)) {
                gui.getQuiz().setQuestionType(QuestionType.WHEN);
                gui.getQuiz().iniQuestionList();
                gui.updateQuestionScene();
                gui.getWindow().setScene(gui.getQuestionScene());
            }
            else if(gui.getModeSelectionScene().getByCoverButton().equals(cmd)) {
                gui.getQuiz().setQuestionType(QuestionType.COVER);
                gui.getQuiz().iniQuestionList();
                gui.updateQuestionScene();
                gui.getWindow().setScene(gui.getQuestionScene());
            }
            else if(gui.getModeSelectionScene().getWhichOneButton().equals(cmd)) {
                gui.getQuiz().setQuestionType(QuestionType.WHICH);
                gui.getQuiz().iniQuestionList();
                gui.updateQuestionScene();
                gui.getWindow().setScene(gui.getQuestionScene());
            }
            else if(gui.getModeSelectionScene().getRandomButton().equals(cmd)) {
                gui.getQuiz().setQuestionType(QuestionType.RANDOM);
                gui.getQuiz().iniQuestionList();
                gui.updateQuestionScene();
                gui.getWindow().setScene(gui.getQuestionScene());
            }
            else if(gui.getModeSelectionScene().getDiscoverButton().equals(cmd)) {
                gui.getQuiz().setQuestionType(QuestionType.DISCOVER);
                gui.getQuiz().iniQuestionList();
                //gui.getWindow().setScene(gui.getQuestionScene());
            }
            else if(gui.getQuestionScene().getProposition1().equals(cmd)) {
                gui.checkAnswerGUI(gui.getQuestionScene().getProposition1().getText());
                enableBottomButton();
                disablePropositions();
            }
            else if(gui.getQuestionScene().getProposition2().equals(cmd)) {
                gui.checkAnswerGUI(gui.getQuestionScene().getProposition2().getText());
                enableBottomButton();
                disablePropositions();
            }
            else if(gui.getQuestionScene().getProposition3().equals(cmd)) {
                gui.checkAnswerGUI(gui.getQuestionScene().getProposition3().getText());
                enableBottomButton();
                disablePropositions();
            }
            else if(gui.getQuestionScene().getProposition4().equals(cmd)) {
                gui.checkAnswerGUI(gui.getQuestionScene().getProposition4().getText());
                enableBottomButton();
                disablePropositions();
            }
            else if(gui.getQuestionScene().getOpenInBrowserButton().equals(cmd)) {
                URLBrowser urlBrowser = new URLBrowser();
                urlBrowser.openWebPage(gui.getQuiz().getCurrentQuestion().getQuestionItem().getItemWikiLink());
            }
            else if(gui.getQuestionScene().getInfoButton().equals(cmd)) {
            }
            else if(gui.getQuestionScene().getNextQuestionButton().equals(cmd)) {
                enablePropositions();
                disableBottomButton();
                gui.updateQuestionScene();
            }
            else if(gui.getResultsScene().getHomeButton().equals(cmd)) {
                gui.getWindow().setScene(gui.getHomeScene());
            }
            else if(gui.getResultsScene().getReplayButton().equals(cmd)) {
                gui.getQuiz().iniQuestionList();
                gui.updateQuestionScene();
                gui.getWindow().setScene(gui.getQuestionScene());
            }
        }
        catch(IOException e) {
            e.printStackTrace();
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

    private void enablePropositions() {
        gui.getQuestionScene().getProposition1().setDisable(false);
        gui.getQuestionScene().getProposition2().setDisable(false);
        gui.getQuestionScene().getProposition3().setDisable(false);
        gui.getQuestionScene().getProposition4().setDisable(false);
    }
}