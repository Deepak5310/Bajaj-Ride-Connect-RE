package com.google.android.libraries.navigation.internal.ne;

import android.content.Context;
import android.content.IntentFilter;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class d {
    private static boolean a = false;

    public static synchronized void a(Context context) {
        if (a) {
            return;
        }
        context.getApplicationContext().registerReceiver(new e(), new IntentFilter("android.intent.action.TIMEZONE_CHANGED"));
        a = true;
    }
}
