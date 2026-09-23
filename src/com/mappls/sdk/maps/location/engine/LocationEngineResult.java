package com.mappls.sdk.maps.location.engine;

import android.content.Intent;
import android.location.Location;
import com.google.android.gms.location.LocationResult;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class LocationEngineResult {
    private static final String GOOGLE_PLAY_LOCATION_RESULT = "com.google.android.gms.location.LocationResult";
    private final List<Location> locations;

    private LocationEngineResult(List<Location> list) {
        this.locations = Collections.unmodifiableList(list);
    }

    public static LocationEngineResult create(Location location) {
        ArrayList arrayList = new ArrayList();
        if (location != null) {
            arrayList.add(location);
        }
        return new LocationEngineResult(arrayList);
    }

    public static LocationEngineResult create(List<Location> list) {
        if (list != null) {
            ArrayList arrayList = new ArrayList(list);
            arrayList.removeAll(Collections.singleton(null));
            return new LocationEngineResult(arrayList);
        }
        return new LocationEngineResult(Collections.emptyList());
    }

    public Location getLastLocation() {
        if (this.locations.isEmpty()) {
            return null;
        }
        return this.locations.get(0);
    }

    public List<Location> getLocations() {
        return Collections.unmodifiableList(this.locations);
    }

    public static LocationEngineResult extractResult(Intent intent) {
        LocationEngineResult locationEngineResultExtractGooglePlayResult = Utils.isOnClasspath(GOOGLE_PLAY_LOCATION_RESULT) ? extractGooglePlayResult(intent) : null;
        return locationEngineResultExtractGooglePlayResult == null ? extractAndroidResult(intent) : locationEngineResultExtractGooglePlayResult;
    }

    private static LocationEngineResult extractGooglePlayResult(Intent intent) {
        LocationResult locationResultExtractResult = LocationResult.extractResult(intent);
        if (locationResultExtractResult != null) {
            return create(locationResultExtractResult.getLocations());
        }
        return null;
    }

    private static LocationEngineResult extractAndroidResult(Intent intent) {
        if (hasResult(intent)) {
            return create((Location) intent.getExtras().getParcelable(FirebaseAnalytics.Param.LOCATION));
        }
        return null;
    }

    private static boolean hasResult(Intent intent) {
        return intent != null && intent.hasExtra(FirebaseAnalytics.Param.LOCATION);
    }
}
