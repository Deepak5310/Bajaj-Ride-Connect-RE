package com.mappls.sdk.maps.location.engine;

import android.app.PendingIntent;
import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Iterator;

/* JADX INFO: loaded from: classes4.dex */
class AndroidLocationEngineImpl implements LocationEngineImpl<LocationListener> {
    private static final String TAG = "AndroidLocationEngine";
    String currentProvider = "passive";
    final LocationManager locationManager;

    private static int priorityToAccuracy(int i) {
        return (i == 0 || i == 1 || i == 4) ? 1 : 2;
    }

    private static int priorityToPowerRequirement(int i) {
        if (i == 0) {
            return 3;
        }
        if (i != 1) {
            return i != 4 ? 1 : 3;
        }
        return 2;
    }

    @Override // com.mappls.sdk.maps.location.engine.LocationEngineImpl
    public /* bridge */ /* synthetic */ LocationListener createListener(LocationEngineCallback locationEngineCallback) {
        return createListener((LocationEngineCallback<LocationEngineResult>) locationEngineCallback);
    }

    AndroidLocationEngineImpl(Context context) {
        this.locationManager = (LocationManager) context.getSystemService(FirebaseAnalytics.Param.LOCATION);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.mappls.sdk.maps.location.engine.LocationEngineImpl
    public LocationListener createListener(LocationEngineCallback<LocationEngineResult> locationEngineCallback) {
        return new AndroidLocationEngineCallbackTransport(locationEngineCallback);
    }

    @Override // com.mappls.sdk.maps.location.engine.LocationEngineImpl
    public void getLastLocation(LocationEngineCallback<LocationEngineResult> locationEngineCallback) throws SecurityException {
        Location lastLocationFor = getLastLocationFor(this.currentProvider);
        if (lastLocationFor != null) {
            locationEngineCallback.onSuccess(LocationEngineResult.create(lastLocationFor));
            return;
        }
        Iterator<String> it2 = this.locationManager.getAllProviders().iterator();
        while (it2.hasNext()) {
            Location lastLocationFor2 = getLastLocationFor(it2.next());
            if (lastLocationFor2 != null) {
                locationEngineCallback.onSuccess(LocationEngineResult.create(lastLocationFor2));
                return;
            }
        }
        locationEngineCallback.onFailure(new Exception("Last location unavailable"));
    }

    Location getLastLocationFor(String str) throws SecurityException {
        try {
            return this.locationManager.getLastKnownLocation(str);
        } catch (IllegalArgumentException e) {
            Log.e(TAG, e.toString());
            return null;
        }
    }

    @Override // com.mappls.sdk.maps.location.engine.LocationEngineImpl
    public void requestLocationUpdates(LocationEngineRequest locationEngineRequest, LocationListener locationListener, Looper looper) throws SecurityException {
        String bestProvider = getBestProvider(locationEngineRequest.getPriority());
        this.currentProvider = bestProvider;
        this.locationManager.requestLocationUpdates(bestProvider, locationEngineRequest.getInterval(), locationEngineRequest.getDisplacement(), locationListener, looper);
    }

    @Override // com.mappls.sdk.maps.location.engine.LocationEngineImpl
    public void requestLocationUpdates(LocationEngineRequest locationEngineRequest, PendingIntent pendingIntent) throws SecurityException {
        String bestProvider = getBestProvider(locationEngineRequest.getPriority());
        this.currentProvider = bestProvider;
        this.locationManager.requestLocationUpdates(bestProvider, locationEngineRequest.getInterval(), locationEngineRequest.getDisplacement(), pendingIntent);
    }

    @Override // com.mappls.sdk.maps.location.engine.LocationEngineImpl
    public void removeLocationUpdates(LocationListener locationListener) {
        if (locationListener != null) {
            this.locationManager.removeUpdates(locationListener);
        }
    }

    @Override // com.mappls.sdk.maps.location.engine.LocationEngineImpl
    public void removeLocationUpdates(PendingIntent pendingIntent) {
        if (pendingIntent != null) {
            this.locationManager.removeUpdates(pendingIntent);
        }
    }

    private String getBestProvider(int i) {
        if (i == 4) {
            return "gps";
        }
        String bestProvider = i != 3 ? this.locationManager.getBestProvider(getCriteria(i), true) : null;
        return bestProvider != null ? bestProvider : "passive";
    }

    static Criteria getCriteria(int i) {
        Criteria criteria = new Criteria();
        criteria.setAccuracy(priorityToAccuracy(i));
        criteria.setCostAllowed(true);
        criteria.setPowerRequirement(priorityToPowerRequirement(i));
        return criteria;
    }

    static final class AndroidLocationEngineCallbackTransport implements LocationListener {
        private final LocationEngineCallback<LocationEngineResult> callback;

        @Override // android.location.LocationListener
        public void onProviderEnabled(String str) {
        }

        @Override // android.location.LocationListener
        public void onStatusChanged(String str, int i, Bundle bundle) {
        }

        AndroidLocationEngineCallbackTransport(LocationEngineCallback<LocationEngineResult> locationEngineCallback) {
            this.callback = locationEngineCallback;
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(Location location) {
            this.callback.onSuccess(LocationEngineResult.create(location));
        }

        @Override // android.location.LocationListener
        public void onProviderDisabled(String str) {
            this.callback.onFailure(new Exception("Current provider disabled"));
        }
    }
}
