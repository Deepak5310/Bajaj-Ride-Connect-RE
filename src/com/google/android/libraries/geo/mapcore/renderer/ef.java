package com.google.android.libraries.geo.mapcore.renderer;

import android.opengl.GLES20;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public class ef {
    private int a = 0;
    protected ee l;
    protected final Class m;

    protected ef(Class cls) {
        this.m = cls;
    }

    protected void b(bv bvVar, aj ajVar, u uVar, float[] fArr, float[] fArr2, float[] fArr3) {
        ee eeVar = this.l;
        if (eeVar != null) {
            bvVar.U(eeVar.x, fArr3);
        }
    }

    public final void c(bv bvVar) {
        int i = this.a + 1;
        this.a = i;
        if (i == 1) {
            ee eeVarG = bvVar.g(this.m);
            this.l = eeVarG;
            if (eeVarG.w != 0) {
                return;
            }
            eeVarG.w = bvVar.a(eeVarG.b(), eeVarG.a(), eeVarG.d());
            int[] iArr = {0};
            GLES20.glGetIntegerv(35725, iArr, 0);
            bvVar.j(eeVarG.w);
            eeVarG.c(bvVar, eeVarG.w);
            bvVar.j(iArr[0]);
        }
    }

    public final boolean d() {
        return this.a > 0;
    }

    public final void e() {
        com.google.android.libraries.navigation.internal.yx.ar.k(this.a > 0);
        int i = this.a - 1;
        this.a = i;
        if (i == 0) {
            this.l = null;
        }
    }
}
