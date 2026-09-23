package com.google.android.libraries.navigation.internal.us;

import android.content.Context;
import android.content.res.Resources;
import com.google.android.libraries.navigation.internal.aac.bn;
import com.google.android.libraries.navigation.internal.hx.ap;
import com.google.android.libraries.navigation.internal.ms.cy;
import com.google.android.libraries.navigation.internal.tj.w;
import com.google.android.libraries.navigation.internal.yz.fz;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class aa<T extends com.google.android.libraries.navigation.internal.tj.w> extends y<T> {
    public boolean x;
    private final z y;

    @Deprecated
    protected aa(com.google.android.libraries.navigation.internal.tj.w wVar, Context context, com.google.android.libraries.navigation.internal.ia.e eVar, com.google.android.libraries.navigation.internal.fz.d dVar, com.google.android.libraries.navigation.internal.sl.d dVar2, com.google.android.libraries.navigation.internal.sn.h hVar, Resources resources, com.google.android.libraries.navigation.internal.mj.a aVar, com.google.android.libraries.navigation.internal.jy.af afVar, com.google.android.libraries.navigation.internal.jy.t tVar, bn bnVar, Executor executor, com.google.android.libraries.navigation.internal.uq.m mVar, long j, com.google.android.libraries.navigation.internal.ch.b bVar) {
        super(wVar, context, eVar, dVar, dVar2, hVar, resources, aVar, afVar, tVar, bnVar, executor, j, bVar);
        this.y = new z(this);
    }

    @Override // com.google.android.libraries.navigation.internal.us.y, com.google.android.libraries.navigation.internal.ut.d
    public synchronized void b() {
        if (((com.google.android.libraries.navigation.internal.tj.w) this.a).a != 1) {
            e(false);
        } else {
            this.x = true;
            com.google.android.libraries.navigation.internal.ia.e eVar = this.c;
            z zVar = this.y;
            fz fzVar = new fz();
            fzVar.b(com.google.android.libraries.navigation.internal.sr.m.class, new ab(com.google.android.libraries.navigation.internal.sr.m.class, zVar, ap.UI_THREAD));
            eVar.c(zVar, fzVar.a());
        }
        super.b();
    }

    @Override // com.google.android.libraries.navigation.internal.us.y, com.google.android.libraries.navigation.internal.ut.d
    public synchronized void c() {
        if (this.x) {
            this.x = false;
            ab.d(this.c, this.y);
        }
        super.c();
    }

    public final void e(boolean z) {
        com.google.android.libraries.navigation.internal.tj.w wVar = (com.google.android.libraries.navigation.internal.tj.w) this.a;
        int i = wVar.a;
        int i2 = i - 1;
        if (i == 0) {
            throw null;
        }
        if (i2 == 1) {
            com.google.android.libraries.navigation.internal.tj.v vVarG = wVar.g();
            this.q = com.google.android.libraries.navigation.internal.jy.aa.k(vVarG.b);
            m mVarY = Y();
            mVarY.f = com.google.android.libraries.navigation.internal.jy.aa.k(vVarG.c);
            J(mVarY.a());
            this.m = this.g.getString(vVarG.a);
            N(com.google.android.libraries.navigation.internal.af.e.c(com.google.android.libraries.navigation.internal.f.d.q, com.google.android.libraries.navigation.internal.f.d.r));
            this.u = 5000L;
        } else if (i2 == 2) {
            g();
        }
        if (z && !this.t.j()) {
            T();
        }
        cy.a(this);
    }

    protected abstract void g();

    @Override // com.google.android.libraries.navigation.internal.us.y, com.google.android.libraries.navigation.internal.ut.d
    public Boolean t() {
        return Boolean.valueOf(((com.google.android.libraries.navigation.internal.tj.w) this.a).a == 1);
    }

    protected aa(com.google.android.libraries.navigation.internal.tj.w wVar, Context context, com.google.android.libraries.navigation.internal.ia.e eVar, com.google.android.libraries.navigation.internal.fz.d dVar, com.google.android.libraries.navigation.internal.sl.d dVar2, com.google.android.libraries.navigation.internal.sn.h hVar, Resources resources, com.google.android.libraries.navigation.internal.mj.a aVar, com.google.android.libraries.navigation.internal.jy.af afVar, com.google.android.libraries.navigation.internal.jy.t tVar, bn bnVar, Executor executor, com.google.android.libraries.navigation.internal.uq.m mVar, com.google.android.libraries.navigation.internal.ch.b bVar) {
        super(wVar, context, eVar, dVar, dVar2, hVar, resources, aVar, afVar, tVar, bnVar, executor, mVar, bVar);
        this.y = new z(this);
    }
}
