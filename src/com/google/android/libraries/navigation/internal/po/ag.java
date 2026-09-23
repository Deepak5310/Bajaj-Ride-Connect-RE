package com.google.android.libraries.navigation.internal.po;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class ag extends b implements com.google.android.libraries.navigation.internal.pp.a {
    private static final com.google.android.libraries.navigation.internal.oe.x c = new com.google.android.libraries.navigation.internal.oe.x(0, 0);
    private final com.google.android.libraries.navigation.internal.ol.ai d;
    private volatile com.google.android.libraries.navigation.internal.px.dj e;
    protected final dd f;
    public final com.google.android.libraries.navigation.internal.px.ek g;
    private volatile com.google.android.libraries.navigation.internal.jy.p h;

    public ag(dd ddVar, af afVar, com.google.android.libraries.navigation.internal.px.ek ekVar, com.google.android.libraries.navigation.internal.ol.ai aiVar) {
        this(ddVar, afVar, ekVar, aiVar, true);
    }

    @Override // com.google.android.libraries.navigation.internal.pp.f
    public final com.google.android.libraries.navigation.internal.px.ek D() {
        return this.g;
    }

    @Override // com.google.android.libraries.navigation.internal.pp.f
    public final com.google.android.libraries.navigation.internal.yx.an E() {
        return com.google.android.libraries.navigation.internal.yx.an.i(this.e);
    }

    @Override // com.google.android.libraries.navigation.internal.ol.au
    /* JADX INFO: renamed from: F, reason: merged with bridge method [inline-methods] */
    public final com.google.android.libraries.navigation.internal.adg.ef n() {
        return ((com.google.android.libraries.navigation.internal.px.b) this.g).a;
    }

    @Override // com.google.android.libraries.navigation.internal.pp.f
    public final void G(com.google.android.libraries.navigation.internal.jy.p pVar) {
        this.h = pVar;
    }

    @Override // com.google.android.libraries.navigation.internal.pp.f
    public final void H(com.google.android.libraries.navigation.internal.px.dj djVar) {
        this.e = djVar;
    }

    protected final boolean I() {
        return t(new Runnable() { // from class: com.google.android.libraries.navigation.internal.po.ad
            @Override // java.lang.Runnable
            public final void run() {
                boolean zB;
                ag agVar = this.a;
                dd ddVar = agVar.f;
                synchronized (ddVar) {
                    zB = agVar instanceof aa ? ddVar.c.b((aa) agVar) : ddVar.a.b(agVar);
                }
                if (zB) {
                    ddVar.h(true);
                }
            }
        });
    }

    @Override // com.google.android.libraries.navigation.internal.ol.o
    public synchronized boolean f() {
        return s();
    }

    @Override // com.google.android.libraries.navigation.internal.pf.a
    public final com.google.android.libraries.navigation.internal.yx.an g() {
        return com.google.android.libraries.navigation.internal.yx.an.i(this.h);
    }

    @Override // com.google.android.libraries.navigation.internal.ol.v
    public final void h() {
        this.d.g(this);
    }

    @Override // com.google.android.libraries.navigation.internal.ol.v
    public void i() {
        this.d.i(this);
    }

    @Override // com.google.android.libraries.navigation.internal.pf.a
    public com.google.android.libraries.navigation.internal.oe.x j() {
        return c;
    }

    @Override // com.google.android.libraries.navigation.internal.ol.v
    public final void m() {
        this.d.m(this);
    }

    @Override // com.google.android.libraries.navigation.internal.po.b
    protected final void u(int i) {
        v(i, this);
    }

    public void w() {
    }

    public void x() {
        synchronized (this) {
            this.b = true;
            o();
        }
    }

    @Override // com.google.android.libraries.navigation.internal.pp.d
    public void y() {
        t(new Runnable() { // from class: com.google.android.libraries.navigation.internal.po.ac
            @Override // java.lang.Runnable
            public final void run() {
                ag agVar = this.a;
                agVar.f.i(agVar);
            }
        });
    }

    public void z() {
        I();
    }

    protected ag(dd ddVar, af afVar, com.google.android.libraries.navigation.internal.px.ek ekVar, com.google.android.libraries.navigation.internal.ol.ai aiVar, boolean z) {
        super(null);
        this.f = ddVar;
        this.g = ekVar;
        this.d = aiVar;
        if (z) {
            com.google.android.libraries.navigation.internal.aac.bj bjVarA = afVar.a(ekVar);
            if (bjVarA != null) {
                bjVarA.l(new Runnable() { // from class: com.google.android.libraries.navigation.internal.po.ab
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.q();
                    }
                }, com.google.android.libraries.navigation.internal.aac.ac.INSTANCE);
            } else {
                this.a = true;
            }
        }
    }
}
