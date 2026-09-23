package com.agontuk.RNFusedLocation;

import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.facebook.react.bridge.ReactApplicationContext;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class LocationManagerProvider implements LocationProvider {
    private final LocationChangeListener locationChangeListener;
    private final LocationManager locationManager;
    private boolean isSingleUpdate = false;
    private final LocationListener locationListener = new LocationListener() { // from class: com.agontuk.RNFusedLocation.LocationManagerProvider.1
        @Override // android.location.LocationListener
        public void onProviderEnabled(String str) {
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(Location location) {
            LocationManagerProvider.this.locationChangeListener.onLocationChange(LocationManagerProvider.this, location);
            if (LocationManagerProvider.this.isSingleUpdate) {
                LocationManagerProvider.this.timeoutHandler.removeCallbacks(LocationManagerProvider.this.timeoutRunnable);
                LocationManagerProvider.this.removeLocationUpdates();
            }
        }

        @Override // android.location.LocationListener
        public void onStatusChanged(String str, int i, Bundle bundle) {
            if (i == 2) {
                onProviderEnabled(str);
            } else {
                onProviderDisabled(str);
            }
        }

        @Override // android.location.LocationListener
        public void onProviderDisabled(String str) {
            LocationManagerProvider.this.locationChangeListener.onLocationError(LocationManagerProvider.this, LocationError.POSITION_UNAVAILABLE, null);
        }
    };
    private final Handler timeoutHandler = new Handler(Looper.getMainLooper());
    private final Runnable timeoutRunnable = new Runnable() { // from class: com.agontuk.RNFusedLocation.LocationManagerProvider.2
        @Override // java.lang.Runnable
        public void run() {
            LocationManagerProvider.this.locationChangeListener.onLocationError(LocationManagerProvider.this, LocationError.TIMEOUT, null);
            LocationManagerProvider.this.removeLocationUpdates();
        }
    };

    @Override // com.agontuk.RNFusedLocation.LocationProvider
    public boolean onActivityResult(int i, int i2) {
        return false;
    }

    public LocationManagerProvider(ReactApplicationContext reactApplicationContext, LocationChangeListener locationChangeListener) {
        this.locationChangeListener = locationChangeListener;
        this.locationManager = (LocationManager) reactApplicationContext.getSystemService(FirebaseAnalytics.Param.LOCATION);
    }

    @Override // com.agontuk.RNFusedLocation.LocationProvider
    public void getCurrentLocation(LocationOptions locationOptions) {
        this.isSingleUpdate = true;
        String bestProvider = getBestProvider(locationOptions.getAccuracy());
        if (bestProvider == null) {
            this.locationChangeListener.onLocationError(this, LocationError.POSITION_UNAVAILABLE, null);
            return;
        }
        Location lastKnownLocation = this.locationManager.getLastKnownLocation(bestProvider);
        if (lastKnownLocation != null && LocationUtils.getLocationAge(lastKnownLocation) < locationOptions.getMaximumAge()) {
            Log.i(RNFusedLocationModule.TAG, "returning cached location.");
            this.locationChangeListener.onLocationChange(this, lastKnownLocation);
        } else {
            startLocationUpdates(bestProvider, locationOptions.getInterval(), 0.0f, locationOptions.getTimeout());
        }
    }

    @Override // com.agontuk.RNFusedLocation.LocationProvider
    public void requestLocationUpdates(LocationOptions locationOptions) {
        this.isSingleUpdate = false;
        String bestProvider = getBestProvider(locationOptions.getAccuracy());
        if (bestProvider == null) {
            this.locationChangeListener.onLocationError(this, LocationError.POSITION_UNAVAILABLE, null);
        } else {
            startLocationUpdates(bestProvider, locationOptions.getInterval(), locationOptions.getDistanceFilter(), locationOptions.getTimeout());
        }
    }

    @Override // com.agontuk.RNFusedLocation.LocationProvider
    public void removeLocationUpdates() {
        this.locationManager.removeUpdates(this.locationListener);
    }

    private String getBestProvider(LocationAccuracy locationAccuracy) {
        String bestProvider = this.locationManager.getBestProvider(getProviderCriteria(locationAccuracy), true);
        if (bestProvider != null) {
            return bestProvider;
        }
        List<String> providers = this.locationManager.getProviders(true);
        if (providers.size() > 0) {
            return providers.get(0);
        }
        return null;
    }

    /* JADX INFO: renamed from: com.agontuk.RNFusedLocation.LocationManagerProvider$3, reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$com$agontuk$RNFusedLocation$LocationAccuracy;

        static {
            int[] iArr = new int[LocationAccuracy.values().length];
            $SwitchMap$com$agontuk$RNFusedLocation$LocationAccuracy = iArr;
            try {
                iArr[LocationAccuracy.high.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$agontuk$RNFusedLocation$LocationAccuracy[LocationAccuracy.balanced.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$agontuk$RNFusedLocation$LocationAccuracy[LocationAccuracy.low.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$agontuk$RNFusedLocation$LocationAccuracy[LocationAccuracy.passive.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    private Criteria getProviderCriteria(LocationAccuracy locationAccuracy) {
        int i;
        int i2 = AnonymousClass3.$SwitchMap$com$agontuk$RNFusedLocation$LocationAccuracy[locationAccuracy.ordinal()];
        int i3 = 3;
        int i4 = 1;
        if (i2 != 1) {
            i = 2;
            if (i2 == 2) {
                i3 = 2;
            } else if (i2 == 3) {
                i3 = 1;
            } else {
                if (i2 != 4) {
                    throw new IllegalStateException("Unexpected value: " + locationAccuracy);
                }
                i3 = 0;
                i4 = 0;
                i = 0;
            }
            Criteria criteria = new Criteria();
            criteria.setAccuracy(i);
            criteria.setBearingAccuracy(i3);
            criteria.setHorizontalAccuracy(i3);
            criteria.setPowerRequirement(i4);
            criteria.setSpeedAccuracy(i3);
            criteria.setVerticalAccuracy(i3);
            return criteria;
        }
        i = 1;
        i4 = i3;
        Criteria criteria2 = new Criteria();
        criteria2.setAccuracy(i);
        criteria2.setBearingAccuracy(i3);
        criteria2.setHorizontalAccuracy(i3);
        criteria2.setPowerRequirement(i4);
        criteria2.setSpeedAccuracy(i3);
        criteria2.setVerticalAccuracy(i3);
        return criteria2;
    }

    private void startLocationUpdates(String str, long j, float f, long j2) {
        this.locationManager.requestLocationUpdates(str, j, f, this.locationListener, Looper.getMainLooper());
        if (!this.isSingleUpdate || j2 <= 0 || j2 == Long.MAX_VALUE) {
            return;
        }
        this.timeoutHandler.postDelayed(this.timeoutRunnable, j2);
    }
}
