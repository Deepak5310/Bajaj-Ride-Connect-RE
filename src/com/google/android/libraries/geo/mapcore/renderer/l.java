package com.google.android.libraries.geo.mapcore.renderer;

import android.opengl.GLES20;
import androidx.core.view.ViewCompat;
import com.drew.metadata.exif.makernotes.FujifilmMakernoteDirectory;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class l {
    private static final String[] a = {"pos"};
    private final bv b;
    private final int c;
    private final bw d;
    private final bw e;
    private final int f;
    private final int g;
    private final int h;
    private final int i;
    private final int j;
    private final int k;
    private final int l;
    private final int m;

    public l(bv bvVar) {
        this.b = bvVar;
        int iA = bvVar.a("precision highp float;attribute vec2 pos;uniform vec2 blitSourceSize;uniform float blitSourceScale;uniform vec2 blitTargetSize;uniform vec2 blitTargetPos;uniform float blitFlipY;varying vec2 texCoord;void main(void) {  vec2 pixelPos = (pos * blitSourceSize * blitSourceScale) + blitTargetPos;  vec2 devicePos = 2.0 * (pixelPos / blitTargetSize) - 1.0;  devicePos.y *= blitFlipY;  gl_Position = vec4(devicePos, 0.0, 1.0);  texCoord = pos;}", "precision highp float;varying vec2 texCoord;uniform sampler2D blitTextureUnit;uniform float blitAlphaScale;uniform float blitAlphaBias;void main(void) {  gl_FragColor = texture2D(blitTextureUnit, texCoord);  gl_FragColor.a = gl_FragColor.a * blitAlphaScale + blitAlphaBias;}", a);
        this.c = iA;
        bvVar.j(iA);
        this.f = bvVar.b(iA, "blitSourceSize");
        this.g = bvVar.b(iA, "blitSourceScale");
        this.h = bvVar.b(iA, "blitTargetSize");
        this.i = bvVar.b(iA, "blitTargetPos");
        this.j = bvVar.b(iA, "blitFlipY");
        this.k = bvVar.b(iA, "blitTextureUnit");
        this.l = bvVar.b(iA, "blitAlphaScale");
        this.m = bvVar.b(iA, "blitAlphaBias");
        bw bwVarF = bvVar.f("blitter_square");
        this.d = bwVarF;
        bvVar.k(bwVarF);
        bvVar.K(new float[]{0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f}, 8);
        bw bwVarE = bvVar.e("checker");
        this.e = bwVarE;
        bvVar.Y(bwVarE, 4, 4, 1, 2, new int[]{-1, ViewCompat.MEASURED_STATE_MASK, -1, ViewCompat.MEASURED_STATE_MASK, ViewCompat.MEASURED_STATE_MASK, -1, ViewCompat.MEASURED_STATE_MASK, -1, -1, ViewCompat.MEASURED_STATE_MASK, -1, ViewCompat.MEASURED_STATE_MASK, ViewCompat.MEASURED_STATE_MASK, -1, ViewCompat.MEASURED_STATE_MASK, -1});
    }

    public final void a(bw bwVar, double d) {
        this.b.r(770, 771);
        this.b.w(true, 517, 2, 2);
        this.b.t(519);
        this.b.j(this.c);
        this.b.B(1, bwVar);
        GLES20.glUniform2f(this.f, 1.0f, 1.0f);
        GLES20.glUniform1f(this.g, 1.0f);
        GLES20.glUniform2f(this.h, 1.0f, 1.0f);
        GLES20.glUniform2f(this.i, 0.0f, 0.0f);
        GLES20.glUniform1f(this.j, -1.0f);
        GLES20.glUniform1i(this.k, 0);
        GLES20.glUniform1f(this.l, (float) d);
        GLES20.glUniform1f(this.m, 0.0f);
        this.b.k(this.d);
        this.b.o(0);
        int i = bt.a().f;
        for (int i2 = 1; i2 < i; i2++) {
            this.b.n(i2);
        }
        GLES20.glVertexAttribPointer(0, 2, FujifilmMakernoteDirectory.TAG_MAX_APERTURE_AT_MIN_FOCAL, false, 0, 0);
        this.b.P(5, 4);
    }
}
