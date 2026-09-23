package com.google.android.libraries.navigation.internal.gm;

import com.google.android.libraries.navigation.internal.aac.az;
import com.google.android.libraries.navigation.internal.aac.bj;
import com.google.android.libraries.navigation.internal.aac.ca;
import com.google.android.libraries.navigation.internal.yz.fz;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class u implements com.google.android.libraries.navigation.internal.gh.e {
    public ca a;
    com.google.android.libraries.navigation.internal.db.n b;
    public volatile com.google.android.libraries.navigation.internal.db.al c;
    public volatile com.google.android.libraries.navigation.internal.db.as d;
    final com.google.android.libraries.navigation.internal.mj.a e;
    private final com.google.android.libraries.navigation.internal.ia.e f;
    private final AtomicReference g = new AtomicReference(t.NEW);

    public u(com.google.android.libraries.navigation.internal.mj.a aVar, com.google.android.libraries.navigation.internal.ia.e eVar) {
        this.e = aVar;
        this.f = eVar;
    }

    private static void e(List list, com.google.android.libraries.navigation.internal.db.as asVar) {
        if (asVar != null) {
            list.add(asVar);
        }
    }

    private final void f() {
        if (s.a(this.g, t.NEW, t.REGISTERING)) {
            com.google.android.libraries.navigation.internal.ia.e eVar = this.f;
            fz fzVar = new fz();
            fzVar.b(com.google.android.libraries.navigation.internal.db.o.class, new w(0, com.google.android.libraries.navigation.internal.db.o.class, this, com.google.android.libraries.navigation.internal.hx.ap.DANGEROUS_PUBLISHER_THREAD));
            fzVar.b(com.google.android.libraries.navigation.internal.db.am.class, new w(1, com.google.android.libraries.navigation.internal.db.am.class, this, com.google.android.libraries.navigation.internal.hx.ap.DANGEROUS_PUBLISHER_THREAD));
            fzVar.b(com.google.android.libraries.navigation.internal.db.ah.class, new w(2, com.google.android.libraries.navigation.internal.db.ah.class, this, com.google.android.libraries.navigation.internal.hx.ap.DANGEROUS_PUBLISHER_THREAD));
            eVar.c(this, fzVar.a());
            if (s.a(this.g, t.REGISTERING, t.ACTIVE)) {
                return;
            }
            com.google.android.libraries.navigation.internal.yx.ar.k(this.g.get() == t.DESTROYED);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.gh.e
    public final bj a() {
        f();
        synchronized (this) {
            com.google.android.libraries.navigation.internal.gh.b bVarC = c();
            if (bVarC != null) {
                return az.h(bVarC);
            }
            ca caVar = this.a;
            if (caVar != null) {
                return az.i(caVar);
            }
            ca caVar2 = new ca();
            this.a = caVar2;
            return az.i(caVar2);
        }
    }

    final synchronized com.google.android.libraries.navigation.internal.db.n b() {
        return this.b;
    }

    public final com.google.android.libraries.navigation.internal.gh.b c() {
        com.google.android.libraries.navigation.internal.db.n nVar = this.b;
        if (nVar == null || com.google.android.libraries.navigation.internal.db.ar.b(nVar, this.e)) {
            return null;
        }
        return d();
    }

    public final com.google.android.libraries.navigation.internal.gh.b d() {
        com.google.android.libraries.navigation.internal.db.n nVar;
        f();
        synchronized (this) {
            nVar = this.b;
        }
        ArrayList arrayList = new ArrayList(4);
        e(arrayList, nVar);
        e(arrayList, this.c);
        e(arrayList, this.d);
        if (arrayList.isEmpty()) {
            return null;
        }
        return new com.google.android.libraries.navigation.internal.gh.a("X-Geo", arrayList);
    }
}
