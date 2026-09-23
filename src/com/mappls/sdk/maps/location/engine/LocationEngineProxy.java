package com.mappls.sdk.maps.location.engine;

import android.app.PendingIntent;
import android.os.Looper;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes4.dex */
class LocationEngineProxy<T> implements LocationEngine {
    private Map<LocationEngineCallback<LocationEngineResult>, T> listeners;
    private final LocationEngineImpl<T> locationEngineImpl;

    LocationEngineProxy(LocationEngineImpl<T> locationEngineImpl) {
        this.locationEngineImpl = locationEngineImpl;
    }

    @Override // com.mappls.sdk.maps.location.engine.LocationEngine
    public void getLastLocation(LocationEngineCallback<LocationEngineResult> locationEngineCallback) throws SecurityException {
        Utils.checkNotNull(locationEngineCallback, "callback == null");
        this.locationEngineImpl.getLastLocation(locationEngineCallback);
    }

    @Override // com.mappls.sdk.maps.location.engine.LocationEngine
    public void requestLocationUpdates(LocationEngineRequest locationEngineRequest, LocationEngineCallback<LocationEngineResult> locationEngineCallback, Looper looper) throws SecurityException {
        Utils.checkNotNull(locationEngineRequest, "request == null");
        Utils.checkNotNull(locationEngineCallback, "callback == null");
        LocationEngineImpl<T> locationEngineImpl = this.locationEngineImpl;
        T listener = getListener(locationEngineCallback);
        if (looper == null) {
            looper = Looper.getMainLooper();
        }
        locationEngineImpl.requestLocationUpdates(locationEngineRequest, listener, looper);
    }

    @Override // com.mappls.sdk.maps.location.engine.LocationEngine
    public void requestLocationUpdates(LocationEngineRequest locationEngineRequest, PendingIntent pendingIntent) throws SecurityException {
        Utils.checkNotNull(locationEngineRequest, "request == null");
        this.locationEngineImpl.requestLocationUpdates(locationEngineRequest, pendingIntent);
    }

    @Override // com.mappls.sdk.maps.location.engine.LocationEngine
    public void removeLocationUpdates(LocationEngineCallback<LocationEngineResult> locationEngineCallback) {
        Utils.checkNotNull(locationEngineCallback, "callback == null");
        this.locationEngineImpl.removeLocationUpdates(removeListener(locationEngineCallback));
    }

    @Override // com.mappls.sdk.maps.location.engine.LocationEngine
    public void removeLocationUpdates(PendingIntent pendingIntent) {
        this.locationEngineImpl.removeLocationUpdates(pendingIntent);
    }

    int getListenersCount() {
        Map<LocationEngineCallback<LocationEngineResult>, T> map = this.listeners;
        if (map != null) {
            return map.size();
        }
        return 0;
    }

    T getListener(LocationEngineCallback<LocationEngineResult> locationEngineCallback) {
        if (this.listeners == null) {
            this.listeners = new ConcurrentHashMap();
        }
        T tCreateListener = this.listeners.get(locationEngineCallback);
        if (tCreateListener == null) {
            tCreateListener = this.locationEngineImpl.createListener(locationEngineCallback);
        }
        this.listeners.put(locationEngineCallback, tCreateListener);
        return tCreateListener;
    }

    T removeListener(LocationEngineCallback<LocationEngineResult> locationEngineCallback) {
        Map<LocationEngineCallback<LocationEngineResult>, T> map = this.listeners;
        if (map != null) {
            return map.remove(locationEngineCallback);
        }
        return null;
    }
}
