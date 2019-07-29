/*
 * @Author: Alexandre Ladrière 
 * @Date: 2019-07-28 10:01:38 
 * @Last Modified by: Alexandre Ladrière
 * @Last Modified time: 2019-07-28 11:49:47
 */
package com.themusicquiz.composants;

import com.themusicquiz.enumerations.*;
import com.themusicquiz.composants.*;
import java.io.IOException;
import java.io.File;
import java.util.List;
import java.util.ArrayList;

public class Quiz {
    private String DBPath;
    private QuestionType questionType;
    private List<Item> itemList;
    private FileHandler fileHandler;
    private RandGenerator rand;
    private QuestionSerie questionSerie;
    private Question currentQuestion;
    private int questionCpt;


    public Quiz() {
        this.fileHandler = new FileHandler();
        this.rand = new RandGenerator();
        this.questionCpt = 0;
        this.DBPath = Paths.DBPath.getPath()+"/hiphop/"+MusicGenres.values()[0].getMusicGenreLanguage_name()+"//"+MusicGenres.values()[0].getMusicGenreLanguage_name()+".txt";
        this.questionType = QuestionType.UNDEFINED;
    }

    public void iniQuestionList() throws IOException {
        this.questionCpt = 0;
        if(this.questionType.equals(QuestionType.DISCOVER)) {
            try {
                this.itemList = this.fileHandler.GetItemListFromDB(this.DBPath);
            }
            catch(IOException e) {
                e.printStackTrace();
            }
        }
        else {
            this.questionSerie = new QuestionSerie(this.DBPath, this.questionType);
        }
    }

    public String getDBPath() {
        return DBPath;
    }

    public void setDBPath(String dBPath) {
        this.DBPath = dBPath;
    }

    public void setDBPath(MusicGenres musicGenre) {
        this.DBPath = Paths.DBPath.getPath()+"/"+musicGenre.getMusicGenre_name()+"/"+musicGenre.getMusicGenreLanguage_name()+"//"+musicGenre.getMusicGenreLanguage_name()+".txt";
    }

    public QuestionType getQuestionType() {
        return questionType;
    }

    public void setQuestionType(QuestionType questionType) {
        this.questionType = questionType;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public QuestionSerie getQuestionSerie() {
        return questionSerie;
    }

    public int getQuestionCpt() {
        return questionCpt;
    }

    public void setQuestionCpt(int questionCpt) {
        this.questionCpt = questionCpt;
    }

    public Question getCurrentQuestion() {
        return currentQuestion;
    }

    public void setCurrentQuestion(Question currentQuestion) {
        this.currentQuestion = currentQuestion;
    }
}