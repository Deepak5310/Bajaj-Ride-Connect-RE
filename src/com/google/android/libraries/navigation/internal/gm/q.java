package com.google.android.libraries.navigation.internal.gm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import com.google.android.libraries.navigation.internal.aac.az;
import com.google.android.libraries.navigation.internal.aac.bj;
import com.google.android.libraries.navigation.internal.aac.ca;
import com.reactnativecommunity.netinfo.BroadcastReceiverConnectivityReceiver;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class q implements com.google.android.libraries.navigation.internal.gh.e {
    private static final com.google.android.libraries.navigation.internal.gh.b c = new com.google.android.libraries.navigation.internal.gh.a("connectivity", Boolean.toString(true));
    public ca a;
    final BroadcastReceiver b = new p(this);
    private final AtomicBoolean d = new AtomicBoolean(false);
    private final com.google.android.libraries.navigation.internal.fr.d e;
    private final Context f;

    public q(Context context, com.google.android.libraries.navigation.internal.fr.d dVar) {
        this.e = dVar;
        this.f = context;
    }

    @Override // com.google.android.libraries.navigation.internal.gh.e
    public final bj a() {
        com.google.android.libraries.navigation.internal.gh.b bVarB = b();
        if (bVarB != null) {
            return az.h(bVarB);
        }
        synchronized (this) {
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
        if (!this.d.getAndSet(true)) {
            this.f.registerReceiver(this.b, new IntentFilter(BroadcastReceiverConnectivityReceiver.CONNECTIVITY_ACTION));
        }
        if (this.e.e()) {
            return c;
        }
        return null;
    }
}
