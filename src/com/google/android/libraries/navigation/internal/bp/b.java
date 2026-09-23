package com.google.android.libraries.navigation.internal.bp;

import com.google.android.libraries.navigation.internal.yz.eq;
import com.google.android.libraries.navigation.internal.yz.ev;
import j$.time.Duration;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class b {
    public static final com.google.android.libraries.navigation.internal.zb.j a = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.navigation.internal.bp.b");

    public static void b(eq eqVar, com.google.android.libraries.navigation.internal.adr.i iVar, int i, Duration duration) {
        h hVar = new h();
        hVar.e(iVar.c);
        hVar.d(Duration.ofSeconds(iVar.d));
        hVar.c(i - iVar.c);
        hVar.b(duration.minus(Duration.ofSeconds(iVar.d)));
        eqVar.h(hVar.a());
    }

    public abstract ev a();
}
