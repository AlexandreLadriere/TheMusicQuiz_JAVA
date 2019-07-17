/*
 * @Author: Alexandre Ladrière 
 * @Date: 2019-07-17 17:35:12 
 * @Last Modified by:   Alexandre Ladrière 
 * @Last Modified time: 2019-07-17 17:35:12 
 */
package com.themusicquiz.enumerations;

public enum QuestionType {
    UNDEFINED(0, "Undefined"),
    WHO(1, "Who ?"),
    WHEN(2, "When ?"),
    WHICH(3, "Which ?"),
    COVER(4, "By cover"),
    RANDOM(13, "Random"),
    DISCOVER(14, "Discover");

    protected int questionType = 0;
    protected String questionTypeName = "";

    QuestionType(int pQuestionType, String pQuestionTypeName) {
        this.questionType = pQuestionType;
        this.questionTypeName = pQuestionTypeName;
    }

    public int getQuestionTypeValue() {
        return this.questionType;
    }

    public String getQuestionTypeNameValue() {
        return this.questionTypeName;
    }
}
