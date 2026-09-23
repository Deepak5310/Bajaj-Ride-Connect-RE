package com.google.android.libraries.navigation.internal.tp;

import androidx.core.app.NotificationCompat;
import com.google.android.libraries.navigation.internal.adu.m;
import com.google.android.libraries.navigation.internal.ee.u;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class d {
    private static final com.google.android.libraries.navigation.internal.zb.j a = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.navigation.internal.tp.d");
    private final com.google.android.libraries.navigation.internal.eg.a b;
    private final com.google.android.libraries.navigation.internal.eh.d c;

    public d(com.google.android.libraries.navigation.internal.eg.a aVar, com.google.android.libraries.navigation.internal.eh.d dVar) {
        this.b = aVar;
        this.c = dVar;
    }

    public final boolean a(NotificationCompat.Builder builder, int i) {
        this.b.a();
        u uVarA = this.c.a(m.NAVIGATION_STATUS.eU);
        if (uVarA == null) {
            return false;
        }
        String strC = uVarA.a().c(i);
        if (strC != null) {
            builder.setChannelId(strC);
            return true;
        }
        ((com.google.android.libraries.navigation.internal.zb.h) a.d(com.google.android.libraries.navigation.internal.nl.a.a).F((char) 1826)).p("ChannelId for the navigation status notification type should be non null.");
        builder.setChannelId("OtherChannel");
        return true;
    }
}
