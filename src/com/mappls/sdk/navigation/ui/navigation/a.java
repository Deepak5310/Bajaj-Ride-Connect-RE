package com.mappls.sdk.navigation.ui.navigation;

import com.mappls.sdk.maps.MapplsMap;
import com.mappls.sdk.maps.geometry.LatLng;
import com.mappls.sdk.navigation.MapplsNavigationHelper;
import com.mappls.sdk.services.api.autosuggest.model.ELocation;

/* JADX INFO: loaded from: classes4.dex */
public final class a implements com.mappls.sdk.navigation.ui.navigation.searchalongroute.c {
    public final /* synthetic */ NavigationView a;

    public a(NavigationView navigationView) {
        this.a = navigationView;
    }

    public final void a(ELocation eLocation) {
        if (eLocation != null) {
            MapplsNavigationViewHelper.getInstance().clearWayPoints();
            MapplsNavigationViewHelper.getInstance().setDestination(eLocation);
            if (eLocation.latitude == null || eLocation.longitude == null) {
                MapplsNavigationHelper mapplsNavigationHelper = MapplsNavigationHelper.getInstance();
                String mapplsPin = eLocation.getMapplsPin();
                String str = eLocation.placeName;
                mapplsNavigationHelper.navigateTo(mapplsPin, str, str);
            } else {
                MapplsNavigationHelper mapplsNavigationHelper2 = MapplsNavigationHelper.getInstance();
                LatLng latLng = new LatLng(eLocation.latitude.doubleValue(), eLocation.longitude.doubleValue());
                String str2 = eLocation.placeName;
                mapplsNavigationHelper2.navigateTo(latLng, str2, str2);
            }
            MapplsMap mapplsMap = this.a.mapplsMap;
            if (mapplsMap != null) {
                mapplsMap.clear();
            }
            q qVar = this.a.navigationViewModel;
            if (qVar != null) {
                qVar.c.setValue(eLocation);
            }
        }
    }

    public final void b(ELocation eLocation) {
        if (eLocation != null) {
            MapplsNavigationViewHelper.getInstance().addWayPoint(eLocation);
            if (eLocation.latitude == null || eLocation.longitude == null) {
                MapplsNavigationHelper mapplsNavigationHelper = MapplsNavigationHelper.getInstance();
                String mapplsPin = eLocation.getMapplsPin();
                String str = eLocation.placeName;
                mapplsNavigationHelper.addWayPoint(mapplsPin, 0, str, str);
            } else {
                MapplsNavigationHelper mapplsNavigationHelper2 = MapplsNavigationHelper.getInstance();
                LatLng latLng = new LatLng(eLocation.latitude.doubleValue(), eLocation.longitude.doubleValue());
                String str2 = eLocation.placeName;
                mapplsNavigationHelper2.addWayPoint(latLng, 0, str2, str2);
            }
            MapplsMap mapplsMap = this.a.mapplsMap;
            if (mapplsMap != null) {
                mapplsMap.clear();
            }
        }
    }
}
