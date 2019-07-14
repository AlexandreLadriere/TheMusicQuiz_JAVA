package com.themusicquiz.composants;

import com.themusicquiz.enumerations.Constantes;
import com.themusicquiz.enumerations.QuestionType;
import java.util.Objects;

public class Question {
    protected QuestionType questionType;
    protected Item questionItem;
    protected int questionScore;
    protected long questionTime; //in ms
    protected Item questionOptions[] = new Item[Constantes.NUMBER_OF_PROPOSITIONS.getValue()];
    protected boolean questionIsCorrect;
    protected String questionCorrectAnswer;

    Question() {
        questionType = QuestionType.UNDEFINED;
        questionItem = new Item();
        questionScore = 0;
        questionTime = 0L;
        questionIsCorrect = false;
        this.setQuestionOptionsEmpty();
        this.setQuestionCorrectAnswer();
    }

    Question(QuestionType pQuestionType, Item pItem, Item[] pItemTab) {
        questionType = pQuestionType;
        questionItem = pItem;
        questionScore = 0;
        questionTime = 0L;
        questionIsCorrect = false;
        this.setQuestionCorrectAnswer();
        this.setQuestionOptions(pItemTab);
    }

    public QuestionType getQuestionType() {
        return questionType;
    }

    public Item getQuestionItem() {
        return questionItem;
    }

    public int getQuestionScore() {
        //this.calculateQuestionScore();
        return questionScore;
    }

    public long getQuestionTime() {
        return questionTime;
    }

    public Item[] getQuestionOptions() {
        return questionOptions;
    }

    public boolean getQuestionIsCorrect() {
        return questionIsCorrect;
    }

    public String getQuestionCorrectAnswer() {
        return questionCorrectAnswer;
    }

    private void setQuestionIsCorrect(boolean pQuestionIsCorrect) {
        this.questionIsCorrect = pQuestionIsCorrect;
    }

    public void setQuestionTime(long pQuestionTime) {
        this.questionTime = pQuestionTime;
    }

    private void setQuestionScore(int pQuestionScore) {
        this.questionScore = pQuestionScore;
    }

    public void setQuestionItem(Item pQuestionItem) {
        this.questionItem = pQuestionItem;
        this.setQuestionCorrectAnswer();
        Item[] tmpItemTab = new Item[Constantes.NUMBER_OF_PROPOSITIONS.getValue()-1];
        for(int i = 0; i<Constantes.NUMBER_OF_PROPOSITIONS.getValue()-1; i++) {
            tmpItemTab[i] = this.questionOptions[i];
        }
        this.setQuestionOptions(tmpItemTab);
    }

    public void setQuestionType(QuestionType pQuestionType) {
        this.questionType = pQuestionType;
        this.setQuestionCorrectAnswer();
    }

    private void setQuestionCorrectAnswer() {
        this.questionCorrectAnswer = this.getProposition(this.questionItem);
    }

    private void setQuestionOptionsEmpty() {
        for(int i = 0; i<Constantes.NUMBER_OF_PROPOSITIONS.getValue(); i++) {
            this.questionOptions[i] = new Item();
        }
    }

    private void setQuestionOptions(Item[] pItemTab) {
        Item[] tmpItemTab = new Item[Constantes.NUMBER_OF_PROPOSITIONS.getValue()];
        RandGenerator rand = new RandGenerator();
        int[] permutationTab = rand.randPermutation(0,Constantes.NUMBER_OF_PROPOSITIONS.getValue()-1);
        if(pItemTab.length+1 >= Constantes.NUMBER_OF_PROPOSITIONS.getValue()) {
            for(int i = 1; i<Constantes.NUMBER_OF_PROPOSITIONS.getValue(); i++) {
                tmpItemTab[i] = pItemTab[i-1];
            }
        }
        else {
            this.setQuestionOptionsEmpty();
        }
        tmpItemTab[0] = this.questionItem;
        for(int i = 0; i<Constantes.NUMBER_OF_PROPOSITIONS.getValue(); i++) {
            this.questionOptions[i] = tmpItemTab[permutationTab[i]];
        }
    }

    public String toString() {
        String tmpStr = "\tQuestion type: "+this.questionType+"\n\tQuestion score: "+this.questionScore+"\n\tQuestion time: "+this.questionTime+"\n\tCorrect answer: "+this.questionIsCorrect;
        for(int i = 0; i<Constantes.NUMBER_OF_PROPOSITIONS.getValue(); i++) {
            tmpStr+="\n\tProposition "+i+": "+this.getProposition(questionOptions[i]);
        }
        tmpStr+="\n\tCorrect Answer: "+this.questionCorrectAnswer;
        return tmpStr;  
    }

    public boolean checkAnswer(String pAnswer) {
        if(pAnswer.equals(this.questionCorrectAnswer)) {
            this.setQuestionIsCorrect(true);
            this.calculateQuestionScore();
        }
        return this.getQuestionIsCorrect();
    }

    private void calculateQuestionScore() {
        Float tmpFloat = new Float(100000/this.getQuestionTime());
        int tmpQuestionScore = tmpFloat.intValue();
        this.setQuestionScore(tmpQuestionScore);
    }

    public String getProposition(Item pItem) {
        String proposition;
        switch (this.questionType) {
            case UNDEFINED:
                proposition = "undefined";
                break;
            case WHEN:
                proposition = pItem.getItemDate();
                break;
            case WHICH:
                proposition = pItem.getItemTitle();
                break;
            case WHO:
                proposition = pItem.getItemAuthor();
                break;
            case COVER:
                proposition = pItem.getItemAuthor().concat(" - "+pItem.getItemDate());
                break;
            default:
                proposition = "undefined";
        }
        return proposition;
    }

    public String askQuestion() {
        String question;
        switch (this.questionType) {
            case UNDEFINED: 
                question = "Undefined question";
                break;
            case WHEN:
                question = "When was \""+questionItem.getItemTitle()+"\" released by "+questionItem.getItemAuthor()+" ?";
                break;
            case WHO:
                question = "Who released \""+questionItem.getItemTitle()+"\" in "+questionItem.getItemDate()+" ?";
                break;
            case WHICH:
                question = "What is the name of the album released by "+questionItem.getItemAuthor()+" in "+questionItem.getItemDate()+" ?";
                break;
            case COVER:
                question = "Who released this album and when ?";
                break;
            default:
                question = "Undefined question";
        }
        return question;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Question other = (Question) obj;
        return Objects.equals(other.getQuestionItem(), this.getQuestionItem()) && Objects.equals(other.getQuestionCorrectAnswer(), this.getQuestionCorrectAnswer()) && Objects.equals(other.getQuestionOptions(), this.getQuestionOptions()) && Objects.equals(other.getQuestionScore(), this.getQuestionScore()) && Objects.equals(other.getQuestionTime(), this.getQuestionTime()) && Objects.equals(other.getQuestionType(), this.getQuestionType());
    }
}
