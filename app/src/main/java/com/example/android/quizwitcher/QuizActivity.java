package com.example.android.quizwitcher;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;



/**
 * Created by Damian on 19/02/2017.
 *
 * @author Damian
 */

public class QuizActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_quiz);
    }


    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        //Save the state of two variables when screen rotate.
        savedInstanceState.putBooleanArray("ArrayOfGoodAnswers", tableAnswers);
        savedInstanceState.putInt("ResultValue", resultValue);

    }


    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        //Write saved values to variables.
        tableAnswers = savedInstanceState.getBooleanArray("ArrayOfGoodAnswers");
        resultValue = savedInstanceState.getInt("ResultValue");
    }


    //===========================   Used variables for this quiz.    ===============================

    public int resultValue = 0;

    //10 elements for 10 questions.
    public boolean[] tableAnswers = {false, false, false, false, false,
            false, false, false, false, false};

    private String[] tabTrueAnswers = {
            "Geralt",
            "Andrzej Sapkowski",
            "Wilka",
            "CD RED Project",
            "2",
            "8",
            "Emhyr Var Emreis",
            "Płotka"
    };

    //==============================================================================================

    /**
     * Main method checking for good answers in the quiz.
     *
     * @param trueAnswer The String value of good answer from table the tabTrueAnswers.
     * @param questionId ID of the question from XML file.
     * @param i          Number of question, must be between 1-8.
     */
    private void checkIt(String trueAnswer, int questionId, int i) {
        RadioGroup q1 = (RadioGroup) findViewById(questionId);
        String s1 = ((RadioButton) findViewById(q1.getCheckedRadioButtonId())).getText().toString();
        if (s1.equals(trueAnswer)) {
            tableAnswers[i - 1] = true;
        } else {
            tableAnswers[i - 1] = false;
        }
    }

    //==============================================================================================

    /**
     * Method checking for good answer from question 1.
     *
     * @param view Current view.
     */
    public void onRadioButtonClicked1(View view) {
        checkIt(tabTrueAnswers[0], R.id.question1, 1);
    }

    /**
     * Method checking for good answer from question 2.
     *
     * @param view Current view.
     */
    public void onRadioButtonClicked2(View view) {
        checkIt(tabTrueAnswers[1], R.id.question2, 2);
    }

    /**
     * Method checking for good answer from question 3.
     *
     * @param view Current view.
     */
    public void onRadioButtonClicked3(View view) {
        checkIt(tabTrueAnswers[2], R.id.question3, 3);
    }

    /**
     * Method checked for good answer from 3rd question.
     *
     * @param s String coming from EditText and checked if it's a good answer.
     * @return true or false, depend of what answer is from user.
     */
    public boolean checkedQuestion4(String s) {
        return s.equals("Ciri") || s.equals("CIRI") || s.equals("ciri");
    }

    /**
     * Method checking for good answer from question 5.
     *
     * @param view Current view.
     */
    public void onRadioButtonClicked5(View view) {
        checkIt(tabTrueAnswers[3], R.id.question5, 5);
    }

    /**
     * Method checking for good answer from question 6.
     *
     * @param view Current view.
     */
    public void onRadioButtonClicked6(View view) {
        checkIt(tabTrueAnswers[4], R.id.question6, 6);
    }

    /**
     * Method checked for good answers from 7th question.
     *
     * @return true or false, depend of what answers are from user.
     */
    public boolean isClickedQuestion7() {
        boolean cb1 = ((CheckBox) findViewById(R.id.qustion7_Wyzima)).isChecked();
        boolean cb2 = ((CheckBox) findViewById(R.id.qustion7_Oxenfurt)).isChecked();
        boolean cb3 = ((CheckBox) findViewById(R.id.qustion7_Kingsberg)).isChecked();
        return cb1 && cb2 && !cb3;
    }

    /**
     * Method checking for good answer from question 8.
     *
     * @param view Current view.
     */
    public void onRadioButtonClicked8(View view) {
        checkIt(tabTrueAnswers[5], R.id.question8, 8);
    }

    /**
     * Method checking for good answer from question 9.
     *
     * @param view Current view.
     */
    public void onRadioButtonClicked9(View view) {
        checkIt(tabTrueAnswers[6], R.id.question9, 9);
    }

    /**
     * Checked witch radio button is checked in 10 Question.
     *
     * @param view Current view.
     */
    public void onRadioButtonClicked10(View view) {
        checkIt(tabTrueAnswers[7], R.id.question10, 10);
    }

    //==============================================================================================

    /**
     * Method checked obtain score and what user wrote in EditText label. Method display the massage
     * into Toast view.
     *
     * @param view Current view.
     */
    public void submitQuestion(View view) {
        // Statement checked if 3rd question have good answer.
        tableAnswers[3] = checkedQuestion4((((EditText) findViewById(R.id.edit_text)).getText().toString()));

        // Statement checked if 7th question have good answers.
        tableAnswers[6] = isClickedQuestion7();

        // Loop for-each for checking any good answers in quiz.
        for (boolean b : tableAnswers) {
            if (b) resultValue++;
        }

        Intent i = new Intent(this, ResultActivity.class);
        i.putExtra("TableOfGoodAnswers", tableAnswers.length);
        i.putExtra("ResultValue", resultValue);
        resultValue = 0;
        startActivity(i);
    }
}