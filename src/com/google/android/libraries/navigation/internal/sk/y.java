package com.google.android.libraries.navigation.internal.sk;

import android.app.Application;
import android.content.IntentFilter;
import androidx.mediarouter.media.MediaRouter;
import com.google.android.libraries.navigation.internal.yz.fz;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class y implements com.google.android.libraries.navigation.internal.afr.f {
    private final com.google.android.libraries.navigation.internal.agl.a a;
    private final com.google.android.libraries.navigation.internal.agl.a b;
    private final com.google.android.libraries.navigation.internal.agl.a c;
    private final com.google.android.libraries.navigation.internal.agl.a d;
    private final com.google.android.libraries.navigation.internal.agl.a e;
    private final com.google.android.libraries.navigation.internal.agl.a f;
    private final com.google.android.libraries.navigation.internal.agl.a g;
    private final com.google.android.libraries.navigation.internal.agl.a h;
    private final com.google.android.libraries.navigation.internal.agl.a i;
    private final com.google.android.libraries.navigation.internal.agl.a j;
    private final com.google.android.libraries.navigation.internal.agl.a k;
    private final com.google.android.libraries.navigation.internal.agl.a l;
    private final com.google.android.libraries.navigation.internal.agl.a m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final com.google.android.libraries.navigation.internal.agl.a f577n;
    private final com.google.android.libraries.navigation.internal.agl.a o;
    private final com.google.android.libraries.navigation.internal.agl.a p;
    private final com.google.android.libraries.navigation.internal.agl.a q;
    private final com.google.android.libraries.navigation.internal.agl.a r;

    public y(com.google.android.libraries.navigation.internal.agl.a aVar, com.google.android.libraries.navigation.internal.agl.a aVar2, com.google.android.libraries.navigation.internal.agl.a aVar3, com.google.android.libraries.navigation.internal.agl.a aVar4, com.google.android.libraries.navigation.internal.agl.a aVar5, com.google.android.libraries.navigation.internal.agl.a aVar6, com.google.android.libraries.navigation.internal.agl.a aVar7, com.google.android.libraries.navigation.internal.agl.a aVar8, com.google.android.libraries.navigation.internal.agl.a aVar9, com.google.android.libraries.navigation.internal.agl.a aVar10, com.google.android.libraries.navigation.internal.agl.a aVar11, com.google.android.libraries.navigation.internal.agl.a aVar12, com.google.android.libraries.navigation.internal.agl.a aVar13, com.google.android.libraries.navigation.internal.agl.a aVar14, com.google.android.libraries.navigation.internal.agl.a aVar15, com.google.android.libraries.navigation.internal.agl.a aVar16, com.google.android.libraries.navigation.internal.agl.a aVar17, com.google.android.libraries.navigation.internal.agl.a aVar18) {
        this.a = aVar;
        this.b = aVar2;
        this.c = aVar3;
        this.d = aVar4;
        this.e = aVar5;
        this.f = aVar6;
        this.g = aVar7;
        this.h = aVar8;
        this.i = aVar9;
        this.j = aVar10;
        this.k = aVar11;
        this.l = aVar12;
        this.m = aVar13;
        this.f577n = aVar14;
        this.o = aVar15;
        this.p = aVar16;
        this.q = aVar17;
        this.r = aVar18;
    }

    @Override // com.google.android.libraries.navigation.internal.agl.a, com.google.android.libraries.navigation.internal.agk.a
    public final /* bridge */ /* synthetic */ Object a() {
        final x xVar = new x((Application) ((com.google.android.libraries.navigation.internal.afr.g) this.a).a, (com.google.android.libraries.navigation.internal.rw.f) this.b.a(), ((com.google.android.libraries.navigation.internal.nj.h) this.c).a(), (d) this.d.a(), (com.google.android.libraries.navigation.internal.ia.e) this.e.a(), (com.google.android.libraries.navigation.internal.iv.f) this.f.a(), ((com.google.android.libraries.navigation.internal.ht.r) this.g).a(), (com.google.android.libraries.navigation.internal.kl.b) this.h.a(), ((ci) this.i).a(), (ck) this.j.a(), (com.google.android.libraries.navigation.internal.sl.q) this.k.a(), (com.google.android.libraries.navigation.internal.th.c) this.l.a(), com.google.android.libraries.navigation.internal.afr.e.c(this.m), com.google.android.libraries.navigation.internal.afr.e.c(this.f577n), (com.google.android.libraries.navigation.internal.sn.h) this.o.a());
        com.google.android.libraries.navigation.internal.mj.a aVar = (com.google.android.libraries.navigation.internal.mj.a) this.p.a();
        com.google.android.libraries.navigation.internal.jy.af afVar = (com.google.android.libraries.navigation.internal.jy.af) this.q.a();
        com.google.android.libraries.navigation.internal.jy.t tVar = (com.google.android.libraries.navigation.internal.jy.t) this.r.a();
        Application application = xVar.b;
        com.google.android.libraries.navigation.internal.rw.f fVar = xVar.c;
        com.google.android.libraries.navigation.internal.iv.f fVar2 = xVar.e;
        com.google.android.libraries.navigation.internal.ia.e eVar = xVar.d;
        com.google.android.libraries.navigation.internal.aac.bn bnVar = xVar.g;
        com.google.android.libraries.navigation.internal.aac.bn bnVar2 = xVar.i;
        int i = bf.t;
        bf bfVar = new bf(application, fVar, fVar2, eVar, aVar, new ac(fVar2, MediaRouter.getInstance(application)), afVar, tVar, bnVar, bnVar2);
        com.google.android.libraries.navigation.internal.ia.e eVar2 = bfVar.d;
        fz fzVar = new fz();
        fzVar.b(com.google.android.libraries.navigation.internal.fm.a.class, new bg(com.google.android.libraries.navigation.internal.fm.a.class, bfVar, com.google.android.libraries.navigation.internal.hx.ap.UI_THREAD));
        eVar2.c(bfVar, fzVar.a());
        bfVar.b(com.google.android.libraries.navigation.internal.sl.i.IDLE);
        ((ac) bfVar.h).f = bfVar.s;
        xVar.k = bfVar;
        xVar.i.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.sk.m
            @Override // java.lang.Runnable
            public final void run() {
                x xVar2 = xVar;
                xVar2.f576n.a();
                xVar2.m.a();
            }
        });
        xVar.l = new u(xVar);
        xVar.b.registerReceiver(xVar.l, new IntentFilter("android.intent.action.LOCALE_CHANGED"));
        xVar.f.e(xVar.r);
        bfVar.i = xVar;
        return xVar;
    }
}
