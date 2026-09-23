package com.google.android.libraries.geo.mapcore.internal.legacy.vector.gl.drawable;

import android.opengl.GLES20;
import android.view.animation.AnimationUtils;
import com.google.android.libraries.geo.mapcore.renderer.bv;
import com.google.android.libraries.geo.mapcore.renderer.ee;
import com.google.android.libraries.geo.mapcore.renderer.ef;
import com.google.android.libraries.geo.mapcore.renderer.ey;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class GmmTextureStyleIdShaderState extends ef {
    public int a;
    public final com.google.android.libraries.geo.mapcore.renderer.az b;
    public final int[] c;

    /* JADX INFO: compiled from: PG */
    public static class GmmTextureStyleIdShaderProgram extends ee {
        public int a;
        public int b;
        public int c;
        public int d;
        private final av e;
        private final String[] f;

        public GmmTextureStyleIdShaderProgram() {
            av avVar = new av();
            this.e = avVar;
            at atVar = avVar.d;
            this.f = new String[]{atVar.a, "unused", "unused", atVar.b, atVar.c};
        }

        @Override // com.google.android.libraries.geo.mapcore.renderer.ee
        public final String a() {
            return this.e.b;
        }

        @Override // com.google.android.libraries.geo.mapcore.renderer.ee
        public final String b() {
            return this.e.a;
        }

        @Override // com.google.android.libraries.geo.mapcore.renderer.ee
        protected final void c(bv bvVar, int i) {
            au auVar = this.e.c;
            this.x = bvVar.b(i, auVar.a);
            this.a = bvVar.b(i, auVar.b);
            this.b = bvVar.b(i, auVar.c);
            this.c = bvVar.b(i, auVar.d);
            this.d = bvVar.b(i, auVar.e);
        }

        @Override // com.google.android.libraries.geo.mapcore.renderer.ee
        public final String[] d() {
            return this.f;
        }
    }

    public GmmTextureStyleIdShaderState() {
        super(GmmTextureStyleIdShaderProgram.class);
        this.b = new com.google.android.libraries.geo.mapcore.renderer.az(true);
        this.c = new int[8];
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.ef
    protected final void b(bv bvVar, com.google.android.libraries.geo.mapcore.renderer.aj ajVar, com.google.android.libraries.geo.mapcore.renderer.u uVar, float[] fArr, float[] fArr2, float[] fArr3) {
        super.b(bvVar, ajVar, uVar, fArr, fArr2, fArr3);
        GmmTextureStyleIdShaderProgram gmmTextureStyleIdShaderProgram = (GmmTextureStyleIdShaderProgram) this.l;
        com.google.android.libraries.navigation.internal.yx.ar.q(gmmTextureStyleIdShaderProgram);
        ey eyVarC = ajVar.c(0);
        if (eyVarC != null) {
            bv.T(gmmTextureStyleIdShaderProgram.a, eyVarC.d.a);
        }
        bvVar.R(gmmTextureStyleIdShaderProgram.b, this.a, this.c);
        com.google.android.libraries.geo.mapcore.renderer.az azVar = this.b;
        long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        if (!azVar.c(jCurrentAnimationTimeMillis)) {
            bvVar.j = true;
        }
        GLES20.glUniform1f(gmmTextureStyleIdShaderProgram.c, azVar.a(jCurrentAnimationTimeMillis));
        GLES20.glUniform1i(gmmTextureStyleIdShaderProgram.d, 0);
    }
}
