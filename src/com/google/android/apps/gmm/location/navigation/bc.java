package com.google.android.apps.gmm.location.navigation;

import j$.time.Duration;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes3.dex */
public final class bc extends com.google.android.libraries.navigation.internal.ia.k {
    public bc(Class cls, ax axVar, com.google.android.libraries.navigation.internal.hx.ap apVar) {
        super(cls, axVar, apVar, null);
    }

    @Override // com.google.android.libraries.navigation.internal.ia.k
    protected final void a(com.google.android.libraries.navigation.internal.ic.a aVar) {
        com.google.android.libraries.navigation.internal.da.h hVar = (com.google.android.libraries.navigation.internal.da.h) aVar;
        if (hVar.d > 25.0f) {
            long j = ba.a;
            return;
        }
        long j2 = ba.a;
        double d = hVar.b;
        double d2 = hVar.c;
        float f = hVar.d;
        com.google.android.libraries.navigation.internal.db.q qVar = new com.google.android.libraries.navigation.internal.db.q(Duration.ofMillis(hVar.a));
        qVar.s(hVar.b, hVar.c);
        qVar.d = hVar.d;
        qVar.a();
    }
}
