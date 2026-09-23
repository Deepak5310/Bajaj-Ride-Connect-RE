package com.google.android.libraries.navigation.internal.gm;

import com.google.android.libraries.navigation.internal.aac.az;
import com.google.android.libraries.navigation.internal.aac.bj;
import com.google.android.libraries.navigation.internal.aac.ca;
import com.google.android.libraries.navigation.internal.yz.fz;
import com.google.android.libraries.navigation.internal.yz.hx;
import j$.time.Duration;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ag implements com.google.android.libraries.navigation.internal.gh.e {
    private ca a;
    private com.google.android.libraries.navigation.internal.db.ab b;
    private final com.google.android.libraries.navigation.internal.mj.a c;
    private final com.google.android.libraries.navigation.internal.ia.e d;
    private final AtomicBoolean e = new AtomicBoolean(false);

    public ag(com.google.android.libraries.navigation.internal.mj.a aVar, com.google.android.libraries.navigation.internal.ia.e eVar) {
        this.c = aVar;
        this.d = eVar;
    }

    private final com.google.android.libraries.navigation.internal.gh.b d() {
        com.google.android.libraries.navigation.internal.db.ab abVar = this.b;
        if (abVar == null) {
            return null;
        }
        if (com.google.android.libraries.navigation.internal.db.ar.d(abVar, abVar.a, this.c, Duration.ZERO)) {
            return null;
        }
        return b();
    }

    private final void e() {
        if (this.e.getAndSet(true)) {
            return;
        }
        com.google.android.libraries.navigation.internal.ia.e eVar = this.d;
        fz fzVar = new fz();
        fzVar.b(com.google.android.libraries.navigation.internal.db.o.class, new ai(0, com.google.android.libraries.navigation.internal.db.o.class, this, com.google.android.libraries.navigation.internal.hx.ap.DANGEROUS_PUBLISHER_THREAD));
        fzVar.b(com.google.android.libraries.navigation.internal.db.ac.class, new ai(1, com.google.android.libraries.navigation.internal.db.ac.class, this, com.google.android.libraries.navigation.internal.hx.ap.DANGEROUS_PUBLISHER_THREAD));
        eVar.c(this, fzVar.a());
    }

    @Override // com.google.android.libraries.navigation.internal.gh.e
    public final bj a() {
        e();
        synchronized (this) {
            com.google.android.libraries.navigation.internal.gh.b bVarD = d();
            if (bVarD != null) {
                return az.h(bVarD);
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

    public final com.google.android.libraries.navigation.internal.gh.b b() {
        e();
        synchronized (this) {
            com.google.android.libraries.navigation.internal.db.ab abVar = this.b;
            if (abVar == null) {
                return null;
            }
            return new com.google.android.libraries.navigation.internal.gh.a("X-Geo", hx.d(abVar));
        }
    }

    public final void c(com.google.android.libraries.navigation.internal.db.ab abVar) {
        com.google.android.libraries.navigation.internal.gh.b bVarD;
        ca caVar;
        synchronized (this) {
            com.google.android.libraries.navigation.internal.db.ab abVar2 = this.b;
            if (abVar2 != null && abVar2.p().compareTo(abVar.p()) >= 0) {
                abVar = abVar2;
            }
            this.b = abVar;
            bVarD = d();
            caVar = null;
            if (bVarD != null) {
                ca caVar2 = this.a;
                this.a = null;
                caVar = caVar2;
            }
        }
        if (caVar != null) {
            caVar.d(bVarD);
        }
    }
}
