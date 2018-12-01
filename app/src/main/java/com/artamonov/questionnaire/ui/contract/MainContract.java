package com.artamonov.questionnaire.ui.contract;

public interface MainContract {

    interface MainPresenter {
        void onRetryClicked();

        void onNextClicked();

        boolean isBetween(int score, int lower_bound, int upper_bound);
    }

    interface MainView {
        void onRetry();

        void onNext();
    }

}
