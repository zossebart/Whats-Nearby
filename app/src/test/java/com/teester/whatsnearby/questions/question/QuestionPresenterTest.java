package com.teester.whatsnearby.questions.question;

import com.teester.whatsnearby.R;
import com.teester.whatsnearby.data.Answers;
import com.teester.whatsnearby.data.OsmObject;
import com.teester.whatsnearby.data.PoiList;
import com.teester.whatsnearby.data.source.SourceContract;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class QuestionPresenterTest {

	@Mock
	private SourceContract.Preferences preferences;

	@Mock
	private QuestionFragmentContract.View view;

	private QuestionFragmentContract.Presenter questionPresenter;
	private OsmObject osmObject = new OsmObject(1, "node", "The Restaurant", "restaurant", 1, 1, 1);

	@Before
	public void setUp() {
		List<OsmObject> poiList = new ArrayList<>();
		poiList.add(osmObject);
		PoiList.getInstance().setPoiList(poiList);

		Answers.setPoiDetails(osmObject);
		questionPresenter = new QuestionPresenter(view, 0, preferences);
	}

	@After
	public void tearDown() {
		PoiList.getInstance().clearPoiList();
	}

	@Test
	public void getObjectTest() {
		questionPresenter.getQuestion();
		verify(view).setPreviousAnswer(anyString());
	}

	@Test
	public void yes_answer_selected() {
		questionPresenter.onAnswerSelected(R.id.answer_yes);
		Set<String> keySet = Answers.getAnswerMap().keySet();
		String key = keySet.toArray(new String[keySet.size()])[0];

		String actual_answer = Answers.getAnswerMap().get(key);
		String expected_answer = "yes";

		verify(view).setBackgroundColor(anyInt(), anyInt(), anyInt());
		assertEquals(expected_answer, actual_answer);
	}

	@Test
	public void no_answer_selected() {
		questionPresenter.onAnswerSelected(R.id.answer_no);
		Set<String> keySet = Answers.getAnswerMap().keySet();
		String key = keySet.toArray(new String[keySet.size()])[0];

		String actual_answer = Answers.getAnswerMap().get(key);
		String expected_answer = "no";

		verify(view).setBackgroundColor(anyInt(), anyInt(), anyInt());
		assertEquals(expected_answer, actual_answer);
	}

	@Test
	public void unsure_answer_selected() {
		questionPresenter.onAnswerSelected(R.id.answer_unsure);
		Set<String> keySet = Answers.getAnswerMap().keySet();
		String key = keySet.toArray(new String[keySet.size()])[0];

		String actual_answer = Answers.getAnswerMap().get(key);
		String expected_answer = "";

		verify(view).setBackgroundColor(anyInt(), anyInt(), anyInt());
		assertEquals(expected_answer, actual_answer);
	}
}