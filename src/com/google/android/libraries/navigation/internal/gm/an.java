package com.google.android.libraries.navigation.internal.gm;

import android.accounts.Account;
import com.google.android.libraries.navigation.internal.aac.bj;
import com.google.android.libraries.navigation.internal.aac.ca;
import com.google.android.libraries.navigation.internal.acd.mj;
import com.google.android.libraries.navigation.internal.ael.dg;
import com.google.android.libraries.navigation.internal.yz.hx;
import com.google.common.net.HttpHeaders;
import j$.time.Duration;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class an {
    public final ab a;
    public final f b;
    public final j c;
    public final u d;
    public final as e;
    public final aq f;
    public final ag g;
    public final q h;
    public final y i;
    public final com.google.android.libraries.navigation.internal.mj.a j;
    public final Executor k;
    public final com.google.android.libraries.navigation.internal.afo.a l;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Account f441n;
    public String o;
    public com.google.android.libraries.navigation.internal.db.n p;
    private final ad r;
    private final n s;
    private final com.google.android.libraries.navigation.internal.yx.an t;
    private final com.google.android.libraries.navigation.internal.afo.a u;
    private final com.google.android.libraries.navigation.internal.gh.d v;
    public int m = 0;
    public final AtomicBoolean q = new AtomicBoolean(false);

    public an(ab abVar, ad adVar, f fVar, k kVar, u uVar, as asVar, aq aqVar, ag agVar, n nVar, q qVar, y yVar, com.google.android.libraries.navigation.internal.mj.a aVar, com.google.android.libraries.navigation.internal.yx.an anVar, Executor executor, com.google.android.libraries.navigation.internal.afo.a aVar2, com.google.android.libraries.navigation.internal.afo.a aVar3, com.google.android.libraries.navigation.internal.gh.d dVar) {
        this.a = abVar;
        this.r = adVar;
        this.b = fVar;
        this.e = asVar;
        this.f = aqVar;
        this.g = agVar;
        this.s = nVar;
        this.v = dVar;
        Account account = dVar.f;
        account = true != com.google.android.libraries.navigation.internal.hj.d.a(account) ? null : account;
        com.google.android.libraries.navigation.internal.ia.e eVar = (com.google.android.libraries.navigation.internal.ia.e) kVar.a.a();
        eVar.getClass();
        com.google.android.libraries.navigation.internal.ik.a aVar4 = (com.google.android.libraries.navigation.internal.ik.a) kVar.b.a();
        aVar4.getClass();
        Executor executor2 = (Executor) kVar.c.a();
        executor2.getClass();
        this.c = new j(eVar, aVar4, executor2, account);
        this.d = uVar;
        this.h = qVar;
        this.k = executor;
        this.i = yVar;
        this.j = aVar;
        this.t = anVar;
        this.l = aVar2;
        this.u = aVar3;
    }

    public final Duration a() {
        return Duration.ofMillis(this.j.a());
    }

    public final void b() {
        if (this.q.get()) {
            this.e.c();
            aq aqVar = this.f;
            synchronized (aqVar) {
                if (aqVar.a != null) {
                    com.google.android.libraries.navigation.internal.gh.b bVarB = aqVar.b();
                    ca caVar = null;
                    if (bVarB != null) {
                        ca caVar2 = aqVar.a;
                        aqVar.a = null;
                        caVar = caVar2;
                    }
                    if (caVar != null) {
                        caVar.d(bVarB);
                    }
                }
            }
            j jVar = this.c;
            if (jVar.c.get()) {
                jVar.a.e(jVar);
                com.google.android.libraries.navigation.internal.ik.a aVar = jVar.g;
                aVar.a().h(jVar.d);
            }
            this.q.set(false);
        }
    }

    public final boolean c() {
        return ((mj) this.u.a()).i;
    }

    public final bj e() {
        return this.r.a();
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0041  */
    public final void d(am amVar) {
        com.google.android.libraries.navigation.internal.gh.b bVarB;
        com.google.android.libraries.navigation.internal.db.at atVar;
        com.google.android.libraries.navigation.internal.gh.b bVar = amVar.a;
        com.google.android.libraries.navigation.internal.gd.i iVar = this.v.b;
        if (iVar.f) {
            ArrayList arrayList = new ArrayList();
            com.google.android.libraries.navigation.internal.gh.b bVarD = this.d.d();
            if (bVarD != null) {
                arrayList.addAll((Collection) ((com.google.android.libraries.navigation.internal.gh.a) bVarD).a);
            }
            com.google.android.libraries.navigation.internal.gh.b bVarB2 = this.g.b();
            bVarB = null;
            if (bVarB2 == null) {
                n nVar = this.s;
                synchronized (nVar) {
                    com.google.android.libraries.navigation.internal.aes.h hVar = (com.google.android.libraries.navigation.internal.aes.h) nVar.b.f(com.google.android.libraries.navigation.internal.iv.ab.bi, (dg) com.google.android.libraries.navigation.internal.aes.h.a.aH(7, null), null);
                    if (hVar == null) {
                        atVar = null;
                    } else {
                        atVar = new com.google.android.libraries.navigation.internal.db.at(hVar);
                        long jB = nVar.b.b(com.google.android.libraries.navigation.internal.iv.ab.bj, -1L);
                        if (jB >= 0 && ((atVar.a.b & 4) == 0 || nVar.a.a() - atVar.b.toEpochMilli() >= TimeUnit.MINUTES.toMillis(jB))) {
                            atVar = null;
                        }
                    }
                    if (atVar != null) {
                        bVarB2 = new com.google.android.libraries.navigation.internal.gh.a("X-Geo", hx.d(atVar));
                    } else {
                        bVarB2 = null;
                    }
                }
            }
            if (bVarB2 != null) {
                arrayList.addAll((Collection) ((com.google.android.libraries.navigation.internal.gh.a) bVarB2).a);
            }
            if (!arrayList.isEmpty()) {
                bVarB = new com.google.android.libraries.navigation.internal.gh.a("X-Geo", arrayList);
            }
        } else {
            bVarB = iVar.e ? this.g.b() : this.d.d();
        }
        if (bVarB != null || bVar != null) {
            amVar.a = (com.google.android.libraries.navigation.internal.gh.b) com.google.android.libraries.navigation.internal.yx.al.c(bVarB, bVar);
        }
        this.p = this.d.b();
        com.google.android.libraries.navigation.internal.gh.b bVarA = amVar.a(HttpHeaders.AUTHORIZATION);
        com.google.android.libraries.navigation.internal.gh.b bVarC = this.c.c();
        if (bVarC != null || bVarA != null) {
            com.google.android.libraries.navigation.internal.gh.b bVar2 = (com.google.android.libraries.navigation.internal.gh.b) com.google.android.libraries.navigation.internal.yx.al.c(bVarC, bVarA);
            amVar.b(bVar2);
            this.o = (String) bVar2.a();
            this.f441n = this.c.b();
        }
        amVar.b(new com.google.android.libraries.navigation.internal.gh.a("X-Device-Elapsed-Time", String.valueOf(this.j.b())));
        com.google.android.libraries.navigation.internal.yx.an anVar = this.t;
        if (anVar.g()) {
            com.google.android.libraries.navigation.internal.yx.an anVarA = ((com.google.android.libraries.navigation.internal.kl.d) anVar.c()).a();
            if (anVarA.g()) {
                amVar.b(new com.google.android.libraries.navigation.internal.gh.a("X-Device-Boot-Count", anVarA.c().toString()));
            }
        }
    }
}
