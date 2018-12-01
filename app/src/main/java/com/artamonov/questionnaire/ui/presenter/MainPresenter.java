package com.artamonov.questionnaire.ui.presenter;

import com.artamonov.questionnaire.ui.contract.MainContract;

public class MainPresenter implements MainContract.MainPresenter {

    private MainContract.MainView view;

    public MainPresenter(MainContract.MainView view) {

        this.view = view;
    }


    @Override
    public void onRetryClicked() {
        view.onRetry();
    }

    @Override
    public void onNextClicked() {
        view.onNext();
    }

    @Override
    public boolean isBetween(int score, int lower_bound, int upper_bound) {
        return lower_bound <= score && score <= upper_bound;
    }
}
