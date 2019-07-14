package com.themusicquiz.composants;

import com.themusicquiz.enumerations.Constantes;
import com.themusicquiz.enumerations.QuestionType;
import java.util.List;
import java.util.ArrayList;

public class QuestionSerie {
    protected String questionSerieDBPath;
    protected QuestionType questionSerieQuestionType;
    protected int questionSerieCorrectAnswerNumber;


    private RandGenerator questionSerieRandGenerator;
    private FileHandler questionSerieFileHandler;

    public QuestionSerie() {}

    public QuestionSerie(String pDBPath, QuestionType pQuestionType) {
        questionSerieDBPath = pDBPath;
        questionSerieQuestionType = pQuestionType;

    }
}