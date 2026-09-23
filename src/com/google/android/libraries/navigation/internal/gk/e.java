package com.google.android.libraries.navigation.internal.gk;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkRequest;
import androidx.work.WorkRequest;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class e implements ad {
    public final ConnectivityManager a;
    public long c;
    public final com.google.android.libraries.navigation.internal.mj.a d;
    private final s f;
    public ConnectivityManager.NetworkCallback b = null;
    private final ScheduledExecutorService e = Executors.newSingleThreadScheduledExecutor();

    public e(ConnectivityManager connectivityManager, s sVar, com.google.android.libraries.navigation.internal.mj.a aVar) {
        this.a = connectivityManager;
        this.f = sVar;
        this.d = aVar;
    }

    public final void a() {
        long jA = this.c - this.d.a();
        this.e.schedule(new Runnable() { // from class: com.google.android.libraries.navigation.internal.gk.d
            @Override // java.lang.Runnable
            public final void run() {
                e eVar = this.a;
                if (eVar.c - eVar.d.a() > 0) {
                    eVar.a();
                    return;
                }
                eVar.d.a();
                try {
                    ConnectivityManager.NetworkCallback networkCallback = eVar.b;
                    if (networkCallback != null) {
                        eVar.a.unregisterNetworkCallback(networkCallback);
                    }
                    eVar.b = null;
                } catch (RuntimeException e) {
                    ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F(583)).s("Failed to unregister network. The exception is ignored: %s", e.getMessage());
                }
            }
        }, jA, TimeUnit.MILLISECONDS);
    }

    @Override // com.google.android.libraries.navigation.internal.gk.ad
    public final boolean b() {
        return this.f.a();
    }

    @Override // com.google.android.libraries.navigation.internal.gk.ad
    public final void c() {
        this.e.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.gk.c
            @Override // java.lang.Runnable
            public final void run() {
                NetworkCapabilities networkCapabilities;
                e eVar = this.a;
                eVar.c = eVar.d.a() + WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS;
                if (eVar.b != null) {
                    return;
                }
                eVar.d.a();
                ConnectivityManager.NetworkCallback networkCallback = new ConnectivityManager.NetworkCallback();
                eVar.b = networkCallback;
                Network activeNetwork = eVar.a.getActiveNetwork();
                if (activeNetwork != null && ((networkCapabilities = eVar.a.getNetworkCapabilities(activeNetwork)) == null || !networkCapabilities.hasTransport(0))) {
                    eVar.a.reportNetworkConnectivity(activeNetwork, false);
                }
                try {
                    eVar.a.requestNetwork(new NetworkRequest.Builder().addCapability(12).addTransportType(0).build(), networkCallback);
                } catch (RuntimeException unused) {
                    ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F((char) 581)).p("Cannot request mobile network, keeping on wifi");
                }
                eVar.a();
            }
        });
    }
}
