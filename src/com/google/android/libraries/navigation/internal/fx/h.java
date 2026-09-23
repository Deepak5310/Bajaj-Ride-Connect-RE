package com.google.android.libraries.navigation.internal.fx;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class h extends BroadcastReceiver {
    public volatile boolean a;
    final /* synthetic */ i b;

    public h(i iVar) {
        this.b = iVar;
    }

    @Override // android.content.BroadcastReceiver
    public final synchronized void onReceive(Context context, Intent intent) {
        if (i.g(context) && this.a) {
            i iVar = this.b;
            iVar.p.c(iVar.r);
            context.unregisterReceiver(this);
            this.a = false;
        }
    }
}
