package com.mappls.sdk.navigation.ui.navigation;

import com.mappls.sdk.navigation.MapplsNavigationHelper;
import com.mappls.sdk.navigation.NavLocation;
import com.mappls.sdk.navigation.NavigationApplication;
import com.mappls.sdk.navigation.data.WayPoint;
import com.mappls.sdk.services.api.autosuggest.model.ELocation;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class MapplsNavigationViewHelper {
    private static MapplsNavigationViewHelper mapplsNavigationViewHelper = new MapplsNavigationViewHelper();
    private ELocation destination;
    private NavLocation startLocation;
    private List<WayPoint> wayPoints;

    public static MapplsNavigationViewHelper getInstance() {
        return mapplsNavigationViewHelper;
    }

    public void addWayPoint(ELocation eLocation) {
        if (eLocation.latitude == null || eLocation.longitude == null) {
            String mapplsPin = eLocation.getMapplsPin();
            String str = eLocation.placeName;
            this.wayPoints.add(0, new WayPoint(mapplsPin, str, str));
            return;
        }
        double dDoubleValue = eLocation.latitude.doubleValue();
        double dDoubleValue2 = eLocation.longitude.doubleValue();
        String str2 = eLocation.placeName;
        this.wayPoints.add(0, new WayPoint(dDoubleValue, dDoubleValue2, str2, str2));
    }

    public void clearWayPoints() {
        this.wayPoints = new ArrayList();
    }

    public ELocation getDestination() {
        return this.destination;
    }

    public NavLocation getStartLocation() {
        return this.startLocation;
    }

    public List<WayPoint> getWayPoints() {
        return this.wayPoints;
    }

    @Deprecated
    public void init(NavigationApplication navigationApplication) {
        MapplsNavigationHelper.getInstance().init(navigationApplication);
    }

    public void setDestination(ELocation eLocation) {
        this.destination = eLocation;
    }

    public void setStartLocation(NavLocation navLocation) {
        this.startLocation = navLocation;
    }

    public void setWayPoints(List<WayPoint> list) {
        this.wayPoints = list;
    }
}
