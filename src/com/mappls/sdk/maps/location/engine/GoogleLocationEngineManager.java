package com.mappls.sdk.maps.location.engine;

import com.google.android.gms.location.LocationCallback;

/* JADX INFO: loaded from: classes4.dex */
public class GoogleLocationEngineManager {
    private static final GoogleLocationEngineManager OUR_INSTANCE = new GoogleLocationEngineManager();
    private LocationEngineImpl<LocationCallback> locationEngine;

    private GoogleLocationEngineManager() {
    }

    public static GoogleLocationEngineManager getInstance() {
        return OUR_INSTANCE;
    }

    LocationEngineImpl<LocationCallback> getLocationEngine() {
        return this.locationEngine;
    }

    public void setLocationEngine(LocationEngineImpl<LocationCallback> locationEngineImpl) {
        this.locationEngine = locationEngineImpl;
    }
}
