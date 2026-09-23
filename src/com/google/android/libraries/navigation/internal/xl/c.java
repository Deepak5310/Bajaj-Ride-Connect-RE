package com.google.android.libraries.navigation.internal.xl;

import android.content.Context;
import android.view.View;
import com.google.android.libraries.navigation.internal.afe.i;
import com.google.android.libraries.navigation.internal.afl.fs;
import com.google.android.libraries.navigation.internal.dw.h;
import com.google.android.libraries.navigation.internal.hn.r;
import com.google.android.libraries.navigation.internal.hx.ap;
import com.google.android.libraries.navigation.internal.jy.aa;
import com.google.android.libraries.navigation.internal.jy.p;
import com.google.android.libraries.navigation.internal.ms.at;
import com.google.android.libraries.navigation.internal.ms.cs;
import com.google.android.libraries.navigation.internal.nt.t;
import com.google.android.libraries.navigation.internal.uu.q;
import com.google.android.libraries.navigation.internal.vd.g;
import com.google.android.libraries.navigation.internal.vd.m;
import com.google.android.libraries.navigation.internal.xe.bh;
import com.google.android.libraries.navigation.internal.yz.fz;
import com.google.android.libraries.navigation.internal.zb.j;
import com.google.android.libraries.navigation.o;
import java.util.Optional;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class c extends com.google.android.libraries.navigation.internal.ag.a implements com.google.android.libraries.navigation.internal.xk.a {
    private static final j b = j.e("com.google.android.libraries.navigation.internal.xl.c");
    private final Context c;
    private final com.google.android.libraries.navigation.internal.ia.e d;
    private final at e;
    private final a f;
    private final m g;
    private final com.google.android.libraries.navigation.internal.ed.b h;
    private final Executor i;
    private final AtomicBoolean j;
    private AtomicBoolean k;
    private final AtomicReference l;
    private final t m;

    /* JADX INFO: compiled from: PG */
    public interface a {
    }

    public c(Context context, com.google.android.libraries.navigation.internal.ia.e eVar, at atVar, a aVar, g gVar, com.google.android.libraries.navigation.internal.ed.b bVar, m mVar, Executor executor, r<fs> rVar) {
        super(context, com.google.android.libraries.navigation.internal.ag.a.EnumC0031a.FIXED, com.google.android.libraries.navigation.internal.ai.b.a.b, com.google.android.libraries.navigation.internal.af.e.c(com.google.android.libraries.navigation.internal.dw.c.t, com.google.android.libraries.navigation.internal.dw.c.u), context.getString(h.X), aa.k(i.f254n), true, View.generateViewId(), context.getResources().getConfiguration().smallestScreenWidthDp <= 360 ? com.google.android.libraries.navigation.internal.ag.a.b.MEDIUM : com.google.android.libraries.navigation.internal.ag.a.b.FULL);
        this.j = new AtomicBoolean(true);
        this.k = new AtomicBoolean(false);
        this.l = new AtomicReference(d.UNREGISTERED);
        this.m = new b(this);
        this.c = context;
        this.d = eVar;
        this.f = aVar;
        this.k = new AtomicBoolean(gVar.b());
        this.e = atVar;
        this.h = bVar;
        this.g = mVar;
        this.i = executor;
    }

    public final void A() {
        aD(this.h.c() ? com.google.android.libraries.navigation.internal.ai.b.a.c : com.google.android.libraries.navigation.internal.ai.b.a.b);
        this.e.a(this);
    }

    @Override // com.google.android.libraries.navigation.internal.ag.a
    public void n(boolean z) {
        if (aE() != z) {
            super.n(z);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.xk.a
    public String o() {
        return "";
    }

    @Override // com.google.android.libraries.navigation.internal.xk.a
    public boolean v() {
        return this.g.a;
    }

    @Override // com.google.android.libraries.navigation.internal.ai.b
    public cs.a w(p pVar) {
        boolean z = this.k.get();
        bh bhVar = ((o) this.f).a;
        com.google.android.libraries.navigation.internal.ia.e eVar = bhVar.b;
        q qVar = bhVar.c;
        int i = qVar.y;
        int i2 = qVar.h;
        eVar.a(new com.google.android.libraries.navigation.internal.ss.b(Optional.empty(), z, new com.google.android.libraries.navigation.internal.si.h(i2 == -1 ? null : Integer.valueOf(i2), qVar.f, i == 3)));
        return cs.a.a;
    }

    public void x(com.google.android.libraries.navigation.internal.ve.d dVar) {
        boolean zC = dVar.c();
        if (this.k.compareAndSet(!zC, zC)) {
            boolean z = this.k.get();
            if (this.j.compareAndSet(z, !z)) {
                this.e.a(this);
            }
        }
    }

    public void y() {
        try {
            if (com.google.android.libraries.navigation.internal.xl.a.a(this.l, d.UNREGISTERED, d.REGISTERED)) {
                com.google.android.libraries.navigation.internal.ia.e eVar = this.d;
                fz fzVar = new fz();
                fzVar.b(com.google.android.libraries.navigation.internal.ve.d.class, new e(com.google.android.libraries.navigation.internal.ve.d.class, this, ap.DANGEROUS_PUBLISHER_THREAD));
                eVar.c(this, fzVar.a());
                this.h.a().g(this.m, this.i);
            }
        } catch (IllegalArgumentException | SecurityException e) {
            ((com.google.android.libraries.navigation.internal.zb.h) ((com.google.android.libraries.navigation.internal.zb.h) b.d(com.google.android.libraries.navigation.internal.nl.a.a).g(e)).F((char) 2016)).p("Failed to register ReportIncidentFabViewModelImpl");
        }
        A();
    }

    public void z() {
        try {
            if (com.google.android.libraries.navigation.internal.xl.a.a(this.l, d.REGISTERED, d.UNREGISTERED)) {
                this.d.e(this);
                this.h.a().h(this.m);
            }
        } catch (IllegalArgumentException e) {
            ((com.google.android.libraries.navigation.internal.zb.h) ((com.google.android.libraries.navigation.internal.zb.h) b.d(com.google.android.libraries.navigation.internal.nl.a.a).g(e)).F((char) 2017)).p("Failed to unregister ReportIncidentFabViewModelImpl");
        }
    }
}
