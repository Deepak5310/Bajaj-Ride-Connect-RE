package com.google.android.libraries.navigation.internal.abe;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class e extends BroadcastReceiver {
    public volatile boolean a;
    final /* synthetic */ f b;

    public e(f fVar) {
        this.b = fVar;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (f.g(context) && this.a) {
            f fVar = this.b;
            fVar.j.b(fVar);
            context.unregisterReceiver(this);
            this.a = false;
        }
    }
}
