package com.google.android.libraries.navigation.internal.yx;

import java.util.Locale;
import java.util.concurrent.TimeUnit;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class bm {
    private final bz a;
    private boolean b;
    private long c;

    public bm() {
        this.a = bz.a;
    }

    public static bm b(bz bzVar) {
        bm bmVar = new bm(bzVar);
        bmVar.d();
        return bmVar;
    }

    private final long e() {
        if (this.b) {
            return this.a.a() - this.c;
        }
        return 0L;
    }

    public final long a(TimeUnit timeUnit) {
        return timeUnit.convert(e(), TimeUnit.NANOSECONDS);
    }

    public final void c() {
        this.b = false;
    }

    public final void d() {
        ar.l(!this.b, "This stopwatch is already running.");
        this.b = true;
        this.c = this.a.a();
    }

    public final String toString() {
        TimeUnit timeUnit;
        String str;
        long jE = e();
        if (TimeUnit.DAYS.convert(jE, TimeUnit.NANOSECONDS) > 0) {
            timeUnit = TimeUnit.DAYS;
        } else if (TimeUnit.HOURS.convert(jE, TimeUnit.NANOSECONDS) > 0) {
            timeUnit = TimeUnit.HOURS;
        } else if (TimeUnit.MINUTES.convert(jE, TimeUnit.NANOSECONDS) > 0) {
            timeUnit = TimeUnit.MINUTES;
        } else if (TimeUnit.SECONDS.convert(jE, TimeUnit.NANOSECONDS) > 0) {
            timeUnit = TimeUnit.SECONDS;
        } else if (TimeUnit.MILLISECONDS.convert(jE, TimeUnit.NANOSECONDS) > 0) {
            timeUnit = TimeUnit.MILLISECONDS;
        } else {
            timeUnit = TimeUnit.MICROSECONDS.convert(jE, TimeUnit.NANOSECONDS) > 0 ? TimeUnit.MICROSECONDS : TimeUnit.NANOSECONDS;
        }
        String str2 = String.format(Locale.ROOT, "%.4g", Double.valueOf(jE / TimeUnit.NANOSECONDS.convert(1L, timeUnit)));
        switch (bl.a[timeUnit.ordinal()]) {
            case 1:
                str = "ns";
                break;
            case 2:
                str = "μs";
                break;
            case 3:
                str = "ms";
                break;
            case 4:
                str = "s";
                break;
            case 5:
                str = "min";
                break;
            case 6:
                str = "h";
                break;
            case 7:
                str = "d";
                break;
            default:
                throw new AssertionError();
        }
        return str2 + StringUtils.SPACE + str;
    }

    public bm(bz bzVar) {
        ar.r(bzVar, "ticker");
        this.a = bzVar;
    }
}
