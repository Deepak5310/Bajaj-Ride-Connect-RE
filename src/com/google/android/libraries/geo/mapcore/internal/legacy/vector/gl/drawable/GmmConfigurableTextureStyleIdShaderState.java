package com.google.android.libraries.geo.mapcore.internal.legacy.vector.gl.drawable;

import android.opengl.GLES20;
import androidx.core.math.MathUtils;
import com.google.android.libraries.geo.mapcore.internal.model.cd;
import com.google.android.libraries.geo.mapcore.internal.model.ce;
import com.google.android.libraries.geo.mapcore.renderer.bv;
import com.google.android.libraries.geo.mapcore.renderer.ee;
import com.google.android.libraries.geo.mapcore.renderer.ef;
import com.google.android.libraries.geo.mapcore.renderer.ep;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class GmmConfigurableTextureStyleIdShaderState extends ef {
    private static final int[] b = new int[0];
    protected float a;
    private int[] c;
    private int[] d;
    private int e;
    private boolean f;
    private ce g;
    private ep h;

    /* JADX INFO: compiled from: PG */
    public static class GmmConfigurableTextureStyleIdShaderProgram extends ee {
        public int a;
        protected int b;
        protected int c;
        protected int d;
        protected int e;
        protected int f;
        protected int g;
        protected int h;
        protected int i;
        protected int j;
        protected int k;
        private final am l;
        private final String[] m;

        public GmmConfigurableTextureStyleIdShaderProgram() {
            am amVar = new am();
            this.l = amVar;
            ak akVar = amVar.d;
            this.m = new String[]{akVar.a, "unused", "unused", "unused", akVar.b};
        }

        @Override // com.google.android.libraries.geo.mapcore.renderer.ee
        public final String a() {
            return this.l.b;
        }

        @Override // com.google.android.libraries.geo.mapcore.renderer.ee
        public final String b() {
            return this.l.a;
        }

        @Override // com.google.android.libraries.geo.mapcore.renderer.ee
        protected final void c(bv bvVar, int i) {
            al alVar = this.l.c;
            this.a = bvVar.b(i, alVar.a);
            this.b = bvVar.b(i, alVar.b);
            this.x = bvVar.b(i, alVar.c);
            this.c = bvVar.b(i, alVar.d);
            this.d = bvVar.b(i, alVar.e);
            this.e = bvVar.b(i, alVar.f);
            this.f = bvVar.b(i, alVar.g);
            this.g = bvVar.b(i, alVar.h);
            this.h = bvVar.b(i, alVar.i);
            this.i = bvVar.b(i, alVar.j);
            this.j = bvVar.b(i, alVar.k);
            this.k = bvVar.b(i, alVar.l);
        }

        @Override // com.google.android.libraries.geo.mapcore.renderer.ee
        public final String[] d() {
            return this.m;
        }
    }

    public GmmConfigurableTextureStyleIdShaderState() {
        super(GmmConfigurableTextureStyleIdShaderProgram.class);
        int[] iArr = b;
        this.c = iArr;
        this.d = iArr;
    }

    public final void a(List list, ce ceVar, ep epVar) {
        this.f = false;
        this.g = ceVar;
        this.h = epVar;
        int i = this.e;
        int iMin = Math.min(list.size(), 64);
        this.e = iMin;
        if (iMin != i) {
            this.c = new int[iMin * 4];
            this.d = new int[iMin * 8];
        }
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < this.e; i4++) {
            com.google.android.libraries.navigation.internal.qh.b bVar = (com.google.android.libraries.navigation.internal.qh.b) list.get(i4);
            int i5 = bVar.a;
            int i6 = bVar.b;
            int[] iArr = this.c;
            iArr[i2] = i5 >>> 16;
            iArr[i2 + 1] = (char) i5;
            iArr[i2 + 2] = i6 >>> 16;
            iArr[i2 + 3] = (char) i6;
            if (bVar.d || bVar.c) {
                this.f = true;
                int[] iArr2 = this.d;
                iArr2[i3] = bVar.f555n;
                iArr2[i3 + 1] = com.google.android.libraries.navigation.internal.qh.b.a(bVar.l, bVar.m);
                iArr2[i3 + 2] = bVar.j;
                iArr2[i3 + 3] = bVar.k;
                iArr2[i3 + 4] = bVar.i;
                iArr2[i3 + 5] = com.google.android.libraries.navigation.internal.qh.b.a(bVar.g, bVar.h);
                int i7 = i3 + 7;
                iArr2[i3 + 6] = bVar.e;
                i3 += 8;
                iArr2[i7] = bVar.f;
            } else {
                int i8 = 0;
                while (i8 < 8) {
                    this.d[i3] = 0;
                    i8++;
                    i3++;
                }
            }
            i2 += 4;
        }
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.ef
    protected final void b(bv bvVar, com.google.android.libraries.geo.mapcore.renderer.aj ajVar, com.google.android.libraries.geo.mapcore.renderer.u uVar, float[] fArr, float[] fArr2, float[] fArr3) {
        super.b(bvVar, ajVar, uVar, fArr, fArr2, fArr3);
        GmmConfigurableTextureStyleIdShaderProgram gmmConfigurableTextureStyleIdShaderProgram = (GmmConfigurableTextureStyleIdShaderProgram) this.l;
        com.google.android.libraries.navigation.internal.yx.ar.q(gmmConfigurableTextureStyleIdShaderProgram);
        ep epVar = this.h;
        if (!this.f || this.g == null || epVar == null) {
            GLES20.glUniform1i(gmmConfigurableTextureStyleIdShaderProgram.a, 0);
        } else {
            GLES20.glUniform1i(gmmConfigurableTextureStyleIdShaderProgram.a, 1);
            float f = this.a;
            float fFloor = (float) Math.floor(f);
            float f2 = f - fFloor;
            float fPow = (float) Math.pow(2.0d, f2);
            float fClamp = MathUtils.clamp(((-0.75f) + f2) * 4.0f, 0.0f, 1.0f);
            GLES20.glUniform1f(gmmConfigurableTextureStyleIdShaderProgram.h, f2);
            GLES20.glUniform4f(gmmConfigurableTextureStyleIdShaderProgram.i, fClamp, fPow, 1.0f - fClamp, 1.0f - f2);
            int iMax = 1 << Math.max(this.g.a(), 4);
            cd cdVar = this.g.a;
            GLES20.glUniform1f(gmmConfigurableTextureStyleIdShaderProgram.f, 1.0f / iMax);
            GLES20.glUniform2f(gmmConfigurableTextureStyleIdShaderProgram.e, cdVar.b, cdVar.c);
            GLES20.glUniform1f(gmmConfigurableTextureStyleIdShaderProgram.g, (float) Math.pow(2.0d, fFloor - cdVar.a));
            GLES20.glUniform2f(gmmConfigurableTextureStyleIdShaderProgram.k, 1.0f / epVar.d(), 1.0f / epVar.c());
            bvVar.B(7, epVar.e());
            GLES20.glUniform1i(gmmConfigurableTextureStyleIdShaderProgram.j, 6);
        }
        bv.S(gmmConfigurableTextureStyleIdShaderProgram.c, this.e, this.c);
        int i = gmmConfigurableTextureStyleIdShaderProgram.d;
        int i2 = this.e;
        bv.S(i, i2 + i2, this.d);
        GLES20.glUniform1f(gmmConfigurableTextureStyleIdShaderProgram.b, this.a);
    }
}
