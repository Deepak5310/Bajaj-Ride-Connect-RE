package com.mappls.sdk.maps.rctmgl.location;

import android.content.Context;
import android.location.Location;
import android.os.Looper;
import android.util.Log;
import com.mappls.sdk.maps.location.engine.LocationEngine;
import com.mappls.sdk.maps.location.engine.LocationEngineCallback;
import com.mappls.sdk.maps.location.engine.LocationEngineProvider;
import com.mappls.sdk.maps.location.engine.LocationEngineRequest;
import com.mappls.sdk.maps.location.engine.LocationEngineResult;
import com.mappls.sdk.maps.location.permissions.PermissionsManager;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class LocationManager implements LocationEngineCallback<LocationEngineResult> {
    static final long DEFAULT_FASTEST_INTERVAL_MILLIS = 1000;
    static final long DEFAULT_INTERVAL_MILLIS = 1000;
    private static WeakReference<LocationManager> INSTANCE = null;
    public static final String LOG_TAG = "LocationManager";
    private Context context;
    private LocationEngine locationEngine;
    private List<OnUserLocationChange> listeners = new ArrayList();
    private float mMinDisplacement = 0.0f;
    private boolean isActive = false;
    private Location lastLocation = null;
    private LocationEngineRequest locationEngineRequest = null;

    public interface OnUserLocationChange {
        void onLocationChange(Location location);
    }

    @Override // com.mappls.sdk.maps.location.engine.LocationEngineCallback
    public void onFailure(Exception exc) {
    }

    public static LocationManager getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = new WeakReference<>(new LocationManager(context));
        }
        return INSTANCE.get();
    }

    private LocationManager(Context context) {
        this.context = context;
        buildEngineRequest();
    }

    private void buildEngineRequest() {
        this.locationEngine = LocationEngineProvider.getBestLocationEngine(this.context.getApplicationContext());
        this.locationEngineRequest = new LocationEngineRequest.Builder(1000L).setFastestInterval(1000L).setPriority(0).setDisplacement(this.mMinDisplacement).build();
    }

    public void addLocationListener(OnUserLocationChange onUserLocationChange) {
        if (this.listeners.contains(onUserLocationChange)) {
            return;
        }
        this.listeners.add(onUserLocationChange);
    }

    public void removeLocationListener(OnUserLocationChange onUserLocationChange) {
        if (this.listeners.contains(onUserLocationChange)) {
            this.listeners.remove(onUserLocationChange);
        }
    }

    public void setMinDisplacement(float f) {
        this.mMinDisplacement = f;
    }

    public void enable() {
        if (PermissionsManager.areLocationPermissionsGranted(this.context)) {
            this.locationEngine.removeLocationUpdates(this);
            buildEngineRequest();
            this.locationEngine.requestLocationUpdates(this.locationEngineRequest, this, Looper.getMainLooper());
            this.isActive = true;
        }
    }

    public void disable() {
        this.locationEngine.removeLocationUpdates(this);
        this.isActive = false;
    }

    public void dispose() {
        if (this.locationEngine == null) {
            return;
        }
        disable();
        this.locationEngine.removeLocationUpdates(this);
    }

    public boolean isActive() {
        return this.locationEngine != null && this.isActive;
    }

    public Location getLastKnownLocation() {
        if (this.locationEngine == null) {
            return null;
        }
        return this.lastLocation;
    }

    public void getLastKnownLocation(LocationEngineCallback<LocationEngineResult> locationEngineCallback) {
        if (this.locationEngine == null) {
            locationEngineCallback.onFailure(new Exception("LocationEngine not initialized"));
        }
        try {
            this.locationEngine.getLastLocation(locationEngineCallback);
        } catch (Exception e) {
            Log.w(LOG_TAG, e);
            locationEngineCallback.onFailure(e);
        }
    }

    public LocationEngine getEngine() {
        return this.locationEngine;
    }

    public void onLocationChanged(Location location) {
        this.lastLocation = location;
        Iterator<OnUserLocationChange> it2 = this.listeners.iterator();
        while (it2.hasNext()) {
            it2.next().onLocationChange(location);
        }
    }

    @Override // com.mappls.sdk.maps.location.engine.LocationEngineCallback
    public void onSuccess(LocationEngineResult locationEngineResult) {
        onLocationChanged(locationEngineResult.getLastLocation());
    }
}
