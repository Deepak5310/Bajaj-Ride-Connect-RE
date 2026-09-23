package com.mappls.sdk.maps.rctmgl.components.annotation;

import com.mappls.sdk.maps.MapView;
import com.mappls.sdk.maps.MapplsMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class MarkerViewManager extends com.mappls.sdk.plugin.markerview.MarkerViewManager {
    private MapView mapView;
    private final List<MarkerView> markers;

    public MarkerViewManager(MapView mapView, MapplsMap mapplsMap) {
        super(mapView, mapplsMap);
        this.markers = new ArrayList();
        this.mapView = mapView;
    }

    public void addMarker(MarkerView markerView) {
        super.addMarker((com.mappls.sdk.plugin.markerview.MarkerView) markerView);
        this.markers.add(markerView);
    }

    public void removeMarker(MarkerView markerView) {
        super.removeMarker((com.mappls.sdk.plugin.markerview.MarkerView) markerView);
        this.markers.remove(markerView);
    }

    public void removeViews() {
        Iterator<MarkerView> it2 = this.markers.iterator();
        while (it2.hasNext()) {
            this.mapView.removeView(it2.next().getView());
        }
    }

    public void restoreViews() {
        Iterator<MarkerView> it2 = this.markers.iterator();
        while (it2.hasNext()) {
            this.mapView.addView(it2.next().getView());
        }
    }
}
