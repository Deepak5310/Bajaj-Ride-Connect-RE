package com.agontuk.RNFusedLocation;

import android.app.Activity;
import android.content.Intent;
import android.location.Location;
import android.util.Log;
import com.facebook.react.bridge.ActivityEventListener;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public class RNFusedLocationModule extends ReactContextBaseJavaModule implements ActivityEventListener, LocationChangeListener {
    public static final String TAG = "RNFusedLocation";
    private LocationProvider continuousLocationProvider;
    private final HashMap<LocationProvider, PendingLocationRequest> pendingRequests;

    @ReactMethod
    public void addListener(String str) {
    }

    @Override // com.facebook.react.bridge.ActivityEventListener
    public void onNewIntent(Intent intent) {
    }

    @ReactMethod
    public void removeListeners(Integer num) {
    }

    public RNFusedLocationModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        reactApplicationContext.addActivityEventListener(this);
        this.pendingRequests = new HashMap<>();
        Log.i(TAG, "RNFusedLocation initialized");
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return TAG;
    }

    @Override // com.facebook.react.bridge.ActivityEventListener
    public void onActivityResult(Activity activity, int i, int i2, Intent intent) {
        LocationProvider locationProvider = this.continuousLocationProvider;
        if (locationProvider == null || !locationProvider.onActivityResult(i, i2)) {
            Iterator<LocationProvider> it2 = this.pendingRequests.keySet().iterator();
            while (it2.hasNext() && !it2.next().onActivityResult(i, i2)) {
            }
        }
    }

    @Override // com.agontuk.RNFusedLocation.LocationChangeListener
    public void onLocationChange(LocationProvider locationProvider, Location location) {
        WritableMap writableMapLocationToMap = LocationUtils.locationToMap(location);
        if (locationProvider.equals(this.continuousLocationProvider)) {
            emitEvent("geolocationDidChange", writableMapLocationToMap);
            return;
        }
        PendingLocationRequest pendingLocationRequest = this.pendingRequests.get(locationProvider);
        if (pendingLocationRequest != null) {
            pendingLocationRequest.successCallback.invoke(writableMapLocationToMap);
            this.pendingRequests.remove(locationProvider);
        }
    }

    @Override // com.agontuk.RNFusedLocation.LocationChangeListener
    public void onLocationError(LocationProvider locationProvider, LocationError locationError, String str) {
        WritableMap writableMapBuildError = LocationUtils.buildError(locationError, str);
        if (locationProvider.equals(this.continuousLocationProvider)) {
            emitEvent("geolocationError", writableMapBuildError);
            return;
        }
        PendingLocationRequest pendingLocationRequest = this.pendingRequests.get(locationProvider);
        if (pendingLocationRequest != null) {
            pendingLocationRequest.errorCallback.invoke(writableMapBuildError);
            this.pendingRequests.remove(locationProvider);
        }
    }

    @ReactMethod
    public void getCurrentPosition(ReadableMap readableMap, Callback callback, Callback callback2) {
        if (!LocationUtils.hasLocationPermission(getContext())) {
            callback2.invoke(LocationUtils.buildError(LocationError.PERMISSION_DENIED, null));
            return;
        }
        LocationOptions locationOptionsFromReadableMap = LocationOptions.fromReadableMap(readableMap);
        LocationProvider locationProviderCreateLocationProvider = createLocationProvider(locationOptionsFromReadableMap.isForceLocationManager());
        this.pendingRequests.put(locationProviderCreateLocationProvider, new PendingLocationRequest(callback, callback2));
        locationProviderCreateLocationProvider.getCurrentLocation(locationOptionsFromReadableMap);
    }

    @ReactMethod
    public void startObserving(ReadableMap readableMap) {
        if (!LocationUtils.hasLocationPermission(getContext())) {
            emitEvent("geolocationError", LocationUtils.buildError(LocationError.PERMISSION_DENIED, null));
            return;
        }
        LocationOptions locationOptionsFromReadableMap = LocationOptions.fromReadableMap(readableMap);
        if (this.continuousLocationProvider == null) {
            this.continuousLocationProvider = createLocationProvider(locationOptionsFromReadableMap.isForceLocationManager());
        }
        this.continuousLocationProvider.requestLocationUpdates(locationOptionsFromReadableMap);
    }

    @ReactMethod
    public void stopObserving() {
        LocationProvider locationProvider = this.continuousLocationProvider;
        if (locationProvider != null) {
            locationProvider.removeLocationUpdates();
            this.continuousLocationProvider = null;
        }
    }

    private LocationProvider createLocationProvider(boolean z) {
        ReactApplicationContext context = getContext();
        boolean zIsGooglePlayServicesAvailable = LocationUtils.isGooglePlayServicesAvailable(context);
        if (z || !zIsGooglePlayServicesAvailable) {
            return new LocationManagerProvider(context, this);
        }
        return new FusedLocationProvider(context, this);
    }

    private void emitEvent(String str, WritableMap writableMap) {
        ((DeviceEventManagerModule.RCTDeviceEventEmitter) getContext().getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit(str, writableMap);
    }

    private ReactApplicationContext getContext() {
        return getReactApplicationContext();
    }

    private static class PendingLocationRequest {
        final Callback errorCallback;
        final Callback successCallback;

        public PendingLocationRequest(Callback callback, Callback callback2) {
            this.successCallback = callback;
            this.errorCallback = callback2;
        }
    }
}
