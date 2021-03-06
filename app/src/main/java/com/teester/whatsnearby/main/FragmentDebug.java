package com.teester.whatsnearby.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.teester.whatsnearby.R;
import com.teester.whatsnearby.data.source.Preferences;
import com.teester.whatsnearby.data.source.SourceContract;

public class FragmentDebug extends Fragment implements MainActivityContract.DebugView {

	private TextView lastQueryTime;
	private TextView lastNotificationTime;
	private TextView lastQuery;
	private TextView accuracy;
	private TextView querydistance;
	private TextView checkdistance;
	private MainActivityContract.DebugPresenter debugPresenter;
	private SourceContract.Preferences preferences;

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		SourceContract.Preferences preferences = new Preferences(getContext());
		debugPresenter = new DebugPresenter(this, preferences);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
	                         Bundle savedInstanceState) {
		super.onCreateView(inflater, container, savedInstanceState);
		return inflater.inflate(R.layout.fragment_debug, container, false);
	}

	@Override
	public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		this.lastQueryTime = view.findViewById(R.id.textView6);
		this.lastNotificationTime = view.findViewById(R.id.textView7);
		this.lastQuery = view.findViewById(R.id.textView8);
		this.accuracy = view.findViewById(R.id.textView16);
		this.querydistance = view.findViewById(R.id.textView14);
		this.checkdistance = view.findViewById(R.id.textView15);

		debugPresenter.getDetails();
	}

	@Override
	public void setLastQueryTime(String time, int color) {
		this.lastQueryTime.setText(time);
		this.lastQueryTime.setTextColor(getResources().getColor(color));
	}

	@Override
	public void setLastNotificationTime(String notificationTime, int color) {
		this.lastNotificationTime.setText(notificationTime);
		this.lastNotificationTime.setTextColor(getResources().getColor(color));
	}

	@Override
	public void setLastQuery(String queryTime) {
		this.lastQuery.setText(queryTime);
	}

	@Override
	public void setAccuracy(String accuracy, int color) {
		this.accuracy.setText(accuracy);
		this.accuracy.setTextColor(getResources().getColor(color));
	}

	@Override
	public void setQuerydistance(String querydistance, int color) {
		this.querydistance.setText(querydistance);
		this.querydistance.setTextColor(getResources().getColor(color));
	}

	@Override
	public void setCheckdistance(String queryTimeSince, int color) {
		this.checkdistance.setText(queryTimeSince);
		this.checkdistance.setTextColor(getResources().getColor(color));
	}

	@Override
	public void setPresenter(MainActivityContract.DebugPresenter presenter) {

	}
}
