package com.google.android.libraries.geo.mapcore.renderer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class ej {
    private static final String[] h = {"pos"};
    public final bv a;
    public final bw b;
    public final int c;
    public final int d;
    public final float[] e = new float[16];
    public final com.google.android.libraries.navigation.internal.oe.x f = new com.google.android.libraries.navigation.internal.oe.x();
    public final float[] g = new float[8];

    public ej(bv bvVar) {
        this.a = bvVar;
        bw bwVarF = bvVar.f("stencil");
        this.b = bwVarF;
        bvVar.k(bwVarF);
        bvVar.K(new float[]{0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f}, 8);
        int iA = bvVar.a("precision highp float;\nuniform mat4 matrix;\nattribute vec4 pos;\nvoid main() {\n  gl_Position = matrix * pos;\n}\n", "precision mediump float;\nvoid main() {\n  gl_FragColor = vec4(0.0, 0.0, 0.0, 0.0);\n}\n", h);
        this.c = iA;
        this.d = bvVar.b(iA, "matrix");
    }

    public static int a(int i, int i2, int i3) {
        int i4 = i % 2 == 0 ? 8 : 0;
        if (i2 % 2 == 0) {
            i4 |= 16;
        }
        return i4 | ((i3 % 8) << 5);
    }
}
