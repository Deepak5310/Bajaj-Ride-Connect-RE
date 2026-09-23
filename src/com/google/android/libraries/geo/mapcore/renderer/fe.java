package com.google.android.libraries.geo.mapcore.renderer;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public abstract class fe {
    protected final int a;
    public final int b;
    public final int c;

    public fe(int i, int i2, int i3, int i4) {
        com.google.android.libraries.navigation.internal.yx.ar.g(i4 % i2 == 0, "Misaligned data; vertices are %s bytes but data is %s-byte aligned", i4, i2);
        com.google.android.libraries.navigation.internal.yx.ar.d(i4 % 4 == 0, "Vertex size must be a multiple of integer size; got %s", i4);
        int i5 = i * i2;
        int i6 = i3 * i4;
        if (i5 < i6) {
            throw new IllegalArgumentException(com.google.android.libraries.navigation.internal.b.b.m(i4, i3, i5, "Byte capacity ", ", count ", ", size in bytes "));
        }
        this.b = i3;
        this.c = i4;
        this.a = i6 / i2;
    }

    public abstract bw a(bv bvVar, String str);

    public abstract bw b(bv bvVar, String str, bq bqVar, int i);
}
