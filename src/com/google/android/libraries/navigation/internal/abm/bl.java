package com.google.android.libraries.navigation.internal.abm;

import android.view.View;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MapColorScheme;
import com.google.android.libraries.navigation.internal.abh.ed;
import com.google.android.libraries.navigation.internal.abh.ef;
import com.google.android.libraries.navigation.internal.abh.ey;
import com.google.android.libraries.navigation.internal.abh.fg;
import com.google.android.libraries.navigation.internal.abh.fo;
import com.google.android.libraries.navigation.internal.abh.gv;
import com.google.android.libraries.navigation.internal.po.fk;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class bl implements ed {
    public final com.google.android.libraries.navigation.internal.oa.k b;
    public final com.google.android.libraries.navigation.internal.oo.b c;
    private final ef d;
    private final com.google.android.libraries.navigation.internal.om.q e;
    private final com.google.android.libraries.navigation.internal.abh.ac f;
    private final com.google.android.libraries.navigation.internal.abn.c g;
    private final com.google.android.libraries.navigation.internal.abn.as h;
    private final fg i;
    private final dl j;
    private final gv k;
    private final ap l;
    private final aa m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final aj f133n;
    private final dn o;
    private final com.google.android.libraries.navigation.internal.abh.d p;
    private final com.google.android.libraries.navigation.internal.abh.dv q;
    private final com.google.android.libraries.navigation.internal.abh.be r;

    @MapColorScheme
    private int s;
    private final String w;
    private final com.google.android.libraries.navigation.internal.abh.bq y;
    private final com.google.android.libraries.navigation.internal.abh.bl z;
    private volatile boolean x = false;
    private int t = 1;
    private String u = null;
    private boolean v = true;
    com.google.android.libraries.navigation.internal.qd.w a = null;
    private com.google.android.libraries.navigation.internal.abh.bj A = null;

    public bl(ef efVar, String str, com.google.android.libraries.navigation.internal.om.q qVar, com.google.android.libraries.navigation.internal.oa.k kVar, com.google.android.libraries.navigation.internal.oo.b bVar, com.google.android.libraries.navigation.internal.abh.ac acVar, com.google.android.libraries.navigation.internal.abn.c cVar, com.google.android.libraries.navigation.internal.abn.as asVar, fg fgVar, dl dlVar, gv gvVar, ap apVar, aa aaVar, aj ajVar, dn dnVar, com.google.android.libraries.navigation.internal.abh.d dVar, com.google.android.libraries.navigation.internal.abh.dv dvVar, com.google.android.libraries.navigation.internal.abh.bq bqVar, com.google.android.libraries.navigation.internal.abh.bl blVar, com.google.android.libraries.navigation.internal.abh.be beVar, boolean z) {
        this.d = efVar;
        this.e = qVar;
        this.b = kVar;
        this.c = bVar;
        this.f = acVar;
        this.g = cVar;
        this.h = asVar;
        this.i = fgVar;
        this.j = dlVar;
        this.k = gvVar;
        this.l = apVar;
        this.m = aaVar;
        this.f133n = ajVar;
        this.o = dnVar;
        this.p = dVar;
        this.q = dvVar;
        this.y = bqVar;
        this.z = blVar;
        this.w = str;
        this.r = beVar;
        if (qVar != null) {
            qVar.d(str);
        }
        if (qVar != null) {
            com.google.android.libraries.navigation.internal.afo.a aVar = bVar != null ? new com.google.android.libraries.navigation.internal.afo.a() { // from class: com.google.android.libraries.navigation.internal.abm.bd
                @Override // com.google.android.libraries.navigation.internal.afo.a
                public final Object a() {
                    return this.a.c;
                }
            } : null;
            com.google.android.libraries.navigation.internal.afo.a aVar2 = new com.google.android.libraries.navigation.internal.afo.a() { // from class: com.google.android.libraries.navigation.internal.abm.be
                @Override // com.google.android.libraries.navigation.internal.afo.a
                public final Object a() {
                    return this.a.b;
                }
            };
            com.google.android.libraries.navigation.internal.om.p pVarA = qVar.a();
            Objects.requireNonNull(pVarA);
            bf bfVar = new bf(pVarA);
            boolean zI = kVar.k.i();
            qVar.a().b();
            qVar.a().b();
            new com.google.android.libraries.navigation.internal.oi.e(aVar, aVar2, bfVar, z, zI, false, null);
        }
        if (qVar != null) {
            qVar.a().b();
        }
        String strA = com.google.android.libraries.navigation.internal.afu.p.a.a().a();
        if (com.google.android.libraries.navigation.internal.yx.aq.c(strA)) {
            return;
        }
        if (com.google.android.libraries.navigation.internal.yx.c.c("blocked", strA)) {
            dvVar.c(false, true, beVar.n(com.google.android.gms.maps.am.p), "The Google Maps SDK has been disabled for this application. This might be because of an incorrectly configured project, or an invalid API key. See the Google API console: https://console.developers.google.com, and information about Obtaining an API key: https://developers.google.com/maps/documentation/android-sdk/signup.");
            com.google.android.libraries.navigation.internal.abf.p.a(5, String.valueOf(strA).concat("The Google Maps SDK has been disabled for this application. This might be because of an incorrectly configured project, or an invalid API key. See the Google API console: https://console.developers.google.com, and information about Obtaining an API key: https://developers.google.com/maps/documentation/android-sdk/signup."), new Object[0]);
            k(String.valueOf(strA).concat(String.valueOf(beVar.n(com.google.android.gms.maps.am.p))));
        } else if (com.google.android.libraries.navigation.internal.yx.c.c("exceeded", strA)) {
            dvVar.c(true, false, beVar.n(com.google.android.gms.maps.am.o), "The number of requests has exceeded the usage limits for the Google Maps SDK.");
            com.google.android.libraries.navigation.internal.abf.p.a(5, String.valueOf(strA).concat("The number of requests has exceeded the usage limits for the Google Maps SDK."), new Object[0]);
        } else if (com.google.android.libraries.navigation.internal.yx.c.c("ok", strA)) {
            dvVar.c(false, false, "", "");
        } else {
            com.google.android.libraries.navigation.internal.abf.p.a(5, com.google.android.libraries.navigation.internal.b.b.g(strA, "Invalid value for Quota Override Flag: ", ". Value has to be one of blocked, exceeded, ok."), new Object[0]);
        }
    }

    private final void V() {
        String str;
        int i = this.t;
        if (i != 1) {
            str = null;
            if (i == 2 ? !this.w.isEmpty() : !(i != 3 && i != 4)) {
                str = "s.t:33|p.v:off";
            }
        } else {
            str = this.u;
        }
        fk fkVar = (fk) this.b.b();
        if (fkVar.V && fkVar.U.x(str)) {
            fkVar.z();
        }
    }

    private final void W(int i) {
        if (i == 1) {
            com.google.android.libraries.navigation.internal.oa.k kVar = this.b;
            kVar.l.d(this.o);
        } else {
            com.google.android.libraries.navigation.internal.oa.k kVar2 = this.b;
            kVar2.l.f(this.o);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.abh.ed
    public final void A(@MapColorScheme int i) {
        if (this.y.g()) {
            return;
        }
        this.s = i;
        if (i == 0) {
            this.b.w(false);
        } else if (i == 1) {
            this.b.w(true);
        } else {
            if (i != 2) {
                return;
            }
            this.b.w((this.r.a.getResources().getConfiguration().uiMode & 48) == 32);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.abh.ed
    public final void B(String str) {
        this.u = str;
        V();
    }

    @Override // com.google.android.libraries.navigation.internal.abh.ed
    public final void C(int i) {
        this.t = i;
        if (this.v) {
            W(i);
            if (i == 0) {
                this.b.z();
            } else if (i == 1) {
                this.b.A();
            } else if (i == 2) {
                this.b.C();
            } else if (i == 3) {
                this.b.F();
            } else if (i != 4) {
                this.b.A();
            } else {
                this.b.B();
            }
            V();
        }
    }

    @Override // com.google.android.libraries.navigation.internal.abh.ed
    public final void D(float f) {
        this.g.f(f);
    }

    @Override // com.google.android.libraries.navigation.internal.abh.ed
    public final void E(float f) {
        this.g.g(f);
    }

    @Override // com.google.android.libraries.navigation.internal.abh.ed
    public final void F(String str, Set set) {
        boolean z;
        ap apVar = this.l;
        apVar.a.a();
        apVar.e.put(str, set);
        Iterator it2 = apVar.e.values().iterator();
        while (it2.hasNext()) {
            if (!((Set) it2.next()).isEmpty()) {
                z = true;
                apVar.d.c(z);
            }
        }
        z = false;
        apVar.d.c(z);
    }

    @Override // com.google.android.libraries.navigation.internal.abh.ed
    public final void G(com.google.android.libraries.navigation.internal.ly.av avVar) {
        ap apVar = this.l;
        apVar.a.a();
        apVar.f = avVar;
    }

    @Override // com.google.android.libraries.navigation.internal.abh.ed
    public final void H(com.google.android.libraries.navigation.internal.ly.az azVar) {
        ap apVar = this.l;
        apVar.a.a();
        apVar.g = azVar;
    }

    @Override // com.google.android.libraries.navigation.internal.abh.ed
    public final void I(com.google.android.libraries.navigation.internal.ly.bn bnVar) {
        ap apVar = this.l;
        apVar.a.a();
        apVar.d.d(bnVar != null);
        apVar.h = bnVar;
    }

    @Override // com.google.android.libraries.navigation.internal.abh.ed
    public final void J(com.google.android.libraries.navigation.internal.ly.bt btVar) {
        this.m.h(btVar);
    }

    @Override // com.google.android.libraries.navigation.internal.abh.ed
    public final boolean K() {
        return this.h.y().g;
    }

    @Override // com.google.android.libraries.navigation.internal.abh.ed
    public final boolean L() {
        return this.h.y().a;
    }

    @Override // com.google.android.libraries.navigation.internal.abh.ed
    public final boolean M() {
        return this.h.y().f;
    }

    @Override // com.google.android.libraries.navigation.internal.abh.ed
    public final boolean N() {
        com.google.android.libraries.navigation.internal.abn.a aVarY = this.h.y();
        return aVarY.e && aVarY.c && aVarY.d && aVarY.b;
    }

    @Override // com.google.android.libraries.navigation.internal.abh.ed
    public final boolean O() {
        com.google.android.libraries.navigation.internal.om.q qVar = this.e;
        if (qVar != null) {
            return qVar.g(this.w);
        }
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.abh.ed
    public final boolean P(boolean z) {
        fk fkVar = (fk) this.b.b();
        if (fkVar.V) {
            com.google.android.libraries.geo.mapcore.renderer.ax axVar = fkVar.B;
            axVar.p = z;
            axVar.o();
        }
        return z;
    }

    @Override // com.google.android.libraries.navigation.internal.abh.ed
    public final boolean Q(boolean z) {
        com.google.android.libraries.navigation.internal.oa.k kVar = this.b;
        if (z) {
            kVar.b().f();
        } else {
            kVar.b().e();
        }
        return z;
    }

    @Override // com.google.android.libraries.navigation.internal.abh.ed
    public final boolean R(boolean z) {
        this.b.x(com.google.android.libraries.navigation.internal.ob.h.TRAFFIC, z);
        return z;
    }

    @Override // com.google.android.libraries.navigation.internal.abh.ed
    public final aj S() {
        return this.f133n;
    }

    @Override // com.google.android.libraries.navigation.internal.abh.ed
    public final void T(com.google.android.libraries.navigation.internal.abh.bj bjVar) {
        this.A = bjVar;
    }

    @Override // com.google.android.libraries.navigation.internal.abh.ed
    public final void U() {
    }

    @Override // com.google.android.libraries.navigation.internal.abh.ed
    @MapColorScheme
    public final int a() {
        return this.s;
    }

    @Override // com.google.android.libraries.navigation.internal.abh.ed
    public final View b() {
        com.google.android.libraries.navigation.internal.oo.b bVar;
        return (!com.google.android.libraries.navigation.internal.afu.m.c() || (bVar = this.c) == null) ? this.b.a() : bVar.f();
    }

    @Override // com.google.android.libraries.navigation.internal.abh.ed
    public final com.google.android.libraries.navigation.internal.abh.ac c() {
        return this.f;
    }

    @Override // com.google.android.libraries.navigation.internal.abh.ed
    public final com.google.android.libraries.navigation.internal.abh.bq d() {
        return this.y;
    }

    @Override // com.google.android.libraries.navigation.internal.abh.ed
    public final ef e() {
        return this.d;
    }

    @Override // com.google.android.libraries.navigation.internal.abh.ed
    public final ey f() {
        return this.j;
    }

    @Override // com.google.android.libraries.navigation.internal.abh.ed
    public final fg g() {
        return this.i;
    }

    @Override // com.google.android.libraries.navigation.internal.abh.ed
    public final fo h() {
        return this.j;
    }

    @Override // com.google.android.libraries.navigation.internal.abh.ed
    public final gv i() {
        return this.k;
    }

    @Override // com.google.android.libraries.navigation.internal.abh.ed
    public final String j() {
        return "P";
    }

    @Override // com.google.android.libraries.navigation.internal.abh.ed
    public final void k(String str) {
        this.v = false;
        this.b.z();
        W(0);
        this.z.a(str);
        this.z.a.setVisibility(0);
    }

    @Override // com.google.android.libraries.navigation.internal.abh.ed
    public final void l() {
        this.v = true;
        C(this.t);
        this.z.a.setVisibility(8);
    }

    @Override // com.google.android.libraries.navigation.internal.abh.ed
    public final void m() {
        com.google.android.libraries.navigation.internal.oo.b bVar;
        com.google.android.libraries.navigation.internal.om.q qVar = this.e;
        if (qVar != null) {
            qVar.b(this.b.hashCode());
            this.e.c(this.b.hashCode());
        }
        this.b.l.f(this.o);
        this.i.d();
        this.d.a().b();
        if (!com.google.android.libraries.navigation.internal.afu.m.c() || (bVar = this.c) == null) {
            this.b.m();
        } else {
            bVar.m();
        }
        this.d.b().h(0.0f);
        this.b.c().c = null;
        com.google.android.libraries.navigation.internal.om.q qVar2 = this.e;
        Boolean bool = false;
        if (qVar2 != null) {
            qVar2.a().d().a(this.w, com.google.android.libraries.navigation.internal.adi.an.MAPS_API_DDS_1P);
            bool.getClass();
            bool.getClass();
            this.b.t(com.google.android.libraries.navigation.internal.adi.an.MAPS_API_DDS_1P.name());
        }
        com.google.android.libraries.navigation.internal.afu.v.c();
        this.q.d.remove(this);
        ap apVar = this.l;
        apVar.a.a();
        com.google.android.libraries.navigation.internal.ol.z zVar = apVar.j;
        if (zVar == null) {
            return;
        }
        zVar.i(null);
        apVar.j.j(null);
        apVar.j = null;
    }

    @Override // com.google.android.libraries.navigation.internal.abh.ed
    public final void n() {
    }

    @Override // com.google.android.libraries.navigation.internal.abh.ed
    public final void o() {
    }

    @Override // com.google.android.libraries.navigation.internal.abh.ed
    public final void p() {
        com.google.android.libraries.navigation.internal.oo.b bVar;
        if (this.x) {
            if (!com.google.android.libraries.navigation.internal.afu.m.c() || (bVar = this.c) == null) {
                this.b.q();
            } else {
                bVar.n();
            }
            this.x = false;
        }
        this.b.h().o();
        this.b.k();
    }

    @Override // com.google.android.libraries.navigation.internal.abh.ed
    public final void q() {
        com.google.android.libraries.navigation.internal.oo.b bVar;
        if (this.x) {
            if (!com.google.android.libraries.navigation.internal.afu.m.c() || (bVar = this.c) == null) {
                this.b.q();
            } else {
                bVar.n();
            }
            this.x = false;
        }
    }

    @Override // com.google.android.libraries.navigation.internal.abh.ed
    public final void r() {
        com.google.android.libraries.navigation.internal.oo.b bVar;
        if (this.x) {
            return;
        }
        if (!com.google.android.libraries.navigation.internal.afu.m.c() || (bVar = this.c) == null) {
            this.b.r();
        } else {
            bVar.o();
        }
        this.x = true;
    }

    @Override // com.google.android.libraries.navigation.internal.abh.ed
    public final void s() {
        this.g.d();
    }

    @Override // com.google.android.libraries.navigation.internal.abh.ed
    public final void t(boolean z) {
        this.h.y().g = z;
    }

    @Override // com.google.android.libraries.navigation.internal.abh.ed
    public final void u(boolean z) {
        this.h.y().a = z;
    }

    @Override // com.google.android.libraries.navigation.internal.abh.ed
    public final void v(boolean z) {
        this.h.y().j = z;
    }

    @Override // com.google.android.libraries.navigation.internal.abh.ed
    public final void w(boolean z) {
        this.h.y().f = z;
    }

    @Override // com.google.android.libraries.navigation.internal.abh.ed
    public final void x(boolean z) {
        com.google.android.libraries.navigation.internal.abn.a aVarY = this.h.y();
        aVarY.e = z;
        aVarY.c = z;
        aVarY.d = z;
        aVarY.b = z;
    }

    @Override // com.google.android.libraries.navigation.internal.abh.ed
    public final void y(com.google.android.libraries.navigation.internal.abh.bv bvVar) {
        this.m.g(bvVar);
    }

    @Override // com.google.android.libraries.navigation.internal.abh.ed
    public final void z(LatLngBounds latLngBounds) {
        this.g.e(latLngBounds);
    }
}
