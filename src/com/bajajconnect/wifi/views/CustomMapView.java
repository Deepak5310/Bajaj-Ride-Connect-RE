package com.bajajconnect.wifi.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.mappls.sdk.maps.MapView;
import com.mappls.sdk.maps.MapplsMapOptions;

/* JADX INFO: loaded from: classes3.dex */
public class CustomMapView extends MapView {
    public CustomMapView(Context context) {
        super(context);
    }

    public CustomMapView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CustomMapView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public CustomMapView(Context context, MapplsMapOptions mapplsMapOptions) {
        super(context, mapplsMapOptions);
    }

    @Override // com.mappls.sdk.maps.MapView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptHoverEvent(MotionEvent motionEvent) {
        return super.onInterceptHoverEvent(motionEvent);
    }
}
