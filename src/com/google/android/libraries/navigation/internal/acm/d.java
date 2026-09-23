package com.google.android.libraries.navigation.internal.acm;

import com.google.android.libraries.navigation.internal.ael.bm;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public enum d implements bm {
    ALL(0),
    EXPLICIT(1),
    LACA(2),
    LACA_INTERNAL(3),
    MAJOR_ROADS_V1_LAUNCH(4),
    MAJOR_ROADS_V1_LAUNCH_INTERNAL(5);

    private final int h;

    d(int i) {
        this.h = i;
    }

    public static d b(int i) {
        if (i == 0) {
            return ALL;
        }
        if (i == 1) {
            return EXPLICIT;
        }
        if (i == 2) {
            return LACA;
        }
        if (i == 3) {
            return LACA_INTERNAL;
        }
        if (i == 4) {
            return MAJOR_ROADS_V1_LAUNCH;
        }
        if (i != 5) {
            return null;
        }
        return MAJOR_ROADS_V1_LAUNCH_INTERNAL;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bm
    public final int a() {
        return this.h;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return Integer.toString(this.h);
    }
}
