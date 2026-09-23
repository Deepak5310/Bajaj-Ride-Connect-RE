package com.google.android.libraries.navigation.internal.db;

import com.google.android.libraries.navigation.internal.ael.bb;
import j$.time.Duration;
import j$.time.Instant;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ag implements as {
    private final as a;

    public ag(as asVar) {
        this.a = asVar;
    }

    @Override // com.google.android.libraries.navigation.internal.db.as
    public final double b() {
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.db.as
    public final double c() {
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.db.as
    public final com.google.android.libraries.navigation.internal.aes.h o() {
        com.google.android.libraries.navigation.internal.aes.h hVarO = this.a.o();
        bb bbVar = (bb) hVarO.aH(5, null);
        bbVar.x(hVarO);
        com.google.android.libraries.navigation.internal.aes.g gVar = (com.google.android.libraries.navigation.internal.aes.g) bbVar;
        int i = com.google.android.libraries.navigation.internal.aes.l.e;
        if (!gVar.b.H()) {
            gVar.v();
        }
        com.google.android.libraries.navigation.internal.aes.h hVar = (com.google.android.libraries.navigation.internal.aes.h) gVar.b;
        com.google.android.libraries.navigation.internal.aes.h hVar2 = com.google.android.libraries.navigation.internal.aes.h.a;
        int i2 = i - 2;
        if (i == 0) {
            throw null;
        }
        hVar.c = i2;
        hVar.b |= 1;
        int i3 = com.google.android.libraries.navigation.internal.aes.j.ah;
        if (!gVar.b.H()) {
            gVar.v();
        }
        com.google.android.libraries.navigation.internal.aes.h hVar3 = (com.google.android.libraries.navigation.internal.aes.h) gVar.b;
        int i4 = i3 - 2;
        if (i3 == 0) {
            throw null;
        }
        hVar3.d = i4;
        hVar3.b |= 2;
        return (com.google.android.libraries.navigation.internal.aes.h) gVar.t();
    }

    @Override // com.google.android.libraries.navigation.internal.db.as
    public final Duration p() {
        return Duration.ZERO;
    }

    @Override // com.google.android.libraries.navigation.internal.db.as
    public final Instant q() {
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.db.as
    public final boolean z() {
        throw null;
    }
}
