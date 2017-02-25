package com.example.android.quizwitcher;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Damian on 21/02/2017.
 *
 */

public class ResultActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent i = getIntent();
        int intValue = i.getIntExtra("ResultValue",0);
        int intVal = i.getIntExtra("TableOfGoodAnswers",0);
        int procVa = intValue*10;
        TextView tv = (TextView) findViewById(R.id.text_view_result);
        tv.setText("Twój wynik to: " + intValue + "/" + intVal +
                ". \nZdobyłeś " + procVa + "%" );
        Toast.makeText(getApplicationContext(),intValue + "/" + intVal,Toast.LENGTH_SHORT).show();
    }

    /**
     * Method reset the quiz and back to previous Activity.
     * @param view The view.
     */
    public void resetQuiz(View view){
        Intent i = new Intent(this, QuizActivity.class);
        startActivity(i);
    }
}
