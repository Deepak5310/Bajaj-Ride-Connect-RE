package com.google.android.libraries.geo.mapcore.renderer;

import android.opengl.GLES20;
import com.drew.metadata.exif.makernotes.FujifilmMakernoteDirectory;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class ei implements aj {
    private static final fg a = new fg(Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);
    private final ax b;
    private final int c;
    private final int d;
    private final int e;
    private final af f;
    private final int g;
    private int h = 0;
    private boolean i = false;

    public ei(ax axVar, int i, int i2, int i3, af afVar) {
        this.b = axVar;
        this.c = i;
        this.d = i2;
        this.e = i3;
        this.f = afVar;
        this.g = ej.a(i, i2, i3);
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.aj
    public final void A(bv bvVar) {
        this.h++;
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.aj
    public final void C(boolean z) {
        this.i = z;
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.aj
    public final ae E() {
        return ae.a;
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.aj
    public final fg F() {
        return a;
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.aj
    public final void G(aj ajVar, aj ajVar2, u uVar) {
        ej ejVar;
        ej ejVar2 = this.b.t;
        if (ejVar2 == null) {
            return;
        }
        if (!(ajVar instanceof ei)) {
            ejVar2.a.j(ejVar2.c);
            ejVar2.a.r(0, 1);
            ejVar2.a.t(519);
            ejVar2.a.v(0.0f, 0.0f);
            ejVar2.a.k(ejVar2.b);
            ejVar2.a.o(0);
            int i = bt.a().f;
            for (int i2 = 1; i2 < i; i2++) {
                ejVar2.a.n(i2);
            }
            GLES20.glVertexAttribPointer(0, 2, FujifilmMakernoteDirectory.TAG_MAX_APERTURE_AT_MIN_FOCAL, false, 0, 0);
        }
        if (this.i) {
            int i3 = this.c;
            int i4 = this.d;
            int i5 = this.e;
            ejVar2.a.w(true, 519, this.g, 248);
            float[] fArr = ejVar2.e;
            com.google.android.libraries.navigation.internal.oe.x xVar = ejVar2.f;
            float[] fArr2 = ejVar2.g;
            v vVar = (v) uVar.e.get();
            if (!u.D(vVar.b / 2.0f, vVar.c / 2.0f, vVar.h, vVar.i, vVar.k, vVar.l, vVar.m, vVar.y, xVar, fArr2)) {
                xVar.J(vVar.h, vVar.i);
            }
            int i6 = 1073741824 >> i5;
            int i7 = i6 >> 1;
            int i8 = xVar.a;
            int i9 = i8 - vVar.h;
            int i10 = (((i3 * i6) - 536870912) + i7) - i8;
            int i11 = (-(((i4 + 1) * i6) - 536870912)) - vVar.i;
            float f = vVar.t;
            float f2 = i6 * f;
            fArr[0] = f2;
            fArr[1] = 0.0f;
            fArr[2] = 0.0f;
            fArr[3] = 0.0f;
            fArr[4] = 0.0f;
            fArr[5] = f2;
            fArr[6] = 0.0f;
            fArr[7] = 0.0f;
            fArr[8] = 0.0f;
            fArr[9] = 0.0f;
            fArr[10] = f2;
            fArr[11] = 0.0f;
            fArr[12] = (com.google.android.libraries.navigation.internal.oe.x.s(i10) + (i9 - i7)) * f;
            fArr[13] = i11 * f;
            fArr[14] = 0.0f;
            fArr[15] = 1.0f;
            com.google.android.libraries.navigation.internal.rq.f.c(fArr, vVar.w, fArr);
            ejVar = ejVar2;
            ejVar.a.U(ejVar.d, ejVar.e);
            ejVar.a.P(5, 4);
        } else {
            ejVar = ejVar2;
        }
        if (ajVar2 instanceof ei) {
            return;
        }
        ejVar.a.n(0);
        ejVar.a.z();
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.aj
    public final void b(long j) {
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.aj
    public final ey c(int i) {
        throw null;
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.aj
    public final void d(boolean z) {
        this.h--;
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.aj
    public final Cdo g() {
        return null;
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.aj
    public final int h() {
        return this.e;
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.aj
    public final af i() {
        return this.f;
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.aj
    public final boolean n() {
        return true;
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.aj
    public final boolean o() {
        return this.h > 0;
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.aj
    public final boolean p() {
        return true;
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.aj
    public final dy y() {
        return this.f.c();
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.aj
    public final void z() {
    }
}
