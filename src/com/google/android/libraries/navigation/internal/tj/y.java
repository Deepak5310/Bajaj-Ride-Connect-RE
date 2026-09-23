package com.google.android.libraries.navigation.internal.tj;

import j$.time.Duration;
import j$.time.Instant;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class y extends a {
    private static final Duration b = Duration.ofSeconds(6);
    public final com.google.android.libraries.navigation.internal.tt.d a;
    private final com.google.android.libraries.navigation.internal.dx.o c;
    private final Instant d = null;

    public y(com.google.android.libraries.navigation.internal.dx.o oVar, com.google.android.libraries.navigation.internal.tt.d dVar, Instant instant) {
        this.c = oVar;
        this.a = dVar;
    }

    @Override // com.google.android.libraries.navigation.internal.tj.a, com.google.android.libraries.navigation.internal.tj.u
    public final long a() {
        return Long.MAX_VALUE;
    }

    @Override // com.google.android.libraries.navigation.internal.tj.a, com.google.android.libraries.navigation.internal.tj.u
    public final Duration b() {
        return b;
    }

    @Override // com.google.android.libraries.navigation.internal.tj.a, com.google.android.libraries.navigation.internal.tj.u
    public final boolean e() {
        return true;
    }

    @Override // com.google.android.libraries.navigation.internal.tj.u
    public final t j() {
        return t.TRAFFIC_INCIDENT;
    }

    @Override // com.google.android.libraries.navigation.internal.tj.u
    public final boolean m() {
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.tj.u
    public final boolean n() {
        return true;
    }
}
