package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;

/* JADX INFO: loaded from: classes3.dex */
public interface MGLMapViewManagerInterface<T extends View> {
    void setAnchorRotateOrZoomGesturesToCenter(T t, boolean z);

    void setAttributionEnabled(T t, boolean z);

    void setAttributionPosition(T t, ReadableMap readableMap);

    void setCompassEnabled(T t, boolean z);

    void setCompassViewMargins(T t, ReadableMap readableMap);

    void setCompassViewPosition(T t, int i);

    void setContentInset(T t, ReadableArray readableArray);

    void setEnableGeoAnalyticsInfoWindow(T t, boolean z);

    void setEnableTraffic(T t, boolean z);

    void setEnableTrafficClosure(T t, boolean z);

    void setEnableTrafficFreeFlow(T t, boolean z);

    void setEnableTrafficNonFreeFlow(T t, boolean z);

    void setEnableTrafficStopIcon(T t, boolean z);

    void setEventPosition(T t, ReadableMap readableMap);

    void setFloor(T t, int i);

    void setLayerControlEnabled(T t, boolean z);

    void setLayerControlPosition(T t, ReadableMap readableMap);

    void setLocalizeLabels(T t, boolean z);

    void setLogoClickEnabled(T t, boolean z);

    void setLogoEnabled(T t, boolean z);

    void setLogoPosition(T t, ReadableMap readableMap);

    void setMapplsStyle(T t, String str);

    void setPitchEnabled(T t, boolean z);

    void setPreferredFramesPerSecond(T t, int i);

    void setRotateEnabled(T t, boolean z);

    void setScrollEnabled(T t, boolean z);

    void setStyleURL(T t, String str);

    void setZoomEnabled(T t, boolean z);
}
