package com.google.android.libraries.navigation.internal.fr;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.tracing.Trace;
import com.reactnativecommunity.netinfo.BroadcastReceiverConnectivityReceiver;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class b extends BroadcastReceiver {
    private static final com.google.android.libraries.navigation.internal.zb.j a = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.navigation.internal.fr.b");
    private final e b;

    public b(e eVar) {
        this.b = eVar;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("ConnectivityChangeReceiver.onReceive");
        try {
            if (intent.getAction().equals(BroadcastReceiverConnectivityReceiver.CONNECTIVITY_ACTION)) {
                this.b.a().b();
                this.b.g();
            } else {
                ((com.google.android.libraries.navigation.internal.zb.h) a.d(com.google.android.libraries.navigation.internal.nl.a.a).F(TypedValues.PositionType.TYPE_PERCENT_Y)).p("ConnectivityChangeReceiver should be only registered to CONNECTIVITY_ACTION!");
            }
            if (dVarB != null) {
                Trace.endSection();
            }
        } catch (Throwable th) {
            if (dVarB != null) {
                try {
                    Trace.endSection();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }
}
