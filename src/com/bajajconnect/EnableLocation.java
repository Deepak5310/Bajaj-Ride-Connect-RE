package com.bajajconnect;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentSender;
import android.location.LocationManager;
import com.facebook.react.bridge.ActivityEventListener;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResponse;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.analytics.FirebaseAnalytics;

/* JADX INFO: loaded from: classes3.dex */
public class EnableLocation extends ReactContextBaseJavaModule implements ActivityEventListener, OnCompleteListener<LocationSettingsResponse> {
    private static final int DEFAULT_FAST_INTERVAL_DURATION = 5000;
    private static final int DEFAULT_INTERVAL_DURATION = 10000;
    private static final String ERR_FAILED_OPEN_DIALOG_CODE = "ERR02";
    private static final String ERR_INTERNAL_ERROR = "ERR03";
    private static final String ERR_SETTINGS_CHANGE_UNAVAILABLE_CODE = "ERR01";
    private static final String ERR_USER_DENIED_CODE = "ERR00";
    private static final String LOCATION_FAST_INTERVAL_DURATION_PARAMS_KEY = "fastInterval";
    private static final String LOCATION_INTERVAL_DURATION_PARAMS_KEY = "interval";
    private static final int REQUEST_CHECK_SETTINGS = 42;
    private static final String SELF_MODULE_NAME = "RNAndroidLocationEnabler";
    private Promise promise;

    @Override // com.facebook.react.bridge.ActivityEventListener
    public void onNewIntent(Intent intent) {
    }

    public EnableLocation(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        reactApplicationContext.addActivityEventListener(this);
    }

    @ReactMethod
    public void promptForEnableLocationIfNeeded(ReadableMap readableMap, Promise promise) {
        if (getCurrentActivity() == null || readableMap == null || promise == null) {
            return;
        }
        this.promise = promise;
        LocationRequest locationRequestCreate = LocationRequest.create();
        locationRequestCreate.setPriority(100);
        locationRequestCreate.setInterval(readableMap.hasKey(LOCATION_INTERVAL_DURATION_PARAMS_KEY) ? readableMap.getInt(LOCATION_INTERVAL_DURATION_PARAMS_KEY) : 10000L);
        locationRequestCreate.setFastestInterval(readableMap.hasKey(LOCATION_FAST_INTERVAL_DURATION_PARAMS_KEY) ? readableMap.getInt(LOCATION_FAST_INTERVAL_DURATION_PARAMS_KEY) : 5000L);
        LocationSettingsRequest.Builder builderAddLocationRequest = new LocationSettingsRequest.Builder().addLocationRequest(locationRequestCreate);
        builderAddLocationRequest.setAlwaysShow(true);
        LocationServices.getSettingsClient(getCurrentActivity()).checkLocationSettings(builderAddLocationRequest.build()).addOnCompleteListener(this);
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return "EnableLocation";
    }

    private boolean isLocationProviderEnabled() {
        LocationManager locationManager;
        return (getCurrentActivity() == null || (locationManager = (LocationManager) getCurrentActivity().getSystemService(FirebaseAnalytics.Param.LOCATION)) == null || !locationManager.isProviderEnabled("gps")) ? false : true;
    }

    @Override // com.facebook.react.bridge.ActivityEventListener
    public void onActivityResult(Activity activity, int i, int i2, Intent intent) {
        if (i != 42 || this.promise == null) {
            return;
        }
        if (i2 == -1 || isLocationProviderEnabled()) {
            this.promise.resolve(ViewProps.ENABLED);
        } else {
            this.promise.reject(ERR_USER_DENIED_CODE, new RNAndroidLocationEnablerException("denied"));
        }
        this.promise = null;
    }

    @Override // com.google.android.gms.tasks.OnCompleteListener
    public void onComplete(Task<LocationSettingsResponse> task) throws Throwable {
        try {
            task.getResult(ApiException.class);
            Promise promise = this.promise;
            if (promise != null) {
                promise.resolve("already-enabled");
            }
            this.promise = null;
        } catch (ApiException e) {
            int statusCode = e.getStatusCode();
            if (statusCode != 6) {
                if (statusCode != 8502) {
                    return;
                }
                Promise promise2 = this.promise;
                if (promise2 != null) {
                    promise2.reject(ERR_SETTINGS_CHANGE_UNAVAILABLE_CODE, new RNAndroidLocationEnablerException("Settings change unavailable"));
                }
                this.promise = null;
                return;
            }
            try {
                ((ResolvableApiException) e).startResolutionForResult(getCurrentActivity(), 42);
            } catch (IntentSender.SendIntentException e2) {
                Promise promise3 = this.promise;
                if (promise3 != null) {
                    promise3.reject(ERR_FAILED_OPEN_DIALOG_CODE, new RNAndroidLocationEnablerException("Failed to show dialog", e2));
                }
                this.promise = null;
            } catch (ClassCastException e3) {
                Promise promise4 = this.promise;
                if (promise4 != null) {
                    promise4.reject(ERR_INTERNAL_ERROR, new RNAndroidLocationEnablerException("Internal error", e3));
                }
                this.promise = null;
            }
        }
    }
}
