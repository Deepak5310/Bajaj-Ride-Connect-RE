package com.google.android.libraries.navigation.internal.km;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class f {
    public static final y a = new y("DirectionsRpcLocationRequirementTimeMillis", w.DIRECTIONS, 4, 2024);
    public static final y b = new y("DirectionsRpcReadFromWireTimeMillis", w.DIRECTIONS, 4, 2024);
    public static final y c = new y("DirectionsRpcRequirementsFulfillmentTimeMillis", w.DIRECTIONS, 4, 2024);
    public static final y d = new y("DirectionsRpcServerFulfillmentTimeMillis", w.DIRECTIONS, 4, 2024);
    public static final y e = new y("DirectionsRpcTransmissionTimeMillis", w.DIRECTIONS, 4, 2024);
    public static final y f = new y("DirectionsRpcWriteToWireTimeMillis", w.DIRECTIONS, 4, 2024);
    public static final y g;
    public static final ad h;

    static {
        new y("OfflineDirectionsSavedTime", w.DIRECTIONS, 4, 2024);
        g = new y("OnlineDirectionsUiFullQueryResponseSize", w.DIRECTIONS);
        new ac("DirectionsZeroSuggestResultsLoadingTime", w.DIRECTIONS, 4, 2024);
        w wVar = w.DIRECTIONS;
        h = new ad("DirectionsResponseProtoGmmServerParseTime", wVar, 4, 2024);
        new ac("PlacesheetLoadedToDirectionsPrefetchCompleteTime", wVar);
    }
}
