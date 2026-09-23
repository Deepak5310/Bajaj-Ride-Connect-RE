package com.mappls.sdk.maps.location;

/* JADX INFO: loaded from: classes4.dex */
public interface CompassEngine {
    void addCompassListener(CompassListener compassListener);

    int getLastAccuracySensorStatus();

    float getLastHeading();

    void removeCompassListener(CompassListener compassListener);
}
