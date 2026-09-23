package com.google.android.libraries.geo.mapcore.internal.vector.gl;

import com.google.android.libraries.navigation.internal.oe.ay;
import com.google.android.libraries.navigation.internal.oe.x;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
final class f implements l {
    private final int[] a;
    private final int[] b;
    private final int[] c;
    private final int d;
    private final int e;
    private final int f;
    private final int g;
    private final boolean h;

    public f(int[] iArr, int i, int i2, int i3, int i4, boolean z, int[] iArr2, int[] iArr3) {
        this.a = iArr;
        this.d = i;
        this.e = i2;
        this.f = i3;
        this.g = i4;
        this.h = z;
        this.b = iArr2;
        this.c = iArr3;
    }

    private final int f(int i) {
        boolean z = this.h;
        int i2 = i - this.f;
        return z ? x.s(i2) : i2;
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.vector.gl.l
    public final int a() {
        return this.d;
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.vector.gl.l
    public final ay b() {
        int[] iArr = this.c;
        if (iArr == null) {
            return null;
        }
        return new ay(f(iArr[0]), iArr[1] - this.g);
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.vector.gl.l
    public final ay c() {
        int[] iArr = this.b;
        if (iArr == null) {
            return null;
        }
        return new ay(f(iArr[0]), iArr[1] - this.g);
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.vector.gl.l
    public final void d(int i, ay ayVar) {
        int i2 = this.e;
        int[] iArr = this.a;
        int i3 = i2 + i;
        ayVar.q(f(iArr[i3]), iArr[i3 + 1] - this.g);
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.vector.gl.l
    public final boolean e(int i, int i2) {
        int[] iArr = this.a;
        int i3 = this.e;
        return iArr[i3 + i] == iArr[i2 + i3];
    }
}
