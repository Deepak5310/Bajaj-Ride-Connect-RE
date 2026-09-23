package com.google.android.libraries.geo.mapcore.renderer;

import android.opengl.GLES20;
import com.drew.metadata.exif.makernotes.FujifilmMakernoteDirectory;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public class al implements aj {
    private static final fg a = new fg(0, 0, 0);
    private ae c;
    private ff e;
    protected ae i;
    public final dy j;
    protected bv l;
    protected v r;
    private final Object b = new Object();
    public boolean k = true;
    public ef m = null;
    private final ey[] d = new ey[8];

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Cdo f74n = null;
    protected final com.google.android.libraries.navigation.internal.rm.c o = new com.google.android.libraries.navigation.internal.rm.c();
    public boolean p = true;
    protected final com.google.android.libraries.navigation.internal.rm.c q = new com.google.android.libraries.navigation.internal.rm.c();
    public boolean s = false;
    private int f = 1;
    private int g = 0;
    public int t = 519;
    public boolean u = false;
    public int v = -1;
    public int w = -1;
    public int x = -1;
    private final float h = 1.0f;
    private final af y = new ak(this);

    public al(dy dyVar, ae aeVar) {
        this.j = dyVar;
        this.c = aeVar;
        this.i = aeVar;
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.aj
    public final void A(bv bvVar) {
        if (this.s) {
            return;
        }
        this.l = bvVar;
        ff ffVar = this.e;
        if (ffVar != null) {
            ffVar.a(bvVar);
        }
        ey[] eyVarArr = this.d;
        for (int i = 0; i < 8; i++) {
            ey eyVar = eyVarArr[i];
            if (eyVar != null) {
                eyVar.b(bvVar);
            }
        }
        ef efVar = this.m;
        if (efVar != null) {
            efVar.c(bvVar);
        }
        this.s = true;
    }

    public void B(int i, ey eyVar) {
        if (this.s) {
            ea eaVar = ea.INVALID;
        }
        ey[] eyVarArr = this.d;
        ey eyVar2 = eyVarArr[i];
        eyVarArr[i] = eyVar;
        if (this.s) {
            if (eyVar2 != null) {
                eyVar2.c(false);
            }
            bv bvVar = this.l;
            com.google.android.libraries.navigation.internal.yx.ar.q(bvVar);
            eyVar.b(bvVar);
        }
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.aj
    public final void C(boolean z) {
        if (this.s) {
            ea eaVar = ea.INVALID;
        }
        this.k = z;
    }

    protected float[] D(u uVar) {
        if (this.p || uVar.x() != this.r) {
            com.google.android.libraries.navigation.internal.rm.c cVar = this.q;
            com.google.android.libraries.navigation.internal.rq.f.c(cVar.a, uVar.G(), this.o.a);
            this.q.a();
            this.p = false;
            this.r = uVar.x();
        }
        return this.q.a;
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.aj
    public final ae E() {
        ae aeVar;
        synchronized (this.b) {
            aeVar = this.i;
        }
        return aeVar;
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.aj
    public fg F() {
        return a;
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.aj
    public void G(aj ajVar, aj ajVar2, u uVar) {
        bv bvVar = this.l;
        ff ffVar = this.e;
        ef efVar = this.m;
        if (bvVar == null || ffVar == null || efVar == null) {
            return;
        }
        for (int i = 0; i < 8; i++) {
            ey eyVarC = c(i);
            bvVar.B(bv.q[i], eyVarC != null ? eyVarC.c : bw.a);
        }
        ee eeVar = efVar.l;
        bvVar.j(eeVar == null ? 0 : eeVar.w);
        efVar.b(bvVar, this, uVar, this.o.a, uVar.G(), D(uVar));
        bvVar.r(this.f, this.g);
        bvVar.t(this.t);
        bvVar.u(1);
        bvVar.w(this.u, this.v, this.w, this.x);
        bvVar.v(0.0f, 0.0f);
        com.google.android.libraries.navigation.internal.yx.ar.k(bvVar.i);
        if (bvVar.e != 1.0f) {
            GLES20.glLineWidth(1.0f);
            bvVar.e = 1.0f;
        }
        bv bvVar2 = ffVar.b;
        com.google.android.libraries.navigation.internal.yx.ar.q(bvVar2);
        if (ffVar.m.b()) {
            bw bwVar = bvVar2.f;
            bw bwVar2 = ffVar.m;
            if (bwVar != bwVar2 || bvVar2.g != ffVar.f83n) {
                bvVar2.k(bwVar2);
                int i2 = ffVar.m.f;
                if (ffVar.f83n.b()) {
                    bvVar2.i(ffVar.f83n);
                }
                bvVar2.o(0);
                bvVar2.n(1);
                if (ffVar.g || ffVar.h) {
                    bvVar2.o(2);
                } else {
                    bvVar2.n(2);
                }
                if (ffVar.f) {
                    bvVar2.o(3);
                } else {
                    bvVar2.n(3);
                }
                if (ffVar.d) {
                    GLES20.glVertexAttribPointer(0, true != ffVar.i ? 3 : 2, FujifilmMakernoteDirectory.TAG_MAX_APERTURE_AT_MIN_FOCAL, false, ffVar.o, i2);
                } else if (ffVar.e) {
                    GLES20.glVertexAttribPointer(0, true != ffVar.i ? 3 : 2, FujifilmMakernoteDirectory.TAG_DYNAMIC_RANGE_SETTING, false, ffVar.o, i2);
                }
                if (ffVar.g) {
                    GLES20.glVertexAttribPointer(2, 4, FujifilmMakernoteDirectory.TAG_MAX_APERTURE_AT_MIN_FOCAL, false, ffVar.o, i2 + ffVar.r);
                }
                if (ffVar.h) {
                    GLES20.glVertexAttribPointer(2, 4, FujifilmMakernoteDirectory.TAG_FILM_MODE, true, ffVar.o, i2 + ffVar.r);
                }
                if (ffVar.f) {
                    GLES20.glVertexAttribPointer(3, 2, FujifilmMakernoteDirectory.TAG_MAX_APERTURE_AT_MIN_FOCAL, true, ffVar.o, i2 + ffVar.q);
                }
                int i3 = ffVar.l;
                if ((i3 & 2176) == 0) {
                    bvVar2.n(4);
                } else if ((i3 & 128) != 0) {
                    bvVar2.o(4);
                    GLES20.glVertexAttribPointer(4, 4, FujifilmMakernoteDirectory.TAG_FILM_MODE, false, ffVar.o, i2 + ffVar.s);
                } else {
                    bvVar2.o(4);
                    GLES20.glVertexAttribPointer(4, 1, FujifilmMakernoteDirectory.TAG_MAX_APERTURE_AT_MIN_FOCAL, false, ffVar.o, i2 + ffVar.s);
                }
                int i4 = ffVar.l;
                if ((i4 & FujifilmMakernoteDirectory.TAG_AUTO_BRACKETING) == 0) {
                    bvVar2.n(5);
                } else if ((i4 & 256) != 0) {
                    bvVar2.o(5);
                    GLES20.glVertexAttribPointer(5, 4, FujifilmMakernoteDirectory.TAG_FILM_MODE, false, ffVar.o, i2 + ffVar.t);
                } else {
                    bvVar2.o(5);
                    GLES20.glVertexAttribPointer(5, 1, FujifilmMakernoteDirectory.TAG_MAX_APERTURE_AT_MIN_FOCAL, false, ffVar.o, i2 + ffVar.t);
                }
                int i5 = ffVar.l;
                if ((i5 & 8704) == 0) {
                    bvVar2.n(6);
                } else if ((i5 & 512) != 0) {
                    bvVar2.o(6);
                    GLES20.glVertexAttribPointer(6, 4, FujifilmMakernoteDirectory.TAG_FILM_MODE, false, ffVar.o, i2 + ffVar.u);
                } else {
                    bvVar2.o(6);
                    GLES20.glVertexAttribPointer(6, 1, FujifilmMakernoteDirectory.TAG_MAX_APERTURE_AT_MIN_FOCAL, false, ffVar.o, i2 + ffVar.u);
                }
                int i6 = ffVar.l;
                if ((i6 & 17408) == 0) {
                    bvVar2.n(7);
                } else if ((i6 & 1024) != 0) {
                    bvVar2.o(7);
                    GLES20.glVertexAttribPointer(7, 4, FujifilmMakernoteDirectory.TAG_FILM_MODE, false, ffVar.o, i2 + ffVar.v);
                } else {
                    bvVar2.o(7);
                    GLES20.glVertexAttribPointer(7, 1, FujifilmMakernoteDirectory.TAG_MAX_APERTURE_AT_MIN_FOCAL, false, ffVar.o, i2 + ffVar.v);
                }
            }
        }
        bv bvVar3 = ffVar.b;
        com.google.android.libraries.navigation.internal.yx.ar.q(bvVar3);
        if (ffVar.f83n.b()) {
            bvVar3.Q(ffVar.k, ffVar.c, ffVar.f83n.f);
        } else {
            bvVar3.P(ffVar.k, ffVar.j);
        }
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.aj
    public void b(long j) {
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.aj
    public ey c(int i) {
        return this.d[i];
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.aj
    public void d(boolean z) {
        if (this.s) {
            ff ffVar = this.e;
            if (ffVar != null) {
                ffVar.b(z);
            }
            ey[] eyVarArr = this.d;
            for (int i = 0; i < 8; i++) {
                ey eyVar = eyVarArr[i];
                if (eyVar != null) {
                    eyVar.c(z);
                }
            }
            ef efVar = this.m;
            if (efVar != null) {
                efVar.e();
            }
            this.l = null;
            this.s = false;
        }
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.aj
    public final Cdo g() {
        return this.f74n;
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.aj
    public int h() {
        return 0;
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.aj
    public af i() {
        return this.y;
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.aj
    public final boolean n() {
        cs csVar;
        int i = 0;
        while (true) {
            boolean zD = true;
            if (i >= 8) {
                return true;
            }
            ey eyVar = this.d[i];
            if (eyVar != null && (csVar = eyVar.b) != null) {
                h hVar = csVar.d;
                if (hVar != null) {
                    zD = hVar.d();
                } else {
                    aa aaVar = csVar.k;
                    if (aaVar == null) {
                        continue;
                    } else if (aaVar.a == null) {
                        zD = false;
                    }
                }
                if (!zD) {
                    return false;
                }
            }
            i++;
        }
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.aj
    public final boolean o() {
        return this.s;
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.aj
    public boolean p() {
        return this.e != null && this.k;
    }

    public final void t(int i, int i2) {
        this.f = i;
        this.g = i2;
    }

    public final void u(ae aeVar) {
        synchronized (this.b) {
            this.c = aeVar;
        }
    }

    public final void v(ef efVar) {
        if (this.s) {
            ea eaVar = ea.INVALID;
        }
        ef efVar2 = this.m;
        this.m = efVar;
        if (this.s) {
            if (efVar2 != null) {
                efVar2.e();
            }
            if (efVar != null) {
                bv bvVar = this.l;
                com.google.android.libraries.navigation.internal.yx.ar.q(bvVar);
                efVar.c(bvVar);
            }
        }
    }

    public final void w(ff ffVar) {
        if (this.s) {
            ea eaVar = ea.INVALID;
        }
        ff ffVar2 = this.e;
        if (this.s) {
            bv bvVar = this.l;
            com.google.android.libraries.navigation.internal.yx.ar.q(bvVar);
            if (ffVar2 != null) {
                ffVar2.b(false);
            }
            if (ffVar != null) {
                ffVar.a(bvVar);
            }
        }
        this.e = ffVar;
    }

    public final void x(int i, int i2) {
        this.u = true;
        this.v = 514;
        this.w = i;
        this.x = i2;
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.aj
    public final dy y() {
        return this.j;
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.aj
    public final void z() {
        synchronized (this.b) {
            ae aeVar = this.c;
            if (aeVar != null && !aeVar.equals(this.i)) {
                this.i = this.c;
            }
        }
    }
}
