package com.google.android.apps.gmm.location.navigation;

import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes3.dex */
public final class c extends com.google.android.libraries.navigation.internal.ia.k {
    public c(Class cls, b bVar, com.google.android.libraries.navigation.internal.hx.ap apVar) {
        super(cls, bVar, apVar, null);
    }

    @Override // com.google.android.libraries.navigation.internal.ia.k
    protected final void a(com.google.android.libraries.navigation.internal.ic.a aVar) {
        com.google.android.libraries.navigation.internal.dh.i iVar = (com.google.android.libraries.navigation.internal.dh.i) aVar;
        bg bgVar = ((b) this.c).a;
        if (bgVar != null) {
            com.google.android.libraries.navigation.internal.acu.av avVar = (com.google.android.libraries.navigation.internal.acu.av) com.google.android.libraries.navigation.internal.acu.aw.a.q();
            long millis = TimeUnit.NANOSECONDS.toMillis(iVar.e);
            if (!avVar.b.H()) {
                avVar.v();
            }
            com.google.android.libraries.navigation.internal.acu.aw awVar = (com.google.android.libraries.navigation.internal.acu.aw) avVar.b;
            awVar.b |= 1;
            awVar.e = millis;
            com.google.android.libraries.navigation.internal.acu.e eVar = (com.google.android.libraries.navigation.internal.acu.e) com.google.android.libraries.navigation.internal.acu.f.a.q();
            long j = iVar.a;
            if (!eVar.b.H()) {
                eVar.v();
            }
            com.google.android.libraries.navigation.internal.acu.f fVar = (com.google.android.libraries.navigation.internal.acu.f) eVar.b;
            fVar.b |= 1;
            fVar.c = j;
            long j2 = iVar.b;
            if (!eVar.b.H()) {
                eVar.v();
            }
            com.google.android.libraries.navigation.internal.acu.f fVar2 = (com.google.android.libraries.navigation.internal.acu.f) eVar.b;
            fVar2.b |= 2;
            fVar2.d = j2;
            double d = iVar.d;
            if (!eVar.b.H()) {
                eVar.v();
            }
            com.google.android.libraries.navigation.internal.acu.f fVar3 = (com.google.android.libraries.navigation.internal.acu.f) eVar.b;
            fVar3.b |= 4;
            fVar3.e = d;
            double d2 = iVar.c;
            if (!eVar.b.H()) {
                eVar.v();
            }
            com.google.android.libraries.navigation.internal.acu.f fVar4 = (com.google.android.libraries.navigation.internal.acu.f) eVar.b;
            fVar4.b |= 8;
            fVar4.f = d2;
            if (!avVar.b.H()) {
                avVar.v();
            }
            com.google.android.libraries.navigation.internal.acu.aw awVar2 = (com.google.android.libraries.navigation.internal.acu.aw) avVar.b;
            com.google.android.libraries.navigation.internal.acu.f fVar5 = (com.google.android.libraries.navigation.internal.acu.f) eVar.t();
            fVar5.getClass();
            awVar2.d = fVar5;
            awVar2.c = 7;
            bgVar.c((com.google.android.libraries.navigation.internal.acu.aw) avVar.t());
        }
    }
}
