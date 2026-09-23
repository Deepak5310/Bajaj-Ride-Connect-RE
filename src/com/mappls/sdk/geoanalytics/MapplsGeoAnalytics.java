package com.mappls.sdk.geoanalytics;

import com.mappls.sdk.maps.MapView;
import com.mappls.sdk.maps.MapplsMap;
import com.mappls.sdk.maps.geometry.LatLng;
import com.mappls.sdk.services.api.MapplsApiConfiguration;
import okhttp3.ResponseBody;
import rx.Observable;

/* JADX INFO: loaded from: classes6.dex */
class MapplsGeoAnalytics {
    MapplsGeoAnalytics() {
    }

    static String createPointUrl(MapView mapView, h hVar, MapplsGeoAnalyticsRequest mapplsGeoAnalyticsRequest) {
        StringBuilder sb = new StringBuilder(MapplsApiConfiguration.getInstance().getMGISApiUrl());
        sb.append("geoanalytics?geoboundtype=");
        sb.append(mapplsGeoAnalyticsRequest.geoboundType());
        sb.append("&geobound=");
        for (int i = 0; i < mapplsGeoAnalyticsRequest.geoBoundList().size(); i++) {
            sb.append("'");
            sb.append(mapplsGeoAnalyticsRequest.geoBoundList().get(i));
            sb.append("'");
            if (i != mapplsGeoAnalyticsRequest.geoBoundList().size() - 1) {
                sb.append(",");
            }
        }
        if (mapplsGeoAnalyticsRequest.query() != null && mapplsGeoAnalyticsRequest.attribute() != null) {
            sb.append("&attribute=");
            sb.append(mapplsGeoAnalyticsRequest.attribute());
            sb.append("&query=");
            sb.append(mapplsGeoAnalyticsRequest.query());
        }
        sb.append("&service=WMS&request=GetMap&version=1.1.1&layers=&styles=point_with_label&format=image/png&transparent=");
        sb.append(mapplsGeoAnalyticsRequest.transparent());
        if (mapplsGeoAnalyticsRequest.style() != null) {
            sb.append("&env=");
            sb.append(mapplsGeoAnalyticsRequest.style().toPointJson());
        }
        sb.append("&width=");
        sb.append(mapView.getWidth());
        sb.append("&height=");
        sb.append(mapView.getHeight());
        sb.append("&srs=EPSG:3857&bbox={bbox-epsg-3857}&layertype=");
        sb.append(hVar.a);
        return sb.toString();
    }

    static String createUrl(MapView mapView, h hVar, MapplsGeoAnalyticsRequest mapplsGeoAnalyticsRequest) {
        StringBuilder sb = new StringBuilder(MapplsApiConfiguration.getInstance().getMGISApiUrl());
        sb.append("geoanalytics?geoboundtype=");
        sb.append(mapplsGeoAnalyticsRequest.geoboundType());
        sb.append("&geobound=");
        for (int i = 0; i < mapplsGeoAnalyticsRequest.geoBoundList().size(); i++) {
            sb.append("'");
            sb.append(mapplsGeoAnalyticsRequest.geoBoundList().get(i));
            sb.append("'");
            if (i != mapplsGeoAnalyticsRequest.geoBoundList().size() - 1) {
                sb.append(",");
            }
        }
        if (mapplsGeoAnalyticsRequest.query() != null && mapplsGeoAnalyticsRequest.attribute() != null) {
            sb.append("&attribute=");
            sb.append(mapplsGeoAnalyticsRequest.attribute());
            sb.append("&query=");
            sb.append(mapplsGeoAnalyticsRequest.query());
        }
        sb.append("&service=WMS&request=GetMap&version=1.1.1&layers=&styles=polygon_with_label&format=image/png&transparent=");
        sb.append(mapplsGeoAnalyticsRequest.transparent());
        if (mapplsGeoAnalyticsRequest.style() != null) {
            sb.append("&env=");
            sb.append(mapplsGeoAnalyticsRequest.style().toJson());
        }
        sb.append("&width=");
        sb.append(mapView.getWidth());
        sb.append("&height=");
        sb.append(mapView.getHeight());
        sb.append("&srs=EPSG:3857&bbox={bbox-epsg-3857}&layertype=");
        sb.append(hVar.a);
        return sb.toString();
    }

    static Observable<ResponseBody> getFeatureCollection(MapView mapView, MapplsMap mapplsMap, h hVar, MapplsGeoAnalyticsRequest mapplsGeoAnalyticsRequest, LatLng latLng) {
        return MapplsFeatureInfo.builder().a(hVar.a).b(mapplsGeoAnalyticsRequest.attribute()).a(mapplsGeoAnalyticsRequest.geoBoundList()).d(mapplsGeoAnalyticsRequest.geoboundType()).e(hVar.a).a(mapplsMap.getProjection().toScreenLocation(latLng)).f(mapplsGeoAnalyticsRequest.propertyNames()).a(Integer.valueOf(mapView.getHeight())).b(Integer.valueOf(mapView.getWidth())).a(mapplsMap.getProjection().getVisibleRegion().latLngBounds).g(mapplsGeoAnalyticsRequest.query()).a().initializeObservable();
    }
}
