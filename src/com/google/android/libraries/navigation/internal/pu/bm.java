package com.google.android.libraries.navigation.internal.pu;

import android.app.ActivityManager;
import android.content.Context;
import com.google.android.libraries.navigation.internal.afl.ee;
import com.google.android.libraries.navigation.internal.qu.cf;
import com.google.android.libraries.navigation.internal.yx.br;
import com.google.android.libraries.navigation.internal.yx.bw;
import com.google.android.libraries.navigation.internal.yz.ma;
import java.util.Map;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class bm implements com.google.android.libraries.navigation.internal.afr.f {
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
    private final com.google.android.libraries.navigation.internal.agl.a f533n;
    private final com.google.android.libraries.navigation.internal.agl.a o;
    private final com.google.android.libraries.navigation.internal.agl.a p;
    private final com.google.android.libraries.navigation.internal.agl.a q;
    private final com.google.android.libraries.navigation.internal.agl.a r;
    private final com.google.android.libraries.navigation.internal.agl.a s;
    private final com.google.android.libraries.navigation.internal.agl.a t;
    private final com.google.android.libraries.navigation.internal.agl.a u;
    private final com.google.android.libraries.navigation.internal.agl.a v;

    public bm(com.google.android.libraries.navigation.internal.agl.a aVar, com.google.android.libraries.navigation.internal.agl.a aVar2, com.google.android.libraries.navigation.internal.agl.a aVar3, com.google.android.libraries.navigation.internal.agl.a aVar4, com.google.android.libraries.navigation.internal.agl.a aVar5, com.google.android.libraries.navigation.internal.agl.a aVar6, com.google.android.libraries.navigation.internal.agl.a aVar7, com.google.android.libraries.navigation.internal.agl.a aVar8, com.google.android.libraries.navigation.internal.agl.a aVar9, com.google.android.libraries.navigation.internal.agl.a aVar10, com.google.android.libraries.navigation.internal.agl.a aVar11, com.google.android.libraries.navigation.internal.agl.a aVar12, com.google.android.libraries.navigation.internal.agl.a aVar13, com.google.android.libraries.navigation.internal.agl.a aVar14, com.google.android.libraries.navigation.internal.agl.a aVar15, com.google.android.libraries.navigation.internal.agl.a aVar16, com.google.android.libraries.navigation.internal.agl.a aVar17, com.google.android.libraries.navigation.internal.agl.a aVar18, com.google.android.libraries.navigation.internal.agl.a aVar19, com.google.android.libraries.navigation.internal.agl.a aVar20, com.google.android.libraries.navigation.internal.agl.a aVar21, com.google.android.libraries.navigation.internal.agl.a aVar22) {
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
        this.f533n = aVar14;
        this.o = aVar15;
        this.p = aVar16;
        this.q = aVar17;
        this.r = aVar18;
        this.s = aVar19;
        this.t = aVar20;
        this.u = aVar21;
        this.v = aVar22;
    }

    @Override // com.google.android.libraries.navigation.internal.agl.a, com.google.android.libraries.navigation.internal.agk.a
    public final /* bridge */ /* synthetic */ Object a() {
        final Context context = (Context) this.a.a();
        com.google.android.libraries.navigation.internal.oe.at atVar = (com.google.android.libraries.navigation.internal.oe.at) this.b.a();
        com.google.android.libraries.navigation.internal.qv.a aVar = (com.google.android.libraries.navigation.internal.qv.a) this.c.a();
        com.google.android.libraries.navigation.internal.yx.an anVar = (com.google.android.libraries.navigation.internal.yx.an) this.d.a();
        com.google.android.libraries.navigation.internal.afo.a aVarC = com.google.android.libraries.navigation.internal.afr.e.c(this.e);
        com.google.android.libraries.navigation.internal.fq.f fVar = (com.google.android.libraries.navigation.internal.fq.f) this.f.a();
        com.google.android.libraries.navigation.internal.kl.b bVar = (com.google.android.libraries.navigation.internal.kl.b) this.g.a();
        com.google.android.libraries.navigation.internal.ox.f fVar2 = (com.google.android.libraries.navigation.internal.ox.f) this.i.a();
        Runnable runnable = (Runnable) this.j.a();
        com.google.android.libraries.navigation.internal.pm.d dVar = (com.google.android.libraries.navigation.internal.pm.d) this.k.a();
        com.google.android.libraries.navigation.internal.mj.a aVar2 = (com.google.android.libraries.navigation.internal.mj.a) this.l.a();
        com.google.android.libraries.navigation.internal.aac.bn bnVarA = ((com.google.android.libraries.navigation.internal.hy.ac) this.m).a();
        com.google.android.libraries.navigation.internal.aac.bn bnVarA2 = ((com.google.android.libraries.navigation.internal.nj.b) this.f533n).a();
        br brVar = (br) this.o.a();
        com.google.android.libraries.navigation.internal.afo.a aVarC2 = com.google.android.libraries.navigation.internal.afr.e.c(this.p);
        com.google.android.libraries.navigation.internal.afo.a aVarC3 = com.google.android.libraries.navigation.internal.afr.e.c(this.q);
        com.google.android.libraries.navigation.internal.qu.br brVar2 = (com.google.android.libraries.navigation.internal.qu.br) this.r.a();
        com.google.android.libraries.navigation.internal.ace.bk bkVarA = ((com.google.android.libraries.navigation.internal.ho.p) this.s).a();
        com.google.android.libraries.navigation.internal.ace.ao aoVarA = ((com.google.android.libraries.navigation.internal.ho.m) this.t).a();
        ee eeVarA = ((com.google.android.libraries.navigation.internal.ho.ar) this.u).a();
        com.google.android.libraries.navigation.internal.hn.p pVarA = ((com.google.android.libraries.navigation.internal.ho.ba) this.v).a();
        return new cf(context.getResources(), atVar, aVar, (Map) anVar.e(ma.b), aVarC, fVar, bVar, this.h, fVar2, runnable, dVar, aVar2, bnVarA, bnVarA2, brVar, bw.a(new br() { // from class: com.google.android.libraries.navigation.internal.pu.az
            @Override // com.google.android.libraries.navigation.internal.yx.br
            public final Object a() {
                ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
                com.google.android.libraries.navigation.internal.yx.ar.q(activityManager);
                return Integer.valueOf(activityManager.getMemoryClass());
            }
        }), aVarC2, aVarC3, brVar2, bkVarA, aoVarA, eeVarA, pVarA);
    }
}
