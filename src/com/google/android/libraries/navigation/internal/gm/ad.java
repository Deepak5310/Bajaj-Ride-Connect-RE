package com.google.android.libraries.navigation.internal.gm;

import com.google.android.libraries.navigation.internal.aac.az;
import com.google.android.libraries.navigation.internal.aac.bj;
import com.google.android.libraries.navigation.internal.aac.ca;
import com.google.android.libraries.navigation.internal.yz.fz;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ad implements com.google.android.libraries.navigation.internal.gh.e, com.google.android.libraries.navigation.internal.hn.i {
    private final com.google.android.libraries.navigation.internal.ia.e b;
    private final Executor c;
    private final com.google.android.libraries.navigation.internal.hm.h g;
    private final AtomicBoolean d = new AtomicBoolean(false);
    private final AtomicBoolean e = new AtomicBoolean(false);
    private volatile boolean f = false;
    private final ca a = new ca();

    public ad(com.google.android.libraries.navigation.internal.ia.e eVar, com.google.android.libraries.navigation.internal.hm.h hVar, Executor executor) {
        this.b = eVar;
        this.g = hVar;
        this.c = executor;
    }

    @Override // com.google.android.libraries.navigation.internal.gh.e
    public final bj a() {
        bj bjVarI;
        com.google.android.libraries.navigation.internal.gh.b bVarB = b();
        if (Boolean.parseBoolean((String) ((com.google.android.libraries.navigation.internal.gh.a) bVarB).a)) {
            return az.h(bVarB);
        }
        synchronized (this) {
            bjVarI = az.i(this.a);
        }
        return bjVarI;
    }

    public final com.google.android.libraries.navigation.internal.gh.b b() {
        if (!this.d.getAndSet(true)) {
            com.google.android.libraries.navigation.internal.ia.e eVar = this.b;
            fz fzVar = new fz();
            fzVar.b(com.google.android.libraries.navigation.internal.hn.q.class, new af(com.google.android.libraries.navigation.internal.hn.q.class, this, com.google.android.libraries.navigation.internal.hx.ap.DANGEROUS_PUBLISHER_THREAD));
            eVar.c(this, fzVar.a());
            this.g.c(this, this.c);
        }
        return new com.google.android.libraries.navigation.internal.gh.a("NonDefaultClientParametersReady", Boolean.toString(this.f));
    }

    public final void c(boolean z) {
        ca caVar;
        if (z) {
            this.f = true;
            com.google.android.libraries.navigation.internal.gh.b bVarB = b();
            synchronized (this) {
                caVar = this.a;
            }
            caVar.d(bVarB);
            if (this.e.getAndSet(true)) {
                return;
            }
            this.b.e(this);
            this.g.d(this);
        }
    }
}
