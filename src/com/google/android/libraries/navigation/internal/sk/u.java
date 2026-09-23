package com.google.android.libraries.navigation.internal.sk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import java.util.Locale;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class u extends BroadcastReceiver {
    final /* synthetic */ x a;

    public u(x xVar) {
        this.a = xVar;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        ((dt) this.a.f576n.a()).c(Locale.getDefault());
        ((ds) this.a.m.a()).c(Locale.getDefault());
    }
}
