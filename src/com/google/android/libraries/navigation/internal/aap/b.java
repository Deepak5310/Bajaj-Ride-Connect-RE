package com.google.android.libraries.navigation.internal.aap;

import com.google.android.libraries.navigation.internal.ael.bm;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public enum b implements bm {
    UNKNOWN_CAMERA_SURFACE(0),
    LEGACY_CAMERA_SURFACE(1),
    SHARED_CAMERA_SURFACE(2),
    IGMM_CARPLAY_SURFACE(3),
    AGMM_PROJECTED_SURFACE(4),
    EGMM_SURFACE(5);

    private final int h;

    b(int i) {
        this.h = i;
    }

    public static b b(int i) {
        if (i == 0) {
            return UNKNOWN_CAMERA_SURFACE;
        }
        if (i == 1) {
            return LEGACY_CAMERA_SURFACE;
        }
        if (i == 2) {
            return SHARED_CAMERA_SURFACE;
        }
        if (i == 3) {
            return IGMM_CARPLAY_SURFACE;
        }
        if (i == 4) {
            return AGMM_PROJECTED_SURFACE;
        }
        if (i != 5) {
            return null;
        }
        return EGMM_SURFACE;
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
