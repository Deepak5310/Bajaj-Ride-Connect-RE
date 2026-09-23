package com.google.android.libraries.navigation.internal.ob;

import com.google.android.libraries.navigation.internal.adi.an;
import com.google.android.libraries.navigation.internal.yz.fy;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public enum h {
    TRAFFIC(an.UNKNOWN),
    BICYCLING(an.GMM_VECTOR_BICYCLING_OVERLAY),
    TRANSIT(an.GMM_TRANSIT),
    SATELLITE(an.GMM_SATELLITE),
    TERRAIN(an.GMM_TERRAIN),
    REALTIME(an.GMM_REALTIME),
    STREETVIEW(an.GMM_STREET_VIEW),
    THREE_DIMENSIONAL(an.GMM_BUILDING_3D),
    COVID19(an.GMM_COVID19),
    AIR_QUALITY(an.GMM_AIR_QUALITY),
    AIR_QUALITY_HEATMAP(an.GMM_AIR_QUALITY_HEATMAP),
    WILDFIRES(an.GMM_CRISIS_WILDFIRES),
    UNKNOWN(an.UNKNOWN);


    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final fy f494n = fy.r(an.GMM_VECTOR_TRAFFIC_V2, an.GMM_TRAFFIC_CAR, an.GMM_TRAFFIC_CAR_JAPAN);
    private final an p;

    h(an anVar) {
        this.p = anVar;
    }

    public static h a(an anVar) {
        for (h hVar : values()) {
            if (hVar.b(false) == anVar || hVar.b(true) == anVar) {
                return hVar;
            }
        }
        if (f494n.contains(anVar)) {
            return TRAFFIC;
        }
        return null;
    }

    public final an b(boolean z) {
        return (z && this == TERRAIN) ? an.GMM_TERRAIN_DARK : this.p;
    }
}
