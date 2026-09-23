package com.google.android.libraries.navigation.internal.abh;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Process;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class bb extends BroadcastReceiver {
    private final bc a;

    public bb(bc bcVar) {
        this.a = bcVar;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        NetworkInfo activeNetworkInfo;
        bc bcVar = this.a;
        if (bcVar.a.checkPermission("android.permission.ACCESS_NETWORK_STATE", Process.myPid(), Process.myUid()) == 0 && ((activeNetworkInfo = ((ConnectivityManager) bcVar.a.getSystemService("connectivity")).getActiveNetworkInfo()) == null || !activeNetworkInfo.isConnected())) {
            return;
        }
        synchronized (bcVar) {
        }
    }
}
