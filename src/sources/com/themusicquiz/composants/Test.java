package com.themusicquiz.composants;

import com.themusicquiz.enumerations.*;
import java.io.IOException;
import java.io.File;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        String DBPathChoice = getDBPath();
        QuestionType questionTypeChoice = getQuestionType();
        if(questionTypeChoice.equals(QuestionType.DISCOVER)) {
            try {
                startDiscover(DBPathChoice);
            }
            catch(IOException e) {
                e.printStackTrace();
            }
        }
        else {
            try {
                startQuiz(questionTypeChoice, DBPathChoice);
            }
            catch(IOException e) {
                e.printStackTrace();
            }
        }

    }

    public static String getDBPath() { //provisoire
        Scanner in = new Scanner(System.in);
        int userAnswer = -1;
        String DBPathChoice = "";
        System.out.println("################# The Music Quiz #################");
        System.out.println("Please select your category:");
        for(int i = 0; i<MusicGenres.values().length; i++) {
            System.out.println(i+". "+MusicGenres.values()[i].getMusicGenreLanguage_toDisplay());
        }
        System.out.println("\nYour answer (0-"+(MusicGenres.values().length-1)+"): ");
        userAnswer = in.nextInt();
        DBPathChoice = Paths.DBPath.getPath()+"/hiphop/"+MusicGenres.values()[userAnswer].getMusicGenreLanguage_name()+"//"+MusicGenres.values()[userAnswer].getMusicGenreLanguage_name()+".txt";
        return DBPathChoice;
    }

    public static QuestionType getQuestionType() {
        Scanner in = new Scanner(System.in);
        int userAnswer = -1;
        System.out.println("Please select the type of question: ");
        for(int i = 0; i<QuestionType.values().length; i++) {
            System.out.println(i+". "+QuestionType.values()[i].getQuestionTypeNameValue());
        }
        System.out.println("\nYour answer (0-"+(QuestionType.values().length-1)+"): ");
        userAnswer = in.nextInt();
        return QuestionType.values()[userAnswer];
    }

    public static void startDiscover(String pDBPath) throws IOException {
        FileHandler fileHandler = new FileHandler();
        RandGenerator rand = new RandGenerator();
        Scanner in = new Scanner(System.in);
        try {
            List<Item> itemList = fileHandler.GetItemListFromDB(pDBPath);
            for(int i = 0; i<Constantes.NUMBER_OF_QUESTIONS.getValue(); i++) {
                System.out.println(itemList.get(rand.randInt_nextInt(0, itemList.size())).getItemDescription());
                System.out.println("\nPress Enter to continue...");
                in.nextLine();
            }
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }
        
    public static void startQuiz(QuestionType pQuestionType, String pDBPath) throws IOException {
        RandGenerator rand = new RandGenerator();
        Scanner in = new Scanner(System.in);
        FileHandler fileHandler = new FileHandler();
        int correctAnswerNumber = 0;
        Item userAnswer = new Item();
        try {
            List<Item> itemList = fileHandler.GetItemListFromDB(pDBPath);
            List<Question> questionList = rand.getQuestionSerie(pQuestionType, itemList);
            for(int i = 0; i<questionList.size(); i++) {
                Question currentQuestion = questionList.get(i);
                System.out.println("\n\n--------------------------------------------");
                System.out.println(currentQuestion.askQuestion());
                System.out.println("cover: "+currentQuestion.getQuestionItem().getItemCoverPath());
                for(int j = 0; j<Constantes.NUMBER_OF_PROPOSITIONS.getValue(); j++) {
                    System.out.println("\tProposition "+(j)+": "+currentQuestion.getProposition(currentQuestion.getQuestionOptions()[j]));
                }
                System.out.println("\nYour answer (0-"+(Constantes.NUMBER_OF_PROPOSITIONS.getValue()-1)+"): ");
                userAnswer = currentQuestion.getQuestionOptions()[in.nextInt()];
                currentQuestion.checkAnswer(currentQuestion.getProposition(userAnswer));
                if(currentQuestion.getQuestionIsCorrect()) {
                    System.out.println("CORRECT ANSWER !");
                    correctAnswerNumber+=1;
                }
                else {
                    System.out.println("WRONG ANSWER !");
                    System.out.println("Correct Answer: "+currentQuestion.getQuestionCorrectAnswer());
                }
                System.out.println("\n\n"+currentQuestion.getQuestionItem().getItemSummary());
            }
            System.out.println("\nYOUR SCORE: "+correctAnswerNumber+"/"+Constantes.NUMBER_OF_QUESTIONS.getValue());
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }    
}
