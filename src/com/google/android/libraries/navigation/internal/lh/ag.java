package com.google.android.libraries.navigation.internal.lh;

import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Looper;
import androidx.work.PeriodicWorkRequest;
import java.util.HashMap;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class ag extends ad {
    public final HashMap f = new HashMap();
    public final Context g;
    public volatile Handler h;
    public final com.google.android.libraries.navigation.internal.lk.a i;
    public final long j;
    private final af k;
    private final long l;
    private volatile Executor m;

    public ag(Context context, Looper looper) {
        af afVar = new af(this);
        this.k = afVar;
        this.g = context.getApplicationContext();
        this.h = new com.google.android.libraries.navigation.internal.lt.c(looper, afVar);
        if (com.google.android.libraries.navigation.internal.lk.a.b == null) {
            synchronized (com.google.android.libraries.navigation.internal.lk.a.a) {
                if (com.google.android.libraries.navigation.internal.lk.a.b == null) {
                    com.google.android.libraries.navigation.internal.lk.a.b = new com.google.android.libraries.navigation.internal.lk.a();
                }
            }
        }
        com.google.android.libraries.navigation.internal.lk.a aVar = com.google.android.libraries.navigation.internal.lk.a.b;
        be.j(aVar);
        this.i = aVar;
        this.l = 5000L;
        this.j = PeriodicWorkRequest.MIN_PERIODIC_FLEX_MILLIS;
        this.m = null;
    }

    @Override // com.google.android.libraries.navigation.internal.lh.ad
    protected final com.google.android.libraries.navigation.internal.lc.a b(ac acVar, ServiceConnection serviceConnection, String str) {
        com.google.android.libraries.navigation.internal.lc.a aVarC;
        synchronized (this.f) {
            ae aeVar = (ae) this.f.get(acVar);
            if (aeVar == null) {
                aeVar = new ae(this, acVar);
                aeVar.d(serviceConnection, serviceConnection);
                aVarC = ae.c(aeVar);
                this.f.put(acVar, aeVar);
            } else {
                this.h.removeMessages(0, acVar);
                if (aeVar.a(serviceConnection)) {
                    throw new IllegalStateException("Trying to bind a GmsServiceConnection that was already connected before.  config=" + acVar.toString());
                }
                aeVar.d(serviceConnection, serviceConnection);
                int i = aeVar.b;
                if (i == 1) {
                    serviceConnection.onServiceConnected(aeVar.f, aeVar.d);
                } else if (i == 2) {
                    aVarC = ae.c(aeVar);
                }
                aVarC = null;
            }
            if (aeVar.c) {
                return com.google.android.libraries.navigation.internal.lc.a.a;
            }
            if (aVarC == null) {
                aVarC = new com.google.android.libraries.navigation.internal.lc.a(-1);
            }
            return aVarC;
        }
    }

    @Override // com.google.android.libraries.navigation.internal.lh.ad
    protected final void c(ac acVar, ServiceConnection serviceConnection) {
        synchronized (this.f) {
            ae aeVar = (ae) this.f.get(acVar);
            if (aeVar == null) {
                throw new IllegalStateException("Nonexistent connection status for service config: " + acVar.toString());
            }
            if (!aeVar.a(serviceConnection)) {
                throw new IllegalStateException("Trying to unbind a GmsServiceConnection  that was not bound before.  config=" + acVar.toString());
            }
            aeVar.a.remove(serviceConnection);
            if (aeVar.b()) {
                this.h.sendMessageDelayed(this.h.obtainMessage(0, acVar), this.l);
            }
        }
    }
}
