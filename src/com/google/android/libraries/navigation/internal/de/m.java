package com.google.android.libraries.navigation.internal.de;

import android.content.Context;
import android.os.Looper;
import android.view.WindowManager;
import com.google.android.libraries.navigation.internal.aac.bn;
import com.google.android.libraries.navigation.internal.ady.al;
import com.google.android.libraries.navigation.internal.afl.ds;
import com.google.android.libraries.navigation.internal.hx.ap;
import com.google.android.libraries.navigation.internal.yx.ar;
import com.google.android.libraries.navigation.internal.yz.fz;
import com.google.android.libraries.navigation.internal.yz.kc;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class m implements com.google.android.libraries.navigation.internal.cw.m {
    public final com.google.android.libraries.navigation.internal.ia.e a;
    public final com.google.android.libraries.navigation.internal.cw.p e;
    final i g;
    private final com.google.android.libraries.navigation.internal.rw.f h;
    private com.google.android.libraries.navigation.internal.cw.p l;
    private final com.google.android.libraries.navigation.internal.cw.p m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final com.google.android.libraries.navigation.internal.cw.p f389n;
    private final k o;
    private final com.google.android.libraries.navigation.internal.hn.r p;
    private final Map i = new HashMap();
    private final Map j = kc.g(com.google.android.libraries.navigation.internal.cw.l.class);
    private boolean k = false;
    public al b = al.WALK;
    public boolean c = false;
    public final boolean d = false;
    final h f = new h(this);

    public m(com.google.android.libraries.navigation.internal.ia.e eVar, com.google.android.libraries.navigation.internal.rw.q qVar, com.google.android.libraries.navigation.internal.rw.f fVar, Executor executor, Context context, com.google.android.libraries.navigation.internal.mj.a aVar, com.google.android.libraries.navigation.internal.cw.a aVar2, ds dsVar, bn bnVar, Looper looper, bn bnVar2, com.google.android.libraries.navigation.internal.hn.r rVar) {
        v vVar = new v(new l(aVar2), aVar, bnVar2, dsVar);
        if (vVar.l != context) {
            vVar.l = context;
            vVar.m = null;
            vVar.L = (WindowManager) context.getSystemService("window");
            int i = com.google.android.libraries.navigation.internal.fs.b.a;
            vVar.T = false;
            if (vVar.o()) {
                vVar.S = new com.google.android.libraries.navigation.internal.lv.x(context);
            } else {
                vVar.S = null;
            }
        }
        this.a = eVar;
        this.h = fVar;
        this.e = vVar;
        this.m = new c();
        this.f389n = new f(eVar, bnVar, bnVar2, aVar);
        this.p = rVar;
        f();
        i iVar = new i(this);
        this.g = iVar;
        k kVar = new k(this);
        this.o = kVar;
        fz fzVar = new fz();
        fzVar.b(com.google.android.libraries.navigation.internal.aq.k.class, new n(0, com.google.android.libraries.navigation.internal.aq.k.class, iVar, ap.DANGEROUS_PUBLISHER_THREAD));
        fzVar.b(com.google.android.libraries.navigation.internal.sq.a.class, new n(1, com.google.android.libraries.navigation.internal.sq.a.class, iVar, ap.DANGEROUS_PUBLISHER_THREAD));
        fzVar.b(com.google.android.libraries.navigation.internal.cy.a.class, new n(2, com.google.android.libraries.navigation.internal.cy.a.class, iVar, ap.DANGEROUS_PUBLISHER_THREAD));
        fzVar.b(com.google.android.libraries.navigation.internal.cy.c.class, new n(3, com.google.android.libraries.navigation.internal.cy.c.class, iVar, ap.DANGEROUS_PUBLISHER_THREAD));
        eVar.c(iVar, fzVar.a());
        qVar.a(kVar, executor);
        fVar.c(new j(this), executor);
    }

    private final Set g(com.google.android.libraries.navigation.internal.cw.l lVar) {
        Set set = (Set) this.j.get(lVar);
        if (set != null) {
            return set;
        }
        HashSet hashSet = new HashSet();
        this.j.put(lVar, hashSet);
        return hashSet;
    }

    @Override // com.google.android.libraries.navigation.internal.cw.m
    public final synchronized void a(com.google.android.libraries.navigation.internal.dp.u uVar, com.google.android.libraries.navigation.internal.cw.l lVar) {
        if (lVar == com.google.android.libraries.navigation.internal.cw.l.FAST && com.google.android.libraries.navigation.internal.rq.d.c) {
            lVar = com.google.android.libraries.navigation.internal.cw.l.SLOW;
        }
        com.google.android.libraries.navigation.internal.ia.e eVar = this.a;
        fz fzVar = new fz();
        fzVar.b(com.google.android.libraries.navigation.internal.cy.g.class, new com.google.android.libraries.navigation.internal.dp.x(com.google.android.libraries.navigation.internal.cy.g.class, uVar, ap.UI_THREAD));
        eVar.c(uVar, fzVar.a());
        e(uVar);
        g(lVar).add(uVar);
        this.i.put(uVar, lVar);
        com.google.android.libraries.navigation.internal.cw.l lVarD = d();
        ar.q(lVarD);
        if (!this.k) {
            this.l.a();
            this.k = true;
        }
        this.l.c(lVarD.c);
    }

    @Override // com.google.android.libraries.navigation.internal.cw.m
    public final synchronized void b(com.google.android.libraries.navigation.internal.dp.u uVar) {
        this.a.e(uVar);
        if (this.k) {
            e(uVar);
            com.google.android.libraries.navigation.internal.cw.l lVarD = d();
            if (lVarD != null) {
                this.l.c(lVarD.c);
            } else {
                this.l.b();
                this.k = false;
            }
        }
    }

    @Override // com.google.android.libraries.navigation.internal.cw.m
    public final synchronized void c() {
    }

    final com.google.android.libraries.navigation.internal.cw.l d() {
        if (!g(com.google.android.libraries.navigation.internal.cw.l.FAST).isEmpty()) {
            return com.google.android.libraries.navigation.internal.cw.l.FAST;
        }
        if (g(com.google.android.libraries.navigation.internal.cw.l.SLOW).isEmpty()) {
            return null;
        }
        return com.google.android.libraries.navigation.internal.cw.l.SLOW;
    }

    final void e(Object obj) {
        com.google.android.libraries.navigation.internal.cw.l lVar = (com.google.android.libraries.navigation.internal.cw.l) this.i.remove(obj);
        if (lVar != null) {
            g(lVar).remove(obj);
        }
    }

    public final synchronized void f() {
        com.google.android.libraries.navigation.internal.cw.p pVar;
        com.google.android.libraries.navigation.internal.rw.f fVar = this.h;
        ar.q(fVar);
        if (fVar.e() && (this.b == al.DRIVE || this.b == al.TWO_WHEELER)) {
            pVar = this.m;
            ar.q(pVar);
        } else if (this.c) {
            pVar = this.f389n;
            ar.q(pVar);
        } else {
            pVar = this.e;
            ar.q(pVar);
        }
        com.google.android.libraries.navigation.internal.cw.p pVar2 = this.l;
        if (pVar != pVar2) {
            if (pVar2 != null) {
                if (this.k) {
                    pVar2.b();
                }
                this.l.e(this.f);
            }
            pVar.d(this.f);
            if (this.k) {
                com.google.android.libraries.navigation.internal.cw.l lVarD = d();
                ar.q(lVarD);
                pVar.a();
                pVar.c(lVarD.c);
            }
            this.l = pVar;
            com.google.android.libraries.navigation.internal.hn.r rVar = this.p;
            if (rVar != null) {
                boolean z = ((com.google.android.libraries.navigation.internal.ace.x) rVar.b()).b;
            }
        }
    }
}
