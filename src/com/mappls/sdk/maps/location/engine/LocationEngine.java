package com.mappls.sdk.maps.location.engine;

import android.app.PendingIntent;
import android.os.Looper;

/* JADX INFO: loaded from: classes4.dex */
public interface LocationEngine {
    void getLastLocation(LocationEngineCallback<LocationEngineResult> locationEngineCallback) throws SecurityException;

    void removeLocationUpdates(PendingIntent pendingIntent);

    void removeLocationUpdates(LocationEngineCallback<LocationEngineResult> locationEngineCallback);

    void requestLocationUpdates(LocationEngineRequest locationEngineRequest, PendingIntent pendingIntent) throws SecurityException;

    void requestLocationUpdates(LocationEngineRequest locationEngineRequest, LocationEngineCallback<LocationEngineResult> locationEngineCallback, Looper looper) throws SecurityException;
}
