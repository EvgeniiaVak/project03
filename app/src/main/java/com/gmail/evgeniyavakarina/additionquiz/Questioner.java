package com.gmail.evgeniyavakarina.additionquiz;

import java.util.Random;

/**
 * Created by evgeniyavakarina on 5/12/17.
 */

public class Questioner {
    private Random mRandom = new Random();
    private int mLeftAdder;
    private int mRightAdder;
    private int mCorrectAnswer;

    /**
     * generate a question and compute the correct answer
     */
    public String createQuestion() {
        String question;
        mLeftAdder = mRandom.nextInt(75) + 1;
        mRightAdder = mRandom.nextInt(75) + 1;
        mCorrectAnswer = mLeftAdder + mRightAdder;
        question = String.format("What is %d + %d?", mLeftAdder, mRightAdder);
        return question;
    }

    /**
     * put the correct answer somewhere in the array of answers
     * and fills other answers with random false answers
     */
    public int[] generateAnswers() {
        int[] answers = new int[3];

        //place the right answer somewhere in the answers array
        int positionOfTrueAnswer = mRandom.nextInt(3);
        answers[positionOfTrueAnswer] = mCorrectAnswer;

        //fill the rest answers with some random numbers
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == 0) {
                int falseAnswer = mCorrectAnswer + mRandom.nextInt(30) - 15;

                //prevent the false answer being equal to right one
                while (falseAnswer == mCorrectAnswer) {
                    falseAnswer = mRandom.nextInt(150);
                }
                answers[i] = falseAnswer;
            }
        }
        return answers;
    }

    /**
     * check if answer is correct
     */
    public boolean isChoiceCorrect(int answer) {
        if (answer == mCorrectAnswer)
            return true;
        else
            return false;
    }
}
