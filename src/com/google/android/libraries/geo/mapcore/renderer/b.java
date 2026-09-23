package com.google.android.libraries.geo.mapcore.renderer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
enum b {
    NEXT,
    PREV,
    Y,
    HEIGHT,
    CELL_COUNT,
    HOLE_LIMIT;

    public static final int g = values().length;

    final int a(int[] iArr, int i) {
        return iArr[(i * g) + ordinal()];
    }

    final void b(int[] iArr, int i, int i2) {
        iArr[(i * g) + ordinal()] = i2;
    }
}
