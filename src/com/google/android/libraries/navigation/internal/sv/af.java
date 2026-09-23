package com.google.android.libraries.navigation.internal.sv;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class af extends BroadcastReceiver {
    final /* synthetic */ ak a;

    public af(ak akVar) {
        this.a = akVar;
    }

    public final /* synthetic */ void a() {
        ak akVar = this.a;
        akVar.A = ak.e(akVar.r, akVar.g);
        ak akVar2 = this.a;
        if (akVar2.D != null) {
            akVar2.p();
        }
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        int i = ak.K;
        if (((com.google.android.libraries.navigation.internal.fr.d) this.a.i.a()).e()) {
            ak akVar = this.a;
            akVar.G.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.sv.ae
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.a();
                }
            });
        }
    }
}
