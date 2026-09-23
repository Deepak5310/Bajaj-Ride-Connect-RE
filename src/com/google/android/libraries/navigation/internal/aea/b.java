package com.google.android.libraries.navigation.internal.aea;

import com.google.android.libraries.navigation.internal.ael.bm;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public enum b implements bm {
    UNKNOWN_MAP_LAYER_TYPE(0),
    TRAFFIC(1),
    TRANSIT(2),
    SATELLITE(3),
    BIKE(4),
    TERRAIN(5),
    THREE_DIMENSIONAL(6),
    STREET_VIEW(7),
    AIR_QUALITY(8),
    WILDFIRES(9),
    GLOBE(10);

    public final int l;

    b(int i) {
        this.l = i;
    }

    public static b b(int i) {
        switch (i) {
            case 0:
                return UNKNOWN_MAP_LAYER_TYPE;
            case 1:
                return TRAFFIC;
            case 2:
                return TRANSIT;
            case 3:
                return SATELLITE;
            case 4:
                return BIKE;
            case 5:
                return TERRAIN;
            case 6:
                return THREE_DIMENSIONAL;
            case 7:
                return STREET_VIEW;
            case 8:
                return AIR_QUALITY;
            case 9:
                return WILDFIRES;
            case 10:
                return GLOBE;
            default:
                return null;
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bm
    public final int a() {
        return this.l;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return Integer.toString(this.l);
    }
}
