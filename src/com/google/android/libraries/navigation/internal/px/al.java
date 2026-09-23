package com.google.android.libraries.navigation.internal.px;

import com.facebook.react.uimanager.ViewProps;
import java.util.concurrent.Semaphore;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class al implements ai {
    protected ek c;
    protected int d;
    protected com.google.android.libraries.geo.mapcore.renderer.af e;
    protected com.google.android.libraries.navigation.internal.pz.d f;
    protected com.google.android.libraries.geo.mapcore.internal.model.ci g;
    protected float h;
    protected long i;
    protected boolean j;
    protected long k;
    public com.google.android.libraries.navigation.internal.fq.o l;
    public float m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    protected int f537n;
    private boolean p;
    protected final Semaphore b = new Semaphore(1);
    protected int o = 1;
    private int a = 0;
    private boolean q = true;

    protected al() {
    }

    @Override // com.google.android.libraries.navigation.internal.px.ai
    public final ek A() {
        return this.c;
    }

    @Override // com.google.android.libraries.navigation.internal.px.ai
    public final com.google.android.libraries.geo.mapcore.renderer.af B() {
        return this.e;
    }

    @Override // com.google.android.libraries.navigation.internal.px.ai
    public final synchronized void C(int i) {
        boolean z = true;
        com.google.android.libraries.navigation.internal.yx.ar.l(!this.q, this);
        if ((this.a & i) != 0) {
            z = false;
        }
        com.google.android.libraries.navigation.internal.yx.ar.l(z, this);
        this.a = i | this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.px.ai
    public final synchronized void D(int i) {
        com.google.android.libraries.navigation.internal.yx.ar.l((this.a & i) != 0, this);
        int i2 = (~i) & this.a;
        this.a = i2;
        if (i2 == 0) {
            j();
        }
    }

    @Override // com.google.android.libraries.navigation.internal.px.ai
    public final void E(boolean z) {
        this.p = z;
    }

    @Override // com.google.android.libraries.navigation.internal.px.ai
    public final void F(float f) {
        this.m = f;
    }

    @Override // com.google.android.libraries.navigation.internal.px.ai
    public final boolean G() {
        return this.p;
    }

    @Override // com.google.android.libraries.navigation.internal.px.ai
    public /* synthetic */ boolean H() {
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.px.ai
    public /* synthetic */ boolean I() {
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:32:0x0060  */
    /* JADX WARN: Code duplicated, block: B:33:0x0063  */
    @Override // com.google.android.libraries.navigation.internal.px.ai
    public final int J(long j) {
        long j2 = j - this.k;
        this.i = j;
        long jV = v(this.f537n);
        int i = this.f537n;
        int i2 = i - 1;
        if (i == 0) {
            throw null;
        }
        if (i2 == 0) {
            this.o = 4;
            this.h = 1.0f;
        } else if (i2 != 1) {
            if (i2 != 2) {
                if (i2 == 3) {
                    this.o = 4;
                    this.h = 1.0f;
                }
            } else if (jV <= 0) {
                float f = this.h - (j2 * 0.0033333334f);
                this.h = f;
                if (f <= 0.0f) {
                    this.h = 0.0f;
                    this.o = 5;
                } else {
                    this.o = 3;
                }
            } else if (j2 >= jV) {
                this.o = 5;
            } else {
                this.o = 3;
            }
        } else if (jV <= 0) {
            float f2 = this.h + (j2 * 0.0033333334f);
            this.h = f2;
            if (f2 >= 1.0f) {
                this.h = 1.0f;
                this.o = 4;
            } else {
                this.o = 2;
            }
        } else if (j2 >= jV) {
            this.o = 4;
        } else {
            this.o = 2;
        }
        return this.o;
    }

    @Override // com.google.android.libraries.navigation.internal.px.ai
    public final void K(long j, int i) {
        float f;
        this.k = j;
        this.i = j;
        this.f537n = i;
        if (this.j) {
            if (i == 2) {
                f = 1.0f;
            } else if (i != 3) {
                return;
            } else {
                f = 0.0f;
            }
            this.h = f;
        }
    }

    protected final void L(ek ekVar, int i, com.google.android.libraries.geo.mapcore.renderer.af afVar, com.google.android.libraries.navigation.internal.pz.d dVar) {
        com.google.android.libraries.navigation.internal.yx.ar.l(this.q, this);
        this.g = ekVar.k() != null ? ekVar.k().d.c : null;
        this.c = ekVar.ab();
        this.d = i;
        this.e = afVar;
        this.f = dVar;
        this.p = false;
        this.h = 1.0f;
        this.i = 0L;
        this.k = 0L;
        this.f537n = 1;
        com.google.android.libraries.navigation.internal.adg.ef efVarO = ekVar.o();
        com.google.android.libraries.navigation.internal.ael.bh bhVarS = com.google.android.libraries.navigation.internal.ael.bi.s(com.google.android.libraries.navigation.internal.adl.k.a);
        efVarO.h(bhVarS);
        Object objK = efVarO.w.k(bhVarS.d);
        this.j = ((com.google.android.libraries.navigation.internal.adl.x) (objK == null ? bhVarS.b : bhVarS.c(objK))).i;
        this.q = false;
    }

    @Override // com.google.android.libraries.navigation.internal.px.ac
    public final com.google.android.libraries.navigation.internal.adg.ef a() {
        return ((b) this.c).a;
    }

    @Override // com.google.android.libraries.navigation.internal.px.ai
    public com.google.android.libraries.navigation.internal.ol.o e() {
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.px.ai
    public com.google.android.libraries.navigation.internal.qa.b g() {
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.px.ai
    public com.google.android.libraries.navigation.internal.qa.b h() {
        return null;
    }

    protected void j() {
        com.google.android.libraries.navigation.internal.yx.ar.l(!this.q, this);
        com.google.android.libraries.navigation.internal.yx.ar.l(this.a == 0, this);
        this.c = null;
        this.d = -559038737;
        this.e = null;
        this.f = null;
        this.p = false;
        this.q = true;
        com.google.android.libraries.navigation.internal.fq.o oVar = this.l;
        if (oVar != null) {
            oVar.g(this);
            this.l = null;
        }
    }

    @Override // com.google.android.libraries.navigation.internal.px.ai
    public void k() {
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.px.ai
    public void m(boolean z) {
    }

    @Override // com.google.android.libraries.navigation.internal.px.ai
    public void n(boolean z) {
    }

    @Override // com.google.android.libraries.navigation.internal.px.ai
    public void o(ai aiVar) {
    }

    @Override // com.google.android.libraries.navigation.internal.px.ai
    public boolean p() {
        return false;
    }

    public boolean q() {
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.px.ai
    public boolean r() {
        throw null;
    }

    public final String toString() {
        com.google.android.libraries.navigation.internal.yx.ak akVarC = com.google.android.libraries.navigation.internal.yx.al.b(this).c("id", this.d);
        ek ekVar = this.c;
        akVarC.g("minZoomLevel", ekVar == null ? "<null>" : Float.valueOf(((b) ekVar).g));
        ek ekVar2 = this.c;
        akVarC.g("rank", ekVar2 != null ? Integer.valueOf(((ep) ekVar2).o().i) : "<null>");
        akVarC.g("drawOrder", this.e);
        com.google.android.libraries.navigation.internal.yx.ak akVarE = akVarC.b(ViewProps.OPACITY, this.h).c("referenceMask", this.a).e("destructed", this.q);
        akVarE.g("labelPool", this.l);
        return akVarE.toString();
    }

    @Override // com.google.android.libraries.navigation.internal.px.ai
    public long v(int i) {
        return 0L;
    }

    public int w(com.google.android.libraries.navigation.internal.qq.x xVar, boolean z, com.google.android.libraries.navigation.internal.oe.x xVar2) {
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.px.ai
    public final int z() {
        return this.d;
    }
}
