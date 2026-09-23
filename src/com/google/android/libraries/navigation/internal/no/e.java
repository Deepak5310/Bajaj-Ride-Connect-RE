package com.google.android.libraries.navigation.internal.no;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.google.android.libraries.navigation.internal.nt.ac;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class e extends BroadcastReceiver {
    final /* synthetic */ ac a;

    public e(ac acVar) {
        this.a = acVar;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        this.a.a();
    }
}
