package com.google.android.libraries.geo.mapcore.renderer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public enum ck implements af {
    OVERLAY_LABELS,
    MY_MAPS_LABELS,
    AR_MAPS_LABELS,
    NAVIGATION_ADS,
    STARS,
    TRAFFIC_INCIDENTS,
    SEARCH_RESULT_MEASLES,
    SEARCH_RESULT_ICONS,
    ADS,
    CLIENT_INJECTED_AREAS_ABOVE_LABELS,
    BIKESHARING_VEHICLE,
    TRANSIT_VEHICLE,
    DEBUG_TILE_BOUNDS,
    CALLOUT_LABEL,
    DEBUG_LABELS,
    CLIENT_INJECTED_AREAS_ABOVE_LABELS_AND_CALLOUTS,
    BLUE_DOT_CALLOUT,
    VISUAL_EXPLORE_CLUSTER,
    FRIEND_ACCURACY_CIRCLE,
    FRIEND,
    FRIEND_CLUSTER,
    SDK_INFO_WINDOW,
    PLACEMARK_LABELS,
    PLACEMARK,
    CALLOUT_LABEL_OVER_PLACEMARKS;

    private static final int z = cj.b + cj.values().length;

    @Override // com.google.android.libraries.geo.mapcore.renderer.af
    public final int a() {
        return z + ordinal();
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.af
    public final int b() {
        return ordinal();
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.af
    public final dy c() {
        return dy.NON_PORTED_CLIENT_INJECTED_PASS;
    }
}
