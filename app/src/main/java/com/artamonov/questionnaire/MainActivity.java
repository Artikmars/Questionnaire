package com.artamonov.questionnaire;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

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
    Integer state = 1;


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
        radioButton4 = findViewById(R.id.answer4);
        tvQuestion = findViewById(R.id.question);
        bRetry = findViewById(R.id.retry);
        radioButton4.setVisibility(View.INVISIBLE);

        radioButton1.setText(getResources().getString(R.string.answer_1_1));
        radioButton2.setText(getResources().getString(R.string.answer_1_2));
        radioButton3.setText(getResources().getString(R.string.answer_1_3));
        tvQuestion.setText(getResources().getString(R.string.first_question));


        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case -1:
                        Toast.makeText(getApplicationContext(), "Please, choose the answer",
                                Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.answer1:
                        switch (state) {
                            case 1:
                                score = score + 5;
                                state++;
                                radioButton1.setText(getResources().getString(R.string.answer_2_1));
                                radioButton2.setText(getResources().getString(R.string.answer_2_2));
                                radioButton3.setText(getResources().getString(R.string.answer_2_3));
                                radioButton4.setText(getResources().getString(R.string.answer_2_4));
                                radioButton4.setVisibility(View.VISIBLE);
                                tvQuestion.setText(getResources().getString(R.string.second_question));
                                break;
                            case 2:
                                state++;
                                radioButton1.setText(getResources().getString(R.string.answer_3_1));
                                radioButton2.setText(getResources().getString(R.string.answer_3_2));
                                radioButton3.setVisibility(View.GONE);
                                radioButton4.setVisibility(View.GONE);
                                tvQuestion.setText(getResources().getString(R.string.third_question));

                            case 3:
                                score = score + 3;
                                Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
                                intent.putExtra("score", score);
                                startActivity(intent);
                        }

                        break;
                    case R.id.answer2:
                        switch (state) {
                            case 1:
                                score = score + 3;
                                state++;
                                radioButton1.setText(getResources().getString(R.string.answer_2_1));
                                radioButton2.setText(getResources().getString(R.string.answer_2_2));
                                radioButton3.setText(getResources().getString(R.string.answer_2_3));
                                radioButton4.setText(getResources().getString(R.string.answer_2_4));
                                radioButton4.setVisibility(View.VISIBLE);
                                tvQuestion.setText(getResources().getString(R.string.second_question));
                                break;
                            case 2:
                                score = score + 1;
                                state++;
                                radioButton1.setText(getResources().getString(R.string.answer_3_1));
                                radioButton2.setText(getResources().getString(R.string.answer_3_2));
                                radioButton3.setVisibility(View.GONE);
                                radioButton4.setVisibility(View.GONE);
                                tvQuestion.setText(getResources().getString(R.string.third_question));
                                break;
                            case 3:
                                Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
                                intent.putExtra("score", score);
                                startActivity(intent);
                                break;
                        }
                    case R.id.answer3:
                        switch (state) {
                            case 1:
                                state++;
                                radioButton1.setText(getResources().getString(R.string.answer_2_1));
                                radioButton2.setText(getResources().getString(R.string.answer_2_2));
                                radioButton3.setText(getResources().getString(R.string.answer_2_3));
                                radioButton4.setText(getResources().getString(R.string.answer_2_4));
                                radioButton4.setVisibility(View.VISIBLE);
                                tvQuestion.setText(getResources().getString(R.string.second_question));
                                break;
                            case 2:
                                score = score + 3;
                                state++;
                                radioButton1.setText(getResources().getString(R.string.answer_3_1));
                                radioButton2.setText(getResources().getString(R.string.answer_3_2));
                                radioButton3.setVisibility(View.GONE);
                                radioButton4.setVisibility(View.GONE);
                                tvQuestion.setText(getResources().getString(R.string.third_question));
                                break;
                            default:
                                break;
                        }
                    case R.id.answer4:
                        switch (state) {
                            case 1:
                                score = score + 5;
                                state++;
                                radioButton1.setText(getResources().getString(R.string.answer_2_1));
                                radioButton2.setText(getResources().getString(R.string.answer_2_2));
                                radioButton3.setText(getResources().getString(R.string.answer_2_3));
                                radioButton4.setText(getResources().getString(R.string.answer_2_4));
                                radioButton4.setVisibility(View.VISIBLE);
                                tvQuestion.setText(getResources().getString(R.string.second_question));
                                break;
                            case 2:
                                score = score + 5;
                                state++;
                                radioButton1.setText(getResources().getString(R.string.answer_3_1));
                                radioButton2.setText(getResources().getString(R.string.answer_3_2));
                                radioButton3.setVisibility(View.GONE);
                                radioButton4.setVisibility(View.GONE);
                                tvQuestion.setText(getResources().getString(R.string.third_question));

                            default:
                                break;
                        }
                }
            }
        });


    }


    public void onRetry(View view) {
        state = 1;
        score = 0;
        radioButton1.setText(getResources().getString(R.string.answer_1_1));
        radioButton2.setText(getResources().getString(R.string.answer_1_2));
        radioButton3.setText(getResources().getString(R.string.answer_1_3));
        radioButton3.setVisibility(View.VISIBLE);
        radioButton4.setVisibility(View.VISIBLE);
        tvQuestion.setText(getResources().getString(R.string.first_question));
    }
}
