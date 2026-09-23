package com.google.android.libraries.navigation.internal.us;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import com.google.android.libraries.navigation.internal.aac.az;
import com.google.android.libraries.navigation.internal.aac.bj;
import com.google.android.libraries.navigation.internal.aac.bn;
import com.google.android.libraries.navigation.internal.ms.cy;
import com.google.android.libraries.navigation.internal.tj.u;
import com.google.android.libraries.navigation.internal.yx.ar;
import com.google.android.libraries.navigation.internal.yz.eq;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.lv;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class y<T extends com.google.android.libraries.navigation.internal.tj.u> implements com.google.android.libraries.navigation.internal.ut.d {
    private static final com.google.android.libraries.navigation.internal.zb.j x = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.navigation.internal.us.y");
    private List A;
    private List B;
    private com.google.android.libraries.navigation.internal.nc.ah C;
    private final List D;
    private com.google.android.libraries.navigation.internal.ut.d.b E;
    private com.google.android.libraries.navigation.internal.ut.d.b F;
    private boolean G;
    private int H;
    private int I;
    private int J;
    private int K;
    private boolean L;
    private final com.google.android.libraries.navigation.internal.ah.a.InterfaceC0032a M;
    protected final com.google.android.libraries.navigation.internal.tj.u a;
    protected final Context b;
    protected final com.google.android.libraries.navigation.internal.ia.e c;
    protected final com.google.android.libraries.navigation.internal.fz.d d;
    protected final com.google.android.libraries.navigation.internal.sl.d e;
    protected final com.google.android.libraries.navigation.internal.sn.h f;
    protected final Resources g;
    protected final com.google.android.libraries.navigation.internal.mj.a h;
    protected final com.google.android.libraries.navigation.internal.jy.af i;
    protected final com.google.android.libraries.navigation.internal.jy.t j;
    protected final Executor k;
    public boolean l;
    public CharSequence m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public CharSequence f626n;
    public CharSequence o;
    public com.google.android.libraries.navigation.internal.ut.d.InterfaceC0038d p;
    public com.google.android.libraries.navigation.internal.jy.aa q;
    public com.google.android.libraries.navigation.internal.sl.a s;
    public com.google.android.libraries.navigation.internal.ag.e t;
    public long u;
    public boolean v;
    protected final com.google.android.libraries.navigation.internal.sl.c w;
    private final com.google.android.libraries.navigation.internal.ch.b y;
    private final AccessibilityManager z;

    @Deprecated
    protected y(com.google.android.libraries.navigation.internal.tj.u uVar, Context context, com.google.android.libraries.navigation.internal.ia.e eVar, com.google.android.libraries.navigation.internal.fz.d dVar, com.google.android.libraries.navigation.internal.sl.d dVar2, com.google.android.libraries.navigation.internal.sn.h hVar, Resources resources, com.google.android.libraries.navigation.internal.mj.a aVar, com.google.android.libraries.navigation.internal.jy.af afVar, com.google.android.libraries.navigation.internal.jy.t tVar, bn bnVar, Executor executor, long j, com.google.android.libraries.navigation.internal.ch.b bVar) {
        this.l = false;
        int i = ev.d;
        this.A = lv.a;
        this.D = new ArrayList();
        this.K = -1;
        this.w = new v(this);
        w wVar = new w(this);
        this.M = wVar;
        this.a = uVar;
        this.b = context;
        this.c = eVar;
        this.d = dVar;
        this.e = dVar2;
        this.f = hVar;
        this.g = resources;
        this.h = aVar;
        this.i = afVar;
        this.j = tVar;
        this.k = bnVar;
        this.z = (AccessibilityManager) context.getSystemService("accessibility");
        this.u = j;
        this.y = bVar;
        this.t = new com.google.android.libraries.navigation.internal.ag.e(wVar, bnVar, executor);
    }

    protected static final List X(CharSequence... charSequenceArr) {
        int i = ev.d;
        eq eqVar = new eq();
        for (CharSequence charSequence : charSequenceArr) {
            if (!TextUtils.isEmpty(charSequence)) {
                eqVar.h(new com.google.android.libraries.navigation.internal.ag.f(charSequence));
            }
        }
        return eqVar.g();
    }

    @Override // com.google.android.libraries.navigation.internal.ut.d
    public CharSequence A() {
        return this.f626n;
    }

    @Override // com.google.android.libraries.navigation.internal.ut.d
    public Integer B() {
        return Integer.valueOf(this.J);
    }

    @Override // com.google.android.libraries.navigation.internal.ut.d
    public Integer C() {
        return Integer.valueOf(this.I);
    }

    @Override // com.google.android.libraries.navigation.internal.ut.d
    public Integer D() {
        return Integer.valueOf(this.H);
    }

    @Override // com.google.android.libraries.navigation.internal.ut.d
    public Integer E() {
        return Integer.valueOf(this.K);
    }

    @Override // com.google.android.libraries.navigation.internal.ut.d
    public String F() {
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.ut.d
    public List<com.google.android.libraries.navigation.internal.ut.d.b> G() {
        return this.D;
    }

    @Override // com.google.android.libraries.navigation.internal.ut.d
    public List<com.google.android.libraries.navigation.internal.ai.c> H() {
        List<com.google.android.libraries.navigation.internal.ai.c> list = this.B;
        return (list == null || !com.google.android.libraries.navigation.internal.nu.a.a(this.b)) ? this.A : list;
    }

    protected final void J(com.google.android.libraries.navigation.internal.ut.d.b bVar) {
        this.D.add(bVar);
        if (bVar instanceof com.google.android.libraries.navigation.internal.ut.d.InterfaceC0038d) {
            ar.l(this.p == null, "Only one button can have a timeout!");
            this.p = (com.google.android.libraries.navigation.internal.ut.d.InterfaceC0038d) bVar;
        }
        if (bVar.n().booleanValue()) {
            ar.l(this.E == null, "Only one button can show a confirmation dialog!");
            this.E = bVar;
        }
    }

    protected final void K(com.google.android.libraries.navigation.internal.ut.d.b bVar) {
        ar.l(this.F == null, "Only one button can be the dismiss button!");
        J(bVar);
        this.F = bVar;
    }

    public void L() {
        V();
        this.k.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.us.s
            @Override // java.lang.Runnable
            public final void run() {
                y yVar = this.a;
                yVar.c.a(new com.google.android.libraries.navigation.internal.sr.o(yVar.a));
            }
        });
    }

    @Override // com.google.android.libraries.navigation.internal.ut.d
    public void M(int i, int i2, int i3) {
        this.H = i;
        this.I = i2;
        this.J = i3;
    }

    public final void N(com.google.android.libraries.navigation.internal.nc.ah ahVar) {
        this.C = ahVar;
        cy.a(this);
    }

    @Override // com.google.android.libraries.navigation.internal.ut.d
    public void O() {
        this.G = true;
    }

    @Override // com.google.android.libraries.navigation.internal.ut.d
    public void P(boolean z) {
        this.L = true;
    }

    @Override // com.google.android.libraries.navigation.internal.ut.d
    public void Q(int i) {
        this.K = i;
    }

    protected final void R(CharSequence... charSequenceArr) {
        this.A = X(charSequenceArr);
    }

    protected final void S(CharSequence... charSequenceArr) {
        this.B = X(charSequenceArr);
    }

    public final void T() {
        if (!this.a.d()) {
            this.a.f();
            com.google.android.libraries.navigation.internal.vn.d dVarA = a();
            if (dVarA != null) {
                az.o(q(dVarA), new u(this), com.google.android.libraries.navigation.internal.aac.ac.INSTANCE);
                return;
            }
        }
        this.v = true;
        this.t.g(h(this.u));
    }

    public final void U() {
        this.t.f();
    }

    protected final void V() {
        com.google.android.libraries.navigation.internal.sl.a aVar = this.s;
        if (aVar != null) {
            this.e.k(aVar);
        }
    }

    public boolean W() {
        return this.G;
    }

    protected final m Y() {
        m mVarM = m(true);
        mVarM.c = l.a;
        mVarM.e = com.google.android.libraries.navigation.internal.ut.d.b.a.DISMISS;
        return mVarM;
    }

    protected com.google.android.libraries.navigation.internal.vn.d a() {
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.ut.d
    public void b() {
        if (t().booleanValue()) {
            return;
        }
        T();
    }

    @Override // com.google.android.libraries.navigation.internal.ut.d
    public void c() {
        this.l = true;
        this.t.d();
    }

    protected void d() {
    }

    @Override // com.google.android.libraries.navigation.internal.ut.d
    public com.google.android.libraries.navigation.internal.ut.d.c f() {
        return com.google.android.libraries.navigation.internal.ut.d.c.DEFAULT;
    }

    public final long h(long j) {
        return (this.z == null || Build.VERSION.SDK_INT < 29) ? j : this.z.getRecommendedTimeoutMillis((int) j, 6);
    }

    @Override // com.google.android.libraries.navigation.internal.ut.d
    public View.AccessibilityDelegate i() {
        return new t(this);
    }

    @Override // com.google.android.libraries.navigation.internal.ut.d
    public com.google.android.libraries.navigation.internal.jy.aa j() {
        return this.q;
    }

    @Override // com.google.android.libraries.navigation.internal.ut.d
    public com.google.android.libraries.navigation.internal.nc.ah k() {
        return this.C;
    }

    @Override // com.google.android.libraries.navigation.internal.ut.d
    public T l() {
        return (T) this.a;
    }

    /* JADX WARN: Code duplicated, block: B:29:0x005f  */
    protected final m m(boolean z) {
        m mVar = new m(this, this.i);
        mVar.j = z;
        com.google.android.libraries.navigation.internal.ag.e eVar = null;
        if (z) {
            if (Build.VERSION.SDK_INT >= 29) {
                eVar = this.t;
            } else if (Build.VERSION.SDK_INT < 29) {
                Context context = this.b;
                Intrinsics.checkNotNullParameter(context, "context");
                com.google.android.libraries.navigation.internal.zp.d dVarA = com.google.android.libraries.navigation.internal.mi.a.a(context);
                Intrinsics.checkNotNullExpressionValue(dVarA, "getAccessibilityState(...)");
                int iA = com.google.android.libraries.navigation.internal.zp.c.a(dVarA.c);
                if (iA == 0) {
                    iA = com.google.android.libraries.navigation.internal.zp.c.a;
                }
                if (iA != com.google.android.libraries.navigation.internal.zp.c.b) {
                    int iA2 = com.google.android.libraries.navigation.internal.zp.c.a(dVarA.d);
                    if (iA2 == 0) {
                        iA2 = com.google.android.libraries.navigation.internal.zp.c.a;
                    }
                    if (iA2 != com.google.android.libraries.navigation.internal.zp.c.b) {
                        int iA3 = com.google.android.libraries.navigation.internal.zp.c.a(dVarA.e);
                        if (iA3 == 0) {
                            iA3 = com.google.android.libraries.navigation.internal.zp.c.a;
                        }
                        if (iA3 != com.google.android.libraries.navigation.internal.zp.c.b) {
                            int iA4 = com.google.android.libraries.navigation.internal.zp.c.a(dVarA.f);
                            if (iA4 == 0) {
                                iA4 = com.google.android.libraries.navigation.internal.zp.c.a;
                            }
                            if (iA4 != com.google.android.libraries.navigation.internal.zp.c.b) {
                                eVar = this.t;
                            }
                        }
                    }
                }
            }
        }
        mVar.k = eVar;
        return mVar;
    }

    @Override // com.google.android.libraries.navigation.internal.ut.d
    public com.google.android.libraries.navigation.internal.ut.d.b n() {
        return this.E;
    }

    @Override // com.google.android.libraries.navigation.internal.ut.d
    public com.google.android.libraries.navigation.internal.ut.d.b o() {
        return this.F;
    }

    @Override // com.google.android.libraries.navigation.internal.ut.d
    public com.google.android.libraries.navigation.internal.ut.d.InterfaceC0038d p() {
        return this.p;
    }

    protected final bj q(com.google.android.libraries.navigation.internal.vn.d dVar) {
        return this.e.i(dVar, com.google.android.libraries.navigation.internal.sl.h.g, this.w);
    }

    @Override // com.google.android.libraries.navigation.internal.ut.d
    public Boolean r() {
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.ut.d
    public Boolean s() {
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.ut.d
    public Boolean t() {
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.ut.d
    public Boolean u() {
        return Boolean.valueOf(this.L);
    }

    @Override // com.google.android.libraries.navigation.internal.ut.d
    public Boolean v() {
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.ut.d
    public Boolean w() {
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.ut.d
    public CharSequence x() {
        return this.m;
    }

    @Override // com.google.android.libraries.navigation.internal.ut.d
    public CharSequence y() {
        return this.o;
    }

    @Override // com.google.android.libraries.navigation.internal.ut.d
    public CharSequence z() {
        return null;
    }

    protected y(com.google.android.libraries.navigation.internal.tj.u uVar, Context context, com.google.android.libraries.navigation.internal.ia.e eVar, com.google.android.libraries.navigation.internal.fz.d dVar, com.google.android.libraries.navigation.internal.sl.d dVar2, com.google.android.libraries.navigation.internal.sn.h hVar, Resources resources, com.google.android.libraries.navigation.internal.mj.a aVar, com.google.android.libraries.navigation.internal.jy.af afVar, com.google.android.libraries.navigation.internal.jy.t tVar, bn bnVar, Executor executor, com.google.android.libraries.navigation.internal.uq.m mVar, com.google.android.libraries.navigation.internal.ch.b bVar) {
        this(uVar, context, eVar, dVar, dVar2, hVar, resources, aVar, afVar, tVar, bnVar, executor, uVar.b().toMillis(), bVar);
    }
}
