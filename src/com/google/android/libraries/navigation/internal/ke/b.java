package com.google.android.libraries.navigation.internal.ke;

import com.google.android.libraries.navigation.internal.yx.aa;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
class b implements aa {
    public static final com.google.android.libraries.navigation.internal.aea.b b(com.google.android.libraries.navigation.internal.cv.a aVar) {
        com.google.android.libraries.navigation.internal.cv.a aVar2 = com.google.android.libraries.navigation.internal.cv.a.TRAFFIC;
        switch (aVar) {
            case TRAFFIC:
                return com.google.android.libraries.navigation.internal.aea.b.TRAFFIC;
            case BICYCLING:
                return com.google.android.libraries.navigation.internal.aea.b.BIKE;
            case TRANSIT:
                return com.google.android.libraries.navigation.internal.aea.b.TRANSIT;
            case SATELLITE:
                return com.google.android.libraries.navigation.internal.aea.b.SATELLITE;
            case TERRAIN:
                return com.google.android.libraries.navigation.internal.aea.b.TERRAIN;
            case REALTIME:
                return com.google.android.libraries.navigation.internal.aea.b.UNKNOWN_MAP_LAYER_TYPE;
            case STREETVIEW:
                return com.google.android.libraries.navigation.internal.aea.b.STREET_VIEW;
            case THREE_DIMENSIONAL:
                return com.google.android.libraries.navigation.internal.aea.b.THREE_DIMENSIONAL;
            case COVID19:
                return com.google.android.libraries.navigation.internal.aea.b.UNKNOWN_MAP_LAYER_TYPE;
            case AIR_QUALITY:
                return com.google.android.libraries.navigation.internal.aea.b.AIR_QUALITY;
            case WILDFIRES:
                return com.google.android.libraries.navigation.internal.aea.b.WILDFIRES;
            case UNKNOWN:
                return com.google.android.libraries.navigation.internal.aea.b.UNKNOWN_MAP_LAYER_TYPE;
            default:
                throw new IllegalArgumentException("unknown enum value: ".concat(String.valueOf(String.valueOf(aVar))));
        }
    }

    @Override // com.google.android.libraries.navigation.internal.yx.aa
    public final /* bridge */ /* synthetic */ Object ak(Object obj) {
        return b((com.google.android.libraries.navigation.internal.cv.a) obj);
    }
}
