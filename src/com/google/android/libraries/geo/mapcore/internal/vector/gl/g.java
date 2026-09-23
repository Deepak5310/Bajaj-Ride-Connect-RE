package com.google.android.libraries.geo.mapcore.internal.vector.gl;

import androidx.core.view.MotionEventCompat;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
final class g {
    final int[] a;
    final int[] b;
    final float[] c;
    final j d;
    final boolean e;
    final int f;
    final int g;
    final boolean h;
    int i;
    int j;
    int k;
    boolean l;
    final boolean m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    final int f72n;
    final l o;

    public g(l lVar, int i, int i2, int i3, float[] fArr, int[] iArr, int[] iArr2, float[] fArr2) {
        this.o = lVar;
        this.f = i2;
        this.a = iArr;
        this.b = iArr2;
        this.c = fArr2;
        boolean z = false;
        this.e = (i & 64) != 0;
        this.g = ((i2 << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK) | ((i3 << 16) & 16711680);
        if (fArr == null) {
            this.d = null;
        } else {
            this.d = m.d(fArr);
        }
        this.m = 1 == (i & 1);
        this.f72n = lVar.a() / 2;
        if (lVar.e(0, lVar.a() - 2) && lVar.e(1, lVar.a() - 1)) {
            z = true;
        }
        this.h = z;
    }
}
