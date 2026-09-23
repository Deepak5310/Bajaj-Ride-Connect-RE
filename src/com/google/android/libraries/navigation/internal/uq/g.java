package com.google.android.libraries.navigation.internal.uq;

import android.content.res.Configuration;
import android.os.Bundle;
import com.google.android.libraries.navigation.internal.adr.iz;
import com.google.android.libraries.navigation.internal.adr.jf;
import com.google.android.libraries.navigation.internal.bp.bg;
import com.google.android.libraries.navigation.internal.bp.bh;
import com.google.android.libraries.navigation.internal.hx.ap;
import com.google.android.libraries.navigation.internal.tj.u;
import com.google.android.libraries.navigation.internal.uc.q;
import com.google.android.libraries.navigation.internal.uc.r;
import com.google.android.libraries.navigation.internal.uh.w;
import com.google.android.libraries.navigation.internal.yz.fz;
import java.util.ArrayList;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class g implements com.google.android.libraries.navigation.internal.uh.c {
    public final Executor a;
    public final com.google.android.libraries.navigation.internal.ia.e b;
    public boolean d;
    public boolean e;
    public u f;
    public final com.google.android.libraries.navigation.internal.sj.a h;
    private final com.google.android.libraries.navigation.internal.uh.d i;
    private final f j = new f(this);
    public final d g = new d(this);
    public final e c = new e(this);

    public g(com.google.android.libraries.navigation.internal.uh.d dVar, com.google.android.libraries.navigation.internal.sj.a aVar, Executor executor, com.google.android.libraries.navigation.internal.ia.e eVar) {
        this.i = dVar;
        this.h = aVar;
        this.a = executor;
        this.b = eVar;
    }

    private static r d(bg bgVar, jf jfVar) {
        int i = jfVar.c;
        return new r(bgVar, i, jfVar.d + i);
    }

    public final void a(u uVar) {
        if ((uVar == null || !uVar.e()) && (uVar instanceof com.google.android.libraries.navigation.internal.tj.m)) {
            com.google.android.libraries.navigation.internal.tj.m mVar = (com.google.android.libraries.navigation.internal.tj.m) uVar;
            iz izVarK = mVar.k();
            ArrayList arrayList = new ArrayList();
            if (izVarK.e) {
                bh<bg> bhVarI = mVar.i();
                if (bhVarI != null) {
                    for (bg bgVar : bhVarI) {
                        arrayList.add(new r(bgVar, 0, bgVar.J));
                    }
                }
            } else {
                bg bgVarH = mVar.h();
                if (bgVarH != null && (izVarK.b & 1) != 0) {
                    jf jfVar = izVarK.c;
                    if (jfVar == null) {
                        jfVar = jf.a;
                    }
                    arrayList.add(d(bgVarH, jfVar));
                }
                bg bgVarG = mVar.g();
                if (bgVarG != null && (izVarK.b & 2) != 0) {
                    jf jfVar2 = izVarK.d;
                    if (jfVar2 == null) {
                        jfVar2 = jf.a;
                    }
                    arrayList.add(d(bgVarG, jfVar2));
                }
            }
            if (arrayList.isEmpty()) {
                return;
            }
            com.google.android.libraries.navigation.internal.uh.d dVar = this.i;
            boolean zL = mVar.l();
            r[] rVarArr = (r[]) arrayList.toArray(new r[0]);
            w wVar = (w) dVar;
            com.google.android.libraries.navigation.internal.ea.c cVar = wVar.b;
            q.a aVar = new q.a(wVar.b.c);
            aVar.a = com.google.android.libraries.navigation.internal.uc.g.INSPECT_ROUTE_SECTION;
            aVar.g = wVar.b.c;
            aVar.f.i(rVarArr);
            aVar.e = zL ? com.google.android.libraries.navigation.internal.ue.b.NORTH_UP : null;
            ((com.google.android.libraries.navigation.internal.ui.a.C0035a) cVar).b(aVar.a());
            wVar.q();
        }
    }

    @Override // com.google.android.libraries.navigation.internal.uh.c
    public final /* synthetic */ void aC() {
    }

    @Override // com.google.android.libraries.navigation.internal.uh.c
    public final /* synthetic */ void ay(Configuration configuration) {
    }

    public final void b(u uVar) {
        u uVar2 = this.f;
        if (uVar2 == null && uVar == null) {
            return;
        }
        if (uVar2 instanceof com.google.android.libraries.navigation.internal.tj.m) {
            this.i.a();
        }
        w wVar = (w) this.i;
        wVar.b.b = uVar;
        wVar.q();
        this.f = uVar;
        a(uVar);
    }

    public final void c() {
        if (this.d) {
            this.d = false;
            this.h.d(this.c);
            this.b.e(this.g);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.uh.c
    public final /* synthetic */ void h(Bundle bundle) {
    }

    @Override // com.google.android.libraries.navigation.internal.uh.c
    public final /* synthetic */ void j(Bundle bundle) {
    }

    @Override // com.google.android.libraries.navigation.internal.uh.c
    public final void k() {
        this.e = true;
        fz fzVar = new fz();
        f fVar = this.j;
        fzVar.b(com.google.android.libraries.navigation.internal.tl.b.class, new i(com.google.android.libraries.navigation.internal.tl.b.class, fVar, ap.UI_THREAD));
        this.b.c(fVar, fzVar.a());
    }

    @Override // com.google.android.libraries.navigation.internal.uh.c
    public final void l() {
        c();
        this.b.e(this.j);
        this.e = false;
    }
}
