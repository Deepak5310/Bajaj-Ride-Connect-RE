package com.google.android.libraries.geo.mapcore.renderer;

import android.opengl.GLES20;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class ex extends ef {
    public float a;
    private final float[] b;

    public ex() {
        super(TextureShaderState$TextureShaderProgram.class);
        float[] fArr = new float[4];
        this.b = fArr;
        this.a = 0.0f;
        System.arraycopy(new float[]{1.0f, 1.0f, 1.0f, 1.0f}, 0, fArr, 0, 4);
    }

    public final void a(float f) {
        if (d()) {
            ea eaVar = ea.INVALID;
        }
        float[] fArr = this.b;
        fArr[0] = 1.0f;
        fArr[1] = 1.0f;
        fArr[2] = 1.0f;
        fArr[3] = f;
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.ef
    protected final void b(bv bvVar, aj ajVar, u uVar, float[] fArr, float[] fArr2, float[] fArr3) {
        super.b(bvVar, ajVar, uVar, fArr, fArr2, fArr3);
        TextureShaderState$TextureShaderProgram textureShaderState$TextureShaderProgram = (TextureShaderState$TextureShaderProgram) this.l;
        com.google.android.libraries.navigation.internal.yx.ar.q(textureShaderState$TextureShaderProgram);
        GLES20.glUniform1i(textureShaderState$TextureShaderProgram.b, 0);
        GLES20.glUniform1f(textureShaderState$TextureShaderProgram.c, this.a);
        ey eyVarC = ajVar.c(0);
        if (eyVarC != null) {
            bv.T(textureShaderState$TextureShaderProgram.a, eyVarC.d.a);
        }
        bv.V(this.b);
    }

    public final void f(float f, float f2, float f3, float f4) {
        if (d()) {
            ea eaVar = ea.INVALID;
        }
        float[] fArr = this.b;
        fArr[0] = f;
        fArr[1] = f2;
        fArr[2] = f3;
        fArr[3] = f4;
    }
}
