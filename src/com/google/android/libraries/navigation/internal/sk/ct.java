package com.google.android.libraries.navigation.internal.sk;

import com.google.android.libraries.navigation.internal.ace.hm;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.fz;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ct implements com.google.android.libraries.navigation.internal.sp.b {
    public final com.google.android.libraries.navigation.internal.afo.a a;
    public final com.google.android.libraries.navigation.internal.afo.a b;
    public final com.google.android.libraries.navigation.internal.ia.e c;
    public final com.google.android.libraries.navigation.internal.sl.q d;
    public final com.google.android.libraries.navigation.internal.afo.a e;
    public final com.google.android.libraries.navigation.internal.iv.f f;
    private final com.google.android.libraries.navigation.internal.sl.l i;
    private final com.google.android.libraries.navigation.internal.rw.q j;
    private final Executor k;
    private final hm l;
    private final com.google.android.libraries.navigation.internal.vo.a p;
    public boolean g = false;
    public boolean h = false;
    private final cr m = new cr(this);

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final cq f574n = new cq(this);
    private final cs o = new cs(this);

    public ct(com.google.android.libraries.navigation.internal.afo.a aVar, com.google.android.libraries.navigation.internal.afo.a aVar2, com.google.android.libraries.navigation.internal.sl.l lVar, com.google.android.libraries.navigation.internal.ia.e eVar, com.google.android.libraries.navigation.internal.sl.q qVar, com.google.android.libraries.navigation.internal.afo.a aVar3, com.google.android.libraries.navigation.internal.iv.f fVar, com.google.android.libraries.navigation.internal.rw.q qVar2, com.google.android.libraries.navigation.internal.vo.a aVar4, Executor executor, hm hmVar) {
        this.a = aVar;
        this.b = aVar2;
        this.i = lVar;
        this.c = eVar;
        this.d = qVar;
        this.e = aVar3;
        this.f = fVar;
        this.j = qVar2;
        this.p = aVar4;
        this.k = executor;
        this.l = hmVar;
    }

    @Override // com.google.android.libraries.navigation.internal.sp.b
    public final void a(com.google.android.libraries.navigation.internal.sp.c cVar) {
        boolean z = false;
        this.g = false;
        this.j.a(this.m, this.k);
        this.p.c(this.f574n, this.k);
        this.p.d(this.o, this.k);
        fz fzVar = new fz();
        fzVar.b(com.google.android.libraries.navigation.internal.sd.a.class, new cv(0, com.google.android.libraries.navigation.internal.sd.a.class, this, com.google.android.libraries.navigation.internal.hx.ap.UI_THREAD));
        fzVar.b(com.google.android.libraries.navigation.internal.sd.b.class, new cv(1, com.google.android.libraries.navigation.internal.sd.b.class, this, com.google.android.libraries.navigation.internal.hx.ap.UI_THREAD));
        fzVar.b(com.google.android.libraries.navigation.internal.cw.d.class, new cv(2, com.google.android.libraries.navigation.internal.cw.d.class, this, com.google.android.libraries.navigation.internal.hx.ap.UI_THREAD));
        this.c.c(this, fzVar.a());
        if (cVar.a == com.google.android.libraries.navigation.internal.si.e.GUIDED_NAV) {
            com.google.android.libraries.navigation.internal.ady.al alVar = cVar.b;
            ev evVar = com.google.android.libraries.navigation.internal.bw.e.a;
            if (alVar == com.google.android.libraries.navigation.internal.ady.al.DRIVE || alVar == com.google.android.libraries.navigation.internal.ady.al.TWO_WHEELER) {
                z = true;
            }
        }
        this.i.b(z);
    }

    @Override // com.google.android.libraries.navigation.internal.sp.b
    public final void b(boolean z) {
        this.k.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.sk.cn
            @Override // java.lang.Runnable
            public final void run() {
                ct ctVar = this.a;
                ((com.google.android.libraries.navigation.internal.sl.d) ctVar.a.a()).s(!ctVar.h);
            }
        });
        this.j.b(this.m);
        this.p.e(this.f574n);
        this.p.f(this.o);
        this.c.e(this);
    }

    public final com.google.android.libraries.navigation.internal.sn.h c() {
        return (com.google.android.libraries.navigation.internal.sn.h) this.b.a();
    }

    public final boolean d() {
        return this.l.l;
    }
}
