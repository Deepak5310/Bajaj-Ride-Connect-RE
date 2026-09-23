package com.google.android.libraries.navigation.internal.aaa;

import com.google.android.libraries.navigation.internal.zw.g;
import j$.time.Instant;
import java.math.RoundingMode;
import kotlin.time.DurationKt;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class b {
    static {
        Instant.ofEpochMilli(Long.MAX_VALUE);
        Instant.ofEpochMilli(Long.MIN_VALUE);
        b(Long.MAX_VALUE);
        b(Long.MIN_VALUE);
        c(Long.MAX_VALUE);
        c(Long.MIN_VALUE);
        Instant.MIN.getEpochSecond();
        Instant.MAX.getEpochSecond();
    }

    public static long a(Instant instant) {
        return instant.getEpochSecond() < -9223372036854L ? g.b(g.c(instant.getEpochSecond() + 1, 1000000L), (instant.getNano() / 1000) - 1000000) : g.b(g.c(instant.getEpochSecond(), 1000000L), instant.getNano() / 1000);
    }

    public static Instant b(long j) {
        return Instant.ofEpochSecond(g.d(j, 1000000L, RoundingMode.FLOOR), g.a(j, DurationKt.NANOS_IN_MILLIS) * 1000);
    }

    public static void c(long j) {
        Instant.ofEpochSecond(g.d(j, 1000000000L, RoundingMode.FLOOR), g.a(j, 1000000000));
    }
}
