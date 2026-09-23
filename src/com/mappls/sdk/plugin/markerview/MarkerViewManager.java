package com.mappls.sdk.plugin.markerview;

import com.mappls.sdk.maps.MapView;
import com.mappls.sdk.maps.MapplsMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class MarkerViewManager implements MapView.OnCameraDidChangeListener, MapView.OnCameraIsChangingListener {
    private boolean initialised;
    private final MapView mapView;
    private final MapplsMap mapplsMap;
    private final List<MarkerView> markers = new ArrayList();

    public MarkerViewManager(MapView mapView, MapplsMap mapplsMap) {
        this.mapView = mapView;
        this.mapplsMap = mapplsMap;
    }

    public void onDestroy() {
        this.markers.clear();
        this.mapView.removeOnCameraDidChangeListener(this);
        this.mapView.removeOnCameraIsChangingListener(this);
        this.initialised = false;
    }

    public void addMarker(MarkerView markerView) {
        if (this.mapView.isDestroyed() || this.markers.contains(markerView)) {
            return;
        }
        if (!this.initialised) {
            this.initialised = true;
            this.mapView.addOnCameraDidChangeListener(this);
            this.mapView.addOnCameraIsChangingListener(this);
        }
        markerView.setProjection(this.mapplsMap.getProjection());
        this.mapView.addView(markerView.getView());
        this.markers.add(markerView);
        markerView.update();
    }

    public void removeMarker(MarkerView markerView) {
        if (this.mapView.isDestroyed() || !this.markers.contains(markerView)) {
            return;
        }
        this.mapView.removeView(markerView.getView());
        this.markers.remove(markerView);
    }

    private void update() {
        Iterator<MarkerView> it2 = this.markers.iterator();
        while (it2.hasNext()) {
            it2.next().update();
        }
    }

    @Override // com.mappls.sdk.maps.MapView.OnCameraDidChangeListener
    public void onCameraDidChange(boolean z) {
        update();
    }

    @Override // com.mappls.sdk.maps.MapView.OnCameraIsChangingListener
    public void onCameraIsChanging() {
        update();
    }
}
