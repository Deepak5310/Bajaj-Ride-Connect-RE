package com.google.android.libraries.navigation.internal.xf;

import com.google.android.libraries.navigation.internal.adr.bm;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class q {
    public static float a(float f, int i) {
        return (i * (f + 100.0f)) / 100.0f;
    }

    public static int b(int i, bm.a aVar) {
        return i + (aVar == bm.a.MILES ? 10 : 20);
    }

    public static int c(int i, bm.a aVar) {
        return i + (aVar == bm.a.MILES ? 5 : 10);
    }
}
