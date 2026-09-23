package com.google.android.libraries.navigation.internal.fr;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a {
    public static final IntentFilter a = new IntentFilter("android.intent.action.BATTERY_CHANGED");

    public static Intent a(Context context) {
        return context.registerReceiver(null, a);
    }
}
