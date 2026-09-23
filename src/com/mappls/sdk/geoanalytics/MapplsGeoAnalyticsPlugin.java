package com.mappls.sdk.geoanalytics;

import com.mappls.sdk.maps.MapView;
import com.mappls.sdk.maps.MapplsMap;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class MapplsGeoAnalyticsPlugin extends c {
    public MapplsGeoAnalyticsPlugin(MapView mapView, MapplsMap mapplsMap) {
        super(mapView, mapplsMap);
    }

    public void removeGeoAnalytics(MapplsGeoAnalyticsType mapplsGeoAnalyticsType) {
        super.removeLayer(mapplsGeoAnalyticsType);
    }

    @Override // com.mappls.sdk.geoanalytics.c
    public void setCustomGeoAnalyticsInfoWindowAdapter(CustomGeoAnalyticsInfoWindowAdapter customGeoAnalyticsInfoWindowAdapter) {
        super.setCustomGeoAnalyticsInfoWindowAdapter(customGeoAnalyticsInfoWindowAdapter);
    }

    @Override // com.mappls.sdk.geoanalytics.c
    public void setGeoAnalyticsCallback(MapplsGeoAnalyticsCallback mapplsGeoAnalyticsCallback) {
        super.setGeoAnalyticsCallback(mapplsGeoAnalyticsCallback);
    }

    @Override // com.mappls.sdk.geoanalytics.c
    public void shouldShowInfoWindow(boolean z) {
        super.shouldShowInfoWindow(z);
    }

    public void showGeoAnalytics(MapplsGeoAnalyticsType mapplsGeoAnalyticsType, MapplsGeoAnalyticsRequest mapplsGeoAnalyticsRequest) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(mapplsGeoAnalyticsRequest);
        showGeoAnalytics(mapplsGeoAnalyticsType, arrayList);
    }

    @Override // com.mappls.sdk.geoanalytics.c
    public void showGeoAnalytics(MapplsGeoAnalyticsType mapplsGeoAnalyticsType, List<MapplsGeoAnalyticsRequest> list) {
        super.showGeoAnalytics(mapplsGeoAnalyticsType, list);
    }
}
