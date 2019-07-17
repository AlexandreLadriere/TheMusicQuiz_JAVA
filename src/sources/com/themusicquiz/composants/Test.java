/*
 * @Author: Alexandre Ladrière 
 * @Date: 2019-07-17 17:34:11 
 * @Last Modified by:   Alexandre Ladrière 
 * @Last Modified time: 2019-07-17 17:34:11 
 */
package com.themusicquiz.composants;

import com.themusicquiz.enumerations.*;
import java.io.IOException;
import java.io.File;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.lang.System;

public class Test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int playAgain = 1;
        System.out.println("################# The Music Quiz #################");
        while(playAgain == 1) {
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
            System.out.print("\nPLAY AGAIN ??\n\t0: No, quit the game\n\t1: Yes of course !\n\nYour choice: ");
            playAgain = in.nextInt();
        }
    }

    public static String getDBPath() { //provisoire
        Scanner in = new Scanner(System.in);
        int userAnswer = -1;
        String DBPathChoice = "";
        System.out.println("Please select your category:");
        for(int i = 0; i<MusicGenres.values().length; i++) {
            System.out.println(i+". "+MusicGenres.values()[i].getMusicGenreLanguage_toDisplay());
        }
        System.out.print("\nYour answer (0-"+(MusicGenres.values().length-1)+"): ");
        userAnswer = in.nextInt();
        DBPathChoice = Paths.DBPath.getPath()+"/hiphop/"+MusicGenres.values()[userAnswer].getMusicGenreLanguage_name()+"//"+MusicGenres.values()[userAnswer].getMusicGenreLanguage_name()+".txt";
        return DBPathChoice;
    }

    public static QuestionType getQuestionType() {
        Scanner in = new Scanner(System.in);
        int userAnswer = -1;
        System.out.print("Please select the type of question: ");
        for(int i = 0; i<QuestionType.values().length; i++) {
            System.out.println(i+". "+QuestionType.values()[i].getQuestionTypeNameValue());
        }
        System.out.print("\nYour answer (0-"+(QuestionType.values().length-1)+"): ");
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
                Item tmpItem = itemList.get(rand.randInt_nextInt(0, itemList.size()));
                System.out.println("--------------------------------------------------------------------");
                System.out.println(tmpItem.getItemDescription()+"\n");
                System.out.println(tmpItem.getItemSummary());
                System.out.println("\n## Press Enter to continue...");
                in.nextLine();
            }
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }  

    public static void startQuiz(QuestionType pQuestionType, String pDBPath) throws IOException {
        Scanner in = new Scanner(System.in);
        Item userAnswer = new Item();
        QuestionSerie questionSerie = new QuestionSerie(pDBPath, pQuestionType);
        long start = 0L;
        long end = 0L;
        try {
            for(int i = 0; i<Constantes.NUMBER_OF_QUESTIONS.getValue(); i++) {
                Question currentQuestion = questionSerie.getQuestionSerieQuestionList().get(i);
                System.out.println("\n\n--------------------------------------------");
                System.out.println(currentQuestion.askQuestion());
                start = System.currentTimeMillis();
                System.out.println("cover: "+currentQuestion.getQuestionItem().getItemCoverPath());
                for(int j = 0; j<Constantes.NUMBER_OF_PROPOSITIONS.getValue(); j++) {
                    System.out.println("\tProposition "+(j)+": "+currentQuestion.getProposition(currentQuestion.getQuestionOptions()[j]));
                }
                System.out.print("\nYour answer (0-"+(Constantes.NUMBER_OF_PROPOSITIONS.getValue()-1)+"): ");
                userAnswer = currentQuestion.getQuestionOptions()[in.nextInt()];
                end = System.currentTimeMillis();
                currentQuestion.setQuestionTime(end-start);
                currentQuestion.checkAnswer(currentQuestion.getProposition(userAnswer)); //always call checkAnswer after setting questionTime
                if(currentQuestion.getQuestionIsCorrect()) {
                    System.out.println("## CORRECT ANSWER !");
                }
                else {
                    System.out.println("## WRONG ANSWER !");
                    System.out.println("Correct Answer: "+currentQuestion.getQuestionCorrectAnswer());
                }
                System.out.println("## QUESTION SCORE: "+currentQuestion.getQuestionScore());
                System.out.println("\n\n"+currentQuestion.getQuestionItem().getItemSummary());
            }
            System.out.print("\n--------------------------------------------------------------------------");
            System.out.print("\nCORRECT ANSWERS: "+questionSerie.getQuestionSerieCorrectAnswerNumber()+"/"+Constantes.NUMBER_OF_QUESTIONS.getValue());
            System.out.print("\nTOTAL SCORE: "+questionSerie.getQuestionSerieTotalScore()+" pts");
            System.out.print("\nAVERAGE TIME: "+(questionSerie.getQuestionSerieAverageTime()/1000F)+" secondes");
            System.out.println("\n--------------------------------------------------------------------------");
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }   
}
