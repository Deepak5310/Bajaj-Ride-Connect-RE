package com.google.android.libraries.geo.mapcore.renderer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
enum a {
    NEXT,
    X,
    Y,
    WIDTH,
    HEIGHT;

    public static final int f = values().length;

    final int a(int[] iArr, int i) {
        return iArr[(i * f) + ordinal()];
    }

    final void b(int[] iArr, int i, int i2) {
        iArr[(i * f) + ordinal()] = i2;
    }
}
