package com.google.android.libraries.navigation.internal.sv;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class ad extends BroadcastReceiver {
    final /* synthetic */ ak a;

    public ad(ak akVar) {
        this.a = akVar;
    }

    public final /* synthetic */ void a() {
        this.a.H(null, false, false, true);
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        ((com.google.android.libraries.navigation.internal.kk.j) this.a.b.a(com.google.android.libraries.navigation.internal.km.af.B)).a();
        this.a.G.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.sv.ac
            @Override // java.lang.Runnable
            public final void run() {
                this.a.a();
            }
        });
    }
}
