package com.google.android.libraries.navigation.internal.tc;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class v extends BroadcastReceiver {
    final /* synthetic */ y a;

    public v(y yVar) {
        this.a = yVar;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if ("android.bluetooth.device.action.ACL_CONNECTED".equals(action) || "android.bluetooth.device.action.ACL_DISCONNECTED".equals(action)) {
            int i = y.c;
            this.a.c();
        }
    }
}
