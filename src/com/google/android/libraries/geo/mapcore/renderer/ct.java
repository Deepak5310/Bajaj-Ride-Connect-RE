package com.google.android.libraries.geo.mapcore.renderer;

import android.opengl.GLES20;
import com.drew.metadata.exif.makernotes.FujifilmMakernoteDirectory;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class ct extends al implements z {
    static final ae a = new ae(0, 0, 0, 0);
    private final af b;
    private final ArrayList c;
    private bw d;
    private bw e;
    private int f;
    private int g;
    private int h;
    private int y;

    public ct(af afVar) {
        super(afVar.c(), a);
        this.c = new ArrayList();
        this.b = afVar;
        bw bwVar = bw.a;
        this.d = bwVar;
        this.e = bwVar;
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.al, com.google.android.libraries.geo.mapcore.renderer.aj
    public final void G(aj ajVar, aj ajVar2, u uVar) {
        bv bvVar = this.l;
        com.google.android.libraries.navigation.internal.yx.ar.q(bvVar);
        bw bwVar = this.d;
        bw bwVar2 = bw.a;
        if (bwVar == bwVar2 || this.e == bwVar2) {
            return;
        }
        if (!(ajVar instanceof ct)) {
            bvVar.r(1, 771);
            bvVar.w(false, 0, 0, 0);
            bvVar.t(519);
            bvVar.u(0);
            bvVar.j(this.f);
            GLES20.glUniform1i(this.g, 0);
            GLES20.glUniform2f(this.y, uVar.s(), uVar.r());
            bvVar.k(this.d);
            bvVar.i(this.e);
            bvVar.o(0);
            GLES20.glVertexAttribPointer(0, 3, FujifilmMakernoteDirectory.TAG_MAX_APERTURE_AT_MIN_FOCAL, false, 20, 0);
            bvVar.o(1);
            GLES20.glVertexAttribPointer(1, 2, FujifilmMakernoteDirectory.TAG_MAX_APERTURE_AT_MIN_FOCAL, false, 20, 12);
            int i = bt.a().f;
            for (int i2 = 2; i2 < i; i2++) {
                bvVar.n(i2);
            }
        }
        for (int i3 = 0; i3 < this.c.size(); i3++) {
            x xVar = (x) this.c.get(i3);
            ep epVar = xVar.a;
            if (epVar != null) {
                bw bwVarE = epVar.e();
                int iD = xVar.a.d();
                int iC = xVar.a.c();
                if (bwVarE != null && bwVarE.b()) {
                    bvVar.B(1, bwVarE);
                    GLES20.glUniform2f(this.h, 1.0f / iD, 1.0f / iC);
                    bvVar.Q(4, xVar.b, xVar.c);
                }
            }
        }
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.al, com.google.android.libraries.geo.mapcore.renderer.aj
    public final af i() {
        return this.b;
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.al, com.google.android.libraries.geo.mapcore.renderer.aj
    public final boolean p() {
        return true;
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.z
    public final List q() {
        return this.c;
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.z
    public final /* bridge */ /* synthetic */ void r(bw bwVar, bw bwVar2, ee eeVar) {
        LabelRenderer.LabelShaderProgram labelShaderProgram = (LabelRenderer.LabelShaderProgram) eeVar;
        this.d = bwVar;
        this.e = bwVar2;
        this.f = labelShaderProgram.w;
        this.g = labelShaderProgram.a;
        this.h = labelShaderProgram.b;
        this.y = labelShaderProgram.c;
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.z
    public final void s() {
        bw bwVar = bw.a;
        this.d = bwVar;
        this.e = bwVar;
        this.f = 0;
        this.g = 0;
        this.h = 0;
        this.y = 0;
    }
}
