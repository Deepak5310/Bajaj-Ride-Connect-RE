package com.google.android.libraries.navigation.internal.adg;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public enum jr implements com.google.android.libraries.navigation.internal.ael.bm {
    WORLD_ENCODING_UNKNOWN(0),
    WORLD_ENCODING_LAT_LNG_E7(3),
    WORLD_ENCODING_LAT_LNG_DOUBLE(4),
    SCREEN_SPACE_FLOAT(5),
    WORLD_ENCODING_MAX_PRECISION_DELTA_VARINT(6);

    public final int f;

    jr(int i) {
        this.f = i;
    }

    public static jr b(int i) {
        if (i == 0) {
            return WORLD_ENCODING_UNKNOWN;
        }
        if (i == 3) {
            return WORLD_ENCODING_LAT_LNG_E7;
        }
        if (i == 4) {
            return WORLD_ENCODING_LAT_LNG_DOUBLE;
        }
        if (i == 5) {
            return SCREEN_SPACE_FLOAT;
        }
        if (i != 6) {
            return null;
        }
        return WORLD_ENCODING_MAX_PRECISION_DELTA_VARINT;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bm
    public final int a() {
        return this.f;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return Integer.toString(this.f);
    }
}
