package com.google.android.libraries.navigation.internal.km;

import com.google.firebase.perf.util.Constants;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class am {
    public static final x a;
    public static final x b;
    public static final x c;
    public static final x d;
    public static final x e;
    public static final x f;
    public static final x g;
    public static final x h;
    public static final x i;
    public static final x j;
    public static final x k;

    static {
        new y("OfflineAutoUpdateJobInterruptionTimeSeconds", w.OFFLINE, 4, 2025);
        new y("OfflineAutoUpdateClientWaitTimeSeconds", w.OFFLINE, 4, 2025);
        new y("OfflineManualUpdateClientWaitTimeSeconds", w.OFFLINE, 4, 2025);
        new y("OfflineDynamicUpdateClientWaitTimeSeconds", w.OFFLINE, 4, 2025);
        new y("OfflineUpdateClientWaitTimeSeconds", w.OFFLINE, 4, 2025);
        new y("OfflineAutodownloadStorageDeficitMegaBytes", w.OFFLINE, 4, 2025);
        new y("OfflineAutoUpdateStartCountByHoursSinceLast", w.OFFLINE, 4, 2025);
        new y("OfflineDownloadNetworkBytesByNetworkType", w.OFFLINE, 4, 2025);
        new y("OfflineGmmOverallNetworkBytesByNetworkType", w.OFFLINE, 4, 2025);
        w wVar = w.OFFLINE;
        a = new x("OfflineAvailabilityPaintGetResource", wVar, 4, 2025);
        b = new x("OfflineAvailabilityPaintGetTile", wVar, 4, 2025);
        c = new x("OfflineAvailabilityPaintHasResource", wVar, 4, 2025);
        d = new x("OfflineAvailabilityRoutingGetDirections", wVar, 4, 2025);
        e = new x("OfflineAvailabilitySearchLocationDetails", wVar, 4, 2025);
        f = new x("OfflineAvailabilitySearchPlaceDetails", wVar, 4, 2025);
        g = new x("OfflineAvailabilitySearchSearch", wVar, 4, 2025);
        h = new x("OfflineAvailabilitySearchSuggest", wVar, 4, 2025);
        i = new x("OfflineEfficacyRoutingGetDirectionsStatus", wVar, 4, 2025);
        j = new x("OfflineEfficacySearchSearchPlaces", wVar, 4, 2025);
        k = new x("OfflineEfficacySearchSuggestPlaces", wVar, 4, 2025);
        new y("OfflineCleanupReappearanceByMs", wVar, 4, 2025);
        com.google.android.libraries.navigation.internal.ky.ab abVar = b.a;
        new com.google.android.libraries.navigation.internal.ky.af(10, 0, Constants.MAX_URL_LENGTH);
        new y("OfflineTileFetcherGetCompositeTilesLatencyMs", w.OFFLINE);
        new y("OfflineTileFetcherGetCompositeTilesAdasTileCacheHitWithSegmentFilterLatencyMs", w.OFFLINE);
        new y("OfflineTileFetcherGetCompositeTilesAdasTileCacheHitNoSegmentFilterLatencyMs", w.OFFLINE);
        new y("OfflineTileFetcherGetCompositeTilesAdasTileCacheMissWithSegmentFilterLatencyMs", w.OFFLINE);
        new y("OfflineTileFetcherGetCompositeTilesAdasTileCacheMissNoSegmentFilterLatencyMs", w.OFFLINE);
        new y("OfflineTileFetcherGetCompositeTilesLaneTileCacheHitWithSegmentFilterLatencyMs", w.OFFLINE);
        new y("OfflineTileFetcherGetCompositeTilesLaneTileCacheHitNoSegmentFilterLatencyMs", w.OFFLINE);
        new y("OfflineTileFetcherGetCompositeTilesLaneTileCacheMissWithSegmentFilterLatencyMs", w.OFFLINE);
        new y("OfflineTileFetcherGetCompositeTilesLaneTileCacheMissNoSegmentFilterLatencyMs", w.OFFLINE);
    }
}
