package com.google.android.libraries.navigation.internal.sv;

import com.google.android.libraries.navigation.internal.ace.hm;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.lv;
import java.util.Optional;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class cg {
    public final com.google.android.libraries.navigation.internal.rw.f d;
    public final Executor f;
    public final com.google.android.libraries.navigation.internal.km.ab g;
    public final com.google.android.libraries.navigation.internal.vo.a h;
    private final com.google.android.libraries.navigation.internal.ia.e i;
    private final hm j;
    private final com.google.android.libraries.navigation.internal.afo.a k;
    public int a = -1;
    public long b = -1;
    public Optional c = Optional.empty();
    public final cf e = new cf(this);

    public cg(com.google.android.libraries.navigation.internal.ia.e eVar, com.google.android.libraries.navigation.internal.vo.a aVar, com.google.android.libraries.navigation.internal.kl.b bVar, hm hmVar, com.google.android.libraries.navigation.internal.rw.f fVar, Executor executor, com.google.android.libraries.navigation.internal.afo.a aVar2) {
        this.i = eVar;
        this.h = aVar;
        this.j = hmVar;
        this.d = fVar;
        this.f = executor;
        this.k = aVar2;
        this.g = (com.google.android.libraries.navigation.internal.km.ab) bVar.a(com.google.android.libraries.navigation.internal.km.ak.s);
    }

    private final boolean c() {
        return this.j.l;
    }

    public final void a(com.google.android.libraries.navigation.internal.sc.d dVar) {
        if (b()) {
            return;
        }
        com.google.android.libraries.navigation.internal.sd.b bVarB = dVar.b();
        com.google.android.libraries.navigation.internal.sd.a aVarA = dVar.a();
        if (bVarB != null) {
            long j = this.b;
            long j2 = bVarB.e;
            int i = bVarB.a.f;
            if (j2 != j) {
                this.b = j2;
                this.a = i;
            } else if (i != this.a) {
                this.a = i;
            } else {
                this.g.d();
            }
            if (c()) {
                com.google.android.libraries.navigation.internal.vn.d dVarD = ((com.google.android.libraries.navigation.internal.sn.h) this.k.a()).d(bVarB.a, bVarB.e, bVarB.b, bVarB.d, bVarB.c);
                if (dVarD != null) {
                    this.h.a(dVarD);
                } else {
                    this.g.d();
                }
            } else {
                this.i.a(bVarB);
            }
        } else {
            this.g.d();
        }
        if (aVarA != null) {
            if (!c()) {
                this.i.a(aVarA);
                return;
            }
            int i2 = ev.d;
            ev evVar = lv.a;
            this.h.b(ev.o(((com.google.android.libraries.navigation.internal.sn.h) this.k.a()).e(aVarA.a, aVarA.c, aVarA.d, aVarA.b)));
        }
    }

    public final boolean b() {
        return this.j.m && c();
    }
}
