package com.google.android.libraries.geo.mapcore.internal.legacy.internal.vector.gl;

import com.google.android.libraries.navigation.internal.agg.de;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
final class k {
    final byte[] a;
    int b;
    final int e;
    final /* synthetic */ p h;
    final de f = new de(4);
    int g = 0;
    final int c = 4;
    final int d = 32;

    public k(p pVar, byte[] bArr, int i, int i2) {
        this.h = pVar;
        this.a = bArr;
        this.e = i2;
    }

    public final void a(int i) {
        int i2 = this.b;
        int i3 = i2 + 1;
        this.b = i3;
        byte[] bArr = this.a;
        bArr[i2] = (byte) ((i >> 24) & 255);
        int i4 = i2 + 2;
        this.b = i4;
        bArr[i3] = (byte) ((i >> 16) & 255);
        int i5 = i2 + 3;
        this.b = i5;
        bArr[i4] = (byte) ((i >> 8) & 255);
        this.b = i2 + 4;
        bArr[i5] = (byte) (i & 255);
    }
}
