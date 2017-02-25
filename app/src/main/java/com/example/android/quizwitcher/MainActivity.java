package com.example.android.quizwitcher;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method open the new activity with quiz questions.
     * @param view The view.
     */
    public void openQuizQuestion(View view) {
        Intent i = new Intent(this, QuizActivity.class);
        startActivity(i);
    }
}

