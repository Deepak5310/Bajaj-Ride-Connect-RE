package com.google.android.libraries.navigation.internal.db;

import j$.time.Duration;
import j$.time.Instant;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class at implements as {
    public final com.google.android.libraries.navigation.internal.aes.h a;
    public final Instant b;

    public at(com.google.android.libraries.navigation.internal.aes.h hVar) {
        this.a = hVar;
        com.google.android.libraries.navigation.internal.aes.d dVar = hVar.f;
        int i = (dVar == null ? com.google.android.libraries.navigation.internal.aes.d.a : dVar).c;
        com.google.android.libraries.navigation.internal.aes.d dVar2 = hVar.f;
        int i2 = (dVar2 == null ? com.google.android.libraries.navigation.internal.aes.d.a : dVar2).d;
        float f = hVar.g;
        if ((hVar.b & 4) != 0) {
            this.b = com.google.android.libraries.navigation.internal.aaa.b.b(hVar.e);
        } else {
            this.b = Instant.ofEpochMilli(-1L);
        }
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
        return this.a;
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
