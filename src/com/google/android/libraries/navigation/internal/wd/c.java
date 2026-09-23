package com.google.android.libraries.navigation.internal.wd;

import android.net.ConnectivityManager;
import android.net.Network;
import android.os.SystemClock;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class c extends ConnectivityManager.NetworkCallback {
    final /* synthetic */ e a;

    public c(e eVar) {
        this.a = eVar;
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onAvailable(Network network) {
        this.a.c.add(network);
        this.a.b = SystemClock.elapsedRealtime();
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onLost(Network network) {
        this.a.c.remove(network);
        if (this.a.c.isEmpty()) {
            this.a.b = 0L;
        }
    }
}
