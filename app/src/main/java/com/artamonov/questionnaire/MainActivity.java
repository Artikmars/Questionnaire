package com.artamonov.questionnaire;

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
    Button bPrevious;
    Button bNext;

    Integer state = 1;
    Integer grade = 0;


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
        bPrevious = findViewById(R.id.previous);
        bNext = findViewById(R.id.next);
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
                                grade = grade + 5;
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
                                grade = grade + 3;
                                state++;
                                radioButton1.setText(getResources().getString(R.string.answer_2_1));
                                radioButton2.setText(getResources().getString(R.string.answer_2_2));
                                radioButton3.setText(getResources().getString(R.string.answer_2_3));
                                radioButton4.setText(getResources().getString(R.string.answer_2_4));
                                radioButton4.setVisibility(View.VISIBLE);
                                tvQuestion.setText(getResources().getString(R.string.second_question));
                        }

                        break;
                    case R.id.answer2:
                        switch (state) {
                            case 1:
                                grade = grade + 3;
                                state++;
                                radioButton1.setText(getResources().getString(R.string.answer_2_1));
                                radioButton2.setText(getResources().getString(R.string.answer_2_2));
                                radioButton3.setText(getResources().getString(R.string.answer_2_3));
                                radioButton4.setText(getResources().getString(R.string.answer_2_4));
                                radioButton4.setVisibility(View.VISIBLE);
                                tvQuestion.setText(getResources().getString(R.string.second_question));
                                break;
                            case 2:
                                grade = grade + 1;
                                state++;
                                radioButton1.setText(getResources().getString(R.string.answer_3_1));
                                radioButton2.setText(getResources().getString(R.string.answer_3_2));
                                radioButton3.setVisibility(View.GONE);
                                radioButton4.setVisibility(View.GONE);
                                tvQuestion.setText(getResources().getString(R.string.third_question));
                                break;
                            case 3:
                                state++;
                                radioButton1.setText(getResources().getString(R.string.answer_2_1));
                                radioButton2.setText(getResources().getString(R.string.answer_2_2));
                                radioButton3.setText(getResources().getString(R.string.answer_2_3));
                                radioButton4.setText(getResources().getString(R.string.answer_2_4));
                                radioButton4.setVisibility(View.VISIBLE);
                                tvQuestion.setText(getResources().getString(R.string.second_question));
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
                                grade = grade + 3;
                                state++;
                                radioButton1.setText(getResources().getString(R.string.answer_3_1));
                                radioButton2.setText(getResources().getString(R.string.answer_3_2));
                                radioButton3.setVisibility(View.GONE);
                                radioButton4.setVisibility(View.GONE);
                                tvQuestion.setText(getResources().getString(R.string.third_question));
                                break;
                            case 3:
                                break;
                        }
                    case R.id.answer4:
                        switch (state) {
                            case 1:
                                grade = grade + 5;
                                state++;
                                radioButton1.setText(getResources().getString(R.string.answer_2_1));
                                radioButton2.setText(getResources().getString(R.string.answer_2_2));
                                radioButton3.setText(getResources().getString(R.string.answer_2_3));
                                radioButton4.setText(getResources().getString(R.string.answer_2_4));
                                radioButton4.setVisibility(View.VISIBLE);
                                tvQuestion.setText(getResources().getString(R.string.second_question));
                                break;
                            case 2:
                                grade = grade + 5;
                                state++;
                                radioButton1.setText(getResources().getString(R.string.answer_3_1));
                                radioButton2.setText(getResources().getString(R.string.answer_3_2));
                                radioButton3.setVisibility(View.GONE);
                                radioButton4.setVisibility(View.GONE);
                                tvQuestion.setText(getResources().getString(R.string.third_question));

                            case 3:
                                break;
                            default:
                                break;
                        }
                }
            }
        });


    }


    public void onPrevious(View view) {
        if (state != 1) {
            state = state - 1;
        }

    }

    public void onNext(View view) {
    }
}
