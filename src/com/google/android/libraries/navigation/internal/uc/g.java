package com.google.android.libraries.navigation.internal.uc;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public enum g {
    FOLLOWING,
    FREE_MOVEMENT,
    OVERVIEW,
    INSPECT_STEP,
    INSPECT_RESULTS_ON_MAP_WITH_LOCATION,
    INSPECT_RESULTS_ON_MAP_WITHOUT_LOCATION,
    INSPECT_POINT_ON_ROUTE,
    INSPECT_ROUTE_SECTION,
    ARRIVAL;

    public final boolean a() {
        return this == FOLLOWING || this == INSPECT_POINT_ON_ROUTE;
    }
}
