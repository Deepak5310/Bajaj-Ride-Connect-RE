package com.google.android.libraries.navigation.internal.dh;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class m extends BroadcastReceiver {
    final /* synthetic */ n a;

    public m(n nVar) {
        this.a = nVar;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if ("android.bluetooth.adapter.action.STATE_CHANGED".equals(intent.getAction())) {
            this.a.a();
        }
    }
}
