package com.themusicquiz.composants;

import com.themusicquiz.enumerations.QuestionType;
import com.themusicquiz.enumerations.Constantes;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class RandGenerator {
    public RandGenerator() {}

    public int randInt_nextInt(int pMin, int pMax) {
        int randInt = pMin;
        Random rand = new Random();
        randInt = rand.nextInt((pMax-pMin)+1)+pMin;
        return randInt;
    }

    public int randInt_ThreadLocalRandom(int pMin, int pMax) {
        int randInt = pMin;
        randInt = ThreadLocalRandom.current().nextInt(pMin, pMax + 1);
        return randInt;
    }

    public int[] randPermutation(int pMin, int pMax) {
        int tabSize = pMax-pMin+1;
        int[] tabIn = new int[tabSize];
        int[] tabOut = new int[tabSize];
        List<Integer> intList = new ArrayList<Integer>();
        for(int i = 0; i<tabSize; i++) {
            tabIn[i] = pMin+i;
            intList.add(pMin+i);
        }
        Collections.shuffle(intList);
        for(int i = 0; i<tabSize; i++) {
            tabOut[i] = intList.get(i);
        }
        return tabOut;
    }

    public QuestionType getRandomQuestionType() {
        int tmpRandNumber = this.randInt_nextInt(1,4); //a generaliser
        for(QuestionType questionType : QuestionType.values()) {
            if(tmpRandNumber == questionType.getQuestionTypeValue()) {
                return questionType;
            }
        }
        return QuestionType.UNDEFINED;
    }

    public List<Question> getQuestionSerie(QuestionType pQuestionType, List<Item> pItemList) {
        List<Question> questionList = new ArrayList<Question>();
        Item[] itemPropositionArray = new Item[Constantes.NUMBER_OF_PROPOSITIONS.getValue()-1];
        int max = pItemList.size()-1;
        if(pQuestionType.equals(QuestionType.RANDOM)) {
            for(int i = 0; i<Constantes.NUMBER_OF_QUESTIONS.getValue(); i++) {
                for(int j = 0; j<Constantes.NUMBER_OF_PROPOSITIONS.getValue()-1; j++) {
                    itemPropositionArray[j] = pItemList.get(this.randInt_nextInt(0, max));
                }
                questionList.add(new Question(this.getRandomQuestionType(), pItemList.get(this.randInt_nextInt(0, max)), itemPropositionArray));
            }
        }
        else {
            for(int i = 0; i<Constantes.NUMBER_OF_QUESTIONS.getValue(); i++) {
                for(int j = 0; j<Constantes.NUMBER_OF_PROPOSITIONS.getValue()-1; j++) {
                    itemPropositionArray[j] = pItemList.get(this.randInt_nextInt(0, max));
                }
                questionList.add(new Question(pQuestionType, pItemList.get(this.randInt_nextInt(0, max)), itemPropositionArray));
            }
        }
        return questionList;
    }
}

