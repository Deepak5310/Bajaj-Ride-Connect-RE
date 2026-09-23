package com.google.android.libraries.geo.mapcore.internal.legacy.internal.vector.gl;

import android.opengl.GLES20;
import com.google.android.libraries.geo.mapcore.renderer.aj;
import com.google.android.libraries.geo.mapcore.renderer.bv;
import com.google.android.libraries.geo.mapcore.renderer.cs;
import com.google.android.libraries.geo.mapcore.renderer.ee;
import com.google.android.libraries.geo.mapcore.renderer.ey;
import com.google.android.libraries.navigation.internal.yx.ar;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class ClientLineStampShaderState extends e {
    private float i;
    private final float[] j;
    private final com.google.android.libraries.navigation.internal.ol.q k;

    /* JADX INFO: compiled from: PG */
    public static class ClientInjectedStrokeShader extends ee {
        protected int a;
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
        protected int l;
        protected int m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        protected int f50n;
        protected int o;
        protected int p;
        protected int q;
        protected int r;
        protected int s;
        protected int t;
        protected int u;
        protected int v;
        private final h y;
        private final String[] z;

        public ClientInjectedStrokeShader() {
            h hVar = new h();
            this.y = hVar;
            f fVar = hVar.d;
            this.z = new String[]{fVar.a, "unused", "unused", "unused", fVar.b, fVar.c};
        }

        @Override // com.google.android.libraries.geo.mapcore.renderer.ee
        public final String a() {
            return this.y.b;
        }

        @Override // com.google.android.libraries.geo.mapcore.renderer.ee
        public final String b() {
            return this.y.a;
        }

        @Override // com.google.android.libraries.geo.mapcore.renderer.ee
        protected final void c(bv bvVar, int i) {
            g gVar = this.y.c;
            this.e = bvVar.b(i, gVar.o);
            this.a = bvVar.b(i, gVar.k);
            this.b = bvVar.b(i, gVar.l);
            this.c = bvVar.b(i, gVar.m);
            this.d = bvVar.b(i, gVar.f53n);
            this.f = bvVar.b(i, gVar.j);
            GLES20.glUniform1i(this.e, 5);
            GLES20.glUniform1i(this.a, 1);
            GLES20.glUniform1i(this.b, 2);
            GLES20.glUniform1i(this.c, 3);
            GLES20.glUniform1i(this.d, 4);
            int i2 = this.f;
            int i3 = i.e;
            bvVar.R(i2, 7, i.a);
            this.g = bvVar.b(i, gVar.a);
            this.h = bvVar.b(i, gVar.b);
            this.x = bvVar.b(i, gVar.c);
            this.i = bvVar.b(i, gVar.d);
            this.j = bvVar.b(i, gVar.e);
            this.k = bvVar.b(i, gVar.f);
            this.l = bvVar.b(i, gVar.g);
            this.m = bvVar.b(i, gVar.i);
            this.f50n = bvVar.b(i, gVar.h);
            this.o = bvVar.b(i, gVar.w);
            this.p = bvVar.b(i, gVar.p);
            this.q = bvVar.b(i, gVar.q);
            this.r = bvVar.b(i, gVar.r);
            this.s = bvVar.b(i, gVar.s);
            this.t = bvVar.b(i, gVar.t);
            this.u = bvVar.b(i, gVar.u);
            this.v = bvVar.b(i, gVar.v);
        }

        @Override // com.google.android.libraries.geo.mapcore.renderer.ee
        public final String[] d() {
            return this.z;
        }
    }

    public ClientLineStampShaderState(float f, com.google.android.libraries.navigation.internal.qq.d dVar, com.google.android.libraries.navigation.internal.ol.q qVar) {
        super(ClientInjectedStrokeShader.class, f, dVar);
        this.i = -3.4028235E38f;
        this.j = new float[16];
        this.k = qVar;
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.ef
    protected final void b(bv bvVar, aj ajVar, com.google.android.libraries.geo.mapcore.renderer.u uVar, float[] fArr, float[] fArr2, float[] fArr3) {
        cs csVar;
        int i;
        super.b(bvVar, this.e, uVar, fArr, fArr2, fArr3);
        ClientInjectedStrokeShader clientInjectedStrokeShader = (ClientInjectedStrokeShader) this.l;
        ar.q(clientInjectedStrokeShader);
        com.google.android.libraries.navigation.internal.ol.q qVar = this.k;
        if (qVar != null) {
            this.i = qVar.b();
        }
        bvVar.U(clientInjectedStrokeShader.g, fArr);
        bvVar.U(clientInjectedStrokeShader.h, fArr2);
        GLES20.glUniform1f(clientInjectedStrokeShader.v, this.i);
        com.google.android.libraries.navigation.internal.qq.d dVar = this.e;
        com.google.android.libraries.navigation.internal.qq.c cVar = (com.google.android.libraries.navigation.internal.qq.c) dVar.b.get(dVar.c);
        for (int i2 = 0; i2 < 8; i2++) {
            float[] fArr4 = cVar.b;
            if (i2 >= 8) {
                break;
            }
            this.j[i2 + i2] = fArr4[i2];
        }
        GLES20.glUniform2fv(clientInjectedStrokeShader.i, 8, this.j, 0);
        GLES20.glUniform1f(clientInjectedStrokeShader.j, this.b);
        float f = fArr[0];
        GLES20.glUniform1f(clientInjectedStrokeShader.k, 5.368709E8f * f);
        GLES20.glUniform1f(clientInjectedStrokeShader.l, f * 1.0737418E9f);
        float f2 = 1.0f;
        GLES20.glUniform1f(clientInjectedStrokeShader.f50n, 1.0f);
        GLES20.glUniform1i(clientInjectedStrokeShader.m, this.h ? 1 : 0);
        GLES20.glUniform1i(clientInjectedStrokeShader.o, 0);
        GLES20.glUniform1f(clientInjectedStrokeShader.p, this.f);
        GLES20.glUniform1f(clientInjectedStrokeShader.q, this.g);
        int i3 = clientInjectedStrokeShader.r;
        ey eyVarC = this.e.c(3);
        if (eyVarC != null && (csVar = eyVarC.b) != null && (i = csVar.g) > 0) {
            f2 = csVar.f / i;
        }
        GLES20.glUniform1f(i3, f2);
        GLES20.glUniform1i(clientInjectedStrokeShader.s, this.e.c);
        GLES20.glUniform1f(clientInjectedStrokeShader.t, cVar.c);
        GLES20.glUniform1f(clientInjectedStrokeShader.u, cVar.d);
    }
}
