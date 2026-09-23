package com.bajajconnect.navigate.utils;

import com.mappls.sdk.maps.location.CompassEngine;
import com.mappls.sdk.maps.location.CompassListener;

/* JADX INFO: loaded from: classes3.dex */
public class NavigationCompassEngine implements CompassEngine {
    @Override // com.mappls.sdk.maps.location.CompassEngine
    public void addCompassListener(CompassListener compassListener) {
    }

    @Override // com.mappls.sdk.maps.location.CompassEngine
    public int getLastAccuracySensorStatus() {
        return 0;
    }

    @Override // com.mappls.sdk.maps.location.CompassEngine
    public float getLastHeading() {
        return 0.0f;
    }

    @Override // com.mappls.sdk.maps.location.CompassEngine
    public void removeCompassListener(CompassListener compassListener) {
    }
}
