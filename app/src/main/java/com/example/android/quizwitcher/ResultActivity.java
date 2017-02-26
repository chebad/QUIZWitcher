package com.example.android.quizwitcher;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Damian on 21/02/2017.
 */

public class ResultActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent i = getIntent();
        //==  Variables received from QuizActivity (same name as variables in previous activity)  ==
        int resultValue = i.getIntExtra("ResultValue", 0);
        int tableAnswersLength = i.getIntExtra("TableOfGoodAnswers", 0);
        int percentValue = resultValue * 10;
        //==========================================================================================
        TextView tv = (TextView) findViewById(R.id.text_view_result);
        tv.setText("Twój wynik to: " + resultValue + "/" + tableAnswersLength +
                ". \nZdobyłeś " + percentValue + "%");
        Toast.makeText(getApplicationContext(), resultValue + "/" + tableAnswersLength, Toast.LENGTH_SHORT).show();
    }

    /**
     * Method reset the quiz and back to main Activity.
     *
     * @param view The view.
     */
    public void resetQuiz(View view) {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}
