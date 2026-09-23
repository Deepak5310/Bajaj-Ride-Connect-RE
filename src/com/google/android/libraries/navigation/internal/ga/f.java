package com.google.android.libraries.navigation.internal.ga;

import android.app.Application;
import android.content.IntentFilter;
import com.google.android.libraries.navigation.internal.afr.g;
import com.google.android.libraries.navigation.internal.iv.ab;
import com.reactnativecommunity.netinfo.BroadcastReceiverConnectivityReceiver;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class f implements com.google.android.libraries.navigation.internal.afr.f {
    private final com.google.android.libraries.navigation.internal.agl.a a;
    private final com.google.android.libraries.navigation.internal.agl.a b;
    private final com.google.android.libraries.navigation.internal.agl.a c;

    public f(com.google.android.libraries.navigation.internal.agl.a aVar, com.google.android.libraries.navigation.internal.agl.a aVar2, com.google.android.libraries.navigation.internal.agl.a aVar3) {
        this.a = aVar;
        this.b = aVar2;
        this.c = aVar3;
    }

    @Override // com.google.android.libraries.navigation.internal.agl.a, com.google.android.libraries.navigation.internal.agk.a
    public final /* bridge */ /* synthetic */ Object a() {
        e eVar = new e((Application) ((g) this.a).a, (com.google.android.libraries.navigation.internal.iv.f) this.b.a(), (com.google.android.libraries.navigation.internal.ia.e) this.c.a());
        if (eVar.b.y(ab.aC, false)) {
            if (!eVar.e) {
                synchronized (eVar) {
                    if (eVar.d == null) {
                        eVar.d = new d(eVar);
                        eVar.a.registerReceiver(eVar.d, new IntentFilter(BroadcastReceiverConnectivityReceiver.CONNECTIVITY_ACTION));
                    }
                }
                eVar.c.a(new com.google.android.libraries.navigation.internal.gc.b());
                eVar.e = true;
                if (eVar.d()) {
                    eVar.c();
                } else {
                    eVar.b();
                }
            }
        } else if (eVar.e) {
            synchronized (eVar) {
                d dVar = eVar.d;
                if (dVar != null) {
                    eVar.a.unregisterReceiver(dVar);
                    eVar.d = null;
                }
            }
            eVar.c.a(new com.google.android.libraries.navigation.internal.gc.b());
            eVar.e = false;
            if (eVar.f) {
                eVar.c();
            }
        }
        return eVar;
    }
}
