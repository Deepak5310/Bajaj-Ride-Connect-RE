package com.mappls.sdk.maps.rctmgl.components.annotation;

import android.view.View;
import com.mappls.sdk.maps.geometry.LatLng;

/* JADX INFO: loaded from: classes4.dex */
public class MarkerView extends com.mappls.sdk.plugin.markerview.MarkerView {
    View view;

    public MarkerView(LatLng latLng, View view) {
        super(latLng, view);
        this.view = view;
    }

    public View getView() {
        return this.view;
    }
}
