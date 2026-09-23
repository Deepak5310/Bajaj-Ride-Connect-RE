package com.mappls.sdk.maps.location.engine;

import android.content.Context;
import com.google.android.gms.common.GoogleApiAvailability;

/* JADX INFO: loaded from: classes4.dex */
public final class LocationEngineProvider {
    private static final String GOOGLE_API_AVAILABILITY = "com.google.android.gms.common.GoogleApiAvailability";
    private static final String GOOGLE_LOCATION_SERVICES = "com.google.android.gms.location.LocationServices";

    private LocationEngineProvider() {
    }

    @Deprecated
    public static LocationEngine getBestLocationEngine(Context context, boolean z) {
        return getBestLocationEngine(context);
    }

    public static LocationEngine getBestLocationEngine(Context context) {
        Utils.checkNotNull(context, "context == null");
        boolean zIsOnClasspath = Utils.isOnClasspath(GOOGLE_LOCATION_SERVICES);
        if (Utils.isOnClasspath(GOOGLE_API_AVAILABILITY)) {
            zIsOnClasspath &= GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(context) == 0;
        }
        return getLocationEngine(context, zIsOnClasspath);
    }

    public static LocationEngine getLocationEngine(Context context, boolean z) {
        if (GoogleLocationEngineManager.getInstance().getLocationEngine() == null) {
            if (z) {
                return new LocationEngineProxy(new GoogleLocationEngineImpl(context.getApplicationContext()));
            }
            return new LocationEngineProxy(new MapplsFusedLocationEngineImpl(context.getApplicationContext()));
        }
        if (z) {
            return new LocationEngineProxy(GoogleLocationEngineManager.getInstance().getLocationEngine());
        }
        return new LocationEngineProxy(new MapplsFusedLocationEngineImpl(context.getApplicationContext()));
    }
}
