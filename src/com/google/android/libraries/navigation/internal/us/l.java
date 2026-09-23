package com.google.android.libraries.navigation.internal.us;

import android.view.View;
import com.google.android.libraries.navigation.internal.ms.cs;
import com.google.android.libraries.navigation.internal.ms.cy;
import com.google.android.libraries.navigation.internal.yx.ar;
import com.google.android.libraries.navigation.internal.zt.as;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class l implements com.google.android.libraries.navigation.internal.ut.d.b {
    public static final com.google.android.libraries.navigation.internal.nc.t a;
    protected final y c;
    protected final com.google.android.libraries.navigation.internal.jy.af d;
    protected final com.google.android.libraries.navigation.internal.nc.t e;
    protected final com.google.android.libraries.navigation.internal.nc.t f;
    protected final com.google.android.libraries.navigation.internal.ut.d.b.a g;
    protected final com.google.android.libraries.navigation.internal.jy.aa h;
    protected final boolean i;
    protected final boolean j;
    protected final boolean k;
    protected final com.google.android.libraries.navigation.internal.us.a o;
    private final com.google.android.libraries.navigation.internal.ms.c p;
    private final com.google.android.libraries.navigation.internal.ut.b q;
    com.google.android.libraries.navigation.internal.ki.a b = new com.google.android.libraries.navigation.internal.ki.a();
    public boolean l = false;
    protected boolean m = false;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    protected boolean f625n = false;

    /* JADX INFO: compiled from: PG */
    public final class a extends l implements com.google.android.libraries.navigation.internal.ut.d.InterfaceC0038d {
        private final com.google.android.libraries.navigation.internal.ah.a p;

        public a(m mVar) {
            super(mVar);
            com.google.android.libraries.navigation.internal.ah.a aVar = mVar.k;
            ar.r(aVar, "progressTimer");
            this.p = aVar;
        }

        @Override // com.google.android.libraries.navigation.internal.ah.a.InterfaceC0032a
        public cs.a a() {
            View view = this.b.a;
            com.google.android.libraries.navigation.internal.jy.o oVarA = view != null ? com.google.android.libraries.navigation.internal.jw.e.a(view) : null;
            if (this.h != null && oVarA != null) {
                this.d.d(oVarA, new com.google.android.libraries.navigation.internal.jy.v(as.ACTION_BY_TIMER), this.h);
            }
            this.f625n = true;
            return g();
        }

        @Override // com.google.android.libraries.navigation.internal.ut.d.InterfaceC0038d
        public com.google.android.libraries.navigation.internal.ah.a b() {
            return this.p;
        }

        @Override // com.google.android.libraries.navigation.internal.us.l, com.google.android.libraries.navigation.internal.ut.d.b
        public cs.a c() {
            this.p.d();
            return super.c();
        }
    }

    static {
        com.google.android.libraries.navigation.internal.nc.j.m(com.google.android.libraries.navigation.internal.dw.h.at);
        a = com.google.android.libraries.navigation.internal.nc.j.m(com.google.android.libraries.navigation.internal.dw.h.au);
        com.google.android.libraries.navigation.internal.nc.j.m(com.google.android.libraries.navigation.internal.dw.h.ar);
        com.google.android.libraries.navigation.internal.nc.j.m(com.google.android.libraries.navigation.internal.dw.h.as);
        com.google.android.libraries.navigation.internal.nc.j.m(com.google.android.libraries.navigation.internal.dw.h.ap);
        com.google.android.libraries.navigation.internal.nc.j.m(com.google.android.libraries.navigation.internal.dw.h.aq);
    }

    public l(m mVar) {
        y yVar = mVar.a;
        ar.r(yVar, "owningPrompt");
        this.c = yVar;
        com.google.android.libraries.navigation.internal.jy.af afVar = mVar.b;
        ar.r(afVar, "reporter");
        this.d = afVar;
        this.e = mVar.c;
        this.f = mVar.d;
        this.g = mVar.e;
        this.o = mVar.l;
        this.h = mVar.f;
        this.i = mVar.h;
        boolean z = mVar.i;
        this.j = z;
        this.k = mVar.j;
        this.p = new j(new k(this));
        this.q = z ? new com.google.android.libraries.navigation.internal.ut.b() { // from class: com.google.android.libraries.navigation.internal.us.l.1
            @Override // com.google.android.libraries.navigation.internal.ut.b
            public com.google.android.libraries.navigation.internal.jy.aa a() {
                return null;
            }

            @Override // com.google.android.libraries.navigation.internal.ut.b
            public com.google.android.libraries.navigation.internal.nc.t b() {
                return l.this.h();
            }

            @Override // com.google.android.libraries.navigation.internal.ut.b
            public com.google.android.libraries.navigation.internal.nc.x c() {
                return com.google.android.libraries.navigation.internal.ju.b.i;
            }

            @Override // com.google.android.libraries.navigation.internal.ut.b
            public com.google.android.libraries.navigation.internal.nc.x d() {
                return com.google.android.libraries.navigation.internal.ju.b.e;
            }

            @Override // com.google.android.libraries.navigation.internal.ut.b
            public com.google.android.libraries.navigation.internal.nc.x e() {
                return com.google.android.libraries.navigation.internal.ju.b.e;
            }

            @Override // com.google.android.libraries.navigation.internal.ut.b
            public com.google.android.libraries.navigation.internal.nc.ah f() {
                return com.google.android.libraries.navigation.internal.nc.j.i(com.google.android.libraries.navigation.internal.fc.a.a, com.google.android.libraries.navigation.internal.ju.b.e);
            }

            @Override // com.google.android.libraries.navigation.internal.ut.b
            public Boolean g() {
                return Boolean.valueOf(l.this.l);
            }

            @Override // com.google.android.libraries.navigation.internal.ut.b
            public Boolean h() {
                return false;
            }

            @Override // com.google.android.libraries.navigation.internal.ut.b
            public Boolean i() {
                return true;
            }

            @Override // com.google.android.libraries.navigation.internal.ut.b
            public String j() {
                return null;
            }
        } : null;
    }

    @Override // com.google.android.libraries.navigation.internal.ut.d.b
    public cs.a c() {
        this.f625n = false;
        return g();
    }

    @Override // com.google.android.libraries.navigation.internal.ut.d.b
    public com.google.android.libraries.navigation.internal.jy.aa d() {
        return this.h;
    }

    @Override // com.google.android.libraries.navigation.internal.ut.d.b
    public com.google.android.libraries.navigation.internal.ki.a e() {
        return this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.ut.d.b
    public com.google.android.libraries.navigation.internal.ms.c f() {
        return this.p;
    }

    protected final cs.a g() {
        if (!this.m) {
            this.m = true;
            if (m().booleanValue()) {
                cy.a(this.c);
            } else {
                r();
            }
        }
        return cs.a.a;
    }

    @Override // com.google.android.libraries.navigation.internal.ut.d.b
    public com.google.android.libraries.navigation.internal.nc.t h() {
        com.google.android.libraries.navigation.internal.nc.t tVar = this.f;
        return tVar != null ? tVar : this.e;
    }

    @Override // com.google.android.libraries.navigation.internal.ut.d.b
    public com.google.android.libraries.navigation.internal.nc.t i() {
        return this.e;
    }

    @Override // com.google.android.libraries.navigation.internal.ut.d.b
    public com.google.android.libraries.navigation.internal.ut.b j() {
        return this.q;
    }

    @Override // com.google.android.libraries.navigation.internal.ut.d.b
    public com.google.android.libraries.navigation.internal.ut.d.b.a k() {
        return this.g;
    }

    @Override // com.google.android.libraries.navigation.internal.ut.d.b
    public Boolean l() {
        return this.c.u();
    }

    @Override // com.google.android.libraries.navigation.internal.ut.d.b
    public Boolean m() {
        boolean z = false;
        if (this.c.W() && this.m && this.j) {
            z = true;
        }
        return Boolean.valueOf(z);
    }

    @Override // com.google.android.libraries.navigation.internal.ut.d.b
    public Boolean n() {
        return Boolean.valueOf(this.j);
    }

    @Override // com.google.android.libraries.navigation.internal.ut.d.b
    public Boolean o() {
        return Boolean.valueOf(this.k);
    }

    @Override // com.google.android.libraries.navigation.internal.ut.d.b
    public Boolean p() {
        return Boolean.valueOf(this.i);
    }

    @Override // com.google.android.libraries.navigation.internal.ut.d.b
    public String q() {
        return null;
    }

    protected final void r() {
        com.google.android.libraries.navigation.internal.us.a aVar = this.o;
        if (aVar != null) {
            boolean z = this.f625n;
            com.google.android.libraries.navigation.internal.ady.ad adVarB = com.google.android.libraries.navigation.internal.ady.ad.b(((com.google.android.libraries.navigation.internal.tj.b) aVar.b.a).b.c);
            if (adVarB == null) {
                adVarB = com.google.android.libraries.navigation.internal.ady.ad.REROUTE_TYPE_BETTER_ETA;
            }
            aVar.b.c.a(new com.google.android.libraries.navigation.internal.sr.c(aVar.a, z, adVarB));
        }
        this.c.L();
    }
}
