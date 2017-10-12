package com.teester.whatsnearby.questions.question;

import com.teester.whatsnearby.BasePresenter;
import com.teester.whatsnearby.BaseView;

public interface QuestionFragmentContract {

	interface Presenter extends BasePresenter {

		void getQuestion();

		void onAnswerSelected(int id);
	}

	interface View extends BaseView<Presenter> {

		void showQuestion(int question, String name, int color, int drawable);

		void setBackgroundColor(int yes, int no, int unsure);
	}
}