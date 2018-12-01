package com.artamonov.questionnaire.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.RatingBar;
import android.widget.TextView;

import com.artamonov.questionnaire.R;
import com.artamonov.questionnaire.ui.contract.MainContract;
import com.artamonov.questionnaire.ui.presenter.MainPresenter;

public class ResultActivity extends AppCompatActivity implements MainContract.MainView {
    int score;

    RatingBar ratingBar;
    TextView tvResult;
    MainContract.MainPresenter mainPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        mainPresenter = new MainPresenter(this);

        ratingBar = findViewById(R.id.ratingBar);
        tvResult = findViewById(R.id.result);


        Intent intent = getIntent();
        score = intent.getIntExtra("score", 0);


        if (mainPresenter.isBetween(score, 0, 6)) {
            ratingBar.setRating(1);
            tvResult.setText(getResources().getString(R.string.result_1));
        } else if (mainPresenter.isBetween(score, 7, 10)) {
            ratingBar.setRating(4);
            tvResult.setText(getResources().getString(R.string.result_2));
        } else if (mainPresenter.isBetween(score, 11, 100)) {
            ratingBar.setRating(5);
            tvResult.setText(getResources().getString(R.string.result_3));
        }


    }

    @Override
    public void onRetry() {

    }

    @Override
    public void onNext() {

    }
}
