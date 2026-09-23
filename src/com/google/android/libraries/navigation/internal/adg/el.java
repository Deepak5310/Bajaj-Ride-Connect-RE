package com.google.android.libraries.navigation.internal.adg;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public enum el implements com.google.android.libraries.navigation.internal.ael.bm {
    UNKNOWN_PROJECTION_BEHAVIOR(0),
    PROJECTION_SCREEN_ALIGNED(1),
    PROJECTION_WORLD_ALIGNED(2);

    private final int e;

    el(int i) {
        this.e = i;
    }

    public static el b(int i) {
        if (i == 0) {
            return UNKNOWN_PROJECTION_BEHAVIOR;
        }
        if (i == 1) {
            return PROJECTION_SCREEN_ALIGNED;
        }
        if (i != 2) {
            return null;
        }
        return PROJECTION_WORLD_ALIGNED;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bm
    public final int a() {
        return this.e;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return Integer.toString(this.e);
    }
}
