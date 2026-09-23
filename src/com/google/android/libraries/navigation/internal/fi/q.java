package com.google.android.libraries.navigation.internal.fi;

import android.location.Location;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class q {
    private final com.google.android.libraries.navigation.internal.agl.a a;
    private final com.google.android.libraries.navigation.internal.agl.a b;

    public q(com.google.android.libraries.navigation.internal.agl.a aVar, com.google.android.libraries.navigation.internal.agl.a aVar2) {
        aVar.getClass();
        this.a = aVar;
        aVar2.getClass();
        this.b = aVar2;
    }

    final p a(Location location) {
        com.google.android.libraries.navigation.internal.ia.e eVar = (com.google.android.libraries.navigation.internal.ia.e) this.a.a();
        eVar.getClass();
        com.google.android.libraries.navigation.internal.mj.a aVar = (com.google.android.libraries.navigation.internal.mj.a) this.b.a();
        aVar.getClass();
        location.getClass();
        return new p(eVar, aVar, location);
    }
}
