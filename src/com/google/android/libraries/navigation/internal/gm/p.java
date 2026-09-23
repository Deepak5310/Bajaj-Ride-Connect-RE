package com.google.android.libraries.navigation.internal.gm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.google.android.libraries.navigation.internal.aac.ca;
import com.reactnativecommunity.netinfo.BroadcastReceiverConnectivityReceiver;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class p extends BroadcastReceiver {
    final /* synthetic */ q a;

    public p(q qVar) {
        this.a = qVar;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (BroadcastReceiverConnectivityReceiver.CONNECTIVITY_ACTION.equals(intent.getAction())) {
            q qVar = this.a;
            synchronized (qVar) {
                ca caVar = qVar.a;
                if (caVar == null) {
                    return;
                }
                com.google.android.libraries.navigation.internal.gh.b bVarB = qVar.b();
                if (bVarB != null) {
                    caVar.d(bVarB);
                } else if (caVar.isDone()) {
                    qVar.a = null;
                }
            }
        }
    }
}
