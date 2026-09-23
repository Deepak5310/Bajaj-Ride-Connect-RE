package com.mappls.sdk.navigation.ui.utils;

import android.app.PendingIntent;
import android.location.Location;
import android.os.Looper;
import com.mappls.sdk.maps.location.engine.LocationEngine;
import com.mappls.sdk.maps.location.engine.LocationEngineCallback;
import com.mappls.sdk.maps.location.engine.LocationEngineRequest;
import com.mappls.sdk.maps.location.engine.LocationEngineResult;

/* JADX INFO: loaded from: classes4.dex */
public final class c implements LocationEngine {
    @Override // com.mappls.sdk.maps.location.engine.LocationEngine
    public final void getLastLocation(LocationEngineCallback locationEngineCallback) {
        if (locationEngineCallback != null) {
            locationEngineCallback.onSuccess(LocationEngineResult.create((Location) null));
        }
    }

    @Override // com.mappls.sdk.maps.location.engine.LocationEngine
    public final void removeLocationUpdates(PendingIntent pendingIntent) {
    }

    @Override // com.mappls.sdk.maps.location.engine.LocationEngine
    public final void removeLocationUpdates(LocationEngineCallback locationEngineCallback) {
    }

    @Override // com.mappls.sdk.maps.location.engine.LocationEngine
    public final void requestLocationUpdates(LocationEngineRequest locationEngineRequest, PendingIntent pendingIntent) {
    }

    @Override // com.mappls.sdk.maps.location.engine.LocationEngine
    public final void requestLocationUpdates(LocationEngineRequest locationEngineRequest, LocationEngineCallback locationEngineCallback, Looper looper) {
    }
}
