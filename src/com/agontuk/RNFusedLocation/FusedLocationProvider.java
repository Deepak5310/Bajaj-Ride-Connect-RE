package com.agontuk.RNFusedLocation;

import android.app.Activity;
import android.content.IntentSender;
import android.location.Location;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.facebook.react.bridge.ReactApplicationContext;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResponse;
import com.google.android.gms.location.SettingsClient;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import java.util.Random;

/* JADX INFO: loaded from: classes3.dex */
public class FusedLocationProvider implements LocationProvider {
    private int activityRequestCode;
    private final ReactApplicationContext context;
    private final FusedLocationProviderClient fusedLocationProviderClient;
    private final LocationChangeListener locationChangeListener;
    private LocationOptions locationOptions;
    private LocationRequest locationRequest;
    private final SettingsClient settingsClient;
    private boolean isSingleUpdate = false;
    private final LocationCallback locationCallback = new LocationCallback() { // from class: com.agontuk.RNFusedLocation.FusedLocationProvider.1
        @Override // com.google.android.gms.location.LocationCallback
        public void onLocationResult(LocationResult locationResult) {
            FusedLocationProvider.this.locationChangeListener.onLocationChange(FusedLocationProvider.this, locationResult.getLastLocation());
            if (FusedLocationProvider.this.isSingleUpdate) {
                FusedLocationProvider.this.timeoutHandler.removeCallbacks(FusedLocationProvider.this.timeoutRunnable);
                FusedLocationProvider.this.fusedLocationProviderClient.removeLocationUpdates(FusedLocationProvider.this.locationCallback);
            }
        }

        @Override // com.google.android.gms.location.LocationCallback
        public void onLocationAvailability(LocationAvailability locationAvailability) {
            if (locationAvailability.isLocationAvailable() || LocationUtils.isLocationEnabled(FusedLocationProvider.this.context)) {
                return;
            }
            FusedLocationProvider.this.locationChangeListener.onLocationError(FusedLocationProvider.this, LocationError.POSITION_UNAVAILABLE, "Unable to retrieve location.");
        }
    };
    private final Handler timeoutHandler = new Handler(Looper.getMainLooper());
    private final Runnable timeoutRunnable = new Runnable() { // from class: com.agontuk.RNFusedLocation.FusedLocationProvider.2
        @Override // java.lang.Runnable
        public void run() {
            FusedLocationProvider.this.locationChangeListener.onLocationError(FusedLocationProvider.this, LocationError.TIMEOUT, null);
            FusedLocationProvider.this.fusedLocationProviderClient.removeLocationUpdates(FusedLocationProvider.this.locationCallback);
        }
    };

    public FusedLocationProvider(ReactApplicationContext reactApplicationContext, LocationChangeListener locationChangeListener) {
        this.context = reactApplicationContext;
        this.fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(reactApplicationContext);
        this.locationChangeListener = locationChangeListener;
        this.settingsClient = LocationServices.getSettingsClient(reactApplicationContext);
    }

    @Override // com.agontuk.RNFusedLocation.LocationProvider
    public void getCurrentLocation(final LocationOptions locationOptions) {
        this.isSingleUpdate = true;
        this.locationOptions = locationOptions;
        this.locationRequest = buildLocationRequest(locationOptions);
        this.fusedLocationProviderClient.getLastLocation().addOnSuccessListener(new OnSuccessListener<Location>() { // from class: com.agontuk.RNFusedLocation.FusedLocationProvider.4
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public void onSuccess(Location location) {
                if (location != null && LocationUtils.getLocationAge(location) < locationOptions.getMaximumAge()) {
                    Log.i(RNFusedLocationModule.TAG, "returning cached location.");
                    FusedLocationProvider.this.locationChangeListener.onLocationChange(FusedLocationProvider.this, location);
                } else {
                    FusedLocationProvider.this.checkLocationSettings();
                }
            }
        }).addOnFailureListener(new OnFailureListener() { // from class: com.agontuk.RNFusedLocation.FusedLocationProvider.3
            @Override // com.google.android.gms.tasks.OnFailureListener
            public void onFailure(Exception exc) {
                FusedLocationProvider.this.checkLocationSettings();
            }
        });
    }

    @Override // com.agontuk.RNFusedLocation.LocationProvider
    public boolean onActivityResult(int i, int i2) {
        if (i != this.activityRequestCode) {
            return false;
        }
        if (i2 == -1) {
            startLocationUpdates();
            return true;
        }
        boolean zIsForceRequestLocation = this.locationOptions.isForceRequestLocation();
        boolean zIsLocationEnabled = LocationUtils.isLocationEnabled(this.context);
        if (zIsForceRequestLocation && zIsLocationEnabled) {
            startLocationUpdates();
        } else {
            this.locationChangeListener.onLocationError(this, zIsLocationEnabled ? LocationError.SETTINGS_NOT_SATISFIED : LocationError.POSITION_UNAVAILABLE, null);
        }
        return true;
    }

    @Override // com.agontuk.RNFusedLocation.LocationProvider
    public void requestLocationUpdates(LocationOptions locationOptions) {
        this.isSingleUpdate = false;
        this.locationOptions = locationOptions;
        this.locationRequest = buildLocationRequest(locationOptions);
        checkLocationSettings();
    }

