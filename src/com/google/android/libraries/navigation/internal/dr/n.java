package com.google.android.libraries.navigation.internal.dr;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public enum n {
    CHEVRON("Navigation chevron", 5),
    CHEVRON_DISC("Navigation chevron disc", 3),
    BEARINGLESS_CHEVRON("Navigation bearingless chevron", 5),
    DIM_CHEVRON("Navigation dim chevron", 5),
    DIM_CHEVRON_DISC("Navigation dim chevron disc", 3),
    DIM_BEARINGLESS_CHEVRON("Navigation dim bearingless chevron", 5);

    public final String g;
    public final int h;

    n(String str, int i2) {
        this.g = str;
        this.h = i2;
    }

    final int a(p pVar) {
        int iOrdinal = ordinal();
        if (iOrdinal == 0) {
            return pVar.e;
        }
        if (iOrdinal == 1) {
            return pVar.g;
        }
        if (iOrdinal == 2) {
            return pVar.f;
        }
        if (iOrdinal == 3) {
            return pVar.o;
        }
        if (iOrdinal == 4) {
            return pVar.q;
        }
        if (iOrdinal == 5) {
            return pVar.p;
        }
        throw null;
    }
}
