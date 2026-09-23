package com.mappls.sdk.maps;

import android.text.TextUtils;
import com.mappls.sdk.maps.annotations.InfoWindow;
import com.mappls.sdk.maps.annotations.Marker;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
class InfoWindowManager {
    private boolean allowConcurrentMultipleInfoWindows;
    private MapplsMap.InfoWindowAdapter infoWindowAdapter;
    private final List<InfoWindow> infoWindows = new ArrayList();
    private MapplsMap.OnInfoWindowClickListener onInfoWindowClickListener;
    private MapplsMap.OnInfoWindowCloseListener onInfoWindowCloseListener;
    private MapplsMap.OnInfoWindowLongClickListener onInfoWindowLongClickListener;

    InfoWindowManager() {
    }

    void update() {
        if (this.infoWindows.isEmpty()) {
            return;
        }
        Iterator<InfoWindow> it2 = this.infoWindows.iterator();
        while (it2.hasNext()) {
            it2.next().update();
        }
    }

    void setInfoWindowAdapter(MapplsMap.InfoWindowAdapter infoWindowAdapter) {
        this.infoWindowAdapter = infoWindowAdapter;
    }

    MapplsMap.InfoWindowAdapter getInfoWindowAdapter() {
        return this.infoWindowAdapter;
    }

    void setAllowConcurrentMultipleOpenInfoWindows(boolean z) {
        this.allowConcurrentMultipleInfoWindows = z;
    }

    boolean isAllowConcurrentMultipleOpenInfoWindows() {
        return this.allowConcurrentMultipleInfoWindows;
    }

    boolean isInfoWindowValidForMarker(Marker marker) {
        return (marker == null || (TextUtils.isEmpty(marker.getTitle()) && TextUtils.isEmpty(marker.getSnippet()))) ? false : true;
    }

    void setOnInfoWindowClickListener(MapplsMap.OnInfoWindowClickListener onInfoWindowClickListener) {
        this.onInfoWindowClickListener = onInfoWindowClickListener;
    }

    MapplsMap.OnInfoWindowClickListener getOnInfoWindowClickListener() {
        return this.onInfoWindowClickListener;
    }

    void setOnInfoWindowLongClickListener(MapplsMap.OnInfoWindowLongClickListener onInfoWindowLongClickListener) {
        this.onInfoWindowLongClickListener = onInfoWindowLongClickListener;
    }

    MapplsMap.OnInfoWindowLongClickListener getOnInfoWindowLongClickListener() {
        return this.onInfoWindowLongClickListener;
    }

    void setOnInfoWindowCloseListener(MapplsMap.OnInfoWindowCloseListener onInfoWindowCloseListener) {
        this.onInfoWindowCloseListener = onInfoWindowCloseListener;
    }

    MapplsMap.OnInfoWindowCloseListener getOnInfoWindowCloseListener() {
        return this.onInfoWindowCloseListener;
    }

    public void add(InfoWindow infoWindow) {
        this.infoWindows.add(infoWindow);
    }
}
