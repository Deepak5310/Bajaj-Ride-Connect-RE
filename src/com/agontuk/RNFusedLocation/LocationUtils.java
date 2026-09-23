package com.agontuk.RNFusedLocation;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import android.os.SystemClock;
import android.provider.Settings;
import androidx.core.app.ActivityCompat;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.devsupport.StackTraceHelper;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.mappls.sdk.navigation.util.SavingTrackHelper;
import com.spotify.sdk.android.auth.AccountsQueryParameters;

/* JADX INFO: loaded from: classes3.dex */
public class LocationUtils {
    public static long getLocationAge(Location location) {
        return (SystemClock.elapsedRealtimeNanos() - location.getElapsedRealtimeNanos()) / 1000000;
    }

    public static boolean hasLocationPermission(Context context) {
        return ActivityCompat.checkSelfPermission(context, "android.permission.ACCESS_FINE_LOCATION") == 0 || ActivityCompat.checkSelfPermission(context, "android.permission.ACCESS_COARSE_LOCATION") == 0;
    }

    public static boolean isGooglePlayServicesAvailable(Context context) {
        int iIsGooglePlayServicesAvailable = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(context);
        return iIsGooglePlayServicesAvailable == 0 || iIsGooglePlayServicesAvailable == 18;
    }

    public static boolean isOnAirplaneMode(Context context) {
        return Settings.Global.getInt(context.getContentResolver(), "airplane_mode_on", 0) != 0;
    }

    public static boolean isLocationEnabled(Context context) {
        try {
            LocationManager locationManager = (LocationManager) context.getSystemService(FirebaseAnalytics.Param.LOCATION);
            if (Build.VERSION.SDK_INT >= 28) {
                return locationManager.isLocationEnabled();
            }
            return locationManager.isProviderEnabled("network") || locationManager.isProviderEnabled("gps");
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean isProviderEnabled(Context context, String str) {
        try {
            return ((LocationManager) context.getSystemService(FirebaseAnalytics.Param.LOCATION)).isProviderEnabled(str);
        } catch (Exception unused) {
            return false;
        }
    }

    public static WritableMap buildError(LocationError locationError, String str) {
        if (str == null) {
            str = getDefaultErrorMessage(locationError);
        }
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putInt(AccountsQueryParameters.CODE, locationError.getValue());
        writableMapCreateMap.putString(StackTraceHelper.MESSAGE_KEY, str);
        return writableMapCreateMap;
    }

    public static WritableMap locationToMap(Location location) {
        WritableMap writableMapCreateMap = Arguments.createMap();
        WritableMap writableMapCreateMap2 = Arguments.createMap();
        writableMapCreateMap2.putDouble("latitude", location.getLatitude());
        writableMapCreateMap2.putDouble("longitude", location.getLongitude());
        writableMapCreateMap2.putDouble(SavingTrackHelper.TRACK_COL_ALTITUDE, location.getAltitude());
        writableMapCreateMap2.putDouble("accuracy", location.getAccuracy());
        writableMapCreateMap2.putDouble("heading", location.getBearing());
        writableMapCreateMap2.putDouble("speed", location.getSpeed());
        if (Build.VERSION.SDK_INT >= 26) {
            writableMapCreateMap2.putDouble("altitudeAccuracy", location.getVerticalAccuracyMeters());
        }
        writableMapCreateMap.putMap("coords", writableMapCreateMap2);
        writableMapCreateMap.putString("provider", location.getProvider());
        writableMapCreateMap.putDouble("timestamp", location.getTime());
        writableMapCreateMap.putBoolean("mocked", location.isFromMockProvider());
        return writableMapCreateMap;
    }

    /* JADX INFO: renamed from: com.agontuk.RNFusedLocation.LocationUtils$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$agontuk$RNFusedLocation$LocationError;

        static {
            int[] iArr = new int[LocationError.values().length];
            $SwitchMap$com$agontuk$RNFusedLocation$LocationError = iArr;
            try {
                iArr[LocationError.PERMISSION_DENIED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$agontuk$RNFusedLocation$LocationError[LocationError.POSITION_UNAVAILABLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$agontuk$RNFusedLocation$LocationError[LocationError.TIMEOUT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$agontuk$RNFusedLocation$LocationError[LocationError.PLAY_SERVICE_NOT_AVAILABLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$agontuk$RNFusedLocation$LocationError[LocationError.SETTINGS_NOT_SATISFIED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$agontuk$RNFusedLocation$LocationError[LocationError.INTERNAL_ERROR.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    private static String getDefaultErrorMessage(LocationError locationError) {
        int i = AnonymousClass1.$SwitchMap$com$agontuk$RNFusedLocation$LocationError[locationError.ordinal()];
        if (i == 1) {
            return "Location permission not granted.";
        }
        if (i == 2) {
            return "No location provider available.";
        }
        if (i == 3) {
            return "Location request timed out.";
        }
        if (i == 4) {
            return "Google play service is not available.";
        }
        if (i == 5) {
            return "Location settings are not satisfied.";
        }
        return "Internal error occurred";
    }
}