    @Override // com.agontuk.RNFusedLocation.LocationProvider
    public void removeLocationUpdates() {
        this.fusedLocationProviderClient.removeLocationUpdates(this.locationCallback);
    }

    private LocationRequest buildLocationRequest(LocationOptions locationOptions) {
        LocationRequest locationRequest = new LocationRequest();
        locationRequest.setPriority(getLocationPriority(locationOptions.getAccuracy())).setInterval(locationOptions.getInterval()).setFastestInterval(locationOptions.getFastestInterval()).setSmallestDisplacement(this.isSingleUpdate ? 0.0f : locationOptions.getDistanceFilter());
        return locationRequest;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkLocationSettings() {
        LocationSettingsRequest.Builder builder = new LocationSettingsRequest.Builder();
        builder.addLocationRequest(this.locationRequest);
        this.settingsClient.checkLocationSettings(builder.build()).addOnSuccessListener(new OnSuccessListener<LocationSettingsResponse>() { // from class: com.agontuk.RNFusedLocation.FusedLocationProvider.6
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public void onSuccess(LocationSettingsResponse locationSettingsResponse) {
                FusedLocationProvider.this.startLocationUpdates();
            }
        }).addOnFailureListener(new OnFailureListener() { // from class: com.agontuk.RNFusedLocation.FusedLocationProvider.5
            @Override // com.google.android.gms.tasks.OnFailureListener
            public void onFailure(Exception exc) {
                ApiException apiException = (ApiException) exc;
                int statusCode = apiException.getStatusCode();
                if (statusCode == 6) {
                    boolean zIsShowLocationDialog = FusedLocationProvider.this.locationOptions.isShowLocationDialog();
                    boolean zIsForceRequestLocation = FusedLocationProvider.this.locationOptions.isForceRequestLocation();
                    boolean zIsLocationEnabled = LocationUtils.isLocationEnabled(FusedLocationProvider.this.context);
                    if (!zIsShowLocationDialog) {
                        if (zIsForceRequestLocation && zIsLocationEnabled) {
                            FusedLocationProvider.this.startLocationUpdates();
                            return;
                        } else {
                            FusedLocationProvider.this.locationChangeListener.onLocationError(FusedLocationProvider.this, zIsLocationEnabled ? LocationError.SETTINGS_NOT_SATISFIED : LocationError.POSITION_UNAVAILABLE, null);
                            return;
                        }
                    }
                    try {
                        ResolvableApiException resolvableApiException = (ResolvableApiException) apiException;
                        Activity currentActivity = FusedLocationProvider.this.context.getCurrentActivity();
                        if (currentActivity == null) {
                            FusedLocationProvider.this.locationChangeListener.onLocationError(FusedLocationProvider.this, LocationError.INTERNAL_ERROR, "Tried to open location dialog while not attached to an Activity.");
                        } else {
                            FusedLocationProvider fusedLocationProvider = FusedLocationProvider.this;
                            fusedLocationProvider.activityRequestCode = fusedLocationProvider.getActivityRequestCode();
                            resolvableApiException.startResolutionForResult(currentActivity, FusedLocationProvider.this.activityRequestCode);
                        }
                        return;
                    } catch (IntentSender.SendIntentException | ClassCastException unused) {
                        FusedLocationProvider.this.locationChangeListener.onLocationError(FusedLocationProvider.this, LocationError.INTERNAL_ERROR, null);
                        return;
                    }
                }
                if (statusCode == 8502 && LocationUtils.isOnAirplaneMode(FusedLocationProvider.this.context) && LocationUtils.isProviderEnabled(FusedLocationProvider.this.context, "gps")) {
                    FusedLocationProvider.this.startLocationUpdates();
                } else {
                    FusedLocationProvider.this.locationChangeListener.onLocationError(FusedLocationProvider.this, LocationError.SETTINGS_NOT_SATISFIED, null);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getActivityRequestCode() {
        return new Random().nextInt(10000);
    }

    /* JADX INFO: renamed from: com.agontuk.RNFusedLocation.FusedLocationProvider$7, reason: invalid class name */
    static /* synthetic */ class AnonymousClass7 {
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

    private int getLocationPriority(LocationAccuracy locationAccuracy) {
        int i = AnonymousClass7.$SwitchMap$com$agontuk$RNFusedLocation$LocationAccuracy[locationAccuracy.ordinal()];
        if (i == 1) {
            return 100;
        }
        if (i == 2) {
            return 102;
        }
        if (i == 3) {
            return 104;
        }
        if (i == 4) {
            return 105;
        }
        throw new IllegalStateException("Unexpected value: " + locationAccuracy);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startLocationUpdates() {
        this.fusedLocationProviderClient.requestLocationUpdates(this.locationRequest, this.locationCallback, Looper.getMainLooper());
        if (this.isSingleUpdate) {
            long timeout = this.locationOptions.getTimeout();
            if (timeout <= 0 || timeout == Long.MAX_VALUE) {
                return;
            }
            this.timeoutHandler.postDelayed(this.timeoutRunnable, timeout);
        }
    }
}
