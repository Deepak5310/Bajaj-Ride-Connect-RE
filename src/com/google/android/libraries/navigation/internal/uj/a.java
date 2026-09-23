package com.google.android.libraries.navigation.internal.uj;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.libraries.geo.navcore.ui.header.views.l;
import com.google.android.libraries.navigation.internal.adr.bm;
import com.google.android.libraries.navigation.internal.bp.bq;
import com.google.android.libraries.navigation.internal.bp.bs;
import com.google.android.libraries.navigation.internal.bp.ca;
import com.google.android.libraries.navigation.internal.dw.h;
import com.google.android.libraries.navigation.internal.hf.n;
import com.google.android.libraries.navigation.internal.ms.cs;
import com.google.android.libraries.navigation.internal.nc.ae;
import com.google.android.libraries.navigation.internal.nc.x;
import com.google.android.libraries.navigation.internal.qz.g;
import com.google.android.libraries.navigation.internal.qz.k;
import com.google.android.libraries.navigation.internal.tj.j;
import com.google.android.libraries.navigation.internal.yx.aq;
import com.google.android.libraries.navigation.internal.yx.ar;
import j$.time.Duration;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class a implements com.google.android.libraries.navigation.internal.uk.a, g {
    private boolean A;
    private com.google.android.libraries.navigation.internal.se.b B;
    private boolean C;
    private boolean D;
    private boolean E;
    private com.google.android.libraries.navigation.internal.uk.a F;
    private final Context a;
    private final com.google.android.libraries.navigation.internal.uk.a.InterfaceC0037a b;
    private final com.google.android.libraries.navigation.internal.uk.a.b c;
    private final com.google.android.libraries.navigation.internal.uk.a.d d;
    private final Runnable e;
    private final com.google.android.libraries.navigation.internal.um.c f;
    private final com.google.android.libraries.navigation.internal.um.c g;
    private final com.google.android.libraries.navigation.internal.uz.b h;
    private final com.google.android.libraries.navigation.internal.hf.c i;
    private final com.google.android.libraries.navigation.internal.uk.a.c j;
    private final com.google.android.libraries.navigation.internal.um.d k;
    private final com.google.android.libraries.navigation.internal.bl.d.a l;
    private final bq m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final l f616n;
    private final C0036a o;
    private final com.google.android.libraries.navigation.internal.up.g p;
    private final com.google.android.libraries.navigation.internal.bl.d.a q;
    private final int s;
    private final boolean t;
    private CharSequence u;
    private String v;
    private com.google.android.libraries.geo.navcore.ui.header.views.d w;
    private CharSequence x;
    private CharSequence y;
    private CharSequence z;

    /* JADX INFO: renamed from: com.google.android.libraries.navigation.internal.uj.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: PG */
    public class C0036a {
        public final int a;
        public final int b;

        public C0036a(int i, int i2) {
            this.a = i;
            this.b = i2;
        }
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0095  */
    public a(com.google.android.libraries.navigation.internal.up.g gVar, com.google.android.libraries.navigation.internal.hf.c cVar, com.google.android.libraries.navigation.internal.bn.d dVar, C0036a c0036a, com.google.android.libraries.navigation.internal.uk.a.InterfaceC0037a interfaceC0037a, com.google.android.libraries.navigation.internal.uk.a.b bVar, com.google.android.libraries.navigation.internal.uk.a.d dVar2, com.google.android.libraries.navigation.internal.um.d dVar3, com.google.android.libraries.navigation.internal.um.d.a aVar, com.google.android.libraries.navigation.internal.uz.c cVar2, com.google.android.libraries.navigation.internal.fz.d dVar4, com.google.android.libraries.navigation.internal.cc.b bVar2, Context context, bq bqVar, com.google.android.libraries.navigation.internal.ui.a aVar2, com.google.android.libraries.navigation.internal.uk.a.c cVar3, boolean z, com.google.android.libraries.navigation.internal.uk.a aVar3, Runnable runnable, Runnable runnable2, boolean z2, boolean z3, int i) {
        com.google.android.libraries.navigation.internal.bl.d.a aVarE;
        com.google.android.libraries.navigation.internal.uz.b bVarE;
        bq bqVar2;
        this.a = context;
        this.m = bqVar;
        this.p = gVar;
        this.i = cVar;
        this.j = cVar3;
        boolean z4 = bqVar == aVar2.h.c().c;
        this.E = z4;
        this.o = c0036a;
        this.b = interfaceC0037a;
        this.c = bVar;
        this.d = dVar2;
        this.k = dVar3;
        this.f616n = new l(bqVar, gVar);
        this.f = aVar.a(false, z4);
        this.g = aVar.a(true, z4);
        this.e = runnable2;
        this.s = i;
        bq bqVar3 = bqVar.M;
        if (z4) {
            Duration duration = ca.a;
            if (bqVar.d == com.google.android.libraries.navigation.internal.aap.l.DESTINATION || (bqVar2 = bqVar.M) == null || ((bqVar2.f355n.compareTo(ca.a) > 0 && bqVar2.l > 500) || bqVar2.d == com.google.android.libraries.navigation.internal.aap.l.ROUNDABOUT_EXIT || bqVar3 == null || !com.google.android.libraries.navigation.internal.bl.d.g(bqVar3))) {
                aVarE = null;
            } else {
                aVarE = com.google.android.libraries.navigation.internal.bl.d.e(bqVar3);
            }
        } else {
            aVarE = null;
        }
        this.q = aVarE;
        this.l = com.google.android.libraries.navigation.internal.bl.d.g(bqVar) ? com.google.android.libraries.navigation.internal.bl.d.e(bqVar) : null;
        com.google.android.libraries.navigation.internal.se.b bVarC = aVar2.h.c();
        this.B = bVarC;
        bm.a aVar4 = bVarC.b.O;
        if (cVar2 == null) {
            bVarE = null;
        } else {
            ar.r(bVar2, "Should be set if directionsStepViewModelImplFactory is");
            bVarE = com.google.android.libraries.navigation.internal.uz.b.e(cVar2, bVar2, context, bqVar, this.B.b, cVar, aVar4, dVar, z, null, null);
        }
        this.h = bVarE;
        G(z);
        this.t = z2;
        if (this.E) {
            H(aVar2);
        } else {
            this.D = false;
            this.y = null;
            this.z = null;
            this.x = null;
            this.C = L(bqVar, this.B.d, false);
            J();
        }
        this.F = aVar3;
    }

    private final void J() {
        com.google.android.libraries.navigation.internal.se.b bVar = this.B;
        bm.a aVar = bVar.b.O;
        boolean z = this.E;
        int i = z ? bVar.f : this.m.l;
        this.u = x(i, aVar, this.o, this.i, this.A, false, j(), Boolean.valueOf(z), this.a);
        this.v = this.i.d(i, aVar, true, false);
    }

    private final void K() {
        com.google.android.libraries.navigation.internal.up.a aVar;
        bq bqVar;
        C0036a c0036a = this.o;
        int i = this.A ? c0036a.b : c0036a.a;
        bq bqVar2 = this.m;
        com.google.android.libraries.navigation.internal.up.g gVar = this.p;
        com.google.android.libraries.navigation.internal.up.a aVar2 = new com.google.android.libraries.navigation.internal.up.a(this.a, 1, 1, -1, true, null, true, i, 0.6f, 1.0f, 0.75f, 0, null, null);
        gVar.g(ca.c(bqVar2), aVar2);
        CharSequence charSequence = (CharSequence) aVar2.d().get(0);
        Context context = this.a;
        com.google.android.libraries.navigation.internal.hf.c cVar = this.i;
        com.google.android.libraries.navigation.internal.up.g gVar2 = this.p;
        bq bqVar3 = this.m;
        com.google.android.libraries.navigation.internal.se.b bVar = this.B;
        C0036a c0036a2 = this.o;
        com.google.android.libraries.navigation.internal.up.a aVar3 = new com.google.android.libraries.navigation.internal.up.a(context, 1, 1, -1, true, null, true, this.A ? c0036a2.b : c0036a2.a, 0.6f, 1.0f, 0.75f, -1, com.google.android.libraries.navigation.internal.ih.a.c(cVar), bVar.b.O);
        int i2 = bVar.f;
        String string = gVar2.e.getResources().getString(h.H);
        int iIndexOf = string.indexOf("{0}");
        int iIndexOf2 = string.indexOf("{1}");
        String strSubstring = string.substring(0, Math.min(iIndexOf, iIndexOf2));
        if (aq.c(strSubstring)) {
            aVar = aVar3;
        } else {
            aVar = aVar3;
            aVar.f(strSubstring);
        }
        if (iIndexOf < iIndexOf2) {
            aVar.b(i2);
            bqVar = bqVar3;
        } else {
            bqVar = bqVar3;
            gVar2.c(bqVar, aVar);
        }
        int i3 = iIndexOf + 3;
        int i4 = iIndexOf2 + 3;
        String strSubstring2 = string.substring(Math.min(i3, i4), Math.max(iIndexOf, iIndexOf2));
        if (!aq.c(strSubstring2)) {
            aVar.f(strSubstring2);
        }
        if (iIndexOf < iIndexOf2) {
            gVar2.c(bqVar, aVar);
        } else {
            aVar.b(i2);
        }
        String strSubstring3 = string.substring(Math.max(i3, i4));
        if (!aq.c(strSubstring3)) {
            aVar.f(strSubstring3);
        }
        CharSequence charSequence2 = (CharSequence) aVar.d().get(0);
        this.x = TextUtils.concat(charSequence, StringUtils.SPACE, charSequence2);
        this.y = charSequence;
        this.z = charSequence2;
    }

    private final boolean L(bq bqVar, boolean z, boolean z2) {
        if (this.t) {
            return false;
        }
        if (!z2) {
            return true;
        }
        Duration duration = ca.a;
        return bqVar.d() == null || z;
    }

    public static CharSequence x(int i, bm.a aVar, C0036a c0036a, com.google.android.libraries.navigation.internal.hf.c cVar, boolean z, boolean z2, com.google.android.libraries.navigation.internal.uk.a.d dVar, Boolean bool, Context context) {
        n.a aVar2 = new n.a();
        n.a aVar3 = new n.a();
        int i2 = z ? c0036a.b : c0036a.a;
        x xVarB = dVar.b(bool.booleanValue());
        Float fValueOf = null;
        Integer numValueOf = xVarB != null ? Integer.valueOf(((ae) xVarB).a) : null;
        x xVarA = dVar.a(bool.booleanValue());
        Integer numValueOf2 = xVarA != null ? Integer.valueOf(((ae) xVarA).a) : null;
        if (numValueOf2 == null) {
            numValueOf2 = Integer.valueOf(i2);
        }
        bool.booleanValue();
        com.google.android.libraries.navigation.internal.nc.a aVarG = dVar.g();
        Float fValueOf2 = aVarG != null ? Float.valueOf(aVarG.a(context)) : null;
        bool.booleanValue();
        com.google.android.libraries.navigation.internal.nc.a aVarF = dVar.f();
        Float fValueOf3 = aVarF != null ? Float.valueOf(aVarF.a(context)) : null;
        if (fValueOf3 != null && fValueOf2 != null && fValueOf2.floatValue() > 0.0f) {
            fValueOf = Float.valueOf(fValueOf3.floatValue() / fValueOf2.floatValue());
        }
        if (fValueOf == null) {
            fValueOf = Float.valueOf(0.6f);
        }
        aVar2.c();
        if (numValueOf != null) {
            aVar2.d(numValueOf.intValue());
        }
        aVar3.e(fValueOf.floatValue());
        aVar3.d(numValueOf2.intValue());
        return i > 0 ? cVar.g(i, aVar, aVar2, aVar3) : "";
    }

    @Override // com.google.android.libraries.navigation.internal.uk.a
    public CharSequence A() {
        return this.x;
    }

    @Override // com.google.android.libraries.navigation.internal.uk.a
    public CharSequence B() {
        return this.y;
    }

    @Override // com.google.android.libraries.navigation.internal.uk.a
    public CharSequence C() {
        return this.z;
    }

    @Override // com.google.android.libraries.navigation.internal.uk.a
    public CharSequence D() {
        return this.m.s;
    }

    @Override // com.google.android.libraries.navigation.internal.uk.a
    public String E() {
        if (!o().booleanValue()) {
            return this.m.q;
        }
        com.google.android.libraries.navigation.internal.hf.b bVar = new com.google.android.libraries.navigation.internal.hf.b(this.a);
        bVar.a(z());
        bVar.a(this.m.q);
        return bVar.toString();
    }

    @Override // com.google.android.libraries.navigation.internal.uk.a
    public String F() {
        return this.m.p.toString();
    }

    @Override // com.google.android.libraries.navigation.internal.uk.a
    public void G(boolean z) {
        if (this.A != z || this.w == null) {
            this.A = z;
            bq bqVar = this.m;
            Duration duration = ca.a;
            this.w = new com.google.android.libraries.geo.navcore.ui.header.views.d(!bqVar.B.isEmpty() ? this.m.B : null, this.k, this.A ? this.g : this.f);
            if (v().booleanValue()) {
                K();
            }
            if (o().booleanValue()) {
                J();
            }
        }
    }

    public void H(com.google.android.libraries.navigation.internal.ui.a aVar) {
        j jVar;
        this.D = aVar.k;
        if (!this.E || (jVar = aVar.h) == null) {
            return;
        }
        this.B = jVar.c();
        J();
        e eVar = new e(this);
        boolean z = this.D && jVar.e();
        bs bsVarC = ca.c(this.m);
        if (!z || bsVarC == null) {
            this.y = null;
            this.z = null;
            this.x = null;
        } else {
            K();
        }
        bq bqVar = this.m;
        boolean z2 = this.D;
        this.C = L(bqVar, z2 && this.B.d, z2);
        if (eVar.t().equals(t()) && eVar.u().equals(u())) {
            return;
        }
        this.F = eVar;
    }

    public void I(com.google.android.libraries.navigation.internal.ui.a aVar) {
        j jVar = aVar.h;
        if (jVar != null) {
            this.E = this.m == jVar.c().c;
        }
    }

    @Override // com.google.android.libraries.navigation.internal.qz.g
    public void a(k kVar) {
        this.e.run();
    }

    @Override // com.google.android.libraries.navigation.internal.uk.a
    public int b(int i, boolean z, boolean z2) {
        return this.s + h().b(z2, q().booleanValue(), w().booleanValue()) + 48;
    }

    @Override // com.google.android.libraries.navigation.internal.uk.a
    public int c() {
        return this.s;
    }

    @Override // com.google.android.libraries.navigation.internal.uk.a
    public com.google.android.libraries.navigation.internal.bl.d.a d() {
        return this.l;
    }

    @Override // com.google.android.libraries.navigation.internal.uk.a
    public com.google.android.libraries.navigation.internal.bl.d.a e() {
        return this.q;
    }

    public bq f() {
        return this.m;
    }

    @Override // com.google.android.libraries.navigation.internal.uk.a
    public cs.a g() {
        this.j.i(this.m);
        return cs.a.a;
    }

    @Override // com.google.android.libraries.navigation.internal.uk.a
    public com.google.android.libraries.navigation.internal.uk.a.InterfaceC0037a h() {
        return this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.uk.a
    public com.google.android.libraries.navigation.internal.uk.a.b i() {
        return this.c;
    }

    @Override // com.google.android.libraries.navigation.internal.uk.a
    public com.google.android.libraries.navigation.internal.uk.a.d j() {
        return this.d;
    }

    @Override // com.google.android.libraries.navigation.internal.uk.a
    public com.google.android.libraries.navigation.internal.uk.a k() {
        return this.F;
    }

    @Override // com.google.android.libraries.navigation.internal.uk.a
    public com.google.android.libraries.geo.navcore.ui.header.views.d l() {
        return this.w;
    }

    @Override // com.google.android.libraries.navigation.internal.uk.a
    public l m() {
        return this.f616n;
    }

    @Override // com.google.android.libraries.navigation.internal.uk.a
    public com.google.android.libraries.navigation.internal.va.b n() {
        return this.h;
    }

    @Override // com.google.android.libraries.navigation.internal.uk.a
    public Boolean o() {
        CharSequence charSequence = this.u;
        boolean z = false;
        if (charSequence != null && charSequence.length() > 0) {
            z = true;
        }
        return Boolean.valueOf(z);
    }

    @Override // com.google.android.libraries.navigation.internal.uk.a
    public Boolean p() {
        return Boolean.valueOf(this.l != null);
    }

    @Override // com.google.android.libraries.navigation.internal.uk.a
    public Boolean q() {
        return Boolean.valueOf(this.E);
    }

    @Override // com.google.android.libraries.navigation.internal.uk.a
    public Boolean r() {
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.uk.a
    public Boolean s() {
        return Boolean.valueOf(this.t);
    }

    @Override // com.google.android.libraries.navigation.internal.uk.a
    public Boolean t() {
        boolean z = false;
        if (this.w.a != null && this.C && !v().booleanValue()) {
            z = true;
        }
        return Boolean.valueOf(z);
    }

    @Override // com.google.android.libraries.navigation.internal.uk.a
    public Boolean u() {
        boolean z = false;
        if (this.q != null && this.D && this.C && !v().booleanValue() && !t().booleanValue() && !s().booleanValue()) {
            z = true;
        }
        return Boolean.valueOf(z);
    }

    @Override // com.google.android.libraries.navigation.internal.uk.a
    public Boolean v() {
        boolean z = false;
        if (this.x != null && this.y != null && this.z != null) {
            z = true;
        }
        return Boolean.valueOf(z);
    }

    @Override // com.google.android.libraries.navigation.internal.uk.a
    public Boolean w() {
        return Boolean.valueOf(this.A);
    }

    @Override // com.google.android.libraries.navigation.internal.uk.a
    public CharSequence y() {
        return this.u;
    }

    @Override // com.google.android.libraries.navigation.internal.uk.a
    public CharSequence z() {
        return this.v;
    }
}
