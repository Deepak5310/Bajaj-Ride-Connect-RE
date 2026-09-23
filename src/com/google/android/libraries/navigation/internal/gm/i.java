package com.google.android.libraries.navigation.internal.gm;

import android.accounts.Account;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.hx;
import java.util.HashMap;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class i implements com.google.android.libraries.navigation.internal.nt.t {
    final /* synthetic */ j a;

    public i(j jVar) {
        this.a = jVar;
    }

    @Override // com.google.android.libraries.navigation.internal.nt.t
    public final void a(com.google.android.libraries.navigation.internal.nt.m mVar) {
        Account accountA;
        ev evVar = (ev) mVar.c();
        if (evVar != null) {
            j jVar = this.a;
            HashMap map = new HashMap();
            com.google.android.libraries.navigation.internal.yx.ar.k(map.isEmpty());
            Account account = null;
            for (com.google.android.libraries.navigation.internal.ik.d dVar : hx.g(evVar)) {
                if (dVar != null && (accountA = dVar.a()) != null) {
                    map.put(accountA, dVar);
                    account = accountA;
                }
            }
            synchronized (jVar) {
                jVar.f = map;
                if (account != null && !jVar.e.g()) {
                    jVar.e = com.google.android.libraries.navigation.internal.yx.an.j(account);
                }
                if (jVar.e.g()) {
                    jVar.d((com.google.android.libraries.navigation.internal.ik.d) jVar.f.get(jVar.e.c()));
                }
            }
        }
    }
}
