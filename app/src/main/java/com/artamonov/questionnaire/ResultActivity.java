package com.artamonov.questionnaire;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.RatingBar;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    int score;

    RatingBar ratingBar;
    TextView tvResult;

    public static boolean isBetween(int score, int lower_bound, int upper_bound) {
        return lower_bound <= score && score <= upper_bound;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        ratingBar = findViewById(R.id.ratingBar);
        tvResult = findViewById(R.id.result);


        Intent intent = getIntent();
        score = intent.getIntExtra("score", 0);


        if (isBetween(score, 0, 6)) {
            ratingBar.setRating(1);
            tvResult.setText(getResources().getString(R.string.result_1));
        } else if (isBetween(score, 7, 10)) {
            ratingBar.setRating(4);
            tvResult.setText(getResources().getString(R.string.result_2));
        } else if (isBetween(score, 11, 100)) {
            ratingBar.setRating(5);
            tvResult.setText(getResources().getString(R.string.result_3));
        }





    }

}
