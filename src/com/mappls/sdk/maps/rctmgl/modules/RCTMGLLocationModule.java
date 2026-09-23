package com.mappls.sdk.maps.rctmgl.modules;

import android.location.Location;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.modules.core.RCTNativeAppEventEmitter;
import com.mappls.sdk.maps.location.engine.LocationEngineCallback;
import com.mappls.sdk.maps.location.engine.LocationEngineResult;
import com.mappls.sdk.maps.rctmgl.events.EventEmitter;
import com.mappls.sdk.maps.rctmgl.events.LocationEvent;
import com.mappls.sdk.maps.rctmgl.location.LocationManager;

/* JADX INFO: loaded from: classes4.dex */
@ReactModule(name = "RCTMGLLocationModule")
public class RCTMGLLocationModule extends ReactContextBaseJavaModule {
    public static final String LOCATION_UPDATE = "MapboxUserLocationUpdate";
    public static final String REACT_CLASS = "RCTMGLLocationModule";
    private boolean isEnabled;
    private boolean isPaused;
    private LifecycleEventListener lifecycleEventListener;
    private LocationManager locationManager;
    private float mMinDisplacement;
    private LocationManager.OnUserLocationChange onUserLocationChangeCallback;

    @ReactMethod
    public void addListener(String str) {
    }

    @ReactMethod
    public void removeListeners(Integer num) {
    }

    public RCTMGLLocationModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.lifecycleEventListener = new LifecycleEventListener() { // from class: com.mappls.sdk.maps.rctmgl.modules.RCTMGLLocationModule.1
            @Override // com.facebook.react.bridge.LifecycleEventListener
            public void onHostResume() {
                if (RCTMGLLocationModule.this.isEnabled) {
                    RCTMGLLocationModule.this.startLocationManager();
                }
            }

            @Override // com.facebook.react.bridge.LifecycleEventListener
            public void onHostPause() {
                RCTMGLLocationModule.this.pauseLocationManager();
            }

            @Override // com.facebook.react.bridge.LifecycleEventListener
            public void onHostDestroy() {
                RCTMGLLocationModule.this.stopLocationManager();
            }
        };
        this.onUserLocationChangeCallback = new LocationManager.OnUserLocationChange() { // from class: com.mappls.sdk.maps.rctmgl.modules.RCTMGLLocationModule.2
            @Override // com.mappls.sdk.maps.rctmgl.location.LocationManager.OnUserLocationChange
            public void onLocationChange(Location location) {
                LocationEvent locationEvent = new LocationEvent(location);
                RCTNativeAppEventEmitter moduleEmitter = EventEmitter.getModuleEmitter(RCTMGLLocationModule.this.getReactApplicationContext());
                if (moduleEmitter != null) {
                    moduleEmitter.emit(RCTMGLLocationModule.LOCATION_UPDATE, locationEvent.getPayload());
                }
            }
        };
        this.locationManager = LocationManager.getInstance(reactApplicationContext);
        reactApplicationContext.addLifecycleEventListener(this.lifecycleEventListener);
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return "RCTMGLLocationModule";
    }

    @ReactMethod
    public void start(float f) {
        this.isEnabled = true;
        this.mMinDisplacement = f;
        startLocationManager();
    }

    @ReactMethod
    public void setMinDisplacement(float f) {
        if (this.mMinDisplacement == f) {
            return;
        }
        this.mMinDisplacement = f;
        if (this.isEnabled) {
            this.locationManager.setMinDisplacement(f);
            this.locationManager.enable();
        }
    }

    @ReactMethod
    public void stop() {
        stopLocationManager();
    }

    @ReactMethod
    public void pause() {
        pauseLocationManager();
    }

    @ReactMethod
    public void getLastKnownLocation(final Promise promise) {
        this.locationManager.getLastKnownLocation(new LocationEngineCallback<LocationEngineResult>() { // from class: com.mappls.sdk.maps.rctmgl.modules.RCTMGLLocationModule.3
            @Override // com.mappls.sdk.maps.location.engine.LocationEngineCallback
            public void onSuccess(LocationEngineResult locationEngineResult) {
                Location lastLocation = locationEngineResult.getLastLocation();
                if (locationEngineResult.getLastLocation() != null) {
                    promise.resolve(new LocationEvent(lastLocation).getPayload());
                } else {
                    promise.resolve(null);
                }
            }

            @Override // com.mappls.sdk.maps.location.engine.LocationEngineCallback
            public void onFailure(Exception exc) {
                promise.reject(exc);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startLocationManager() {
        this.locationManager.addLocationListener(this.onUserLocationChangeCallback);
        this.locationManager.setMinDisplacement(this.mMinDisplacement);
        this.locationManager.enable();
        this.isPaused = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pauseLocationManager() {
        if (this.isPaused) {
            return;
        }
        this.locationManager.disable();
        this.isPaused = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopLocationManager() {
        if (this.isEnabled) {
            this.locationManager.removeLocationListener(this.onUserLocationChangeCallback);
            this.locationManager.dispose();
            this.isEnabled = false;
            this.isPaused = false;
        }
    }
}
