package com.google.android.libraries.geo.mapcore.internal.vector.gl;

import com.google.android.libraries.navigation.internal.oe.ay;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
final class e implements l {
    final float[] a;
    final int b;
    final float c;
    final float d;

    public e(float[] fArr, int i, float f, float f2) {
        this.a = fArr;
        this.b = i;
        this.c = f;
        this.d = f2;
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.vector.gl.l
    public final int a() {
        return this.b;
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.vector.gl.l
    public final ay b() {
        return null;
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.vector.gl.l
    public final ay c() {
        return null;
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.vector.gl.l
    public final void d(int i, ay ayVar) {
        float[] fArr = this.a;
        ayVar.q(fArr[i] - this.c, fArr[i + 1] - this.d);
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.vector.gl.l
    public final boolean e(int i, int i2) {
        float[] fArr = this.a;
        return fArr[i] == fArr[i2];
    }
}
