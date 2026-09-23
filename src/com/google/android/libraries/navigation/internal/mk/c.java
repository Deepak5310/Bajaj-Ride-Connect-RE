package com.google.android.libraries.navigation.internal.mk;

import android.os.SystemClock;
import com.google.android.libraries.navigation.internal.mj.e;
import j$.time.Duration;
import j$.time.Instant;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class c implements e {
    private final com.google.android.libraries.navigation.internal.mj.a a = new b();

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
        return this.a.d();
    }

    @Override // com.google.android.libraries.navigation.internal.mj.a
    public final Duration e() {
        return this.a.e();
    }

    @Override // com.google.android.libraries.navigation.internal.mj.a
    public final Instant f() {
        return this.a.f();
    }
}
