package com.mappls.sdk.maps.rctmgl.components;

import android.content.Context;
import com.facebook.react.views.view.ReactViewGroup;
import com.mappls.sdk.maps.rctmgl.components.mapview.RCTMGLMapView;

/* JADX INFO: loaded from: classes4.dex */
public abstract class AbstractMapFeature extends ReactViewGroup {
    public abstract void addToMap(RCTMGLMapView rCTMGLMapView);

    public abstract void removeFromMap(RCTMGLMapView rCTMGLMapView);

    public AbstractMapFeature(Context context) {
        super(context);
    }
}
