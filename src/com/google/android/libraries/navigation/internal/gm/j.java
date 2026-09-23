package com.google.android.libraries.navigation.internal.gm;

import android.accounts.Account;
import com.google.android.libraries.navigation.internal.aac.az;
import com.google.android.libraries.navigation.internal.aac.bj;
import com.google.android.libraries.navigation.internal.aac.ca;
import com.google.android.libraries.navigation.internal.yz.fz;
import com.google.common.net.HttpHeaders;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class j implements com.google.android.libraries.navigation.internal.gh.e {
    public final com.google.android.libraries.navigation.internal.ia.e a;
    public final Executor b;
    public volatile com.google.android.libraries.navigation.internal.yx.an e;
    public final com.google.android.libraries.navigation.internal.ik.a g;
    private ca h;
    public final AtomicBoolean c = new AtomicBoolean(false);
    public final com.google.android.libraries.navigation.internal.nt.t d = new i(this);
    public volatile Map f = new HashMap();

    public j(com.google.android.libraries.navigation.internal.ia.e eVar, com.google.android.libraries.navigation.internal.ik.a aVar, Executor executor, Account account) {
        this.a = eVar;
        this.g = aVar;
        this.b = executor;
        this.e = com.google.android.libraries.navigation.internal.yx.an.i(account);
    }

    private final void f(String str) {
        ca caVar;
        synchronized (this) {
            caVar = this.h;
            if (caVar != null) {
                this.h = null;
            } else {
                caVar = null;
            }
        }
        if (caVar != null) {
            caVar.d(new com.google.android.libraries.navigation.internal.gh.a(HttpHeaders.AUTHORIZATION, str));
        }
    }

    @Override // com.google.android.libraries.navigation.internal.gh.e
    public final synchronized bj a() {
        bj bjVarI;
        com.google.android.libraries.navigation.internal.ik.d dVar;
        com.google.android.libraries.navigation.internal.gh.b bVarC = c();
        if (bVarC != null) {
            return az.h(bVarC);
        }
        if (this.e.g() && (dVar = (com.google.android.libraries.navigation.internal.ik.d) this.f.get(this.e.c())) != null) {
            dVar.d();
        }
        synchronized (this) {
            if (this.h == null) {
                this.h = new ca();
            }
            bjVarI = az.i(this.h);
        }
        return bjVarI;
    }

    final synchronized Account b() {
        if (!this.e.g()) {
            return null;
        }
        return (Account) this.e.c();
    }

    public final com.google.android.libraries.navigation.internal.gh.b c() {
        com.google.android.libraries.navigation.internal.ik.d dVar;
        String strC;
        if (!this.c.getAndSet(true)) {
            com.google.android.libraries.navigation.internal.ia.e eVar = this.a;
            fz fzVar = new fz();
            fzVar.b(com.google.android.libraries.navigation.internal.fw.k.class, new m(com.google.android.libraries.navigation.internal.fw.k.class, this, com.google.android.libraries.navigation.internal.hx.ap.DANGEROUS_PUBLISHER_THREAD));
            eVar.c(this, fzVar.a());
            this.g.a().e(this.d, this.b);
        }
        synchronized (this) {
            if (!this.e.g() || (dVar = (com.google.android.libraries.navigation.internal.ik.d) this.f.get(this.e.c())) == null || (strC = dVar.c()) == null) {
                return null;
            }
            return new com.google.android.libraries.navigation.internal.gh.a(HttpHeaders.AUTHORIZATION, strC);
        }
    }

    public final synchronized void d(com.google.android.libraries.navigation.internal.ik.d dVar) {
        String strA;
        if (dVar != null) {
            if (this.e.g() && (strA = com.google.android.libraries.navigation.internal.yx.aq.a(dVar.b())) != null) {
                f(strA);
            }
        }
    }

    public final synchronized void e() {
        com.google.android.libraries.navigation.internal.ik.d dVar;
        String strC;
        if (!this.e.g() || (dVar = (com.google.android.libraries.navigation.internal.ik.d) this.f.get(this.e.c())) == null || (strC = dVar.c()) == null) {
            return;
        }
        f(strC);
    }
}
