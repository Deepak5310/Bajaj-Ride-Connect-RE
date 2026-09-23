package com.google.android.libraries.geo.mapcore.renderer;

import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class v {
    public final com.google.android.libraries.navigation.internal.pd.d a;
    public final int b;
    public final int c;
    public final float d;
    public final float e;
    public final float f;
    public final float g;
    public final int h;
    public final int i;
    public final int j;
    public final int k;
    public final int l;
    public final int m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final double f86n;
    public final double o;
    public final double p;
    public final float q;
    public final float r;
    public final float s;
    public final float t;
    public final com.google.android.libraries.navigation.internal.oe.bc u;
    public final float[] v;
    public final float[] w;
    public final float[] x;
    public final float[] y;

    public v() {
        this(com.google.android.libraries.navigation.internal.pd.d.a, 0, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0, 0, 0, 0, 0, 0, 0.0d, 0.0d, 0.0d, 0.0f, 0.0f, 0.0f, 0.0f, new com.google.android.libraries.navigation.internal.oe.bc(new com.google.android.libraries.navigation.internal.oe.x[]{new com.google.android.libraries.navigation.internal.oe.x(), new com.google.android.libraries.navigation.internal.oe.x(), new com.google.android.libraries.navigation.internal.oe.x(), new com.google.android.libraries.navigation.internal.oe.x()}), new float[16], new float[16], new float[16], new float[16]);
    }

    public v(com.google.android.libraries.navigation.internal.pd.d dVar, int i, int i2, float f, float f2, float f3, float f4, int i3, int i4, int i5, int i6, int i7, int i8, double d, double d2, double d3, float f5, float f6, float f7, float f8, com.google.android.libraries.navigation.internal.oe.bc bcVar, float[] fArr, float[] fArr2, float[] fArr3, float[] fArr4) {
        this.a = dVar;
        this.b = i;
        this.c = i2;
        this.d = f;
        this.e = f2;
        this.f = f3;
        this.g = f4;
        this.h = i3;
        this.i = i4;
        this.j = i5;
        this.k = i6;
        this.l = i7;
        this.m = i8;
        this.f86n = d;
        this.o = d2;
        this.p = d3;
        this.q = f5;
        this.r = f6;
        this.s = f7;
        this.t = f8;
        this.u = bcVar;
        this.w = fArr2;
        this.v = fArr;
        this.x = fArr3;
        this.y = fArr4;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof v) {
            v vVar = (v) obj;
            if (this.a.equals(vVar.a) && this.b == vVar.b && this.c == vVar.c && this.d == vVar.d && this.e == vVar.e && this.f == vVar.f && this.g == vVar.g) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.a, Integer.valueOf(this.b), Integer.valueOf(this.c), Float.valueOf(this.d), Float.valueOf(this.e), Float.valueOf(this.f), Float.valueOf(this.g)});
    }
}
