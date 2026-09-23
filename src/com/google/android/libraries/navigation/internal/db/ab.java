package com.google.android.libraries.navigation.internal.db;

import j$.time.Duration;
import j$.time.Instant;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ab implements as {
    public final Duration a;
    private final double b;
    private final double c;
    private final float d;
    private final n e;
    private final boolean f;
    private final Instant g;

    public ab(double d, double d2, float f, n nVar, Duration duration, boolean z, Instant instant) {
        this.b = d;
        this.c = d2;
        this.d = f;
        this.e = nVar;
        this.a = duration;
        this.f = z;
        this.g = instant;
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
        com.google.android.libraries.navigation.internal.aes.g gVarA = w.a(this.b, this.c, this.d);
        int i = com.google.android.libraries.navigation.internal.aes.l.b;
        if (!gVarA.b.H()) {
            gVarA.v();
        }
        com.google.android.libraries.navigation.internal.aes.h hVar = (com.google.android.libraries.navigation.internal.aes.h) gVarA.b;
        com.google.android.libraries.navigation.internal.aes.h hVar2 = com.google.android.libraries.navigation.internal.aes.h.a;
        int i2 = i - 2;
        if (i == 0) {
            throw null;
        }
        hVar.c = i2;
        hVar.b |= 1;
        int i3 = com.google.android.libraries.navigation.internal.aes.j.ak;
        if (!gVarA.b.H()) {
            gVarA.v();
        }
        com.google.android.libraries.navigation.internal.aes.h hVar3 = (com.google.android.libraries.navigation.internal.aes.h) gVarA.b;
        int i4 = i3 - 2;
        if (i3 == 0) {
            throw null;
        }
        hVar3.d = i4;
        hVar3.b |= 2;
        if (this.f) {
            long jA = com.google.android.libraries.navigation.internal.aaa.b.a(this.g);
            if (!gVarA.b.H()) {
                gVarA.v();
            }
            com.google.android.libraries.navigation.internal.aes.h hVar4 = (com.google.android.libraries.navigation.internal.aes.h) gVarA.b;
            hVar4.b |= 4;
            hVar4.e = jA;
        }
        return (com.google.android.libraries.navigation.internal.aes.h) gVarA.t();
    }

    @Override // com.google.android.libraries.navigation.internal.db.as
    public final Duration p() {
        return ((r) this.e).g;
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
