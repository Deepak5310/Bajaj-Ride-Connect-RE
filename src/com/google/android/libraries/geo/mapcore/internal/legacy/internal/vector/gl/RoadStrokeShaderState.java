package com.google.android.libraries.geo.mapcore.internal.legacy.internal.vector.gl;

import android.opengl.GLES20;
import com.google.android.libraries.geo.mapcore.renderer.aj;
import com.google.android.libraries.geo.mapcore.renderer.bt;
import com.google.android.libraries.geo.mapcore.renderer.bv;
import com.google.android.libraries.geo.mapcore.renderer.ee;
import com.google.android.libraries.geo.mapcore.renderer.ef;
import com.google.android.libraries.navigation.internal.yx.ar;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class RoadStrokeShaderState extends ef {
    protected float a;
    public float b;
    protected final float c;
    public float[] d;
    public final float e;
    public float f;
    public float g;
    public float h;
    public float i;
    public final float j;
    public float k;

    /* JADX INFO: compiled from: PG */
    public static class RoadShaderProgram extends ee {
        protected final boolean a;
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
        private final v l;
        private final String[] m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private final String[] f51n;

        public RoadShaderProgram() {
            v vVar = new v();
            this.l = vVar;
            this.a = bt.a().b();
            t tVar = vVar.d;
            String str = tVar.a;
            String str2 = tVar.b;
            String str3 = tVar.c;
            this.m = new String[]{str, "unused", "unused", "unused", str2, str3};
            this.f51n = new String[]{str, "unused", "unused", "unused", str2, str3, tVar.d, tVar.e};
        }

        @Override // com.google.android.libraries.geo.mapcore.renderer.ee
        public final String a() {
            return (true != this.a ? "" : "#define VERTEX_TEXTURES\n").concat(String.valueOf(this.l.b));
        }

        @Override // com.google.android.libraries.geo.mapcore.renderer.ee
        public final String b() {
            return (true != this.a ? "" : "#define VERTEX_TEXTURES\n").concat(String.valueOf(this.l.a));
        }

        @Override // com.google.android.libraries.geo.mapcore.renderer.ee
        protected final void c(bv bvVar, int i) {
            u uVar = this.l.c;
            this.x = bvVar.b(i, uVar.g);
            int iB = bvVar.b(i, uVar.k);
            this.b = iB;
            GLES20.glUniform1i(iB, 1);
            if (this.a) {
                int iB2 = bvVar.b(i, uVar.h);
                this.c = iB2;
                GLES20.glUniform1i(iB2, 0);
            }
            int iB3 = bvVar.b(i, uVar.j);
            this.d = iB3;
            GLES20.glUniform1i(iB3, 0);
            this.e = bvVar.b(i, uVar.f);
            this.g = bvVar.b(i, uVar.e);
            this.h = bvVar.b(i, uVar.d);
            this.i = bvVar.b(i, uVar.i);
            this.f = bvVar.b(i, uVar.c);
            this.j = bvVar.b(i, uVar.b);
            this.k = bvVar.b(i, uVar.a);
        }

        @Override // com.google.android.libraries.geo.mapcore.renderer.ee
        public final String[] d() {
            return this.a ? this.m : this.f51n;
        }
    }

    public RoadStrokeShaderState(Class cls, float f) {
        super(cls);
        this.d = new float[4];
        this.f = 1.0f;
        this.i = 1.0f;
        this.h = f;
        this.g = 1.0f;
        this.e = 0.1875f;
        this.c = 0.03125f;
        this.j = 0.125f;
    }

    public final void a(int i) {
        this.a = i;
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.ef
    protected final void b(bv bvVar, aj ajVar, com.google.android.libraries.geo.mapcore.renderer.u uVar, float[] fArr, float[] fArr2, float[] fArr3) {
        super.b(bvVar, ajVar, uVar, fArr, fArr2, fArr3);
        RoadShaderProgram roadShaderProgram = (RoadShaderProgram) this.l;
        ar.q(roadShaderProgram);
        GLES20.glUniform1f(roadShaderProgram.e, this.a);
        GLES20.glUniform1f(roadShaderProgram.g, this.i);
        GLES20.glUniform1f(roadShaderProgram.h, 0.03125f);
        GLES20.glUniform4fv(roadShaderProgram.i, 1, this.d, 0);
        GLES20.glUniform1f(roadShaderProgram.f, this.f);
        GLES20.glUniform1f(roadShaderProgram.j, this.b);
        GLES20.glUniform1f(roadShaderProgram.k, this.k);
    }
}
