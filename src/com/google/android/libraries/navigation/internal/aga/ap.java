package com.google.android.libraries.navigation.internal.aga;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ap {
    private final Random a = new Random();
    private final long b;
    private final long c;
    private final double d;
    private final double e;
    private long f;

    public ap() {
        long nanos = TimeUnit.SECONDS.toNanos(1L);
        this.b = nanos;
        this.c = TimeUnit.MINUTES.toNanos(2L);
        this.d = 1.6d;
        this.e = 0.2d;
        this.f = nanos;
    }

    public final long a() {
        long j = this.f;
        double d = j;
        this.f = Math.min((long) (1.6d * d), this.c);
        double d2 = 0.2d * d;
        double d3 = d * (-0.2d);
        com.google.android.libraries.navigation.internal.yx.ar.a(d2 >= d3);
        return j + ((long) ((this.a.nextDouble() * (d2 - d3)) + d3));
    }
}
