package com.google.android.libraries.navigation.internal.tj;

import j$.time.Duration;
import j$.time.Instant;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ab extends w {
    public static final Duration b = Duration.ofSeconds(45);
    public com.google.android.libraries.navigation.internal.tt.d c;
    public boolean d;
    public final boolean e;
    private final com.google.android.libraries.navigation.internal.dx.o f;
    private final boolean g;
    private final Instant h;

    /* JADX WARN: Illegal instructions before constructor call */
    public ab(com.google.android.libraries.navigation.internal.dx.o oVar, com.google.android.libraries.navigation.internal.tt.d dVar, boolean z, boolean z2, Instant instant) {
        boolean z3 = true;
        if (dVar.t() != null && ((!dVar.E() || dVar.v() != null) && dVar.m() != null)) {
            z3 = false;
        }
        super(z3);
        this.d = false;
        this.f = oVar;
        this.c = dVar;
        this.e = z;
        this.g = false;
        this.h = null;
    }

    @Override // com.google.android.libraries.navigation.internal.tj.a, com.google.android.libraries.navigation.internal.tj.u
    public final long a() {
        return Long.MAX_VALUE;
    }

    @Override // com.google.android.libraries.navigation.internal.tj.a, com.google.android.libraries.navigation.internal.tj.u
    public final Duration b() {
        return b;
    }

    @Override // com.google.android.libraries.navigation.internal.tj.w
    public final v g() {
        return new v(com.google.android.libraries.navigation.internal.jl.b.i, com.google.android.libraries.navigation.internal.afe.i.B, com.google.android.libraries.navigation.internal.afe.i.C);
    }

    public final boolean h() {
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.tj.u
    public final t j() {
        return this.e ? t.MODERATABLE_TRAFFIC_INCIDENT : t.TRAFFIC_INCIDENT;
    }

    @Override // com.google.android.libraries.navigation.internal.tj.u
    public final boolean m() {
        return true;
    }

    @Override // com.google.android.libraries.navigation.internal.tj.u
    public final boolean n() {
        return true;
    }
}
