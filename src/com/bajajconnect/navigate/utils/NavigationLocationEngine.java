package com.bajajconnect.navigate.utils;

import android.app.PendingIntent;
import android.location.Location;
import android.os.Looper;
import com.mappls.sdk.maps.location.engine.LocationEngine;
import com.mappls.sdk.maps.location.engine.LocationEngineCallback;
import com.mappls.sdk.maps.location.engine.LocationEngineRequest;
import com.mappls.sdk.maps.location.engine.LocationEngineResult;

/* JADX INFO: loaded from: classes3.dex */
public class NavigationLocationEngine implements LocationEngine {
    private LocationEngineCallback<LocationEngineResult> callback;
    private Location location = null;

    @Override // com.mappls.sdk.maps.location.engine.LocationEngine
    public void removeLocationUpdates(PendingIntent pendingIntent) {
    }

    @Override // com.mappls.sdk.maps.location.engine.LocationEngine
    public void removeLocationUpdates(LocationEngineCallback<LocationEngineResult> locationEngineCallback) {
    }

    @Override // com.mappls.sdk.maps.location.engine.LocationEngine
    public void requestLocationUpdates(LocationEngineRequest locationEngineRequest, PendingIntent pendingIntent) throws SecurityException {
    }

    public void updateLocation(Location location) {
        if (location == null) {
            return;
        }
        this.location = location;
        LocationEngineCallback<LocationEngineResult> locationEngineCallback = this.callback;
        if (locationEngineCallback != null) {
            locationEngineCallback.onSuccess(LocationEngineResult.create(location));
        }
    }

    @Override // com.mappls.sdk.maps.location.engine.LocationEngine
    public void getLastLocation(LocationEngineCallback<LocationEngineResult> locationEngineCallback) throws SecurityException {
        if (locationEngineCallback != null) {
            locationEngineCallback.onSuccess(LocationEngineResult.create(this.location));
        }
    }

    @Override // com.mappls.sdk.maps.location.engine.LocationEngine
    public void requestLocationUpdates(LocationEngineRequest locationEngineRequest, LocationEngineCallback<LocationEngineResult> locationEngineCallback, Looper looper) throws SecurityException {
        this.callback = locationEngineCallback;
    }
}
