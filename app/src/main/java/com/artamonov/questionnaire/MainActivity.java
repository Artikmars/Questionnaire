package com.artamonov.questionnaire;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    RadioGroup radioGroup;
    RadioButton radioButton1;
    RadioButton radioButton2;
    RadioButton radioButton3;
    RadioButton radioButton4;
    TextView tvQuestion;
    Button bRetry;

    /**
     * State indicates the question position where a user is located right now [1..3]
     */
    Integer questionState = 1;


    Integer score = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup = findViewById(R.id.radioGroup);
        radioButton1 = findViewById(R.id.answer1);
        radioButton2 = findViewById(R.id.answer2);
        radioButton3 = findViewById(R.id.answer3);
        radioButton4 = findViewById(R.id.answer4);
        tvQuestion = findViewById(R.id.question);
        bRetry = findViewById(R.id.retry);
        radioButton4.setVisibility(View.INVISIBLE);

        radioButton1.setText(getResources().getString(R.string.answer_1_1));
        radioButton2.setText(getResources().getString(R.string.answer_1_2));
        radioButton3.setText(getResources().getString(R.string.answer_1_3));
        tvQuestion.setText(getResources().getString(R.string.first_question));

    }

    public void onRetry(View view) {
        questionState = 1;
        score = 0;
        radioButton1.setText(getResources().getString(R.string.answer_1_1));
        radioButton2.setText(getResources().getString(R.string.answer_1_2));
        radioButton3.setText(getResources().getString(R.string.answer_1_3));
        radioButton3.setVisibility(View.VISIBLE);
        radioButton4.setVisibility(View.GONE);
        radioGroup.clearCheck();
        tvQuestion.setText(getResources().getString(R.string.first_question));
    }

    public void onNext(View view) {

        switch (questionState) {
            case 1:
                questionState++;
                radioButton1.setText(getResources().getString(R.string.answer_2_1));
                radioButton2.setText(getResources().getString(R.string.answer_2_2));
                radioButton3.setText(getResources().getString(R.string.answer_2_3));
                radioButton4.setText(getResources().getString(R.string.answer_2_4));
                radioButton4.setVisibility(View.VISIBLE);
                tvQuestion.setText(getResources().getString(R.string.second_question));

                if (radioButton1.isChecked()) {
                    score = score + 5;
                } else if (radioButton2.isChecked()) {
                    score = score + 3;
                }
                break;
            case 2:
                questionState++;
                radioButton1.setText(getResources().getString(R.string.answer_3_1));
                radioButton2.setText(getResources().getString(R.string.answer_3_2));
                radioButton3.setVisibility(View.GONE);
                radioButton4.setVisibility(View.GONE);
                tvQuestion.setText(getResources().getString(R.string.third_question));
                if (radioButton2.isChecked()) {
                    score = score + 1;
                } else if (radioButton3.isChecked()) {
                    score = score + 3;
                } else if (radioButton4.isChecked()) {
                    score = score + 5;
                }
                break;
            case 3:
                if (radioButton1.isChecked()) {
                    score = score + 3;
                }
                Intent intent = new Intent(this, ResultActivity.class);
                intent.putExtra("score", score);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}

