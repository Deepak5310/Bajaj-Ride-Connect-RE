package com.google.android.libraries.navigation.internal.mk;

import android.os.SystemClock;
import j$.time.Duration;
import j$.time.Instant;
import j$.time.temporal.ChronoUnit;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class b implements com.google.android.libraries.navigation.internal.mj.a {
    @Override // com.google.android.libraries.navigation.internal.mj.a
    public final long a() {
        return SystemClock.elapsedRealtime();
    }

    @Override // com.google.android.libraries.navigation.internal.mj.a
    public final long b() {
        return a.a();
    }

    @Override // com.google.android.libraries.navigation.internal.mj.a
    public final long c() {
        return System.nanoTime();
    }

    @Override // com.google.android.libraries.navigation.internal.mj.a
    public final Duration d() {
        return Duration.ofMillis(SystemClock.currentThreadTimeMillis());
    }

    @Override // com.google.android.libraries.navigation.internal.mj.a
    public final Duration e() {
        return Duration.ofMillis(SystemClock.uptimeMillis());
    }

    @Override // com.google.android.libraries.navigation.internal.mj.a
    public final Instant f() {
        return Instant.now().truncatedTo(ChronoUnit.MILLIS);
    }
}
