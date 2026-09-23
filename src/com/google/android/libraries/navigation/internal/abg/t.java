package com.google.android.libraries.navigation.internal.abg;

import android.os.SystemClock;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class t {
    private static final String a = "t";
    private static final long b = TimeUnit.MINUTES.toMillis(1);
    private static final AtomicInteger c = new AtomicInteger(0);
    private final com.google.android.libraries.navigation.internal.abf.a d;
    private final long e = SystemClock.elapsedRealtime();
    private final StringBuilder f;

    public t(List list, com.google.android.libraries.navigation.internal.abf.a aVar) {
        this.d = aVar;
        synchronized (this) {
            StringBuilder sb = new StringBuilder("DRD");
            this.f = sb;
            sb.append("(");
            sb.append(c.incrementAndGet());
            sb.append("): ");
            String str = "";
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                n nVar = (n) it2.next();
                this.f.append(str);
                str = "|";
                this.f.append(nVar.h());
            }
        }
    }

    public final synchronized void a() {
        long jElapsedRealtime = SystemClock.elapsedRealtime() - this.e;
        this.f.append(", ");
        if (jElapsedRealtime < 1000) {
            this.f.append("<1s");
            return;
        }
        StringBuilder sb = this.f;
        sb.append(jElapsedRealtime / 1000);
        sb.append("s");
    }

    public final synchronized void b(int i) {
        long jElapsedRealtime = SystemClock.elapsedRealtime() - this.e;
        if (i >= 8192) {
            int i2 = (int) jElapsedRealtime;
            if (i2 <= b) {
                int millis = (((int) TimeUnit.SECONDS.toMillis(1L)) * i) / i2;
                com.google.android.libraries.navigation.internal.abf.p.f(a, 3);
            }
        }
        this.f.append(", ");
        if (i < 1000) {
            this.f.append("<1kb");
        } else {
            StringBuilder sb = this.f;
            sb.append(i / 1000);
            sb.append("kb");
        }
        com.google.android.libraries.navigation.internal.abf.p.f(a, 3);
    }
}
