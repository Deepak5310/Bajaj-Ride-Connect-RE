package com.google.android.libraries.geo.mapcore.internal.legacy.vector.gl.drawable;

import android.opengl.GLES20;
import com.google.android.libraries.geo.mapcore.renderer.bt;
import com.google.android.libraries.geo.mapcore.renderer.bv;
import com.google.android.libraries.geo.mapcore.renderer.cs;
import com.google.android.libraries.geo.mapcore.renderer.ee;
import com.google.android.libraries.geo.mapcore.renderer.ef;
import com.google.android.libraries.geo.mapcore.renderer.ey;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class GmmStyleTextureShaderState extends ef {
    protected float a;

    /* JADX INFO: compiled from: PG */
    public static class StyleTextureShaderProgram extends ee {
        protected final boolean a;
        protected int b;
        protected int c;
        protected int d;
        private final as e;
        private final String[] f;

        public StyleTextureShaderProgram() {
            as asVar = new as();
            this.e = asVar;
            this.a = bt.a().b();
            aq aqVar = asVar.d;
            this.f = new String[]{aqVar.a, "unused", "unused", "unused", aqVar.b};
        }

        @Override // com.google.android.libraries.geo.mapcore.renderer.ee
        public final String a() {
            return (true != this.a ? "" : "#define VERTEX_TEXTURES\n").concat(String.valueOf(this.e.b));
        }

        @Override // com.google.android.libraries.geo.mapcore.renderer.ee
        public final String b() {
            return (true != this.a ? "" : "#define VERTEX_TEXTURES\n").concat(String.valueOf(this.e.a));
        }

        @Override // com.google.android.libraries.geo.mapcore.renderer.ee
        protected final void c(bv bvVar, int i) {
            ar arVar = this.e.c;
            this.x = bvVar.b(i, arVar.a);
            this.d = bvVar.b(i, arVar.b);
            this.b = bvVar.b(i, arVar.c);
            this.c = bvVar.b(i, arVar.d);
        }

        @Override // com.google.android.libraries.geo.mapcore.renderer.ee
        public final String[] d() {
            return this.f;
        }
    }

    protected GmmStyleTextureShaderState() {
        super(StyleTextureShaderProgram.class);
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.ef
    protected final void b(bv bvVar, com.google.android.libraries.geo.mapcore.renderer.aj ajVar, com.google.android.libraries.geo.mapcore.renderer.u uVar, float[] fArr, float[] fArr2, float[] fArr3) {
        cs csVar;
        super.b(bvVar, ajVar, uVar, fArr, fArr2, fArr3);
        StyleTextureShaderProgram styleTextureShaderProgram = (StyleTextureShaderProgram) this.l;
        com.google.android.libraries.navigation.internal.yx.ar.q(styleTextureShaderProgram);
        ey eyVarC = ajVar.c(0);
        if (eyVarC != null && (csVar = eyVarC.b) != null) {
            GLES20.glUniform2f(styleTextureShaderProgram.b, 1.0f / csVar.f, 1.0f / csVar.g);
        }
        GLES20.glUniform1f(styleTextureShaderProgram.d, this.a);
        GLES20.glUniform1i(styleTextureShaderProgram.c, 0);
    }
}
