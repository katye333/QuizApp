package com.example.android.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Determine the user's score
     * @return int score
     */
    private int calculateScore() {
        int score = 0;

        // Check answer to question 1
        RadioButton question_1 = findViewById(R.id.answer_1_kindle);
        if (question_1.isChecked()) {
            score += 1;
        }

        // Check answer to question 2
        CheckBox q2_answer_1 = findViewById(R.id.answer_2_clowder);
        CheckBox q2_answer_2 = findViewById(R.id.answer_2_clutter);
        CheckBox q2_answer_3 = findViewById(R.id.answer_2_glaring);
        CheckBox q2_answer_4 = findViewById(R.id.answer_2_pounce);

        if (q2_answer_1.isChecked() && q2_answer_2.isChecked() && q2_answer_3.isChecked() && q2_answer_4.isChecked()) {
            score += 1;
        }

        // Check answer to question 3
        TextView answer_3_value = findViewById(R.id.answer_3);
        String answer_3 = answer_3_value.getText().toString().toLowerCase();

        if (answer_3.equals("stubbs")) {
            score += 1;
        }

        // Check answer to question 4
        RadioButton question_4 = findViewById(R.id.answer_4_true);
        if (question_4.isChecked()) {
            score += 1;
        }

        return score;
    }

    public void submitQuiz(View v) {
        int number_correct = calculateScore();

        float score = ((float) number_correct / 4) * 100;

        EditText text_name = findViewById(R.id.name);
        String name = text_name.getText().toString();

        Toast.makeText(this, name + " scored a " + (int) score + "!", Toast.LENGTH_SHORT).show();
        return;
    }
}
