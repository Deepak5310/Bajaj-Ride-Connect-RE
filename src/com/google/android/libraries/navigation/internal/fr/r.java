package com.google.android.libraries.navigation.internal.fr;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class r extends BroadcastReceiver {
    private static final com.google.android.libraries.navigation.internal.zb.j a = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.navigation.internal.fr.r");
    private final e b;

    public r(e eVar) {
        this.b = eVar;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (action.equals("android.intent.action.ACTION_POWER_CONNECTED")) {
            this.b.h(3);
        } else if (action.equals("android.intent.action.ACTION_POWER_DISCONNECTED")) {
            this.b.h(2);
        } else {
            ((com.google.android.libraries.navigation.internal.zb.h) a.d(com.google.android.libraries.navigation.internal.nl.a.a).F((char) 519)).p("PowerConnectionReceiver should be only registered to ACTION_POWER_CONNECTED and ACTION_POWER_DISCONNECTED!");
        }
    }
}
