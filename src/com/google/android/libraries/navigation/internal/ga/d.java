package com.google.android.libraries.navigation.internal.ga;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class d extends BroadcastReceiver {
    final /* synthetic */ e a;

    public d(e eVar) {
        this.a = eVar;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        e eVar = this.a;
        if (eVar.d()) {
            if (eVar.f) {
                eVar.c();
            }
        } else {
            if (eVar.f) {
                return;
            }
            eVar.b();
        }
    }
}
