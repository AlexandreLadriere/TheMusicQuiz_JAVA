package com.themusicquiz.composants;

import com.themusicquiz.enumerations.Constantes;
import com.themusicquiz.enumerations.QuestionType;
import java.util.List;
import java.util.ArrayList;
import java.io.IOException;
import java.util.Objects;

public class QuestionSerie {
    protected String questionSerieDBPath;
    protected QuestionType questionSerieQuestionType;
    protected int questionSerieCorrectAnswerNumber;
    protected float questionSerieAverageTime; //in ms
    protected int questionSerieTotalScore;
    protected List<Item> questionSerieItemList = new ArrayList<Item>();
    protected List<Question> questionSerieQuestionList = new ArrayList<Question>();

    private RandGenerator questionSerieRandGenerator = new RandGenerator();
    private FileHandler questionSerieFileHandler = new FileHandler();

    public QuestionSerie() {
        questionSerieAverageTime = 0F;
        questionSerieCorrectAnswerNumber = 0;
        questionSerieDBPath = "";
        questionSerieQuestionType = QuestionType.UNDEFINED;
        questionSerieTotalScore = 0;
    }

    public QuestionSerie(String pDBPath, QuestionType pQuestionType) {
        questionSerieAverageTime = 0F;
        questionSerieCorrectAnswerNumber = 0;
        questionSerieDBPath = pDBPath;
        questionSerieQuestionType = pQuestionType;
        questionSerieTotalScore = 0;
        this.buildLists();
    }

    private void buildLists() {
        try {
            this.questionSerieItemList = questionSerieFileHandler.GetItemListFromDB(this.questionSerieDBPath);
            this.questionSerieQuestionList = questionSerieRandGenerator.getQuestionSerie(this.questionSerieQuestionType, this.questionSerieItemList);
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }

    public String getQuestionSerieDBPath() {
        return questionSerieDBPath;
    }

    public void setQuestionSerieDBPath(String pDBPath) {
        this.questionSerieDBPath = pDBPath;
        this.buildLists();
    }

    public QuestionType getQuestionSerieQuestionType() {
        return questionSerieQuestionType;
    }

    public void setquestionSerieQuestionType(QuestionType pQuestionType) {
        this.questionSerieQuestionType = pQuestionType;
        this.buildLists();
    }

    public int getQuestionSerieCorrectAnswerNumber() {
        this.calculateQuestionSerieCorrectAnswerNumber();
        return questionSerieCorrectAnswerNumber;
    }

    private void setQuestionSerieCorrectAnswerNumber(int pCorrectAnswerNumber) {
        this.questionSerieCorrectAnswerNumber = pCorrectAnswerNumber;
    }

    private void calculateQuestionSerieCorrectAnswerNumber() {
        int tmpCorrectAnswerNumber = 0;
        for(int i = 0; i<Constantes.NUMBER_OF_QUESTIONS.getValue(); i++) {
            tmpCorrectAnswerNumber += (this.getQuestionSerieQuestionList().get(i).getQuestionIsCorrect()) ? 1 : 0;
        }
        this.setQuestionSerieCorrectAnswerNumber(tmpCorrectAnswerNumber);
    }

    public float getQuestionSerieAverageTime() {
        calculateQuestionSerieAverageTime();
        return questionSerieAverageTime;
    }

    private void setQuestionSerieAverageTime(float pAverageTime) {
        this.questionSerieAverageTime = pAverageTime;
    }

    private void calculateQuestionSerieAverageTime() {
        float tmpAverageTime = 0F;
        for(int i = 0; i<Constantes.NUMBER_OF_QUESTIONS.getValue(); i++) {
            tmpAverageTime += (float) this.getQuestionSerieQuestionList().get(i).getQuestionTime();
        }
        tmpAverageTime = tmpAverageTime/Constantes.NUMBER_OF_QUESTIONS.getValue();
        this.setQuestionSerieAverageTime(tmpAverageTime);
    }

    public int getQuestionSerieTotalScore() {
        this.calculateQuestionSerieTotalScore();
        return questionSerieTotalScore;
    }

    private void setQuestionSerieTotalScore(int pTotalScore) {
        this.questionSerieTotalScore = pTotalScore;
    }

    private void calculateQuestionSerieTotalScore() {
        int tmpTotalScore = 0;
        for(int i = 0; i<Constantes.NUMBER_OF_QUESTIONS.getValue(); i++) {
            tmpTotalScore += this.getQuestionSerieQuestionList().get(i).getQuestionScore();
        }
        this.setQuestionSerieTotalScore(tmpTotalScore);
    }

    public List<Item> getQuestionSerieItemList() {
        return questionSerieItemList;
    }

    private void setQuestionSerieItemList(List<Item> pItemList) {
        this.questionSerieItemList = pItemList;
    }

    public List<Question> getQuestionSerieQuestionList() {
        return questionSerieQuestionList;
    }

    private void setQuestionSerieQuestionList(List<Question> pQuestionList) {
        this.questionSerieQuestionList = pQuestionList;
    }

    public String toString() {
        String tmpStr = "QuestionSerie DBPath: "+this.questionSerieDBPath+"\nQuestionSerie QuestionType: "+this.questionSerieQuestionType
                        +"\nQuestionSerie correctAnswerNumber:"+this.getQuestionSerieCorrectAnswerNumber()+"\nQuestionSerie AverageTime: "
                        +this.getQuestionSerieAverageTime()+"\nQuestionSerie TotalScore: "+this.getQuestionSerieTotalScore();
        return tmpStr; //Afficher les lists ?
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        QuestionSerie other = (QuestionSerie) obj;
        return Objects.equals(other.getQuestionSerieAverageTime(), this.getQuestionSerieAverageTime()) 
                && Objects.equals(other.getQuestionSerieCorrectAnswerNumber(), this.getQuestionSerieCorrectAnswerNumber()) 
                && Objects.equals(other.getQuestionSerieDBPath(), this.getQuestionSerieDBPath()) 
                && Objects.equals(other.getQuestionSerieItemList(), this.getQuestionSerieItemList()) 
                && Objects.equals(other.getQuestionSerieQuestionList(), this.getQuestionSerieQuestionList()) 
                && Objects.equals(other.getQuestionSerieQuestionType(), this.getQuestionSerieQuestionType())
                && Objects.equals(other.getQuestionSerieTotalScore(), this.getQuestionSerieTotalScore());
    }
}