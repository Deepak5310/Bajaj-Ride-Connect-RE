package com.google.android.libraries.geo.mapcore.renderer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
final class es {
    public final String a;
    public bv b;
    public final bw[] e;
    public final int f;
    public final int[] h;
    public final boolean k;
    public final int l;
    public int c = 0;
    public int d = 0;
    public int g = 0;
    public int i = 0;
    public int j = 0;

    public es(String str, int i, int i2, boolean z) {
        com.google.android.libraries.navigation.internal.yx.ar.a(true);
        this.a = str;
        this.f = i;
        this.l = 2;
        this.k = z;
        bw[] bwVarArr = new bw[true == z ? 2 : 1];
        this.e = bwVarArr;
        this.h = new int[bwVarArr.length];
        int i3 = 0;
        while (true) {
            bw[] bwVarArr2 = this.e;
            if (i3 >= bwVarArr2.length) {
                return;
            }
            this.h[i3] = 0;
            bwVarArr2[i3] = bw.a;
            i3++;
        }
    }

    public final bw a() {
        return this.e[this.d];
    }
}
