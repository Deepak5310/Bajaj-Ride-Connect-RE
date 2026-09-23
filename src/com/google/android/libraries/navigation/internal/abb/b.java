package com.google.android.libraries.navigation.internal.abb;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class b {
    public int a;
    public int b;
    public int c;
    public int d;
    public int e;

    public b(int i, int i2, int i3, int i4, int i5) {
        if (i5 != 0 && i5 != 1) {
            throw new IllegalArgumentException(com.google.android.libraries.navigation.internal.b.b.b(i5, "qualityAlgorithm = "));
        }
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
        this.e = i5;
    }
}
