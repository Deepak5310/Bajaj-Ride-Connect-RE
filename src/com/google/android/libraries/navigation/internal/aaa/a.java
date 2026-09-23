package com.google.android.libraries.navigation.internal.aaa;

import j$.time.Duration;
import j$.time.temporal.ChronoUnit;
import java.math.RoundingMode;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a {
    static final Duration a;
    public static final double b;
    public static final Duration c;

    static {
        Duration durationOfSeconds = Duration.ofSeconds(Long.MIN_VALUE);
        a = durationOfSeconds;
        b = durationOfSeconds.toSeconds();
        c = Duration.ofSeconds(Long.MAX_VALUE, 999999999L);
        Duration.ofMillis(Long.MAX_VALUE);
        Duration.ofMillis(Long.MIN_VALUE);
        c(Long.MAX_VALUE);
        c(Long.MIN_VALUE);
        Duration.ofNanos(Long.MAX_VALUE);
        Duration.ofNanos(Long.MIN_VALUE);
    }

    public static double a(Duration duration) {
        return duration.getSeconds() + (((double) duration.getNano()) / 1.0E9d);
    }

    public static Duration b(double d) {
        if (d >= 9.223372036854776E18d) {
            return c;
        }
        if (d <= b) {
            return a;
        }
        long jC = com.google.android.libraries.navigation.internal.zw.b.c(d, RoundingMode.FLOOR);
        return Duration.ofSeconds(jC, com.google.android.libraries.navigation.internal.zw.b.c((d - jC) * 1.0E9d, RoundingMode.FLOOR));
    }

    public static void c(long j) {
        Duration.of(j, ChronoUnit.MICROS);
    }
}
