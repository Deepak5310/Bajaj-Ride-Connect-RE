package com.agontuk.RNFusedLocation;

import androidx.mediarouter.media.SystemMediaRouteProvider;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;

/* JADX INFO: loaded from: classes3.dex */
public class LocationOptions {
    private static final float DEFAULT_DISTANCE_FILTER = 100.0f;
    private static final long DEFAULT_FASTEST_INTERVAL = 5000;
    private static final long DEFAULT_INTERVAL = 10000;
    private final LocationAccuracy accuracy;
    private final float distanceFilter;
    private final long fastestInterval;
    private final boolean forceLocationManager;
    private final boolean forceRequestLocation;
    private final long interval;
    private final double maximumAge;
    private final boolean showLocationDialog;
    private final long timeout;

    private LocationOptions(LocationAccuracy locationAccuracy, long j, long j2, float f, long j3, double d, boolean z, boolean z2, boolean z3) {
        this.accuracy = locationAccuracy;
        this.interval = j;
        this.fastestInterval = j2;
        this.distanceFilter = f;
        this.timeout = j3;
        this.maximumAge = d;
        this.showLocationDialog = z;
        this.forceRequestLocation = z2;
        this.forceLocationManager = z3;
    }

    public static LocationOptions fromReadableMap(ReadableMap readableMap) {
        LocationAccuracy accuracy = getAccuracy(readableMap);
        long j = readableMap.hasKey("interval") ? (long) readableMap.getDouble("interval") : 10000L;
        long j2 = readableMap.hasKey("fastestInterval") ? (long) readableMap.getDouble("fastestInterval") : DEFAULT_FASTEST_INTERVAL;
        float f = readableMap.hasKey("distanceFilter") ? (float) readableMap.getDouble("distanceFilter") : DEFAULT_DISTANCE_FILTER;
        long j3 = readableMap.hasKey("timeout") ? (long) readableMap.getDouble("timeout") : Long.MAX_VALUE;
        double d = readableMap.hasKey("maximumAge") ? readableMap.getDouble("maximumAge") : Double.POSITIVE_INFINITY;
        boolean z = false;
        boolean z2 = !readableMap.hasKey("showLocationDialog") || readableMap.getBoolean("showLocationDialog");
        boolean z3 = readableMap.hasKey("forceRequestLocation") && readableMap.getBoolean("forceRequestLocation");
        if (readableMap.hasKey("forceLocationManager") && readableMap.getBoolean("forceLocationManager")) {
            z = true;
        }
        return new LocationOptions(accuracy, j, j2, f, j3, d, z2, z3, z);
    }

    public LocationAccuracy getAccuracy() {
        return this.accuracy;
    }

    public long getInterval() {
        return this.interval;
    }

    public long getFastestInterval() {
        return this.fastestInterval;
    }

    public float getDistanceFilter() {
        return this.distanceFilter;
    }

    public long getTimeout() {
        return this.timeout;
    }

    public double getMaximumAge() {
        return this.maximumAge;
    }

    public boolean isShowLocationDialog() {
        return this.showLocationDialog;
    }

    public boolean isForceRequestLocation() {
        return this.forceRequestLocation;
    }

    public boolean isForceLocationManager() {
        return this.forceLocationManager;
    }

    private static LocationAccuracy getAccuracy(ReadableMap readableMap) {
        String string;
        ReadableMap map;
        boolean z = readableMap.hasKey("enableHighAccuracy") && readableMap.getBoolean("enableHighAccuracy");
        if (!readableMap.hasKey("accuracy") || readableMap.getType("accuracy") != ReadableType.Map || (map = readableMap.getMap("accuracy")) == null || !map.hasKey(SystemMediaRouteProvider.PACKAGE_NAME) || map.getType(SystemMediaRouteProvider.PACKAGE_NAME) != ReadableType.String || (string = map.getString(SystemMediaRouteProvider.PACKAGE_NAME)) == null) {
            string = "";
        }
        string.hashCode();
        switch (string) {
            case "balanced":
                return LocationAccuracy.balanced;
            case "passive":
                return LocationAccuracy.passive;
            case "low":
                return LocationAccuracy.low;
            case "high":
                return LocationAccuracy.high;
            default:
                return z ? LocationAccuracy.high : LocationAccuracy.balanced;
        }
    }
}
