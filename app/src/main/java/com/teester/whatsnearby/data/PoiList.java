package com.teester.whatsnearby.data;

import com.teester.whatsnearby.Utilities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * A Singleton to store the current POI list
 */
public class PoiList {

	private static PoiList INSTANCE;
	private List<OsmObject> poiList = new ArrayList<>();

	private PoiList() {

	}

	public static synchronized PoiList getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new PoiList();
		}
		return INSTANCE;
	}

	/**
	 * Get a list of points of interest
	 *
	 * @return
	 */
	public List<OsmObject> getPoiList() {
		return poiList;
	}

	/**
	 * Set a list of points of interest
	 *
	 * @param poiList
	 */
	public void setPoiList(List<OsmObject> poiList) {
		this.poiList = poiList;
	}

	/**
	 * Create a list of POIs except the first one
	 *
	 * @return
	 */
	public List<OsmObject> createAlternateList() {
		return poiList.subList(1, poiList.size());
	}

	/**
	 * Clears the list of points of interest
	 */
	public void clearPoiList() {
		INSTANCE = null;
	}

	public void sortList(final double queryLatitude, final double queryLongitude) {
		Collections.sort(poiList, new Comparator<OsmObject>() {
			public int compare(OsmObject p1, OsmObject p2) {
				float p1Distance = Utilities.computeDistance(queryLatitude, queryLongitude, p1.getLatitude(), p1.getLongitude());
				float p2Distance = Utilities.computeDistance(queryLatitude, queryLongitude, p2.getLatitude(), p2.getLongitude());
				return (int) (p1Distance - p2Distance);
			}
		});
	}

}
