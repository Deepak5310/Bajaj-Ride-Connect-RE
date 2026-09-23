package com.google.android.libraries.navigation.internal.xt;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class aw extends BroadcastReceiver {
    public static volatile ab a;
    static volatile ac b;

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        ab abVar;
        String stringExtra = intent.getStringExtra("com.google.android.gms.phenotype.PACKAGE_NAME");
        if (stringExtra == null || stringExtra.contains("../") || stringExtra.contains("/..") || (abVar = a) == null) {
            return;
        }
        abVar.a(stringExtra);
    }
}
