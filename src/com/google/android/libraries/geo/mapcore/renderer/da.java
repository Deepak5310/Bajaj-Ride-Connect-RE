package com.google.android.libraries.geo.mapcore.renderer;

import android.opengl.GLES20;
import com.drew.metadata.exif.makernotes.FujifilmMakernoteDirectory;
import com.drew.metadata.exif.makernotes.NikonType2MakernoteDirectory;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class da extends al implements z {
    static final ae a = new ae(0, 0, 0, 1);
    private final af b;
    private final ArrayList c;
    private bw d;
    private bw e;
    private LayeredLabelRenderer.LayeredLabelShaderProgram f;

    public da(af afVar) {
        super(afVar.c(), a);
        this.c = new ArrayList();
        this.f = null;
        this.b = afVar;
        bw bwVar = bw.a;
        this.d = bwVar;
        this.e = bwVar;
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.al, com.google.android.libraries.geo.mapcore.renderer.aj
    public final void G(aj ajVar, aj ajVar2, u uVar) {
        bw bwVar = this.d;
        bw bwVar2 = bw.a;
        if (bwVar == bwVar2 || this.e == bwVar2) {
            return;
        }
        com.google.android.libraries.navigation.internal.yx.ar.q(this.f);
        bv bvVar = this.l;
        com.google.android.libraries.navigation.internal.yx.ar.q(bvVar);
        if (!(ajVar instanceof da)) {
            com.google.android.libraries.navigation.internal.yx.ar.q(this.f);
            bv bvVar2 = this.l;
            com.google.android.libraries.navigation.internal.yx.ar.q(bvVar2);
            bvVar2.r(1, 771);
            bvVar2.w(false, 0, 0, 0);
            bvVar2.t(519);
            bvVar2.u(0);
            bvVar2.j(this.f.w);
            GLES20.glUniform1i(this.f.a, 0);
            GLES20.glUniform2f(this.f.c, uVar.s(), uVar.r());
            bvVar2.k(this.d);
            bvVar2.i(this.e);
            bvVar2.o(0);
            GLES20.glVertexAttribPointer(0, 2, FujifilmMakernoteDirectory.TAG_MAX_APERTURE_AT_MIN_FOCAL, false, NikonType2MakernoteDirectory.TAG_LENS, 0);
            bvVar2.o(1);
            GLES20.glVertexAttribPointer(1, 1, FujifilmMakernoteDirectory.TAG_MAX_APERTURE_AT_MIN_FOCAL, false, NikonType2MakernoteDirectory.TAG_LENS, 8);
            int i = 2;
            for (int i2 = 0; i2 < 6; i2++) {
                bvVar2.o(i);
                int i3 = i2 * 20;
                GLES20.glVertexAttribPointer(i, 4, FujifilmMakernoteDirectory.TAG_MAX_APERTURE_AT_MIN_FOCAL, false, NikonType2MakernoteDirectory.TAG_LENS, i3 + 12);
                int i4 = i + 1;
                bvVar2.o(i4);
                GLES20.glVertexAttribPointer(i4, 1, FujifilmMakernoteDirectory.TAG_MAX_APERTURE_AT_MIN_FOCAL, false, NikonType2MakernoteDirectory.TAG_LENS, i3 + 28);
                i += 2;
            }
            int i5 = bt.a().f;
            while (i < i5) {
                bvVar2.n(i);
                i++;
            }
        }
        for (int i6 = 0; i6 < this.c.size(); i6++) {
            x xVar = (x) this.c.get(i6);
            ep epVar = xVar.a;
            if (epVar != null) {
                bw bwVarE = epVar.e();
                int iD = xVar.a.d();
                int iC = xVar.a.c();
                if (bwVarE != null && bwVarE.b()) {
                    bvVar.B(1, bwVarE);
                    GLES20.glUniform2f(this.f.b, 1.0f / iD, 1.0f / iC);
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
        this.d = bwVar;
        this.e = bwVar2;
        this.f = (LayeredLabelRenderer.LayeredLabelShaderProgram) eeVar;
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.z
    public final void s() {
        bw bwVar = bw.a;
        this.d = bwVar;
        this.e = bwVar;
    }
}
