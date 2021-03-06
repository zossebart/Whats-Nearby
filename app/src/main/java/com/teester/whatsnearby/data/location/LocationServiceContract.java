package com.teester.whatsnearby.data.location;

import android.location.Location;

import com.teester.whatsnearby.BasePresenter;
import com.teester.whatsnearby.BaseView;

public interface LocationServiceContract {

	interface Presenter extends BasePresenter {

		void processLocation(Location location);

		void createLostClient();

		void queryResult();

		void updateLastQueryTime();
	}

	interface Service extends BaseView<Presenter> {

		void cancelNotifications();

		void createLostClient(int interval);

		void performOverpassQuery(Location location);

		void createNotification(String name, int drawable);
	}
}
