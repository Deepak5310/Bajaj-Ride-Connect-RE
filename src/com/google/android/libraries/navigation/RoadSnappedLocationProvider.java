package com.google.android.libraries.navigation;

import android.location.Location;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public interface RoadSnappedLocationProvider {

    /* JADX INFO: compiled from: PG */
    public interface GpsAvailabilityEnhancedLocationListener extends LocationListener {
        void onGpsAvailabilityUpdate(boolean z);
    }

    /* JADX INFO: compiled from: PG */
    public interface LocationListener {
        public static final String IS_ROAD_SNAPPED_KEY = "is_road_snapped";

        void onLocationChanged(Location location);

        void onRawLocationUpdate(Location location);
    }

    void addLocationListener(LocationListener locationListener);

    void removeLocationListener(LocationListener locationListener);

    void resetFreeNav();
}
