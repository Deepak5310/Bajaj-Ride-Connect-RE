package com.google.android.libraries.navigation.internal.px;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
enum ab {
    SECONDARY_FIRST,
    TRAILING_EDGE_ALIGNED,
    CENTERED,
    LEADING_EDGE_ALIGNED,
    PRIMARY_FIRST;

    public static final com.google.android.libraries.navigation.internal.zb.j f = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.navigation.internal.px.ab");

    final float a(float f2, float f3) {
        float f4;
        float fMax = Math.max(f2, f3);
        int iOrdinal = ordinal();
        if (iOrdinal == 0) {
            return f3 / 2.0f;
        }
        if (iOrdinal == 1) {
            return (fMax - f2) / 2.0f;
        }
        if (iOrdinal == 2) {
            return 0.0f;
        }
        if (iOrdinal == 3) {
            f4 = f2 - fMax;
        } else if (iOrdinal != 4) {
            f4 = -f3;
            ((com.google.android.libraries.navigation.internal.zb.h) f.d(com.google.android.libraries.navigation.internal.nl.a.a).F(921)).s("Unsupported callout label alignment alignment: %s", this);
        } else {
            f4 = -f3;
        }
        return f4 / 2.0f;
    }

    final float b(float f2, float f3) {
        float fMax = Math.max(f2, f3);
        int iOrdinal = ordinal();
        if (iOrdinal == 0) {
            return (-f2) / 2.0f;
        }
        if (iOrdinal == 1) {
            return (fMax - f3) / 2.0f;
        }
        if (iOrdinal == 2) {
            return 0.0f;
        }
        if (iOrdinal == 3) {
            return (f3 - fMax) / 2.0f;
        }
        if (iOrdinal == 4) {
            return f2 / 2.0f;
        }
        ((com.google.android.libraries.navigation.internal.zb.h) f.d(com.google.android.libraries.navigation.internal.nl.a.a).F(922)).s("Unsupported callout label alignment alignment: %s", this);
        return 0.0f;
    }
}
