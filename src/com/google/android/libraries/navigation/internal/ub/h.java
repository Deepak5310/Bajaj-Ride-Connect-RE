package com.google.android.libraries.navigation.internal.ub;

import com.google.android.libraries.navigation.internal.zs.ar;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class h implements com.google.android.libraries.navigation.internal.uc.f, com.google.android.libraries.navigation.internal.sp.b {
    public static ar c(com.google.android.libraries.navigation.internal.uc.g gVar) {
        switch (gVar) {
            case FOLLOWING:
                return ar.FOLLOW;
            case FREE_MOVEMENT:
                return ar.FREE_MOVEMENT;
            case OVERVIEW:
                return ar.OVERVIEW_MODE;
            case INSPECT_STEP:
                return ar.INSPECT_STEP;
            case INSPECT_RESULTS_ON_MAP_WITH_LOCATION:
            case INSPECT_RESULTS_ON_MAP_WITHOUT_LOCATION:
                return ar.SEARCH_RESULTS;
            case INSPECT_POINT_ON_ROUTE:
            case INSPECT_ROUTE_SECTION:
                return ar.INSPECT_ROUTE;
            case ARRIVAL:
                return ar.ARRIVAL;
            default:
                return ar.UNKNOWN_MODE;
        }
    }

    @Override // com.google.android.libraries.navigation.internal.sp.b
    public final void a(com.google.android.libraries.navigation.internal.sp.c cVar) {
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.sp.b
    public final void b(boolean z) {
        throw null;
    }
}
