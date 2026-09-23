package com.google.android.libraries.geo.mapcore.internal.legacy.internal.vector.gl;

import android.opengl.GLES20;
import com.google.android.libraries.geo.mapcore.renderer.aj;
import com.google.android.libraries.geo.mapcore.renderer.bv;
import com.google.android.libraries.geo.mapcore.renderer.ee;
import com.google.android.libraries.geo.mapcore.renderer.ef;
import com.google.android.libraries.navigation.internal.yx.ar;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class RoadStrokePointSpriteShaderState extends ef {
    public boolean a;
    private final com.google.android.libraries.navigation.internal.ol.q b;
    private float c;

    /* JADX INFO: compiled from: PG */
    public static class StrokeShaderProgram extends ee {
        protected int a;
        protected int b;
        protected int c;
        protected int d;
        protected int e;
        protected int f;
        protected int g;
        private final s h;
        private final String[] i;

        public StrokeShaderProgram() {
            s sVar = new s();
            this.h = sVar;
            q qVar = sVar.d;
            this.i = new String[]{qVar.a, "unused", "unused", qVar.b, "unused", "unused"};
        }

        @Override // com.google.android.libraries.geo.mapcore.renderer.ee
        public final String a() {
            return this.h.b;
        }

        @Override // com.google.android.libraries.geo.mapcore.renderer.ee
        public final String b() {
            return this.h.a;
        }

        @Override // com.google.android.libraries.geo.mapcore.renderer.ee
        protected final void c(bv bvVar, int i) {
            r rVar = this.h.c;
            this.x = bvVar.b(i, rVar.a);
            this.a = bvVar.b(i, rVar.b);
            this.b = bvVar.b(i, rVar.c);
            this.c = bvVar.b(i, rVar.d);
            this.d = bvVar.b(i, rVar.e);
            this.e = bvVar.b(i, rVar.f);
            this.f = bvVar.b(i, rVar.g);
            this.g = bvVar.b(i, rVar.h);
            GLES20.glUniform1i(this.f, 3);
        }

        @Override // com.google.android.libraries.geo.mapcore.renderer.ee
        public final String[] d() {
            return this.i;
        }
    }

    public RoadStrokePointSpriteShaderState() {
        this(null);
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.ef
    protected final void b(bv bvVar, aj ajVar, com.google.android.libraries.geo.mapcore.renderer.u uVar, float[] fArr, float[] fArr2, float[] fArr3) {
        super.b(bvVar, ajVar, uVar, fArr, fArr2, fArr3);
        StrokeShaderProgram strokeShaderProgram = (StrokeShaderProgram) this.l;
        ar.q(strokeShaderProgram);
        bvVar.U(strokeShaderProgram.a, fArr);
        bvVar.U(strokeShaderProgram.b, fArr2);
        GLES20.glUniform1i(strokeShaderProgram.e, this.a ? 1 : 0);
        float f = fArr[0];
        GLES20.glUniform1f(strokeShaderProgram.c, 5.368709E8f * f);
        GLES20.glUniform1f(strokeShaderProgram.d, f * 1.0737418E9f);
        com.google.android.libraries.navigation.internal.ol.q qVar = this.b;
        if (qVar != null) {
            this.c = qVar.b();
        }
        GLES20.glUniform1f(strokeShaderProgram.g, this.c);
    }

    public RoadStrokePointSpriteShaderState(com.google.android.libraries.navigation.internal.ol.q qVar) {
        super(StrokeShaderProgram.class);
        this.a = false;
        this.c = -3.4028235E38f;
        this.b = qVar;
    }
}
