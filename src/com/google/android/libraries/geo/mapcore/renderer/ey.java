package com.google.android.libraries.geo.mapcore.renderer;

import android.graphics.Bitmap;
import android.opengl.ETC1Util;
import android.opengl.GLUtils;
import java.io.ByteArrayInputStream;
import java.io.IOException;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public class ey {
    public final String a;
    public cs b;
    public final int f;
    private bv g;
    private final int i;
    bw c = bw.a;
    private int h = 0;
    public final com.google.android.libraries.navigation.internal.rm.b d = new com.google.android.libraries.navigation.internal.rm.b();
    public long e = -9223372036854775807L;

    public ey(String str, cs csVar, int i, int i2) {
        this.b = null;
        this.a = str;
        this.b = csVar;
        this.i = i;
        if (csVar == null || csVar.j) {
            this.f = i2;
        } else {
            this.f = 1;
        }
    }

    public final void b(bv bvVar) {
        int i;
        int i2 = this.h + 1;
        this.h = i2;
        if (i2 == 1) {
            bw bwVarE = bvVar.e(this.a);
            this.c = bwVarE;
            cs csVar = this.b;
            if (csVar != null) {
                int i3 = this.i;
                int i4 = this.f;
                h hVar = csVar.d;
                if (hVar != null) {
                    csVar.a = hVar.a();
                } else {
                    aa aaVar = csVar.k;
                    if (aaVar != null) {
                        ab abVar = aaVar.a;
                        aaVar.a = null;
                        csVar.c = abVar;
                    }
                }
                Bitmap bitmap = csVar.a;
                if (bitmap != null) {
                    bw bwVar = bvVar.f77n[0];
                    bvVar.B(1, bwVarE);
                    GLUtils.texImage2D(3553, 0, bitmap, 0);
                    bvVar.C(i3, i4);
                    bvVar.B(1, bwVar);
                    bwVarE.e = bitmap.getWidth() * bitmap.getHeight() * 4;
                    h hVar2 = csVar.d;
                    if (hVar2 != null) {
                        hVar2.c();
                        csVar.a = null;
                    }
                } else {
                    byte[] bArr = csVar.b;
                    if (bArr != null) {
                        int i5 = csVar.e;
                        if (i5 == 1) {
                            i = 6409;
                        } else if (i5 == 2) {
                            i = 6410;
                        } else if (i5 == 3) {
                            i = 6407;
                        } else {
                            if (i5 != 4) {
                                throw new IllegalArgumentException("Bad number of channels in ImageData buffer");
                            }
                            i = 6408;
                        }
                        bvVar.E(bwVarE, i, csVar.h, csVar.i, i3, i4, bvVar.F(bArr, bArr.length));
                    } else {
                        ab abVar2 = csVar.c;
                        if (abVar2 != null) {
                            bw bwVar2 = bvVar.f77n[0];
                            bvVar.B(1, bwVarE);
                            byte[] bArr2 = abVar2.c;
                            try {
                                ETC1Util.loadTexture(3553, 0, 0, 6408, 33635, new ByteArrayInputStream(bArr2));
                            } catch (IOException unused) {
                                ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F((char) 1358)).p("GlContext error in uploadCompressedTexture:");
                            }
                            bvVar.C(i3, i4);
                            bvVar.B(1, bwVar2);
                            bwVarE.e = bArr2.length;
                            csVar.c = null;
                        } else {
                            bvVar.D(bwVarE, csVar.f, csVar.g, i3, i4);
                        }
                    }
                }
            }
            this.g = bvVar;
        }
    }

    public final void c(boolean z) {
        com.google.android.libraries.navigation.internal.yx.ar.k(this.h > 0);
        int i = this.h - 1;
        this.h = i;
        if (i != 0 || z) {
            return;
        }
        bv bvVar = this.g;
        com.google.android.libraries.navigation.internal.yx.ar.q(bvVar);
        bvVar.m(this.c);
    }

    public final void d(cs csVar) {
        if (e()) {
            throw new RuntimeException("Must be called BEFORE set live");
        }
        this.b = csVar;
    }

    public final boolean e() {
        return this.h > 0;
    }
}
